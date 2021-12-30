package de.juljano.myaquarium;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CardviewAdapter extends RecyclerView.Adapter<CardviewAdapter.CardviewHolder> {

    //this context we will use to inflate the layout
    private Context context;

    private View view;
    //we are storing all the information in a list
    private List<AquariumValues> aquariumValues;


    public CardviewAdapter(MainActivity context, List<AquariumValues> aquariumValueslist) {
        this.context = context;
        this.view = view;
        this.aquariumValues =  aquariumValueslist;
    }


    @NonNull
    @Override
    public CardviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_layout, null);
        CardviewHolder cardviewHolder = new CardviewHolder(view);
        return cardviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardviewHolder holder, int position) {

        final AquariumValues getValues = aquariumValues.get(position);

        holder.textViewTemperatur.setText(" Temperatur:   " + getValues.getTemperatur());
        holder.textViewpH.setText(" pH:   " + getValues.getpH());
        holder.textViewWattage.setText(" Watt:   " + getValues.getWattage());
        holder.textViewTDS.setText(" TDS:   " + getValues.getTds());
        holder.textViewInfo.setText(" Beleuchtung:   " + getValues.getLightStatus());

    }


    @Override
    public int getItemCount() {
        return aquariumValues.size();
    }

    public class CardviewHolder extends RecyclerView.ViewHolder {
        TextView textViewTemperatur;
        TextView textViewTDS;
        TextView textViewpH;
        TextView textViewInfo;
        TextView textViewWattage;

        public CardviewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTemperatur = itemView.findViewById(R.id.textviewTemperatur);
            textViewTDS = itemView.findViewById(R.id.textviewTDS);
            textViewpH = itemView.findViewById(R.id.textviewpH);
            textViewInfo = itemView.findViewById(R.id.textviewInfo);
            textViewWattage = itemView.findViewById(R.id.textviewWattage);
        }
    }
}
