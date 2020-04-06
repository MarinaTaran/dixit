package com.example.dixit.Entity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dixit.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class PlayTayble extends AppCompatActivity {
    GridView simpleList;
    ArrayList birdList=new ArrayList<>();
    DaoCard daoCard;



    ImageView iv_deck,card1,card2,card3,card4,card5,card6;
    File directory;
    FirebaseStorage storage;
    ImageView ivCard;
   final String  TAG="PlayTayble";
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_tayble);
        daoCard=new DaoCard();

        Card card;
        card=new Card("jdfj","jdjdjd");
       Card card7=new Card("kskskk","khfds");
       Card card8=new Card("oppu","kklou");
        daoCard.create(card);
       daoCard.create(card7);
        String key=card7.getId_card();
        Log.d(TAG, "onCreate: &&&&&&&&&&&&"+key);
        daoCard.create(card8);

        Log.d(TAG, "onCreate: !!!!!!!"+daoCard.getAll());
        //daoCard.delete(key);



//        simpleList = (GridView) findViewById(R.id.simpleGridView);
//        birdList.add(new Item("Bird 1",R.drawable.b1));
//        birdList.add(new Item("Bird 2",R.drawable.b2));
//        birdList.add(new Item("Bird 3",R.drawable.b3));
//        birdList.add(new Item("Bird 4",R.drawable.b4));
//        birdList.add(new Item("Bird 5",R.drawable.b5));
//        birdList.add(new Item("Bird 6",R.drawable.b6));
//
//        MyAdapter myAdapter=new MyAdapter(this,R.layout.grid_view_items,birdList);
//        simpleList.setAdapter(myAdapter);
storageReference= FirebaseStorage.getInstance().getReference();
//        storage= FirebaseStorage.getInstance(); //ssilka na storage
//        Log.d(TAG, "onCreate: !!!!!!!!!!!!!!!!"+storage.getReference());
        Log.d(TAG, "onCreate: !!!!!!!!!!!!!!!!"+storageReference.child("image/399613_285356714859804_664014420_n.jpg").toString());
        iv_deck=(findViewById(R.id.iv_deck));
//        String url="https://firebasestorage.googleapis.com/v0/b/gs://testproject-10cdf.appspot.com/23 Surreal Animal Paintings.jpg=media&token=9d152258-40f7-41c5-a4a2-53ee995008dd";//Retrieved url as mentioned above

       Glide.with(this).load(storageReference.child("image/399613_285356714859804_664014420_n.jpg")).into(iv_deck);
//        gs://dixit-b5b8f.appspot.com/image/399613_285356714859804_664014420_n.jpg
        card1=(findViewById(R.id.card1));
        card2=(findViewById(R.id.card2));
        card3=(findViewById(R.id.card3));
        card4=(findViewById(R.id.card4));
       card5=(findViewById(R.id.card5));
        card6=(findViewById(R.id.card6));

        card1.setVisibility(View.INVISIBLE);
        card2.setVisibility(View.INVISIBLE);
        card3.setVisibility(View.INVISIBLE);
        card4.setVisibility(View.INVISIBLE);
        card5.setVisibility(View.INVISIBLE);
        card6.setVisibility(View.INVISIBLE);


       iv_deck.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//               Collections.shuffle();



               card1.setVisibility(View.VISIBLE);
               card2.setVisibility(View.VISIBLE);
               card3.setVisibility(View.VISIBLE);
               card4.setVisibility(View.VISIBLE);
               card5.setVisibility(View.VISIBLE);
               card6.setVisibility(View.VISIBLE);
           }
       });

    }



//
        }
