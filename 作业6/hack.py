def hackmach(messge=''):
    anyu="OIZEYSGLBP"
    for x in messge:
     messge=messge.replace(x,anyu[eval(x)],1)
    return messge
print(hackmach("084300486"))