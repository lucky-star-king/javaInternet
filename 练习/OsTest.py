# import os
# print(os.path.abspath("."))
# print(os.path.split(os.getcwd()+os.sep+'ni.txt'))
import csv
list1=["姓名","分数"]
list2=[{"姓名":"吕布","分数":20},{"姓名":"貂蝉","分数":30}]
with open('stu.csv',"r") as f:
    write1=csv.DictReader(f,fieldnames=list1)
    write1.writeheader
    # write1.writerows(list2)
# with open("stu.csv") as f:
#     f.readlines()