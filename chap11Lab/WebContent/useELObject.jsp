<%@ page contentType = "text/html; charset=utf-8" %>
<%
	request.setAttribute("name", "최범균");
%>
<html>
<head><title>EL Object</title></head>
<body>

요청 URI: ${pageContext.request.requestURI}<br>
<%-- 요청 URI: <%= request.getRequestURI() %><br> --%>
request의 name 속성: ${requestScope.name}<br>
<%-- request의 name 속성 : <%=request.getAttribute("name") %><br> --%>
code 파라미터: ${param.code}

</body>
</html>
