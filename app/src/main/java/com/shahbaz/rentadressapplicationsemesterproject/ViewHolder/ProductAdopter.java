package com.shahbaz.rentadressapplicationsemesterproject.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shahbaz.rentadressapplicationsemesterproject.JavaClass.Product;
import com.shahbaz.rentadressapplicationsemesterproject.ProductDetailActicity;
import com.shahbaz.rentadressapplicationsemesterproject.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdopter extends RecyclerView.Adapter<ProductAdopter.MyViewHolder> {
    public Context mcontext;
    public List<Product> productList;
    public List<Product> productListFull;

    private DatabaseReference dr;


    public ProductAdopter(Context mcontext, List<Product> productList) {
        this.mcontext = mcontext;
        this.productList = productList;
        productListFull = new ArrayList<>(productList);
    }

    @NonNull
    @Override
    public ProductAdopter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(mcontext).inflate(R.layout.product_item_view,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdopter.MyViewHolder myViewHolder, int position) {

        final Product p=productList.get(position);
        myViewHolder.txtProductName.setText(p.pname);
        myViewHolder.txtProductDescription.setText(p.description);
        myViewHolder.txtProductRent.setText("Rent="+p.prent+"Pkr");
        myViewHolder.txtProductPrice.setText("Values = "+p.price+"Pkr");

        Glide.with(mcontext).load(p.imageUrl).into(myViewHolder.imageView);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mcontext, ProductDetailActicity.class);
                dr = FirebaseDatabase.getInstance().getReference().child("Products").child(p.getPid());

                i.putExtra("pid",p.getPid());
                mcontext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtProductName, txtProductDescription, txtProductPrice,txtProductRent;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.product_imageShow);
            txtProductName = (TextView) itemView.findViewById(R.id.product_nameShow);
            txtProductDescription = (TextView) itemView.findViewById(R.id.product_descriptionShow);
            txtProductPrice = (TextView) itemView.findViewById(R.id.product_priceShow);
            txtProductRent = (TextView) itemView.findViewById(R.id.product_rentShow);


        }

    }
    public void filterList(ArrayList<Product> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }


}

