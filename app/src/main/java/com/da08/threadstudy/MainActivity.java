package com.da08.threadstudy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText urlEdit, regexEdit;
    TextView resultTxt;
    Button crawlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEdit = (EditText)findViewById(R.id.url);
        regexEdit = (EditText)findViewById(R.id.regx);
        resultTxt = (TextView)findViewById(R.id.result);
        crawlBtn = (Button)findViewById(R.id.crawl);
    }

    @Override
    public void onClick(View view) {
        String url = urlEdit.getText().toString();
        String regx = regexEdit.getText().toString();

        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0].contains("http")?strings[0]:"http://"+strings[0]); //url
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                    PrintWriter pw = new PrintWriter(con.getOutputStream());
//                    String protocol[] = {"GET /index HTTP/1.1",
//                            "Host: localhost:8080",
//                            "Cache-Control: no-cache",
//                            "Postman-Token: 8716f735-6daa-792a-edcc-2f6cbbfeea53"
//                            ""};
//                    for(String s : protocol){
//                        pw.println(s);
//                    }
                    Scanner scan = new Scanner(con.getInputStream());
//                    scan.next("\\z");  // "\\z" 전체 문자 끝까지 다 가져옴
                    while(scan.hasNext()){  // 내용물을 반복하여 다 가져오기
                        scan.next();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                strings[1] //regex
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }
        }.execute(url,regx);
    }
}
