package com.example.last;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragementTwo extends Fragment {
View view;
private TextView textView,textView2,textView3,textView4,gender;
private Button nextbtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //view = inflater.inflate(R.layout.fragement_one, container, false);

        view = inflater.inflate(R.layout.fragement_two,container,false );
        Bundle bundle= getArguments();
        String user= bundle.getString("user");
        String email = bundle.getString("email");
        String mobile = bundle.getString("mobile");
        String pass = bundle.getString("pass");

         textView = view.findViewById(R.id.textviewId);
        textView2=view.findViewById(R.id.textview2Id);
        textView3=view.findViewById(R.id.textview3Id);
        textView4=view.findViewById(R.id.textview4Id);
        gender=view.findViewById(R.id.genderresultId);
//        String value = gender.getText().toString();



        textView.setText(user);
        textView2.setText(email);
        textView3.setText(mobile);
        textView4.setText(pass);

        nextbtn=view.findViewById(R.id.nextbtnId);
nextbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       // Intent intent= new Intent(context,SecondActivity.class);
        Intent myIntent = new Intent(getActivity(), RecyclerView.class);
        startActivity(myIntent);

    }
});

        return view;
    }
}
