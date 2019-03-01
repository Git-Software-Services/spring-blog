package com.codeup.blog.models;

import javax.persistence.*;

    @Entity
    @Table(name="projects")
    public class Portfolio {

        @Id
        @GeneratedValue
        private int portId;

        @Column(nullable = false, length =512)
        private String portTitle;

        @Lob
        @Column(nullable = false, columnDefinition="BLOB")
        private String portBody;

        @Column
        private String portImage;


        public int getPortId() {
            return portId;
        }

        public void setPortId(int portId) {
            this.portId = portId;
        }

        public String getPortTitle() {
            return portTitle;
        }

        public void setPortTitle(String portTitle) {
            this.portTitle = portTitle;
        }

        public String getPortBody() {
            return portBody;
        }

        public void setPortBody(String portBody) {
            this.portBody = portBody;
        }

        public String getPortImage() {
            return portImage;
        }

        public void setPortImage(String portImage) {
            this.portImage = portImage;
        }

        public Portfolio(){}

        public Portfolio(int portId, String portTitle, String portBody) {
            this.portId = portId;
            this.portTitle = portTitle;
            this.portBody = portBody;
        }

        public Portfolio(String portTitle, String portBody) {
            this.portTitle = portTitle;
            this.portBody = portBody;
        }

        public Portfolio(String portTitle, String portBody, String portImage) {
            this.portTitle = portTitle;
            this.portBody = portBody;
            this.portImage = portImage;
        }

        public Portfolio(int portId, String portTitle, String portBody, String portImage) {
            this.portId = portId;
            this.portTitle = portTitle;
            this.portBody = portBody;
            this.portImage = portImage;
        }


    }
