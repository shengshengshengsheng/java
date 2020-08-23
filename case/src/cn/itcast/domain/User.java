package cn.itcast.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
public class User implements Serializable {
    private String username;

    private String password;

    private Integer id;

    private Date birthday;

    private String sex;

    private String address;

    private Integer age;

    private String qq;

    private String email;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdayStr(){
        if(birthday == null){
            return null;
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(birthday);
        }
    }

    public User() {
    }

    public User(String userName, String passWord) {
        this.username = userName;
        this.password = passWord;
    }

    public User(String username, String password, Integer id, Date birthday, String sex, String address, Integer age, String qq, String email) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.age = age;
        this.qq = qq;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
