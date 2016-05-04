package com.example.evandro.carsale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MasterActivity extends AppCompatActivity {
    ListView list;
    String[] cor = {"Preto", "Prata", "Azul", "Vermelho", "Branco", "Vermelho", "Prata", "Preto", "Prata", "Branca"};

//            [2,3,1,2,0...]
    String[] carro = {"Gol", "Uno", "Palio", "Fox BlueMotion", "Siena EL", "Celta", "Voyage", "HB20", "Onix", "320i"};
    Double[] preco = {35432.67, 31765.32, 25056.55, 46987.89, 37767.87, 29877.65, 45899.55, 33789.99, 39898.77, 120766.78};
    Integer[] imageId = {R.drawable.gol, R.drawable.uno,R.drawable.palio,R.drawable.fox,R.drawable.siena,R.drawable.celta,R.drawable.voyage,R.drawable.hb20,R.drawable.onix,R.drawable.bm320i};
    List<Integer> idCarrosComprados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        ListCell adapter = new ListCell(MasterActivity.this, carro, imageId, preco);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent itRetorno = getIntent();
                if(itRetorno != null){
                    if(itRetorno.getExtras() != null){
                        Bundle params = itRetorno.getExtras();
                        idCarrosComprados = params.getIntegerArrayList("idCarrosComprados");
                        System.out.println("Encheu a lista da activity detail");
                    }else{
                        idCarrosComprados = new ArrayList<Integer>();
                    }
                }else{
                    idCarrosComprados = new ArrayList<Integer>();
                }


//                if(itRetorno != null){
//                    idCarrosComprados = new ArrayList<>();
//                }
                Carro carroObj = new Carro();
                carroObj.toArray();
                Intent it = new Intent(MasterActivity.this, DetailActivity.class);
                Bundle params = new Bundle();
                params.putIntegerArrayList("idCarrosComprados", (ArrayList<Integer>) idCarrosComprados);
                params.putInt("position", position);
                params.putString("modelo", carro[position]);
                params.putDouble("preco", preco[position]);
                params.putInt("imagemId", imageId[position]);
                it.putExtras(params);

                for(Integer idCarro : idCarrosComprados){
                    System.out.println("Id do carro:" + idCarro.longValue());
                }
                startActivity(it);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent itRetorno = getIntent();
        if(itRetorno != null){
            if(itRetorno.getExtras() != null){
                Bundle params = itRetorno.getExtras();
                idCarrosComprados = params.getIntegerArrayList("idCarrosComprados");
                System.out.println("Encheu a lista da activity detail");
            }else{
                idCarrosComprados = new ArrayList<Integer>();
            }
        }else{
            idCarrosComprados = new ArrayList<Integer>();
        }
        System.out.println("chamou onResume");
        for(Integer idCarro : idCarrosComprados){
            System.out.println("Id do carro:" + idCarro.longValue());
        }
    }

    public void relatorio(View view){
        Intent itRetorno = getIntent();
        if(itRetorno != null){
            if(itRetorno.getExtras() != null){
                Bundle params = itRetorno.getExtras();
                idCarrosComprados = params.getIntegerArrayList("idCarrosComprados");
                System.out.println("Encheu a lista da activity detail");
            }else{
                idCarrosComprados = new ArrayList<Integer>();
            }
        }else{
            idCarrosComprados = new ArrayList<Integer>();
        }

        Intent it = new Intent(this, RelatorioActivity.class);
        Bundle params = new Bundle();
        params.putIntegerArrayList("idCarrosComprados", (ArrayList<Integer>) idCarrosComprados);
        it.putExtras(params);
        startActivity(it);

    }
}
