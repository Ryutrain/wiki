<link rel="stylesheet"type="text/css" href="css/create.css">

<div id="right">

<h1>�y�[�W�̈ꗗ</h1>
<c:forEach var="wikiPage" items="${list}">
<c:url value="/refer" var="url">
 <c:param name="name" value="${wikiPage.name}" />
 </c:url>
 <li><a href="${url}">${wikiPage.name}</a><br>
</c:forEach>


</div>
<div id="left">���j���[</div>


</div>
<div id="left">���j���[</div>

