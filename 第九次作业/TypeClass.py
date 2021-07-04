def move(self,a):
    print(a+"自己走进了冰箱！")
def open(self,b):
    print(b+"打开了门")

Ele=type("Ele",(),{"name":"大象","move":move})
Fridge=type("Fridge",(),{"name":"冰箱","open":open})
ele=Ele()
fri=Fridge()
fri.open(fri.name)
ele.move(ele.name)

