import time
class Bankaccount:
    def __init__(self,money):
        self.money=money
        self.info=[]
    def withdraw(self,a):
        self.money=self.money-a
        self.info.append("交易日期:"+time.strftime("%Y-%m-%d",time.localtime())+"\t摘要:转出"\
                    +"\t金额:"+str(a)+"\t币种：人命币"+"\t余额："+str(self.money)+"\n")
    def save(self,b):
        self.money=self.money+b
        self.info.append("交易日期:" + time.strftime("%Y-%m-%d", time.localtime()) + "\t摘要:转入" \
                    + "\t金额:" + str(b) + "\t币种：人命币" + "\t余额：" + str(self.money)+"\n")
    def printinfo(self):
        for x in range(0,len(self.info)):
            print(self.info[x])

bankaccount1=Bankaccount(5000)
bankaccount1.save(20)
bankaccount1.withdraw(90)
bankaccount1.printinfo()
