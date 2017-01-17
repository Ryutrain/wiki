package tera;
import java.util.Map;

public abstract class AbstractCommand{
	private Map parameters;
	private Object result;
	
	public void init(Map parameters){
		this.parameters = parameters;
	}
	public Object getResult(){
		return result;
	}
	protected void setResult(Object data){
		this.result=data;
	}
	protected Map getParameters(){
		return parameters;
	}
	
	public abstract String execute();
}
