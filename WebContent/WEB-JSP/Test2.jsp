<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<%!
private Date date=new Date();
public String showTime(int hour){
	if(hour<12){
		return "���Ϻã�";
	}else if(hour<18){
		return "����ã�";
	}else{
		return "���Ϻã�";
	}
}
%>
<%
	String infor=showTime(date.getHours());
	if(infor!=null){
%>
		<p>����ʱ��Ϊ��<%=date.getHours() %>�㣬�õ����ʺ���<%=infor %></p>
<%
	}
%>
</body>
</html>