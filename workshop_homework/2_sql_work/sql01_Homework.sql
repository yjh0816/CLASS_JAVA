--1) 30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal),2) "������ ���", MAX(sal) �ְ�, MIN(sal) ����, COUNT(deptno) �ο���
FROM emp
GROUP BY deptno
HAVING deptno=30;

--2) �� �μ��� �޿��� ���(�Ҽ� ���� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal)) "������ ���", MAX(sal) �ְ�, MIN(sal) ����, COUNT(deptno) �ο���
FROM emp
GROUP BY deptno;

--3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ, ������, �ο����� ����϶�.
SELECT deptno, job, COUNT(job) �ο���
FROM emp
GROUP BY deptno, job
ORDER BY 1;

--4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο����� ����϶�.
SELECT job, COUNT(job) �ο���
FROM emp
GROUP BY job
HAVING COUNT(job)>=2
ORDER BY 1;

--5) �� �μ��� ��� ����(�Ҽ� ���� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�.
SELECT deptno, TRUNC(AVG(sal)), SUM(sal), MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
ORDER BY 2 DESC;

--6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �� �޿��� �Ұ�� ������ ����϶�. �μ��� �����Ѵ�.
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY 1;

--7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno, COUNT(empno)
FROM emp
GROUP BY deptno
HAVING COUNT(empno) >=5;

--8) �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�. ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���� ������ ��ȸ������� ���ܽ�Ų��.
SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) <> MIN(sal);

--9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴� �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
--��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ���� �μ� ���� ��µǵ��� �ؾ� �Ѵ�.
SELECT deptno, ROUND(AVG(sal)) ��ձ޿�
FROM emp
WHERE sal BETWEEN 2500 and 5000
AND deptno IN(10,20,30)
GROUP BY deptno
HAVING AVG(sal)>=2000
ORDER BY ��ձ޿� DESC;