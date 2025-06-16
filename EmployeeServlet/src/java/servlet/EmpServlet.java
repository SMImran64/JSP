/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Emp;

/**
 *
 * @author USER
 */
@WebServlet("/empServlet")
public class EmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            Emp emp = new Emp();
            emp.setName(request.getParameter("name"));
            emp.setEmail(request.getParameter("email"));
            emp.setDesignation(request.getParameter("designation"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));

            EmpDao.saveEmpDetails(emp);

            response.sendRedirect("index.jsp");

        } else if ("update".equals(action)) {

            Emp emp = new Emp();
            emp.setName(request.getParameter("name"));
            emp.setEmail(request.getParameter("email"));
            emp.setDesignation(request.getParameter("designation"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));
            emp.setId(Integer.parseInt(request.getParameter("id")));

            EmpDao.updateEmpDetails(emp);

            response.sendRedirect("index.jsp");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            EmpDao.deleteEmpDetails(Integer.parseInt(request.getParameter("id")));

            response.sendRedirect("index.jsp");
        } else if ("edit".equals(action)) {
            
            Emp e = EmpDao.getById(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("emp", e);
            request.getRequestDispatcher("editemp.jsp").forward(request, response);
        }

    }

}
