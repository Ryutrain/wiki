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


<H1>${wikiPage.name}</H1>

${wikiPage.formatedContent}

<br>
<br>
<br>
<br>
<br>
<br>
最終更新日:${wikiPage.updateTime}<br>
最終編集者:${wikiPage.ipaddress}

<HR>
<form action = "update">
<input type="HIDDEN" name="cmd" id="cmd" value=null/> 
<input type="HIDDEN" name="name" value="${wikiPage.name}"/>


<input type="button" onclick="location.href='update.jsp'"value="編集"/>
	削除パス：<INPUT TYPE="password" maxlength='12' minlength='4' NAME="delete_key"/>
	<input type="submit" value="削除"  ONCLICK="check();"/>
</form>