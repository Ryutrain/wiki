public abstract class AbstractCommand{
	private RequestContext _reqContext;
	
	public void init(RequestContext reqc){
		_reqContext=reqc;
	}
	public RequestContext getRequestContext(){
		return _reqContext;
	}
	public abstract ResponseContext execute();
}