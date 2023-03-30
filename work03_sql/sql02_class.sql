-- Extract(년,월,일,시간,초 추출할때 사용)
-- emp 테이블에서 사원의 이름과 입사한 년, 월, 일을 추출...부서번호가 20번인 사원
-- Year, Month, Day
SELECT ename, hiredate,
EXTRACT(YEAR FROM hiredate) Year,
EXTRACT(MONTH FROM hiredate) Month, 
EXTRACT(DAY FROM hiredate) Day
FROM emp
WHERE deptno=20;

SELECT ename, hiredate,
SUBSTR(hiredate,1,2) Year, SUBSTR(hiredate,4,2) Month, SUBSTR(hiredate,7,2) Day
FROM emp
WHERE deptno=20;

-- KB IT's Your Life 시작 이후 첫번째 토요일
SELECT NEXT_DAY(to_date('23/03/02'),7)
FROM dual;

-- EMP 테이블에서 10번 부서원의 입사 일자로부터 돌아오는 금요일, 토요일을 계산하라
SELECT ename, hiredate, NEXT_DAY(hiredate,6) N_6, NEXT_DAY(hiredate,7) N_7
FROM emp
WHERE deptno=10
ORDER BY hiredate DESC;

SELECT empno, ename, hiredate, LAST_DAY(hiredate)-hiredate 근무일수
FROM emp
ORDER BY 근무일수 DESC;

-- EMP 테이블에서 20번 부서 중 급여를 3자리마다 ,를 출력하라
SELECT empno, ename, job, sal, TO_CHAR(sal,'999,999') 
FROM emp
ORDER BY sal;

CREATE TABLE test(num number);
DESC test;
INSERT INTO test VALUES(20003050);
SELECT num FROM test;
SELECT TO_CHAR(num,'999,999,999') FROM test;
--SELECT TO_CHAR(num,'999,999') FROM test;

-- EMP 테이블에서 20번 부서 중 입사 일자를 1998년 1월 1일의 형태로 출력하라

-- 업무가 PRESIDENT면 사장, MANAGER면 관리자, ANALYST면 분석가, 직원, 직원분류 Alias
SELECT ename, job, 
        DECODE(job, 'PRESIDENT', '사장', 
                    'MANAGER', '관리자', 
                    'ANALYST', '분석가', 
                    '직원') 직원분류
FROM emp;

SELECT ename, deptno, 
        CASE WHEN deptno=10 THEN 'NewYork' 
             WHEN deptno=20 THEN 'Dallas' 
             WHEN deptno=30 THEN 'Boston' 
             ELSE 'city'
        END 도시명
FROM emp;

/*
그룹함수는 null값을 건너뛴다
여기에서 제외되는 그룹함수가 COUNT(*)
*/
SELECT * FROM emp;
-- 전체 사원의 수를 리턴...
SELECT COUNT(*) FROM emp;
SELECT COUNT(empno) FROM emp; --pk, this is better
SELECT COUNT(-1) FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;
-- 입사한지 가장 오래된 사원의 입사일?
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

-- 부서번호가 10번이거나 20번인 사원수 조회..COUNT()
SELECT COUNT(empno) FROM emp WHERE deptno IN(10,20);

-- 모든 사원의 보너스 평균...AVG
-- step1.
-- null값이 있는 경우...그룹 함수 사용시 주의!! 4로만 나눈다.
--SELECT ROUND(AVG(comm)) FROM emp; -- x
-- step2.
SELECT ROUND(AVG(NVL(comm,0))) FROM emp;

-- emp 테이블에서 부서 갯수
SELECT COUNT(DISTINCT deptno) 부서갯수 FROM emp;

---------------------------------------------------------
/*
그룹함수에 적용되지 않은 컬럼이(deptno)
SELECT절에 나열....
반드시 GROUP BY절 뒤에 deptno컬럼을 명시해야 한다
*/
SELECT deptno, ROUND(AVG(sal))
FROM emp 
GROUP BY deptno;

-- step2.
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp 
GROUP BY deptno
ORDER BY DNumber;

-- step3.
-- 알리아스 적용이 안되는 구절...1)where 2)group by
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp 
GROUP BY DNumber
ORDER BY DNumber; -- 에러!!, MySQL은 됨(strict하지 않음)

-- step4.
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp 
WHERE deptno != 10
GROUP BY deptno
ORDER BY DNumber;

