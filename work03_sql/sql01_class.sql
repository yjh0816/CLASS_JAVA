-- 테이블의 구조를 확인
DESC emp;
DESC dept;

-- Projection :: 디스플레이하고자 하는 컬럼을 지정해서 가지고 온다
SELECT * FROM emp;

-- emp 테이블에서 사원의 이름, 급여, 업무, 부서번호를 검색
SELECT ename, sal, job, deptno FROM emp;

-- SELECTION :: 조건(where절)을 부여해서 행을 제한
-- 10번 부서에서 근무하는 사원의 이름, 급여, 입사년도, 부서번호를 검색
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10;

-- 10번 부서에서 근무하는 사원의 이름, 급여, 입사년도, 부서번호를 검색
-- 이때 급여를 많이 받은 사원 순으로 정렬(ORDER BY)
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal; -- 기본 정렬은 오름차순

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal ASC;

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal DESC;

-- SALEMAN 부서에서 사원의 사원번호, 이름, 업무, 부서번호를 검색
-- 정렬은 부서번호 순으로 한다.
-- step1.
SELECT empno, ename, job, deptno 부서번호
FROM emp
WHERE job='SALESMAN'
ORDER BY deptno;

-- step2.
SELECT empno, ename, job, deptno 부서번호
FROM emp
WHERE job='SALESMAN'
ORDER BY 부서번호;

-- step3.
SELECT empno, ename, job, deptno 부서번호
FROM emp
WHERE job='SALESMAN'
ORDER BY 4;

-- step4.
-- WHERE절의 조건을 변경..20번 부서의 사원으로 행을 제한
SELECT empno, ename, job, deptno 부서번호
FROM emp
WHERE deptno=20
ORDER BY 4;

-- step5.
-- WHERE절의 조건을 변경..20번 부서의 사원으로 행을 제한
SELECT empno, ename, job, deptno 부서번호
FROM emp
WHERE 부서번호=20
ORDER BY 4;

-- 사원 중에서 입사일이 가장 빠른 사원 순으로 검색
SELECT ename, job, hiredate
FROM emp
ORDER BY hiredate;

-- 사원 중에서 급여를 가장 많이 받는 사원 상위 3명만 검색(rownum)
SELECT ename, job, sal
FROM emp
ORDER BY sal DESC;

-- WHERE절보다 ORDER BY절이 먼저 실행되도록 해야한다
-- rownum이 ORDER BY절보다 먼저 실행이 되서 결과가 잘못나온다
SELECT ename, job, sal
FROM emp
WHERE rownum <= 3
ORDER BY sal DESC;

-- 대안책
-- ( )안에 ORDER BY절이 먼저 실행되고 WHERE절이 동작하도록 작성
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <=3;

-- 모든 사원의 급여를 기존 급여의 2배에 20달러 추가한 급여로 인상
-- Alias에 공백, 특수문자, 대소문자를 구분해야 하는 경우.." "로 묶는다
-- step1.
SELECT ename, sal "급여", sal*2+20 "인상 급여"
FROM emp;

-- step2.
SELECT ename, sal "급여", sal*2+20 "인상 급여"
FROM emp
ORDER BY "인상 급여";

-- step3.
SELECT ename, sal "급여", sal*2+20 AS IncrementSalary
FROM emp
ORDER BY 3;

-- 사원 급여에서 세금을 제외한 수령한 월급을 검색(세금을 월급의 10%라 간주함)
SELECT ename, sal, sal-(sal*0.1) 실제수령한급여1
FROM emp;

SELECT ename, sal, sal*0.9 실제수령한급여1
FROM emp;

-- EMP 테이블에서 모든 사원의 연봉을 검색
-- 이때 연봉에 대한 Alias를 AnnualSalary 로 지정함
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp;

-- step2
-- null값으로 연산이 진행될때 반드시 다른 값으로 치환해서 사용
-- NVL(comm, 0) : comm이 null이면 0, null이 아니면 comm을 그대로 사용
SELECT ename, job, sal, sal*12+NVL(comm, 0) AnnualSalary
FROM emp;

-- step3
-- comm이 null이 아닌 시원의 연봉을 구한다...
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
WHERE comm is not null;

-- COMM을 검색...내림차원순으로 정렬
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
ORDER BY AnnualSalary DESC;

-- EMP 테이블에 있는 부서(deptno)를 검색
SELECT deptno FROM emp;

-- EMP 테이블에 있는 부서(deptno)를 검색, DISTINCT(중복을 벗김)
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT(deptno) FROM emp;

-- 10G 이후 부터는 자동정렬 안된다
SELECT DISTINCT deptno FROM emp ORDER BY 1;

-- DISTINCT를 사용해서 부서번호를 중복을 벗겨서 가져와야 하는 경우....
-- EXISTS를 사용
SELECT deptno from dept d
WHERE EXISTS(SELECT * FROM emp e WHERE d.deptno=e.deptno);

-- 특정한 패턴으로 검색...
-- LIKE 연산자 + 와일드카드()
-- 사원 중에서 사원 이름이 S로 시작하는 사원을 검색
SELECT ename, job
FROM emp
WHERE ename LIKE 'S%';

