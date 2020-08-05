package com.example.tola.Data;

public class FamilyData {
   private String name;
   private String phonNumber;
   private int familyImage;

    public FamilyData(String name, String phonNumber, int familyImage) {
        this.name = name;
        this.phonNumber = phonNumber;
        this.familyImage = familyImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public int getFamilyImage() {
        return familyImage;
    }

    public void setFamilyImage(int familyImage) {
        this.familyImage = familyImage;
    }
}
