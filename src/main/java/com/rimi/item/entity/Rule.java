package com.rimi.item.entity;

/**
 * 权限信息
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 21:57
 */
public class Rule {
    private Integer id;
    private String classifyname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", classifyname='" + classifyname + '\'' +
                '}';
    }
}
