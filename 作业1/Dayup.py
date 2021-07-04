#假定初始值为1
a=1
n=1
while n<=365:
    a=a*1.01
    n+=1
print("累计进步",a)
a=1
n=1
while n<=365:
    a=a*0.99
    n+=1
print("累计剩下",a)