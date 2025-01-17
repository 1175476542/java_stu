<!-- TOC -->
* [数据库](#数据库)
  * [数据类型](#数据类型)
  * [使用int数据类信号](#使用int数据类信号)
  * [浮点小数](#浮点小数)
  * [定点小数](#定点小数)
  * [日期和时间类型](#日期和时间类型)
    * [datetime和timestamp](#datetime和timestamp)
  * [字符串](#字符串)
  * [位类型（了解）](#位类型了解)
  * [blob类型（了解）](#blob类型了解)
  * [枚举（ENUM）](#枚举enum)
  * [集合](#集合)
  * [导入导出](#导入导出)
    * [导入](#导入)
    * [导出数据库备份](#导出数据库备份)
  * [SQL语句的规范：](#sql语句的规范)
    * [命名规范：](#命名规范)
  * [mySQL的分类](#mysql的分类)
  * [代码演示](#代码演示)
  * [运算符](#运算符)
    * [算术运算符](#算术运算符)
    * [比较运算符](#比较运算符)
      * [示例](#示例)
    * [逻辑运算符](#逻辑运算符)
      * [示例](#示例-1)
    * [范围](#范围)
      * [示例](#示例-2)
    * [模糊查询](#模糊查询)
  * [DDL](#ddl)
    * [操作表结构的SQL](#操作表结构的sql)
  * [DML](#dml)
<!-- TOC -->
# 数据库
## 数据类型
1. TINYINT:非常小的整数
2. SMALLINT:小整数
3. MEDIUMINT:中整数
4. INT、INTEGER:整数
5. BIGINT:大整数
## 使用int数据类信号
1. int:默认11，等价于int(11)
2. int (M):M表示宽度，需要结合另外的两个参数使用
3. unsigned：表示无符号，即没有负数
4. zerofill：表示用0填充。例如：int(5) zerofill
> 无论int的宽度设置为多少，在内存中都是占4个字节，如果数字超了范围也可以存
## 浮点小数
1. float:4个字节
2. double：8个字节
3. 使用float和double时：
- float或double
- float(M,D),double(M,D):M表示总位数，D表示精度，即小数点后几位
## 定点小数
- 类似于java的BigDecimal，底层使用字符串存储
1. Decimal
2. Decimal(M,D)
## 日期和时间类型
1. date:只能表示时间
2. time:表示时间
3. datetime:表示日期和时间
4. year:表示年
5. timestamp:表示日期和时间
###  datetime和timestamp
1. timestamp实际存储的毫秒值，显示时，显示根据毫秒值算出来的一个本地化的日期时间，datetime就是存储日期时间
2. timestamp因为存储的毫秒值，所以在比较和计算时，效率比较高
3. datetime和timestamp可以表示的时间范围是不同的
## 字符串
- 强调：mysql没有单字符类型，只有字符串类型
1. char：定长字符，实际定的几个字符就只能是这么多
2. varchar(M)：变长字符,必须制定M，意思是最长不超过M
- char和varchar
   - 内存占用空间不同
       - char(M)：M字符就占M个字符的空间<br/>
       例如：char(2)  实际存储的是'男'，但是也是占2个字符的位置，那一个空的字符存储的是\u0000
       - varchar：实际几个字符 + 1/2个字节的空间<br/>
       例如：varchar(20)  实际存储的是'张三',占的2个字符 + 1/2个字节（用来记录实际的字符个数的）
   - varchar节省空间，但是每次存和取，都要数字符个数
   - char：看起来浪费空间，但是每次存和取，都按照固定的长度去处理的
> 建议：像身份证号，学号，邮编等定长的字符串使用char，例如：地址等使用变长的
现在mysql的版本对varchar优化的越来越快了。
3. text：长文本，存储文字比较多的，不经常检索的信息
## 位类型（了解）
- 二进制的位类型，BIT(M)类型允许存储M位值。M范围为1-64，默认是1
## blob类型（了解）
BINARY和VARBINARY类型类似于CHAR和VARCHAR类型，但是不同的是，它们存储的不是字符字符串，而是二进制串。所以它们没有字符集
## 枚举（ENUM）
多个中选择一个
## 集合
多个中可以选择多个
## 导入导出
### 导入
1、登录mysql后
2、导入执行sql脚本
- mysql> source sql文件的路径名
- 例如：mysql> source d:/mysqldb.sql

### 导出数据库备份
- 不用登录，直接在命令行
- mysqldump -h主机名 -P端口 -u用户名 -p密码 --database 数据库名 > 文件名.sql
- 例如： mysqldump -hlocalhost -P3306 -uroot -p123456 --database test > D:\mysqldb.sql
## SQL语句的规范：
1. mysql对于SQL语句不区分大小写，SQL语句关键字尽量大写
- show databases;
- SHOW DATABASES;
  - 至于表中的数据是否区分大小写，和字符编码，和数据类型，和校对规则有关。
  - ci：不区分大小写
  - cs：区分大小写
  - bin：最严格，区分大小写，以二进制值存储
2. 在sql语句中的值，除了数值类型（整数、小数），其他的类型，都使用''引起来。
>例如：select * from t_employee where gender ='男';

3. 如果在SQL中需要给字段取别名时，可以给别名加""。
- 如果别名中间没有空格，""可以省略，如果有空格，不能省略""
4. 所有标点符号使用英文状态下的半角输入方式
5. 必须保证所有(),单引号，双引号是成对结束的
6. 可以使用（1）#单行注释 （2）--空格单行注释 （3）/*  多行注释  */
### 命名规范：
1. 必须只能包含 A–Z, a–z, 0–9, _共63个字符
2. 不能在对象名的字符间留空格
- 例如：create database xx db; #错误的
3. 避免重名
- 同一个DB数据库中，表不能重名，
- 同一张表中，字段不能重名
- 同一个DBMS数据库管理软件中，数据库不能重名
4. 命名时不要使用关键字
create database database; #错误的
## mySQL的分类
1. DDL：Data Define Language
- 数据定义语言，即定义数据的结构。
- 例如：`create，drop，alter`
2. DML：Data Manage Language
- 数据管理语言，对数据值的增、删、改、查
- 例如：`insert，delete，update，select`
3. DCL：Data Control Language
- 数据控制语言，对权限、事务等的控制
- 例如：`grant,revoke,commit,rollback`等
## 代码演示
```mysql
#注释
# 1、查看当前mysql数据库管理软件中都有什么数据库
show databases;

#使用一个数据库
use test;

#如果test不存在，可以创建一个新的数据库
create database test;

#查看当前数据库中都有什么表格
show tables;

#查看某个表的数据
select * from 表名称;
select * from t_employee;

#查询所有人的薪资
select salary from t_employee;
select salary+1000 from t_employee;

#修改所有人的薪资，涨1000元
update t_employee set salary = salary + 1000;

#查询薪资加完1000元后，超过20000
select * from t_employee where salary+1000 > 20000;



```
## 运算符
### 算术运算符
1. +：加
2. -：减
3. *：乘
4. /：除   可以保留小数部分
5. div：除  如果整数与整数相除只保留整数部分
6. %：求余数
7. mod：求余数
```mysql
select 1/2; # 0.5
select 1 div 2; # 0
```
### 比较运算符
1. >：大于
2. <：小于
3. =：等于  注意区别，Java中是==,mysql中是=
4. >=：大于等于
5. <=：小于等于
6. !=：不等于
7. <>：不等于
8. <=>：安全等于  用于判断null值的比较运算符
9. null值的判断，习惯上我们用is null 和is not null
#### 示例
- 查询薪资大于20000元的员工
`select * from t_employee where salary > 20000;`
- 查询所有男员工
```mysql
select * from t_employee where gender = '男';
select * from t_employee where gender != '女';
select * from t_employee where gender <> '女';
```
- 查询奖金比例commision_pct是null的员工
`select  * from t_employee where commission_pct <=> null;`
`select  * from t_employee where commission_pct is null;`
### 逻辑运算符
1. &&和and：逻辑与
- 两个条件同时满足
2. ||和or：逻辑或
- 两个条件满足任意一个
3. ^和xor：逻辑异或
- 两个条件只能满足其中一个
4. !和not：
- 不满足xx条件
#### 示例
- 查询薪资大于20000元的女员工	
  ` select * from t_employee where salary > 20000 && gender = '女';`
  `select * from t_employee where salary > 20000 and gender = '女';`
- 查询男员工
`select * from t_employee where not gender = '女';`
`select * from t_employee where !(gender = '女');`
- 查询薪资大于10000  异或 性别是男的，即它俩只能满足一个
- 即查询薪资大于10000的女的或薪资低于10000的男的
`select * from t_employee where salary>10000 ^ gender ='男';`
`select * from t_employee where salary>10000 xor gender ='男';`
### 范围
1. 区间范围：
	- 在[a,b]之间，between a and b
	- 不在[a,b]之间，not between a and b
2. 集合范围
	- in(...)
	- not in(...)
#### 示例
- 查询薪资在[15000,20000]之间的员工
`select * from t_employee where salary between 15000 and 20000;`
`select * from t_employee where salary >= 15000 and salary <=20000;`
- 查询薪资在9000,10000,12000
`select * from t_employee where salary in(9000,10000,12000);`
`select * from t_employee where salary =9000 || salary =10000 || salary =12000;`
### 模糊查询
1. like '%x%' x代表确定的字符 %表示不确定的0~n个字符
     - '_x%'  x代表确定的字符 _表示确定的1个字符
- 查询，名字ename中包含“冰”这个字的员工
`select * from t_employee where ename like '%冰%';`
- 查询，名字ename是张xx，三个字
`select * from t_employee where ename like '张__';`

- 查询，名字ename是第二个字是'冰'
`select * from t_employee where ename like '_冰%';`
## DDL
1. 操作database的SQL
- 查看当前mysql数据库管理软件中的所有数据库
`show databases;`
2. 使用某个数据库
- use 数据库名;
- 例如：`use test;`
3. 创建一个数据库
- create database 数据库名;
- 例如：
`create database library;`
4. 删除一个数据库
-  database 数据库名;
- 例如：
`drop database  0513db;`
### 操作表结构的SQL
1. 查看某个数据库下的所有表格
`show tables;`
>mysql> show tables;
ERROR 1046 (3D000): No database selected

- 解决方案有两种：
  - 先use，再操作表格
  `use 数据库名;`
  `show tables;`
  - show tables from 数据名;
2. 创建某个表格
- create table 【数据库名.】表名称(字段名1 数据类型,字段名2 数据类型,字段名3 数据类型);
`create table 【数据库名.】表名称(
字段名1 数据类型,
字段名2 数据类型,
字段名3 数据类型
);`
>说明：如果前面有use语句，那么【数据库名.】可以省略

- 例如：
`create table test.t_stu(
sid int,
sname varchar(20),
gender char,
birthday date,
score double
);`

3. 查看表结构
- desc 表名称;

```mysql
mysql> desc t_stu;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| sid      | int(11)     | YES  |     | NULL    |       |
| sname    | varchar(20) | YES  |     | NULL    |       |
| gender   | char(1)     | YES  |     | NULL    |       |
| birthday | date        | YES  |     | NULL    |       |
| score    | double      | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
```
- 类似于通过Class对象看类的信息。

4. 修改表名称
- rename table 旧表名 to 新表名;
- alter table 旧表名 rename 新表名;
- 例如：
```mysql
rename table t_stu to student;
alter table student rename t_stu;
```
5. 修改表结构
   1. 增加一列，增加一个字段
      - alter table 表名称 add 【column】 字段名 数据类型; #默认添加到最后
      - alter table 表名称 add 【column】 字段名 数据类型 first;
      - alter table 表名称 add 【column】 字段名 数据类型 after 另一个字段;
      - 例如：增加一列，存储电话号码
      `alter table t_stu add  tel char(11);`
      - 增加一列，存储地址，添加到第一列的位置
      `alter table t_stu add  address varchar(50) first;`
      - 增加一列，年龄，添加到sname的后面
      `alter table t_stu add  age int after sname;`
   2. 修改，字段的数据类型或位置
      - alter table 表名称 modify  【column】 字段名 新的数据类型;
      - alter table 表名称 modify  【column】 字段名 数据类型 first;
      - alter table 表名称 modify  【column】 字段名 数据类型 after 另一个字段;
      - 例如：修改gender的数据类型为char(2)
      `alter table t_stu modify   gender char(2);`
      - 例如：修改address的位置到最后一列
     ` alter table t_stu modify   address varchar(50) after tel;`
   3. 修改，列的名称
      - alter table 表名称 change  【column】 旧字段名  新的字段名 数据类型;
      - 例如：修改列的名称tel为phone
      `alter table t_stu change tel phone char(11);`

   4. 删除一列
      `alter table 表名称 drop 【column】 字段名;`
       - 例如：删除地址列
      `alter table t_stu drop address;`
6. 删除整张表
- drop table 表名称;
例如：`drop table t_stu;`
## DML
- DML：增删改查    对应程序员来说，DML的重要性要比你掌握DDL还要重要。
1. 添加数据，往表中插入数据
- insert into 【数据库名.】表名称 values(值列表);
要求为所有列赋值，(值列表)的类型、数量与表结构中列的类型、数量一致
- insert into 【数据库名.】表名称(字段列表) values(值列表);
为(字段列表)指定的列赋值，(值列表)的数量与(字段列表)的类型、数量对应
- insert into 【数据库名.】表名称 values(值列表1),(值列表2)。。。;
- insert into 【数据库名.】表名称(字段列表) values(值列表1),(值列表2)。。。;

```bash
mysql> shell;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| sid      | int(11)     | YES  |     | NULL    |       |
| sname    | varchar(20) | YES  |     | NULL    |       |
| gender   | char(1)     | YES  |     | NULL    |       |
| birthday | date        | YES  |     | NULL    |       |
| score    | double      | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)
```
- 例如：
`insert into t_stu values(1,'张三','男','1995-05-09',89.5);`
```shell
mysql> insert into t_stu values(2,'李四',60);
ERROR 1136 (21S01): Column count doesn't match value count at row 1'
```
```mysql
insert into t_stu(sid,sname,score) values(2,'李四',60);

insert into t_stu values
(3,'王五','男','1993-05-09',80.5),
(4,'赵六','女','1992-05-09',82.5),
(5,'钱七','男','1991-05-09',82.5);

insert into t_stu(sid,sname,score) values
(6,'李六',60),
(7,'李七',70);
```
2. 修改
```mysql
update 【数据库名.】表名称
set 字段名1 = 新值,
字段名2 = 新值,
字段名3 = 新值
。。。
【where 条件】;
```
>说明：如果没有where条件，说明修改所有行的这几个字段的值

- 例如：修改所有人的成绩为80分
`update t_stu set score = 80;`
- 例如：修改李四的成绩为40分
`update t_stu set score = 40 where sname = '李四';`
- 例如：把没有填写性别的学生的性别都设置为'男'
`update t_stu set gender = '男' where gender <=> null;`
`update t_stu set gender = '男' where gender is null;`
- 例如：修改所有人的成绩都加10分
`update t_stu set score = score + 10;`
3. 删除数据
`delete from 表名称 【where 条件】;`
- 例如：删除所有数据，表结构还在
`delete from t_stu;`
- 例如：删除成绩是82.5的学生
`delete from t_stu where score = 82.5;`
4. 查询数据
- select * from 表名称;
- select * from 表名称 【where 条件】;
- select 字段列表 from 表名称 【where 条件】;
- 例如：查询全部
`select * from t_stu;`
- 例如：查询哪些学生没有填写性别
`select * from t_stu where gender is null;`
- 例如：查询没有填写性别的学生的姓名
`select sname from t_stu where gender is null;`
- 例如：查询没有填写性别的学生的姓名和成绩
`select sname,score from t_stu where gender is null;`
5. 查询时给字段取别名
- 字段名 as "别名"
- 其中：
- (1)如果""中的别名没有空格，可以省略""
- (2)这个as可以省略
- 例如：查询没有填写性别的学生的姓名和成绩，查询结果sname显示姓名，score显示成绩
`select sname as "姓名",score as "成绩" from t_stu where gender is null;`
`select sname 姓名,score 成绩 from t_stu where gender is null;`