import matplotlib.pyplot as mat
import numpy as nu
mat.rcParams['font.sans-serif'] = ['SimHei']
x=nu.linspace(1,10,10)
mat.subplot(121)
mat.plot(x,x*x)
mat.subplot(122)
mat.title("销售子图")
data=[200,300,100,500]
labels=["第1季度","第2季度","第3季度","第4季度"]
mat.bar(range(len(data)),data,tick_label=labels)
mat.show()