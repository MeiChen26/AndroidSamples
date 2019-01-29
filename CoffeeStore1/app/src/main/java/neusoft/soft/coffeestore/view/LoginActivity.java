package neusoft.soft.coffeestore.view;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class LoginActivity extends Activity {

    EditText userNameEt,pwdEt;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameEt= (EditText) findViewById(R.id.et_username);
        pwdEt= (EditText) findViewById(R.id.et_password);

        Button loginButton= (Button) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=userNameEt.getText().toString();
                String pwd=pwdEt.getText().toString();
                if(username.equals("")||pwd.equals("")){
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        data="username="+ URLEncoder.encode(username,"UTF-8")+
                                "&pwd="+URLEncoder.encode(pwd,"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    AsyncHttpConnection ac=new AsyncHttpConnection();
                    try {
                        URL url=new URL("http://10.0.3.2:8080/eshop/login.action");
                        ac.execute(url);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    class AsyncHttpConnection extends AsyncTask<URL,Void,JSONObject>{
        @Override
        protected JSONObject doInBackground(URL... params) {
            JSONObject result=null;
            HttpURLConnection conn=null;
            try {
                conn=(HttpURLConnection)params[0].openConnection();
                conn.setConnectTimeout(3000);
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                OutputStream out=conn.getOutputStream();
                out.write(data.getBytes());
                out.flush();
                out.close();
                if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    InputStream in=conn.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(in));
                    String str=br.readLine();
                    result=new JSONObject(str);
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }finally {
                conn.disconnect();
            }
            return result;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            if(jsonObject!=null){

                if(jsonObject.optString("login").equals("true")){
                    Toast.makeText(LoginActivity.this, "成功"+jsonObject.optString("msg"), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "失败"+jsonObject.optString("msg"), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
