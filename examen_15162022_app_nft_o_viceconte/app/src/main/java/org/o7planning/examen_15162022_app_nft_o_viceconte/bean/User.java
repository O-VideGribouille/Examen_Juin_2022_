package org.o7planning.examen_15162022_app_nft_o_viceconte.bean;

import java.io.Serializable;

public class User implements Serializable{

    private int userId;
    private String userName;
    private String userMP;
    private int userNbTicket;
    //private int user;

    /*public User(int i, String string, String cursorString, int n)  {

    }*/
    public User()  {

    }

    public User(String userName, String userMP) {
        this.userName= userName;
        this.userMP= userMP;
    }

    public User(int userId, String userName, String userMP, int userNbTicket) {
        this.userId= userId;
        this.userName= userName;
        this.userMP= userMP;
        this.userNbTicket = userNbTicket;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserMP() {
        return userMP;
    }

    public void setUserMP(String userMP) {
        this.userMP = userMP;
    }

    public int getUserNbTicket() {
        return userNbTicket;
    }

    public void setUserNbTicket(int userNbTicket) {
        this.userNbTicket = userNbTicket;
    }




    @Override
    public String toString()  {
        return this.userName;
    }

}
