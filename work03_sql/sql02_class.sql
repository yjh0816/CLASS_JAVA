-- Extract(��,��,��,�ð�,�� �����Ҷ� ���)
-- emp ���̺��� ����� �̸��� �Ի��� ��, ��, ���� ����...�μ���ȣ�� 20���� ���
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

-- KB IT's Your Life ���� ���� ù��° �����
SELECT NEXT_DAY(to_date('23/03/02'),7)
FROM dual;

-- EMP ���̺��� 10�� �μ����� �Ի� ���ڷκ��� ���ƿ��� �ݿ���, ������� ����϶�
SELECT ename, hiredate, NEXT_DAY(hiredate,6) N_6, NEXT_DAY(hiredate,7) N_7
FROM emp
WHERE deptno=10
ORDER BY hiredate DESC;

SELECT empno, ename, hiredate, LAST_DAY(hiredate)-hiredate �ٹ��ϼ�
FROM emp
ORDER BY �ٹ��ϼ� DESC;

-- EMP ���̺��� 20�� �μ� �� �޿��� 3�ڸ����� ,�� ����϶�
SELECT empno, ename, job, sal, TO_CHAR(sal,'999,999') 
FROM emp
ORDER BY sal;

CREATE TABLE test(num number);
DESC test;
INSERT INTO test VALUES(20003050);
SELECT num FROM test;
SELECT TO_CHAR(num,'999,999,999') FROM test;
--SELECT TO_CHAR(num,'999,999') FROM test;

-- EMP ���̺��� 20�� �μ� �� �Ի� ���ڸ� 1998�� 1�� 1���� ���·� ����϶�

-- ������ PRESIDENT�� ����, MANAGER�� ������, ANALYST�� �м���, ����, �����з� Alias
SELECT ename, job, 
        DECODE(job, 'PRESIDENT', '����', 
                    'MANAGER', '������', 
                    'ANALYST', '�м���', 
                    '����') �����з�
FROM emp;

SELECT ename, deptno, 
        CASE WHEN deptno=10 THEN 'NewYork' 
             WHEN deptno=20 THEN 'Dallas' 
             WHEN deptno=30 THEN 'Boston' 
             ELSE 'city'
        END ���ø�
FROM emp;

/*
�׷��Լ��� null���� �ǳʶڴ�
���⿡�� ���ܵǴ� �׷��Լ��� COUNT(*)
*/
SELECT * FROM emp;
-- ��ü ����� ���� ����...
SELECT COUNT(*) FROM emp;
SELECT COUNT(empno) FROM emp; --pk, this is better
SELECT COUNT(-1) FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;
-- �Ի����� ���� ������ ����� �Ի���?
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

-- �μ���ȣ�� 10���̰ų� 20���� ����� ��ȸ..COUNT()
SELECT COUNT(empno) FROM emp WHERE deptno IN(10,20);

-- ��� ����� ���ʽ� ���...AVG
-- step1.
-- null���� �ִ� ���...�׷� �Լ� ���� ����!! 4�θ� ������.
--SELECT ROUND(AVG(comm)) FROM emp; -- x
-- step2.
SELECT ROUND(AVG(NVL(comm,0))) FROM emp;

-- emp ���̺��� �μ� ����
SELECT COUNT(DISTINCT deptno) �μ����� FROM emp;

