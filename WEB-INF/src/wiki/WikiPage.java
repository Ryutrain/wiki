package wiki;

import java.sql.Timestamp;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WikiPage{
		//�y�[�W�̖��O
	private String name;
		
	//�y�[�W�̓��e
	private String content;
	
	//�X�V����
	private Timestamp updateTime;
	
	//IPadrress
	//private static InetAddress ip;
	private String ipaddress; // = ip.toString();
	
	//�폜�p�p�X���[�h
	
	private String delete_key;
	
	
	//���`���s�������e��Ԃ�
	public String getFormatedContent(){
		WikiFormater formater = new WikiFormater();
		return formater.formatText(content);
	}
	
	//�ȉ��̓Q�b�^�A�Z�b�^
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
	
	public String getDelete_Key(){
		return delete_key;
	}
	
	public void setDelete_Key(String delete_key){
		this.delete_key=delete_key;
	}
	
}