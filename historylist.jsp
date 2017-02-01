<h1>更新履歴</h1>
<c:forEach var="wikiPage" items="${historylist}">
<c:url value="/refer" var="url">
 <c:param name="updateTime" value="${wikiPage.updateTime}" /> 
 <c:param name="name" value="${wikiPage.name}" />
 </c:url>
 <li><a href="${url}">${wikiPage.name}</a> - ${wikiPage.updateTime} 編集者： ${wikiPage.ipaddress}<br>
</c:forEach>