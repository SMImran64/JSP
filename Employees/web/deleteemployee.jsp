
<jsp:useBean class="model.Employee"  id="e" />
<%@page  import="dao.EmployeeDao" %>
<jsp:setProperty  name="e" property="*" />

<%

EmployeeDao.deleteEmployeeDetails(e.getId());

response.sendRedirect("index.jsp");


%>