firend_list=[]
firend_list_Pro={}
control=True
def addFirend():
    Str=input("请输入你想添加朋友的名字！")
    firend_list.append(Str)
    print("添加完毕！")
def delFirend():
    Str=input("请输入你想删除朋友的名字！")
    firend_list.pop(firend_list.index(Str))
    print("删除完毕！")
def asname():
    str1=input("请输入你想备注好友的名字：")
    Str2=input("请输入你想备注的名称：")
    global firend_list_Pro
    if len(firend_list_Pro)==0:
        firend_list_Pro={}.fromkeys(firend_list)
        firend_list_Pro[str1]=Str2
    else:
        firend_list_Pro[str1]=Str2
def showname():
    if len(firend_list_Pro) == 0:
        print(firend_list)
    else:print(firend_list_Pro)
def exitp():
    print("退出程序！")
    global control
    control=False
chooses={"1":addFirend,"2":delFirend,"3":asname,"4":showname,"5":exitp}
while control:
    print('''菜单
    1.添加好友
    2.删除好友
    3.备注好友
    4.展示好友
    5.退出程序''')
    choose=input("")
    func=chooses.get(choose,lambda :"")
    func()
