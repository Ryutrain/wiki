<%@ page language="java" contentType="text/html; charset=Windows-31J"
 pageEncoding="Windows-31J"%>
<link rel="stylesheet"type="text/css" href="css/create.css">


<H1>${param.name}�̍쐬</H1>

<FORM ACTION="create">

	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}">
	
	<TEXTAREA ROWS="15" COLS="60" NAME="content"></TEXTAREA>
	
	<BR>
	�폜�p�X�F<INPUT TYPE="password" maxlength='12' minlength='4' NAME="delete_key"><br>
	<INPUT TYPE="SUBMIT" VALUE="�쐬">
	<INPUT TYPE="BUTTON" VALUE="�L�����Z��" ONCLICK="location.href='refer'">
	
	
<br/>
<br/>
�ȉ��̓��e���܂ޓ��e���֎~���鎖�𗹏�����l�����ҏW���Ă��������B<br/>
			�E���{�y�ъe���̖@���E�@�߁E���Ɉᔽ����悤�ȓ��e<br/>
			�E��排����⑼�l�ւ̕s�����E���_�I�e����^������e<br/>
			�E�_���I�ϓ_������̂�����e<br/>
			
�쐬����ƍ쐬�����l��IP�A�h���X�����J����܂��B<br/>

</FORM>

