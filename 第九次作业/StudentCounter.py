class student:
    counter=0
    def __new__(cls,name):
        cls.counter+=1
        return cls
    def __init__(self, name):
        self.name=name


student1=student("小猪")
student2=student("小李")
print("已经实例化的学生"+str(student.counter))