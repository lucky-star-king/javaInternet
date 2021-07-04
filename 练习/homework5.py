import pymysql
Db=pymysql.connect(host="localhost",port=3306,user="root",password="50qqww",database="student",charset="utf8")
cur=Db.cursor()
sqllist=['''create table scores(name varchar (64),major varchar (64),score int)'''
    ,'''insert into scores(name,major,score) values("陈晓","软件工程",92),("李娜","软件工程",86),("赵鹏","软件工程",69)''']
for x in sqllist:
    cur.execute(x)
Db.commit()
sql1='''select * from scores'''
cur.execute(sql1)
print(cur.fetchall())
sql3='''delete from scores where score<70'''
cur.execute(sql3)
Db.commit()
cur.execute(sql1)
print(cur.fetchall())
sql2="drop table scores"
cur.execute(sql2)
Db.commit()
print("执行完毕！")
