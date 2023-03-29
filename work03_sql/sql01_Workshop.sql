-- 1) EMP ���̺������Ǳ�����Ȯ���ϴ�SQL���ۼ��ϼ���.
DESC emp;

-- 2) �̸��� K�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �޿����˻��ϼ���.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'K%';

-- 3) �Ի����� 80�⵵�� ����� ��� ������ �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE hiredate LIKE '80%';

-- 4) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE comm is not null;

-- 5) �μ��� 30���μ��̰� �޿���$1,500 �̻��� ����� �̸�, �μ�,������ �˻��ϼ���.
SELECT ename, deptno, sal
FROM emp
WHERE deptno=30 and 1500<=sal;

-- 6) �μ���ȣ�� 30�� ��� �� �����ȣ SORT�Ͽ� ��µǵ��� �˻��ϼ���.
SELECT empno, ename, deptno, sal
FROM emp
WHERE deptno=30
ORDER BY empno;

-- 7) �޿��� ���������� SORT�Ͽ� ��µǵ��� �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY sal DESC;

-- 8) �μ���ȣ�� ASCENDING SORT ���� �޿��� ���� ��� ������ �˻��ϼ���.
--SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
--FROM (SELECT * FROM emp ORDER BY deptno ASC)
--ORDER BY sal DESC;
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno, sal DESC;

-- 9) �μ���ȣ�� DESCENDING SORT�ϰ�, �̸������� ASCENDING SORT, �޿������� DESCENDING SORT �Ͽ� ��µǵ��� �˻��ϼ���.
--SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
--FROM (SELECT * FROM emp ORDER BY deptno DESC)
--ORDER BY ename ASC, sal DESC;
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno DESC, ename, sal DESC;

-- 10) EMP Table���� �̸�, �޿�, Ŀ�̼Ǳݾ�, �Ѿ�(�޿�+Ŀ�̼Ǳݾ�)�� ���Ͽ� �Ѿ��� ���� ������ �˻��ϼ���. ��, Ŀ�̼��� NULL�� ����������Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100) �Ѿ��� ��Ī�� Total�� �Ѵ�.
--SELECT ename, sal, comm, sal+sal*NVL(comm, 0)/100 Total
--FROM emp
--WHERE comm IS NOT NULL
--ORDER BY 4 DESC;
SELECT ename, sal, sal*comm/100 comm, sal+sal*comm/100 Total
FROM emp
WHERE comm IS NOT NULL
ORDER BY Total DESC;

-- 11) 10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ��ݾ�, �μ���ȣ�� �˻��ϼ���.
SELECT ename, sal, sal*0.13 BONUS, deptno
FROM emp
WHERE deptno=10;
SELECT ename, sal, sal*.13 Bonus, deptno
FROM emp
WHERE deptno = 10;

-- 12) �μ���ȣ�� 20�� ����� �ð� �� �ӱ��� ����Ͽ� �˻��ϼ���. ��, 1���� �ٹ��� ���� 12���̰�, 1�� �ٹ��ð��� 5�ð��̴�. ��� ����� �̸�, �޿�, �ð��� �ӱ�(�Ҽ��� ���� ù��° �ڸ����� �ݿø�)�� �˻��ϼ���.
SELECT ename, sal, ROUND(sal/60) "�ð��� �ӱ�"
FROM emp
WHERE deptno=20;
SELECT ename, sal, round(sal/12/5) HourSal
FROM emp
WHERE deptno = 20;

-- 13) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. �̸� �̸�, �޿�, ȸ��(�Ҽ��� ���ڸ� �Ʒ����� �ݿø�)�� �˻��ϼ���.
SELECT ename, sal, ROUND(sal*0.15, 2) ȸ��
FROM emp
WHERE 1500<=sal and sal<=3000;
SELECT ename, sal, round(sal*.15, 2) ȸ��
FROM emp
WHERE sal between 1500 and 3000;

-- 14) ��� ����� �Ǽ��ɾ��� ����Ͽ� �˻��ϼ���.. ��, �޿��� ���������� �̸�, �޿�, �Ǽ��ɾ��� �˻��ϼ���..(�Ǽ��ɾ��� �޿��� ���� 10%�� ������ ���ݾ�)
SELECT ename, sal, comm, sal*0.9 �Ǽ��ɾ�
FROM emp
ORDER BY sal DESC;

