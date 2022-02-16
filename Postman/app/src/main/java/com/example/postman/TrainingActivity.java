package com.example.postman;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.postman.Data.PowerliftingData;
import com.example.postman.Data.TrainingData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class TrainingActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    TrainingAdapter adapter;

    static RequestQueue requestQueue2;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        Intent intent = getIntent();
        setResult(RESULT_OK, intent);


        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TrainingAdapter();
        recyclerView.setAdapter(adapter);



        
        //RequestQueue 객체생성
        if (requestQueue2 == null) {
            requestQueue2 = Volley.newRequestQueue(getApplicationContext());
        }

        //버튼 입력 안받고 바로 출력
        trainRequest();
        

    }

    private void trainRequest() {
        //GET
        String url = "https://34680239-27cc-40d0-b8e3-bf9b6aa469bc.mock.pstmn.io/example";

        StringRequest request = new StringRequest(  //요청을 보내기 위한 StringRequest 객체 생성
                Request.Method.GET,
                url,
                new Response.Listener<String>() {   //응답을 잘 받았을 때 이 메소드가 자동으로 호출

                    @Override
                    public void onResponse(String response2) {
                        println2("response -> " + response2);

                        trainingResponse(response2);
                    }
                },
                new Response.ErrorListener() {  //에러 발생시 호출될 리스너 객체
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println2("error -> " + error.getMessage());
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };

        request.setShouldCache(false);  //이전 결과 있어도 새로 요청하여 응답을 보여준다.
        requestQueue2.add(request);  //요청 큐의 add메소드
        println2("요청 보냄.");

    }

    private void println2(String data2) {
        Log.d("TrainingData", data2);
    }

    private void trainingResponse(String response2) {
        Gson gson = new Gson();
        TrainingList trainingList = gson.fromJson(response2, TrainingList.class); //JSON문자열을 TrainingList list 객체로 변환

        for (int i = 0; i < trainingList.functional.size(); i++){
            TrainingData tdo = trainingList.functional.get(i);

            adapter.addItem(tdo);

        }

        for (int i = 0; i < trainingList.powerlifting.size(); i++){
            PowerliftingData tdo2 = trainingList.powerlifting.get(i);

            adapter.addItem2(tdo2);

       }

        // 리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용
        adapter.notifyDataSetChanged();

    }


}