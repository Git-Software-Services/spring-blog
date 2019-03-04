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
    private String quote;

    @Column(nullable = false, length =512)
    private String author;

    @Column(nullable = false, columnDefinition="TEXT")
    private String body;

    @Column
   private String image;





    public Post(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, String quote, String author, String image) {
        this.title = title;
        this.body = body;
        this.quote = quote;
        this.author = author;
        this.image = image;
    }

    public Post(String title, String body, String quote, String author) {
        this.title = title;
        this.body = body;
        this.quote = quote;
        this.author = author;
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

    public void setBody(String body) { this.body = body; }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
