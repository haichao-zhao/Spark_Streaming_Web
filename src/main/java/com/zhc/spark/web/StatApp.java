package com.zhc.spark.web;

import com.zhc.spark.dao.CourseClickCountDAO;
import com.zhc.spark.domain.CourseClickCountEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StatApp {

    private static Map<String, String> courses = new HashMap<>();

    static {
        courses.put("112", "Spark SQL慕课网日志分析");
        courses.put("128", "10小时入门大数据");
        courses.put("145", "深度学习之神经网络核心原理与算法");
        courses.put("146", "强大的Node.js在Web开发的应用");
        courses.put("131", "Vue+Django实战");
        courses.put("130", "Web前端性能优化");
    }

    @Autowired
    CourseClickCountDAO courseClickCountDAO;

    @ResponseBody
    @RequestMapping(value = "/course_clickcount", method = RequestMethod.POST)
    public List<CourseClickCountEmpty> courseClickCount() throws Exception {


        List<CourseClickCountEmpty> list = courseClickCountDAO.query("20200223");

        for (CourseClickCountEmpty empty : list) {
            String s = empty.getName().split("_")[1];
            empty.setName(courses.get(s));
        }

        return list;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("index");

        return view;
    }
}
