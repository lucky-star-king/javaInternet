def cacluate(*args):
   sum=0
   for x in args:
       sum+=x
   avg=sum/len(args)
   num=0
   for x in args:
       if x>avg:
           num+=1
   return  avg ,num
#if _name_=='_main_':
print(cacluate(2,4,5))