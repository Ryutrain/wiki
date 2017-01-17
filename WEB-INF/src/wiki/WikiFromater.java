package wiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiFormater{
	public String formatText(String text){
		
		test = escapeHtmlTags(text);
		test = createHyperLink(text);
		test = addBrToEachLines(text);
		return text;
	}
	
	//<BR>タグの追加
	private String addBrToEachLines(String text){
		
		text = text.replaceAll("[\n]","<BR>\n");
		return text;
	}
	
	//<.>、タグの変換
	private String escapeHtmlTags(String text){
		
		text = text.replaceAll("<","&lt");
		text = text.replaceAll(">","&gt");
		text = text.replaceAll("\t","	");
		return text;
	}
	
	//リングの生成
	private String createHyperLink(String text){
		Pattern pattern = Pattern.compile(
					"(mailto|http|https|ftp):\\/\\/([^\\s]+)");
		Matcher matcher = pattern.matcher(text);
		StringBuffer sb = new StringBuffer();
		
		while(matcher.find()){
			String group = matcher.group();
			String repText = "<A HREF = \"" + group + "\">"
							+ group +
							"</A>";
			matcher.appendReplacement(sb, repText);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
}