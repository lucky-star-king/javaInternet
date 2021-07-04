Str=input("请输入一定金额,不大于5位数:")
a=['零','壹','贰','叁','肆','伍','陆','柒','捌','玖']
b=['圆','拾','佰','仟','萬']
#统计有几位数字
money=eval(Str)
num=0
while money>0:
    money=int(money/10)
    num+=1
#提取出来每一位数字并把他们放入数组中
numlist=[]
for x in range(0,num):
    m=int((eval(Str)/(10**x))%10)
    numlist.append(m)
print("用汉字表示是:",end="")
for j in numlist[::-1]:
    print("%s%s"%(a[j],b[num-1]),end="")
    num-=1

