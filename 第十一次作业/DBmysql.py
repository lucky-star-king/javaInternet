import pymysql
Db=pymysql.connect(host="localhost",user="root",password="50qqww",port=3306,database="info",charset="utf8")
cur=Db.cursor()
sql="select * from login"
sql2='''CREATE TABLE login
(
num int,
Name varchar(64),
score int
)'''
sql3='''insert into login(num,Name,score) values(10001,"小明",90),(10002,"小白",85),(10003,"小兰",83),(10004,"小张",92),(10005,"小赵",81)'''
cur.execute(sql2)
cur.execute(sql3)
Db.commit()
cur.execute(sql)
print(cur.fetchall())
cur.close()
Db.close()