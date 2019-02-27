package com.codeup.blog.models;
import javax.persistence.*;

@Entity

@Table(name="blogs")
public class Post {
    @Id @GeneratedValue
    private int id;

    @Column(nullable = false, length =512)
    private String title;

    @Column(nullable = false, length =512)
    private String body;


    public Post(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
