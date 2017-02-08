<link rel="stylesheet"type="text/css" href="css/create.css">

<<<<<<< HEAD

=======
<div id="right">
>>>>>>> 749b0ea14311c4b1c2f9f3e858d68b7a8f1b9154
<h1>ページの一覧</h1>
<c:forEach var="wikiPage" items="${list}">
<c:url value="/refer" var="url">
 <c:param name="name" value="${wikiPage.name}" />
 </c:url>
 <li><a href="${url}">${wikiPage.name}</a><br>
</c:forEach>
<<<<<<< HEAD
=======
</div>
<div id="left">メニュー</div>
>>>>>>> 749b0ea14311c4b1c2f9f3e858d68b7a8f1b9154
