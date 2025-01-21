# 约束
## 主键约束
1. 一个表只能有一个主键约束
2. 主键约束意味着唯一并且非空
3. 主键约束名PRIMARY
4. 创建主键会自动创建对应的索引，同样删除主键对应的索引也会删除
### 在建表的时候如何指定主键约束
```mysql
create table 【数据库名.】表名称(
    字段名1 数据类型 primary key,
    字段名2 数据类型,
)
```
- 例如
```mysql
create table test.t_stu(
    sid int primary key,
    sname varchar(20),
    gender char
)
```
### 建表后的主键约束
```mysql
alter table 【数据库名】.表名 add primary key(字段名)
```
- 例如
```mysql
 alter table java_sql_stu.stu add primary key(id);
```
### 主键约束分为两种
- 单列的主键约束
    - 如上
- 复合主键约束
    - 要求两表主键的组合为主键
1. 建表后
```mysql
alter table stu_course_score add primary key(sid,cid);
```
2. 建表前
```mysql
create table stu_course_score(
    sid int,
    cid int,
    score int,
    primary key(sid,cid)
);
```
### 删除主键约束
```mysql
alter table 【数据库名.】表名称 drop primary key;
```
## 唯一键约束
### 特点：
- 一个表可以有多个唯一键约束
- 唯一键约束意味着，唯一，可以为null
- 唯一键的约束可以自己指定，也可以默认，如果是默认的话，一般如果是单列唯一，默认就是列名
  如果是多个唯一，那么默认是该组合第一列的名称
- 创建唯一键约束，也会在对应列上建立索引，而且删除唯一键约束的方式是通过删除对应索引来实现的
### 建表时如何指定唯一键
```mysql
create table books(
    bid int primary key,
    bname varchar(20) unique key,
    price double
);
```
### 唯一键约束也是分为两种
- 单列唯一键
    - 如上
- 多列组合唯一键
```mysql
    create table books(
    bid int primary key,
    bname varchar(20),
    price double,
    unique key(bname,price)
    );
```
### 建表后如何指定唯一键约束
   `alter table 【数据库名.】表名称 add unique key(字段列表)`
### 删除唯一键约束
   `alter table 【数据库名.】表名称 drop index 索引名`
   `alter table books drop index bname`
### 如何查看某个表格的索引名
   `show index from 【数据库名.】表名称;`