---------------------------------------------------------
/*
�׷��Լ��� ������� ���� �÷���(deptno)
SELECT���� ����....
�ݵ�� GROUP BY�� �ڿ� deptno�÷��� ����ؾ� �Ѵ�
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
-- �˸��ƽ� ������ �ȵǴ� ����...1)where 2)group by
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp 
GROUP BY DNumber
ORDER BY DNumber; -- ����!!, MySQL�� ��(strict���� ����)

-- step4.
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp 
WHERE deptno != 10
GROUP BY deptno
ORDER BY DNumber;

-- �Ի�⵵�� ����� �ο��� ��ȸ...count()
SELECT EXTRACT( YEAR FROM hiredate) Year FROM emp;
SELECT EXTRACT( YEAR FROM hiredate) Year, COUNT(empno)
FROM emp
GROUP BY EXTRACT( YEAR FROM hiredate)
ORDER BY Year;

-- 2
SELECT TO_CHAR(hiredate, 'YYYY') �⵵, COUNT(*)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YYYY')
ORDER BY 1;

-- �μ��� ��ձ޿��� 2000�޷� �̻��� �μ��� �μ���ȣ�� ��ձ޿��� ��ȸ
-- �׷��Լ��� WHERE���� �ƴ� HAVING������ ����ؾ� �Ѵ�
-- step1.
SELECT deptno, ROUND(AVG(sal)) ��ձ޿�
FROM emp
HAVING ROUND(AVG(sal))>=2000
GROUP BY deptno;

-- step2.
-- �ǹ̷������� �׷����� �ϰ� > �׸��� ���� ���߿��� ���ǿ� �´°͸� �����ؼ� ���
SELECT deptno, ROUND(AVG(sal)) ��ձ޿�
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal))>=2000;

-- �μ��� �ִ�޿��� 2900�޷��� �Ѵ� �μ����� �ִ�޿��� ���
--SELECT deptno, MAX(sal) �ִ�޿�
--FROM emp
--GROUP BY deptno
--HAVING MAX(sal)>2900;

-- �μ��� ��ձ޿��� �ִ�޿��� �μ��� �޿��� �˻�
--SELECT deptno, AVG(sal)
--FROM emp
--GROUP BY deptno;
--HAVING MAX(AVG(sal));

-- �μ��� �ο���, �޿��� ��ȸ�� ROLLUP�� ����� �� ���踦 ��ȸ�Ѵ�
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

-- UNION ALL ���� GROUPING SET�� ������ �ξ� ����
SELECT deptno, NULL job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal)
FROM emp
GROUP BY job
ORDER BY 1;

/*
����
�ϳ� �̻�(Self Join)�� ���̺��� ���Ǹ� ������ ���
�Ϲ����� ��� FK�� ���ؼ� ���� ������ �����ȴ�.
Equi Join, Self Join, Outer Join�� �ֿ��ϰ� ���캸��
*/
SELECT empno, ename, sal, job FROM emp; -- �ش� ����� ������ �˰� ������
SELECT deptno, dname, loc FROM dept; -- �ش� �μ��� ������ �˰� ������
SELECT * FROM emp, dept;
/*
Cartesian Product
::
emp, dept ���̺��� ���������� ����
14  X  4 = 56

1) ���������� ����������
2) ���������� �߸�������
*/

-- STEP1.
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- STEP2. ���̺� Alias
SELECT * FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP3. Projection
SELECT empno, ename, sal, deptno, dname, loc FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP4. Projection...�÷����� ���̺� ��Ī�� �� �ش�
SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP5. Equi Join AND Join����
SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE 
e.deptno = d.deptno
AND
d.deptno=10;

/*
Self Join
::
�ϳ��� ���̺��� ��ü������ ������
*/
-- Ư�� ����� ����� �̸��� ��ȸ
/*
1. emp���̺��� ���� Ư���� ����� ename�� ��ȸ
2. ename�� �ش��ϴ� mgr��ȣ�� ã�´�
----------------------------------
3. �ٽ� emp���̺��� empno�� mgr�� ����� ã�Ƽ� ename�� ã�´�
*/

-- STEP1.
SELECT ename, mgr FROM emp; -- BLAKE ����� ����ȣ�� ã��
SELECT empno, ename FROM emp; -- ����ȣ�� ��ġ�ϴ� �����ȣ�� ã�� �׿� �ش��ϴ� ��� �̸��� ã�´�.

-- STEP2.
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m;

-- STEP3. ���� ���� �߰�
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- STEP4. ���� ���� �߰�
SELECT e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno;

-- STEP5. ���� ���� �߰�
SELECT e.ename ����̸�, m.ename ����̸�
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





