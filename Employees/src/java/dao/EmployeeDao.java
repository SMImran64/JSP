package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import util.DbUtil;

public class EmployeeDao {

    static PreparedStatement ps;
    static String sql;
    static ResultSet rs;
    
    public static List<Employee> getAllEmployee(){
    
    List<Employee> employees = new ArrayList<>();
    
    sql = "select * from employees";
    
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            
            while(rs.next()){
            
                Employee e = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("designation"),
                        rs.getFloat("salary"));
                
                employees.add(e);
            
            }
            rs.close();
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return employees;
    }
    
    
    public static int saveEmployeeDetails(Employee e){
    
        int status = 0;
        sql = "insert into employees(name, email,designation,salary) values(?,?,?,?)";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDesignation());
            ps.setFloat(4, e.getSalary());
            
            status = ps.executeUpdate();
            
            System.out.println(status);
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return status;
    }
    
    public static void deleteEmployeeDetails(int id){
    
    
        sql = "delete from employees where id = ?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
}
