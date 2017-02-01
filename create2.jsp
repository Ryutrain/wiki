<%@ page language="java" contentType="text/html; charset=Windows-31J"
 pageEncoding="Windows-31J"%>
<link rel="stylesheet"type="text/css" href="css/create.css">


<H1>${param.name}の作成</H1>

<FORM ACTION="create">

	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}">
	
	<TEXTAREA ROWS="15" COLS="60" NAME="content"></TEXTAREA>
	
	<BR>
	削除パス：<INPUT TYPE="password" maxlength='12' minlength='4' NAME="delete_key"><br>
	<INPUT TYPE="SUBMIT" VALUE="作成">
	<INPUT TYPE="BUTTON" VALUE="キャンセル" ONCLICK="location.href='refer'">
	
	
<br/>
<br/>
以下の内容を含む投稿を禁止する事を了承する人だけ編集してください。<br/>
			・日本及び各国の法律・法令・条例に違反するような内容<br/>
			・誹謗中傷や他人への不快感・精神的影響を与える内容<br/>
			・論理的観点から問題のある内容<br/>
			
作成すると作成した人のIPアドレスが公開されます。<br/>

</FORM>

