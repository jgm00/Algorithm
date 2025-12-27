# Algorithm

<details>
<summary><b>플로이드 워셜 (Floyd-Warshall)</b></summary><br>


**개념**

모든 정점 쌍 사이의 최단 거리를 구하는 알고리즘

**시간복잡도**
- 시간: O(V³)
- 공간: O(V²)

**동작방법**
1. 거리 테이블을 INF로 초기화 (자기 자신은 0)
2. 직접 연결된 간선 정보로 테이블 초기화
3. 각 정점 k를 거쳐가는 경로 고려
   - k=1일 때: 1번 정점을 거쳐가는 최단 경로 갱신
   - k=2일 때: 1,2번 정점을 거쳐가는 최단 경로 갱신
   - ...
   - k=V일 때: 모든 정점을 거쳐가는 최단 경로 갱신
4. D[i][j] = min(D[i][j], D[i][k] + D[k][j])로 갱신

**증명**

k=1일 때 중간에 다른 정점을 거치지 않았거나 1번 정점을 거쳐서 갈 때의 최단 거리를 알 수 있고, 그 다음으로 중간에 다른 정점을 거치지 않았거나 1,2번 정점을 거쳐서 갈 떄의 최단 거리를 알 수 있다는 식의 귀납법

**핵심 아이디어**
- "중간에 k번 정점을 거쳐가면 더 짧아질까?"를 모든 정점 쌍에 대해 확인
- k번 정점을 거쳐가는 것이 유리하면: i→k→j 경로로 갱신

