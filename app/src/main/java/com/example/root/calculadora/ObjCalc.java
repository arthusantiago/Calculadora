package com.example.root.calculadora;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ObjCalc {
    private EditText campo1;
    private EditText campo2;
    private Button bt_limpar;
    private Button bt_somar;
    private Button bt_subtrair;
    private Button bt_multi;
    private Button bt_dividir;
    private TextView tv;
    private Button bt_voltar;


    public EditText getCampo1() {
        return campo1;
    }

    public void setCampo1(View view) {
        this.campo1 = (EditText) view;
    }

    public EditText getCampo2() {
        return campo2;
    }

    public void setCampo2(View view) {
        this.campo2 = (EditText) view;
    }



    public Button getBt_limpar() {
        return bt_limpar;
    }

    public void setBt_limpar(View view) {
        this.bt_limpar = (Button) view;
    }

    public void setBt_limpar(View.OnClickListener ouvinte) {
        this.bt_limpar.setOnClickListener(ouvinte);
    }



    public Button getBt_somar(Button bt_somar) {
        return bt_somar;
    }

    public void setBt_somar(View view) {
        this.bt_somar = (Button) view;
    }

    public void setBt_somar(View.OnClickListener ouvinte) {
        this.bt_somar.setOnClickListener(ouvinte);
    }



    public Button getBt_subtrair() {
        return bt_subtrair;
    }

    public void setBt_subtrair(View view) {
        this.bt_subtrair = (Button) view;
    }

    public void setBt_subtrair(View.OnClickListener ouvinte) {
        this.bt_subtrair.setOnClickListener(ouvinte);
    }



    public Button getBt_multi() {
        return bt_multi;
    }

    public void setBt_multi(View view) {
        this.bt_multi = (Button) view;
    }

    public void setBt_multi(View.OnClickListener ouvinte) {
        this.bt_multi.setOnClickListener(ouvinte);
    }



    public Button getBt_dividir() {
        return bt_dividir;
    }

    public void setBt_dividir(View view) {
        this.bt_dividir = (Button) view;
    }

    public void setBt_dividir(View.OnClickListener ouvinte) {
        this.bt_dividir.setOnClickListener(ouvinte);
    }



    public TextView getTv() {
        return tv;
    }

    public void setTv(View view) {
        this.tv = (TextView) view;
    }

    public void setTv(View.OnClickListener ouvinte) {
        this.tv.setOnClickListener(ouvinte);
    }



    public Button getBt_voltar() {
        return bt_voltar;
    }

    public void setBt_voltar(View view) {
        this.bt_voltar = (Button) view;
    }

    public void setBt_voltar(View.OnClickListener ouvinte) {
        this.bt_voltar.setOnClickListener(ouvinte);
    }


}
