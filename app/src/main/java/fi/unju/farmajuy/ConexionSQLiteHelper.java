package fi.unju.farmajuy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilidadesConexion.CREAR_TABLA_CATEGORIA);
        db.execSQL(UtilidadesConexion.CREAR_TABLA_PRODUCTO);
        db.execSQL(UtilidadesConexion.CREAR_TABLA_FARMACIA);
        db.execSQL(UtilidadesConexion.CREAR_TABLA_DETALLE_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesConexion.TABLA_DETALLE_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesConexion.TABLA_FARMACIA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesConexion.TABLA_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesConexion.TABLA_CATEGORIA);
        onCreate(db);
    }
}
