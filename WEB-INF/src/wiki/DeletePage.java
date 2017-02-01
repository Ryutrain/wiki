package wiki;

public class DeletePage{
	private String name;
	private String delete_key;

	public void setName(String name){
		this.name = name;
	}
	public void setDelete_key(String delete_key){
		this.delete_key = delete_key;
	}

	public String getName(){
		return name;
	}
	public String getDelete_key(){
		return delete_key;
	}
}