package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //pedimos ubicacion al usuario, directamente al iniciar la aplicacion
        obtenerLocalizacion();
        // Registramos productos al iniciar esta pantalla, solo como ejemplo
        registrarProductos();
    }

    //metodo permiso para acceder a la localizacion. Permisos para la app acceda a la ubicacion
    private void obtenerLocalizacion() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(permiso == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    private void registrarProductos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();

//        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_ID, 1);
//        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE, "Medicamentos");

        //CATEGORIA
        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE, "Medicamento");

        db.insert(UtilidadesConexion.TABLA_CATEGORIA, UtilidadesConexion.CAMPO_CATEGORIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE, "Desmocosmética");

        db.insert(UtilidadesConexion.TABLA_CATEGORIA, UtilidadesConexion.CAMPO_CATEGORIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE, "Perfumes y Fragancias");

        db.insert(UtilidadesConexion.TABLA_CATEGORIA, UtilidadesConexion.CAMPO_CATEGORIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE, "Bebés y Maternidad");

        db.insert(UtilidadesConexion.TABLA_CATEGORIA, UtilidadesConexion.CAMPO_CATEGORIA_ID, valores);

        valores = new ContentValues();

        //PRODUCTOS
        //Medicamento
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Aseptobron Antigripal Forte");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Ibuprofeno-Clorfeniramina-Pseudoefedrina");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Tratamiento sintomático de cuadros gripales que presenten alergia, rinorrea, congestión nasal, dolor corporal y fiebre.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase que contiene 10 comprimidos recubiertos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/da/03/X8Y8FnkX_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "IbuMejoral 400");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Ibuprofeno");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Para el alivio sintomático de dolores (musculares de espalda, de cabeza, menstruales, dientes), dolores producidos por artritis, dolores asociados a estados gripales y para reducir la fiebre.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase que contiene 10 comprimidos recubiertos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/02/47/S2hSkUCm_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Ibuprofeno Fecofar VL");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Ibuprofeno");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Analgésico y antinflamatorio para el tratamiento de la fiebre y el dolor leve a moderado.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase que contiene 20 comprimidos recubiertos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/84/c0/JJYvES2V_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "TabCin Plus Rápida Acción");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Paracetamol-Fenilefrina-Guaifenesina");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Para el alivio sintomático de dolores (de cabeza, musculares) leves a moderados, alivio de estados gripales y/o resfríos, facilitar la expulsión de secreciones (expectoración) y reducir la fiebre.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase que contiene 20 comprimidos recubiertos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/c5/29/7Z0g2IAw_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Nuevapina");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Aspirina");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Antiagregante plaquetario para la prevención primaria de un primer infarto en pacientes con factores de riesgo cardiovascular, como por ejemplo, diabetes, hiperlipidemia, etc.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase que contiene 28 comprimidos recubiertos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/d7/ec/z2bKQ6Lm_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 6);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Omeprazol Richet");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Omeprazol");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Para el tratamiento de úlcera duodenal, úlcera gástrica, enfermedad ulcerosa péptica con histología antral.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase que contiene 20 comprimidos recubiertos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/1c/65/6DBa6nT0_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        //Desmocosmética
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 7);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Agua Micelar Cleanance");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Limpiadora Pieles Grasas Y Acné");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Limpia y desmaquilla rostro, ojos y cuello. Ayuda a disminuir el exceso de sebo.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 400 ml.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/fa/f2/IiSJZJR2_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 2);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 8);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Crema Facial de Día");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Vitamina E");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Su fórmula ligera de rápida absorción mantiene el balance natural propio de la piel. Con su FPS 15 ayuda a proteger la piel contra los rayos del sol que causan envejecimiento prematuro.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 50 ml.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/34/a3/Q0tlfnmu_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 2);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Fotoprotector Isdin Fusión Water");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "SPF 50");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Fotoprotector facial de fase acuosa que aporta hidratación intensa, absorción inmediata y garantiza una alta protección frente a la radiación UV.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 50 ml.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/c3/88/7qQWczT3_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 2);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        //Perfumes y Fragancias
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 10);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Desodorante Mineral Roll-On");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Sin sales de aluminio, alcohol ni parabenos.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "El desodorante Mineral Vichy Roll On está diseñado para hombres y mujeres que buscan un desodorante sin sales de aluminio, con un nivel máximo de eficacia.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 50 ml.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/73/2b/2F04gzET_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 2);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 11);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Perfume King of Seduction");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Antonio Banderas");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Un perfume único para adentrarnos en el intenso y cautivador reino de la seducción.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 50 ml.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/0e/91/KRci09WI_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 3);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 12);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Saphirus Fragancia New York");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Aromatizante de ambientes");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Fragancia oriental amaderada con notas de salida frescas como el eucaliptus y laurel en complemento con las notas cítricas, generando una sensación de frescura y placer apenas olemos la fragancia");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 185 gr.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/5d/11/0jCbS7Na_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 3);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        //Bebés y Maternidad
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 13);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Nestle Nido FortiGrow");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Leche deslactosada");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Leche modificada en polvo para niños a partir de 2 años. Libre de gluten. Porcentaje de reducción de contenido de lactosa en un 99%.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 800 gr.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/c5/25/2Dv40FQT_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 4);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 14);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Huggies Triple Protección");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Pañal desechable");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "3 beneficios en 1. Sequedad, ansorción y sistema  antifiltración. Protege a tu bebé por más tiempo.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 68 unidades.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/e5/11/f4jAcZMP_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 4);

        db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 15);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Toallitas Húmedas con Aloe");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "JOHNSON'S Baby, sin alcohol");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Limian suavemente  la delicada piel de tu bebé, sin irritarla ni resecarla, manteniendola saluble.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Envase de 50 unidades.");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/a3/d6/SjoQkEOX_o.png");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 3);

        Long idResultanteBaseDatos = db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        Toast.makeText(getApplicationContext(),"ID Producto: "+idResultanteBaseDatos, Toast.LENGTH_SHORT).show();

        valores = new ContentValues();

        //FARMACIA
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_NOMBRE, "Farmacity");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_DIRECCION, "Av. Hipólito Yrigoyen 1116.");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_HORARIO, "Abierto las 24 horas.");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_TELEFONO, "0388 431-0877");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LATITUD, -24.190258);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LONGITUD, -65.303592);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_FOTO, "https://images2.imgbox.com/95/a6/XN6KUsIg_o.jpg");

        db.insert(UtilidadesConexion.TABLA_FARMACIA, UtilidadesConexion.CAMPO_FARMACIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_NOMBRE, "Farmacia Catedral 1 - Farmar");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_DIRECCION, "Gral. Lavalle 390");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_HORARIO, "Lunes a Sabado de 08:00 hs. a 12:00 hs.");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_TELEFONO, "0388 424-2416");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LATITUD, -24.184317);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LONGITUD, -65.303592);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_FOTO, "https://images2.imgbox.com/1d/5c/aQyyOtgN_o.png");

        db.insert(UtilidadesConexion.TABLA_FARMACIA, UtilidadesConexion.CAMPO_FARMACIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_NOMBRE, "Farmacia Siufi");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_DIRECCION, "Gral. Alvear 1062");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_HORARIO, "Lunes a Sabado de 08:00 hs. a 00:00 hs.");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_TELEFONO, "0388 423-1705");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LATITUD, -24.184453);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LONGITUD, -65.303592);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_FOTO, "https://images2.imgbox.com/10/23/kXxDMgqK_o.jpg");

        db.insert(UtilidadesConexion.TABLA_FARMACIA, UtilidadesConexion.CAMPO_FARMACIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_NOMBRE, "Farmacia Norte");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_DIRECCION, "Gral. Güemes 1300");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_HORARIO, "Lunes a Viernes de 08:00 hs. a 00:00 hs.");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_TELEFONO, "0388 423-4050");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LATITUD, -24.183356);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LONGITUD, -65.303592);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_FOTO, "https://images2.imgbox.com/9f/87/nWg1Qaus_o.jpg");

        db.insert(UtilidadesConexion.TABLA_FARMACIA, UtilidadesConexion.CAMPO_FARMACIA_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_NOMBRE, "Farmacia San Martín");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_DIRECCION, "Gral. San Martín 244");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_HORARIO, "Lunes a Viernes de 08:00 hs. a 21:00 hs.");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_TELEFONO, "0388 422-8215");
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LATITUD, -24.186305);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_LONGITUD, -65.303592);
        valores.put(UtilidadesConexion.CAMPO_FARMACIA_FOTO, "https://images2.imgbox.com/f9/7b/hRWZpMyP_o.jpg");

        db.insert(UtilidadesConexion.TABLA_FARMACIA, UtilidadesConexion.CAMPO_FARMACIA_ID, valores);

        valores = new ContentValues();

        //DETALLE PRODUCTO
        //Farmacity
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 227.54);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 10);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 218.90);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 2);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 6);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 785.32);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 1);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 8);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 149);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 5);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1595);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 1);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 6);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 12);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 425);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 1);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 7);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 13);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 594);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 21);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        //Farmacia Catedral 1 - Farmar
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 8);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 400);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 1);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 210);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 14);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 10);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 7);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1972);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 3);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 11);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1540);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 17);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 12);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 10);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 2425);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 1);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 13);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 13);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 669);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 5);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        //Farmacia Siufi
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 14);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 210);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 10);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 15);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 314.15);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 5);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 16);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1470);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 2);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 17);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 10);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 2100);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 7);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 18);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 11);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 2125);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 4);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 19);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 13);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 460);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 7);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 20);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 15);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 145);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 5);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        //Farmacia Norte
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 21);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 3);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 230);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 18);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 22);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 300);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 5);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 23);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 8);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 249);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 2);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 24);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1700);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 20);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 25);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 10);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 2425);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 6);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 26);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 15);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 4);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 160);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 4);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        //Farmacia San Martín
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 27);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 2);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 410);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 2);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 28);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 175);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 2);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 33);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 6);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 800);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 3);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 29);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 7);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1877);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 9);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 30);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 9);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 1430);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 3);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 31);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 11);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 2375);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 23);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, 32);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID, 13);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID, 5);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO, 544);
        valores.put(UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK, 1);

        db.insert(UtilidadesConexion.TABLA_DETALLE_PRODUCTO, UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_ID, valores);

        db.close();
    }

    public void Sitios(View view){
        Intent intent = new Intent(getApplicationContext(), MapsSitiosActivity.class);
        startActivity(intent);
    }



    public void Ubicacion(View view){
        Intent intent = new Intent(getApplicationContext(), MapsMiUbicacionActivity.class);
        startActivity(intent);
    }

    public void Busqueda(View view){
        Intent intent = new Intent(getApplicationContext(), BuscarProductoActivity.class);
        startActivity(intent);
    }
}