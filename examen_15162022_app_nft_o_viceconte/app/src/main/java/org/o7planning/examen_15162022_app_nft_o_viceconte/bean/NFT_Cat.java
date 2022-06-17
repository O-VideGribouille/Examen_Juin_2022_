package org.o7planning.examen_15162022_app_nft_o_viceconte.bean;

import java.io.Serializable;

public class NFT_Cat implements Serializable{

    private int catId;
    private String catName;
    private double catPrice_Eur;
    private double catPrice_Et;
    private double catPrice_BTC;
    private int catNbimage;
    private int catValue;
    private boolean catAdopt;


    public NFT_Cat(String botte, String s, String s1, String s2, String s3, String s4, String s5, String aFalse)  {

    }

    public NFT_Cat(String catName, double catPrice_Eur, double catPrice_Et, double catPrice_BTC, int catNbimage, int catValue, boolean catAdopt) {
        this.catName= catName;
        this.catPrice_Eur= catPrice_Eur;
        this.catPrice_Et= catPrice_Et;
        this.catPrice_BTC= catPrice_BTC;
        this.catNbimage = catNbimage;
        this.catValue = catValue;
        this.catAdopt = catAdopt;
    }

    public NFT_Cat(int catId, String catName, double catPrice_Eur, double catPrice_Et, double catPrice_BTC, int catNbimage, int catValue, boolean catAdopt) {
        this.catId= catId;
        this.catName= catName;
        this.catPrice_Eur= catPrice_Eur;
        this.catPrice_Et= catPrice_Et;
        this.catPrice_BTC= catPrice_BTC;
        this.catNbimage = catNbimage;
        this.catValue = catValue;
        this.catAdopt = catAdopt;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int userId) {
        this.catId = catId;
    }
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


    public double getCatPrice_Eur() {
        return catPrice_Eur;
    }

    public void setCatPrice_Eur(double catPrice_Eur) {
        this.catPrice_Eur = catPrice_Eur;
    }

    public double getCatPrice_Et() {
        return catPrice_Et;
    }

    public void setCatPrice_ET(double catPrice_Et) {
        this.catPrice_Et = catPrice_Et;
    }

    public double getCatPrice_BTC() {
        return catPrice_BTC;
    }

    public void setCatPrice_BTC(double catPrice_BTC) {
        this.catPrice_BTC = catPrice_BTC;
    }



    public int getCatNbimage() {
        return catNbimage;
    }

    public void setCatNbimage(int catNbimage) {
        this.catNbimage = catNbimage;
    }

    public int getCatValue() {
        return catValue;
    }

    public void setCatValue(int catValue) {
        this.catValue = catValue;
    }


    public boolean getCatAdopt() {
        return catAdopt;
    }

    public void setCatAdopt( boolean catAdopt) {
        this.catAdopt = catAdopt;
    }




    @Override
    public String toString()  {
        return this.catName+this.catPrice_Eur+this.catPrice_Et+this.catPrice_BTC+this.catNbimage+this.catValue+this.catAdopt;
    }
}
