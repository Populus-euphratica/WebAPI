package com.ysu.webapi.pojo;

public class APIInfo {
    private int id;
    private int clickNum;
    private int collectionNum;

    public APIInfo(){
        clickNum=0;
        collectionNum=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }
}
