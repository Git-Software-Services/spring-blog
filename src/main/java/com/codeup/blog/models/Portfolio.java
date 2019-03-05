package com.codeup.blog.models;

import javax.persistence.*;

@Entity
    @Table(name="projects")
    public class Portfolio {

        @Id
        @GeneratedValue
        private int id;

        @Column(nullable = false, length =512)
        private String title;

        @Column(nullable = false, columnDefinition="TEXT")
        private String body;

        @Column
        private String image;


    @ManyToOne @JoinColumn (name = "user_id")
    private User user;




//    public List getImages() {
//        return images;
//    }
//
//    public void setImages(List<PostImage> images) {
//        this.images = images;
//    }

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Portfolio(){}

        public Portfolio(int id, String title, String body) {
            this.id = id;
            this.title = title;
            this.body = body;
        }

        public Portfolio(String title, String body, User user) {
            this.title = title;
            this.body = body;
            this.user = user;
        }

        public Portfolio(String title, String body, String image, User user) {
            this.title = title;
            this.body = body;
            this.image = image;
            this.user = user;
        }

        public Portfolio(int id, String title, String body, String image, User user) {
            this.id = id;
            this.title = title;
            this.body = body;
            this.image = image;
            this.user = user;
        }



    }
