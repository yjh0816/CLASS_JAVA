--### Equijoin ###
--1) EMP�� DEPT Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿��� ����϶�.
SELECT d.deptno, d.dname, e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno=d.deptno;

--2) �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno
AND
e.ename='SMITH';

--### Outer join ###
--3) dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table���ִ� DATA�� JOIN�Ͽ� ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ����϶�.
SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;

--### Self join###
--4) EMP Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
--��SMTH�� �Ŵ����� FORD�̴١�
SELECT e.ename, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno;
SELECT  e.ename  || '�� �Ŵ����� ' || m.ename || '�̴�.'
FROM emp e, emp m
WHERE e.mgr = m.empno;
--### Sub Query ###
--1)��ü ����� ��� �޿����� �޿��� ���� ����� �����ȣ, �̸�, �μ���ȣ, �Ի���, �޿��� ����϶�.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);

--2) 10�� �μ��� �������� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���������� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE job IN(SELECT job FROM emp WHERE deptno=10)
ORDER BY sal DESC;

--3) 10�� �μ��߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ, ����, �Ի����� ����϶�.
SELECT empno, ename, sal, job, hiredate
FROM emp
WHERE deptno=10  
AND
job NOT IN (SELECT job FROM emp WHERE deptno=30);

--4) ��KING���̳���JAMES'�� �޿��� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal IN(SELECT sal FROM emp WHERE ename='KING' OR ename='JAMES'); 

--5) �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno=30); 

--6) SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻��϶�.
--2���� ����� ��� 1) ��������2) ���̺� �˸��߽� ���
--6-1)
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT'); 

--6-2)
SELECT main.empno, main.ename, main.sal
FROM emp main, (SELECT sal FROM emp WHERE ename='SCOTT') sub
WHERE main.sal > sub.sal; 

--7) �μ��� �ּ� �޿��߿��� 20�� �μ��� �ּ� �޿����� �� ū �ּ� �޿��� �˻��϶�.
--SELECT MIN(sal)
--FROM emp
--WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno=20);
--SELECT MIN(sal)
--FROM emp
--WHERE sal > ANY (SELECT sal FROM emp WHERE deptno=20);
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);
--8) ���� ������ �Ŵ��� ����� �˻��϶�. �̶� ����̸��� ����� �����ȣ�� �˻��ǵ��� �Ѵ�.(�⸮�߽��� ����̸�, �������ȣ)
SELECT DISTINCT m.ename ����̸�, m.empno �������ȣ
FROM emp e, emp m
WHERE e.mgr = m.empno;
