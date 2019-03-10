<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
	session.invalidate();
	response.sendRedirect("index.jsp");
	return;%>