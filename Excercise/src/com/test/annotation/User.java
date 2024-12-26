package com.test.annotation;


@Table("t_user")
public class User {
    @Column(name = "no",type = "int")
    private int id;
    @Column(name = "username",type = "varchar(20)")
    private String username;
    @Column(name = "password",type = "char(6)")
    private int password;
    @Column(name = "mail",type = "varchar(50)")
    private String mail;

    public User() {
    }

    public User(int id, String username, int password, String mail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", mail='" + mail + '\'' +
                '}';
    }
}
