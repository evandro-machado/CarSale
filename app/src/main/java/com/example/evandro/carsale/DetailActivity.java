package com.example.evandro.carsale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    String[] cor = {"Preto", "Prata", "Azul", "Vermelho", "Branco", "Vermelho", "Prata", "Preto", "Prata", "Branca"};
    String[] fabricante = {"Wolksvagen", "Fiat", "Fiat", "Wolksvagen", "Fiat", "Chevrolet", "Wolkswagen", "Hyundai", "Chevrolet", "BMW"};
    int position;
    List<Integer> idCarrosComprados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            TextView modeloEditText = (TextView) findViewById(R.id.modeloTextView);
            TextView fabricanteEditText = (TextView) findViewById(R.id.fabricanteTextView);
            TextView corEditText = (TextView) findViewById(R.id.corTextView);
            TextView precoEditText = (TextView) findViewById(R.id.precoTextView);
            ImageView imageView = (ImageView) findViewById(R.id.img);


            idCarrosComprados = params.getIntegerArrayList("idCarrosComprados");

            if(idCarrosComprados != null){
                System.out.println("carros passou pela intent");
            }else{
                System.out.println("nao passou pela intent");
            }
            String modeloStr = params.getString("modelo");
            Double preco = params.getDouble("preco", 0);
            int imagemId = params.getInt("imagemId",10);
            position = params.getInt("position",10);
            String corStr = cor[position];
            String fabricanteStr = fabricante[position];

            modeloEditText.setText(modeloStr);
            fabricanteEditText.setText(fabricanteStr);
            corEditText.setText(corStr);
            precoEditText.setText(Double.toString(preco));
            imageView.setImageResource(imagemId);
        }
    }

    public void comprar(View view){
        idCarrosComprados.add(position);
        Toast.makeText(DetailActivity.this, "Carro comprado com sucesso!" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Bundle params = new Bundle();
        params.putIntegerArrayList("idCarrosComprados", (ArrayList<Integer>) idCarrosComprados);
        Intent it = new Intent(this, MasterActivity.class);
        it.putExtras(params);
        startActivity(it);
        super.onBackPressed();
    }
}
