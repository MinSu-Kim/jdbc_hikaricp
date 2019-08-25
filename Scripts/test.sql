select user(), database();

select * from employee;
select dept_code, dept_name, floor from department;
select title_code, title_name from title;

delete from department where dept_code = 6;
delete from title where title_code = 6;