## 非空约束
### 特点：
- 一个表可以有很多的非空约束
- 非空约束只能针对某一个字段来说
- 非空约束意味着，该字段不能存为null值
### 如何在建表时指定非空约束
```mysql
create table 【数据库名.】表名称(
    字段名1 数据类型 primary key,
    字段名2 数据类型 not null,
)
```
- 例如
```mysql
create table books(
    bid int primary key,
    bname varchar(20) not null
)
```
### 建表后如何指定某个字段非空
```mysql
alter table 【数据库名.】表名称 modify 字段名 数据类型 not null;
```
```mysql
alter table books modify bname varchar(20) not null;
```
## 默认值约束
### 特点：
1. 一个表可以有很多的默认值约束
2. 默认值约束只能针对某一个字段来说
3. 默认值约束意味着，该字段如果没有手动赋值，惠安默认值处理
### 如何在建表时指定默认值约束
1. 结构
```mysql
create  table 【数据库名.】表名称(
    字段名1 数据类型 primary key,
    字段名2 数据类型 【unique key】 【not null】 default 默认值,
    字段名3 数据类型 default 默认值,
)
```
2. 代码
```mysql
create  table books(
    bid int primary key,
    bname varchar(20) default "bname"
)
```
### 建表后如何指定字段默认值
1. 结构
```mysql
alter table 【数据库名.】表名称 modify 字段名 数据类型 default 默认值;
```
2. 代码
```mysql
alter table books modify bname varchar(20) default "bname";
```
### 如果字段本身有 not null并且想保留
- 两个都要写
```mysql
alter table books modify bname varchar(20) default "bname" not null;
```
### 如何取消某个字段的默认值约束
```mysql
alter table books modify bname varchar(20);
```
## 检查约束
1. check：mysql暂不支持
```mysql
create table stu(
    sid int primary key,
    sname varchar(20),
    sgender char check ("男" or "女")
);
```
## 自增约束
- auto_increment
- 如果指定值，就按照指定的来，没有指定就自增
- 如果指定的值是0或者null就按照自增来
### 特点
1. 一个表只能有一个自增约束，因为一个表只有一个维护子增值的变量‘
2. 自增约束的列只能是整数列
3. 自增约束的列必须是键列（主键，唯一键，外键），实际中一般是主键自增最多
### 如何在建表时制定某个列自增
1. 结构
```mysql
create table 【数据库名.】表名称(
    字段名 数据类型 primary key auto_increment
)
```
2. 代码
```mysql
create table books(
    bid int primary key auto_increment
)
```
### 如何给自增列添加数据
1. 代码（三种）
```mysql
insert into stu(sname) values("张三");
insert into stu values(3,"李四");
insert into stu(sname) values("王五");# id：4
insert into stu values(0,"李四");# id：5
insert into stu values(null,"李四");# id：6
```
### 如何取消自增
```mysql
alter table 【数据库名.】表名称 modify 字段名 数据类型;
```
### 建表后增加自增
```mysql
alter table 【数据库名.】表名称 modify 字段名 数据类型 auto_increment;
```
## 外检约束
### 特点
1. 一个表可以有含多个外键约束
2. 外键约束是需要一个表的两个字段或两个表的两个字段之间建立外键约束
3. 外键约束一定是在从表/子表中建立的
- 主表、子表：参考别人，依赖别人
- 从表、父表：被参考的，被依赖的
4. 在从表中外键约束的列，与在主表中外检约束参考的列，这两个列的名称可以不同，但是意义、数据类型必须一致
5. 外键约束是同时约束双方的
- 对于主表来说：修改和删除就受约束了
- 对于从表来说：添加哈修改被约束了
6. 建表时先建主表在建从表
7. 删除时先删从表，再删主表
### 约束的等级
1. Cascade方式：级联
- 主动权在主表上
- 如果主表被依赖的字段修改了，从表的对应的外键字段跟着修改
- 如果主表被依赖的的记录删除了，从表对应的外键字段的记录也会被删除
2. set null方式
- - 主动权在主表上
- 如果主表被依赖的字段修改了，从表的对应的外键字段设置为null
- 如果主表被依赖的的记录删除了，从表对应的外键字段的值设置为null
- 这里要求，外键字段必须不能有非空约束
3. No action方式：不作为
4. Restrict：严格
- 3、4，如果主表的被依赖字段的值被引用了，那么主表对该字段的修改和删除就完全限制了，就不能修改和删除
- 3、4，主表没有主动权。必须先处理从表对应的值，然后才能修改和删除
5. Set default方式：mysql的Innodb引擎不支持
6. 主表被参考的列必须是键列
### 如何在建表时指定外键
1. 结构
```mysql
create table 【数据库名.】表名称(
    字段名1 数据类型 primary key auto_increment,
    字段名2 数据类型 default 默认值,
    foreign key(从表的某个字段) references 主表名(被参考的字段) 【on update 等级】 【on delete 等级】
)
```
2. 代码
```mysql
# 部门表
create table dept(
    did int primary key,
    dname varchar(20)
);

# 员工表
create table emp(
    eid int primary key,
    ename varchar(20),
    did int,
    foreign key(did) references dept(did) 
        on update cascade on delete set null 
);
insert into emp values(1,'张三',1);#错误的，因为主表还没有对应记录
# ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`test`.`emp`, CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE)


insert into dept values(1,'咨询部'),(2,'教学部')
insert into emp values(1,'张三',1);
insert into emp values(2,'李四',4);
# ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`test`.`emp`, CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE)

delete from dept where did = 1;
update dept set did = 5 where did = 2;
```
### 建表后如何指定外键
```mysql
alter table 【数据库名.】从表名称 add foreign key(从表的某字段) references 主表名(主表被引用字段)
```
### 如何删除外键
```mysql
alter table 【数据库名.】从表名称 drop foreign key 约束名;
```
### 如何查看某个表的外键约束名
```mysql
select * from information_schema.TABLE_CONSTRAINTS where TABLE_CONSTRAINTS.TABLE_NAME = "表名称"
```
## 函数
### 求字符数
1. length(xx)
- 求得是字节数，和字符集有关
2. char_length(xx)
- 求字符数
### 求字符串拼接
1. concat(xx,xx)
- 拼接xx和xx
2. concat_ws(拼接的符号,xx,xx)
- 以什么符号拼接
3. upper(str),lower(str)
- 转大小写
4. left/right(xx,数量)
- 返回左/右边的几个字符
5. ltrim/rtrim/trim
- 去除左边/右边/两边的空格
6. trim(both '符号' from '字符串')/trim(leading '符号' from '字符串')/trim(trailing '符号' from '字符串')
- 去掉两边/前边/后边的对应符号
7. substring('字符串','第几个字符从1开始')
- 从第几个字符截取
### 数学函数
1. seil()/floor()/round()
- 向上取整/向下取整/四舍五入
2. rand()
- [0,1)随机值
3. round(x,y)
- round(3.1415926,3)
- 保留小数点后y位，看第y+1位，决定四舍五入
- truncate(3.1415926,3)
- 保留小数点后y位，之后直接截掉
### 日期时间函数
1. now():现在的系统时间
2. sysdate():同上
3. current_time()：只有当前时间
3. current_time()：只有当前日期
4. current_timestamp():当前时间戳
5. year(时间)/month(时间)/day(时间):求年/月/日
6. dayofweek(那天):那天是星期几
> 注：这里周日是1周六是7
7. weekday(日期):那天是星期几
> 注：这里周一是0，周日是6
8. datediff(日期,日期)：两个日期之间的天数
9. date_format():把日期转为字符串
10. str_to_date():把字符串转为日期
### 其他函数
#### 加密函数
1. password()
2. md5()
#### 分组函数
1. count(*):统计数量
- count(*)和count(常量)一样
- count(字段名)是统计非null值的
2. sum(x):总和
3. max()/min():最大/最小值
4. avg():平均值
## 联合查询（关联查询）
### 总共与七种情况
1. a
2. b
3. a∩b
4. a∪b
5. a-a∩b
6. b-a∩b
7. a∪b-a∩b
### 如何实现这些结果
1. 内连接：a∩b
2. 左外连接：a、a-a∩b
3. 右外连接：b、b-a∩b
4. 全外链接：a∪b、a∪b-a∩b
- 不直接支持全外连接，但是可以使用union（合并）结果来实现以下两种结果
#### 内连接
- 关联条件 = 表数 - 1
1. 结构
```mysql
select 字段列表 from A表名 inner join B表名 on 关联条件 where 其他条件
```
2. 代码
- 错误的：当前代码会出现笛卡尔积：A表的数量*B表的数量
```mysql
select eid,ename,t_employee.did,dname
from t_employee inner join t_department;
```
- 正确的
```mysql
select eid,ename,t_employee.did,dname
from t_employee inner join t_department
on t_employee.did = t_department.did;
```
- 简化版：字段取别名
```mysql
select eid,ename,emp.did,dname
from t_employee as emp inner join t_department as dept
on emp.did = dept.did;
```
3. 三张表
```mysql
select eid,ename,t_employee.`job_id`,job_name,t_employee.`did`,dname
from t_employee inner join t_job inner join t_department
on t_employee.did = t_department.did and t_employee.`job_id` = t_job
```
4. 另一种简化语法
- 结构
```mysql
select 字段列表
from A表名,B表名
where 1个关联条件 and 其他条件
```
- 代码
```mysql
select eid,ename,t_employee.did,dname
from t_employee,t_department
where t_employee.did = t_department.did;
```
#### 左连接
- 适用于A表的关联外键右null值
- 例如：当A表的部门编号有null时，使用inner join的时候会少信息，使用left join可以以A表为主
##### 查询A
1. 结构
```mysql
# 
select 字段列表
from A left join B
on 关联条件
where 其他条件;
```
2. 代码
```mysql
select eid,ename,t_employee.did,dname
from t_employee left join t_department
on t_employee.did = t_department.did;
```
##### 查询A-A∩B
1. 结构
```mysql
select 字段列表
from A left join B
on 关联条件
where 关联字段 is null and 其他条件;
```
2. 代码
```mysql
select eid,ename,t_employee.did,dname
from t_employee left join t_department
on t_employee.did = t_department.did
where t_employee.did is null;
```
#### 右连接
- 适用于B表的关联外键右null值
- 例如：当B表的部门编号有null时，使用inner join的时候会少信息，使用right join可以以A表为主
##### 查询B
1. 结构
```mysql
# 
select 字段列表
from B right join A
on 关联条件
where 其他条件;
```
2. 代码
```mysql
select eid,ename,t_employee.did,dname
from t_department right join t_employee
on t_employee.did = t_department.did;
```
##### 查询B-A∩B
1. 结构
```mysql
select 字段列表
from B right join A
on 关联条件
where 关联字段 is null and 其他条件;
```
2. 代码
```mysql
select eid,ename,t_employee.did,dname
from t_department right join t_employee
on t_employee.did = t_department.did
where t_department.did is null;
```
#### 用union实现全外连接
- 把A∪B转换成 A union B
- 把A∪B-A∩B转换成 A-A∩B union B-A∩B
- 通俗来讲就是左连接union右连接
```mysql
select *
from t_employee left join t_department
on t_employee.did = t_department.did
union
select *
from t_employee right join t_department
on t_employee.did = t_department.`did`;
```
## select的6大子句
### 1.from:从哪里来筛选数据
- 后面根表，视图，多行多列的二维表的结构
### 2.where:意思是取那几行
- 后面跟条件
### 3.group by:分组
- 后面跟字段名
- 建议：分组查询的结果的字段列表中不要出现和分组无关的字段
### 4.having:在分组统计结果中再次对统计结果加条件
- 构面跟条件
- 在分组统计结果中再次对统计结果加条件
- having和where的区别
  - where后面不能跟分组函数，having可以
  - where适用于在原表的记录中筛选，having可以对原表筛选，但更多的应用于统计的结果筛选
