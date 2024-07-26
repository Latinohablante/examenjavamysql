package com.examen.persons.domain.entity;

public class Person {
    private Long id;
    private String name;
    private String lastname;
    private Integer idcity;
    private String address;
    private Integer age;
    private String email;
    private Integer idgender;
    
    public Person(Long id, String name, String lastname, Integer idcity, String address, Integer age, String email,
            Integer idgender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.idcity = idcity;
        this.address = address;
        this.age = age;
        this.email = email;
        this.idgender = idgender;
    }

    public Long getId() {
        return id;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getIdcity() {
        return idcity;
    }

    public void setIdcity(Integer idcity) {
        this.idcity = idcity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdgender() {
        return idgender;
    }

    public void setIdgender(Integer idgender) {
        this.idgender = idgender;
    }
    

    
    
}
