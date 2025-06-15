<jsp:useBean class="model.Employee" id="e" />
<%@page import="dao.EmployeeDao" %>
<jsp:setProperty name="e" property="*" />


<% 

int result = EmployeeDao.saveEmployeeDetails(e);
if(result > 0){
    response.sendRedirect("success.jsp");
    
    
    }
    else{
    
    response.sendRedirect("error.jsp");
    
    }

%>