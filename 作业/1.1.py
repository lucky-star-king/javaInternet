#1
print("两个数字的和是：",int(input("请输入第一个数字\n"))+int(input("请输入第二个数字\n")))
#2
a,b,c,d="A","B","C","D"
print(a,b,c,d)
print("%s,%s,%s,%s"%(a,b,c,d))
#3
hell="Hello World!"
print(hell[::-1])
#4
if int(input("请输入一个数字\n"))%2==0:print("这是一个偶数")
else:print("这是一个奇数")
#5
n=int(input("请输入你想输入的数字\n"))
a=1
while n>0:
    a*=n
    n-=1
print("阶乘是%d"%(a))
#6
data=[23,4,6,9,2,11,20]
i,j=0,0
while i<len(data):
    while j<len(data)-i-1:
        if data[j]<=data[j+1]:
            data[j],data[j+1]=data[j+1],data[j]
        j += 1
    i += 1
    j=0
print("冒泡排序",data)
