package id.ac.binus.assigment_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Store extends AppCompatActivity {


//    ArrayList<User> list_user = new ArrayList<>();
    ArrayList<Product> list_product = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        RecyclerView productrecycler = findViewById(R.id.store_rv);



        //Shared Preference buat ambil data
        SharedPreferences get_data = PreferenceManager.getDefaultSharedPreferences(Store.this);
        //Shared Preference buat ambil data

        //Shared Preference buat store data
        SharedPreferences.Editor store_data = PreferenceManager.getDefaultSharedPreferences(Store.this).edit();
        //Shared Preference buat store data

        //AMBIL DATA USER
        Gson gson = new Gson();
        String response = get_data.getString("list_user_key","null");
        Register.list_User = gson.fromJson(response,new TypeToken<List<User>>(){}.getType());
        int userke = get_data.getInt("userke",0);
        //AMBIL DATA USER


        //ADD PRODUCT
        Product product_1 = new Product(1,"Explodding Kitten", 2,5,250000,106.265139, -6.912035);
        Product product_2 = new Product(2, "Card Against Humanity",2,4,182500, 108.126810, -7.586037);
        list_product.add(product_1);
        list_product.add(product_2);
        //ADD PRODUCT

        //STORE DATA PRODUK
        SharedPreferences.Editor sp = PreferenceManager.getDefaultSharedPreferences(Store.this).edit();
        String json_list_product = gson.toJson(list_product);
        sp.putString("list_product_key", json_list_product);
        sp.apply();
        //STORE DATA PRODUK

        //SETTING RECYVLER VIEW
        ProductAdapter product_adapter = new ProductAdapter(this);
        product_adapter.setProduct_vector(list_product);

        productrecycler.setAdapter(product_adapter);
        productrecycler.setLayoutManager(new GridLayoutManager(this,2));
        //SETTING RECYVLER VIEW


//        String tampung = String.valueOf(userke);
//        Toast.makeText(Store.this,tampung, Toast.LENGTH_LONG).show();
    }


}