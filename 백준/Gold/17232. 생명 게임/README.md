# [Gold IV] 생명 게임 - 17232 

[문제 링크](https://www.acmicpc.net/problem/17232) 

### 성능 요약

메모리: 33920 KB, 시간: 348 ms

### 분류

구현, 시뮬레이션, 누적 합

### 제출 일자

2025년 7월 19일 04:19:47

### 문제 설명

<p>생명 게임은 수학자 콘웨이(John Horton Conway)가 창안한 게임으로, 바둑판 모양의 격자에 '생명'을 배치하고 그 변화를 관찰하는 게임이다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/c7a500d6-5fad-41ff-bc83-344faf074c83/"></p>

<p style="text-align: center;"><그림1> 자리를 바꾸면서 무한히 움직이는 패턴의 한 예. 출처) 네이버 지식백과</p>

<p>준표는 콘웨이가 창안한 생명 게임에서 사소한 조건을 바꿔 새로운 규칙의 생명 게임을 제안 해보았다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/d77d7ecc-4f0f-45f0-a74d-f7cc0ddcf0c3/-/preview/" style="width: 313px; height: 300px;"></p>

<p style="text-align: center;"><그림2></p>

<p>바둑판의 각 칸은 <strong>주위</strong>의 영향을 받는데, 주위란 <그림2>에서 색칠한 영역과 같이 현재 칸을 중심으로 둔 한 변의 길이가 (2<em>K</em> + 1) 인 정사각형에서 현재 칸을 제외한 영역을 말한다.</p>

<p>바둑판의 각 칸은 주위에 몇 개의 생명이 존재하는지에 따라 다음 상황이 아래와 같이 결정된다.</p>

<ol>
	<li>생존 : 만약 현재 칸에 생명이 있고, 주위에 <em>a</em>개 이상 <em>b</em>개 이하의 생명이 있다면 현재 칸의 생명은 다음 단계에 살아남는다.</li>
	<li>고독 : 만약 현재 칸에 생명이 있고, 주위에 <em>a</em>개 미만의 생명이 있다면 현재 칸의 생명은 외로워서 죽는다.</li>
	<li>과밀 : 만약 현재 칸에 생명이 있고, 주위에 <em>b</em>개 초과의 생명이 있다면 현재 칸의 생명은 과밀로 죽는다.</li>
	<li>탄생 : 만약 현재 칸에 생명이 없고, 주위에 <em>a</em>개 초과 <em>b</em>개 이하의 생명이 있다면 다음 단계에서 현재 칸에 생명이 생긴다.</li>
</ol>

<p>생명은 바둑판을 벗어난 영역에서는 생존할 수 없다.</p>

<p>준표는 <em>N</em>×<em>M</em> 크기의 바둑판에 생명을 뿌리고, <em>T</em>시간 뒤의 생명을 관찰하고자 한다.</p>

### 입력 

 <p>첫줄에는 바둑판의 세로길이, 가로길이를 나타내는 두 정수 <em>N</em>과 <em>M</em>, 준표가 바둑판을 관찰하고자 하는 시간 <em>T</em>가 주어진다.</p>

<p>두번째 줄에는 주위의 기준이 되는 정수 <em>K</em>, 각 칸의 다음 상황을 결정하는 정수 <em>a</em>, <em>b</em>가 주어진다.</p>

<p>다음 <em>N</em>개의 줄에 걸쳐 바둑판의 처음 상태가 주어진다. 각 줄은 길이 <em>M</em>의 문자열로 생명이 있는 칸은 <code>'*'</code>, 빈칸은 <code>'.'</code>로 주어진다.</p>

### 출력 

 <p><em>N</em>개의 줄에 걸쳐 바둑판의 상태를 출력한다. 각 줄은 길이 <em>M</em>의 문자열로 생명이 있는 칸은 <code>'*'</code>, 빈칸은 <code>'.'</code>로 출력한다.</p>

