package wiki;

import java.sql.Timestamp;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WikiPage{
		//ページの名前
	private String name;
		
	//ページの内容
	private String content;
	
	//更新日時
	private Timestamp updateTime;
	
	//IPadrress
	//private static InetAddress ip;
	private String ipaddress; // = ip.toString();
	
	//整形を行った内容を返す
	public String getFormatedContent(){
		WikiFormater formater = new WikiFormater();
		return formater.formatText(content);
	}
	
	//以下はゲッタ、セッタ
	public String getContent(){
		return content;
	}
	public void setContent(String contents){
		this.content = contents;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Timestamp getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
	
	public String getIpaddress(){
		return ipaddress;
	}
	
	public void setIpaddress(String ipaddress){
		this.ipaddress=ipaddress;
	}
	
}