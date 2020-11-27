package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import fi.unju.farmajuy.entidades.Medicamento;
import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class activity_ingreso_medicamento extends AppCompatActivity {

    EditText medicamentoNombreDroga;

    ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_medicamento);


        medicamentoNombreDroga = (EditText) findViewById(R.id.inputTextMedicamentoNombreDroga);

        RegistrarMedicamentos();
    }

    private void RegistrarMedicamentos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE, "Rivotril");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_DROGA, "Clonazepam");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_DESCRIPCION, "Ansiolítico");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_PRESENTACION, "Capsulas de 10 mg");
        //valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_FOTO, "https://imgbox.com/ZKCZRars");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_FOTO, "https://images2.imgbox.com/80/ce/ZKCZRars_o.jpeg");


        Long idResultanteBaseDatos = db.insert(UtilidadesConexion.TABLA_MEDICAMENTO, UtilidadesConexion.CAMPO_MEDICAMENTO_ID, valores);

        Toast.makeText(getApplicationContext(),"ID Medicamento: "+idResultanteBaseDatos, Toast.LENGTH_SHORT).show();

        db.close();
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnBuscarMedicamento:
                //buscarMedicamento();

                listaMedicamentos = buscarMedicamentos();

                if ( !listaMedicamentos.isEmpty() ){
                    Intent medicamentoActivityIntent = new Intent(activity_ingreso_medicamento.this,MedicamentoActivity.class);
                    Bundle medicamentoActivityBundle = new Bundle();

                    medicamentoActivityBundle.putSerializable("listaMedicamentos", listaMedicamentos);
                    medicamentoActivityIntent.putExtras(medicamentoActivityBundle);

                    startActivity(medicamentoActivityIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"No se han encontrado medicamentos para su Busqueda ", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private ArrayList<Medicamento> buscarMedicamentos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        Medicamento medicamento = null;
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        String parametro = medicamentoNombreDroga.getText().toString();

        try {


            Cursor cursor = db.rawQuery("SELECT * FROM " + UtilidadesConexion.TABLA_MEDICAMENTO +
                    " WHERE "+ UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE + " LIKE '%"+parametro+"%' ", null);

            while (cursor.moveToNext()){
                medicamento = new Medicamento();
                medicamento.setMedicamento_id(cursor.getInt(0));
                medicamento.setNombre(cursor.getString(1));
                medicamento.setDroga(cursor.getString(2));
                medicamento.setDescripcion(cursor.getString(3));
                medicamento.setPresentacion(cursor.getString(4));
                medicamento.setFoto((cursor.getString(5)));
                // TODO: hacer el de categoria id

                medicamentos.add(medicamento);
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"No hay resultados", Toast.LENGTH_SHORT).show();
        }
        return medicamentos;
    }

//    private void buscarMedicamento() {
//        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
//        SQLiteDatabase db = conexion.getReadableDatabase();
//
//        //String[] parametros = {medicamentoNombreDroga.getText().toString()};
//        //String[] camposDevueltos = {UtilidadesConexion.CAMPO_MEDICAMENTO_DROGA};
//        String parametro = medicamentoNombreDroga.getText().toString();
//
//        try {
//            //Cursor cursor = db.query(UtilidadesConexion.TABLA_MEDICAMENTO,camposDevueltos,UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE+"=?", parametros,null,null,null);
//            Cursor cursor = db.rawQuery("SELECT "+UtilidadesConexion.CAMPO_MEDICAMENTO_DROGA+" FROM " + UtilidadesConexion.TABLA_MEDICAMENTO +
//                    " WHERE "+ UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE + " LIKE '%"+parametro+"%' ", null);
//
//            cursor.moveToFirst();
//
//            pruebaDroga = cursor.getString(0);
//        } catch (Exception e) {
//
//        }
//    }
}