-- 입사년도별 사원의 인원수 조회...count()
SELECT EXTRACT( YEAR FROM hiredate) Year FROM emp;
SELECT EXTRACT( YEAR FROM hiredate) Year, COUNT(empno)
FROM emp
GROUP BY EXTRACT( YEAR FROM hiredate)
ORDER BY Year;

-- 2
SELECT TO_CHAR(hiredate, 'YYYY') 년도, COUNT(*)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YYYY')
ORDER BY 1;

-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 조회
-- 그룹함수는 WHERE절이 아닌 HAVING절에서 사용해야 한다
-- step1.
SELECT deptno, ROUND(AVG(sal)) 평균급여
FROM emp
HAVING ROUND(AVG(sal))>=2000
GROUP BY deptno;

-- step2.
-- 의미론적으로 그룹핑을 하고 > 그리고 나서 그중에서 조건에 맞는것만 추출해서 출력
SELECT deptno, ROUND(AVG(sal)) 평균급여
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal))>=2000;

-- 부서별 최대급여가 2900달러가 넘는 부서들의 최대급여를 출력
--SELECT deptno, MAX(sal) 최대급여
--FROM emp
--GROUP BY deptno
--HAVING MAX(sal)>2900;

-- 부서별 평균급여가 최대급여인 부서의 급여를 검색
--SELECT deptno, AVG(sal)
--FROM emp
--GROUP BY deptno;
--HAVING MAX(AVG(sal));

-- 부서별 인원수, 급여합 조회시 ROLLUP을 사용해 총 집계를 조회한다
SELECT deptno, COUNT(*), SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno;

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(job, deptno)
ORDER BY job;

-- GROUPING SETS
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job)
ORDER BY 1;

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(job, deptno)
ORDER BY 1;

-- UNION ALL 보다 GROUPING SET가 성능이 훨씬 낫다
SELECT deptno, NULL job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal)
FROM emp
GROUP BY job
ORDER BY 1;

/*
조인
하나 이상(Self Join)의 테이블에서 질의를 던지는 경우
일반적인 경우 FK에 의해서 조인 조건이 성립된다.
Equi Join, Self Join, Outer Join을 주요하게 살펴보자
*/
SELECT empno, ename, sal, job FROM emp; -- 해당 사원의 정보를 알고 싶을때
SELECT deptno, dname, loc FROM dept; -- 해당 부서의 정보를 알고 싶을때
SELECT * FROM emp, dept;
/*
Cartesian Product
::
emp, dept 테이블이 수평적으로 결합
14  X  4 = 56

1) 조인조건을 생략했을때
2) 조인조건을 잘못줬을떄
*/

-- STEP1.
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- STEP2. 테이블 Alias
SELECT * FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP3. Projection
SELECT empno, ename, sal, deptno, dname, loc FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP4. Projection...컬럼마다 테이블 별칭을 다 준다
SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP5. Equi Join AND Join조건
SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE 
e.deptno = d.deptno
AND
d.deptno=10;

/*
Self Join
::
하나의 테이블을 자체적으로 조인함
*/
-- 특정 사원의 상사의 이름을 조회
/*
1. emp테이블에서 먼저 특정한 사원의 ename을 조회
2. ename에 해당하는 mgr번호를 찾는다
----------------------------------
3. 다시 emp테이블에서 empno가 mgr인 사원을 찾아서 ename을 찾는다
*/

-- STEP1.
SELECT ename, mgr FROM emp; -- BLAKE 사원의 상사번호를 찾고
SELECT empno, ename FROM emp; -- 상사번호와 일치하는 사원번호를 찾고 그에 해당하는 사원 이름을 찾는다.

-- STEP2.
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m;

-- STEP3. 조인 조건 추가
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- STEP4. 조인 조건 추가
SELECT e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno;

-- STEP5. 조인 조건 추가
SELECT e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno
AND
e.ename='BLAKE';

-- Outer Join
SELECT * FROM dept;

-- STEP1.
SELECT e.empno, e.ename, e.job, e.deptno e_deptno,
        d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno;

-- STEP2.
SELECT e.empno, e.ename, e.job, e.deptno e_deptno,
        d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+); -- Right Outer Join

SELECT e.empno, e.ename, e.job, e.deptno e_deptno,
        d.deptno d_deptno, d.dname
FROM emp e Right join dept d
ON d.deptno = e.deptno;

-- Left Outer Join
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno
AND e.sal>2000;

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno
AND e.sal(+)>2000;





