package com.example.dixit.Entity;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String id_card;
    private String picture_url;
    private String name;

    public Card(String picture_url, String name) {
        this.picture_url = picture_url;
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPicture_url() {
        return picture_url;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id_card='" + id_card + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    Map<String,Object> toMap(){
        HashMap<String,Object> result=new HashMap<>();
//        result.put("id_card",this.id_card);
        result.put("picture_url",this.picture_url);
        result.put("name",this.name);
        return result;
    };

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void viewCard(){}


}
