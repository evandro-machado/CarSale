package com.example.evandro.carsale;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCellVendidos extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] carro;

    public ListCellVendidos(Activity context, String[] carro){
        super(context, R.layout.list_cell, carro);
        this.context = context;
        this.carro = carro;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cellvendidos, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.modelo);
        txtTitle.setText(carro[position]);
        return rowView;
    }

}
