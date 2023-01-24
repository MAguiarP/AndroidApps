package dao;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public UsuarioDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDatabase() {
        if (database == null) {
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    private Usuario criarUsuario(Cursor cursor){
        Usuario model = new Usuario(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Usuarios._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.NOME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.LOGIN)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.SENHA)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.CREATED_AT))
        );

        return model;
    }

    public List<Usuario> listarUsuarios(){
        Cursor cursor = getDatabase().query(DatabaseHelper.Usuarios.TABELA,DatabaseHelper.Usuarios.COLUNAS, null, null, null, null, null);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        while(cursor.moveToNext()){
            Usuario model = criarUsuario(cursor);
            usuarios.add(model);
        }
        cursor.close();
        return usuarios;
    }

    public void fechar(){
        databaseHelper.close();
        database = null;
    }
}
