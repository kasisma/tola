package com.example.tola.Data;

import java.io.Serializable;

public class PlanData implements Serializable {
  private   String title;
   private String content;
  private   String date;

    public PlanData(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
