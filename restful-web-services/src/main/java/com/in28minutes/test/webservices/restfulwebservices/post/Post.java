package com.in28minutes.test.webservices.restfulwebservices.post;

public class Post {
    private Integer id;
    private Integer userId;
    private String subject;
    private String Description;

    public Post(Integer id, Integer userId, String subject, String description) {
        super();
        this.id = id;
        this.userId = userId;
        this.subject = subject;
        Description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", subject='" + subject + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}

