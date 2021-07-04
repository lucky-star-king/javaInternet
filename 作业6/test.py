# def printname(name="mmi"):
#     print(name)
# # printname()
# def rever(a,b):
#     a,b=b,a
# a,b=1,2
# rever(1,2)
# print(a,b)
# def summ(*args):
#     m=0
#     for x in args:
#         m+=x
#     print(m)
# li=[1,2,4,5,6,23,4]
# summ(*li)
def fi(n):
    if n==1:
        return 0
    return  1 if (n==2 or n==3) else fi(n-1)+fi(n-2)
print(fi(6))
