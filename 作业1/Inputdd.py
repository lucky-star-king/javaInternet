# name=input("请输入姓名")
# gender=input("请输入你的性别")
# age=input("请输入你的年龄")
info=dict({"name":input("请输入姓名:"),"gender":input("请输入性别:"),\
           "age":input("请输入年龄:"),"blood":input("请输入血型:"),\
           "height":input("请输入身高:"),"tel":input("请输入电话:"),"birth":input("请输入出生日期:")})
print("姓名:%s\n性别:%s\n年龄:%d\n血型:%s\n身高:%f\n电话:%d\n出生日期:%d"%(info["name"],info["gender"],\
               eval(info["age"]),info["blood"],eval(info["height"]),\
                eval(info["tel"]),eval(info["birth"])))