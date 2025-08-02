package com.example.julyandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvlist;
    List<MyListData> listdata=new ArrayList<>();
    ApiService apiService;
    ProgressBar progressBar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        rvlist=findViewById(R.id.rvlist1);
        progressBar=findViewById(R.id.ivprogress);
        apiService=ApiClient.getClient().create(ApiService.class);
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
//        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listdata,this);
//        rvlist.setHasFixedSize(true);
//        //horizontal
//        rvlist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        rvlist.setAdapter(adapter);

        callApi();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void callApi(){
        Call<Movie> call=apiService.getMovieList("abc","c8d30391");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    List<Search> searchList=response.body().getSearch();
                    RecyclerViewAdapter adapter=new RecyclerViewAdapter(searchList,getApplicationContext());
                    rvlist.setHasFixedSize(true);
                    rvlist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvlist.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}