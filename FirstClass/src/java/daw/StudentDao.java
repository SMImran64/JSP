package daw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.Dbutil;

public class StudentDao {
    
    
    static PreparedStatement ps;
    static String sql;
    static ResultSet rs;

    public static List<String> getAllStudent() {

        List<Student> students = new ArrayList<>();

        sql = "select * from student";  
        
        try {
            ps = Dbutil.getCon().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                
                Student s = new Student(sql, 
                        sql,
                        sql,
                        sql,
                        sql, 
                        sql);
            
                
            
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    

    }

}
