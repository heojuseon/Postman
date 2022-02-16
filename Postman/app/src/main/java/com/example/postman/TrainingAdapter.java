package com.example.postman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postman.Data.PowerliftingData;
import com.example.postman.Data.TrainingData;
import com.example.postman.Item.PowerliftingItem;
import com.example.postman.Item.TrainingItem;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<Object> items = new ArrayList();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == 0){

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.functional, parent, false);

            return new TrainingItem(itemView);

        }else if (viewType == 1){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.powerlifting, parent, false);

            return new PowerliftingItem(itemView);

        }else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.functional, parent, false);

            return new TrainingItem(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        Object obj = items.get(position);

        if (obj instanceof TrainingData){
            TrainingData trainingData = (TrainingData) obj;
            TrainingItem trainingItem = (TrainingItem) holder;
            trainingItem.setItem(trainingData);
        }

        else if (obj instanceof PowerliftingData){
            PowerliftingData powerliftingData = (PowerliftingData) obj;
            PowerliftingItem powerliftingItem = (PowerliftingItem) holder;
            powerliftingItem.setItem(powerliftingData);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {



        Object obj = items.get(position);
        if (obj instanceof TrainingData){

            TrainingData tda = (TrainingData) obj;
            return  tda.getType();

        }else if (obj instanceof PowerliftingData){

            PowerliftingData pwl = (PowerliftingData) obj;
            return  pwl.getType();
        }

        return 0;
    }

    public void setItems(ArrayList<Object> items){
        this.items = items;
    }


    public void addItem(TrainingData tdo) {
        items.add(tdo);
    }

    public void addItem2(PowerliftingData tdo2) {
        items.add(tdo2);
    }
}
