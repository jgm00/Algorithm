# SQL 기본 문법 정리

## 📑 목차
- [1. 기본 검색 및 정렬](#1-기본-검색-및-정렬)
- [2. 그룹 제어](#2-그룹-제어)
- [3. 분기문 (CASE)](#3-분기문-case)
  - [3-1. SIMPLE_CASE_EXPRESSION](#3-1-simple_case_expression)
  - [3-2. SEARCHED_CASE_EXPRESSION](#3-2-searched_case_expression)
- [4. 집합 연산 (Set Operations)](#4-집합-연산-set-operations)
  - [4-1. UNION](#4-1-union)
  - [4-2. UNION ALL](#4-2-union-all)
- [5. 순위 집계 (Ranking Functions)](#5-순위-집계-ranking-functions)
  - [5-1. RANK](#5-1-rank)
  - [5-2. DENSE_RANK](#5-2-dense_rank)
  - [5-3. ROW_NUMBER](#5-3-row_number)
- [6. 조인 (JOIN)](#6-조인-join)
  - [6-1. INNER JOIN](#6-1-inner-join)
  - [6-2. LEFT OUTER JOIN](#6-2-left-outer-join)
  - [6-3. RIGHT OUTER JOIN](#6-3-right-outer-join)
  - [6-4. FULL OUTER JOIN](#6-4-full-outer-join)
  - [6-5. SELF JOIN](#6-5-self-join)
  - [6-6. CROSS JOIN](#6-6-cross-join)
- [7. 집계 함수 (Aggregate Functions)](#7-집계-함수-aggregate-functions)
  - [7-1. MAX](#7-1-max)
  - [7-2. MIN](#7-2-min)
  - [7-3. COUNT](#7-3-count)
  - [7-4. SUM](#7-4-sum)
  - [7-5. AVG](#7-5-avg)
- [8. 문자열 함수 (String Functions)](#8-문자열-함수-string-functions)
  - [8-1. SUBSTRING](#8-1-substringstring-start-length)
  - [8-2. LTRIM-RTRIM](#8-2-ltrimstring-rtrimstring)
  - [8-3. TRIM](#8-3-trimleadingtrailingboth-string-from-string)
  - [8-4. LPAD-RPAD](#8-4-lpadstring-n-pad_str--rpadstring-n-pad_str)
  - [8-5. REPLACE](#8-5-replacestring-pattern-replacement)
- [9. 날짜 함수 (Date Functions)](#9-날짜-함수-date-functions)
  - [9-1. NOW](#9-1-now)
  - [9-2. AGE](#9-2-age)
  - [9-3. DATE_PART](#9-3-date_part)
  - [9-4. DATE_TRUNC](#9-4-date_trunc)
- [10. 기타 함수 (Other Useful Functions)](#10-기타-함수-other-useful-functions)
  - [10-1. TO_CHAR](#10-1-to_chartimestamp-text)
  - [10-2. COALESCE](#10-2-coalescevalue-ex1-ex2)
  - [10-3. CAST](#10-3-castsource_type-as-target_type)
  - [10-4. ROUND](#10-4-roundv-numeric-s-int)


---

## 1. 기본 검색 및 정렬

```sql
SELECT [컬럼명들] 
FROM [테이블명] 
WHERE [조건들] 
ORDER BY [컬럼명들];
```

예시)
```sql
SELECT name, age 
FROM students 
WHERE age >= 20 
ORDER BY name ASC;
```

#### 예시 데이터 (students)
| id | name    | age | department | grade | score |
|----|---------|-----|------------|-------|-------|
| 1  | Alice   | 19  | CS         | 1     | 85    |
| 2  | Bob     | 22  | CS         | 3     | 92    |
| 3  | Charlie | 20  | Math       | 2     | 76    |
| 4  | David   | 23  | Math       | 4     | 88    |


#### 결과

| name    | age |
| ------- | --- |
| Bob     | 22  |
| Charlie | 20  |
| David   | 23  |

---

## 2. 그룹 제어

```sql
SELECT [GROUP BY에서 사용된 컬럼명들, 집계함수] 
FROM [테이블명] 
WHERE [조건들] 
GROUP BY [컬럼명들] 
HAVING [GROUP BY절 조건들];
```

예시)
```sql
SELECT department, AVG(score) AS avg_score
FROM students
GROUP BY department
HAVING AVG(score) >= 80;
```

#### 예시 데이터 (students)
| id | name    | age | department | grade | score |
|----|---------|-----|------------|-------|-------|
| 1  | Alice   | 19  | CS         | 1     | 85    |
| 2  | Bob     | 22  | CS         | 3     | 92    |
| 3  | Charlie | 20  | Math       | 2     | 76    |
| 4  | David   | 23  | Math       | 4     | 88    |


#### 결과

| department | avg\_score |
| ---------- | ---------- |
| CS         | 88.5       |
| Math       | 82.0       |

---

## 3. 분기문 (CASE)

### 3-1. SIMPLE\_CASE\_EXPRESSION

```sql
SELECT (CASE [컬럼명] 
           WHEN [비교값1] THEN [반환값1] 
           WHEN [비교값2] THEN [반환값2] 
           ELSE [그 외 값] 
        END) AS [별칭 컬럼명]
FROM [테이블명];
```

예시)
```sql
SELECT name, grade,
       CASE grade
            WHEN 1 THEN 'Freshman'
            WHEN 2 THEN 'Sophomore'
            WHEN 3 THEN 'Junior'
            WHEN 4 THEN 'Senior'
            ELSE 'Unknown'
       END AS grade_label
FROM students;
```

#### 예시 데이터 (students)
| id | name    | age | department | grade | score |
|----|---------|-----|------------|-------|-------|
| 1  | Alice   | 19  | CS         | 1     | 85    |
| 2  | Bob     | 22  | CS         | 3     | 92    |
| 3  | Charlie | 20  | Math       | 2     | 76    |
| 4  | David   | 23  | Math       | 4     | 88    |


#### 결과

| name    | grade | grade\_label |
| ------- | ----- | ------------ |
| Alice   | 1     | Freshman     |
| Bob     | 3     | Junior       |
| Charlie | 2     | Sophomore    |
| David   | 4     | Senior       |

---

### 3-2. SEARCHED\_CASE\_EXPRESSION

```sql
SELECT (CASE 
            WHEN [조건문1] THEN [반환값1] 
            WHEN [조건문2] THEN [반환값2] 
            ELSE [그 외 값] 
        END) AS [별칭 컬럼명]
FROM [테이블명];
```

예시)
```sql
SELECT name, score,
       CASE 
            WHEN score >= 90 THEN 'A'
            WHEN score >= 80 THEN 'B'
            WHEN score >= 70 THEN 'C'
            WHEN score >= 60 THEN 'D'
            ELSE 'F'
       END AS grade
FROM students;
```

#### 예시 데이터 (students)
| id | name    | age | department | grade | score |
|----|---------|-----|------------|-------|-------|
| 1  | Alice   | 19  | CS         | 1     | 85    |
| 2  | Bob     | 22  | CS         | 3     | 92    |
| 3  | Charlie | 20  | Math       | 2     | 76    |
| 4  | David   | 23  | Math       | 4     | 88    |


#### 결과

| name    | score | grade |
| ------- | ----- | ----- |
| Alice   | 85    | B     |
| Bob     | 92    | A     |
| Charlie | 76    | C     |
| David   | 88    | B     |

---

## 4. 집합 연산 (Set Operations)

### 4-1. UNION (중복 제거)

```sql
SELECT [컬럼1], [컬럼2] 
FROM [테이블명1]
UNION
SELECT [컬럼1], [컬럼2] 
FROM [테이블명2];
```

예시)
```sql
SELECT name, age FROM class_a
UNION
SELECT name, age FROM class_b;
```
#### 예시 데이터

**class\_a**

| name  | age |
| ----- | --- |
| Alice | 19  |
| Bob   | 22  |

**class\_b**

| name  | age |
| ----- | --- |
| Bob   | 22  |
| David | 23  |


#### 결과

| name  | age |
| ----- | --- |
| Alice | 19  |
| Bob   | 22  |
| David | 23  |

---

### 4-2. UNION ALL (중복 허용)

```sql
SELECT [컬럼1], [컬럼2] 
FROM [테이블명1]
UNION ALL
SELECT [컬럼1], [컬럼2] 
FROM [테이블명2];
```

예시)
```sql
SELECT name, age FROM class_a
UNION ALL
SELECT name, age FROM class_b;
```

#### 예시 데이터

**class\_a**

| name  | age |
| ----- | --- |
| Alice | 19  |
| Bob   | 22  |

**class\_b**

| name  | age |
| ----- | --- |
| Bob   | 22  |
| David | 23  |

#### 결과

| name  | age |
| ----- | --- |
| Alice | 19  |
| Bob   | 22  |
| Bob   | 22  |
| David | 23  |

## 5. 순위 집계 (Ranking Functions)

### 5-1. RANK

```sql
SELECT RANK() OVER(PARTITION BY[그룹할 컬럼들] ORDER BY [순위를 매길때 사용할 컬럼들]) 
FROM [테이블명1]
```

예시)
```sql
SELECT name, department, score,
       RANK() OVER(PARTITION BY department ORDER BY score DESC) AS rank
FROM students;
```

#### 예시 데이터 (students)

| id | name    | department | score |
| -- | ------- | ---------- | ----- |
| 1  | Alice   | CS         | 85    |
| 2  | Bob     | CS         | 92    |
| 3  | Charlie | CS         | 92    |
| 4  | David   | Math       | 88    |
| 5  | Erin    | Math       | 76    |

#### 결과

| name    | department | score | rank |
| ------- | ---------- | ----- | ---- |
| Bob     | CS         | 92    | 1    |
| Charlie | CS         | 92    | 1    |
| Alice   | CS         | 85    | 3    |
| David   | Math       | 88    | 1    |
| Erin    | Math       | 76    | 2    |

---

### 5-2. DENSE\_RANK

```sql
SELECT DENSE_RANK()
OVER(PARTITION BY{그룹할 컬럼들}
ORDER BY [순위를 매길때 사용할 컬럼들])
FROM [테이블명1];
```

예시)
```sql
SELECT name, department, score,
       DENSE_RANK() OVER(PARTITION BY department ORDER BY score DESC) AS dense_rank
FROM students;
```

#### 예시 데이터 (students)

| id | name    | department | score |
| -- | ------- | ---------- | ----- |
| 1  | Alice   | CS         | 85    |
| 2  | Bob     | CS         | 92    |
| 3  | Charlie | CS         | 92    |
| 4  | David   | Math       | 88    |
| 5  | Erin    | Math       | 76    |

#### 결과

| name    | department | score | dense\_rank |
| ------- | ---------- | ----- | ----------- |
| Bob     | CS         | 92    | 1           |
| Charlie | CS         | 92    | 1           |
| Alice   | CS         | 85    | 2           |
| David   | Math       | 88    | 1           |
| Erin    | Math       | 76    | 2           |

---

### 5-3. ROW\_NUMBER


```sql
SELECT ROW_NUMBER() OVER(PARTITION BY [그룹할 컬럼들] ORDER BY [순위를 매길때 사용할 컬럼들]) 
FROM [테이블명1];
```

예시)
```sql
SELECT name, department, score,
       ROW_NUMBER() OVER(PARTITION BY department ORDER BY score DESC) AS row_num
FROM students;
```

#### 예시 데이터 (students)

| id | name    | department | score |
| -- | ------- | ---------- | ----- |
| 1  | Alice   | CS         | 85    |
| 2  | Bob     | CS         | 92    |
| 3  | Charlie | CS         | 92    |
| 4  | David   | Math       | 88    |
| 5  | Erin    | Math       | 76    |

#### 결과

| name    | department | score | row\_num |
| ------- | ---------- | ----- | -------- |
| Bob     | CS         | 92    | 1        |
| Charlie | CS         | 92    | 2        |
| Alice   | CS         | 85    | 3        |
| David   | Math       | 88    | 1        |
| Erin    | Math       | 76    | 2        |

---

## 6. 조인 (JOIN)

### 6-1. INNER JOIN

```sql
SELECT *
FROM [테이블1] AS A
INNER JOIN [테이블2] AS B
ON A.KEY = B.KEY
```

예시)
```sql
SELECT A.name, B.department
FROM employees AS A
INNER JOIN departments AS B
ON A.dept_id = B.id;
```

#### 예시 데이터

**employees**

| id | name    | dept\_id |
| -- | ------- | -------- |
| 1  | Alice   | 1        |
| 2  | Bob     | 2        |
| 3  | Charlie | 1        |

**departments**

| id | department |
| -- | ---------- |
| 1  | CS         |
| 2  | Math       |
| 3  | Physics    |

#### 결과

| name    | department |
| ------- | ---------- |
| Alice   | CS         |
| Bob     | Math       |
| Charlie | CS         |

---

### 6-2. LEFT OUTER JOIN

```sql
SELECT *
FROM [테이블1] AS A
LEFT OUTer JOIN [테이블2] AS B
ON A.KEY = B.KEY
```

예시)
```sql
SELECT A.name, B.department
FROM employees AS A
LEFT OUTER JOIN departments AS B
ON A.dept_id = B.id;
```
#### 예시 데이터

**employees**

| id | name    | dept\_id |
| -- | ------- | -------- |
| 1  | Alice   | 1        |
| 2  | Bob     | 2        |
| 3  | Charlie | 1        |

**departments**

| id | department |
| -- | ---------- |
| 1  | CS         |
| 2  | Math       |
| 3  | Physics    |

#### 결과

| name    | department |
| ------- | ---------- |
| Alice   | CS         |
| Bob     | Math       |
| Charlie | CS         |

---

### 6-3. RIGHT OUTER JOIN

```sql
SELECT [컬럼1], [컬럼2] 
FROM [테이블명1]
UNION ALL
SELECT [컬럼1], [컬럼2] 
FROM [테이블명2];
```

예시)
```sql
SELECT A.name, B.department
FROM employees AS A
RIGHT OUTER JOIN departments AS B
ON A.dept_id = B.id;
```

#### 예시 데이터

**employees**

| id | name    | dept\_id |
| -- | ------- | -------- |
| 1  | Alice   | 1        |
| 2  | Bob     | 2        |
| 3  | Charlie | 1        |

**departments**

| id | department |
| -- | ---------- |
| 1  | CS         |
| 2  | Math       |
| 3  | Physics    |

#### 결과

| name    | department |
| ------- | ---------- |
| Alice   | CS         |
| Bob     | Math       |
| Charlie | CS         |
| NULL    | Physics    |

---

### 6-4. FULL OUTER JOIN

```sql
SELECT *
FROM [테이블1] AS A
FULL OUTER JOIN [테이블2] AS B
ON A.KEY = B.KEY
```

예시)
```sql
SELECT A.name, B.department
FROM employees AS A
FULL OUTER JOIN departments AS B
ON A.dept_id = B.id;
```

#### 예시 데이터

**employees**

| id | name    | dept\_id |
| -- | ------- | -------- |
| 1  | Alice   | 1        |
| 2  | Bob     | 2        |
| 3  | Charlie | 1        |

**departments**

| id | department |
| -- | ---------- |
| 1  | CS         |
| 2  | Math       |
| 3  | Physics    |

#### 결과

| name    | department |
| ------- | ---------- |
| Alice   | CS         |
| Bob     | Math       |
| Charlie | CS         |
| NULL    | Physics    |

---

### 6-5. SELF JOIN

```sql
SELECT *
FROM [테이블1] AS A
JOIN [테이블1] AS B
ON A.NAME = B.MANAGER
```

예시)
```sql
SELECT A.name AS employee, B.name AS manager
FROM employees AS A
JOIN employees AS B
ON A.manager_id = B.id;
```

#### 예시 데이터 (employees)

| id | name    | manager\_id |
| -- | ------- | ----------- |
| 1  | Alice   | 3           |
| 2  | Bob     | 3           |
| 3  | Charlie | NULL        |

#### 결과

| employee | manager |
| -------- | ------- |
| Alice    | Charlie |
| Bob      | Charlie |

---

### 6-6. CROSS JOIN

```sql
SELECT *
FROM [테이블1] AS A
CROSS JOIN [테이블2] AS B
```

예시)
```sql
SELECT A.name, B.department
FROM employees AS A
CROSS JOIN departments AS B;
```

#### 예시 데이터

**employees**

| id | name    | dept\_id |
| -- | ------- | -------- |
| 1  | Alice   | 1        |
| 2  | Bob     | 2        |
| 3  | Charlie | 1        |

**departments**

| id | department |
| -- | ---------- |
| 1  | CS         |
| 2  | Math       |
| 3  | Physics    |

#### 결과

| name    | department |
| ------- | ---------- |
| Alice   | CS         |
| Alice   | Math       |
| Alice   | Physics    |
| Bob     | CS         |
| Bob     | Math       |
| Bob     | Physics    |
| Charlie | CS         |
| Charlie | Math       |
| Charlie | Physics    |

## 7. 집계 함수 (Aggregate Functions)

### 예시 데이터 (students)
| id | name    | department | score |
|----|---------|------------|-------|
| 1  | Alice   | CS         | 85    |
| 2  | Bob     | CS         | 92    |
| 3  | Charlie | Math       | 76    |
| 4  | David   | Math       | 88    |
| 5  | Erin    | CS         | 90    |

---

### 7-1. MAX
: 명시된 컬럼 내 값들 중 **최대값**을 반환한다.

```sql
SELECT MAX(score) AS max_score
FROM students;
```

#### 결과

| max\_score |
| ---------- |
| 92         |

---

### 7-2. MIN

: 명시된 컬럼 내 값들 중 **최소값**을 반환한다.

```sql
SELECT MIN(score) AS min_score
FROM students;
```

#### 결과

| min\_score |
| ---------- |
| 76         |

---

### 7-3. COUNT

: 행의 개수(레코드 수)를 반환한다. (NULL 값은 제외)

```sql
SELECT COUNT(*) AS total_students
FROM students;
```

#### 결과

| total\_students |
| --------------- |
| 5               |

---

### 7-4. SUM

: 명시된 컬럼의 모든 값을 합산한다.
(NULL값은 제외)

```sql
SELECT SUM(score) AS total_score
FROM students;
```

#### 결과

| total\_score |
| ------------ |
| 431          |

---

### 7-5. AVG

: 명시된 컬럼의 평균값을 반환한다.
(NULL값은 제외)

```sql
SELECT AVG(score) AS avg_score
FROM students;
```

#### 결과

| avg\_score |
| ---------- |
| 86.2       |

## 8. 문자열 함수 (String Functions)

### 예시 데이터 (students)
| id | name    | department | score |
|----|---------|------------|-------|
| 1  | Alice   | CS         | 85    |
| 2  | Bob     | CS         | 92    |
| 3  | Charlie | Math       | 76    |
| 4  | David   | Math       | 88    |
| 5  | Erin    | CS         | 90    |

---

### 8-1. SUBSTRING(string, start, length)
: 문자열에서 지정한 위치(start)부터 지정한 길이(length)만큼 잘라낸다.

```sql
SELECT name, SUBSTRING(name, 1, 3) AS short_name
FROM students;
```

#### 결과

| name    | short\_name |
| ------- | ----------- |
| Alice   | Ali         |
| Bob     | Bob         |
| Charlie | Cha         |
| David   | Dav         |
| Erin    | Eri         |

---

### 8-2. LTRIM(string), RTRIM(string)

: LTRIM은 문자열 왼쪽 공백 제거, RTRIM은 문자열 오른쪽 공백 제거.

```sql
SELECT LTRIM('   Alice   ') AS left_trimmed,
       RTRIM('   Alice   ') AS right_trimmed;
```

#### 결과

| left\_trimmed | right\_trimmed |
| ------------- | -------------- |
| Alice         | Alice          |

---

### 8-3. TRIM(\[LEADING/TRAILING/BOTH] string FROM string)

: 문자열의 앞/뒤/양쪽에서 특정 문자를 제거한다. (기본값은 공백 제거)

```sql
SELECT TRIM(BOTH 'x' FROM 'xxxBobxxx') AS trimmed;
```

#### 결과

| trimmed |
| ------- |
| Bob     |

---

### 8-4. LPAD(string, n, pad\_str) / RPAD(string, n, pad\_str)

: 문자열을 지정된 길이(n)가 될 때까지 왼쪽(LPAD) 또는 오른쪽(RPAD)에 채운다.

```sql
SELECT name,
       LPAD(name, 10, '*') AS lpad_name,
       RPAD(name, 10, '-') AS rpad_name
FROM students;
```

#### 결과

| name    | lpad\_name        | rpad\_name |
| ------- | ----------------- | ---------- |
| Alice   | \*\*\*\*\*Alice   | Alice----- |
| Bob     | \*\*\*\*\*\*\*Bob | Bob------- |
| Charlie | \*\*\*Charlie     | Charlie--  |
| David   | \*\*\*\*\*David   | David----- |
| Erin    | \*\*\*\*\*\*Erin  | Erin------ |

---

### 8-5. REPLACE(string, pattern, replacement)

: 문자열에서 특정 패턴(pattern)을 다른 문자열(replacement)로 치환한다.

```sql
SELECT name,
       REPLACE(name, 'a', '@') AS replaced_name
FROM students;
```

#### 결과

| name    | replaced\_name          |
| ------- | ----------------------- |
| Alice   | Alice (대소문자 구분, 'a' 없음) |
| Bob     | Bob                     |
| Charlie | Ch\@rlie                |
| David   | D\@vid                  |
| Erin    | Erin                    |

---

## 9. 날짜 함수 (Date Functions)

### 예시: 기준 현재 날짜  
가정: NOW() = '2025-09-13 12:34:56'

---

### 9-1. NOW()
: 현재의 날짜 및 시간을 출력한다.

```sql
SELECT NOW() AS current_datetime;
```

#### 결과

| current\_datetime   |
| ------------------- |
| 2025-09-13 12:34:56 |

---

### 9-2. AGE(timestamp, timestamp) / AGE(timestamp)

: 두 날짜 사이의 차이를 반환한다.

* AGE(date1, date2) → date1 - date2
* AGE(date) → NOW() - date

```sql
SELECT AGE(DATE '2000-01-01') AS age_from_2000;

SELECT AGE(DATE '2025-12-31', DATE '2025-01-01') AS diff;
```

#### 결과

| age\_from\_2000         | diff                    |
| ----------------------- | ----------------------- |
| 25 years 8 mons 12 days | 0 years 11 mons 30 days |

---

### 9-3. DATE\_PART(text, timestamp)

: 특정 시간 단위를 추출한다.

```sql
SELECT DATE_PART('year', NOW())  AS current_year,
       DATE_PART('month', NOW()) AS current_month,
       DATE_PART('day', NOW())   AS current_day,
       DATE_PART('hour', NOW())  AS current_hour;
```

#### 결과

| current\_year | current\_month | current\_day | current\_hour |
| ------------- | -------------- | ------------ | ------------- |
| 2025          | 9              | 13           | 12            |

---

### 9-4. DATE\_TRUNC(text, timestamp)

: 지정된 단위 이하를 0으로 초기화한다 (즉, 잘라낸다).

```sql
SELECT DATE_TRUNC('year', NOW())  AS year_start,
       DATE_TRUNC('month', NOW()) AS month_start,
       DATE_TRUNC('day', NOW())   AS day_start;
```

#### 결과

| year\_start         | month\_start        | day\_start          |
| ------------------- | ------------------- | ------------------- |
| 2025-01-01 00:00:00 | 2025-09-01 00:00:00 | 2025-09-13 00:00:00 |

---

## 10. 기타 함수 (Other Useful Functions)

### 예시 데이터 (students)
| id | name    | department | score | enrolled_at          |
|----|---------|------------|-------|----------------------|
| 1  | Alice   | CS         | 85    | 2025-09-13 12:34:56 |
| 2  | Bob     | CS         | NULL  | 2025-09-10 09:15:00 |
| 3  | Charlie | Math       | 76    | 2025-08-01 18:00:00 |

---

### 10-1. TO_CHAR(timestamp, text)
: 날짜/숫자를 문자열로 변환하며, 포맷을 지정할 수 있다. (PostgreSQL 기준)

```sql
SELECT name,
       TO_CHAR(enrolled_at, 'YYYY-MM-DD') AS enroll_date,
       TO_CHAR(enrolled_at, 'HH24:MI:SS') AS enroll_time
FROM students;
```

#### 결과

| name    | enroll\_date | enroll\_time |
| ------- | ------------ | ------------ |
| Alice   | 2025-09-13   | 12:34:56     |
| Bob     | 2025-09-10   | 09:15:00     |
| Charlie | 2025-08-01   | 18:00:00     |

---

### 10-2. COALESCE(value, ex1, ex2)

: 첫 번째 **NULL이 아닌 값**을 반환한다.

```sql
SELECT name,
       COALESCE(score, 0) AS safe_score
FROM students;
```

#### 결과

| name    | safe\_score |
| ------- | ----------- |
| Alice   | 85          |
| Bob     | 0           |
| Charlie | 76          |

---

### 10-3. CAST(source\_type AS target\_type)

: 데이터 타입을 변환한다.

```sql
SELECT name,
       CAST(score AS VARCHAR) AS score_text
FROM students;
```

#### 결과

| name    | score\_text |
| ------- | ----------- |
| Alice   | 85          |
| Bob     | NULL        |
| Charlie | 76          |

---

### 10-4. ROUND(v numeric, s int)

: 숫자를 반올림한다. s는 소수점 자리수.

```sql
SELECT score,
       ROUND(score::NUMERIC, 1) AS rounded_1,
       ROUND(score::NUMERIC, 0) AS rounded_0
FROM students;
```

#### 결과

| score | rounded\_1 | rounded\_0 |
| ----- | ---------- | ---------- |
| 85    | 85.0       | 85         |
| NULL  | NULL       | NULL       |
| 76    | 76.0       | 76         |

---