/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Emp;
import util.DbUtil;

/**
 *
 * @author USER
 */
public class EmpDao {
    
     static PreparedStatement ps;
    static String sql;
    static ResultSet rs;

    public static List<Emp> getAllEmp() {

        List<Emp> emps = new ArrayList<>();

        sql = "select * from emp";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Emp e = new Emp(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("designation"),
                        rs.getFloat("salary"));

                emps.add(e);

            }
            rs.close();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return emps;
    }

    public static int saveEmpDetails(Emp e) {

        int status = 0;
        sql = "insert into emp(name, email,designation,salary) values(?,?,?,?)";

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
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static void deleteEmpDetails(int id) {

        sql = "delete from emp where id = ?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Emp getById(int id) {

        Emp e = null;

        sql = "select * from emp where id = ?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                e = new Emp(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("designation"),
                        rs.getFloat("salary"));

            }

            rs.close();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;
    }

    public static int updateEmpDetails(Emp e) {

        int status = 0;

        sql = "update emp set name=?, email=?, designation=?,salary=? where id=?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDesignation());
            ps.setFloat(4, e.getSalary());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();
            System.out.println(status);
            
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
    
}
