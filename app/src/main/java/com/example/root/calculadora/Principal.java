package com.example.root.calculadora;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Principal extends ListActivity {
    //Meu Array contendo a minha listagem de calculadoras
    String[] listagem_calcs = new String[] {"Modelo 1","Modelo 2","Modelo 3","Modelo 4"};
    ArrayAdapter <String> meu_adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        meu_adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listagem_calcs);
        setListAdapter(meu_adaptador);
        super.onCreate(savedInstanceState);
    }



    // utilizando o atalho Alt+Insert para sobrescrever um metodo da superclasse
    /*
    * Essa clase é usada para
    * */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        //passando parâmetros para o construtor do objeto
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, "Clicou em "+listagem_calcs[position],Toast.LENGTH_SHORT).show();

        Intent intent;

        switch(position)
        {
            case 0 :
                // Vai para a calculadora do modelo 1
                intent = new Intent(Principal.this,CalcModelo1.class);
                startActivity(intent);
                break;

            case 1 :
                // Vai para a calculadora do modelo 2
                intent = new Intent(Principal.this,CalcModelo2.class);
                startActivity(intent);
                break;

            case 2 :
                // Vai para a calculadora do modelo 3
                intent = new Intent(Principal.this,CalcModelo3.class);
                startActivity(intent);
                break;
            case 3 :
                // Vai para a calculadora do modelo 4
                intent = new Intent(Principal.this,CalcModelo4.class);
                startActivity(intent);
                break;

        }

    }
}
