'''这能有1和本身整除的整数叫素数；如一个素
数从左向右和从右向左是相同的数，则该素数为
回文素数。编程求出2-1000内的所有回文素数'''
m=True;
for x in range(2,1001):
    m = True;
    for y in range(2,x):
        if x%y==0:
           m=False
    if m==True:
        if str(x)[::-1]==str(x):
            print(x)
