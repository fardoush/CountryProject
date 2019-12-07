package com.example.last;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxx extends AppCompatActivity {
    private TextView textView,result;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private Button showbtn;
    Switch aSwitch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_boxx);

        textView=findViewById(R.id.checktextId);
        checkBox1=findViewById(R.id.check1Id);
        checkBox2=findViewById(R.id.check2Id);
        checkBox3=findViewById(R.id.check3Id);
        checkBox4=findViewById(R.id.check4Id);
        result=findViewById(R.id.resultId);
        aSwitch=findViewById(R.id.switchId);

        showbtn=findViewById(R.id.showbtnId);



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(CheckBoxx.this,"On",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CheckBoxx.this,"OFF",Toast.LENGTH_SHORT).show();


                }

            }
        });


        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                if(checkBox1.isChecked()){
                    String value= checkBox1.getText().toString();
                    stringBuilder.append(value + "is "+"\n");
                }
                if(checkBox2.isChecked()){
                    String value= checkBox2.getText().toString();
                    stringBuilder.append(value + "is "+"\n");
                }
                if(checkBox3.isChecked()){
                    String value= checkBox3.getText().toString();
                    stringBuilder.append(value + "is "+"\n");
                }
                if(checkBox4.isChecked()){
                    String value= checkBox4.getText().toString();
                    stringBuilder.append(value + "is"+"\n");
                }
                result.setText(stringBuilder);

            }
        });
    }
}
