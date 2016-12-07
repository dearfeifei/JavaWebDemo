package com.forever.demo.business;

import com.forever.demo.model.Students;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 */
public class StudentBusiness {

    /**
     * @return
     */
    public static List<Students> getAllStudents() {
        List<Students> list = new ArrayList<Students>();
        String sql = null;
        DBHelper db1 = null;
        sql = "select *from student_info";// SQL
        db1 = new DBHelper(sql);//
        ResultSet ret = null;
        try {
            ret = db1.pst.executeQuery();
            while (ret.next()) {

                int id = ret.getInt(1);
                String name = ret.getString(2);
                String sex = ret.getString(3);
                int number = ret.getInt(4);
                String email = ret.getString(5);
                String phone = ret.getString(6);
                String info = ret.getString(7);

                Students students = new Students();
                students.setId(id);
                students.setName(name);
                students.setSex(sex);
                students.setNumber(number);
                students.setEmail(email);
                students.setPhone(phone);
                students.setInfo(info);
                list.add(students);
            } //
            ret.close();
            db1.close();//
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //

        return list;
    }

    /**
     * @param _id
     * @return
     */
    public static Students getStudentInfoById(String _id) {
        String sql = null;
        DBHelper db1 = null;
        sql = "select * from student_info where id ='" + _id + "';";//
        db1 = new DBHelper(sql);//
        ResultSet ret = null;
        Students students = new Students();
        try {
            ret = db1.pst.executeQuery();
            while (ret.next()) {
                int id = ret.getInt(1);
                String name = ret.getString(2);
                String sex = ret.getString(3);
                int number = ret.getInt(4);
                String email = ret.getString(5);
                String phone = ret.getString(6);
                String info = ret.getString(7);

                students.setId(id);
                students.setName(name);
                students.setSex(sex);
                students.setNumber(number);
                students.setEmail(email);
                students.setPhone(phone);
                students.setInfo(info);
            } //
            ret.close();
            db1.close();//
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //
        return students;
    }
}
