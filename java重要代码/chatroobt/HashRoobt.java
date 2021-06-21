import java.util.Hashtable;

public class HashRoobt {
	
private Hashtable<String,String> Mess=new Hashtable<>();
public String Getmessage(String info) {
	if (Mess.containsKey(info)){
	return Mess.get(info);
	}else {
		return "我也不知道了呢!!!";
	}
}
//public void JudgeOddEve() {
//	
//}
public HashRoobt() {
	Mess.put("你今天吃饭了吗", "没吃呢，你呢");
	Mess.put("一言", "You complete me !");
	Mess.put("舔狗日记", "玲珑骰子安红豆，入骨相思知不知。");
	Mess.put("优美诗句", "长风几万里，吹度玉门关。\r\n"
			+ "关山月--李白");
	Mess.put("彩虹屁", "多看你一眼就心软，拥抱一下就沦陷");
	Mess.put("毒鸡汤","努力吧，不然以后你的自拍照，可能会变成你的全家福。");
}
}
