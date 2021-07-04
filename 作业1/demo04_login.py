#while循环版
n=3
while n>0:
    name=input("请输入你的用户名:")
    password=input("请输入你的密码:")
    if name=="admin" and password=="123":
        print("登录成功!!!")
        break
    n-=1
    print("输入错误，你还有%d次机会"%n)
#for循环版
for x in range(3,0,-1):
    name = input("请输入你的用户名:")
    password = input("请输入你的密码:")
    if name=="admin" and password=="123":
        print("登录成功!!!")
        break
    print("输入错误，你还有%d次机会" % (x-1))