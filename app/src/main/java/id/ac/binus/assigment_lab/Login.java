package id.ac.binus.assigment_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Login extends AppCompatActivity {

    TextView tessss;
    EditText edittext_username;
    EditText edittext_password;
    Button btn_login;
    Button btn_register;
    int userke = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tessss = findViewById(R.id.tes);
        edittext_username = findViewById(R.id.username);
        edittext_password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);



        //Ambil username
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Login.this);
        String username = sp.getString("username_key","null");
        //Ambil username

        //Ambil password
        String password = sp.getString("password_key","null");
        //Ambil password

        //Ambil phone_number
        String phone_number = sp.getString("phone_number_key","null");
        //Ambil phone_number

        //Ambil gender
        String gender = sp.getString("gender_key","null");
        //Ambil gender

        //Ambil DoB
        String DoB = sp.getString("DoB_key","null");
        //Ambil DoB

        //Ambil id_user
        String id_user = sp.getString("user_id_key","null");
        //Ambil id_user


        if (Register.list_User.size() != 0){
            userke = sp.getInt("userke",0);
            Register.list_User.get(userke).convert_string_to_arraylist();
        }



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Assign
                    //VECTOR LIST_USER
//                    ArrayList<User> list_user = new ArrayList<>();
                    //Ambil 1 data user semuanya
                    Gson gson = new Gson();
                    String response = sp.getString("list_user_key","null");
                    Register.list_User = gson.fromJson(response,new TypeToken<List<User>>(){}.getType());
                    //Ambil 1 data user semuanya
                    String username_login = edittext_username.getText().toString();
                    String password_login = edittext_password.getText().toString();
                    int username_ketemu = 0;//Ini kalo usernamenya gak ada di database
                    int password_ketemu = 0;//Ini kalo passwordnya gak ada di database
                    int username_dan_paswword_cocok = 1;// Ini kalo username dan passwordnya  cocok
                //Assign



                for (int i = 0; i < Register.list_User.size(); i++){
                    //Username ketemu di database
                    if(Register.list_User.get(i).getUsername().equals(username_login)){
                        username_ketemu = 1;
                        userke = i;
                        //Cek apakah Username dan password cocok
                        if(!password_login.equals(Register.list_User.get(i).getPassword())){
                            username_dan_paswword_cocok = 0; // Ini kalau gk cocok
                        }
                        //Cek apakah Username dan password cocok
                    }
                    //Username ketemu di database

                    //Password ketemu di database
                    if(Register.list_User.get(i).getPassword().equals(password_login)){
                        password_ketemu = 1;
                    }
                    //Password ketemu di database

                }

//                tessss.setText(username_login+ " "+ password_login + " " + username_ketemu + " "+ password_ketemu + " "+ username_dan_paswword_cocok);

                //Username kosong
                if(username_login.isEmpty()){
                    Toast.makeText(Login.this,"Please input your username",Toast.LENGTH_LONG).show();
                }
                //Username kosong

                //Password kosong
                else if (password_login.isEmpty()){
                    Toast.makeText(Login.this,"Please input your password", Toast.LENGTH_LONG).show();
                }
                //Password kosong

                //Username tidak ketemu
                else if(username_ketemu == 0){
                    Toast.makeText(Login.this,"Username not found", Toast.LENGTH_LONG).show();
                }
                //Username tidak ketemu

                //Password tidak ketemu
                else if(password_ketemu == 0){
                    Toast.makeText(Login.this,"Password not found", Toast.LENGTH_LONG).show();
                }
                //Password tidak ketemu

                //Username dan Password tidak cocok
                else if(username_dan_paswword_cocok == 0){
                    Toast.makeText(Login.this,"Username and Password not match", Toast.LENGTH_LONG).show();
                }
                //Username dan Password tidak cocok

                else{

//                    Intent intent = new Intent(Login.this,Profile.class);

                    //Kirim data ke login page
                    SharedPreferences.Editor share_username_password = PreferenceManager.getDefaultSharedPreferences(Login.this).edit();
                    share_username_password.putString("username_from_login",username_login);
                    share_username_password.putString("password_from_login",password_login);
                    share_username_password.putInt("userke", userke);
                    share_username_password.apply();
                    //Kirim data ke login page

//                    //Lempar data ke profile page
//                    Intent intent_to_profile = new Intent();
//                    intent_to_profile.putExtra("username_login", username_login);
//                    intent_to_profile.putExtra("password_login", password_login);
//                    startActivity(intent_to_profile);
//                    //Lempar data ke profile page
                    Intent intent = new Intent(Login.this,HomePage.class); // INI YANG BENER (PINDAH PAGE KE HOME)
                    startActivity(intent);

                }

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
}