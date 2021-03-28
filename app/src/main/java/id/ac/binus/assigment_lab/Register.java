package id.ac.binus.assigment_lab;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;
//INGET JANGAN LUPA DIGANTI INTENT YANG KE HOMENYA
public class Register extends AppCompatActivity {

    RadioGroup gender;
    RadioButton radio_button;
    Button btn_register;
    TextView tes;
    EditText username;
    EditText password;
    EditText confirm_password;
    EditText phone_number;
    DatePicker DoB;
    CheckBox cekbok;
    public static ArrayList<User> list_User = new ArrayList<>();
//    static int user_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        gender = findViewById(R.id.gender);
        btn_register = findViewById(R.id.btn_register);
        tes = findViewById(R.id.tes);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        phone_number = findViewById(R.id.phone_number);
        DoB = findViewById(R.id.DoB);
        cekbok = findViewById(R.id.cekbok);



        //Methon tombol Register
        btn_register.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //Ini untuk validasi password
                int huruf = 0; // Ini kalo gk ada huruf sama sekali
                int angka = 0; // Ini kalo gk ada angka sama sekali
                //Ini untuk validasi password

                //Asign
                String userrname = username.getText().toString();
                String passwordd = password.getText().toString();
                String confirm_passworddd = confirm_password.getText().toString();
                String phone_numberrr = phone_number.getText().toString();
                int date_of_birth = 0;
                int month_of_birth = 0;
                int year_of_birth = 0;
                date_of_birth = DoB.getDayOfMonth();
                month_of_birth = DoB.getMonth();
                year_of_birth = DoB.getYear();
                boolean checked = cekbok.isChecked();
                //Assign

                //Validasi password alphanumeric
                for (int i = 0; i < passwordd.length();i++){
                    if(passwordd.charAt(i) == 'a' || passwordd.charAt(i) == 'b' || passwordd.charAt(i) == 'c' || passwordd.charAt(i) == 'd'
                            || passwordd.charAt(i) == 'e' || passwordd.charAt(i) == 'f' || passwordd.charAt(i) == 'g' || passwordd.charAt(i) == 'h'
                            || passwordd.charAt(i) == 'i' || passwordd.charAt(i) == 'j' || passwordd.charAt(i) == 'k' || passwordd.charAt(i) == 'l'
                            || passwordd.charAt(i) == 'm' || passwordd.charAt(i) == 'n' || passwordd.charAt(i) == 'o' || passwordd.charAt(i) == 'p'
                            || passwordd.charAt(i) == 'q' || passwordd.charAt(i) == 'r' || passwordd.charAt(i) == 's' || passwordd.charAt(i) == 't'
                            || passwordd.charAt(i) == 'u' || passwordd.charAt(i) == 'v' || passwordd.charAt(i) == 'w' || passwordd.charAt(i) == 'x'
                            || passwordd.charAt(i) == 'y' || passwordd.charAt(i) == 'z' || passwordd.charAt(i) == 'A' || passwordd.charAt(i) == 'B'
                            || passwordd.charAt(i) == 'C' || passwordd.charAt(i) == 'D' || passwordd.charAt(i) == 'E' || passwordd.charAt(i) == 'F'
                            || passwordd.charAt(i) == 'G' || passwordd.charAt(i) == 'H' || passwordd.charAt(i) == 'I' || passwordd.charAt(i) == 'J'
                            || passwordd.charAt(i) == 'K' || passwordd.charAt(i) == 'L' || passwordd.charAt(i) == 'M' || passwordd.charAt(i) == 'N'
                            || passwordd.charAt(i) == 'O' || passwordd.charAt(i) == 'P' || passwordd.charAt(i) == 'Q' || passwordd.charAt(i) == 'R'
                            || passwordd.charAt(i) == 'S' || passwordd.charAt(i) == 'T' || passwordd.charAt(i) == 'V' || passwordd.charAt(i) == 'W'
                            || passwordd.charAt(i) == 'X' || passwordd.charAt(i) == 'Y' || passwordd.charAt(i) == 'Z'){
                        huruf = 1;
                    }

                    if(passwordd.charAt(i) == '1' || passwordd.charAt(i) == '2' || passwordd.charAt(i) == '3' || passwordd.charAt(i) == '4'
                            || passwordd.charAt(i) == '5' || passwordd.charAt(i) == '6' || passwordd.charAt(i) == '7' || passwordd.charAt(i) == '8'
                            || passwordd.charAt(i) == '9' || passwordd.charAt(i) == '0'){
                        angka = 1;
                    }
                }
                //Validasi password alphanumeric

