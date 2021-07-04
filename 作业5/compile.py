import re
str1='''
<tbody><tr><td><span><span class="c-index  c-index-hot1 c-gap-icon-right-small">1</span>张婷婷</span></td><td class="oprtoplist-right">92<i class="opr-toplist-st c-icon c-icon-down"></i></td></tr>
<tr><td><span><span class="c-index  c-index-hot2 c-gap-icon-right-small">2</span>王华</span></td><td class="opr-toplist-right">91<i class="opr-toplist-st c-icon c-icon-down"></i></td></tr><tr><td><span><span class="c-index  c-index-hot3 c-gap-icon-right-small">3</span>张岚</span></td><td class="opr-toplist-right">90<i class="opr-toplist-st c-icon c-icon-down"></i></td></tr><tr><td><span><span class="c-index  c-gap-icon-right-small">4</span>孙鸿峰</span></td><td class="opr-toplist-right">90<i class="opr-toplist-st c-icon c-icon-down"></i></td></tr><tr><td><span><span class="c-index  c-gap-icon-right-small">5</span>周海栋</span></td><td class="opr-toplist-right">89<i class="opr-toplist-st c-icon c-icon-down"></i></td></tr><tr><td><span><span class="c-index  c-gap-icon-right-small">6</span>武静</span></td><td class="opr-toplist-right">88<i class="opr-toplist-st c-icon c-icon-down"></i></td></tr></tbody>'''
pattern1=re.compile(r">(\d)<.*?>(\S{2,3})<.*?>(\d{2})<")
iter=pattern1.finditer(str1)
for x in iter:
	print("序号:",x.group(1)," 姓名:",x.group(2)," 分数:",x.group(3))
	#print(x.group(0))
#print(pattern1.(str1).groups())
#print()

