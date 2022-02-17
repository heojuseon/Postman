package com.example.postman.Item;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.postman.Data.TrainingData;
import com.example.postman.R;

public class TrainingItem extends RecyclerView.ViewHolder{

    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;


    public TrainingItem(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.id);
        textView2 = itemView.findViewById(R.id.name);
        textView3 = itemView.findViewById(R.id.level);
        textView4 = itemView.findViewById(R.id.week);
        textView5 = itemView.findViewById(R.id.msg);
    }

    public void setItem(TrainingData item) {

        textView.setText(item.getId());
        textView2.setText(item.getName());
        textView3.setText(item.getLv());
        textView4.setText(item.getWeek());
        textView5.setText(item.getMsg());

    }
}
