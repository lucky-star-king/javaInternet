def Stringcounter(stri=""):
    list1=list(stri)
    up=0
    low=0
    for x in list1:
        if x>='a' and x<='z':
            low+=1
        elif x>'A'and x<'Z':
            up+=1
        else:pass
    return up,low
print(Stringcounter("WninfisnafsI"))