### 5.order by:排序
- 后面根字段或表达式
- desc：降序
- asc：升序，可以省略
### 6.limit:限制统计结果条数
- limit m,n：m表示从几条开始取，n表示最多取n条数据
- 分页：
  - 假设page代表第几页，nums代表每页数量
  - limit(page-1)*nums,nums
> 强调：每一个select的6大子句的顺序是1-6
## 子查询
- 在另外一个查询中嵌套了另一个查询
- 子查询的结果作为外部查询的条件或者数据的筛选范围来使用
- 子查询分类三类
### where型
- 子查询的结果作为外部查询的条件来使用
1. 举例:联合查询
```mysql
# 查询所有运营部员工的信息
select *
from employee inner join department
on employee.did = department.did
where department.name = '运营部';
```
2. 子查询
```mysql
select *
from employee where did = (select * from department where name = '运营部');
```
3. 总结：
- 子查询结果是单值结果，比较云悬浮后面可以跟单值的结果
- 子查询结果是一些多行的可以用in()比较运算符all(),any()
### from型
- 子查询的结果作为外部查询的筛选范围来使用
1. 举例：
- 查询每个部门的编号，部门名称，部门的人数
- 每个部门的编号，部门名称在部门的表中
- 每个部门的编号，部门的人数在员工表中统计出来的
```mysql
# 每个部门的编号，部门的人数 员工表
select did ,COUNT(*) from employee group by did;# 把它看成是一个临时表

# select 部门表.did,部门标的.name,temp.部门人数 
# from 部门标 inner join 临时表temp
# on 部门表.did = 临时表temp.did
select department.did,department.name,temp.countOfDep # countOfDep是部门人数
from department inner join (select did ,COUNT(*) from employee group by did) as temp
on department.did = temp;
```
### exists型
- 子查询的结果作为外部查询的条件来使用
1. 查询部门信息，要求这些部门必须有员工
- 运行规则：将select * from department的每一条记录，带入
子查询去匹配，如果能查询出记录，就说明要保留这样，否则就去掉
- 例如：把部门表中有而员工表没有的带入子查询，那么就不保留
```mysql
select * from department
where exists(select * from empolyee where department.did = employee.did)
```