                //Validasi Username
                if (userrname.length() < 6 || userrname.length() > 12){
                    Toast.makeText(Register.this,"Username Length must between 6 - 12",Toast.LENGTH_LONG).show();
                }
                //Validasi Username

                //Validasi Password

                    //Validasi lenght passord harus lebih dari 8
                    else if(passwordd.length() <= 8){
                        Toast.makeText(Register.this,"Password Length must more than 8", Toast.LENGTH_LONG).show();
                    }
                    //Validasi lenght passord harus lebih dari 8

                    //Validasi password alphanumeric

//                    for (int i = 0; i < passwordd.length();i++){
//                        if(passwordd.indexOf(i) == 'a' || passwordd.indexOf(i) == 'b' || passwordd.indexOf(i) == 'c' || passwordd.indexOf(i) == 'd'
//                    || passwordd.indexOf(i) == 'e' || passwordd.indexOf(i) == 'f' || passwordd.indexOf(i) == 'g' || passwordd.indexOf(i) == 'h'
//                    || passwordd.indexOf(i) == 'i' || passwordd.indexOf(i) == 'j' || passwordd.indexOf(i) == 'k' || passwordd.indexOf(i) == 'l'
//                    || passwordd.indexOf(i) == 'm' || passwordd.indexOf(i) == 'n' || passwordd.indexOf(i) == 'o' || passwordd.indexOf(i) == 'p'
//                    || passwordd.indexOf(i) == 'q' || passwordd.indexOf(i) == 'r' || passwordd.indexOf(i) == 's' || passwordd.indexOf(i) == 't'
//                    || passwordd.indexOf(i) == 'u' || passwordd.indexOf(i) == 'v' || passwordd.indexOf(i) == 'w' || passwordd.indexOf(i) == 'x'
//                    || passwordd.indexOf(i) == 'y' || passwordd.indexOf(i) == 'z' || passwordd.indexOf(i) == 'A' || passwordd.indexOf(i) == 'B'
//                    || passwordd.indexOf(i) == 'C' || passwordd.indexOf(i) == 'D' || passwordd.indexOf(i) == 'E' || passwordd.indexOf(i) == 'F'
//                    || passwordd.indexOf(i) == 'G' || passwordd.indexOf(i) == 'H' || passwordd.indexOf(i) == 'I' || passwordd.indexOf(i) == 'J'
//                    || passwordd.indexOf(i) == 'K' || passwordd.indexOf(i) == 'L' || passwordd.indexOf(i) == 'M' || passwordd.indexOf(i) == 'N'
//                    || passwordd.indexOf(i) == 'O' || passwordd.indexOf(i) == 'P' || passwordd.indexOf(i) == 'Q' || passwordd.indexOf(i) == 'R'
//                    || passwordd.indexOf(i) == 'S' || passwordd.indexOf(i) == 'T' || passwordd.indexOf(i) == 'V' || passwordd.indexOf(i) == 'W'
//                    || passwordd.indexOf(i) == 'X' || passwordd.indexOf(i) == 'Y' || passwordd.indexOf(i) == 'Z'){
//                            huruf = 1;
//                        }
//
//                        if(passwordd.indexOf(i) == '1' || passwordd.indexOf(i) == '2' || passwordd.indexOf(i) == '3' || passwordd.indexOf(i) == '4'
//                        || passwordd.indexOf(i) == '5' || passwordd.indexOf(i) == '6' || passwordd.indexOf(i) == '7' || passwordd.indexOf(i) == '8'
//                        || passwordd.indexOf(i) == '9' || passwordd.indexOf(i) == '0'){
//                            angka = 1;
//                        }
//                    }

