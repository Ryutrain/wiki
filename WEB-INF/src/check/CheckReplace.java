package check;

import wiki.*;

import java.util.*;

public class CheckReplace{
	
	public static WikiPage check1(WikiPage wp){
		String name = wp.getName();
		
		String content = wp.getContent();
		String ipaddress = wp.getIpaddress();
		String delete_key = wp.getDelete_Key();
		
		name = name.replaceAll("'", "''");
		ipaddress = ipaddress.replaceAll("'", "''");
		content = content.replaceAll("'", "''");
		delete_key = delete_key.replaceAll("'", "''");
		
		wp.setName(name);
		wp.setIpaddress(ipaddress);
		wp.setContent(content);
		wp.setDelete_Key(delete_key);

		
		return wp;
	}
	
	public static WikiPage check(WikiPage wp){
		String delete_key = wp.getDelete_Key();
		
		delete_key = delete_key.replaceAll("'", "''");
		
		wp.setDelete_Key(delete_key);
		
		return wp;
	}
	
	//public static String check(String s){
		//String str = s;
		
		//str = str.replaceAll("<", "&lt;");
		//str = str.replaceAll(">", "&gt;");
		
		//return str;
	//}
	
}