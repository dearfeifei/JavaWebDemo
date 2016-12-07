package com.forever.demo.action;

import com.forever.demo.business.StudentBusiness;
import com.forever.demo.json.core.ListObject;
import com.forever.demo.json.core.SingleObject;
import com.forever.demo.json.responseUtils.ResponseUtils;
import com.forever.demo.json.status.StatusCode;
import com.forever.demo.json.utils.JackJsonUtils;
import com.forever.demo.model.Students;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by forever on 2016/12/7.
 */
@Controller
public class StudentServlet {


    @RequestMapping("/getAllStudent")
    public void getAllStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Students> list = StudentBusiness.getAllStudents();
        ListObject listObject = new ListObject();
        listObject.setItems(list);
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("访问成功");
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(listObject));
    }

    @RequestMapping("/getStudent")
    public void getStudentById(HttpServletRequest request, HttpServletResponse response, String id) {
        id = "1";
        Students stu = StudentBusiness.getStudentInfoById(id);
        SingleObject singleObject = new SingleObject();
        singleObject.setObject(stu);
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("访问成功");
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
    }

}

