package id.ac.binus.assigment_lab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Product> product_vector;

    public ProductAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setProduct_vector(ArrayList<Product> product_vector) {
        this.product_vector = product_vector;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.product_item, parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        //set data
        holder.product_name_txt.setText(product_vector.get(position).getProduct_name());
        holder.product_min_player_txt.setText("Min Player: " +  String.valueOf(product_vector.get(position).getProduct_min_player()));
        holder.product_max_player_txt.setText("Max Player: " + String.valueOf(product_vector.get(position).getProduct_max_player()));
        holder.product_price_txt.setText(String.valueOf("Price: " + product_vector.get(position).getProduct_price()));

        holder.product_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DI SINI BUAT PINDAH HALAMAN KE "PRODUCT DETAIL DAN STORE DATANYA"
                ctx.startActivity(new Intent(ctx, Product_Detail_Activity.class));
                Intent intent = new Intent(ctx, Product_Detail_Activity.class);
                intent.putExtra("product_id_key", product_vector.get(position).getProduct_id());
                intent.putExtra("product_name_key", product_vector.get(position).getProduct_name());
                intent.putExtra("min_player__key", product_vector.get(position).getProduct_min_player());
                intent.putExtra("max_player_key", product_vector.get(position).getProduct_max_player());
                intent.putExtra("product_price_key", product_vector.get(position).getProduct_price());
                ctx.startActivity(intent);
//                Toast.makeText(ctx,product_vector.get(position).getProduct_name(), Toast.LENGTH_SHORT).show();
                //DI SINI BUAT PINDAH HALAMAN KE "PRODUCT DETAIL DAN STORE DATANYA"

            }
        });
    }

    @Override
    public int getItemCount() {
        return product_vector.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView product_name_txt, product_min_player_txt, product_max_player_txt, product_price_txt;
        CardView product_cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //get component
            product_name_txt = itemView.findViewById(R.id.product_name_txt);
            product_min_player_txt = itemView.findViewById(R.id.product_min_player_txt);
            product_max_player_txt = itemView.findViewById(R.id.product_max_player_txt);
            product_price_txt = itemView.findViewById(R.id.product_price_txt);
            product_cv = itemView.findViewById(R.id.product_cv);
        }
    }
}
