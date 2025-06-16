<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Emp"%>
<%@page import="dao.EmpDao"%>
<%@page import="java.util.*"%>

 
<%@include file="header.jsp" %>


<%
 List<Emp> list=EmpDao.getAllEmp();
 request.setAttribute("list", list);

%>

<div class="container">



    <h1 class="text-primary text-center"> Employee Details</h1> 

    <table class="table table-striped">

        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Designation</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${list}" var="e">
                <tr>
                    <td>${e.getId()}</td>
                    <td>${e.getName()}</td>
                    <td>${e.getEmail()}</td>
                    <td>${e.getDesignation()}</td>
                    <td>${e.getSalary()}</td>
                    <td>
                        <a href="empServlet?action=edit&id=${e.id}" class="btn btn-primary">Edit</a>
                        
                        <a href="empServlet?action=delete&id=${e.id}" class="btn btn-danger"
                           onclick="return confirm('Are you sure');">Delete</a>
                    </td>

                </tr>

            </c:forEach>

        </tbody>


    </table>

</div>





<%@include file="footer.jsp" %>
