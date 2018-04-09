package com.tream.property;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties( prefix = "test" )
public class TestProperty {

    private Integer id;
    private Integer age;
    private String name;
    private String date;

    public TestProperty() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestProperty{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
