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