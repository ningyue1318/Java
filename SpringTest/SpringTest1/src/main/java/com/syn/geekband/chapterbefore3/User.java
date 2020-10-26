package com.syn.geekband.chapterbefore3;


import com.syn.geekband.chapter11.Company;

public class User {
    private Long id;
    private String name;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUser(){
        User user = new User();
        user.setName("静态方法创建的user");
        user.setId(2L);
        return user;
    }
}
