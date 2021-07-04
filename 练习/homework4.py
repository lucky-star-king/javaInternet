#首先构建csv文件
import csv
listdict= [{'学号': '1445204009', '姓名': '王召', '平时成绩': '100', '期末成绩': '90'},
           {'学号': '1445204013', '姓名': '林锦', '平时成绩': '95', '期末成绩': '67'}]
header=["学号","姓名","平时成绩","期末成绩"]
with open("StudentInfo.csv","w",newline='') as f:
    writer=csv.DictWriter(f,fieldnames=header)
    writer.writeheader()
    writer.writerows(listdict)
from json import loads, dumps
with open("StudentInfo.csv","r") as f:
    reader=csv.DictReader(f)
    for x in reader:
        print(loads(dumps(x)))
