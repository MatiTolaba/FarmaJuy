package fi.unju.farmajuy.utilidades;

public class UtilidadesConexion {

    //Constantes campos de tabla categoria

    public static final String TABLA_CATEGORIA = "categorias";
    public static final String CAMPO_CATEGORIA_ID = "categoria_id";
    public static final String CAMPO_CATEGORIA_NOMBRE = "categoria_nombre";

    public static final String CREAR_TABLA_CATEGORIA = "CREATE TABLE " +TABLA_CATEGORIA+ " (" +
            CAMPO_CATEGORIA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +CAMPO_CATEGORIA_NOMBRE+ " TEXT ) ";

    //Constantes campos de tabla producto

    public static final String TABLA_PRODUCTO = "productos";
    public static final String CAMPO_PRODUCTO_ID = "producto_id";
    public static final String CAMPO_PRODUCTO_NOMBRE = "producto_nombre";
    public static final String CAMPO_PRODUCTO_DROGA = "producto_droga";
    public static final String CAMPO_PRODUCTO_DESCRIPCION = "producto_descripcion";
    public static final String CAMPO_PRODUCTO_PRESENTACION = "producto_presentacion";
    public static final String CAMPO_PRODUCTO_FOTO = "producto_foto";
    public static final String CAMPO_PRODUCTO_CATEGORIA_ID = "categoria_id";

    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE " + TABLA_PRODUCTO + " (" +
            CAMPO_PRODUCTO_ID + " INTEGER, " + CAMPO_PRODUCTO_NOMBRE + " TEXT, " +
            CAMPO_PRODUCTO_DROGA +" TEXT," + CAMPO_PRODUCTO_DESCRIPCION + " TEXT," + CAMPO_PRODUCTO_PRESENTACION + " TEXT, " +
            CAMPO_PRODUCTO_FOTO +" TEXT, " + CAMPO_PRODUCTO_CATEGORIA_ID + " INTEGER )";

    //Constantes campos de tabla farmacia

    public static final String TABLA_FARMACIA = "farmacias";
    public static final String CAMPO_FARMACIA_ID = "farmacia_id";
    public static final String CAMPO_FARMACIA_NOMBRE = "farmacia_nombre";
    public static final String CAMPO_FARMACIA_DIRECCION = "farmacia_direccion";
    public static final String CAMPO_FARMACIA_HORARIO = "farmacia_horario";
    public static final String CAMPO_FARMACIA_TELEFONO = "farmacia_telefono";
    public static final String CAMPO_FARMACIA_LATITUD = "farmacia_latitud";
    public static final String CAMPO_FARMACIA_LONGITUD = "farmacia_longitud";
    public static final String CAMPO_FARMACIA_FOTO = "farmacia_foto";

    public static final String CREAR_TABLA_FARMACIA = "CREATE TABLE " +TABLA_FARMACIA+  " (" +
            CAMPO_FARMACIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +CAMPO_FARMACIA_NOMBRE + " TEXT, " +
            CAMPO_FARMACIA_DIRECCION +" TEXT," + CAMPO_FARMACIA_HORARIO + " TEXT," + CAMPO_FARMACIA_TELEFONO +
            " TEXT, " + CAMPO_FARMACIA_LATITUD + " DOUBLE, " + CAMPO_FARMACIA_LONGITUD + " DOUBLE, " + CAMPO_FARMACIA_FOTO + " TEXT )";

    //Constantes campos de tabla detalle producto

    public static final String TABLA_DETALLE_PRODUCTO = "detalles_producto";
    public static final String CAMPO_DETALLE_PRODUCTO_ID = "detalle_producto_id";
    public static final String CAMPO_DETALLE_PRODUCTO_FARMACIA_ID = "farmacia_id";
    public static final String CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID = "producto_id";
    public static final String CAMPO_DETALLE_PRODUCTO_PRECIO = "detalle_producto_precio";
    public static final String CAMPO_DETALLE_PRODUCTO_FECHA_VENCIMIENTO = "detalle_producto_fecha_vencimiento";
    public static final String CAMPO_DETALLE_PRODUCTO_STOCK = "detalle_producto_stock";

    public static final String CREAR_TABLA_DETALLE_PRODUCTO = "CREATE TABLE " + TABLA_DETALLE_PRODUCTO + " (" +
            CAMPO_DETALLE_PRODUCTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CAMPO_DETALLE_PRODUCTO_FARMACIA_ID + " INTEGER, " +
            CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID +" INTEGER," + CAMPO_DETALLE_PRODUCTO_PRECIO + " DOUBLE," + CAMPO_DETALLE_PRODUCTO_FECHA_VENCIMIENTO +
            " DATE, " + CAMPO_DETALLE_PRODUCTO_STOCK + " INTEGER )";
}