                    else if(huruf != 1 && angka != 1){
                        Toast.makeText(Register.this,"Password must contains alphanumeric", Toast.LENGTH_LONG).show();
                    }
                    //Validasi password alphanumeric

                    //Validasi confirm password
                    else if (!confirm_passworddd.equals(passwordd)){
                        Toast.makeText(Register.this,"Confirm password must same with password", Toast.LENGTH_LONG).show();
                    }
                    //Validasi confirm password

                //Validasi Password

                //Validasi phone_number
                else if (phone_numberrr.length() < 10 || phone_numberrr.length() > 12){
                    Toast.makeText(Register.this,"Phone number must between 10 and 12 digit", Toast.LENGTH_LONG).show();
                }
                else if (phone_numberrr.isEmpty()){
                    Toast.makeText(Register.this,"Phone number must be filled", Toast.LENGTH_LONG).show();
                }
                //Validasi phone_number

                //Validasi DoB
                else if(date_of_birth == 0 || month_of_birth == 0 || year_of_birth == 0){
                    Toast.makeText(Register.this,"Date of birth must be filled", Toast.LENGTH_LONG).show();
                }
                //Validasi DoB

                //Validasi checkbox
                else if(checked == false){
                    Toast.makeText(Register.this,"You must agreed the terms and condition", Toast.LENGTH_LONG).show();
                }
                //Validasi checknos

                else{
                    //Store Username
                    SharedPreferences.Editor share_username = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();
                    share_username.putString("username_key",userrname);
                    share_username.apply();
                    //Store Username

                    //Store Password
                    SharedPreferences.Editor share_password = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();
                    share_password.putString("password_key",passwordd);
                    share_password.apply();
                    //Store Password

                    //Store phone_number
                    SharedPreferences.Editor share_phone_number = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();
                    share_phone_number.putString("phone_number_key",phone_numberrr);
                    share_phone_number.apply();
                    //Store phone_number

                    //Store Gender
                    radio_button = findViewById(gender.getCheckedRadioButtonId());
                    String genderrr = radio_button.getText().toString();
                    SharedPreferences.Editor share_gender = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();
                    share_gender.putString("gender_key",genderrr);
                    share_gender.apply();
                    //Store Gender

                    //Store DoB
                    String Date_of_Birth = String.valueOf(date_of_birth) + " - " + String.valueOf(month_of_birth) + " - " + String.valueOf(year_of_birth);
                    SharedPreferences.Editor share_DoB = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();
                    share_DoB.putString("DoB_key",Date_of_Birth);
                    share_DoB.apply();
                    //Store DoB

                    //Generate & store user_id


                    //Ini pas user next-nextnya daftar
//                    if(!list_User.isEmpty()) {
//                        for (int i = 0; i < list_User.size(); i++){
//                            if (list_User.get(i+1).getUsername().isEmpty()){
//                                user_id = i+1;
//                            }
//                        }
//                    }
//                    Ini pas user next-nextnya daftar
                    int user_id = 0;
                    user_id++;

                    //Generate & store user_id
                    SharedPreferences.Editor id_user = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();
                    id_user.putString("user_id_key", String.valueOf(user_id));
                    id_user.apply();
                    //Generate & store user_id

                    //Store 1 objek user
//                    String wallet = "0";
                    User pengguna = new User(user_id,userrname,passwordd,genderrr,Date_of_Birth,phone_numberrr,0);//Ini objek yang mau distore
                    list_User.add(pengguna);// Tambahin ke vector

                    SharedPreferences.Editor list_user = PreferenceManager.getDefaultSharedPreferences(Register.this).edit();

                    Gson gson = new Gson();
                    String json_list_user = gson.toJson(list_User);

                    list_user.putString("list_user_key", json_list_user);
                    list_user.apply();
                    //Store 1 objek user

                    //Pindah ke Login Page
                    Intent intent = new Intent(Register.this,Login.class);
                    startActivity(intent);
                    //Pindah ke Login Page
                }

                tes.setText("Succesfull"); //BUAT TESTING
            }
        });
        //Methon tombol Register

    }




}