# 1.查询"01"课程比"02"课程成绩高的学生的信息及课程分数
select std.*, sc1.s_score score01, sc2.s_score score02
from score sc1
         join score sc2 on sc1.s_id = sc2.s_id
         join student std on std.s_id = sc1.s_id
where sc1.c_id = 1
  and sc2.c_id = 2
  and sc1.s_score > sc2.s_score;

# 2.查询"01"课程比"02"课程成绩低的学生的信息及课程分数
select std.*, sc1.s_score score01, sc2.s_score score02
from score sc1
         join score sc2 on sc1.s_id = sc2.s_id
         join student std on std.s_id = sc1.s_id
where sc1.c_id = 1
  and sc2.c_id = 2
  and sc1.s_score < sc2.s_score;

# 3.查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
select std.s_id, s_name, avg_score
from student std
         join (select sc.s_id, avg(s_score) avg_score
               from score sc
               group by sc.s_id
               having avg(s_score) >= 60) sc on sc.s_id = std.s_id;

# 4.查询平均成绩小于60分的同学的学生编号和学生姓名和平均成绩(包括有成绩的和无成绩的)
# 需要考虑到一科都没参加考试的同学，使用left join

select std.s_id, s_name, ifnull(avg_score, 0)
from student std
         left join (select sc.s_id, avg(s_score) avg_score
                    from score sc
                    group by sc.s_id) sc on sc.s_id = std.s_id
where avg_score < 60
   or avg_score is null;


# 5.查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
select std.s_id, s_name, ifnull(avg_score, 0), ifnull(c_count, 0)
from student std
         left join (select sc.s_id, avg(s_score) avg_score from score sc group by sc.s_id) sc on std.s_id = sc.s_id
         left join (select s_id, count(c_id) c_count from score sc group by s_id) ccount on std.s_id = ccount.s_id;

# 6.查询"李"姓老师的数量
select count(1)
from teacher
where t_name like '李%';

#7. 查询学过"张三"老师授课的同学的信息
select std.*
from student std
         join
     # 查找选课学生
         (select s_id
          from course c
                   join teacher t
                        on t.t_id = c.t_id
                   join score sc
                        on sc.c_id = c.c_id
          where t_name = '张三') selected_sid
     on std.s_id = selected_sid.s_id;

#8. 查询没学过"张三"老师授课的同学的信息
select std.*
from student std
where std.s_id not in (select s_id
                       from course c
                                join teacher t
                                     on t.t_id = c.t_id
                                join score sc
                                     on sc.c_id = c.c_id
                       where t_name = '张三');

#9. 查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息
select std.*
from student std
where s_id in
      (select sc1.s_id
       from score sc1
                join score sc2
                     on sc1.s_id = sc2.s_id
       where sc1.c_id = 1
         and sc2.c_id = 2);

#10. 查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息
select *
from student
where s_id in
      (select s_id from score sc where c_id = 1 and s_id not in (select sc.s_id from score sc where sc.c_id = 2));

#11. 查询没有学全所有课程的同学的信息
select std.*
from student std
where s_id in
      (select std.s_id
       from student std
                left join score sc
                          on sc.s_id = std.s_id
       group by s_id
       having count(1) <
              (select count(1)
               from course c));

# 12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息
select *
from student std
where s_id in
      (select distinct s_id
       from score
       where c_id in (select c_id
                      from score sc
                      where s_id = 1));

# 13.查询和"01"号的同学学习的课程完全相同的其他同学的信息
select *
from student
where s_id in (select s_id
               from score sc
               where s_id != 1
               group by s_id
               having group_concat(c_id) =
                      (select group_concat(c_id)
                       from score sc
                       where s_id = 1
                       group by s_id));

# 14.查询没学过"张三"老师讲授的任一门课程的学生姓名
select s_name
from student std
where s_id not in
      (select distinct s_id
       from score sc
       where c_id in (select c.c_id
                      from course c
                               join teacher t on c.t_id = t.t_id
                      where t_name = '张三'));

# 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
select std.s_id, s_name
from student std
         join
     ((select s_id, avg(s_score)
       from (select * from score where s_score < 60) selected_l60
       group by s_id
       having count(1) >= 2)) selected_avgscore_l60
     on std.s_id = selected_avgscore_l60.s_id;

# 16、检索"01"课程分数小于60，按分数降序排列的学生信息
select std.*
from student std
         join
     (select s_id, s_score
      from score sc
      where c_id = 1
        and s_score < 60) selected_sc
     on std.s_id = selected_sc.s_id
order by s_score desc;

# 17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
# # 这个题做得我头挺大的   最后参考了别人写的代码
# 自欺欺人sql
select s.s_id                                        as 学号,
       s.s_name                                      as 姓名,
       sum(case c_id when 1 then s_score else 0 end) as 语文,
       sum(case c_id when 2 then s_score else 0 end) as 数学,
       sum(case c_id when 3 then s_score else 0 end) as 英语,
       ifnull(round(avg(s_score), 2), 0)             as 平均成绩
from student s
         left join score sc on s.s_id = sc.s_id
group by s.s_id
order by 平均成绩 desc;

# 18、查询各科成绩最高分、最低分和平均分，以如下形式显示：
# 课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
# – 及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
select c.c_id,
       round(max(s_score), 2)                                              最高分,
       round(min(s_score), 2)                                              最低分,
       round(avg(s_score), 2)                                              平均分,
       round((sum(if(s_score >= 90, 1, 0)) / sum(1)) * 100, 2)             优秀率,
       round((sum(if(s_score between 80 and 90, 1, 0)) / sum(1)) * 100, 2) 优良率,
       round((sum(if(s_score between 70 and 80, 1, 0)) / sum(1)) * 100, 2) 中等率,
       round((sum(if(s_score >= 60, 1, 0)) / sum(1)) * 100, 2)             及格率
from course c
         join score sc
              on c.c_id = sc.c_id
group by c.c_id;

# 19、按各科成绩进行排序，并显示排名
select c_id,
       s_id,
       s_score,
       rank() over (partition by c_id order by s_score desc) 排名
from score sc
order by c_id, s_score desc;

# 20、查询学生的总成绩并进行排名
select std.*,
       sum_score,
       rank() over (order by sum_score desc)
from student std
         join (select sc.s_id, sum(s_score) sum_score
               from student std
                        left join score sc
                                  on sc.s_id = std.s_id
               group by sc.s_id) selected_sumscore
              on std.s_id = selected_sumscore.s_id
order by sum_score desc;

# 21、查询不同老师所教不同课程平均分从高到低显示
select t.t_id, c.c_id, avg(s_score)
from score sc
         join course c on c.c_id = sc.c_id
         join teacher t on c.t_id = t.t_id
group by t.t_id, c.c_id
order by avg(s_score);

# 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
select *
from (select c_id,
             s_id,
             s_score,
             rank() over (partition by c_id order by s_score desc) 排名
      from score sc
      order by c_id, s_score desc) sc_desc
where 排名 = 2
   or 排名 = 3;

# 23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比

# 24、查询学生平均成绩及其名次
select s_id, avg_score, rank() over (order by avg_score desc) 排名
from (select s_id, avg(s_score) avg_score
      from score sc
      group by s_id) selected_score;

# 25、查询各科成绩前三名的记录
select * from (
select *, rank() over (partition by c_id order by s_score desc) 排名
from score sc) selected_score
where 排名 <= 3
