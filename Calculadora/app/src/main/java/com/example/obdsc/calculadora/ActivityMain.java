package com.example.obdsc.calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.*;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    private EditText edtvalor1;
    private EditText edtvalor2;
    private Button btncalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtvalor1 = (EditText)findViewById(R.id.edtvalor1);
        edtvalor2 = (EditText)findViewById(R.id.edtvalor2);

        btncalcular = (Button) findViewById(R.id.btncalcular);
        btncalcular.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onClick(View v)
    {
        String v1 = edtvalor1.getText().toString();
        String v2 = edtvalor2.getText().toString();

        if (v1.trim().isEmpty() || v2.trim().isEmpty()){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Existem dados em branco");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

        else{
            double valor1 = Double.parseDouble(edtvalor1.getText().toString());
            double valor2 = Double.parseDouble(edtvalor2.getText().toString());

            double resultado = valor1+valor2;

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("O Resultado da soma: "+ resultado);
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
