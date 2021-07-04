a=eval(input("请输入你的身高:"))
b=eval(input("请输入你的体重:"))
BMI=b/(a**2)
print("你的BMI指数为:%f   "%BMI,end="")
if BMI<18.5:
    print("过轻!!!")
elif BMI<23.9:
    print("正常!!!")
elif BMI<27:
    print("过重!!!")
elif BMI<32:
    print("肥胖!!!")
else:print("非常肥胖!!!")

