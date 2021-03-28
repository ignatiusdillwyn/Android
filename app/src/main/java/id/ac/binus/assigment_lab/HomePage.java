package id.ac.binus.assigment_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    TextView wallet;
    TextView transaction_history_txt;
    RecyclerView homeRecycler;

//    ArrayList<User> list_user = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        wallet = findViewById(R.id.wallet);
        transaction_history_txt = findViewById(R.id.transaction_history_txt);
        homeRecycler = findViewById(R.id.transaction_history_rv);



        //Shared Preference buat ambil data
        SharedPreferences get_data = PreferenceManager.getDefaultSharedPreferences(HomePage.this);
        //Shared Preference buat ambil data

        //Shared Preference buat store data
        SharedPreferences.Editor store_data = PreferenceManager.getDefaultSharedPreferences(HomePage.this).edit();
        //Shared Preference buat store data

        //AMBIL DATA USER
        Gson gson = new Gson();
        String response = get_data.getString("list_user_key","null");
        Register.list_User = gson.fromJson(response,new TypeToken<List<User>>(){}.getType());
        Log.e("list user key response", response);
        int userke = get_data.getInt("userke",0);
        //AMBIL DATA USER

        for (int i = 0; i < Register.list_User.size(); i++){
            Log.e(i+"", Register.list_User.get(i).getUsername());
        }
//        //TES
//        Toast.makeText(HomePage.this, "dor" + String.valueOf(list_user.get(userke).getList_transaction_history().size()), Toast.LENGTH_SHORT).show();
//        //TES

        if (Register.list_User.get(userke).getList_transaction_history().isEmpty()){
            transaction_history_txt.setText("You don't have any transaction history");
        }

        else{
            //SETTING RECYVLER VIEW
            Register.list_User.get(userke).convert_string_to_arraylist();
            HomePage_Adapter homePage_adapter = new HomePage_Adapter(this);
            homePage_adapter.setUserArralist(Register.list_User);
//            homePage_adapter.notifyDataSetChanged();
            homePage_adapter.setUserke(userke);

            homeRecycler.setAdapter(homePage_adapter);
//            homeRecycler.setLayoutManager(new GridLayoutManager(this, 1));
            homeRecycler.setLayoutManager(new LinearLayoutManager(this));
            //SETTING RECYVLER VIEW
        }


        //SET TEXT WALLET
        wallet.setText("Rp " +  String.valueOf(Register.list_User.get(userke).getWallet()));
        //SET TEXT WALLET

        //TES
//        Toast.makeText(this, String.valueOf( Register.list_User.get(userke).getList_transaction_history().size()), Toast.LENGTH_SHORT).show();
//
//        for (int i = 0; i < Register.list_User.get(userke).getList_transaction_history().size(); i++){
//            if (Register.list_User.get(userke).getList_transaction_history().size() > 1){
//                Toast.makeText(this,Register.list_User.get(userke).getList_transaction_history().get(1).getProduct_name(),Toast.LENGTH_SHORT).show();
//                break;
//            }
//
//        }
        //TES


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_homepage, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.homeee:
                Intent intent = new Intent(HomePage.this,HomePage.class);
                startActivity(intent);
                return true;

            case R.id.storeee:
                Intent intent_to_store = new Intent(HomePage.this,Store.class);
                startActivity(intent_to_store);
                return true;

            case R.id.profileeee:
                Intent intent_to_profile = new Intent(HomePage.this,Profile.class);
                startActivity(intent_to_profile);
                return true;

            case R.id.logoutttt:
                Intent intent_to_login = new Intent(HomePage.this,Login.class);
                startActivity(intent_to_login);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}