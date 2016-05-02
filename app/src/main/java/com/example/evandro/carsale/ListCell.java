package com.example.evandro.carsale;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCell extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] carro;
    private final Integer[] imageId;
    private final Double[] preco;

    public ListCell(Activity context, String[] carro, Integer[] imageId, Double[] preco){
        super(context, R.layout.list_cell, carro);
        this.context = context;
        this.carro = carro;
        this.imageId = imageId;
        this.preco = preco;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView txtPreco = (TextView) rowView.findViewById(R.id.txtPreco);
        ImageView imgView = (ImageView) rowView.findViewById(R.id.img);
        String precoStr = String.format("R$ %.2f", preco[position]);
        txtPreco.setText(precoStr);
        txtTitle.setText(carro[position]);
        imgView.setImageResource(imageId[position]);
        return rowView;
    }

}
