class Student:
    def __init__(self,name,score,age):
        self.name=name
        self.score=score
        self.age=age
    def printinfo(self):
        print("姓名:"+self.name+" 分数:"+str(self.score)," 年龄"+str(self.age))
students=[]
import random
for i in range(10):
    score=random.randint(0,100)
    age=random.randint(16,25)
    students.append(Student("李"+str(i),score,age))
students.sort(key=lambda s:s.score,reverse=True)
for i in students:
    i.printinfo()
print("_______________________")
scoremax=students[9].score
scoremin=students[0].score
for i in students:
    if i.score==scoremax or i.score==scoremin:
         students.remove(i)
for i in students:
    i.printinfo()