package com.example.last;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragementOne extends Fragment {
    private View view;
    private EditText editText,editText2,editText3,editText4;
    private Button button;
    private RadioGroup radioGroup;
    private RadioButton male,female;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragement_one,container,false);

        editText=view.findViewById(R.id.et_name);
        editText2=view.findViewById(R.id.et_name2);
        editText3=view.findViewById(R.id.et_name3);
        editText4=view.findViewById(R.id.et_name4);
        radioGroup=view.findViewById(R.id.radiogrpId);
        male=view.findViewById(R.id.maleId);
        female=view.findViewById(R.id.femaleId);
        button=view.findViewById(R.id.clickBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=editText.getText().toString();
                String email=editText2.getText().toString();
                String mobile=editText3.getText().toString();
                String pass=editText4.getText().toString();
               int selectId= radioGroup.getCheckedRadioButtonId();

                male=view.findViewById(R.id.maleId);
                female=view.findViewById(R.id.femaleId);
                String value = male.getText().toString();
                String value2 = female.getText().toString();
                male.setText("You have selected "+ value);
                female.setText("You have selected "+ value2);



                if(user.isEmpty()){
                 editText.setError("Please fill up");
                 return;
            }
            if(email.isEmpty()){
                 editText2.setError("Please fill up");
                 return;
            }
            if(mobile.isEmpty()){
                    editText3.setError("Please fill up");
                    return;
                }
                if(pass.isEmpty()){
                    editText4.setError("Please fill up");
                    return;
                }



                Bundle bundle= new Bundle();
                bundle.putString("user","User Name : "+ user);
                bundle.putString("email","E-mail : "+ email);
                bundle.putString("mobile","Mobile No : "+ mobile);
                bundle.putString("pass","Password : "+ pass);

                FragmentManager fragementManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragementManager.beginTransaction();

                FragementTwo fragementTwo= new FragementTwo();
                fragementTwo.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_place,fragementTwo);
                fragmentTransaction.commit();

            }
        });
        return view;
    }
}