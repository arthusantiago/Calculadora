package com.example.root.calculadora;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class CalcModelo1 extends AppCompatActivity {

    /*Variáveis usadas no calculo dentro das funções*/
    private Double n1,n2, result;
    private AlertDialog.Builder diag_mensagem;
    private ArrayList<Objetohistorico> list_historico = new ArrayList<>();
    private Button historico;
    private DecimalFormat df2;

    private ObjCalc objcalc = new ObjCalc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcmodelo1);

        //Essa é a declaração dos meus objetos que eu irei manipular da view (tela do telefone)
        //depois de declarar essas variáveis e fazer o findViewById eu devo considerar que estou manipulando os elementos da view.
        objcalc.setCampo1(findViewById(R.id.campo1));
        objcalc.setCampo2(findViewById(R.id.campo2));
        objcalc.setBt_somar(findViewById(R.id.somar));
        objcalc.setBt_subtrair(findViewById(R.id.subtrair));
        objcalc.setBt_multi(findViewById(R.id.multiplicar));
        objcalc.setBt_dividir(findViewById(R.id.dividir));
        objcalc.setBt_limpar(findViewById(R.id.limpar));
        objcalc.setBt_voltar(findViewById(R.id.voltar));
        objcalc.setTv(findViewById(R.id.resultado));

        historico = findViewById(R.id.historico);

        //Escutando os "Clicks" do botão, setando e executando alguma função;
        objcalc.setBt_somar(ouvinteSomar);
        objcalc.setBt_subtrair(ouvinteSubtrair);
        objcalc.setBt_multi(ouvinteMultiplicar);
        objcalc.setBt_dividir(ouvinteDividir);
        objcalc.setBt_limpar(ouvinteLimpar);
        objcalc.setBt_voltar(ouvinteVoltar);

        historico.setOnClickListener(ouvinteHistorico);
    }

    //função botão de somar
    View.OnClickListener ouvinteSomar = new View.OnClickListener()
    {
          @Override
          public void onClick (View v)
          {
              //mensagem de alerta;
              diag_mensagem = new AlertDialog.Builder(CalcModelo1.this);
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
    };

    //função botão de subtrair
    View.OnClickListener ouvinteSubtrair = new View.OnClickListener()
    {
        @Override
        public void onClick (View v)
        {
            //mensagem de alerta;
            diag_mensagem = new AlertDialog.Builder(CalcModelo1.this);
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
    };

    //função botão de multiplicars
    View.OnClickListener ouvinteMultiplicar = new View.OnClickListener()
    {
        @Override
        public void onClick (View v)
        {
            //mensagem de alerta;
            diag_mensagem = new AlertDialog.Builder(CalcModelo1.this);
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

                    //salvando no array
                    Objetohistorico hist = new Objetohistorico();
                    hist.setN1(Double.toString(n1));
                    hist.setN2(Double.toString(n2));
                    hist.setOperacao("*");
                    hist.setResultado(Double.toString(result));
                    list_historico.add(hist);
                }
            }
        }
    };

    //função botão de Dividir
    View.OnClickListener ouvinteDividir = new View.OnClickListener()
    {
        @Override
        public void onClick (View v)
        {
            //mensagem de alerta;
            diag_mensagem = new AlertDialog.Builder(CalcModelo1.this);
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
    };

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
            Intent intent = new Intent(CalcModelo1.this,TelaHistorico.class);
            intent.putExtra("arrayHistorico", list_historico);
            startActivity(intent);
        }
    };

    View.OnClickListener ouvinteVoltar = new View.OnClickListener()
    {
        @Override
        public void onClick (View v) {
            Intent intent = new Intent(CalcModelo1.this,Principal.class);
            startActivity(intent);
        }
    };

}
