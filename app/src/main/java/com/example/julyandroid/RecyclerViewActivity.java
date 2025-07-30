package com.example.julyandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvlist;
    List<MyListData> listdata=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        rvlist=findViewById(R.id.rvlist1);
        listdata.add(new MyListData("Apple","Apple is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Mango","Mango is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Banana","Banana is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Grapes","Grapes is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Orange","Orange is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Pineapple","Pineapple is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Watermelon","Watermelon is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Strawberry","Strawberry is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Kiwi","Kiwi is a fruit",R.drawable.workhunt_new));
        listdata.add(new MyListData("Pear","Pear is a fruit",R.drawable.workhunt_new));
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listdata,this);
        rvlist.setHasFixedSize(true);
        //horizontal
        rvlist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvlist.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}