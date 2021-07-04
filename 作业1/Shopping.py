import math
a=eval(input("扫描第一个商品的价格"))
b=eval(input("扫描第二个商品的价格"))
c=eval(input("扫描第三个商品的价格"))
print("扫描第一个商品的价格:%.2f\n扫描第一个商品的价格:%.2f\n扫描第一个商品的价格:%.2f\n总计:%d"%(a,b,c,math.floor(a+b+c)))