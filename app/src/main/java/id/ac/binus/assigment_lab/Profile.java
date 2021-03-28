package id.ac.binus.assigment_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

    TextView username;
    TextView date_of_birth;
    TextView gender;
    TextView phone_number;
    TextView wallet;
    RadioGroup topup;
    RadioButton radionbutton;
    EditText password;
    Button btn_confirm;
    TextView tesss;
//    ArrayList<User> list_user = new ArrayList<>();
    Integer datake = 0;
    String tampung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        username = findViewById(R.id.username);
        date_of_birth = findViewById(R.id.DoB);
        gender = findViewById(R.id.gender);
        phone_number = findViewById(R.id.phone_number);
        wallet = findViewById(R.id.wallet);
        topup = findViewById(R.id.top_up);
        password = findViewById(R.id.password);
        btn_confirm = findViewById(R.id.btn_confirm_top_up);
        tesss = findViewById(R.id.tes);
        radionbutton = findViewById(R.id.topup1);

        Intent intent = getIntent();

        //Ambil semua data user
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Profile.this);


        Gson gson = new Gson();
        String response = sp.getString("list_user_key","null");
        Register.list_User = gson.fromJson(response,new TypeToken<List<User>>(){}.getType());
        //Ambil semua data user

        //TESTING DATA MASUK DARI LOGIN PAGE
        String usernameee = sp.getString("username_from_login","null");
        String passwordddd = sp.getString("password_from_login","null");
//        tesss.setText(usernameee + " " + passwordddd + " " + list_user.get(0).getUsername() + " "  + list_user.get(0).getPassword() + " " + list_user.get(0).getWallet());

//        Toast.makeText(Profile.this,tampung, Toast.LENGTH_LONG).show();
        //TESTING DATA MASUK DARI LOGIN PAGE



        int cocok = 0;

        if (! Register.list_User.isEmpty()){
            for (int i = 0; i <  Register.list_User.size(); i++){
                if(usernameee.equals( Register.list_User.get(i).getUsername())){
                    cocok = 1;
                    datake = i;
                }
            }
        }


        if (cocok == 1){
            username.setText( Register.list_User.get(datake).getUsername());
            date_of_birth.setText( Register.list_User.get(datake).getDob());
            gender.setText( Register.list_User.get(datake).getGender());
            phone_number.setText( Register.list_User.get(datake).getPhone_number());
            wallet.setText("Rp." +  Register.list_User.get(datake).getWallet());
        }



        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TOP UP
                radionbutton = findViewById(topup.getCheckedRadioButtonId());
                String harga = radionbutton.getText().toString();
                int wallet = 0;

                if (harga.equals("Rp.250.000")){
                    wallet =  Register.list_User.get(datake).getWallet() + 250000;
                    Register.list_User.get(datake).setWallet(wallet);
                }

                if (harga.equals("Rp.500.000")){
                    wallet =  Register.list_User.get(datake).getWallet() + 500000;
                    Register.list_User.get(datake).setWallet(wallet);
                }

                if (harga.equals("Rp.1.000.000")){
                    wallet =  Register.list_User.get(datake).getWallet() + 1000000;
                    Register.list_User.get(datake).setWallet(wallet);
                }
                // TOP UP

                //TESTING
                tampung = String.valueOf( Register.list_User.get(datake).getWallet());
//                Toast.makeText(Profile.this,tampung,Toast.LENGTH_LONG).show();
                //TESTING

                //VALIDASI PASSWORD
                String password_from_input = password.getText().toString();
                if (!password_from_input.equals( Register.list_User.get(datake).getPassword())){
                    Toast.makeText(Profile.this,"Password is Wrong",Toast.LENGTH_LONG).show();
                }
                //VALIDASI PASSWORD

                else{
                    //STORE DATA
                    String json_list_user = gson.toJson( Register.list_User);
                    SharedPreferences.Editor list_user = PreferenceManager.getDefaultSharedPreferences(Profile.this).edit();
                    list_user.putString("list_user_key", json_list_user);
                    list_user.apply();
                    //STORE DATA

                    Intent intent = new Intent(Profile.this, Store.class);
//                Intent intent = new Intent(Profile.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}