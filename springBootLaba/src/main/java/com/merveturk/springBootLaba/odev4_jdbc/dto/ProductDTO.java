package com.merveturk.springBootLaba.odev4_jdbc.dto;

public class ProductDTO {

    private int ID;
    private String NAME;
    private String CATEGORY;
    private String DESCRIPTION;
    private String PHOTOURL;
    private Double PRICE;





    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getPHOTOURL() {
        return PHOTOURL;
    }

    public void setPHOTOURL(String PHOTOURL) {
        this.PHOTOURL = PHOTOURL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }
}
