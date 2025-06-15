
<jsp:useBean class="model.Student" id="s" />
<%@page import="daw.StudentDao" %>
<jsp:setProperty name="s" property="*" />

<% 

int result = StudentDao.saveAllStudent(s);
if(result > 0){
    
    respose.sendRedirect("index.jsp");
    
    }
    else{
     respose.sendRedirect("error.jsp");
    
    }


%>