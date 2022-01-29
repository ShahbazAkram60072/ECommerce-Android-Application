package com.shahbaz.rentadressapplicationsemesterproject.CollectionActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.shahbaz.rentadressapplicationsemesterproject.JavaClass.Product;
import com.shahbaz.rentadressapplicationsemesterproject.R;
import com.shahbaz.rentadressapplicationsemesterproject.ViewHolder.ProductAdopter;

import java.util.ArrayList;
import java.util.List;

public class GownActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private ValueEventListener postListener;
    private DatabaseReference df;
    private RecyclerView rv;
    private ProductAdopter adopter;
    private List<Product> productList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gown);
        setTitle("Gown");
        auth=FirebaseAuth.getInstance();
        post();

        df = FirebaseDatabase.getInstance().getReference().child("Products");

        rv=findViewById(R.id.rv_gown);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adopter=new ProductAdopter(this,productList);
        rv.setAdapter(adopter);

        Query query1=FirebaseDatabase.getInstance().getReference().child("Products")
                .orderByChild("category")
                .equalTo("gown");
        query1.addListenerForSingleValueEvent(postListener);

    }

    public void post(){
        postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productList.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                        Product p = postSnapshot.getValue(Product.class);
                        productList.add(p);
                    }
                    adopter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };


    }
}
