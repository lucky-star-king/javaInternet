list=[eval(input("请输入第一个数字:")),eval(input("请输入第二个数字:"))]
x=int(input("请输入你想取数列的前多少位"))
n=2
while n<x:
    list.append(list[n-1]+list[n-2])
    n+=1
print(list)