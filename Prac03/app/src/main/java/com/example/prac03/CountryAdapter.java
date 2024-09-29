package com.example.prac03;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.widget.ImageView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Country> countryList;
    private Context context;

    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country currentCountry = countryList.get(position);
        holder.textViewCountryName.setText(currentCountry.getName());
        holder.textViewPopulation.setText("Dân số: " + currentCountry.getPopulation());
        holder.imageViewFlag.setImageResource(currentCountry.getFlagResource());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Country country = countryList.get(holder.getAdapterPosition());
                Intent intent = new Intent(context, CountryDetailActivity.class);
                intent.putExtra("countryName", country.getName());
                intent.putExtra("population", country.getPopulation());
                intent.putExtra("details", country.getDetails());
                intent.putExtra("flagResource", country.getFlagResource());
                intent.putExtra("area", country.getArea());
                intent.putExtra("density", country.getDensity());
                intent.putExtra("worldShare", country.getWorldShare());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCountryName;
        TextView textViewPopulation;
        ImageView imageViewFlag;
        LinearLayout item;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCountryName = itemView.findViewById(R.id.textView_countryName);
            textViewPopulation = itemView.findViewById(R.id.textView_population);
            imageViewFlag = itemView.findViewById(R.id.imageView_flag);
            item = itemView.findViewById(R.id.item);
        }
    }
}
