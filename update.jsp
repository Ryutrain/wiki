<%@ page language="java" contentType="text/html; charset=Windows-31J"
 pageEncoding="Windows-31J"%>
 <script>
	function check(){
		con = confirm('削除しますか?');
		if(con){
			$("#cmd").attr("value","delete");
		 }else{
		 	alert("削除はキャンセルしました");
		}
	}

</script>

<h1>${wikiPage.name}の編集</h1>
<form action = "update">
	<input type="HIDDEN" name="cmd" id="cmd" value=null/> 
	<input type="HIDDEN" name="name" value="${wikiPage.name}"/> 
	
	<textarea rows="15" COLS="60"
	name="content">${wikiPage.content}</textarea>
	
	<br>
	<input type="submit" value="更新" ONCLICK="cmd.value='update'"/>
	<input type="submit" value="削" ONCLICK="cmd.value='delete'"/>
	<input type="submit" value="削除"  ONCLICK="check();"/>
	<input type="submit" value="キャンセル" 
	onclick="location.href='refer'"/>
	
	</form>