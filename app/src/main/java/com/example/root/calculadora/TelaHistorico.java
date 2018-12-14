package com.example.root.calculadora;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

public class TelaHistorico extends ListActivity{
    //Esse é o array que contem o texto do Histórico para exibir na tela;
    private ArrayList<String> arrayExibicao = new ArrayList<>();
    private ArrayAdapter<String> meuAdaptador;
    private String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Objetohistorico> hist = (ArrayList<Objetohistorico>) getIntent().getSerializableExtra("arrayHistorico");

        for (int i=0;i < hist.size();i++){

            texto = hist.get(i).getN1()+" "+hist.get(i).getOperacao()+" "+hist.get(i).getN2()+" = "+hist.get(i).getResultado();
            arrayExibicao.add(texto);
        }
        meuAdaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayExibicao);
        setListAdapter(meuAdaptador);
    }
}
