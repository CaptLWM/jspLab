<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="util.Cookies"%>
<%
	session.invalidate();
	response.sendRedirect("../login/loginForm.jsp");
%>
