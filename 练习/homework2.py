import re as r
def count(string):
    list1=r.findall("\d",string,r.I)
    list2=r.findall(" ",string,r.I)
    list3=r.findall("[a-zA-Z]",string,r.I)
    a=len(list1)
    b=len(list3)
    c=len(list2)
    d=len(string)-a-b-c
    return a,b,c,d
print(count("dsfsf 454 g***"))
