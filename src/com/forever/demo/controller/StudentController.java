package com.forever.demo.controller;

import com.forever.demo.business.StudentBusiness;
import com.forever.demo.json.core.ListObject;
import com.forever.demo.json.core.SingleObject;
import com.forever.demo.json.responseUtils.ResponseUtils;
import com.forever.demo.json.status.StatusCode;
import com.forever.demo.json.utils.JackJsonUtils;
import com.forever.demo.model.Students;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by forever on 2016/12/7.
 */

//朋友一定很好奇这个是干什么的，这个呢就是告诉spring这个类是Controller
@Controller
// 是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
@RequestMapping("Student")
public class StudentController {

    // value： 指定请求的实际地址；
// method： 指定请求的method类型， GET、POST、PUT、DELETE等；
    @RequestMapping(value = "/getAllStudent.json", method = RequestMethod.GET)
// 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
    @ResponseBody
// 那么我们要访问此方法是 完整路径应该是http://ip地址:端口/SpringMVC/HelloController/hello.json
    public Object getAllStudent() {
        List<Students> list = StudentBusiness.getAllStudents();
        ListObject listObject = new ListObject();
        listObject.setItems(list);
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("SUCCESS");

//        ResponseUtils.renderJson(response, JackJsonUtils.toJson(listObject));
        return JackJsonUtils.toJson(listObject);
    }

    // 路径参数{id}填入用户名id。我们设置为GET请求。
//    当使用@RequestMapping URI template 样式映射时， 即 /getStudent.json/{id},
    // 这时的id可通过 @Pathvariable注解绑定它传过来的值到方法的参数上。
    @RequestMapping(value = "/getStudent.json/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentById(@PathVariable("id") String id) {

        Students stu = StudentBusiness.getStudentInfoById(id);
        SingleObject singleObject = new SingleObject();
        singleObject.setObject(stu);
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("SUCCESS");

//        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return JackJsonUtils.toJson(singleObject);
    }

    /*
     * 只接收Post 请求
     */
    @ResponseBody
    @RequestMapping(value = "/getStudentPost.json", method = RequestMethod.POST)
    public String getStudentPost(@RequestParam String id) {

        Students stu = StudentBusiness.getStudentInfoById(id);
        SingleObject singleObject = new SingleObject();
        singleObject.setObject(stu);
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("SUCCESS");

//        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return JackJsonUtils.toJson(singleObject);
    }

}

