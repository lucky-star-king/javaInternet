import re
pattern1=re.compile("1[3456789]{2}\d{8}")
pattern2=re.compile("[\da-zA-Z]\w{7,9}")//密码不能用下划线开头
pattern3=re.compile("^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})(X|\d)$")
pattern4=re.compile("\d+(\.\d+)?")
pattern5=re.compile("([1-9][0-9]{3})-((0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]))")