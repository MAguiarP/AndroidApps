package dao;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
}

