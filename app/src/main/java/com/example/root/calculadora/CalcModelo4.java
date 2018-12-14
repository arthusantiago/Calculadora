package com.example.root.calculadora;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CalcModelo4 extends AppCompatActivity {
    private Double n1,n2, result;
    private AlertDialog.Builder diag_mensagem;
    private ArrayList<Objetohistorico> list_historico = new ArrayList<>();
    private Button historico;
    private Spinner bt_spinner;
    private ObjCalc objcalc = new ObjCalc();
    private DecimalFormat df2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcmodelo4);

        //Essa é a declaração dos meus objetos que eu irei manipular da view (tela do telefone)
        //depois de declarar essas variáveis e fazer o findViewById eu devo considerar que estou manipulando os elementos da view.
        objcalc.setCampo1(findViewById(R.id.campo1));
        objcalc.setCampo2(findViewById(R.id.campo2));
        objcalc.setBt_limpar(findViewById(R.id.limpar));
        objcalc.setBt_voltar(findViewById(R.id.voltar));
        objcalc.setTv(findViewById(R.id.resultado));
        historico = findViewById(R.id.historico);
        bt_spinner = findViewById(R.id.spinner);

        ArrayList<String> opcoesSpinner = new ArrayList<>();
        opcoesSpinner.add("Selecione uma opção: ");
        opcoesSpinner.add("Somar");
        opcoesSpinner.add("Subtrair");
        opcoesSpinner.add("Multiplicar");
        opcoesSpinner.add("Dividir");
        //Construindo adaptador do Spinner
        ArrayAdapter<String> spinnerArrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,opcoesSpinner)
        {
            //Desabilitar a primeira opção do Array opcoesSpinner
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Desabilita o primeiro item o transforma em hint(sugestão) da list
                    return false;
                }else
                {
                    return true;
                }
            }
            //
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Deixa o primeiro item em cinza
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        bt_spinner.setAdapter(spinnerArrayAdapter);

        bt_spinner.setOnItemSelectedListener(ouvinteSpinner);
        historico.setOnClickListener(ouvinteHistorico);

        //Escutando os "Clicks" do botão, setando e executando alguma função;
        objcalc.setBt_limpar(ouvinteLimpar);
        objcalc.setBt_voltar(ouvinteVoltar);
    }



    AdapterView.OnItemSelectedListener ouvinteSpinner = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int intemSelecionadoLong = (int)bt_spinner.getSelectedItemPosition();
            switch(intemSelecionadoLong)
            {
                case 1:
                    Somar();
                    break;
                case 2:
                    Subtrair();
                    break;
                case 3:
                    Multiplicar();
                    break;
                case 4:
                    Dividir();
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };



    //função botão de somar
    public void Somar()
    {
        //mensagem de alerta;
        diag_mensagem = new AlertDialog.Builder(CalcModelo4.this);
        diag_mensagem.setTitle("Calculadora");

        //Essa condicional mais externa está verificando se os dois campos estão vazios;
        if(objcalc.getCampo1().getText().toString().trim().equals("") && objcalc.getCampo2().getText().toString().trim().equals(""))
        {
            diag_mensagem.setMessage("Você precisa preenchar algum campo!");
            diag_mensagem.setNeutralButton("OK",null);
            diag_mensagem.show();
        }else{
            if(TextUtils.isEmpty(objcalc.getCampo1().getText().toString())){
                objcalc.getCampo1().setError("");
            }else if(TextUtils.isEmpty(objcalc.getCampo2().getText().toString())){
                objcalc.getCampo2().setError("");
            }else{
                //pegando os valores para setar nas variáveis
                n1 = Double.parseDouble(objcalc.getCampo1().getText().toString());
                n2 = Double.parseDouble(objcalc.getCampo2().getText().toString());
                result = n1 + n2;
                objcalc.getTv().setText("Resultado: "+Double.toString(result));

                //salvando no array
                Objetohistorico hist = new Objetohistorico();
                hist.setN1(Double.toString(n1));
                hist.setN2(Double.toString(n2));
                hist.setOperacao("+");
                hist.setResultado(Double.toString(result));
                list_historico.add(hist);
            }
        }
    }



    //função botão de Subtrair
    public void Subtrair()
    {
        //mensagem de alerta;
        diag_mensagem = new AlertDialog.Builder(CalcModelo4.this);
        diag_mensagem.setTitle("Calculadora");

        //Essa condicional mais externa está verificando se os dois campos estão vazios;
        if(objcalc.getCampo1().getText().toString().trim().equals("") && objcalc.getCampo2().getText().toString().trim().equals(""))
        {
            diag_mensagem.setMessage("Você precisa preenchar algum campo!");
            diag_mensagem.setNeutralButton("OK",null);
            diag_mensagem.show();
        }else{
            if(TextUtils.isEmpty(objcalc.getCampo1().getText().toString())){
                objcalc.getCampo1().setError("");
            }else if(TextUtils.isEmpty(objcalc.getCampo2().getText().toString())){
                objcalc.getCampo2().setError("");
            }else{
                //pegando os valores para setar nas variáveis
                n1 = Double.parseDouble(objcalc.getCampo1().getText().toString());
                n2 = Double.parseDouble(objcalc.getCampo2().getText().toString());
                result = n1 - n2;
                objcalc.getTv().setText("Resultado: "+Double.toString(result));

                //salvando no array
                Objetohistorico hist = new Objetohistorico();
                hist.setN1(Double.toString(n1));
                hist.setN2(Double.toString(n2));
                hist.setOperacao("-");
                hist.setResultado(Double.toString(result));
                list_historico.add(hist);
            }
        }
    }



    //função botão de Multiplicar
    public void Multiplicar()
    {
        //mensagem de alerta;
        diag_mensagem = new AlertDialog.Builder(CalcModelo4.this);
        diag_mensagem.setTitle("Calculadora");

        //Essa condicional mais externa está verificando se os dois campos estão vazios;
        if(objcalc.getCampo1().getText().toString().trim().equals("") && objcalc.getCampo2().getText().toString().trim().equals(""))
        {
            diag_mensagem.setMessage("Você precisa preenchar algum campo!");
            diag_mensagem.setNeutralButton("OK",null);
            diag_mensagem.show();
        }else{
            if(TextUtils.isEmpty(objcalc.getCampo1().getText().toString())){
                objcalc.getCampo1().setError("");
            }else if(TextUtils.isEmpty(objcalc.getCampo2().getText().toString())){
                objcalc.getCampo2().setError("");
            }else{
                //pegando os valores para setar nas variáveis
                n1 = Double.parseDouble(objcalc.getCampo1().getText().toString());
                n2 = Double.parseDouble(objcalc.getCampo2().getText().toString());
                result = n1 * n2;
                df2 = new DecimalFormat(".##");
                objcalc.getTv().setText("Resultado: "+ df2.format(result));

                //salvando no array o historico
                Objetohistorico hist = new Objetohistorico();
                hist.setN1(Double.toString(n1));
                hist.setN2(Double.toString(n2));
                hist.setOperacao("*");
                hist.setResultado(Double.toString(result));
                list_historico.add(hist);
            }
        }
    }



    //função botão de Dividir
    public void Dividir()
    {
        //mensagem de alerta;
        diag_mensagem = new AlertDialog.Builder(CalcModelo4.this);
        diag_mensagem.setTitle("Calculadora");

        //Essa condicional mais externa está verificando se os dois campos estão vazios;
        if(objcalc.getCampo1().getText().toString().trim().equals("") && objcalc.getCampo2().getText().toString().trim().equals(""))
        {
            diag_mensagem.setMessage("Você precisa preenchar algum campo!");
            diag_mensagem.setNeutralButton("OK",null);
            diag_mensagem.show();
        }else{
            if(TextUtils.isEmpty(objcalc.getCampo1().getText().toString())){
                objcalc.getCampo1().setError("");
            }else if(TextUtils.isEmpty(objcalc.getCampo2().getText().toString())){
                objcalc.getCampo2().setError("");
            }else{
                //pegando os valores para setar nas variáveis
                n1 = Double.parseDouble(objcalc.getCampo1().getText().toString());
                n2 = Double.parseDouble(objcalc.getCampo2().getText().toString());
                result = n1 / n2;
                df2 = new DecimalFormat(".##");
                objcalc.getTv().setText("Resultado: "+ df2.format(result));

                //salvando no array
                Objetohistorico hist = new Objetohistorico();
                hist.setN1(Double.toString(n1));
                hist.setN2(Double.toString(n2));
                hist.setOperacao("/");
                hist.setResultado(Double.toString(result));
                list_historico.add(hist);
            }
        }
    }



    //função botão de limpar
    View.OnClickListener ouvinteLimpar = new View.OnClickListener()
    {
        @Override
        public void onClick (View v) {
            objcalc.getTv().setText("Resultado: ");
            objcalc.getCampo1().setText("");
            objcalc.getCampo2().setText("");
        }
    };



    View.OnClickListener ouvinteHistorico = new View.OnClickListener()
    {
        public void onClick (View v) {
            Intent intent = new Intent(CalcModelo4.this,TelaHistorico.class);
            intent.putExtra("arrayHistorico", list_historico);
            startActivity(intent);
        }
    };



    View.OnClickListener ouvinteVoltar = new View.OnClickListener()
    {
        @Override
        public void onClick (View v) {
            Intent intent = new Intent(CalcModelo4.this,Principal.class);
            startActivity(intent);
        }
    };
}
