package com.example.last;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerView extends AppCompatActivity {
    Toolbar toolbar;
    Switch aSwitch;
    SearchView searchView;
    CircleImageView circleImageView;

    private ImageButton backbtn;

    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private int[] images = {R.drawable.aus,R.drawable.bangla,R.drawable.india,R.drawable.paki,R.drawable.dubai,R.drawable.news,R.drawable.swed,R.drawable.brazil};
    private String[] name = {"Australia","Bangladesh","India","Pakistan","Dubai","New zealand ","Sweden","Brazil"};
    TextView textView,textView1;


    private List<Details> detailsList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        circleImageView=findViewById(R.id.CircleImg);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecyclerView.this, "About Us", Toast.LENGTH_SHORT).show();
            }
        });
        searchView=findViewById(R.id.searchId);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecyclerView.this, "Search", Toast.LENGTH_SHORT).show();
            }
        });
        backbtn=findViewById(R.id.backbtnId);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecyclerView.this, "Back Button", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar = findViewById(R.id.toolbarId);

        aSwitch=findViewById(R.id.switchId);



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(RecyclerView.this,"On",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RecyclerView.this,"OFF",Toast.LENGTH_SHORT).show();


                }

            }
        });


        setTitle(null);
        setSupportActionBar(toolbar);
//        setSupportActionBar(toolbar);

        //USE TO TOOLBAR

//
//       toolbar=(Toolbar)findViewById(R.id.toolbarId);
////USE TO TOOL BAR
//        setActionBar(toolbar);
//        getSupportActionBar().setTitle("Getting");
//        toolbar.setSubtitle("welcome");
//        toolbar.setLogo(R.drawable.shakib);
//        toolbar.setNavigationIcon(R.drawable.mushfiqur);

//        public boolean onCreateOptionMenu(Menu menu){
//            getMenuInflater().inflate(R.menu.menu_main);
//            return ;
//        }





        initView();
        prepareData();
    }

//    private void setSupportActionBar(Toolbar toolbar) {
//    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = " ";
        switch (item.getItemId()) {
//            case R.id.backId:
//                msg = "delete";
//                break;

            case R.id.setting:
                msg = "Setting";
                break;

            case R.id.logout:
                msg = "Logout";
                break;
        }
        Toast.makeText(RecyclerView.this, msg + " ", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }


    private void prepareData() {
        for(int i=0;i<name.length;i++)
        {
            detailsList.add(new Details(images[i],name[i])) ;
        }
        DetailsAdapter adapter=new DetailsAdapter(this,detailsList);
        recyclerView.setAdapter(adapter);


    }

    private void initView() {

        recyclerView= findViewById(R.id.recyclerId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }
}
