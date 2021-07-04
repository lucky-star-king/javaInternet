n=3
account="xswl"
password="123qw"
while n>0:
    n-=1
    if(input("请输入账户：")==account and input("请输入密码:")==password):
        print("欢迎xswl")
        break
    elif n==0:
        print("登录超限，请明天再登录！！")
    else:print("你还有%d次机会"%n)