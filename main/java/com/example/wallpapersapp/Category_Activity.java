package com.example.wallpapersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.wallpapersapp.Utility.NetworkChangeListener;

import java.util.ArrayList;
import java.util.Arrays;

public class Category_Activity extends AppCompatActivity {

    NetworkChangeListener networkChangeListener=new NetworkChangeListener();


    String[] subNames = { "3D","Animal","Anime" ,"Clocks","Dark","Designs","Flowers","Food","Games","God","Love","Men","Misc","Music","Nature","Quotes","Space","Sports","Super Heroes","Vehicles","Women"};
//    String [] thumbnails={"https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/threed.jpg?alt=media&token=6f3cdf21-5005-447c-9d5e-c46fb5f385d5","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/animal.jpg?alt=media&token=767af999-1179-4229-9acd-24a69bd10785","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/anime%20(1).jpg?alt=media&token=ae50f6bf-7ce1-46cb-b800-a17808667b8e","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/clocks.jpg?alt=media&token=ac5261dd-bc32-4b66-99b9-824dd61a0605","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/dark.jpeg?alt=media&token=a557cc98-791b-46d8-b5c4-e92ba78f5973","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/designs.jpg?alt=media&token=aab0f3bf-3649-40f5-9fad-91acaa984540","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/flowers.jpg?alt=media&token=ffb3549e-43ca-4a4d-8408-df69efef5638","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/food.jpg?alt=media&token=48f97fc8-b2d3-4ebb-bc89-f26ef2934b09","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/game.jpg?alt=media&token=0933edc9-590f-4a66-ad62-fae939889c19","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/god.jpg?alt=media&token=4f204ff4-a465-4520-acfd-09d0521922f7","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/love.jpg?alt=media&token=bb9b5dba-4c71-4a95-9e25-a2e216e4e3bb","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/men.jpg?alt=media&token=268edf48-b80d-459d-a2ea-df8f3e6dcc42","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/misc.jpeg?alt=media&token=caf3a7ca-29e6-4947-a3e7-791b43e03ab4","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/music.jpg?alt=media&token=fcc488ef-0c4a-4516-8828-0cf20e125390","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/nature.jpg?alt=media&token=c4e6b6a6-c4c7-415d-8481-f14180c46210","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/quotes.jpg?alt=media&token=23a7d53e-778d-4e20-b7f1-8302dbd04098","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/space.jpg?alt=media&token=4d3717f2-3b48-4085-965f-b9a384dbf31a","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/sports.jpg?alt=media&token=e380ab09-3380-41ab-8781-a4c13066f63b","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/superheroes.jpg?alt=media&token=05c2d2a0-2de6-4e6b-a777-4820acc07102","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/vehicles.jpg?alt=media&token=2c36714a-fc84-4eb2-952b-9bc10d665cd9","https://firebasestorage.googleapis.com/v0/b/wallpaper-app-123.appspot.com/o/women.jpg?alt=media&token=15bf1fe7-9160-4c08-b7be-a9de159fd6dd"};
    int[] myImageList = new int[]{R.drawable.threed, R.drawable.animal,R.drawable.anime,R.drawable.clocks,R.drawable.dark,R.drawable.designs,R.drawable.flowers,R.drawable.food,R.drawable.game,R.drawable.god,R.drawable.love,R.drawable.men,R.drawable.misc,R.drawable.music,R.drawable.nature,R.drawable.quotes,R.drawable.space,R.drawable.sports,R.drawable.superheroes,R.drawable.vehicles,R.drawable.women};
    ArrayList<String> names;
//    ArrayList<String> thumbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_);

//        initializing recyclerview
            RecyclerView listNames=(RecyclerView)findViewById(R.id.list_recyclerView);
            names=new ArrayList<>();
//            thumbs=new ArrayList<>();

//        initializing arraylist
            names.addAll(Arrays.asList(subNames) );
//            thumbs.addAll(Arrays.asList(thumbnails));

//        layoutmanager initalize
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
            listNames.setLayoutManager(linearLayoutManager);

//      Custom Adapter class
//        ListAdapter listAdapter=new ListAdapter(names,Category_Activity.this,thumbs,myImageList);
            ListAdapter listAdapter=new ListAdapter(names,Category_Activity.this,myImageList);
            listNames.setAdapter(listAdapter);
    }

    @Override
    protected void onStart() {
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener,filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.drawermenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.AboutUs)
        {
            startActivity(new Intent(Category_Activity.this,AboutUsActivity.class));
        }
        if(id==R.id.Share)
        {
            try {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i,"Share with"));
            }

            catch(Exception e){
                Toast.makeText(this,"Unable to share!",Toast.LENGTH_SHORT).show();
            }

        }
        if(id==R.id.contact)
        {
            try{
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "skb.tuts@gmail.com"});
//                email.putExtra(Intent.EXTRA_SUBJECT, "");
//                email.putExtra(Intent.EXTRA_TEXT, message);

//need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }catch (Exception e)
            {
                Toast.makeText(this,"Unable to open Email client application!",Toast.LENGTH_SHORT).show();

            }

        }
        return super.onOptionsItemSelected(item);
    }
}