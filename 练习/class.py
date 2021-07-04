class Student():
    def __init__(self):
        print("__init__方法被调用！！！")
    def __new__(cls, *args, **kwargs):
        print("__new__方法被调用！！！")
    def __call__(self, *args, **kwargs):
        print("__call__方法被调用！！！")

