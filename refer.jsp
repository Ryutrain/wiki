<script>
	function check(){
		con = confirm('�폜���܂���?');
		if(con){
			$("#cmd").attr("value","delete");
		 }else{
		 	alert("�폜�̓L�����Z�����܂���");
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
�ŏI�X�V��:${wikiPage.updateTime}<br>
�ŏI�ҏW��:${wikiPage.ipaddress}

<HR>
<form action = "update">
<input type="HIDDEN" name="cmd" id="cmd" value=null/> 
<input type="HIDDEN" name="name" value="${wikiPage.name}"/>


<input type="button" onclick="location.href='update.jsp'"value="�ҏW"/>
	�폜�p�X�F<INPUT TYPE="password" maxlength='12' minlength='4' NAME="delete_key"/>
	<input type="submit" value="�폜"  ONCLICK="check();"/>
</form>