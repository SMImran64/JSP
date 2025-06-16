
<jsp:useBean class="model.Student" id="s" />
<%@page import="daw.StudentDao" %>
<jsp:setProperty name="s" property="*" />


<%

StudentDao.deleteStudentDetails(s.getId());
response.sendRedirect("index.jsp");


%>