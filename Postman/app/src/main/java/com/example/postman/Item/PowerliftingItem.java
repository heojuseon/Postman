package com.example.postman.Item;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postman.Data.PowerliftingData;
import com.example.postman.R;

public class PowerliftingItem extends RecyclerView.ViewHolder{

    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;


    public PowerliftingItem(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.id_power);
        textView2 = itemView.findViewById(R.id.name_power);
        textView3 = itemView.findViewById(R.id.level_power);
        textView4 = itemView.findViewById(R.id.week_power);
        textView5 = itemView.findViewById(R.id.msg_power);

    }

    public void setItem(PowerliftingData powerliftingData) {

        textView.setText(powerliftingData.getId());
        textView2.setText(powerliftingData.getName());
        textView3.setText(powerliftingData.getLv());
        textView4.setText(powerliftingData.getWeek());
        textView5.setText(powerliftingData.getMsg());

    }
}
