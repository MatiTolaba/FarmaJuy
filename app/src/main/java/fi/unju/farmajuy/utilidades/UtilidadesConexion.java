package fi.unju.farmajuy.utilidades;

public class UtilidadesConexion {

    //Constantes campos de tabla categoria

    public static final String TABLA_CATEGORIA = "categorias";
    public static final String CAMPO_CATEGORIA_ID = "categoria_id";
    public static final String CAMPO_CATEGORIA_NOMBRE = "categoria_nombre";

    public static final String CREAR_TABLA_CATEGORIA = "CREATE TABLE " +TABLA_CATEGORIA+ " (" +
            CAMPO_CATEGORIA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +CAMPO_CATEGORIA_NOMBRE+ " TEXT ) ";

    //Constantes campos de tabla medicamento

    public static final String TABLA_MEDICAMENTO = "medicamentos";
    public static final String CAMPO_MEDICAMENTO_ID = "medicamento_id";
    public static final String CAMPO_MEDICAMENTO_NOMBRE = "medicamento_nombre";
    public static final String CAMPO_MEDICAMENTO_DROGA = "medicamento_droga";
    public static final String CAMPO_MEDICAMENTO_DESCRIPCION = "medicamento_descripcion";
    public static final String CAMPO_MEDICAMENTO_PRESENTACION = "medicamento_presentacion";
    public static final String CAMPO_MEDICAMENTO_FOTO = "medicamento_foto";
    public static final String CAMPO_MEDICAMENTO_CATEGORIA_ID = "categoria_id";

    public static final String CREAR_TABLA_MEDICAMENTO = "CREATE TABLE " +TABLA_MEDICAMENTO+ " (" +
        CAMPO_MEDICAMENTO_ID+ " INTEGER, " +CAMPO_MEDICAMENTO_NOMBRE+ " TEXT, " +
        CAMPO_MEDICAMENTO_DROGA+" TEXT," +CAMPO_MEDICAMENTO_DESCRIPCION+ " TEXT," +CAMPO_MEDICAMENTO_PRESENTACION+ " TEXT, " +
        CAMPO_MEDICAMENTO_FOTO+" TEXT, " +CAMPO_MEDICAMENTO_CATEGORIA_ID+ " INTEGER )";

    //Constantes campos de tabla farmacia

    public static final String TABLA_FARMACIA = "farmacias";
    public static final String CAMPO_FARMACIA_ID = "farmacia_id";
    public static final String CAMPO_FARMACIA_NOMBRE = "farmacia_nombre";
    public static final String CAMPO_FARMACIA_DIRECCION = "farmacia_direccion";
    public static final String CAMPO_FARMACIA_HORARIO = "farmacia_horario";
    public static final String CAMPO_FARMACIA_TELEFONO = "farmacia_telefono";
    public static final String CAMPO_FARMACIA_UBICACION = "farmacia_ubicacion";
    public static final String CAMPO_FARMACIA_FOTO = "farmacia_foto";

    public static final String CREAR_TABLA_FARMACIA = "CREATE TABLE " +TABLA_FARMACIA+  " (" +
            CAMPO_FARMACIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +CAMPO_FARMACIA_NOMBRE + " TEXT, " +
            CAMPO_FARMACIA_DIRECCION +" TEXT," + CAMPO_FARMACIA_HORARIO + " TEXT," + CAMPO_FARMACIA_TELEFONO +
            " TEXT, " + CAMPO_FARMACIA_UBICACION + " TEXT, " + CAMPO_FARMACIA_FOTO + "TEXT )";

    //Constantes campos de tabla detalle medicamento

    public static final String TABLA_DETALLE_MEDICAMENTO = "detalles_medicamento";
    public static final String CAMPO_DETALLE_MEDICAMENTO_ID = "detalle_medicamento_id";
    public static final String CAMPO_DETALLE_MEDICAMENTO_FARMACIA_ID = "farmacia_id";
    public static final String CAMPO_DETALLE_MEDICAMENTO_MEDICAMENTO_ID = "medicamento_id";
    public static final String CAMPO_DETALLE_MEDICAMENTO_PRECIO = "detalle_medicamento_precio";
    public static final String CAMPO_DETALLE_MEDICAMENTO_FECHA_VENCIMIENTO = "detalle_medicamento_fecha_vencimiento";
    public static final String CAMPO_DETALLE_MEDICAMENTO_STOCK = "detalle_medicamento_stock";

    public static final String CREAR_TABLA_DETALLE_MEDICAMENTO = "CREATE TABLE " +TABLA_DETALLE_MEDICAMENTO+ " (" +
            CAMPO_DETALLE_MEDICAMENTO_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +CAMPO_DETALLE_MEDICAMENTO_FARMACIA_ID+ " INTEGER, " +
            CAMPO_DETALLE_MEDICAMENTO_MEDICAMENTO_ID+" INTEGER," +CAMPO_DETALLE_MEDICAMENTO_PRECIO+ " DOUBLE," +CAMPO_DETALLE_MEDICAMENTO_FECHA_VENCIMIENTO +
            " DATE, " + CAMPO_DETALLE_MEDICAMENTO_STOCK+ " INTEGER )";
}
