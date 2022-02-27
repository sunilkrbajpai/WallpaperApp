package com.example.wallpapersapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class Full_Image extends AppCompatActivity {


    private ImageView fullImage;
    private Button apply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full__image);

        fullImage=findViewById(R.id.FullImage);
        apply=findViewById(R.id.applyBtn);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(fullImage);
        apply.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                setBackground();
                Toast.makeText(Full_Image.this,"Wallpaper set successfully!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setBackground() {

        Bitmap bitmap=((BitmapDrawable)fullImage.getDrawable()).getBitmap();
        WallpaperManager manager=WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
        } catch (IOException e) {
            Toast.makeText(Full_Image.this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setLockScreen() {

        Bitmap bitmap=((BitmapDrawable)fullImage.getDrawable()).getBitmap();
        WallpaperManager manager=WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);
//            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(Full_Image.this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.lockoption,menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.lock)
        {
            setLockScreen();
            Toast.makeText(Full_Image.this,"Lockscreen set successfully!",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.wall)
        {
            try {
                setBackground();
                Toast.makeText(Full_Image.this,"Homescreen set successfully!",Toast.LENGTH_SHORT).show();
            }

            catch(Exception e){
                Toast.makeText(this,"Unable to set Homescreen",Toast.LENGTH_SHORT).show();
            }
        }
        if(id==R.id.both)
        {
            try {
                setBackground();
                setLockScreen();
                Toast.makeText(Full_Image.this,"Homescreen and Lockscreen set successfully!",Toast.LENGTH_SHORT).show();
            }

            catch(Exception e){
                Toast.makeText(this,"Unable to set Homescreen and Lockscreen",Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}