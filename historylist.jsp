<h1>�X�V����</h1>
<c:forEach var="wikiPage" items="${historylist}">
<c:url value="/refer" var="url">
 <c:param name="updateTime" value="${wikiPage.updateTime}" /> 
 <c:param name="name" value="${wikiPage.name}" />
 </c:url>
 <li><a href="${url}">${wikiPage.name}</a> - ${wikiPage.updateTime} �ҏW�ҁF ${wikiPage.ipaddress}<br>
</c:forEach>