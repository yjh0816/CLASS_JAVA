-- ������ ��������
-- CLARK�� �޿����� �� ���� �޿��� �޴� ����� �˻�
-- STEP1...sql�Ľ��� 2�� �ϴ� ��
SELECT sal FROM emp WHERE ename='CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal>2450;

-- STEP2...sql�Ľ��� 1�� �ϰ� ���̺��� 2�� ȣ���ϵ���
SELECT ename, sal FROM emp 
WHERE sal>(SELECT sal FROM emp WHERE ename='CLARK');

-- ename�� KING �� ����� ���� �μ����� ���ϴ� ����� �˻�
SELECT empno, ename, deptno FROM emp
WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING');

-- job�� ���� ���� ��ձ޿��� �˻�
SELECT job, ROUND(AVG(sal)) 
FROM emp
GROUP BY job
HAVING AVG(sal)= (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

-- �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno=20);

----------------------------

-- 3. FROM ���� ���Ǵ� ��������
-- step1...ORDER BY
SELECT ename, sal, rownum
FROM emp
WHERE rownum<=3
ORDER BY sal DESC;

-- step2...ORDER BY���� ���� ����...(ORDER BY~~~)
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;

-- �������� ������
SELECT empno, ename
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno);

-- IN���� ����
SELECT empno, ename
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

-- ANY
-- ������ SALESMAN�� �ּ� �� �� �̻��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ�϶�
SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN'
AND sal > ANY (SELECT sal FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN'
AND sal > (SELECT MIN(sal) FROM emp WHERE job='SALESMAN');

-- ALL
-- ������ SALESMAN�� ��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ�϶�
SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN'
AND sal > ALL (SELECT sal FROM emp WHERE job='SALESMAN');

-- SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻�
-- 1
SELECT ename, sal, job
FROM emp
WHERE sal> (SELECT sal FROM emp WHERE ename='SCOTT');

--2 Table alias
SELECT main.ename, main.sal, main.job
FROM emp main, (SELECT sal FROM emp WHERE ename='SCOTT') sub
WHERE main.sal > sub.sal ;

-- Correlated Subquery
-- �Ҽ� �μ��� ��� �޿����� ���� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ, �Ի���, ���� ������ ��ȸ�ϴ� SQL��
SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal > (SELECT AVG(sal) FROM emp WHERE deptno=e.deptno);

-- ����� ������ �� �ִ� ����� ��ձ޿����� �޿��� �� ���� �޴� ��������� ��ȸ
SELECT empno, ename, sal, job
FROM emp e
WHERE sal > (SELECT AVG(sal) FROM emp WHERE e.empno=mgr);

-- EXISTS
-- �Ҽ� ����� �����ϴ� �μ��� �μ���ȣ, �μ��� ��ȸ�Ѵ�
-- step1. EXISTS
SELECT deptno, dname
FROM dept d
WHERE EXISTS (SELECT 'A' FROM emp WHERE deptno=d.deptno);
-- 'A'�� �ƹ��ų� ���� ��
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

-- �м��Լ�
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
    ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) ����
FROM emp;
-- NTILE
SELECT ename, sal,
    NTILE(4) OVER(ORDER BY sal)
FROM emp;

----------------------------------------------------------------------------
-- ���̺� �����ϱ�
-- �÷� �������� PK�߰�
CREATE TABLE MYDEPT(
    no number(3) CONSTRAINT PK_MYDEPT PRIMARY KEY,
    dname varchar2(30) not null,
    loc varchar2(30));

-- ���̺� �����ϱ�
-- ���̺� �������� PK�߰�(�̰� �� ���� ���)
CREATE TABLE CUSTOM(
SSN NUMBER(7),
CUST_NAME VARCHAR2(20),
ADDRESS VARCHAR2(50),
CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN));

-- ������ �Է��ϱ�
INSERT INTO custom(ssn, cust_name, address) VALUES(111,USER,'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(222,'JAMES','NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(333,'JULIET','TEXAS');

SELECT SSN,CUST_NAME,ADDRESS FROM custom;

-- ������ �����ϱ�
UPDATE custom SET cust_name='������',address='�Ż絿' WHERE ssn=111;

-- ������ �����ϱ� !!!!
/*
DELETE
   1) ���ǿ� �ش��ϴ� �ุ ������ ����
   2) �Ϻ��� ���� �Ȱ� �ƴϴ�. rollback���� ������� �ǵ��� �� �ִ�.
TRUNCATE :: DROP + CREATE
   1) ��� �����͸� �� ����
   2) rollback �ȵȴ�.
   3) ���̺��� ������ �����.
DROP
   1) ��� �����Ͱ� �������� ���� �翬
   2) ���̺��� ������ ���ش�.
*/

DELETE custom WHERE ssn=222;
rollback;

TRUNCATE TABLE custom;
DESC custom;

DROP TABLE custom;

-- ��������
-- CTAS �̿�
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

-- �⺻Ű �������� �߰�
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

DELETE employee WHERE deptno=10;
SELECT ename, deptno FROM employee WHERE deptno=10;

DELETE department WHERE deptno=20;
SELECT ename, deptno FROM employee WHERE deptno=20;

-- �ܷ�Ű ���������� �߰�
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno);

-- FK�� �����ϴ� ���� �θ� �ڽ� ���谡 ������
-- �ڽ��� ���� �θ�� ���� �� ����
-- DEPARTMENT ���̺��� ������ ���� ����
-- 
DELETE department WHERE deptno=20;

-- ON DELETE CASCADE �ɼ��� ������
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;

DELETE department WHERE deptno=20;
SELECT * FROM department;
SELECT * FROM employee;











