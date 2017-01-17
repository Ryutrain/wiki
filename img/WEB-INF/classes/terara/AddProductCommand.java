package terara;

public class AddProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		String name=reqc.getParameter("name")[0];
		String price=reqc.getParameter("price")[0];
		
		Product bean=new Product();
		
		bean.setName(name);
		bean.setPrice(price);
		
		DbDummy.addProduct(bean);
		resc.setTarget("start");
		
		return resc;
	}
}