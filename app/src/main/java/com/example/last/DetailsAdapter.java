package com.example.last;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
//}


import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    //context+data
    private Context context;
    //model
    private List<Details>detailsList;

    public DetailsAdapter(Context context, List<Details> cricketerList) {
        this.context = context;
        this.detailsList = cricketerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//call 1st step

        View view= LayoutInflater.from(context).inflate(R.layout.sample,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {//set 3 rd step
// img,name set

        viewHolder.imageView.setImageResource(detailsList.get(i).getImage());
        viewHolder.textView.setText(detailsList.get(i).getName());


        viewHolder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,SecondActivity.class);

               /* intent.putExtra("Name",(detailsList.get(i).getName()));
                intent.putExtra("img",(detailsList.get(i).getImage()));*/
                // intent.putExtra("detailse",(detailsList.get(i).getName()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{//find|hold 2nd step
        //find
        ImageView imageView;
        TextView textView,textView1;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView= itemView.findViewById(R.id.imageviewId);
            textView= itemView.findViewById(R.id.textviewId);
            textView1=itemView.findViewById(R.id.texDetails);

        }
    }
    {


    }
}