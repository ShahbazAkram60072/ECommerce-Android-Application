package com.shahbaz.rentadressapplicationsemesterproject.AdminActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shahbaz.rentadressapplicationsemesterproject.LogIn.LogInActivity;
import com.shahbaz.rentadressapplicationsemesterproject.R;

public class AdminCategoryActivity extends AppCompatActivity {

    private boolean backPress = false;
    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        logOut = findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        setTitle("");

    }


    public void clickOntPentCoat(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Pent Coat");
        startActivity(intent);
    }

    public void clickOnSweaters(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Sweater");
        startActivity(intent);
    }

    public void clickOnJeans(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Jeans");
        startActivity(intent);
    }

    public void clickOnDressPent(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Dress Pent");
        startActivity(intent);
    }

    public void clickOnDressShirts(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Dress Shirts");
        startActivity(intent);
    }

    public void clickOnSherwani(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Sherwani");
        startActivity(intent);
    }

    public void clickOnHoodie(View view) {
        Intent intent = new Intent(AdminCategoryActivity.this, AddProductAdminActivity.class);
        intent.putExtra("category", "Hoodie");
        startActivity(intent);
    }

    public void addminViewProduct(View view) {
        startActivity(new Intent(getApplicationContext(), AdminViewProductActivity.class));

    }

    public void checknewOrder(View view) {

        startActivity(new Intent(getApplicationContext(), Admin_new_Orders_Activity.class));
    }

    @Override
    public void onBackPressed() {
        if (backPress) {
            super.onBackPressed();
        }
        this.backPress = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                backPress = false;
            }
        }, 2000);
    }
}
