package com.example.tola.Data;

import java.io.Serializable;

public class PostData implements Serializable {
    String title;
    String content;
    String postImage;
    String user;
    String date;

    public PostData(String title, String content, String postImage, String user, String date) {
        this.title = title;
        this.content = content;
        this.postImage = postImage;
        this.user = user;
        this.date = date;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
