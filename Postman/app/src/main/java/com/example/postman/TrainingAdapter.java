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

    //여기 부분 수정함
    public static final int VIEW_TYPE_A = 0;
    public static final int VIEW_TYPE_B = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        if (viewType == VIEW_TYPE_A){
//
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            View itemView = inflater.inflate(R.layout.functional, parent, false);
//
//            return new TrainingItem(itemView);
//
//        }else {
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            View itemView = inflater.inflate(R.layout.powerlifting, parent, false);
//
//            return new PowerliftingItem(itemView);
//        }


        if (viewType == VIEW_TYPE_A){

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.functional, parent, false);

            return new TrainingItem(itemView);

//        }else if (viewType == VIEW_TYPE_B){
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            View itemView = inflater.inflate(R.layout.powerlifting, parent, false);
//
//            return new PowerliftingItem(itemView);

        }else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.powerlifting, parent, false);

            return new PowerliftingItem(itemView);
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

            TrainingData trainingData = (TrainingData) obj;

            trainingData.getType(); //여기 부분 수정함

            return VIEW_TYPE_A;

        }else if (obj instanceof PowerliftingData){

            PowerliftingData powerliftingData = (PowerliftingData) obj;

            powerliftingData.getType();//여기 부분 수정함

            return VIEW_TYPE_B;

        }

        return VIEW_TYPE_A;
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
