package com.forever.demo.service;

import com.forever.demo.business.StudentBusiness;
import com.forever.demo.model.Students;

import java.util.List;

/**
 * Created by forever on 2016/12/7.
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Students> getAllStudents() {
        // TODO Auto-generated method stub
        return StudentBusiness.getAllStudents();
    }

}
