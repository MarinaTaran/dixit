package com.example.dixit.Entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String gmail;
    String password;
    int numberOfCard;
    List<Card> userCards=new ArrayList<>();
   PlayTayble currentGame;
    int totalBall;

    public User(String sdklm) {
    }

    public void inviteUser(int currentGame){
        User user;
        if(currentGame!=0){
//            user.
        }
    };
    public boolean joinGame(String sicretWord){return true;}

    public boolean madeStep(int numberCard){
        for (Card temp:userCards){
//            temp.id=currentGame.cardsOnTable;
        }
        return true;}

    public void viewMyCards(){}
    public  boolean getCardFromDeck(){return true;}
//    public Game  startGame(){return null;}

    public void choiceCard(int indexCard) {
    }

    public void setTotalBall(int i) {
    }

}
