# import turtle
# bo=turtle.Turtle()
# bo.fd(20)
# bo.lt(90)
# turtle.mainloop()
import numpy
dd=numpy.array([(3,4,5),(4,5,6)])
m1=dd.shape
m2=dd.size
m3=dd.dtype
dd=numpy.array([3,4,55])
dd=numpy.array([[3,4,5],[4,53,3]])
dd=numpy.zeros((2,3))
dd=numpy.random.random(size=(4,5))
dd=numpy.linspace(4,30,6)
print(m1)
print(m2)
print(m3)
print(dd.ndim)
print(dd)
print(numpy.eye(3))
print("________________________")
print(numpy.array((2,3,4)))