-- ���̺��� ������ Ȯ��
DESC emp;
DESC dept;

-- Projection :: ���÷����ϰ��� �ϴ� �÷��� �����ؼ� ������ �´�
SELECT * FROM emp;

-- emp ���̺��� ����� �̸�, �޿�, ����, �μ���ȣ�� �˻�
SELECT ename, sal, job, deptno FROM emp;

-- SELECTION :: ����(where��)�� �ο��ؼ� ���� ����
-- 10�� �μ����� �ٹ��ϴ� ����� �̸�, �޿�, �Ի�⵵, �μ���ȣ�� �˻�
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10;

-- 10�� �μ����� �ٹ��ϴ� ����� �̸�, �޿�, �Ի�⵵, �μ���ȣ�� �˻�
-- �̶� �޿��� ���� ���� ��� ������ ����(ORDER BY)
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal; -- �⺻ ������ ��������

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal ASC;

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal DESC;

-- SALEMAN �μ����� ����� �����ȣ, �̸�, ����, �μ���ȣ�� �˻�
-- ������ �μ���ȣ ������ �Ѵ�.
-- step1.
SELECT empno, ename, job, deptno �μ���ȣ
FROM emp
WHERE job='SALESMAN'
ORDER BY deptno;

-- step2.
SELECT empno, ename, job, deptno �μ���ȣ
FROM emp
WHERE job='SALESMAN'
ORDER BY �μ���ȣ;

-- step3.
SELECT empno, ename, job, deptno �μ���ȣ
FROM emp
WHERE job='SALESMAN'
ORDER BY 4;

-- step4.
-- WHERE���� ������ ����..20�� �μ��� ������� ���� ����
SELECT empno, ename, job, deptno �μ���ȣ
FROM emp
WHERE deptno=20
ORDER BY 4;

-- step5.
-- WHERE���� ������ ����..20�� �μ��� ������� ���� ����
SELECT empno, ename, job, deptno �μ���ȣ
FROM emp
WHERE �μ���ȣ=20
ORDER BY 4;

-- ��� �߿��� �Ի����� ���� ���� ��� ������ �˻�
SELECT ename, job, hiredate
FROM emp
ORDER BY hiredate;

-- ��� �߿��� �޿��� ���� ���� �޴� ��� ���� 3�� �˻�(rownum)
SELECT ename, job, sal
FROM emp
ORDER BY sal DESC;

-- WHERE������ ORDER BY���� ���� ����ǵ��� �ؾ��Ѵ�
-- rownum�� ORDER BY������ ���� ������ �Ǽ� ����� �߸����´�
SELECT ename, job, sal
FROM emp
WHERE rownum <= 3
ORDER BY sal DESC;

-- ���å
-- ( )�ȿ� ORDER BY���� ���� ����ǰ� WHERE���� �����ϵ��� �ۼ�
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <=3;

-- ��� ����� �޿��� ���� �޿��� 2�迡 20�޷� �߰��� �޿��� �λ�
-- Alias�� ����, Ư������, ��ҹ��ڸ� �����ؾ� �ϴ� ���.." "�� ���´�
-- step1.
SELECT ename, sal "�޿�", sal*2+20 "�λ� �޿�"
FROM emp;

-- step2.
SELECT ename, sal "�޿�", sal*2+20 "�λ� �޿�"
FROM emp
ORDER BY "�λ� �޿�";

-- step3.
SELECT ename, sal "�޿�", sal*2+20 AS IncrementSalary
FROM emp
ORDER BY 3;

-- ��� �޿����� ������ ������ ������ ������ �˻�(������ ������ 10%�� ������)
SELECT ename, sal, sal-(sal*0.1) ���������ѱ޿�1
FROM emp;

SELECT ename, sal, sal*0.9 ���������ѱ޿�1
FROM emp;

-- EMP ���̺��� ��� ����� ������ �˻�
-- �̶� ������ ���� Alias�� AnnualSalary �� ������
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp;

-- step2
-- null������ ������ ����ɶ� �ݵ�� �ٸ� ������ ġȯ�ؼ� ���
-- NVL(comm, 0) : comm�� null�̸� 0, null�� �ƴϸ� comm�� �״�� ���
SELECT ename, job, sal, sal*12+NVL(comm, 0) AnnualSalary
FROM emp;

-- step3
-- comm�� null�� �ƴ� �ÿ��� ������ ���Ѵ�...
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
WHERE comm is not null;

-- COMM�� �˻�...�������������� ����
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
ORDER BY AnnualSalary DESC;

-- EMP ���̺� �ִ� �μ�(deptno)�� �˻�
SELECT deptno FROM emp;

-- EMP ���̺� �ִ� �μ�(deptno)�� �˻�, DISTINCT(�ߺ��� ����)
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT(deptno) FROM emp;

-- 10G ���� ���ʹ� �ڵ����� �ȵȴ�
SELECT DISTINCT deptno FROM emp ORDER BY 1;

