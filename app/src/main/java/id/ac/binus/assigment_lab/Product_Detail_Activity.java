package id.ac.binus.assigment_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;

public class Product_Detail_Activity extends AppCompatActivity {

    TextView product_name;
    TextView min_player;
    TextView max_player;
    TextView product_price;
    Button btn_buy_product;
    ArrayList<Product> list_product = new ArrayList<>();
//    ArrayList <User> list_user = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__detail_);
        product_name = findViewById(R.id.product_name);
        min_player = findViewById(R.id.min_player);
        max_player = findViewById(R.id.max_player);
        product_price = findViewById(R.id.product_price);
        btn_buy_product = findViewById(R.id.btn_buy_product);

        //Shared Preference buat ambil data
        SharedPreferences get_data = PreferenceManager.getDefaultSharedPreferences(Product_Detail_Activity.this);
        //Shared Preference buat ambil data

        //Shared Preference buat store data
        SharedPreferences.Editor store_data = PreferenceManager.getDefaultSharedPreferences(Product_Detail_Activity.this).edit();
        //Shared Preference buat store data

        //AMBIL DATA USER
        Gson gson = new Gson();
        String response = get_data.getString("list_user_key","null");
        Register.list_User = gson.fromJson(response,new TypeToken<List<User>>(){}.getType());
        int userke = get_data.getInt("userke",0);
        //AMBIL DATA USER

        //AMBIL DATA PRODUK
        response = get_data.getString("list_product_key","null");
        list_product = gson.fromJson(response,new TypeToken<List<Product>>(){}.getType());
        //AMBIL DATA PRODUK

        //AMBIL DATA PRODUK YANG DIPILIH USER DARI STORE
        Intent intent = getIntent();
        String nama_produk_dari_store = intent.getStringExtra("product_name_key");
        int min_player_dari_store = intent.getIntExtra("min_player__key", 0);
        int max_player_dari_store = intent.getIntExtra("max_player_key", 0);
        int price_produk_dari_store = intent.getIntExtra("product_price_key", 0);
        //AMBIL DATA PRODUK YANG DIPILIH USER DARI STORE

//        int produk_ke = 0;
//        for (int i = 0; i < list_product.size(); i++){
//            if (nama_produk_dari_store.equals(list_product.get(i).getProduct_name())){
//
//                break;
//            }
//        }

        product_name.setText(nama_produk_dari_store);
        min_player.setText(String.valueOf(min_player_dari_store));
        max_player.setText(String.valueOf(max_player_dari_store));
        product_price.setText(String.valueOf(price_produk_dari_store));

        //TES
        Toast.makeText(Product_Detail_Activity.this, String.valueOf( Register.list_User.get(userke).getList_transaction_history().size()), Toast.LENGTH_SHORT).show();
        //TES
        btn_buy_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validasi Walletnya gk cukup
                if( Register.list_User.get(userke).getWallet() < price_produk_dari_store){
                    Toast.makeText(Product_Detail_Activity.this,"Insufficient Wallet. Please Top Up Your Wallet",Toast.LENGTH_SHORT).show();
                }
                //Validasi Walletnya gk cukup

                else{
                    Transaction_History user_transaction_history = new Transaction_History(nama_produk_dari_store,"25 April 2001",price_produk_dari_store);
                    Register.list_User.get(userke).getList_transaction_history().add(user_transaction_history);

                    int wallet_customer =  Register.list_User.get(userke).getWallet() - price_produk_dari_store;
                    Register.list_User.get(userke).setWallet(wallet_customer);

                    //Store data user
                    Register.list_User.get(userke).convert_arraylist_to_string();
                    String json_list_user = gson.toJson(Register.list_User);
                    Log.e("json list user", json_list_user);
                    store_data.putString("list_user_key", json_list_user);
                    store_data.apply();
                    //Store data user

                    Toast.makeText(Product_Detail_Activity.this,"Payment Success",Toast.LENGTH_SHORT).show();
//                    //TES
//                    Toast.makeText(Product_Detail_Activity.this, String.valueOf(list_user.get(userke).getList_transaction_history().size()), Toast.LENGTH_SHORT).show();
//                    //TES
                    //TES
                    for (int i = 0; i < Register.list_User.get(userke).getList_transaction_history().size(); i++){
                        if (Register.list_User.get(userke).getList_transaction_history().size() > 1){
                            Toast.makeText(Product_Detail_Activity.this,Register.list_User.get(userke).getList_transaction_history().get(1).getProduct_name(),Toast.LENGTH_SHORT).show();
                        }

                    }
                    //TES
                    Intent intent = new Intent(Product_Detail_Activity.this,HomePage.class);
                    startActivity(intent);
                }

            }
        });
    }
}