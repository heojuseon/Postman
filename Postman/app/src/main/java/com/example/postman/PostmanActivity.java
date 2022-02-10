package com.example.postman;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class PostmanActivity extends AppCompatActivity {

    static RequestQueue requestQueue;
    static RequestQueue requestQueue2;


    Button lgnbtn;
    Button trnbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        lgnbtn = findViewById(R.id.login);
        lgnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                makeRequest();

            }
        });

        //RequestQueue 객체생성
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }


        ///////////////////////////////////////////////////////////////////////////////////

        trnbtn = findViewById(R.id.training);
        trnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                trainRequest();

            }
        });

        //RequestQueue 객체생성
        if (requestQueue2 == null) {
            requestQueue2 = Volley.newRequestQueue(getApplicationContext());
        }

    }

    private void makeRequest() {
        //GET
        String url = "https://34680239-27cc-40d0-b8e3-bf9b6aa469bc.mock.pstmn.io/login";

//        //POST
//        String url = "https://34680239-27cc-40d0-b8e3-bf9b6aa469bc.mock.pstmn.io/login2";

        StringRequest request = new StringRequest(  //요청을 보내기 위한 StringRequest 객체 생성
                Request.Method.GET,
                url,
                new Response.Listener<String>() {   //응답을 잘 받았을 때 이 메소드가 자동으로 호출

                    @Override
                    public void onResponse(String response) {
                        println("response -> " + response);

                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {  //에러 발생시 호출될 리스너 객체
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("error -> " + error.getMessage());
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                //POST방식
//                params.put("id", editId.getText().toString());
//                params.put("pw", editPw.getText().toString());

                return params;
            }
        };

        request.setShouldCache(false);  //이전 결과 있어도 새로 요청하여 응답을 보여준다.
        requestQueue.add(request);  //요청 큐의 add메소드
        println("요청 보냄.");

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////


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


    private void println(String data) {
        Log.d("Login", data);
    }



    private void println2(String data2) {
        Log.d("Training", data2);
    }



    //데이터 매핑 과정
    //Gson의 가장 강력한 기능은 mapping 기능이다.
    //mapping 이란 Json의 Key-Value 형태를 자바의 변수-값 형태로 매핑이 가능하다.
    //Gson은 이 클래스 매핑이라는 기능을 통해 서버로 부터 받을 데이터에 대해서 정확하게 클래스로 명시가 가능하고 유지보수가 상당히 쉬워지는 장점을 제공
    private void processResponse(String response) {
        Gson gson = new Gson();
        LoginList loginList = gson.fromJson(response, LoginList.class); //JSON문자열을 LoginList 객체로 변환

        println(loginList.name);
        println(loginList.email);
        println(loginList.id);
        println(loginList.pw);
    }




    private void trainingResponse(String response2) {
        Gson gson = new Gson();
        TrainingList trainingList = gson.fromJson(response2, TrainingList.class); //JSON문자열을 TrainingList list 객체로 변환



    }


}
