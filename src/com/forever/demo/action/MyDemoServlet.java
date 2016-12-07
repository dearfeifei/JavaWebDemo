package com.forever.demo.action;

import com.forever.demo.json.core.ListObject;
import com.forever.demo.json.responseUtils.ResponseUtils;

import com.forever.demo.json.status.StatusHouse;
import com.forever.demo.json.utils.JackJsonUtils;
import com.forever.demo.model.Students;
import com.forever.demo.service.StudentServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Created by forever on 2016/12/7.
 */
public class MyDemoServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        List<Students> list = new StudentServiceImpl().getAllStudents();
        ListObject listObject=new ListObject();
        listObject.setItems(list);
        listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        String responseText = JackJsonUtils.toJson(listObject);
        ResponseUtils.renderJson(response, responseText);
    }
}