-- DISTINCT�� ����ؼ� �μ���ȣ�� �ߺ��� ���ܼ� �����;� �ϴ� ���....
-- EXISTS�� ���
SELECT deptno from dept d
WHERE EXISTS(SELECT * FROM emp e WHERE d.deptno=e.deptno);

-- Ư���� �������� �˻�...
-- LIKE ������ + ���ϵ�ī��()
-- ��� �߿��� ��� �̸��� S�� �����ϴ� ����� �˻�
SELECT ename, job
FROM emp
WHERE ename LIKE 'S%';

-- ��� �߿��� ��� �̸��� A�� ���Ե� ����� �˻�
SELECT ename, job
FROM emp
WHERE ename LIKE '%A%';

-- 80�⿡ �Ի��� ��� �˻�
SELECT ename, job, hiredate
FROM emp
WHERE hiredate LIKE '80%';

------
-- IN ������
-- ���� ���� �� �߿� ��� �ϳ��� ��ġ�ϴ����� ��
-- �����ȣ�� 7369�̰ų� 7521�̰ų� 7782���� ����� �˻�
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

-- �����ȣ�� 7369�� �ƴϰ� 7521�� �ƴϰ� 7782���� �ƴ� ����� �˻�
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

-- SUBSTR(������ ���ڿ�, ���� ������ġ)
-- SUBSTR(������ ���ڿ�, ���� ������ġ, ���ⰹ��)
-- ���ڿ��� �����ϴ� ���... �Լ����� ���ڰ��� ��Ȯ�� ����
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;
SELECT SUBSTR('HelloWorld', -4) FROM dual;
SELECT SUBSTR('HelloWorld', -4,2) FROM dual;

SELECT SUBSTR(hiredate, 1,2)
FROM emp
WHERE deptno = 10;

--��� �̸��� N���� ������ ����� �˻�
 SELECT ename
 FROM emp
 WHERE SUBSTR(ename,-1,1) = 'N';
 
SELECT ename, job FROM emp WHERE ename LIKE '%N';

-- emp���̺��� �⵵�� ����... 10�� �μ����� �˻��ǵ���
SELECT ename, hiredate, SUBSTR(hiredate,1,2) �⵵
FROM emp
WHERE deptno = 10;

SELECT ename, hiredate
FROM emp
WHERE hiredate LIKE '80%';
------

-- PAD :: LPAD, RPAD
SELECT LPAD('abc',6,'*') FROM DUAL;
SELECT RPAD('abc',6,'*') FROM DUAL;

-- ä��� ���ڸ� �������� ������ �������� ä���� -> ����(Ư�� �ݾ�)
SELECT RPAD(deptno,10) FROM emp;

-- TRIM :: RTRIM, LTRIM
SELECT RTRIM('       James Gosling        ') FROM dual;
SELECT LTRIM('       James Gosling        ') FROM dual;
SELECT TRIM('       James Gosling        ') FROM dual;
SELECT REPLACE('       James Gosling        ', ' ', '') FROM dual;

-- �����Լ�
SELECT ROUND(45.923,2) FROM dual;
SELECT ROUND(45.923,0) FROM dual;
SELECT ROUND(45.923) FROM dual;

-- FLOOR :: �Ҽ��� �Ʒ��� ����(�����θ� ǥ��, �ڸ��� ���� �ȵ�) 
SELECT FLOOR(45.923) FROM dual;
--SELECT FLOOR(45.923,2) FROM dual; -- syntax error
SELECT FLOOR(7.6) FROM dual;

-- TRUNC :: ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923, 2) FROM dual;
SELECT TRUNC(45.923) FROM dual;

-- CEIL :: �ø�. �����θ� ǥ�õ� FLOOR�� �ݴ�
SELECT CEIL(45.923) FROM dual;

-- ��¥ �Լ�
/*
��¥ + ���� = ��¥
��¥ - ���� = ��¥
��¥ - ��¥ = �Ⱓ(����)
*/

SELECT SYSDATE + 1 "Tommorow" FROM dual;
SELECT SYSDATE - 1 "Yesterday" FROM dual;
SELECT SYSDATE + 100 "�츮������100��°" FROM dual;

-- �����е��� ���ݱ��� ��ƿ� �ϻ��� �˻�...
SELECT ROUND(SYSDATE - to_date('1997/09/17')) "��ƿ� �ϻ�" FROM dual;

-- ���÷κ��� 4���� ���� ��¥�� �˻�
SELECT ADD_MONTHS(SYSDATE, 4) "After 4Month" FROM dual;

-- ���濬���� ��ƿ� ������ �˻�
SELECT ROUND(MONTHS_BETWEEN(SYSDATE,to_date('2000/12/08'))) "��ƿ� ����" FROM dual;

-- EMP ���̺��� ������� ������� �ٹ��� ��(Weeks)���� �˻�
SELECT ename, hiredate, TRUNC((SYSDATE-hiredate)/7) "Weeks"
FROM emp;
