package com.example.evandro.carsale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class RelatorioActivity extends AppCompatActivity {

    ListView list;
    List<Integer> idCarrosComprados;
    TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        String[] carro = {"Gol", "Uno", "Palio", "Fox BlueMotion", "Siena EL", "Celta", "Voyage", "HB20", "Onix", "320i"};
        Double[] preco = {35432.67, 31765.32, 25056.55, 46987.89, 37767.87, 29877.65, 45899.55, 33789.99, 39898.77, 120766.78};
        Double total = 0.0;
        Intent it = getIntent();
        totalTextView = (TextView) findViewById(R.id.total);
        totalTextView.setText("Total: R$ 00.00");
        if(it != null){
            Bundle params = it.getExtras();
            idCarrosComprados = params.getIntegerArrayList("idCarrosComprados");

            if(idCarrosComprados != null){
                System.out.println("carros passou pela intent");
            }else{
                System.out.println("nao passou pela intent");
            }

            int[] idsCarrosInt = convertIntegers(idCarrosComprados);
            String[] modelosArray = new String[idsCarrosInt.length];
            for(int i = 0 ; i < idsCarrosInt.length; i++){
                modelosArray[i] = carro[idsCarrosInt[i]];
                total += preco[idsCarrosInt[i]];
            }
            totalTextView.setText(String.format("Total: R$ %.2f", total));


            ListCellVendidos adapter = new ListCellVendidos(RelatorioActivity.this, modelosArray);
            list = (ListView) findViewById(R.id.listView);
            list.setAdapter(adapter);
        }
    }
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}
