package com.example.obdsc.listadeopcoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

public class ActMain extends AppCompatActivity implements View.OnClickListener {

    private EditText edtvalor;
    private Spinner spnOpcoes;
    private Button btnAdicionar;
    private Button btnExcluir;
    private ListView lstDados;

    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        edtvalor = (EditText)findViewById(R.id.edtvalor);
        spnOpcoes = (Spinner)findViewById(R.id.spnOpcoes);
        btnAdicionar = (Button)findViewById(R.id.btnAdicionar);
        btnExcluir = (Button)findViewById(R.id.btnExcluir);
        lstDados = (ListView)findViewById(R.id.lstDados);

        btnExcluir.setOnClickListener(this);
        btnAdicionar.setOnClickListener(this);

        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpcoes.setAdapter(adpOpcoes);

        adpOpcoes.add("Cartao Credito");
        adpOpcoes.add("Cartao Debito");
        adpOpcoes.add("Boleto");
        adpOpcoes.add("Deposito Bancario");

        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    @Override
    public void onClick(View v) {

        if (v == btnAdicionar)
        {
            string item = edtvalor.getText().toString();
            item += "-" + spnOpcoes.getSelectedItem();
            adpDados.add(item);
        }
        else
            if (v == btnExcluir)
            {
                if (adpDados.getCount()>0)
                {
                   String item = adpDados.getItem(0);
                    adpDados.remove(item);
                }
            }

    }
}
