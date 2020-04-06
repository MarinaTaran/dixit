package com.example.dixit.Entity;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoCard implements DAO<Card> {
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String TAG="DaoCard";
    @Override
    public Card create(final Card obj) {
        Map<String, Object> source = obj.toMap();
//final Thread[] tred={null};
////        String newKey = db.collection("cards").getId();
//        Log.d(TAG, "create: !!!1111"+newKey);
//        obj.setId_card(newKey);
        db.collection("cards").add(source)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        obj.setId_card(documentReference.getId());
//                    tred[0]=Thread.currentThread();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });;
//while (tred[0]==null || tred[0].isAlive()){
//
//}
        return obj;
    }
    @Override
    public boolean update(Card obj) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        db.collection("cards").document(id)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted!!!!!!!!!!!!!!!!!!!!!1");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document  !!!!!!!!!!!!!!!!!!!!!", e);
                    }
                });

        return false;
    }

    @Override
    public List<Card> getAll() {
        db.collection("cards").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                               Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        ;

        return null;
    }
}
