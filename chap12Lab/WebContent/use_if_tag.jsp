<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- c태그 사용할때 반드시 추가 해야함 -->
<%@ import %>
<html>
<head>
<title>if 태그</title>
</head>
<body>
	<c:if test="true">
		무조건 수행<br>
	</c:if>

	<c:if test="${param.name == 'bk'}">
		name 파라미터의 값이 ${param.name} 입니다.<br>
	</c:if>

	<c:if test="${18 < param.age}">
	<%-- 	<c:if test=<%=18<Integer.parseInt(request.getParameter("age")) %>> --%>
    <%-- 	</c:if> --%>
		당신의 나이는 18세 이상입니다.
	</c:if>
</body>
</html>
