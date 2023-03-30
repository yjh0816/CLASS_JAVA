--1) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�. ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename,0,3) ENAME_3, sal
FROM emp;

--2) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
SELECT empno, LOWER(SUBSTR(ename,0,3)) ENAME_3, sal
FROM emp
WHERE LENGTH(ename)>=6;

--3) �����������Է��ϴ��߾Ʒ��Ͱ����ԷµǾ���.(�̸����������Էµ�)
insert into emp values(8001, '  PARK   ' , 'IT' , 7521 , '21/11/10', 20000,1000,10);
select * from emp;
-- �̸���'PARK'������������������Ͽ�����.
select * from emp where ename='PARK';
-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����϶�.
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE TRIM(ename)='PARK';

--4) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
--   �̸� �̸�, �޿�, ȸ��(�Ҽ��� ���ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, ROUND(sal*.15,2) ȸ��
FROM emp
WHERE sal BETWEEN 1500 and 3000;

--5) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ����� �Ͽ���.�̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�
SELECT ename, sal, TRUNC(sal*.05) ������
FROM emp
WHERE 2000<=sal;

--6) �Ի��Ϸκ��� 100���� �����ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.
SELECT ename, hiredate, hiredate+100 AFTER_100D, sal
FROM emp;

--7) �Ի��Ϸκ��� 6������ �������� ��¥�� ���Ϸ��� �Ѵ�. �Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate, ADD_MONTHS(hiredate,6) AFTER_6M, sal
FROM emp;

--8) �Ի��Ѵ��� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
SELECT deptno, ename, LAST_DAY(hiredate)-hiredate �ٹ��ϼ�
FROM emp;

--9) ��� ����� �Ի��� �������� 100���� �������� �������� ��¥�� ���ؼ� ����̸�, �Ի���, ��MONDAY���� ����϶�.
SELECT ename, hiredate, NEXT_DAY(hiredate+100,2) MONDAY
FROM emp;

--10) ������ �̸�, ����, �ټӳ���� ���Ͽ� ����϶�.
SELECT ename, job, EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM (hiredate)) �ټӳ�� FROM emp;
select ename, job, trunc((sysdate-hiredate)/365) �ټӳ�� from emp;

--11) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ����϶�.
SELECT ename, TO_CHAR(hiredate,'YYYY"-"MM"-"DD')
FROM emp;

--12) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿� �տ� ȭ��ǥ��($), �׸��� ����(,)ǥ��, �Ҽ��� ���� 2�ڸ��� ǥ�õǵ��� �϶�.
SELECT empno, ename, TO_CHAR(sal,'$999,999.99')
FROM emp;

--13) ��� ������ �̸��� �Ի��� ������ ����϶�.
SELECT ename, TO_CHAR(hiredate,'DAY')
FROM emp;

-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- mgr�� null�̸� ���������/ null�̸� mgr���� �������� �Ѵ�.
-- ��Ī�� mgr2�� ����
SELECT ename, mgr,
        CASE WHEN mgr is null THEN '��������� '
             ELSE mgr || ''
        END mgr2
FROM emp;

select ename, mgr,
        CASE  WHEN mgr is null THEN '���������'  
        ELSE mgr || '�����'
        END MGR2
from emp;

SELECT ename, mgr,
		CASE  WHEN mgr is null THEN '���������'       
			 ELSE TO_CHAR(mgr)
		END mgr2
FROM emp;