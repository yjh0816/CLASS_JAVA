-- 단일행 서브쿼리
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색
-- STEP1...sql파싱을 2번 하는 꼴
SELECT sal FROM emp WHERE ename='CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal>2450;

-- STEP2...sql파싱을 1번 하고 테이블을 2번 호출하도록
SELECT ename, sal FROM emp 
WHERE sal>(SELECT sal FROM emp WHERE ename='CLARK');

-- ename이 KING 인 사원과 같은 부서에서 일하는 사원을 검색
SELECT empno, ename, deptno FROM emp
WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING');

-- job별 가장 작은 평균급여를 검색
SELECT job, ROUND(AVG(sal)) 
FROM emp
GROUP BY job
HAVING AVG(sal)= (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

-- 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno=20);

----------------------------

-- 3. FROM 절에 사용되는 서브쿼리
-- step1...ORDER BY
SELECT ename, sal, rownum
FROM emp
WHERE rownum<=3
ORDER BY sal DESC;

-- step2...ORDER BY절을 먼저 실행...(ORDER BY~~~)
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;

-- 다중행을 넣으면
SELECT empno, ename
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno);

-- IN으로 수정
SELECT empno, ename
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

-- ANY
-- 업무가 SALESMAN인 최소 한 명 이상의 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회하라
SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN'
AND sal > ANY (SELECT sal FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN'
AND sal > (SELECT MIN(sal) FROM emp WHERE job='SALESMAN');

-- ALL
-- 업무가 SALESMAN인 모든 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회하라
SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN'
AND sal > ALL (SELECT sal FROM emp WHERE job='SALESMAN');

-- SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색
-- 1
SELECT ename, sal, job
FROM emp
WHERE sal> (SELECT sal FROM emp WHERE ename='SCOTT');

--2 Table alias
SELECT main.ename, main.sal, main.job
FROM emp main, (SELECT sal FROM emp WHERE ename='SCOTT') sub
WHERE main.sal > sub.sal ;

-- Correlated Subquery
-- 소속 부서의 평균 급여보다 많은 급여를 받는 사원의 이름, 급여, 부서번호, 입사일, 업무 정보를 조회하는 SQL문
SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal > (SELECT AVG(sal) FROM emp WHERE deptno=e.deptno);

-- 사원을 관리할 수 있는 사람의 평균급여보다 급여를 더 많이 받는 사원정보를 조회
SELECT empno, ename, sal, job
FROM emp e
WHERE sal > (SELECT AVG(sal) FROM emp WHERE e.empno=mgr);

-- EXISTS
-- 소속 사원이 존재하는 부서의 부서번호, 부서명 조회한다
-- step1. EXISTS
SELECT deptno, dname
FROM dept d
WHERE EXISTS (SELECT 'A' FROM emp WHERE deptno=d.deptno);
-- 'A'에 아무거나 들어가도 됨
SELECT deptno, dname
FROM dept d
WHERE EXISTS (SELECT 1 FROM emp WHERE deptno=d.deptno);

-- step2. DISTINCT
SELECT DISTINCT d.deptno, d.dname
FROM dept d, emp e
WHERE e.deptno=d.deptno;

-- step3. IN
SELECT deptno, dname
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE job='MANAGER');

-- 분석함수
SELECT ename, sal, deptno,
    RANK() OVER(ORDER BY sal DESC) ALL_RANKING,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) DEPT_RANKING
FROM emp;

SELECT ename, sal, rownum FROM emp ORDER BY sal DESC;

SELECT ename, sal, rownum 
FROM (SELECT * FROM emp ORDER BY sal DESC);

SELECT ename, sal, 
    ROW_NUMBER() OVER(ORDER BY sal DESC) RANKING
FROM emp
WHERE ROWNUM<=3;

-- RANK
SELECT empno, ename, deptno, sal,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;
-- DENSE_RANK
SELECT empno, ename, deptno, sal,
    DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;
-- ROW_NUMBER
SELECT empno, ename, sal, hiredate,
    ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) 순번
FROM emp;
-- NTILE
SELECT ename, sal,
    NTILE(4) OVER(ORDER BY sal)
FROM emp;

----------------------------------------------------------------------------
-- 테이블 생성하기
-- 컬럼 레벨에서 PK추가
CREATE TABLE MYDEPT(
    no number(3) CONSTRAINT PK_MYDEPT PRIMARY KEY,
    dname varchar2(30) not null,
    loc varchar2(30));

-- 테이블 생성하기
-- 테이블 레벨에서 PK추가(이걸 더 많이 사용)
CREATE TABLE CUSTOM(
SSN NUMBER(7),
CUST_NAME VARCHAR2(20),
ADDRESS VARCHAR2(50),
CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN));

-- 데이터 입력하기
INSERT INTO custom(ssn, cust_name, address) VALUES(111,USER,'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(222,'JAMES','NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(333,'JULIET','TEXAS');

SELECT SSN,CUST_NAME,ADDRESS FROM custom;

-- 데이터 수정하기
UPDATE custom SET cust_name='이정재',address='신사동' WHERE ssn=111;

-- 데이터 삭제하기 !!!!
/*
DELETE
   1) 조건에 해당하는 행만 삭제를 진행
   2) 완벽히 삭제 된건 아니다. rollback으로 원래대로 되돌릴 수 있다.
TRUNCATE :: DROP + CREATE
   1) 모든 데이터를 다 삭제
   2) rollback 안된다.
   3) 테이블의 구조는 남긴다.
DROP
   1) 모든 데이터가 없어지는 것은 당연
   2) 테이블의 구조도 없앤다.
*/

DELETE custom WHERE ssn=222;
rollback;

TRUNCATE TABLE custom;
DESC custom;

DROP TABLE custom;

-- 제약조건
-- CTAS 이용
DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee
AS
SELECT * FROM emp;

CREATE TABLE department
AS
SELECT * FROM dept;

SELECT * FROM employee;
SELECT * FROM dept;
DESC emp;
DESC employee;
DESC dept;
DESC department;

-- 기본키 제약조건 추가
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

DELETE employee WHERE deptno=10;
SELECT ename, deptno FROM employee WHERE deptno=10;

DELETE department WHERE deptno=20;
SELECT ename, deptno FROM employee WHERE deptno=20;

-- 외래키 제약조건을 추가
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno);

-- FK를 설정하는 순간 부모 자식 관계가 형성됨
-- 자식을 가진 부모는 죽일 수 없다
-- DEPARTMENT 테이블의 데이터 삭제 못함
-- 
DELETE department WHERE deptno=20;

-- ON DELETE CASCADE 옵션을 지정함
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;

DELETE department WHERE deptno=20;
SELECT * FROM department;
SELECT * FROM employee;











