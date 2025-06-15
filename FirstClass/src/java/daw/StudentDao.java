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

    public static List<Student> getAllStudent() {

        List<Student> students = new ArrayList<>();

        sql = "select * from students";

        try {
            ps = Dbutil.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contactNo"),
                        rs.getString("subject"),
                        rs.getString("gender"));
                students.add(s);
            }
            rs.close();
            ps.close();
            Dbutil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public static int saveAllStudent(Student s) {

        int status = 0;
        sql = "insert into students(name,email,contactNo,subject,gender) values(?,?,?,?,?)";

        try {
            ps = Dbutil.getCon().prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getContactNo());
            ps.setString(4, s.getSubject());
            ps.setString(5, s.getGender());

            status = ps.executeUpdate();

            System.out.println(status);

            ps.close();
            Dbutil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
