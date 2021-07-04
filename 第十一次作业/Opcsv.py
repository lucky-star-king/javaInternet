# import csv
# with open("student.csv","w",newline='') as f:
#     write=csv.writer(f)
#     write.writerow(["学号","姓名","成绩"])
#     liststu=[[10001,"小明",90],[10002,"小白",85],[10003,"小兰",83],[10004,"小张",92],[10005,"小赵",81]]
#     write.writerows(liststu)
# with open("student.csv","r") as f:
#     read=csv.reader(f)
#     for x in read:
#         print(x)
#     # print(list(read))
##########################################################
# import csv
# list1=["姓名","分数"]
# list2=[{"姓名":"吕布","分数":20},{"姓名":"貂蝉","分数":30}]
# with open('stu.csv',"w",newline="") as f:
#     write1=csv.DictWriter(f,fieldnames=list1)
#     write1.writeheader()
#     write1.writerows(list2)
# with open("stu.csv") as f:
#     print(f.readlines())
#############################################
list1=["fdsfsd\n","fdsfsdf","fdsfsddf"]
with open("stud.csv","w")as f:
    f.write("fdsfsd")
    print(f.writable())
    f.writelines(list1)
with open("stud.csv") as f:
    print(f.read())