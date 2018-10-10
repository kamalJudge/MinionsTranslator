package com.kamalpreet.minionstranslator.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kamalpreet.minionstranslator.R;
import com.kamalpreet.minionstranslator.model.Contents;
import com.kamalpreet.minionstranslator.model.Model;
import com.kamalpreet.minionstranslator.rest.ApiClient;
import com.kamalpreet.minionstranslator.rest.UserEndPoints;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText type_text;
    TextView tv_result;
    Button translate_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translate_button =  findViewById(R.id.button);
        tv_result = findViewById(R.id.textView);
        type_text = findViewById(R.id.editText2);

        translate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final UserEndPoints apiService = ApiClient.getClient().create(UserEndPoints.class);
                Call<Model> call = apiService.getContents(type_text.getText().toString());
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response)
                    {
                        String s = type_text.getText().toString();
                        Log.d("TEXT----", s);
                        tv_result.setText(response.body().getContents().getTranslatedText());
                        Log.d("Repo Avtivity", response.body().getContents().getTranslation());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t)
                    {
                        Log.d("Failure!!!!!!!!!", call.toString());
                    }
                });
            }
        });
    }
}
