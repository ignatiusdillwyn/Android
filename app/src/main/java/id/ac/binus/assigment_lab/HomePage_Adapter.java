package id.ac.binus.assigment_lab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class HomePage_Adapter extends RecyclerView.Adapter<HomePage_Adapter.ViewHolder> {

    Context ctx;
    ArrayList<User> userArrayist;
    int userke;

    public void setUserke(int userke) {
        this.userke = userke;
    }

    public void setUserArralist(ArrayList<User> userArraylist) {
        this.userArrayist = userArraylist;
    }

    public HomePage_Adapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HomePage_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.home_page_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePage_Adapter.ViewHolder holder, int position) {
        //set data
        holder.product_name_txt.setText("Product Name: " + userArrayist.get(userke).getList_transaction_history().get(position).getProduct_name());
        holder.product_price_txt.setText("Product Price: Rp " + String.valueOf(userArrayist.get(userke).getList_transaction_history().get(position).getProduct_price()));
        holder.transaction_date_txt.setText("Transaction_Date: " + userArrayist.get(userke).getList_transaction_history().get(position).getTransaction_date());

//        holder.product_name_txt.setText(Register.list_User.get(userke).getList_transaction_history().get(position).getProduct_name());
//        holder.product_price_txt.setText(String.valueOf(Register.list_User.get(userke).getList_transaction_history().get(position).getProduct_price()));
//        holder.transaction_date_txt.setText(Register.list_User.get(userke).getList_transaction_history().get(position).getTransaction_date());

        final User infoData =userArrayist.get(position);

        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(infoData);

                Gson gson = new Gson();
                SharedPreferences.Editor store_data = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
                String json_list_user = gson.toJson(userArrayist);
                store_data.putString("list_user_key", json_list_user);
                store_data.apply();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userArrayist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView product_name_txt;
        TextView product_price_txt;
        TextView transaction_date_txt;
        Button delete_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //get component
            product_name_txt = itemView.findViewById(R.id.product_name_home_txt);
            product_price_txt = itemView.findViewById(R.id.product_price_home_txt);
            transaction_date_txt = itemView.findViewById(R.id.transaction_date_home_txt);
            delete_btn = itemView.findViewById(R.id.delete_btn);
        }
    }

    public void removeItem(User infoData) {
        int currPosition = userArrayist.indexOf(infoData);
        userArrayist.remove(currPosition);
        notifyItemRemoved(currPosition);
    }
}