**STANDARD 문제**
- [BOJ 11780](https://www.acmicpc.net/problem/11780): 플로이드 2 [(최단 거리 + 경로 복원)](https://github.com/jgm00/Algorithm/blob/main/백준/Gold/11780. 플로이드 2/플로이드 2.java)


**주의사항**
- 방향 그래프, 무방향 그래프, 간선 값이 음수인 그래프 모두 가능
- 음수 사이클이 있으면 제대로 작동하지 않음
- **3중 for문 순서 중요**: k(거쳐가는 정점)가 반드시 가장 바깥에 위치
- INF 값 설정: 두 INF를 더해도 오버플로우 나지 않도록 `0x3f3f3f3f` 권장
- 정점이 적을 때(V ≤ 500~1000) 사용 가능
- 상수 최적화: `dist[i][j] = min(...)`보다 `if`문으로 비교 후 대입이 더 빠름

</details>

<details>
<summary><b>다익스트라 (Dijkstra)</b></summary><br>

**개념**

하나의 시작점으로부터 다른 모든 정점까지의 최단 거리를 구하는 알고리즘

**시간복잡도**
- 시간: O(ElogV)
- 공간: O(V+E)

**동작방법**
1. 최단 거리 테이블 d를 INF로 초기화, d[시작점] = 0
2. 우선순위 큐에 (0, 시작점) 삽입
3. 우선순위 큐에서 최소 거리 정점 추출
4. 추출한 정점의 거리가 테이블 값과 다르면 skip
5. 인접한 정점들에 대해:
   - 현재 정점을 거쳐가는 거리 계산
   - 기존 거리보다 짧으면 테이블 갱신 및 우선순위 큐에 추가
6. 우선순위 큐가 빌 때까지 3-5 반복

**증명**

매 단계마다 현재까지 확정된 정점들 중 가장 가까운 정점을 선택하는 것이 최적임을 귀류법으로 증명 가능. 음수 간선이 없으므로 중간 정점을 거쳐가는 경로는 항상 더 길거나 같음.

**핵심 아이디어**
- 그리디: 매번 가장 가까운 미확정 정점의 거리를 확정
- 우선순위 큐로 최소 거리 정점을 효율적으로 추출
- 거리 검증으로 이미 처리된 정점 중복 처리 방지
- 같은 정점이 우선순위 큐에 여러 번 들어갈 수 있음

**STANDARD 문제**
- [BOJ11779](https://www.acmicpc.net/problem/11779): 최소비용 구하기 2 [(최단 거리 + 경로 복원)](https://github.com/jgm00/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Gold/11779.%E2%80%85%EC%B5%9C%EC%86%8C%EB%B9%84%EC%9A%A9%E2%80%85%EA%B5%AC%ED%95%98%EA%B8%B0%E2%80%852/%EC%B5%9C%EC%86%8C%EB%B9%84%EC%9A%A9%E2%80%85%EA%B5%AC%ED%95%98%EA%B8%B0%E2%80%852.java)

**주의사항**
- 방향 그래프 또는 무방향 그래프에서 사용 가능
- 음수 간선이 있으면 사용 불가 (음수 간선이 있는 경우 벨만-포드 알고리즘 사용)

</details>

<details>
<summary><b>프림 (Prim)</b></summary><br>


**개념**

한 정점에서 시작해 트리를 확장해나가며 최소 신장 트리(MST)를 구성하는 알고리즘

**시간복잡도**
- 시간: O(ElogE)
- 공간: O(V + E)

**동작방법**
1. 임의의 시작 정점을 선택해 MST에 포함
2. 선택된 정점과 연결된 모든 간선을 우선순위 큐에 추가
3. 우선순위 큐에서 최소 비용 간선 추출
4. 간선이 연결하는 정점이 MST에 포함되지 않았다면:
   - 해당 간선과 정점을 MST에 추가
   - 새 정점과 연결된 간선들을 우선순위 큐에 추가
5. MST에 V-1개의 간선이 포함될 때까지 3-4 반복

**증명**

매 단계마다 MST에 포함된 정점과 포함되지 않은 정점을 연결하는 최소 비용 간선을 선택하는 것이 최적임을 Cut Property로 증명 가능

**핵심 아이디어**
- 현재 MST와 연결 가능한 간선 중 가장 비용이 작은 것을 매번 선택
- 우선순위 큐로 최소 비용 간선을 효율적으로 관리
- 이미 MST에 포함된 정점으로 가는 간선은 스킵

**STANDARD 문제**
* [BOJ1197](https://www.acmicpc.net/problem/1197): 최소 스패닝 트리 [(최소 MST 가중치)](https://github.com/jgm00/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Gold/1197.%E2%80%85%EC%B5%9C%EC%86%8C%E2%80%85%EC%8A%A4%ED%8C%A8%EB%8B%9D%E2%80%85%ED%8A%B8%EB%A6%AC/%EC%B5%9C%EC%86%8C%E2%80%85%EC%8A%A4%ED%8C%A8%EB%8B%9D%E2%80%85%ED%8A%B8%EB%A6%AC.java)

</details>

<details>
<summary><b>LCS (Longest Common Subsequence)</b></summary><br>

**개념**

두 문자열에서 순서를 유지하면서 공통으로 나타나는 부분 수열 중 가장 긴 것을 찾는 알고리즘

**시간복잡도**
- 시간: O(N × M)
- 공간: O(N × M)

**동작방법**
1. 2차원 DP 테이블 생성: dp[i][j] = 문자열 A의 i번째까지, B의 j번째까지의 LCS 길이
2. 초기화: dp[0][j] = 0, dp[i][0] = 0
3. 점화식:
   - A[i] == B[j]인 경우: dp[i][j] = dp[i-1][j-1] + 1
   - A[i] != B[j]인 경우: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
4. dp[N][M]이 LCS의 길이
5. 역추적으로 실제 LCS 문자열 복원 가능

**증명**

최적 부분 구조: 두 문자열의 LCS는 마지막 문자의 일치 여부에 따라 부분 문제로 분할 가능. 동적 프로그래밍으로 중복 계산을 제거하며 최적해 도출

**핵심 아이디어**
- 문자가 같으면 이전 상태에서 +1
- 문자가 다르면 더 긴 것 선택
- 부분 문제의 최적해를 조합하여 전체 최적해 구성
- 역추적으로 실제 수열 복원 가능

**STANDARD 문제**
* [BOJ9252](https://www.acmicpc.net/problem/9252): LCS 2 [(LCS + 복원)](https://github.com/jgm00/Algorithm/tree/main/%EB%B0%B1%EC%A4%80//Gold/9252.%E2%80%85LCS%E2%80%852/LCS%E2%80%852.java)

</details>

<details>
<summary><b>LCA (Lowest Common Ancestor)</b></summary><br>

**개념**

트리에서 두 정점의 공통 조상 중 가장 가까운(깊이가 가장 깊은) 조상을 찾는 알고리즘

**시간복잡도**
- 전처리: O(N log N)
- 쿼리: O(N log N)
- 공간: O(N log N)

**동작방법**
1. 루트에서 DFS로 각 정점의 깊이(depth)와 부모 정보 저장
2. 각 정점에 대해 2^k번째 조상 정보를 sparse table로 전처리
   - `parent[node][k]` = node의 2^k번째 조상
3. LCA 쿼리 시:
   - 두 정점의 깊이를 맞춤 (깊은 쪽을 올림)
   - 두 정점이 같아질 때까지 동시에 올라감 (이진 탐색 방식)
   - 공통 조상을 만나면 해당 정점이 LCA

**증명**

Sparse table을 이용하면 임의의 k번째 조상을 k의 이진 표현을 이용해 O(log N) 시간에 찾을 수 있음. 두 정점을 동시에 올리며 처음 만나는 지점이 LCA임이 보장됨

**핵심 아이디어**
- 2의 거듭제곱 단위로 조상을 저장하여 빠른 탐색
- 깊이를 먼저 맞춘 후 이진 탐색으로 LCA 탐색
- DP를 활용한 전처리로 쿼리 최적화
- `parent[node][k] = parent[parent[node][k-1]][k-1]`

**STANDARD 문제**
- [BOJ11438](https://www.acmicpc.net/problem/11438): LCA 2 [(LCA + sparse table)](https://github.com/jgm00/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Platinum/11438.%E2%80%85LCA%E2%80%852/LCA%E2%80%852.java)

</details>

<details>
<summary><b>위상 정렬 (Topological Sort)</b></summary><br>

**개념**

방향 그래프에서 간선으로 주어진 정점 간 선후관계를 위배하지 않도록 나열하는 정렬

**시간복잡도**
- 시간: O(V+E)
- 공간: O(V+E)

**동작방법**
1. 모든 정점의 indegree(진입차수) 계산
2. indegree가 0인 정점들을 큐에 삽입
3. 큐에서 정점을 꺼내 결과에 추가
4. 해당 정점과 연결된 간선 제거 (연결된 정점의 indegree 감소)
5. indegree가 0이 된 정점을 큐에 삽입
6. 큐가 빌 때까지 3~5 반복

**증명**

indegree가 0인 정점은 자신보다 앞에 와야 할 정점이 없으므로 현재 시점에서 가장 앞에 올 수 있다. 해당 정점을 제거하면 연결된 정점들의 제약이 하나씩 사라지며, 사이클이 없는 DAG에서는 항상 indegree가 0인 정점이 존재한다는 귀납법

**핵심 아이디어**
- "이 정점보다 앞에 와야 할 정점이 있는가?"를 indegree로 판단
- indegree가 0 = 선행 조건 모두 충족 = 현재 선택 가능
- 선택한 정점은 더 이상 고려 대상이 아니므로 관련 간선 제거

**STANDARD 문제**
- [BOJ14567](https://www.acmicpc.net/problem/14567): 선수과목 (Prerequisite) [(Topological Sort)](https://github.com/jgm00/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Gold/14567.%E2%80%85%EC%84%A0%EC%88%98%EA%B3%BC%EB%AA%A9%E2%80%85%EF%BC%88Prerequisite%EF%BC%89/%EC%84%A0%EC%88%98%EA%B3%BC%EB%AA%A9%E2%80%85%EF%BC%88Prerequisite%EF%BC%89.java)


**주의사항**
- DAG(Directed Acyclic Graph)에서만 정의됨
- 사이클이 존재하면 위상 정렬 불가능
- 사이클 감지: 결과 배열의 크기가 정점 개수와 다르면 사이클 존재
- 하나의 그래프에 여러 위상 정렬 결과가 존재 가능
- visited 배열 불필요: indegree가 0이 되는 순간이 정점당 1번뿐
- 큐 대신 스택, 배열 사용 가능 (순서는 달라질 수 있음)
- DFS를 이용한 구현도 가능 (종료 시간의 역순 = 위상 정렬)

</details>
