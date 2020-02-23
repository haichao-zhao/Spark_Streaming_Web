package com.zhc.spark.domain;

public class CourseClickCountEmpty {
    private String name;
    private Long value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CourseClickCountEmpty{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
