import csv
with open("student.csv","w",newline='') as f:
    write=csv.writer(f)
    wi=csv.DictReader(f)

    write.writerow(["学号","姓名","成绩"])
    liststu=[[10001,"小明",90],[10002,"小白",85],[10003,"小兰",83],[10004,"小张",92],[10005,"小赵",81]]
    write.writerows(liststu)
try:
    with open("D:\\student.csv","r") as f:
        read=csv.reader(f)
        for x in read:
            print(x)
except FileNotFoundError as e:
    print(e.strerror)
finally:
    print("这是一次异常测试")