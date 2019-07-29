package com.example.lenovo.gardenclub;

/**
 * Created by Joe on 3/19/2018.
 */

public class Contacts {
    private String name, email, mobile, mbrStatus, userID, loginEmail, photoID;

    public Contacts (String name, String email, String mobile, String mbrStatus, String userID, String loginEmail, String photoID) {
        this.setName(name);
        this.setEmail(email);
        this.setMobile(mobile);
        this.setMbrStatus(mbrStatus);
        this.setUserID(userID);
        this.setLoginEmail(loginEmail);
        this.setPhotoID(photoID);

    }

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getMbrStatus() {
        return mbrStatus;
    }

    public void setMbrStatus(String mbrStatus) {
        this.mbrStatus = mbrStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
