package dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "tasks";
    private static final int VERSAO = 1;

    public DatabaseHelper (Context context){
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     //Tabela de usuários
        db.execSQL("create table usuarios(_id integer primary key autoincrement, "
        +"nome text not null, login text not null, senha text not null, created_at text)");

     //Tabela de Tarefas
        db.execSQL("create table tarefas(_id integer primary key autoincrement, "
        +"tarefa text not null, dt_criacao text, dt_completado text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static class Usuarios{
        public static final String TABELA = "usuarios";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String LOGIN = "login";
        public static final String SENHA = "senha";
        public static final String CREATED_AT = "created_at";

        public static final String[] COLUNAS = new String []{
                _ID, NOME, LOGIN, SENHA, CREATED_AT
        };



    }
}
