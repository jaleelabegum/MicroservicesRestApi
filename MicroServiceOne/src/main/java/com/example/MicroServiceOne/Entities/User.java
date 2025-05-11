package com.example.MicroServiceOne.Entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="usersdetails")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="UserName")
    private String name;

    @Column(name="UserMailid")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="Age")
    private Integer age;

    @Column(name="City")
    private String city;

    @Column(name="Country")
    private String country;
    @Id
    private Integer uuid;

    public User(String name, String email, String password, Integer age, String city, String country, Integer uuid) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.city = city;
        this.country = country;
        this.uuid = uuid;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tasks> tasks;

    @OneToMany
    @JoinColumn(name = "ForeignerKeyUser", referencedColumnName = "UserMailid")
    private List<Tasks> task;
}