-- 사원 중에서 사원 이름에 A가 포함된 사원을 검색
SELECT ename, job
FROM emp
WHERE ename LIKE '%A%';

-- 80년에 입사한 사원 검색
SELECT ename, job, hiredate
FROM emp
WHERE hiredate LIKE '80%';

------
-- IN 연산자
-- 여러 개의 값 중에 어느 하나와 일치하는지를 비교
-- 사원번호가 7369이거나 7521이거나 7782번인 사원을 검색
--STEP1. 
SELECT empno, ename, job FROM emp WHERE empno = 7369;
SELECT empno, ename, job FROM emp WHERE empno = 7521;
SELECT empno, ename, job FROM emp WHERE empno = 7782;

--STEP2.
SELECT empno, ename, job 
FROM emp 
WHERE empno = 7369 or empno = 7521 or empno = 7782;

--STEP3.
SELECT empno, ename, job 
FROM emp 
WHERE empno IN (7369,7521,7782);

-- 사원번호가 7369도 아니고 7521도 아니고 7782번도 아닌 사원을 검색
SELECT empno, ename, job
FROM emp
WHERE empno != 7369 AND empno != 7521 AND empno != 7782;

-- STEP.2
SELECT empno, ename, job 
FROM emp
WHERE empno != 7369 AND empno <> 7521 AND empno != 7782;

-- STEP3.
SELECT empno, ename, job 
FROM emp 
WHERE empno NOT IN (7369,7521,7782);

-- SUBSTR(추출할 문자열, 추출 시작위치)
-- SUBSTR(추출할 문자열, 추출 시작위치, 추출갯수)
-- 문자열을 추출하는 기능... 함수안의 인자값을 정확히 이해
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;
SELECT SUBSTR('HelloWorld', -4) FROM dual;
SELECT SUBSTR('HelloWorld', -4,2) FROM dual;

SELECT SUBSTR(hiredate, 1,2)
FROM emp
WHERE deptno = 10;

--사원 이름이 N으로 끝나는 사원을 검색
 SELECT ename
 FROM emp
 WHERE SUBSTR(ename,-1,1) = 'N';
 
SELECT ename, job FROM emp WHERE ename LIKE '%N';

-- emp테이블에서 년도만 추출... 10번 부서에서 검색되도록
SELECT ename, hiredate, SUBSTR(hiredate,1,2) 년도
FROM emp
WHERE deptno = 10;

SELECT ename, hiredate
FROM emp
WHERE hiredate LIKE '80%';
------

-- PAD :: LPAD, RPAD
SELECT LPAD('abc',6,'*') FROM DUAL;
SELECT RPAD('abc',6,'*') FROM DUAL;

-- 채우는 문자를 지정하지 않으면 공백으로 채워짐 -> 숫자(특히 금액)
SELECT RPAD(deptno,10) FROM emp;

-- TRIM :: RTRIM, LTRIM
SELECT RTRIM('       James Gosling        ') FROM dual;
SELECT LTRIM('       James Gosling        ') FROM dual;
SELECT TRIM('       James Gosling        ') FROM dual;
SELECT REPLACE('       James Gosling        ', ' ', '') FROM dual;

-- 숫자함수
SELECT ROUND(45.923,2) FROM dual;
SELECT ROUND(45.923,0) FROM dual;
SELECT ROUND(45.923) FROM dual;

-- FLOOR :: 소숫점 아래를 버림(정수로만 표시, 자릿수 지정 안됨) 
SELECT FLOOR(45.923) FROM dual;
--SELECT FLOOR(45.923,2) FROM dual; -- syntax error
SELECT FLOOR(7.6) FROM dual;

-- TRUNC :: 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923, 2) FROM dual;
SELECT TRUNC(45.923) FROM dual;

-- CEIL :: 올림. 정수로만 표시됨 FLOOR의 반대
SELECT CEIL(45.923) FROM dual;

-- 날짜 함수
/*
날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
날짜 - 날짜 = 기간(숫자)
*/

SELECT SYSDATE + 1 "Tommorow" FROM dual;
SELECT SYSDATE - 1 "Yesterday" FROM dual;
SELECT SYSDATE + 100 "우리만난지100일째" FROM dual;

-- 여러분들이 지금까지 살아온 일생을 검색...
SELECT ROUND(SYSDATE - to_date('1997/09/17')) "살아온 일생" FROM dual;

-- 오늘로부터 4개월 후의 날짜를 검색
SELECT ADD_MONTHS(SYSDATE, 4) "After 4Month" FROM dual;

-- 정길연님의 살아온 월수를 검색
SELECT ROUND(MONTHS_BETWEEN(SYSDATE,to_date('2000/12/08'))) "살아온 월수" FROM dual;

-- EMP 테이블에서 사원들이 현재까지 근무한 주(Weeks)수를 검색
SELECT ename, hiredate, TRUNC((SYSDATE-hiredate)/7) "Weeks"
FROM emp;
