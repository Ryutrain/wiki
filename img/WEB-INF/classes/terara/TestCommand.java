package terara;

public class TestCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		String param1=reqc.getParameter("value1")[0];
		
		TestBean bean=new TestBean();
		
		resc.setResult(bean);
		
		resc.setTarget("show");
		
		return resc;
	}
}