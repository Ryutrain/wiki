package terara;

public class GetProductsCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setResult(DbDummy.getDatabase());
		
		resc.setTarget("view");
		return resc;
	}
}