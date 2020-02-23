package com.zhc.spark.dao;

import com.zhc.spark.domain.CourseClickCountEmpty;
import com.zhc.spark.utils.HBaseUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CourseClickCountDAO {

    public List<CourseClickCountEmpty> query(String day) throws Exception {

        ArrayList<CourseClickCountEmpty> list = new ArrayList<>();

        Map<String, Long> map = HBaseUtils.getInstance().query("imooc_course_clickcount", day);

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            CourseClickCountEmpty empty = new CourseClickCountEmpty();

            empty.setName(entry.getKey());
            empty.setValue(entry.getValue());

            list.add(empty);
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        CourseClickCountDAO dao = new CourseClickCountDAO();

        List<CourseClickCountEmpty> query = dao.query("20200223");
        for (CourseClickCountEmpty x : query) {
            System.out.println(x);
        }
    }

}
