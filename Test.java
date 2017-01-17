package wiki;

public class Test{
	public static void main(String[] args){
		String name=args[0];
		String content=args[1];
		try{
			byte[] byteData1 = name.getBytes("Shift_JIS");
			byte[] byteData2 = name.getBytes("Windows-31J");
			name = new String(byteData1, "Windows-31J");
		 	content = new String(byteData2, "Shift_JIS");
		}catch(Exception e){}
		
		
		WikiPage wikiPage= new WikiPage();
		wikiPage.setName(name);
		wikiPage.setContent(content);
		System.out.println(wikiPage.getName());
		System.out.println(wikiPage.getContent());
		//String s = WikiPage.getName();
		//System.out.println(s);
	}
}