package lucaezc.promesas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DataSource {
    //Metainformación de la base de datos
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";
    public static final String VERSION_TABLE_NAME = "Version";
    public static final String LIBRO_TABLE_NAME = "Libro";
    public static final String VERSICULO_TABLE_NAME = "Versiculo";
    public static final String PROMESA_TABLE_NAME = "Promesa";
    public static final String TEMA_TABLE_NAME = "Tema";
    public static final String PROMESA_TEMA_TABLE_NAME = "Promesa_Tema";

    //Campos de la tabla Version
    public static class VersionCampos{
        public static final String VERSION_ID = BaseColumns._ID;
        public static final String VERSION_NOMBRE = "version_nombre";
        public static final String VERSION_CODIGO = "version_codigo";
    }

    //Campos de la tabla Libro
    public static class LibroCampos{
        public static final String LIBRO_ID = BaseColumns._ID;
        public static final String LIBRO_NOMBRE = "libro_nombre";
        public static final String LIBRO_NOMBRE_EN = "libro_nombre_en";
        public static final String LIBRO_TESTAMENTO = "libro_testamento";
    }

    //Campos de la tabla Versiculo
    public static class VersiculoCampos{
        public static final String VERSICULO_ID = BaseColumns._ID;
        public static final String VERSICULO_VERSION = "versiculo_version";
        public static final String VERSICULO_LIBRO = "versiculo_libro";
        public static final String VERSICULO_CAPITULO = "versiculo_capitulo";
        public static final String VERSICULO_NRO = "versiculo_nro";
        public static final String VERSICULO_TEXTO = "versiculo_texto";
    }

    //Campos de la tabla Promesa
    public static class PromesaCampos{
        public static final String PROMESA_ID = BaseColumns._ID;
        public static final String PROMESA_VERSICULO = "versiculo";
    }

    //Campos de la tabla Tema
    public static class TemaCampos{
        public static final String TEMA_ID = BaseColumns._ID;
        public static final String TEMA_NOMBRE = "versiculo_desde";
    }

    //Campos de la tabla Promesa_Tema
    public static class PromesaTemaCampos{
        public static final String PROMESA_TEMA_ID = BaseColumns._ID;
        public static final String PROMESA_TEMA_ID_TEMA = "tema_id";
        public static final String PROMESA_TEMA_VERSICULO = "versiculo";
    }

    //Script de Creación de la tabla Version
    public static final String CREATE_VERSION_SCRIPT =
        "create table " + VERSION_TABLE_NAME + "(" +
            VersionCampos.VERSION_ID + " " + INT_TYPE + " primary key autoincrement," +
            VersionCampos.VERSION_CODIGO + " " + STRING_TYPE + " not null," +
            VersionCampos.VERSION_NOMBRE + " " + STRING_TYPE + " not null)";

    //Script de Creación de la tabla Libro
    public static final String CREATE_LIBRO_SCRIPT =
        "create table " + LIBRO_TABLE_NAME + "(" +
            LibroCampos.LIBRO_ID + " " + INT_TYPE + " primary key," +
            LibroCampos.LIBRO_NOMBRE + " " + STRING_TYPE + " not null," +
            LibroCampos.LIBRO_NOMBRE_EN + " " + STRING_TYPE + " not null," +
            LibroCampos.LIBRO_TESTAMENTO + " " + STRING_TYPE + " not null)";

    //Script de Creación de la tabla Versiculo
    public static final String CREATE_VERSICULO_SCRIPT =
        "create table " + VERSICULO_TABLE_NAME + "(" +
            VersiculoCampos.VERSICULO_ID + " " + INT_TYPE + " primary key," +
            VersiculoCampos.VERSICULO_VERSION + " " + INT_TYPE + " not null," +
            VersiculoCampos.VERSICULO_LIBRO + " " + INT_TYPE + " not null," +
            VersiculoCampos.VERSICULO_CAPITULO + " " + INT_TYPE + " not null," +
            VersiculoCampos.VERSICULO_NRO + " " + INT_TYPE + " not null," +
            VersiculoCampos.VERSICULO_TEXTO + " " + STRING_TYPE + " not null," +
            "foreign key(" + VersiculoCampos.VERSICULO_VERSION + ") references " + VERSION_TABLE_NAME + "(" + VersionCampos.VERSION_ID + ")," +
            "foreign key(" + VersiculoCampos.VERSICULO_LIBRO + ") references " + LIBRO_TABLE_NAME + "(" + LibroCampos.LIBRO_ID + "))";

    //Script de Creación de la tabla Promesa
    public static final String CREATE_PROMESA_SCRIPT =
        "create table " + PROMESA_TABLE_NAME + "(" +
            PromesaCampos.PROMESA_ID + " " + INT_TYPE + " primary key," +
            PromesaCampos.PROMESA_VERSICULO + " " + INT_TYPE + " not null," +
            "foreign key(" + PromesaCampos.PROMESA_VERSICULO + ") references " + VERSICULO_TABLE_NAME + "(" + VersiculoCampos.VERSICULO_ID + "))";

    //Script de Creación de la tabla Tema
    public static final String CREATE_TEMA_SCRIPT =
        "create table " + TEMA_TABLE_NAME + "(" +
            TemaCampos.TEMA_ID + " " + INT_TYPE + " primary key autoincrement," +
            TemaCampos.TEMA_NOMBRE + " " + STRING_TYPE + " not null)";

    //Script de Creación de la tabla Promesa_Tema
    public static final String CREATE_PROMESA_TEMA_SCRIPT =
        "create table " + PROMESA_TEMA_TABLE_NAME + "(" +
            PromesaTemaCampos.PROMESA_TEMA_ID + " " + INT_TYPE + " primary key," +
            PromesaTemaCampos.PROMESA_TEMA_ID_TEMA + " " + INT_TYPE + " not null," +
            PromesaTemaCampos.PROMESA_TEMA_VERSICULO + " " + INT_TYPE + " not null," +
            "foreign key(" + PromesaTemaCampos.PROMESA_TEMA_ID_TEMA + ") references " + TEMA_TABLE_NAME + "(" + TemaCampos.TEMA_ID + ")," +
            "foreign key(" + PromesaTemaCampos.PROMESA_TEMA_VERSICULO + ") references " + VERSICULO_TABLE_NAME + "(" + VersiculoCampos.VERSICULO_ID + "))";

    //Scripts de inserción de la tabla Libro
    public static final String INSERT_LIBRO_SCRIPT =
        "insert into " + LIBRO_TABLE_NAME + " values" +
            "(1, \"Génesis\", \"Genesis\", \"AT\")," +
            "(2, \"Éxodo\", \"Exodus\", \"AT\")," +
            "(3, \"Levítico\", \"Leviticus\", \"AT\")," +
            "(4, \"Números\", \"Numbers\", \"AT\")," +
            "(5, \"Deuteronomio\", \"Deuteronomy\", \"AT\")," +
            "(6, \"Josué\", \"Joshua\", \"AT\")," +
            "(7, \"Jueces\", \"Judges\", \"AT\")," +
            "(8, \"Rut\", \"Ruth\", \"AT\")," +
            "(9, \"1 Samuel\", \"1 Samuel\", \"AT\")," +
            "(10, \"2 Samuel\", \"2 Samuel\", \"AT\")," +
            "(11, \"1 Reyes\", \"1 Kings\", \"AT\")," +
            "(12, \"2 Reyes\", \"2 Kings\", \"AT\")," +
            "(13, \"1 Crónicas\", \"1 Chronicles\", \"AT\")," +
            "(14, \"2 Crónicas\", \"2 Chronicles\", \"AT\")," +
            "(15, \"Esdras\", \"Ezra\", \"AT\")," +
            "(16, \"Nehemías\", \"Nehemiah\", \"AT\")," +
            "(17, \"Ester\", \"Esther\", \"AT\")," +
            "(18, \"Job\", \"Job\", \"AT\")," +
            "(19, \"Salmos\", \"Psalms\", \"AT\")," +
            "(20, \"Proverbios\", \"Proverbs\", \"AT\")," +
            "(21, \"Eclesiastés\", \"Ecclesiastes\", \"AT\")," +
            "(22, \"Cantares\", \"Song of Solomon\", \"AT\")," +
            "(23, \"Isaías\", \"Isaiah\", \"AT\")," +
            "(24, \"Jeremías\", \"Jeremiah\", \"AT\")," +
            "(25, \"Lamentaciones\", \"Lamentations\", \"AT\")," +
            "(26, \"Ezequiel\", \"Ezekiel\", \"AT\")," +
            "(27, \"Daniel\", \"Daniel\", \"AT\")," +
            "(28, \"Oseas\", \"Hosea\", \"AT\")," +
            "(29, \"Joel\", \"Joel\", \"AT\")," +
            "(30, \"Amós\", \"Amos\", \"AT\")," +
            "(31, \"Abdías\", \"Obadiah\", \"AT\")," +
            "(32, \"Jonás\", \"Jonah\", \"AT\")," +
            "(33, \"Miqueas\", \"Micah\", \"AT\")," +
            "(34, \"Nahúm\", \"Nahum\", \"AT\")," +
            "(35, \"Habacuc\", \"Habakkuk\", \"AT\")," +
            "(36, \"Sofonías\", \"Zephaniah\", \"AT\")," +
            "(37, \"Hageo\", \"Haggai\", \"AT\")," +
            "(38, \"Zacarías\", \"Zechariah\", \"AT\")," +
            "(39, \"Malaquías\", \"Malachi\", \"AT\")," +
            "(40, \"Mateo\", \"Matthew\", \"NT\")," +
            "(41, \"Marcos\", \"Mark\", \"NT\")," +
            "(42, \"Lucas\", \"Luke\", \"NT\")," +
            "(43, \"Juan\", \"John\", \"NT\")," +
            "(44, \"Hechos\", \"Acts\", \"NT\")," +
            "(45, \"Romanos\", \"Romans\", \"NT\")," +
            "(46, \"1 Corintios\", \"1 Corinthians\", \"NT\")," +
            "(47, \"2 Corintios\", \"2 Corinthians\", \"NT\")," +
            "(48, \"Gálatas\", \"Galatians\", \"NT\")," +
            "(49, \"Efesios\", \"Ephesians\", \"NT\")," +
            "(50, \"Filipenses\", \"Philippians\", \"NT\")," +
            "(51, \"Colosenses\", \"Colossians\", \"NT\")," +
            "(52, \"1 Tesalonicenses\", \"1 Thessalonians\", \"NT\")," +
            "(53, \"2 Tesalonicenses\", \"2 Thessalonians\", \"NT\")," +
            "(54, \"1 Timoteo\", \"1 Timothy\", \"NT\")," +
            "(55, \"2 Timoteo\", \"2 Timothy\", \"NT\")," +
            "(56, \"Tito\", \"Titus\", \"NT\")," +
            "(57, \"Filemón\", \"Philemon\", \"NT\")," +
            "(58, \"Hebreos\", \"Hebrews\", \"NT\")," +
            "(59, \"Santiago\", \"James\", \"NT\")," +
            "(60, \"1 Pedro\", \"1 Peter\", \"NT\")," +
            "(61, \"2 Pedro\", \"2 Peter\", \"NT\")," +
            "(62, \"1 Juan\", \"1 John\", \"NT\")," +
            "(63, \"2 Juan\", \"2 John\", \"NT\")," +
            "(64, \"3 Juan\", \"3 John\", \"NT\")," +
            "(65, \"Judas\", \"Jude\", \"NT\")," +
            "(66, \"Apocalipsis\", \"Revelation\", \"NT\")";

    //Scripts de inserción de la tabla Version
    public static final String INSERT_VERSION_SCRIPT =
        "insert into " + VERSION_TABLE_NAME + " values" +
            "(null, \"RVR1960\", \"Reina Valera 1960\")," +
            "(null, \"NVI\", \"Nueva Versión Internacional\")," +
            "(null, \"TLA\", \"Traducción en Lenguaje Actual\")," +
            "(null, \"NTV\", \"Nueva Traducción Viviente\")," +
            "(null, \"KJV\", \"King James Version\")";

    //Scripts de inserción de la tabla Versiculo
    public static final String INSERT_VERSICULO_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(1, 1, 19, 46, 1, \"Dios es nuestro amparo y fortaleza, Nuestro pronto auxilio en las tribulaciones.\")," + //Salmos 46:1 RVR60
            "(4, 1, 19, 40, 1, \"Pacientemente esperé a Jehová, Y se inclinó a mí, y oyó mi clamor.\")," + //Salmos 40:1 RVR60
            "(7, 1, 20, 11, 25, \"El alma generosa será prosperada; Y el que saciare, él también será saciado.\")," + //Proverbios 11:25 RVR60
            "(10, 1, 5, 3, 22, \"No los temáis; porque Jehová vuestro Dios, él es el que pelea por vosotros.\")," + //Deuteronomio 3:22 RVR60
            "(12, 1, 19, 32, 8, \"Te haré entender, y te enseñaré el camino en que debes andar; Sobre ti fijaré mis ojos.\")," + //Salmos 32:8 RVR60
            "(15, 1, 6, 1, 7, \"Solamente esfuérzate y sé muy valiente, para cuidar de hacer conforme a toda la ley que mi siervo Moisés te mandó; no te apartes de ella ni a diestra ni a siniestra, para que seas prosperado en todas las cosas que emprendas.\")," + //Josue 1:7 RVR60
            "(18, 1, 23, 43, 1, \"Ahora, así dice Jehová, Creador tuyo, oh Jacob, y Formador tuyo, oh Israel: No temas, porque yo te redimí; te puse nombre, mío eres tú.\")," + //Isaias 43:1 RVR60
            "(21, 1, 19, 50, 15, \"E invócame en el día de la angustia; Te libraré, y tú me honrarás.\")," + //Salmos 50:15 RVR60
            "(24, 1, 47, 6, 18, \"Y seré para vosotros por Padre, Y vosotros me seréis hijos e hijas, dice el Señor Todopoderoso.\")," + //2 Corintios 6:18 RVR60
            "(27, 1, 19, 23, 1, \"E invócame en el día de la angustia; Te libraré, y tú me honrarás.\")," + //Salmos 23:1 RVR60
            "(30, 1, 23, 58, 9, \"Entonces invocarás, y te oirá Jehová; clamarás, y dirá él: Heme aquí.\")," + //Isaias 58:9 RVR60
            "(33, 1, 23, 58, 11, \"Jehová te pastoreará siempre, y en las sequías saciará tu alma, y dará vigor a tus huesos; y serás como huerto de riego, y como manantial de aguas, cuyas aguas nunca faltan.\")," + //Isaias 58:11 RVR60
            "(36, 1, 19, 62, 2, \"Él solamente es mi roca y mi salvación. Es mi refugio, no resbalaré.\")," + //Salmos 62:6 RVR60
            "(39, 1, 45, 8, 28, \"Y sabemos que a los que aman a Dios, todas las cosas les ayudan a bien, esto es, a los que conforme a su propósito son llamados.\")," + //Romanos 8:28 RVR60
            "(42, 1, 19, 68, 19, \"Bendito el Señor; cada día nos colma de beneficios El Dios de nuestra salvación.\")," + //Salmos 68:19 RVR60
            "(45, 1, 40, 28, 20, \"enseñándoles que guarden todas las cosas que os he mandado; y he aquí yo estoy con vosotros todos los días, hasta el fin del mundo. Amén.\")," + //Mateo 28:20 RVR60
            "(48, 1, 2, 14, 14, \"Jehová peleará por vosotros, y vosotros estaréis tranquilos.\")," + //Exodo 14:14 RVR60
            "(50, 1, 2, 33, 14, \"Y él dijo: Mi presencia irá contigo, y te daré descanso.\")," + //Exodo 33:14 RVR60
            "(53, 1, 1, 28, 15, \"He aquí, yo estoy contigo, y te guardaré por dondequiera que fueres, y volveré a traerte a esta tierra; porque no te dejaré hasta que haya hecho lo que te he dicho.\")," + //Genesis 28:15 RVR60
            "(56, 1, 20, 16, 3, \"Encomienda a Jehová tus obras, Y tus pensamientos serán afirmados.\")," + //Proverbios 16:3 RVR60
            "(59, 1, 19, 37, 4, \"Deléitate asimismo en Jehová, Y él te concederá las peticiones de tu corazón.\")," + //Salmos 37:4 RVR60
            "(62, 1, 23, 41, 10, \"No temas, porque yo estoy contigo; no desmayes, porque yo soy tu Dios que te esfuerzo; siempre te ayudaré, siempre te sustentaré con la diestra de mi justicia.\")," + //Isaias 41:10 RVR60
            "(65, 1, 20, 18, 10, \"Torre fuerte es el nombre de Jehová; A él correrá el justo, y será levantado.\")," + //Proverbios 18:10 RVR60
            "(68, 1, 19, 37, 5, \"Pon tu vida en sus manos, confía plenamente en él, y él actuará en tu favor\")," + //Salmos 37:5 RVR60
            "(71, 1, 18, 8, 7, \"Y aunque tu principio haya sido pequeño, Tu postrer estado será muy grande.\")," + //Job 8:7 RVR60
            "(74, 1, 26, 34, 26, \"Y daré bendición a ellas y a los alrededores de mi collado, y haré descender la lluvia en su tiempo; lluvias de bendición serán.\")," + //Ezequiel 34:26 RVR60
            "(77, 1, 5, 15, 10, \"Sin falta le darás, y no serás de mezquino corazón cuando le des; porque por ello te bendecirá Jehová tu Dios en todos tus hechos, y en todo lo que emprendas.\")," + //Deuteronomio 15:10 RVR60
            "(80, 1, 50, 4, 13, \"Todo lo puedo en Cristo que me fortalece.\")," + //Filipenses 4:13 RVR60
            "(83, 1, 23, 44, 3, \"Porque yo derramaré aguas sobre el sequedal, y ríos sobre la tierra árida; mi Espíritu derramaré sobre tu generación, y mi bendición sobre tus renuevos;\")," + //Isaias 44:3 RVR60
            "(86, 1, 24, 20, 11, \"Mas Jehová está conmigo como poderoso gigante; por tanto, los que me persiguen tropezarán, y no prevalecerán; serán avergonzados en gran manera, porque no prosperarán; tendrán perpetua confusión que jamás será olvidada.\")," + //Jeremias 20:11 RVR60
            "(88, 1, 24, 31, 3, \"Jehová se manifestó a mí hace ya mucho tiempo, diciendo: Con amor eterno te he amado; por tanto, te prolongué mi misericordia.\")," + //Jeremias 31:3 RVR60
            "(90, 1, 19, 121, 8, \"Jehová guardará tu salida y tu entrada desde ahora y para siempre.\")," + //Salmos 121:8 RVR60
            "(93, 1, 58, 6, 14, \"diciendo: De cierto te bendeciré con abundancia y te multiplicaré grandemente.\")," + //Hebreos 6:14 RVR60
            "(95, 1, 39, 3, 10, \"Traed todos los diezmos al alfolí y haya alimento en mi casa; y probadme ahora en esto, dice Jehová de los ejércitos, si no os abriré las ventanas de los cielos, y derramaré sobre vosotros bendición hasta que sobreabunde\")," + //Malaquias 3:10 RVR60
            "(98, 1, 19, 3, 3, \"Mas tú, Jehová, eres escudo alrededor de mí; Mi gloria, y el que levanta mi cabeza.\")," + //Salmos 3:3 RVR60
            "(101, 1, 5, 31, 8, \"Y Jehová va delante de ti; él estará contigo, no te dejará, ni te desamparará; no temas ni te intimides.\")," + //Deuteronomio 31:8 RVR60
            "(104, 1, 42, 11, 10, \"Porque todo aquel que pide, recibe; y el que busca, halla; y al que llama, se le abrirá.\")," + //Lucas 11:10 RVR60
            "(107, 1, 42, 1, 37, \"Porque nada hay imposible para Dios.\")," + //Lucas 1:37 RVR60
            "(110, 1, 20, 22, 4, \"Riquezas, honra y vida son la remuneración de la humildad y del temor de Jehová.\")," + //Proverbios 22:4 RVR60
            "(113, 1, 19, 5, 12, \"Porque tú, oh Jehová, bendecirás al justo; Como con un escudo lo rodearás de tu favor.\")," + //Salmos 5:12 RVR60
            "(116, 1, 19, 1, 3, \"Será como árbol plantado junto a corrientes de aguas, Que da su fruto en su tiempo, Y su hoja no cae; Y todo lo que hace, prosperará.\")," + //Salmos 1:3 RVR60
            "(119, 1, 46, 2, 9, \"Antes bien, como está escrito: 'Cosas que ojo no vio, ni oído oyó, Ni han subido en corazón de hombre, Son las que Dios ha preparado para los que le aman.'\")," + //1 Corintios 2:9 RVR60
            "(122, 1, 41, 9, 23, \"Jesús le dijo: Si puedes creer, al que cree todo le es posible.\")," + //Marcos 9:23 RVR60
            "(125, 1, 40, 6, 33, \"Mas buscad primeramente el reino de Dios y su justicia, y todas estas cosas os serán añadidas.\")," + //Mateo 6:33 RVR60
            "(128, 1, 16, 8, 10, \"Luego les dijo: Id, comed grosuras, y bebed vino dulce, y enviad porciones a los que no tienen nada preparado; porque día santo es a nuestro Señor; no os entristezcáis, porque el gozo de Jehová es vuestra fuerza.\")," + //Nehemías 8:10 RVR60
            "(131, 1, 20, 1, 33, \"Mas el que me oyere, habitará confiadamente y vivirá tranquilo, sin temor del mal.\")," + //Proverbios 1:33 RVR60
            "(134, 1, 41, 10, 27, \"Entonces Jesús, mirándolos, dijo: Para los hombres es imposible, mas para Dios, no; porque todas las cosas son posibles para Dios.\")," + //Marcos 10:27 RVR60
            "(137, 1, 19, 40, 4, \"Bienaventurado el hombre que puso en Jehová su confianza, y no mira a los soberbios, ni a los que se desvían tras la mentira.\")," + //Salmos 40:4 RVR60
            "(140, 1, 24, 17, 7, \"Bendito el varón que confía en Jehová, y cuya confianza es Jehová.\")," + //Jeremias 17:7 RVR60
            "(143, 1, 20, 16, 20, \"El entendido en la palabra hallará el bien, Y el que confía en Jehová es bienaventurado.\")," + //Proverbios 16:20 RVR60
            "(146, 1, 19, 138, 8, \"Jehová cumplirá su propósito en mí; Tu misericordia, oh Jehová, es para siempre; No desampares la obra de tus manos.\")," + //Salmos 138:8 RVR60
            "(149, 1, 25, 3, 25, \"Bueno es Jehová a los que en él esperan, al alma que le busca.\")," + //Lamentaciones 3:25 RVR60
            "(152, 1, 24, 29, 11, \"Porque yo sé los pensamientos que tengo acerca de vosotros, dice Jehová, pensamientos de paz, y no de mal, para daros el fin que esperáis.\")," + //Jeremias 29:11 RVR60
            "(155, 1, 5, 4, 31, \"porque Dios misericordioso es Jehová tu Dios; no te dejará, ni te destruirá, ni se olvidará del pacto que les juró a tus padres.\")," + //Deuteronomio 4:31 RVR60
            "(158, 1, 43, 15, 7, \"Si permanecéis en mí, y mis palabras permanecen en vosotros, pedid todo lo que queréis, y os será hecho.\")," + //Juan 15:7 RVR60
            "(161, 1, 14, 15, 7, \"Pero esforzaos vosotros, y no desfallezcan vuestras manos, pues hay recompensa para vuestra obra.\")," + //2 Cronicas 15:7 RVR60
            "(167, 1, 24, 33, 3, \"Clama a mí, y yo te responderé, y te enseñaré cosas grandes y ocultas que tú no conoces.\")," + //Jeremias 33:3 RVR60
            "(170, 1, 47, 5, 17, \"De modo que si alguno está en Cristo, nueva criatura es; las cosas viejas pasaron; he aquí todas son hechas nuevas.\")," + //2 Corintios 5:17 RVR60
            "(172, 1, 1, 12, 2, \"Y haré de ti una nación grande, y te bendeciré, y engrandeceré tu nombre, y serás bendición.\")," + //Genesis 12:2 RVR60
            "(175, 1, 23, 40, 29, \"Él da esfuerzo al cansado, y multiplica las fuerzas al que no tiene ningunas.\")," + //Isaias 40:29 RVR60
            "(178, 1, 44, 16, 31, \"Ellos dijeron: Cree en el Señor Jesucristo, y serás salvo, tú y tu casa.\")," + //Hechos 16:31 RVR60
            "(181, 1, 23, 55, 5, \"He aquí, llamarás a gente que no conociste, y gentes que no te conocieron correrán a ti, por causa de Jehová tu Dios, y del Santo de Israel que te ha honrado.\")," + //Isaias 55:5 RVR60
            "(184, 1, 50, 4, 19, \"Mi Dios, pues, suplirá todo lo que os falta conforme a sus riquezas en gloria en Cristo Jesús.\")," + //Filipenses 4:19 RVR60
            "(187, 1, 23, 58, 8, \"Entonces nacerá tu luz como el alba, y tu salvación se dejará ver pronto; e irá tu justicia delante de ti, y la gloria de Jehová será tu retaguardia.\")," + //Isaias 58:8 RVR60
            "(190, 1, 34, 1, 7, \"Jehová es bueno, fortaleza en el día de la angustia; y conoce a los que en él confían.\")," + //Nahum 1:7 RVR60
            "(193, 1, 53, 3, 3, \"Pero fiel es el Señor, que os afirmará y guardará del mal.\")," + //2 Tesalonicenses 3:3 RVR60
            "(199, 1, 40, 11, 28, \"Venid a mí todos los que estáis trabajados y cargados, y yo os haré descansar.\")," + //Mateo 11:28 RVR60
            "(202, 1, 4, 6, 24, \"Jehová te bendiga, y te guarde.\")," + //Numeros 6:24 RVR60
            "(205, 1, 5, 28, 12, \"Te abrirá Jehová su buen tesoro, el cielo, para enviar la lluvia a tu tierra en su tiempo, y para bendecir toda obra de tus manos. Y prestarás a muchas naciones, y tú no pedirás prestado.\")"; //Deuteronomio 28:12 RVR60

    public static final String INSERT_VERSICULO_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(2, 2, 19, 46, 1, \"Dios es nuestro amparo y nuestra fortaleza, nuestra ayuda segura en momentos de angustia.\")," + //Salmos 46:1 NVI
            "(5, 2, 19, 40, 1, \"Puse en el Señor toda mi esperanza; él se inclinó hacia mí y escuchó mi clamor.\")," + //Salmos 40:1 NVI
            "(8, 2, 20, 11, 25, \"El que es generoso prospera; el que reanima será reanimado.\")," + //Proverbios 11:25 NVI
            "(11, 2, 5, 3, 22, \"No les tengas miedo, que el Señor tu Dios pelea por ti.\")," + //Deuteronomio 3:22 NVI
            "(13, 2, 19, 32, 8, \"El Señor dice: 'Yo te instruiré, yo te mostraré el camino que debes seguir; yo te daré consejos y velaré por ti.'\")," + //Salmos 32:8 NVI
            "(16, 2, 6, 1, 7, \"Sólo te pido que tengas mucho valor y firmeza para obedecer toda la ley que mi siervo Moisés te mandó. No te apartes de ella para nada; sólo así tendrás éxito dondequiera que vayas.\")," + //Josue 1:7 NVI
            "(19, 2, 23, 43, 1, \"Pero ahora, así dice el Señor, el que te creó, Jacob, el que te formó, Israel: 'No temas, que yo te he redimido; te he llamado por tu nombre; tú eres mío'.\")," + //Isaias 43:1 NVI
            "(22, 2, 19, 50, 15, \"Invócame en el día de la angustia; yo te libraré y tú me honrarás.\")," + //Salmos 50:15 NVI
            "(25, 2, 47, 6, 18, \"Yo seré un padre para ustedes, y ustedes serán mis hijos y mis hijas, dice el Señor Todopoderoso.\")," + //2 Corintios 6:18 NVI
            "(28, 2, 19, 23, 1, \"Invócame en el día de la angustia; yo te libraré y tú me honrarás.\")," + //Salmos 23:1 NVI
            "(31, 2, 23, 58, 9, \"Llamarás, y el Señor responderá; pedirás ayuda, y él dirá: '¡Aquí estoy!'\")," + //Isaias 58:9 NVI
            "(34, 2, 23, 58, 11, \"El Señor te guiará siempre; te saciará en tierras resecas, fortalecerá tus huesos. Serás como jardín bien regado, como manantial cuyas aguas no se agotan.\")," + //Isaias 58:11 NVI
            "(37, 2, 19, 62, 2, \"Sólo él es mi roca y mi salvación; él es mi protector y no habré de caer.\")," + //Salmos 62:6 NVI
            "(40, 2, 45, 8, 28, \"Ahora bien, sabemos que Dios dispone todas las cosas para el bien de quienes lo aman, los que han sido llamados de acuerdo con su propósito.\")," + //Romanos 8:28 NVI
            "(43, 2, 19, 68, 19, \"Bendito sea el Señor, nuestro Dios y Salvador, que día tras día sobrelleva nuestras cargas.\")," + //Salmos 68:19 NVI
            "(46, 2, 40, 28, 20, \"enseñándoles a obedecer todo lo que les he mandado a ustedes. Y les aseguro que estaré con ustedes siempre, hasta el fin del mundo.\")," + //Mateo 28:20 NVI
            "(49, 2, 2, 14, 14, \"Ustedes quédense quietos, que el Señor presentará batalla por ustedes.\")," + //Exodo 14:14 NVI
            "(51, 2, 2, 33, 14, \"—Yo mismo iré contigo y te daré descanso —respondió el Señor.\")," + //Exodo 33:14 NVI
            "(54, 2, 1, 28, 15, \"Yo estoy contigo. Te protegeré por dondequiera que vayas, y te traeré de vuelta a esta tierra. No te abandonaré hasta cumplir con todo lo que te he prometido.\")," + //Genesis 28:15 NVI
            "(57, 2, 20, 16, 3, \"Pon en manos del Señor todas tus obras, y tus proyectos se cumplirán.\")," + //Proverbios 16:3 NVI
            "(60, 2, 19, 37, 4, \"Pon en manos del Señor todas tus obras, y tus proyectos se cumplirán.\")," + //Salmos 37:4 NVI
            "(63, 2, 23, 41, 10, \"Así que no temas, porque yo estoy contigo; no te angusties, porque yo soy tu Dios. Te fortaleceré y te ayudaré; te sostendré con mi diestra victoriosa.\")," + //Isaias 41:10 NVI
            "(66, 2, 20, 18, 10, \"Torre inexpugnable es el nombre del Señor; a ella corren los justos y se ponen a salvo.\")," + //Proverbios 18:10 NVI
            "(69, 2, 19, 37, 5, \"Encomienda al Señor tu camino; confía en él, y él actuará.\")," + //Salmos 37:5 NVI
            "(72, 2, 18, 8, 7, \"Modestas parecerán tus primeras riquezas, comparadas con tu prosperidad futura.\")," + //Job 8:7 NVI
            "(75, 2, 26, 34, 26, \"Haré que ellas y los alrededores de mi colina sean una fuente de bendición. Haré caer lluvias de bendición en el tiempo oportuno.\")," + //Ezequiel 34:26 NVI
            "(78, 2, 5, 15, 10, \"No seas mezquino sino generoso, y así el Señor tu Dios bendecirá todos tus trabajos y todo lo que emprendas.\")," + //Deuteronomio 15:10 NVI
            "(81, 2, 50, 4, 13, \"Todo lo puedo en Cristo que me fortalece.\")," + //Filipenses 4:13 NVI
            "(84, 2, 23, 44, 3, \"que regaré con agua la tierra sedienta, y con arroyos el suelo seco; derramaré mi Espíritu sobre tu descendencia, y mi bendición sobre tus vástagos\")," + //Isaias 44:3 NVI
            "(87, 2, 24, 20, 11, \"Pero el Señor está conmigo como un guerrero poderoso; por eso los que me persiguen caerán y no podrán prevalecer, fracasarán y quedarán avergonzados. Eterna será su deshonra; jamás será olvidada.\")," + //Jeremias 20:11 NVI
            "(89, 2, 24, 31, 3, \"Hace mucho tiempo se me apareció el Señor y me dijo: 'Con amor eterno te he amado; por eso te sigo con fidelidad'.\")," + //Jeremias 31:3 NVI
            "(91, 2, 19, 121, 8, \"El Señor te cuidará en el hogar y en el camino, desde ahora y para siempre.\")," + //Salmos 121:8 NVI
            "(94, 2, 58, 6, 14, \"y dijo: 'Te bendeciré en gran manera y multiplicaré tu descendencia.'\")," + //Hebreos 6:14 NVI
            "(96, 2, 39, 3, 10, \"Traigan íntegro el diezmo para los fondos del templo, y así habrá alimento en mi casa. Pruébenme en esto —dice el Señor Todopoderoso—, y vean si no abro las compuertas del cielo y derramo sobre ustedes bendición hasta que sobreabunde.\")," + //Malaquias 3:10 NVI
            "(99, 2, 19, 3, 3, \"Pero tú, Señor, me rodeas cual escudo; tú eres mi gloria; ¡tú mantienes en alto mi cabeza!\")," + //Salmos 3:3 NVI
            "(102, 2, 5, 31, 8, \"El Señor mismo marchará al frente de ti y estará contigo; nunca te dejará ni te abandonará. No temas ni te desanimes.\")," + //Deuteronomio 31:8 NVI
            "(105, 2, 42, 11, 10, \"Porque todo el que pide, recibe; el que busca, encuentra; y al que llama, se le abre.\")," + //Lucas 11:10 NVI
            "(108, 2, 42, 1, 37, \"Porque para Dios no hay nada imposible.\")," + //Lucas 1:37 NVI
            "(111, 2, 20, 22, 4, \"Recompensa de la humildad y del temor del Señor son las riquezas, la honra y la vida.\")," + //Proverbios 22:4 NVI
            "(114, 2, 19, 5, 12, \"Porque tú, Señor, bendices a los justos; cual escudo los rodeas con tu buena voluntad.\")," + //Salmos 5:12 NVI
            "(117, 2, 19, 1, 3, \"Es como el árbol plantado a la orilla de un río que, cuando llega su tiempo, da fruto y sus hojas jamás se marchitan. ¡Todo cuanto hace prospera!\")," + //Salmos 1:3 NVI
            "(120, 2, 46, 2, 9, \"Sin embargo, como está escrito: 'Ningún ojo ha visto, ningún oído ha escuchado, ninguna mente humana ha concebido lo que Dios ha preparado para quienes lo aman.'\")," + //1 Corintios 2:9 NVI
            "(123, 2, 41, 9, 23, \"—¿Cómo que si puedo? Para el que cree, todo es posible.\")," + //Marcos 9:23 NVI
            "(126, 2, 40, 6, 33, \"Más bien, busquen primeramente el reino de Dios y su justicia, y todas estas cosas les serán añadidas.\")," + //Mateo 6:33 NVI
            "(129, 2, 16, 8, 10, \"Luego Nehemías añadió: 'Ya pueden irse. Coman bien, tomen bebidas dulces y compartan su comida con quienes no tengan nada, porque este día ha sido consagrado a nuestro Señor. No estén tristes, pues el gozo del Señor es nuestra fortaleza.'\")," + //Nehemías 8:10 NVI
            "(132, 2, 20, 1, 33, \"Pero el que me obedezca vivirá tranquilo, sosegado y sin temor del mal.\")," + //Proverbios 1:33 NVI
            "(135, 2, 41, 10, 27, \"—Para los hombres es imposible —aclaró Jesús, mirándolos fijamente—, pero no para Dios; de hecho, para Dios todo es posible.\")," + //Marcos 10:27 NVI
            "(138, 2, 19, 40, 4, \"Dichoso el que pone su confianza en el Señor y no recurre a los idólatras ni a los que adoran dioses falsos\")," + //Salmos 40:4 NVI
            "(141, 2, 24, 17, 7, \"Bendito el hombre que confía en el Señor, y pone su confianza en él.\")," + //Jeremias 17:7 NVI
            "(144, 2, 20, 16, 20, \"El que atiende a la palabra, prospera. ¡Dichoso el que confía en el Señor!\")," + //Proverbios 16:20 NVI
            "(147, 2, 19, 138, 8, \"El Señor cumplirá en mí su propósito. Tu gran amor, Señor, perdura para siempre; ¡no abandones la obra de tus manos!\")," + //Salmos 138:8 NVI
            "(150, 2, 25, 3, 25, \"Bueno es el Señor con quienes en él confían, con todos los que lo buscan.\")," + //Lamentaciones 3:25 NVI
            "(153, 2, 24, 29, 11, \"Porque yo sé muy bien los planes que tengo para ustedes —afirma el Señor—, planes de bienestar y no de calamidad, a fin de darles un futuro y una esperanza.\")," + //Jeremias 29:11 NVI
            "(156, 2, 5, 4, 31, \"Porque el Señor tu Dios es un Dios compasivo, que no te abandonará ni te destruirá, ni se olvidará del pacto que mediante juramento hizo con tus antepasados.\")," + //Deuteronomio 4:31 NVI
            "(159, 2, 43, 15, 7, \"Si permanecen en mí y mis palabras permanecen en ustedes, pidan lo que quieran, y se les concederá.\")," + //Juan 15:7 NVI
            "(162, 2, 14, 15, 7, \"Pero ustedes, ¡manténganse firmes y no bajen la guardia, porque sus obras serán recompensadas!\")," + //2 Cronicas 15:7 NVI
            "(168, 2, 24, 33, 3, \"Clama a mí y te responderé, y te daré a conocer cosas grandes y ocultas que tú no sabes.\")," + //Jeremias 33:3 NVI
            "(171, 2, 47, 5, 17, \"Por lo tanto, si alguno está en Cristo, es una nueva creación. ¡Lo viejo ha pasado, ha llegado ya lo nuevo!\")," + //2 Corintios 5:17 NVI
            "(173, 2, 1, 12, 2, \"Haré de ti una nación grande, y te bendeciré; haré famoso tu nombre, y serás una bendición.\")," + //Genesis 12:2 NVI
            "(176, 2, 23, 40, 29, \"Él fortalece al cansado y acrecienta las fuerzas del débil.\")," + //Isaias 40:29 NVI
            "(179, 2, 44, 16, 31, \"—Cree en el Señor Jesús; así tú y tu familia serán salvos —le contestaron.\")," + //Hechos 16:31 NVI
            "(182, 2, 23, 55, 5, \"Sin duda convocarás a naciones que no conocías, y naciones que no te conocían correrán hacia ti, gracias al Señor tu Dios, el Santo de Israel, que te ha colmado de honor.\")," + //Isaias 55:5 NVI
            "(185, 2, 50, 4, 19, \"Así que mi Dios les proveerá de todo lo que necesiten, conforme a las gloriosas riquezas que tiene en Cristo Jesús.\")," + //Filipenses 4:19 NVI
            "(188, 2, 23, 58, 8, \"Si así procedes, tu luz despuntará como la aurora, y al instante llegará tu sanidad; tu justicia te abrirá el camino, y la gloria del Señor te seguirá.\")," + //Isaias 58:8 NVI
            "(191, 2, 34, 1, 7, \"Bueno es el Señor; es refugio en el día de la angustia, y protector de los que en él confían.\")," + //Nahum 1:7 NVI
            "(194, 2, 53, 3, 3, \"Pero el Señor es fiel, y él los fortalecerá y los protegerá del maligno.\")," + //2 Tesalonicenses 3:3 NVI
            "(200, 2, 40, 11, 28, \"Vengan a mí todos ustedes que están cansados y agobiados, y yo les daré descanso.\")," + //Mateo 11:28 NVI
            "(203, 2, 4, 6, 24, \"El Señor te bendiga y te guarde.\")," + //Numeros 6:24 NVI
            "(206, 2, 5, 28, 12, \"El Señor abrirá los cielos, su generoso tesoro, para derramar a su debido tiempo la lluvia sobre la tierra, y para bendecir todo el trabajo de tus manos. Tú les prestarás a muchas naciones, pero no tomarás prestado de nadie.\")"; //Deuteronomio 28:12 NVI

    public static final String INSERT_VERSICULO_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(3, 3, 19, 46, 1, \"Nuestro Dios es como un castillo que nos brinda protección. Dios siempre nos ayuda cuando estamos en problemas.\")," + //Salmos 46:1 TLA
            "(6, 3, 19, 40, 1, \"Toda mi esperanza la tengo puesta en Dios, pues aceptó atender mis ruegos.\")," + //Salmos 40:1 TLA
            "(9, 3, 20, 11, 25, \"El que es generoso, progresa; el que siembra, también cosecha.\")," + //Proverbios 11:25 TLA
            "(14, 3, 19, 32, 8, \"Tú me dijiste: 'Yo te voy a instruir; te voy a enseñar cómo debes portarte. Voy a darte buenos consejos y a cuidar siempre de ti.'\")," +  //Salmos 32:8 TLA
            "(17, 3, 6, 1, 7, \"Sólo te pido que seas muy fuerte y valiente. Así podrás obedecer siempre todas las leyes que te dio mi servidor Moisés. No desobedezcas ni una sola de ellas, y te irá bien por dondequiera que vayas.\")," + //Josue 1:7 TLA
            "(20, 3, 23, 43, 1, \"Isaías dijo: Ahora, pueblo de Israel, Dios tu creador te dice: 'No tengas miedo. Yo te he liberado; te he llamado por tu nombre y tú me perteneces'.\")," + //Isaias 43:1 TLA
            "(23, 3, 19, 50, 15, \"¡Llámame cuando tengas problemas! Yo vendré a salvarte, y tú me darás alabanza.\")," + //Salmos 50:15 TLA
            "(26, 3, 47, 6, 18, \"Yo seré para ustedes como un padre, y ustedes serán para mí como mis hijos y mis hijas. Esto lo afirmo yo, el Dios todopoderoso.\")," + //2 Corintios 6:18 TLA
            "(29, 3, 19, 23, 1, \"¡Llámame cuando tengas problemas! Yo vendré a salvarte, y tú me darás alabanza.\")," + //Salmos 23:1 TLA
            "(32, 3, 23, 58, 9, \"Si me llaman, yo les responderé; si gritan pidiendo ayuda, yo les diré: 'Aquí estoy'\")," + //Isaias 58:9 TLA
            "(35, 3, 23, 58, 11, \"Yo los guiaré constantemente, les daré agua en el calor del desierto, daré fuerzas a su cuerpo, y serán como un jardín bien regado, como una corriente de agua.\"),"+ //Isaias 58:11 TLA
            "(38, 3, 19, 62, 2, \"Sólo él me da su protección, sólo él puede salvarme; ¡jamás seré derrotado!\")," + //Salmos 62:6 TLA
            "(41, 3, 45, 8, 28, \"Sabemos que Dios va preparando todo para el bien de los que lo aman, es decir, de los que él ha llamado de acuerdo con su plan.\")," + //Romanos 8:28 TLA
            "(44, 3, 19, 68, 19, \"¡Bendito seas siempre, nuestro Dios! Tú, Dios y salvador nuestro, nos ayudas en nuestros problemas.\")," + //Salmos 68:19 TLA
            "(47, 3, 40, 28, 20, \"Enséñenles a obedecer todo lo que yo les he enseñado. Yo estaré siempre con ustedes, hasta el fin del mundo.\")," + //Mateo 28:20 TLA
            "(52, 3, 2, 33, 14, \"Dios le contestó: —Yo mismo voy a acompañarte y te haré estar tranquilo.\")," + //Exodo 33:14 TLA
            "(55, 3, 1, 28, 15, \"Yo estaré contigo, y no te abandonaré hasta cumplir lo que te he prometido. Te cuidaré por dondequiera que vayas, y te haré volver a esta tierra.\")," + //Genesis 28:15 TLA
            "(58, 3, 20, 16, 3, \"Deja en manos de Dios todo lo que haces, y tus proyectos se harán realidad.\")," + //Proverbios 16:3 TLA
            "(61, 3, 19, 37, 4, \"Entrégale a Dios tu amor, y él te dará lo que más deseas.\")," + //Salmos 37:4 TLA
            "(64, 3, 23, 41, 10, \"Por tanto, no tengan miedo, pues yo soy su Dios y estoy con ustedes. Mi mano victoriosa les dará fuerza y ayuda; mi mano victoriosa siempre les dará su apoyo.\")," + //Isaias 41:10 TLA
            "(67, 3, 20, 18, 10, \"Dios es como una alta torre; hacia él corren los buenos para ponerse a salvo.\")," + //Proverbios 18:10 TLA
            "(70, 3, 19, 37, 5, \"Dios es como una alta torre; hacia él corren los buenos para ponerse a salvo.\")," + //Salmos 37:5 TLA
            "(73, 3, 18, 8, 7, \"Tus primeras riquezas no serán nada, comparadas con las que tendrás después.\")," + //Job 8:7 TLA
            "(76, 3, 26, 34, 26, \"Yo los dejaré vivir alrededor de mi monte, y les enviaré abundantes lluvias en el momento oportuno.\")," + //Ezequiel 34:26 TLA
            "(79, 3, 5, 15, 10, \"Mejor ayuden siempre al pobre, y háganlo con alegría. Si lo hacen, les irá bien y Dios los bendecirá en todo lo que hagan.\")," + //Deuteronomio 15:10 TLA
            "(82, 3, 50, 4, 13, \"Cristo me da fuerzas para enfrentarme a toda clase de situaciones.\")," + //Filipenses 4:13 TLA
            "(85, 3, 23, 44, 3, \"Yo haré que corra agua en el desierto y que broten arroyos en tierras secas. A tus descendientes les daré vida nueva y les enviaré mi bendición.\")," + //Isaias 44:3 TLA
            "(92, 3, 19, 121, 8, \"Dios te cuidará ahora y siempre por dondequiera que vayas.\")," + //Salmos 121:8 TLA
            "(97, 3, 39, 3, 10, \"Traigan a mi templo sus diezmos, y échenlos en el cofre de las ofrendas; así no les faltará alimento. ¡Pónganme a prueba con esto! Verán que abriré las ventanas del cielo, y les enviaré abundantes lluvias.\")," + //Malaquias 3:10 TLA
            "(100, 3, 19, 3, 3, \"Sólo tú, Dios mío, me proteges como un escudo; y con tu poder me das nueva vida.\")," + //Salmos 3:3 TLA
            "(103, 3, 5, 31, 8, \"Dios mismo será tu guía, y te ayudará en todo; él jamás te abandonará. ¡Echa fuera el miedo y la cobardía!\")," + //Deuteronomio 31:8 TLA
            "(106, 3, 42, 11, 10, \"Porque el que confía en Dios recibe lo que pide, encuentra lo que busca y, si llama, es atendido.\")," + //Lucas 11:10 TLA
            "(109, 3, 42, 1, 37, \"Eso demuestra que para Dios todo es posible.\")," + //Lucas 1:37 TLA
            "(112, 3, 20, 22, 4, \"Humíllate y obedece a Dios, y recibirás riquezas, honra y vida.\")," + //Proverbios 22:4 TLA
            "(115, 3, 19, 5, 12, \"Tú, Dios mío, bendices al que es bueno, y con tu amor lo proteges.\")," + //Salmos 5:12 TLA
            "(118, 3, 19, 1, 3, \"Son como árboles sembrados junto a los arroyos: llegado el momento, dan mucho fruto y no se marchitan sus hojas. ¡Todo lo que hacen les sale bien!\")," + //Salmos 1:3 TLA
            "(121, 3, 46, 2, 9, \"Como dice la Biblia: 'Para aquellos que lo aman, Dios ha preparado cosas que nadie jamás pudo ver, ni escuchar ni imaginar.'\")," + //1 Corintios 2:9 TLA
            "(124, 3, 41, 9, 23, \"Jesús le preguntó: '—¿Puedes confiar en Dios? Para el que confía en él, todo es posible.'\")," + //Marcos 9:23 TLA
            "(127, 3, 40, 6, 33, \"Lo más importante es que reconozcan a Dios como único rey, y que hagan lo que él les pide. Dios les dará a su tiempo todo lo que necesiten.\")," + //Mateo 6:33 TLA
            "(130, 3, 16, 8, 10, \"Esdras también les dijo: '¡Hagan fiesta! Coman de lo mejor, beban vino dulce; inviten a los que no tengan nada preparado. Hoy es un día dedicado a nuestro Dios, así que no se pongan tristes. ¡Alégrense, que Dios les dará fuerzas!'\")," + //Nehemías 8:10 TLA
            "(133, 3, 20, 1, 33, \"Pero los que me hagan caso vivirán tranquilos y en paz, y no tendrán miedo del mal\")," + //Proverbios 1:33 TLA
            "(136, 3, 41, 10, 27, \"Jesús los miró y les dijo: —Para los seres humanos eso es imposible, pero todo es posible para Dios.\")," + //Marcos 10:27 TLA
            "(139, 3, 19, 40, 4, \"Dios bendice a los que en él confían, a los que rechazan a los orgullosos que adoran dioses falsos.\")," + //Salmos 40:4 TLA
            "(142, 3, 24, 17, 7, \"¡Pero benditos sean aquellos que sólo confían en mí!\")," + //Jeremias 17:7 TLA
            "(145, 3, 20, 16, 20, \"El buen administrador prospera; ¡Dios bendice a quienes en él confían!\")," + //Proverbios 16:20 TLA
            "(148, 3, 19, 138, 8, \"Dios mío, tú cumplirás en mí todo lo que has pensado hacer. Tu amor por mí no cambia, pues tú mismo me hiciste. ¡No me abandones!\")," + //Salmos 138:8 TLA
            "(151, 3, 25, 3, 25, \"Invito a todos a confiar en Dios porque él es bondadoso.\")," + //Lamentaciones 3:25 TLA
            "(154, 3, 24, 29, 11, \"Mis planes para ustedes solamente yo los sé, y no son para su mal, sino para su bien. Voy a darles un futuro lleno de bienestar.\")," + //Jeremias 29:11 TLA
            "(157, 3, 5, 4, 31, \"él no los abandonará ni los destruirá, porque los ama mucho. Dios jamás se olvidará del pacto que hizo con los antepasados de ustedes, pues se comprometió a cumplirlo.\")," + //Deuteronomio 4:31 TLA
            "(160, 3, 43, 15, 7, \"Si ustedes se mantienen unidos a mí y obedecen todo lo que les he enseñado, recibirán de mi Padre todo lo que pidan.\")," + //Juan 15:7 TLA
            "(163, 3, 14, 15, 7, \"¡Sean valientes, no dejen de obedecer a Dios, y él les dará su recompensa!\")," + //2 Cronicas 15:7 TLA
            "(169, 3, 24, 33, 3, \"Llámame y te responderé. Te haré conocer cosas maravillosas y misteriosas que nunca has conocido.\")," + //Jeremias 33:3 TLA
            "(174, 3, 1, 12, 2, \"Con tus descendientes formaré una gran nación. Voy a bendecirte y hacerte famoso, y serás de bendición para otros.\")," + //Genesis 12:2 TLA
            "(177, 3, 23, 40, 29, \"Dios les da nuevas fuerzas a los débiles y cansados.\")," + //Isaias 40:29 TLA
            "(180, 3, 44, 16, 31, \"Ellos le respondieron: —Cree en el Señor Jesús, y tú y tu familia se salvarán.\")," + //Hechos 16:31 TLA
            "(183, 3, 23, 55, 5, \"Pueblo de Israel, llamarás a pueblos que no conocías, y ellos irán corriendo hacia ti, porque yo, tu Dios, te pondré sobre todas las naciones\")," + //Isaias 55:5 TLA
            "(186, 3, 50, 4, 19, \"Por eso, de sus riquezas maravillosas mi Dios les dará, por medio de Jesucristo, todo lo que les haga falta.\")," + //Filipenses 4:19 TLA
            "(189, 3, 23, 58, 8, \"Los que ayunan así brillarán como la luz de la aurora, y sus heridas sanarán muy pronto. Delante de ellos irá la justicia y detrás de ellos, la protección de Dios.\")," + //Isaias 58:8 TLA
            "(192, 3, 34, 1, 7, \"Nuestro Dios es bondadoso y cuida de los que en él confían. En momentos de angustia, él nos brinda protección.\")," + //Nahum 1:7 TLA
            "(195, 3, 53, 3, 3, \"Pero el Señor Jesucristo les dará una firme confianza y los protegerá del mal, porque él siempre cumple lo que dice.\")," + //2 Tesalonicenses 3:3 TLA
            "(201, 3, 40, 11, 28, \"Ustedes viven siempre angustiados y preocupados. Vengan a mí, y yo los haré descansar.\")," + //Mateo 11:28 TLA
            "(204, 3, 4, 6, 24, \"Que Dios te bendiga y siempre te cuide.\")," + //Numeros 6:24 TLA
            "(207, 3, 5, 28, 12, \"pues Dios abrirá los cielos, donde guarda la lluvia, y regará los sembrados de ustedes. En todo lo que ustedes hagan, siempre les irá bien. Nunca tendrán que pedir prestado nada; al contrario, ustedes tendrán de sobra para prestarles a otros países.\")" ; //Deuteronomio 28:12 TLA

    public static final String INSERT_VERSICULO_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(196, 4, 40, 11, 28, \"Luego dijo Jesús: «Vengan a mí todos los que están cansados y llevan cargas pesadas, y yo les daré descanso.\")," + //Mateo 11:28 NTV
            "(197, 4, 4, 6, 24, \"Que el Señor te bendiga y te proteja.\")," + //Numeros 6:24 NTV
            "(198, 4, 5, 28, 12, \"El Señor enviará lluvias en el tiempo oportuno desde su inagotable tesoro en los cielos y bendecirá todo tu trabajo. Tú prestarás a muchas naciones pero jamás tendrás necesidad de pedirles prestado.\")," + //Deuteronomio 28:12 NTV
            "(208, 4, 19, 46, 1, \"Dios es nuestro refugio y nuestra fuerza, siempre está dispuesto a ayudar en tiempos de dificultad.\")," + //Salmos 46:1 NTV
            "(209, 4, 19, 40, 1, \"Con paciencia esperé que el Señor me ayudara, y él se fijó en mí y oyó mi clamor.\")," + //Salmos 40:1 NTV
            "(210, 4, 20, 11, 25, \"El generoso prosperará, y el que reanima a otros será reanimado.\")," + //Proverbios 11:25 NTV
            "(211, 4, 5, 3, 22, \"No tengas miedo de esas naciones, porque el Señor tu Dios peleará por ustedes.\")," + //Deuteronomio 3:22 NTV
            "(212, 4, 19, 32, 8, \"El Señor dice: Te guiaré por el mejor sendero para tu vida; te aconsejaré y velaré por ti.\")," + //Salmos 32:8 NTV
            "(213, 4, 6, 1, 7, \"Sé fuerte y muy valiente. Ten cuidado de obedecer todas las instrucciones que Moisés te dio. No te desvíes de ellas ni a la derecha ni a la izquierda. Entonces te irá bien en todo lo que hagas.\")," + //Josue 1:7 NTV
            "(214, 4, 23, 43, 1, \"Pero ahora, oh Jacob, escucha al Señor, quien te creó. Oh Israel, el que te formó dice: 'No tengas miedo, porque he pagado tu rescate; te he llamado por tu nombre; eres mío'.\")," + //Isaias 43:1 NTV
            "(215, 4, 19, 50, 15, \"Luego llámame cuando tengas problemas, y yo te rescataré, y tú me darás la gloria.\")," + //Salmos 50:15 NTV
            "(216, 4, 47, 6, 18, \"Y yo seré su Padre, y ustedes serán mis hijos e hijas, dice el Señor Todopoderoso.\")," + //2 Corintios 6:18 NTV
            "(217, 4, 19, 23, 1, \"El Señor es mi pastor; tengo todo lo que necesito.\")," + //Salmos 23:1 NTV
            "(218, 4, 23, 58, 9, \"Entonces cuando ustedes llamen, el Señor les responderá. 'Sí, aquí estoy', les contestará enseguida.\")," + //Isaias 58:9 NTV
            "(219, 4, 23, 58, 11, \"El Señor los guiará continuamente, les dará agua cuando tengan sed y restaurará sus fuerzas. Serán como un huerto bien regado, como un manantial que nunca se seca.\")," + //Isaias 58:11 NTV
            "(220, 4, 19, 62, 6, \"Solo él es mi roca y mi salvación, mi fortaleza donde no seré sacudido.\")," + //Salmos 62:6 NTV
            "(221, 4, 45, 8, 28, \"Y sabemos que Dios hace que todas las cosas cooperen para el bien de quienes lo aman y son llamados según el propósito que él tiene para ellos.\")," + //Romanos 8:28 NTV
            "(222, 4, 19, 68, 19, \"¡Alaben al Señor, alaben a Dios nuestro salvador! Pues cada día nos lleva en sus brazos.\")," + //Salmos 68:19 NTV
            "(223, 4, 40, 28, 20, \"Enseñen a los nuevos discípulos a obedecer todos los mandatos que les he dado. Y tengan por seguro esto: que estoy con ustedes siempre, hasta el fin de los tiempos.\")," + //Mateo 28:20 NTV
            "(224, 4, 2, 14, 14, \"El Señor mismo peleará por ustedes. Solo quédense tranquilos.\")," + //Exodo 14:14 NTV
            "(225, 4, 2, 33, 14, \"El Señor le respondió: '—Yo mismo iré contigo, Moisés, y te daré descanso; todo te saldrá bien.'\")," + //Exodo 33:14 NTV
            "(226, 4, 1, 28, 15, \"Además, yo estoy contigo y te protegeré dondequiera que vayas. Llegará el día en que te traeré de regreso a esta tierra. No te dejaré hasta que haya terminado de darte todo lo que te he prometido.\")," + //Genesis 28:15 NTV
            "(227, 4, 20, 16, 3, \"Pon todo lo que hagas en manos del Señor, y tus planes tendrán éxito.\")," + //Proverbios 16:3 NTV
            "(228, 4, 19, 37, 4, \"Deléitate en el Señor, y él te concederá los deseos de tu corazón.\")," + //Salmos 37:4 NTV
            "(229, 4, 23, 41, 10, \"No tengas miedo, porque yo estoy contigo; no te desalientes, porque yo soy tu Dios. Te daré fuerzas y te ayudaré; te sostendré con mi mano derecha victoriosa.\")," + //Isaias 41:10 NTV
            "(230, 4, 20, 18, 10, \"El nombre del Señor es una fortaleza firme; los justos corren a él y quedan a salvo.\")," + //Proverbios 18:10 NTV
            "(231, 4, 19, 37, 5, \"Entrega al Señor todo lo que haces; confía en él, y él te ayudará.\")," + //Salmos 37:5 NTV
            "(232, 4, 18, 8, 7, \"Aunque comenzaste con poco, terminarás con mucho.\")," + //Job 8:7 NTV
            "(233, 4, 26, 34, 26, \"Bendeciré a mi pueblo y a sus hogares alrededor de mi colina sagrada. En la temporada oportuna les enviaré las lluvias que necesiten; habrá lluvias de bendición.\")," + //Ezequiel 34:26 NTV
            "(234, 4, 5, 15, 10, \"Da al pobre con generosidad, no de mala gana, porque el Señor tu Dios te bendecirá en todo lo que hagas.\")," + //Deuteronomio 15:10 NTV
            "(235, 4, 50, 4, 13, \"Pues todo lo puedo hacer por medio de Cristo, quien me da las fuerzas.\")," + //Filipenses 4:13 NTV
            "(236, 4, 23, 44, 3, \"Pues derramaré agua para calmar tu sed y para regar tus campos resecos; derramaré mi Espíritu sobre tus descendientes, y mi bendición sobre tus hijos.\")," + //Isaias 44:3 NTV
            "(237, 4, 24, 20, 11, \"No obstante, el Señor está a mi lado como un gran guerrero; ante él mis perseguidores caerán. No pueden derrotarme. Fracasarán y serán totalmente humillados; nunca se olvidará su deshonra.\")," + //Jeremias 20:11 NTV
            "(238, 4, 24, 31, 3, \"Hace tiempo el Señor le dijo a Israel: 'Yo te he amado, pueblo mío, con un amor eterno. Con amor inagotable te acerqué a mí.\")," + //Jeremias 31:3 NTV
            "(239, 4, 19, 121, 8, \"El Señor te protege al entrar y al salir, ahora y para siempre.\")," +//Salmos 121:8 NTV
            "(240, 4, 58, 6, 14, \"'Ciertamente te bendeciré y multiplicaré tu descendencia hasta que sea incontable.'\")," +//Hebreos 6:14 NTV
            "(241, 4, 39, 3, 10, \"Traigan todos los diezmos al depósito del templo, para que haya suficiente comida en mi casa. Si lo hacen —dice el Señor de los Ejércitos Celestiales— les abriré las ventanas de los cielos. ¡Derramaré una bendición tan grande que no tendrán suficiente espacio para guardarla! ¡Inténtenlo! ¡Pónganme a prueba!\")," +//Malaquias 3:10 NTV
            "(242, 4, 19, 3, 3, \"Pero tú, oh Señor, eres un escudo que me rodea; eres mi gloria, el que sostiene mi cabeza en alto.\")," +//Salmos 3:3 NTV
            "(243, 4, 5, 31, 8, \"No temas ni te desalientes, porque el propio Señor irá delante de ti. Él estará contigo; no te fallará ni te abandonará.\")," +//Deuteronomio 31:8 NTV
            "(244, 4, 42, 11, 10, \"Pues todo el que pide, recibe; todo el que busca, encuentra; y a todo el que llama, se le abrirá la puerta.\")," +//Lucas 11:10 NTV
            "(245, 4, 42, 1, 37, \"Pues nada es imposible para Dios.\")," +//Lucas 1:37 NTV
            "(246, 4, 20, 22, 4, \"La verdadera humildad y el temor del Señor conducen a riquezas, a honor y a una larga vida.\")," +//Proverbios 22:4 NTV
            "(247, 4, 19, 5, 12, \"Pues tú bendices a los justos, oh Señor; los rodeas con tu escudo de amor.\")," +//Salmos 5:12 NTV
            "(248, 4, 19, 1, 3, \"Son como árboles plantados a la orilla de un río, que siempre dan fruto en su tiempo. Sus hojas nunca se marchitan, y prosperan en todo lo que hacen.\")," +//Salmos 1:3 NTV
            "(249, 4, 46, 2, 9, \"A eso se refieren las Escrituras cuando dicen: 'Ningún ojo ha visto, ningún oído ha escuchado, ninguna mente ha imaginado lo que Dios tiene preparado para quienes lo aman.'\")," +//1 Corintios 2:9 NTV
            "(250, 4, 41, 9, 23, \"—¿Cómo que 'si puedo'? —preguntó Jesús—. Todo es posible si uno cree.\")," +//Marcos 9:23 NTV
            "(251, 4, 40, 6, 33, \"Busquen el reino de Dios por encima de todo lo demás y lleven una vida justa, y él les dará todo lo que necesiten.\")," +//Mateo 6:33 NTV
            "(252, 4, 16, 8, 10, \"Nehemías continuó diciendo: 'Vayan y festejen con un banquete de deliciosos alimentos y bebidas dulces, y regalen porciones de comida a los que no tienen nada preparado. Este es un día sagrado delante de nuestro Señor. ¡No se desalienten ni entristezcan, porque el gozo del Señor es su fuerza!'\")," +//Nehemías 8:10 NTV
            "(253, 4, 20, 1, 33, \"En cambio, todos los que me escuchan vivirán en paz, tranquilos y sin temor del mal.\")," +//Proverbios 1:33 NTV
            "(254, 4, 41, 10, 27, \"Jesús los miró fijamente y dijo: '—Humanamente hablando, es imposible, pero no para Dios. Con Dios, todo es posible.'\")," +//Marcos 10:27 NTV
            "(255, 4, 19, 40, 4, \"Ah, qué alegría para los que confían en el Señor, los que no confían en los orgullosos ni en aquellos que rinden culto a ídolos.\")," +//Salmos 40:4 NTV
            "(256, 4, 24, 17, 7, \"Pero benditos son los que confían en el Señor y han hecho que el Señor sea su esperanza y confianza.\")," +//Jeremias 17:7 NTV
            "(257, 4, 20, 16, 20, \"Los que están atentos a la instrucción prosperarán; los que confían en el Señor se llenarán de gozo.\")," +//Proverbios 16:20 NTV
            "(258, 4, 19, 138, 8, \"El Señor llevará a cabo los planes que tiene para mi vida, pues tu fiel amor, oh Señor, permanece para siempre. No me abandones, porque tú me creaste.\")," +//Salmos 138:8 NTV
            "(259, 4, 25, 3, 25, \"El Señor es bueno con los que dependen de él, con aquellos que lo buscan.\")," +//Lamentaciones 3:25 NTV
            "(260, 4, 24, 29, 11, \"Pues yo sé los planes que tengo para ustedes —dice el Señor—. Son planes para lo bueno y no para lo malo, para darles un futuro y una esperanza.\")," +//Jeremias 29:11 NTV
            "(261, 4, 5, 4, 31, \"Pues el Señor su Dios es Dios compasivo; no los abandonará, ni los destruirá, ni se olvidará del pacto solemne que hizo con sus antepasados.\")," +//Deuteronomio 4:31 NTV
            "(262, 4, 43, 15, 7, \"Si ustedes permanecen en mí y mis palabras permanecen en ustedes, pueden pedir lo que quieran, ¡y les será concedido!\")," +//Juan 15:7 NTV
            "(263, 4, 14, 15, 7, \"pero en cuanto a ustedes, sean fuertes y valientes porque su trabajo será recompensado.\")," +//2 Cronicas 15:7 NTV
            "(265, 4, 24, 33, 3, \"pídeme y te daré a conocer secretos sorprendentes que no conoces acerca de lo que está por venir.\")," +//Jeremias 33:3 NTV
            "(266, 4, 47, 5, 17, \"Esto significa que todo el que pertenece a Cristo se ha convertido en una persona nueva. La vida antigua ha pasado, ¡una nueva vida ha comenzado!\")," +//2 Corintios 5:17 NTV
            "(267, 4, 1, 12, 2, \"Haré de ti una gran nación; te bendeciré y te haré famoso, y serás una bendición para otros.\")," +//Genesis 12:2 NTV
            "(268, 4, 23, 40, 29, \"Él da poder a los indefensos y fortaleza a los débiles.\")," +//Isaias 40:29 NTV
            "(269, 4, 44, 16, 31, \"Ellos le contestaron: —Cree en el Señor Jesús y serás salvo, junto con todos los de tu casa.\")," +//Hechos 16:31 NTV
            "(270, 4, 23, 55, 5, \"Tú también darás órdenes a naciones que no conoces, y pueblos desconocidos vendrán corriendo a obedecerte, porque yo, el Señor tu Dios, el Santo de Israel, te hice glorioso\")," +//Isaias 55:5 NTV
            "(271, 4, 50, 4, 19, \"Y este mismo Dios quien me cuida suplirá todo lo que necesiten, de las gloriosas riquezas que nos ha dado por medio de Cristo Jesús.\")," +//Filipenses 4:19 NTV
            "(272, 4, 23, 58, 8, \"Entonces su salvación llegará como el amanecer, y sus heridas sanarán con rapidez; su justicia los guiará hacia adelante y atrás los protegerá la gloria del Señor.\")," +//Isaias 58:8 NTV
            "(273, 4, 34, 1, 7, \"El Señor es bueno, un refugio seguro cuando llegan dificultades. Él está cerca de los que confían en él.\")," +//Nahum 1:7 NTV
            "(274, 4, 53, 3, 3, \"Pero el Señor es fiel; él los fortalecerá y los protegerá del maligno.\")"; //2 Tesalonicenses 3:3 NTV

    public static final String INSERT_VERSICULO_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(275, 5, 19, 46, 1, \"God is our refuge and strength, a very present help in trouble.\")," +//Psalms 46:1 KJV
            "(276, 5, 19, 40, 1, \"I waited patiently for the Lord; and he inclined unto me, and heard my cry.\")," +//Psalms 40:1 KJV
            "(277, 5, 20, 11, 25, \"The liberal soul shall be made fat: and he that watereth shall be watered also himself.\")," +//Proverbs 11:25 KJV
            "(278, 5, 5, 3, 22, \"Ye shall not fear them: for the Lord your God he shall fight for you.\")," +//Deuteronomy 3:22 KJV
            "(279, 5, 19, 32, 8, \"I will instruct thee and teach thee in the way which thou shalt go: I will guide thee with mine eye.\")," +//Psalms 32:8 KJV
            "(280, 5, 6, 1, 7, \"Only be thou strong and very courageous, that thou mayest observe to do according to all the law, which Moses my servant commanded thee: turn not from it to the right hand or to the left, that thou mayest prosper whithersoever thou goest.\")," +//Joshua 1:7 KJV
            "(281, 5, 23, 43, 1, \"But now thus saith the Lord that created thee, O Jacob, and he that formed thee, O Israel, Fear not: for I have redeemed thee, I have called thee by thy name; thou art mine.\")," +//Isaiah 43:1 KJV
            "(282, 5, 19, 50, 15, \"And call upon me in the day of trouble: I will deliver thee, and thou shalt glorify me.\")," +//Psalms 50:15 KJV
            "(283, 5, 47, 6, 18, \"And will be a Father unto you, and ye shall be my sons and daughters, saith the Lord Almighty.\")," +//2 Corinthians 6:18 KJV
            "(284, 5, 19, 23, 1, \"The Lord is my shepherd; I shall not want.\")," +//Psalms 23:1 KJV
            "(285, 5, 23, 58, 9, \"Then shalt thou call, and the Lord shall answer; thou shalt cry, and he shall say, Here I am. If thou take away from the midst of thee the yoke, the putting forth of the finger, and speaking vanity.\")," +//Isaiah 58:9 KJV
            "(286, 5, 23, 58, 11, \"And the Lord shall guide thee continually, and satisfy thy soul in drought, and make fat thy bones: and thou shalt be like a watered garden, and like a spring of water, whose waters fail not.\")," +//Isaiah 58:11 KJV
            "(164, 5, 23, 58, 8, \"Then shall thy light break forth as the morning, and thine health shall spring forth speedily: and thy righteousness shall go before thee; the glory of the Lord shall be thy rearward.\")," +//Isaiah 58:8 KJV
            "(165, 5, 23, 40, 29, \"He giveth power to the faint; and to them that have no might he increaseth strength.\")," +//Isaiah 40:29 KJV
            "(166, 5, 23, 44, 3, \"For I will pour water upon him that is thirsty, and floods upon the dry ground: I will pour my spirit upon thy seed, and my blessing upon thine offspring.\")," +//Isaiah 44:3 KJV
            "(264, 5, 23, 41, 10, \"Fear thou not; for I am with thee: be not dismayed; for I am thy God: I will strengthen thee; yea, I will help thee; yea, I will uphold thee with the right hand of my righteousness.\")," +//Isaiah 41:10 KJV
            "(287, 5, 23, 55, 5, \"Behold, thou shalt call a nation that thou knowest not, and nations that knew not thee shall run unto thee because of the Lord thy God, and for the Holy One of Israel; for he hath glorified thee.\")," +//Isaiah 55:5 KJV
            "(288, 5, 45, 8, 28, \"And we know that all things work together for good to them that love God, to them who are the called according to his purpose.\")," +//Romans 8:28 KJV
            "(289, 5, 19, 3, 3, \"But thou, O Lord, art a shield for me; my glory, and the lifter up of mine head.\")," +//Psalms 3:3 KJV
            "(290, 5, 19, 5, 12, \"For thou, Lord, wilt bless the righteous; with favour wilt thou compass him as with a shield.\")," +//Psalms 5:12 KJV
            "(291, 5, 19, 1, 3, \"And he shall be like a tree planted by the rivers of water, that bringeth forth his fruit in his season; his leaf also shall not wither; and whatsoever he doeth shall prosper.\")," +//Psalms 1:3 KJV
            "(292, 5, 19, 62, 6, \"He only is my rock and my salvation: he is my defence; I shall not be moved.\")," +//Psalms 62:6 KJV
            "(293, 5, 19, 68, 19, \"Blessed be the Lord, who daily loadeth us with benefits, even the God of our salvation. Selah.\")," +//Psalms 68:19 KJV
            "(294, 5, 19, 37, 4, \"Delight thyself also in the Lord; and he shall give thee the desires of thine heart.\")," +//Psalms 37:4 KJV
            "(295, 5, 19, 37, 5, \"Commit thy way unto the Lord; trust also in him; and he shall bring it to pass.\")," +//Psalms 37:5 KJV
            "(296, 5, 19, 138, 8, \"The Lord will perfect that which concerneth me: thy mercy, O Lord, endureth for ever: forsake not the works of thine own hands.\")," +//Psalms 138:8 KJV
            "(297, 5, 19, 121, 8, \"The Lord shall preserve thy going out and thy coming in from this time forth, and even for evermore.\")," +//Psalms 121:8 KJV
            "(298, 5, 19, 40, 4, \"Blessed is that man that maketh the Lord his trust, and respecteth not the proud, nor such as turn aside to lies.\")," +//Psalms 40:4 KJV
            "(299, 5, 40, 28, 20, \"Teaching them to observe all things whatsoever I have commanded you: and, lo, I am with you alway, even unto the end of the world. Amen.\")," +//Matthew 28:20 KJV
            "(300, 5, 2, 14, 14, \"The Lord shall fight for you, and ye shall hold your peace.\")," +//Exodus 14:14 KJV
            "(301, 5, 2, 33, 14, \"And he said, My presence shall go with thee, and I will give thee rest.\")," +//Exodus 33:14 KJV
            "(302, 5, 1, 28, 15, \"And, behold, I am with thee, and will keep thee in all places whither thou goest, and will bring thee again into this land; for I will not leave thee, until I have done that which I have spoken to thee of.\")," +//Genesis 28:15 KJV
            "(303, 5, 1, 12, 2, \"And I will make of thee a great nation, and I will bless thee, and make thy name great; and thou shalt be a blessing.\")," +//Genesis 12:2 KJV
            "(304, 5, 20, 16, 3, \"Commit thy works unto the Lord, and thy thoughts shall be established.\")," +//Proverbs 16:3 KJV
            "(305, 5, 20, 18, 10, \"The name of the Lord is a strong tower: the righteous runneth into it, and is safe.\")," +//Proverbs 18:10 KJV
            "(306, 5, 20, 22, 4, \"By humility and the fear of the Lord are riches, and honour, and life.\")," +//Proverbs 22:4 KJV
            "(307, 5, 20, 1, 33, \"But whoso hearkeneth unto me shall dwell safely, and shall be quiet from fear of evil.\")," +//Proverbs 1:33 KJV
            "(308, 5, 20, 16, 20, \"He that handleth a matter wisely shall find good: and whoso trusteth in the Lord, happy is he.\")," +//Proverbs 16:20 KJV
            "(309, 5, 5, 15, 10, \"Thou shalt surely give him, and thine heart shall not be grieved when thou givest unto him: because that for this thing the Lord thy God shall bless thee in all thy works, and in all that thou puttest thine hand unto.\")," +//Deuteronomy 15:10 KJV
            "(310, 5, 5, 31, 8, \"And the Lord, he it is that doth go before thee; he will be with thee, he will not fail thee, neither forsake thee: fear not, neither be dismayed.\")," +//Deuteronomy 31:8 KJV
            "(311, 5, 5, 28, 12, \"The Lord shall open unto thee his good treasure, the heaven to give the rain unto thy land in his season, and to bless all the work of thine hand: and thou shalt lend unto many nations, and thou shalt not borrow.\")," +//Deuteronomy 28:12 KJV
            "(312, 5, 5, 4, 31, \"(For the Lord thy God is a merciful God;) he will not forsake thee, neither destroy thee, nor forget the covenant of thy fathers which he sware unto them.\")," +//Deuteronomy 4:31 KJV
            "(313, 5, 24, 20, 11, \"But the Lord is with me as a mighty terrible one: therefore my persecutors shall stumble, and they shall not prevail: they shall be greatly ashamed; for they shall not prosper: their everlasting confusion shall never be forgotten.\")," +//Jeremiah 20:11 KJV
            "(314, 5, 24, 31, 3, \"The Lord hath appeared of old unto me, saying, Yea, I have loved thee with an everlasting love: therefore with loving kindness have I drawn thee.\")," +//Jeremiah 31:3 KJV
            "(315, 5, 24, 17, 7, \"Blessed is the man that trusteth in the Lord, and whose hope the Lord is.\")," +//Jeremiah 17:7 KJV
            "(316, 5, 24, 29, 11, \"For I know the thoughts that I think toward you, saith the Lord, thoughts of peace, and not of evil, to give you an expected end.\")," +//Jeremiah 29:11 KJV
            "(317, 5, 24, 33, 3, \"Call unto me, and I will answer thee, and shew thee great and mighty things, which thou knowest not.\")," +//Jeremiah 33:3 KJV
            "(318, 5, 40, 6, 33, \"But seek ye first the kingdom of God, and his righteousness; and all these things shall be added unto you.\")," +//Matthew 6:33 KJV
            "(319, 5, 40, 11, 28, \"Come unto me, all ye that labour and are heavy laden, and I will give you rest.\")," +//Matthew 11:28 KJV
            "(320, 5, 18, 8, 7, \"Though thy beginning was small, yet thy latter end should greatly increase.\")," +//Job 8:7 KJV
            "(321, 5, 26, 34, 26, \"And I will make them and the places round about my hill a blessing; and I will cause the shower to come down in his season; there shall be showers of blessing.\")," +//Ezekiel 34:26 KJV
            "(322, 5, 50, 4, 13, \"I can do all things through Christ which strengtheneth me.\")," +//Philippians 4:13 KJV
            "(323, 5, 50, 4, 19, \"But my God shall supply all your need according to his riches in glory by Christ Jesus.\")," +//Philippians 4:19 KJV
            "(324, 5, 58, 6, 14, \"Saying, Surely blessing I will bless thee, and multiplying I will multiply thee.\")," +//Hebrews 6:14 KJV
            "(325, 5, 39, 3, 10, \"Bring ye all the tithes into the storehouse, that there may be meat in mine house, and prove me now herewith, saith the Lord of hosts, if I will not open you the windows of heaven, and pour you out a blessing, that there shall not be room enough to receive it.\")," +//Malachi 3:10 KJV
            "(326, 5, 42, 11, 10, \"For every one that asketh receiveth; and he that seeketh findeth; and to him that knocketh it shall be opened.\")," +//Luke 11:10 KJV
            "(327, 5, 42, 1, 37, \"For with God nothing shall be impossible.\")," +//Luke 1:37 KJV
            "(328, 5, 47, 5, 17, \"Therefore if any man be in Christ, he is a new creature: old things are passed away; behold, all things are become new.\")," +//2 Corinthians 5:17 KJV
            "(329, 5, 46, 2, 9, \"But as it is written, Eye hath not seen, nor ear heard, neither have entered into the heart of man, the things which God hath prepared for them that love him.\")," +//1 Corinthians 2:9 KJV
            "(330, 5, 41, 9, 23, \"Jesus said unto him, If thou canst believe, all things are possible to him that believeth.\")," +//Mark 9:23 KJV
            "(331, 5, 41, 10, 27, \"Jesus said unto him, If thou canst believe, all things are possible to him that believeth.And Jesus looking upon them saith, With men it is impossible, but not with God: for with God all things are possible.\")," +//Mark 10:27 KJV
            "(332, 5, 25, 3, 25, \"The Lord is good unto them that wait for him, to the soul that seeketh him.\")," +//Lamentations 3:25 KJV
            "(333, 5, 43, 15, 7, \"If ye abide in me, and my words abide in you, ye shall ask what ye will, and it shall be done unto you.\")," +//John 15:7 KJV
            "(334, 5, 14, 15, 7, \"Be ye strong therefore, and let not your hands be weak: for your work shall be rewarded.\")," +//2 Chronicles 15:7 KJV
            "(335, 5, 44, 16, 31, \"And they said, Believe on the Lord Jesus Christ, and thou shalt be saved, and thy house.\")," +//Acts 16:31 KJV
            "(336, 5, 16, 8, 10, \"Then he said unto them, Go your way, eat the fat, and drink the sweet, and send portions unto them for whom nothing is prepared: for this day is holy unto our Lord: neither be ye sorry; for the joy of the Lord is your strength.\")," +//Nehemiah 8:10 KJV
            "(337, 5, 34, 1, 7, \"The Lord is good, a strong hold in the day of trouble; and he knoweth them that trust in him.\")," +//Nahum 1:7 KJV
            "(338, 5, 53, 3, 3, \"But the Lord is faithful, who shall stablish you, and keep you from evil.\")," +//2 Thessalonians 3:3 KJV
            "(339, 5, 4, 6, 24, \"The Lord bless thee, and keep thee.\")"; //Numbers 6:24 NTV

    //Scripts de inserción de la tabla Promesa
    public static final String INSERT_PROMESA_RVR60_SCRIPT =
        "insert into " + PROMESA_TABLE_NAME + " values" +
            "(1, 1)," + //Salmos 46:1 RVR60
            "(4, 4)," + //Salmos 40:1 RVR60
            "(7, 7)," + //Proverbios 11:25 RVR60
            "(10, 10)," + //Deuteronomio 3:22 RVR60
            "(12, 12)," + //Salmos 32:8 RVR60
            "(15, 15)," + //Josue 1:7 RVR60
            "(18, 18)," + //Isaias 43:1 RVR60
            "(21, 21)," + //Salmos 50:15 RVR60
            "(24, 24)," + //2 Corintios 6:18 RVR60
            "(27, 27)," + //Salmos 23:1 RVR60
            "(30, 30)," + //Isaias 58:9 RVR60
            "(33, 33)," + //Isaias 58:11 RVR60
            "(36, 36)," + //Salmos 62:6 RVR60
            "(39, 39)," + //Romanos 8:28 RVR60
            "(42, 42)," + //Salmos 68:19 RVR60
            "(45, 45)," + //Mateo 28:20 RVR60
            "(48, 48)," + //Exodo 14:14 RVR60
            "(50, 50)," + //Exodo 33:14 RVR60
            "(53, 53)," + //Genesis 28:15 RVR60
            "(56, 56)," + //Proverbios 16:3 RVR60
            "(59, 59)," + //Salmos 37:4 RVR60
            "(62, 62)," + //Isaias 41:10 RVR60
            "(65, 65)," + //Proverbios 18:10 RVR60
            "(68, 68)," + //Salmos 37:5 RVR60
            "(71, 71)," + //Job 8:7 RVR60
            "(74, 74)," + //Ezequiel 34:26 RVR60
            "(77, 77)," + //Deuteronomio 15:10 RVR60
            "(80, 80)," + //Filipenses 4:13 RVR60
            "(83, 83)," + //Isaias 44:3 RVR60
            "(86, 86)," + //Jeremias 20:11 RVR60
            "(88, 88)," + //Jeremias 31:3 RVR60
            "(90, 90)," + //Salmos 121:8 RVR60
            "(93, 93)," + //Hebreos 6:14 RVR60
            "(95, 95)," + //Malaquias 3:10 RVR60
            "(98, 98)," + //Salmos 3:3 RVR60
            "(101, 101)," + //Deuteronomio 31:8 RVR60
            "(104, 104)," + //Lucas 11:10 RVR60
            "(107, 107)," + //Lucas 1:37 RVR60
            "(110, 110)," + //Proverbios 22:4 RVR60
            "(113, 113)," + //Salmos 5:12 RVR60
            "(116, 116)," + //Salmos 1:3 RVR60
            "(119, 119)," + //1 Corintios 2:9 RVR60
            "(122, 122)," + //Marcos 9:23 RVR60
            "(125, 125)," + //Mateo 6:33 RVR60
            "(128, 128)," + //Nehemías 8:10 RVR60
            "(131, 131)," + //Proverbios 1:33 RVR60
            "(134, 134)," + //Marcos 10:27 RVR60
            "(137, 137)," + //Salmos 40:4 RVR60
            "(140, 140)," + //Jeremias 17:7 RVR60
            "(143, 143)," + //Proverbios 16:20 RVR60
            "(146, 146)," + //Salmos 138:8 RVR60
            "(149, 149)," + //Lamentaciones 3:25 RVR60
            "(152, 152)," + //Jeremias 29:11 RVR60
            "(155, 155)," + //Deuteronomio 4:31 RVR60
            "(158, 158)," + //Juan 15:7 RVR60
            "(161, 161)," + //2 Cronicas 15:7 RVR60
            "(167, 167)," + //Jeremias 33:3 RVR60
            "(170, 170)," + //2 Corintios 5:17 RVR60
            "(172, 172)," + //Genesis 12:2 RVR60
            "(175, 175)," + //Isaias 40:29 RVR60
            "(178, 178)," + //Hechos 16:31 RVR60
            "(181, 181)," + //Isaias 55:5 RVR60
            "(184, 184)," + //Filipenses 4:19 RVR60
            "(187, 187)," + //Isaias 58:8 RVR60
            "(190, 190)," + //Nahum 1:7 RVR60
            "(193, 193)," + //2 Tesalonicenses 3:3 RVR60
            "(199, 199)," + //Mateo 11:28 RVR60
            "(202, 202)," + //Numeros 6:24 RVR60
            "(205, 205)" ; //Deuteronomio 28:12 RVR60

    public static final String INSERT_PROMESA_NVI_SCRIPT =
        "insert into " + PROMESA_TABLE_NAME + " values" +
            "(2, 2)," + //Salmos 46:1 NVI
            "(5, 5)," + //Salmos 40:1 NVI
            "(8, 8)," + //Proverbios 11:25 NVI
            "(11, 11)," + //Deuteronomio 3:22 NVI
            "(13, 13)," + //Salmos 32:8 NVI
            "(16, 16)," + //Josue 1:7 NVI
            "(19, 19)," + //Isaias 43:1 NVI
            "(22, 22)," + //Salmos 50:15 NVI
            "(25, 25)," + //2 Corintios 6:18 NVI
            "(28, 28)," + //Salmos 23:1 NVI
            "(31, 31)," + //Isaias 58:9 NVI
            "(34, 34)," + //Isaias 58:11 NVI
            "(37, 37)," + //Salmos 62:6 NVI
            "(40, 40)," + //Romanos 8:28 NVI
            "(43, 43)," + //Salmos 68:19 NVI
            "(46, 46)," + //Mateo 28:20 NVI
            "(49, 49)," + //Exodo 14:14 NVI
            "(51, 51)," + //Exodo 33:14 NVI
            "(54, 54)," + //Genesis 28:15 NVI
            "(57, 57)," + //Proverbios 16:3 NVI
            "(60, 60)," + //Salmos 37:4 NVI
            "(63, 63)," + //Isaias 41:10 NVI
            "(66, 66)," + //Proverbios 18:10 NVI
            "(69, 69)," + //Salmos 37:5 NVI
            "(72, 72)," + //Job 8:7 NVI
            "(75, 75)," + //Ezequiel 34:26 NVI
            "(78, 78)," + //Deuteronomio 15:10 NVI
            "(81, 81)," + //Filipenses 4:13 NVI
            "(84, 84)," + //Isaias 44:3 NVI
            "(87, 87)," + //Jeremias 20:11 NVI
            "(89, 89)," + //Jeremias 31:3 NVI
            "(91, 91)," + //Salmos 121:8 NVI
            "(94, 94)," + //Hebreos 6:14 NVI
            "(96, 96)," + //Malaquias 3:10 NVI
            "(99, 99)," + //Salmos 3:3 NVI
            "(102, 102)," + //Deuteronomio 31:8 NVI
            "(105, 105)," + //Lucas 11:10 NVI
            "(108, 108)," + //Lucas 1:37 NVI
            "(111, 111)," + //Proverbios 22:4 NVI
            "(114, 114)," + //Salmos 5:12 NVI
            "(117, 117)," + //Salmos 1:3 NVI
            "(120, 120)," + //1 Corintios 2:9 NVI
            "(123, 123)," + //Marcos 9:23 NVI
            "(126, 126)," + //Mateo 6:33 NVI
            "(129, 129)," + //Nehemías 8:10 NVI
            "(132, 132)," + //Proverbios 1:33 NVI
            "(135, 135)," + //Marcos 10:27 NVI
            "(138, 138)," + //Salmos 40:4 NVI
            "(141, 141)," + //Jeremias 17:7 NVI
            "(144, 144)," + //Proverbios 16:20 NVI
            "(147, 147)," + //Salmos 138:8 NVI
            "(150, 150)," + //Lamentaciones 3:25 NVI
            "(153, 153)," + //Jeremias 29:11 NVI
            "(156, 156)," + //Deuteronomio 4:31 NVI
            "(159, 159)," + //Juan 15:7 NVI
            "(162, 162)," + //2 Cronicas 15:7 NVI
            "(168, 168)," + //Jeremias 33:3 NVI
            "(171, 171)," + //2 Corintios 5:17 NVI
            "(173, 173)," + //Genesis 12:2 NVI
            "(176, 176)," + //Isaias 40:29 NVI
            "(179, 179)," + //Hechos 16:31 NVI
            "(182, 182)," + //Isaias 55:5 NVI
            "(185, 185)," + //Filipenses 4:19 NVI
            "(188, 188)," + //Isaias 58:8 NVI
            "(191, 191)," + //Nahum 1:7 NVI
            "(194, 194)," + //2 Tesalonicenses 3:3 NVI
            "(200, 200)," + //Mateo 11:28 NVI
            "(203, 203)," + //Numeros 6:24 NVI
            "(206, 206)"; //Deuteronomio 28:12 NVI

    public static final String INSERT_PROMESA_TLA_SCRIPT =
        "insert into " + PROMESA_TABLE_NAME + " values" +
            "(3, 3)," + //Salmos 46:1 TLA
            "(6, 6)," + //Salmos 40:1 TLA
            "(9, 9)," + //Proverbios 11:25 TLA
            "(14, 14)," + //Salmos 32:8 TLA
            "(17, 17)," + //Josue 1:7 TLA
            "(20, 20)," + //Isaias 43:1 TLA
            "(23, 23)," + //Salmos 50:15 TLA
            "(26, 26)," + //2 Corintios 6:18 TLA
            "(29, 29)," + //Salmos 23:1 TLA
            "(32, 32)," + //Isaias 58:9 TLA
            "(35, 35)," + //Isaias 58:11 TLA
            "(38, 38)," + //Salmos 62:6 TLA
            "(41, 41)," + //Romanos 8:28 TLA
            "(44, 44)," + //Salmos 68:19 TLA
            "(47, 47)," + //Mateo 28:20 TLA
            "(52, 52)," + //Exodo 33:14 TLA
            "(55, 55)," + //Genesis 28:15 TLA
            "(58, 58)," + //Proverbios 16:3 TLA
            "(61, 61)," + //Salmos 37:4 TLA
            "(64, 64)," + //Isaias 41:10 TLA
            "(67, 67)," + //Proverbios 18:10 TLA
            "(70, 70)," + //Salmos 37:5 TLA
            "(73, 73)," + //Job 8:7 TLA
            "(76, 76)," + //Ezequiel 34:26 TLA
            "(79, 79)," + //Deuteronomio 15:10 TLA
            "(82, 82)," + //Filipenses 4:13 TLA
            "(85, 85)," + //Isaias 44:3 TLA
            "(92, 92)," + //Salmos 121:8 TLA
            "(97, 97)," + //Malaquias 3:10 TLA
            "(100, 100)," + //Salmos 3:3 TLA
            "(103, 103)," + //Deuteronomio 31:8 TLA
            "(106, 106)," + //Lucas 11:10 TLA
            "(109, 109)," + //Lucas 1:37 TLA
            "(112, 112)," + //Proverbios 22:4 TLA
            "(115, 115)," + //Salmos 5:12 TLA
            "(118, 118)," + //Salmos 1:3 TLA
            "(121, 121)," + //1 Corintios 2:9 TLA
            "(124, 124)," + //Marcos 9:23 TLA
            "(127, 127)," + //Mateo 6:33 TLA
            "(130, 130)," + //Nehemías 8:10 TLA
            "(133, 133)," + //Proverbios 1:33 TLA
            "(136, 136)," + //Marcos 10:27 TLA
            "(139, 139)," + //Salmos 40:4 TLA
            "(142, 142)," + //Jeremias 17:7 TLA
            "(145, 145)," + //Proverbios 16:20 TLA
            "(148, 148)," + //Salmos 138:8 TLA
            "(151, 151)," + //Lamentaciones 3:25 TLA
            "(154, 154)," + //Jeremias 29:11 TLA
            "(157, 157)," + //Deuteronomio 4:31 TLA
            "(160, 160)," + //Juan 15:7 TLA
            "(163, 163)," + //2 Cronicas 15:7 TLA
            "(169, 169)," + //Jeremias 33:3 TLA
            "(174, 174)," + //Genesis 12:2 TLA
            "(177, 177)," + //Isaias 40:29 TLA
            "(180, 180)," + //Hechos 16:31 TLA
            "(183, 183)," + //Isaias 55:5 TLA
            "(186, 186)," + //Filipenses 4:19 TLA
            "(189, 189)," + //Isaias 58:8 TLA
            "(192, 192)," + //Nahum 1:7 TLA
            "(195, 195)," + //2 Tesalonicenses 3:3 TLA
            "(201, 201)," + //Mateo 11:28 TLA
            "(204, 204)," + //Numeros 6:24 TLA
            "(207, 207)" ; //Deuteronomio 28:12 TLA

    public static final String INSERT_PROMESA_NTV_SCRIPT =
        "insert into " + PROMESA_TABLE_NAME + " values" +
            "(196, 196)," + //Mateo 11:28 NTV
            "(197, 197)," + //Numeros 6:24 NTV
            "(198, 198)," + //Deuteronomio 28:12 NTV
            "(208, 208)," + //Salmos 46:1 NTV
            "(209, 209)," + //Salmos 40:1 NTV
            "(210, 210)," + //Proverbios 11:25 NTV
            "(211, 211)," + //Deuteronomio 3:22 NTV
            "(212, 212)," + //Salmos 32:8 NTV
            "(213, 213)," + //Josue 1:7 NTV
            "(214, 214)," + //Isaias 43:1 NTV
            "(215, 215)," + //Salmos 50:15 NTV
            "(216, 216)," + //2 Corintios 6:18 NTV
            "(217, 217)," + //Salmos 23:1 NTV
            "(218, 218)," + //Isaias 58:9 NTV
            "(219, 219)," + //Isaias 58:11 NTV
            "(220, 220)," + //Salmos 62:6 NTV
            "(221, 221)," + //Romanos 8:28 NTV
            "(222, 222)," + //Salmos 68:19 NTV
            "(223, 223)," + //Mateo 28:20 NTV
            "(224, 224)," + //Exodo 14:14 NTV
            "(225, 225)," + //Exodo 33:14 NTV
            "(226, 226)," + //Genesis 28:15 NTV
            "(227, 227)," + //Proverbios 16:3 NTV
            "(228, 228)," + //Salmos 37:4 NTV
            "(229, 229)," + //Isaias 41:10 NTV
            "(230, 230)," + //Proverbios 18:10 NTV
            "(231, 231)," + //Salmos 37:5 NTV
            "(232, 232)," + //Job 8:7 NTV
            "(233, 233)," + //Ezequiel 34:26 NTV
            "(234, 234)," + //Deuteronomio 15:10 NTV
            "(235, 235)," + //Filipenses 4:13 NTV
            "(236, 236)," + //Isaias 44:3 NTV
            "(237, 237)," + //Jeremias 20:11 NTV
            "(238, 238)," + //Jeremias 31:3 NTV
            "(239, 239)," + //Salmos 121:8 NTV
            "(240, 240)," + //Hebreos 6:14 NTV
            "(241, 241)," + //Malaquias 3:10 NTV
            "(242, 242)," + //Salmos 3:3 NTV
            "(243, 243)," + //Deuteronomio 31:8 NTV
            "(244, 244)," + //Lucas 11:10 NTV
            "(245, 245)," + //Lucas 1:37 NTV
            "(246, 246)," + //Proverbios 22:4 NTV
            "(247, 247)," + //Salmos 5:12 NTV
            "(248, 248)," + //Salmos 1:3 NTV
            "(249, 249)," + //1 Corintios 2:9 NTV
            "(250, 250)," + //Marcos 9:23 NTV
            "(251, 251)," + //Mateo 6:33 NTV
            "(252, 252)," + //Nehemías 8:10 NTV
            "(253, 253)," + //Proverbios 1:33 NTV
            "(254, 254)," + //Marcos 10:27 NTV
            "(255, 255)," + //Salmos 40:4 NTV
            "(256, 256)," + //Jeremias 17:7 NTV
            "(257, 257)," + //Proverbios 16:20 NTV
            "(258, 258)," + //Salmos 138:8 NTV
            "(259, 259)," + //Lamentaciones 3:25 NTV
            "(260, 260)," + //Jeremias 29:11 NTV
            "(261, 261)," + //Deuteronomio 4:31 NTV
            "(262, 262)," + //Juan 15:7 NTV
            "(263, 263)," + //2 Cronicas 15:7 NTV
            "(265, 265)," + //Jeremias 33:3 NTV
            "(266, 266)," + //2 Corintios 5:17 NTV
            "(267, 267)," + //Genesis 12:2 NTV
            "(268, 268)," + //Isaias 40:29 NTV
            "(269, 269)," + //Hechos 16:31 NTV
            "(270, 270)," + //Isaias 55:5 NTV
            "(271, 271)," + //Filipenses 4:19 NTV
            "(272, 272)," + //Isaias 58:8 NTV
            "(273, 273)," + //Nahum 1:7 NTV
            "(274, 274)"; //2 Tesalonicenses 3:3 NTV

    public static final String INSERT_PROMESA_KJV_SCRIPT =
        "insert into " + PROMESA_TABLE_NAME + " values" +
            "(275, 275)," + //Psalms 46:1 KJV
            "(276, 276)," + //Psalms 40:1 KJV
            "(277, 277)," + //Proverbs 11:25 KJV
            "(278, 278)," + //Deuteronomy 3:22 KJV
            "(279, 279)," + //Psalms 32:8 KJV
            "(280, 280)," + //Joshua 1:7 KJV
            "(281, 281)," + //Isaiah 43:1 KJV
            "(282, 282)," + //Psalms 50:15 KJV
            "(283, 283)," + //2 Corinthians 6:18 KJV
            "(284, 284)," + //Psalms 23:1 KJV
            "(285, 285)," + //Isaiah 58:9 KJV
            "(286, 286)," + //Isaiah 58:11 KJV
            "(164, 164)," + //Isaiah 58:8 KJV
            "(165, 165)," + //Isaiah 40:29 KJV
            "(166, 166)," + //Isaiah 44:3 KJV
            "(264, 264)," + //Isaiah 41:10 KJV
            "(287, 287)," + //Isaiah 55:5 KJV
            "(288, 288)," + //Romans 8:28 KJV
            "(289, 289)," + //Psalms 3:3 KJV
            "(290, 290)," + //Psalms 5:12 KJV
            "(291, 291)," + //Psalms 1:3 KJV
            "(292, 292)," + //Psalms 62:6 KJV
            "(293, 293)," + //Psalms 68:19 KJV
            "(294, 294)," + //Psalms 37:4 KJV
            "(295, 295)," + //Psalms 37:5 KJV
            "(296, 296)," + //Psalms 138:8 KJV
            "(297, 297)," + //Psalms 121:8 KJV
            "(298, 298)," + //Psalms 40:4 KJV
            "(299, 299)," + //Matthew 28:20 KJV
            "(300, 300)," + //Exodus 14:14 KJV
            "(301, 301)," + //Exodus 33:14 KJV
            "(302, 302)," + //Genesis 28:15 KJV
            "(303, 303)," + //Genesis 12:2 KJV
            "(304, 304)," + //Proverbs 16:3 KJV
            "(305, 305)," + //Proverbs 18:10 KJV
            "(306, 306)," + //Proverbs 22:4 KJV
            "(307, 307)," + //Proverbs 1:33 KJV
            "(308, 308)," + //Proverbs 16:20 KJV
            "(309, 309)," + //Deuteronomy 15:10 KJV
            "(310, 310)," + //Deuteronomy 31:8 KJV
            "(311, 311)," + //Deuteronomy 28:12 KJV
            "(312, 312)," + //Deuteronomy 4:31 KJV
            "(313, 313)," + //Jeremiah 20:11 KJV
            "(314, 314)," + //Jeremiah 31:3 KJV
            "(315, 315)," + //Jeremiah 17:7 KJV
            "(316, 316)," + //Jeremiah 29:11 KJV
            "(317, 317)," + //Jeremiah 33:3 KJV
            "(318, 318)," + //Matthew 6:33 KJV
            "(319, 319)," + //Matthew 11:28 KJV
            "(320, 320)," + //Job 8:7 KJV
            "(321, 321)," + //Ezekiel 34:26 KJV
            "(322, 322)," + //Philippians 4:13 KJV
            "(323, 323)," + //Philippians 4:19 KJV
            "(324, 324)," + //Hebrews 6:14 KJV
            "(325, 325)," + //Malachi 3:10 KJV
            "(326, 326)," + //Luke 11:10 KJV
            "(327, 327)," + //Luke 1:37 KJV
            "(328, 328)," + //2 Corinthians 5:17 KJV
            "(329, 329)," + //1 Corinthians 2:9 KJV
            "(330, 330)," + //Mark 9:23 KJV
            "(331, 331)," + //Mark 10:27 KJV
            "(332, 332)," + //Lamentations 3:25 KJV
            "(333, 333)," + //John 15:7 KJV
            "(334, 334)," + //2 Chronicles 15:7 KJV
            "(335, 335)," + //Acts 16:31 KJV
            "(336, 336)," + //Nehemiah 8:10 KJV
            "(337, 337)," + //Nahum 1:7 KJV
            "(338, 338)," + //2 Thessalonians 3:3 KJV
            "(339, 339)"; //Numbers 6:24 KJV

    //Scripts de inserción de la tabla Tema
    public static final String INSERT_TEMA_SCRIPT =
        "insert into " + TEMA_TABLE_NAME + " values" +
            "(null, \"Amor\")," +
            "(null, \"Arrepentimiento\")," +
            "(null, \"Paciencia\")," +
            "(null, \"Perdón\")," +
            "(null, \"Humildad\")," +
            "(null, \"Sabiduría\")";

    public static final String INSERT_VERSICULO_TEMA_AMOR_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(340, 1, 62, 2, 15, \"No améis al mundo, ni las cosas que están en el mundo. Si alguno ama al mundo, el amor del Padre no está en él.\")," + //1 Juan 2:15 RVR60
            "(341, 1, 62, 3, 1, \"Mirad cuál amor nos ha dado el Padre, para que seamos llamados hijos de Dios; por esto el mundo no nos conoce, porque no le conoció a él.\")," + //1 Juan 3:1 RVR60
            "(342, 1, 62, 3, 11, \"Porque éste es el mensaje que habéis oído desde el principio: Que nos amemos unos a otros.\")," + //1 Juan 3:11 RVR60
            "(343, 1, 62, 3, 16, \"En esto hemos conocido el amor, en que él puso su vida por nosotros; también nosotros debemos poner nuestras vidas por los hermanos.\")," + //1 Juan 3:16 RVR60
            "(344, 1, 62, 4, 7, \"Amados, amémonos unos a otros; porque el amor es de Dios. Todo aquel que ama, es nacido de Dios, y conoce a Dios.\")," + //1 Juan 4:7 RVR60
            "(345, 1, 62, 4, 8, \"El que no ama, no ha conocido a Dios; porque Dios es amor.\")," + //1 Juan 4:8 RVR60
            "(346, 1, 62, 4, 9, \"En esto se mostró el amor de Dios para con nosotros, en que Dios envió a su Hijo unigénito al mundo, para que vivamos por él.\")," + //1 Juan 4:9 RVR60
            "(347, 1, 62, 4, 10, \"En esto consiste el amor: no en que nosotros hayamos amado a Dios, sino en que él nos amó a nosotros, y envió a su Hijo en propiciación por nuestros pecados.\")," + //1 Juan 4:10 RVR60
            "(348, 1, 62, 4, 11, \"Amados, si Dios nos ha amado así, debemos también nosotros amarnos unos a otros.\")," + //1 Juan 4:11 RVR60
            "(349, 1, 62, 4, 12, \"Nadie ha visto jamás a Dios. Si nos amamos unos a otros, Dios permanece en nosotros, y su amor se ha perfeccionado en nosotros.\")," + //1 Juan 4:12 RVR60
            "(350, 1, 62, 4, 16, \"Y nosotros hemos conocido y creído el amor que Dios tiene para con nosotros. Dios es amor; y el que permanece en amor, permanece en Dios, y Dios en él.\")," + //1 Juan 4:16 RVR60
            "(351, 1, 62, 4, 18, \"En el amor no hay temor, sino que el perfecto amor echa fuera el temor; porque el temor lleva en sí castigo. De donde el que teme, no ha sido perfeccionado en el amor.\")," + //1 Juan 4:18 RVR60
            "(352, 1, 62, 4, 19, \"Nosotros le amamos a él, porque él nos amó primero.\")," + //1 Juan 4:19 RVR60
            "(353, 1, 62, 4, 20, \"Si alguno dice: Yo amo a Dios, y aborrece a su hermano, es mentiroso. Pues el que no ama a su hermano a quien ha visto, ¿cómo puede amar a Dios a quien no ha visto?\")," + //1 Juan 4:20 RVR60
            "(354, 1, 62, 4, 21, \"Y nosotros tenemos este mandamiento de él: El que ama a Dios, ame también a su hermano.\")," + //1 Juan 4:21 RVR60
            "(355, 1, 19, 33, 5, \"Él ama justicia y juicio; De la misericordia de Jehová está llena la tierra.\")," + //Salmos 33:5 RVR60
            "(356, 1, 19, 116, 1, \"Amo a Jehová, pues ha oído mi voz y mis súplicas.\")," + //Salmos 116:1 RVR60
            "(357, 1, 20, 3, 12, \"Porque Jehová al que ama castiga, como el padre al hijo a quien quiere.\")," + //Proverbios 3:12 RVR60
            "(358, 1, 20, 10, 12, \"El odio despierta rencillas; Pero el amor cubrirá todas las faltas.\")," + //Proverbios 10:12 RVR60
            "(359, 1, 46, 2, 9, \"Antes bien, como está escrito: Cosas que ojo no vio, ni oído oyó, Ni han subido en corazón de hombre, Son las que Dios ha preparado para los que le aman.\")," + //1 Corintios 2:9 RVR60
            "(360, 1, 46, 13, 1, \"Si yo hablase lenguas humanas y angélicas, y no tengo amor, vengo a ser como metal que resuena, o címbalo que retiñe.\")," + //1 Corintios 13:1 RVR60
            "(361, 1, 46, 13, 2, \"Y si tuviese profecía, y entendiese todos los misterios y toda ciencia, y si tuviese toda la fe, de tal manera que trasladase los montes, y no tengo amor, nada soy.\")," + //1 Corintios 13:2 RVR60
            "(362, 1, 46, 13, 3, \"Y si repartiese todos mis bienes para dar de comer a los pobres, y si entregase mi cuerpo para ser quemado, y no tengo amor, de nada me sirve.\")," + //1 Corintios 13:3 RVR60
            "(363, 1, 46, 13, 4, \"El amor es sufrido, es benigno; el amor no tiene envidia, el amor no es jactancioso, no se envanece; no hace nada indebido, no busca lo suyo, no se irrita, no guarda rencor; no se goza de la injusticia, mas se goza de la verdad. Todo lo sufre, todo lo cree, todo lo espera, todo lo soporta.\")," + //1 Corintios 13:4-7 RVR60
            "(364, 1, 46, 13, 13, \"Y ahora permanecen la fe, la esperanza y el amor, estos tres; pero el mayor de ellos es el amor.\")," + //1 Corintios 13:13 RVR60
            "(365, 1, 46, 16, 14, \"Todas vuestras cosas sean hechas con amor.\")," + //1 Corintios 16:14 RVR60
            "(366, 1, 47, 5, 14, \"Porque el amor de Cristo nos constriñe, pensando esto: que si uno murió por todos, luego todos murieron; y por todos murió, para que los que viven, ya no vivan para sí, sino para aquel que murió y resucitó por ellos.\")," + //2 Corintios 5:14-15 RVR60
            "(367, 1, 49, 2, 4, \"Pero Dios, que es rico en misericordia, por su gran amor con que nos amó, aun estando nosotros muertos en pecados, nos dio vida juntamente con Cristo (por gracia sois salvos).\")," + //Efesios 2:4-5 RVR60
            "(368, 1, 49, 4, 2, \"Con toda humildad y mansedumbre, soportándoos con paciencia los unos a los otros en amor.\")," + //Efesios 4:2 RVR60
            "(369, 1, 49, 4, 15, \"Sino que siguiendo la verdad en amor, crezcamos en todo en aquel que es la cabeza, esto es, Cristo.\")," + //Efesios 4:15 RVR60
            "(370, 1, 49, 5, 2, \"Y andad en amor, como también Cristo nos amó, y se entregó a sí mismo por nosotros, ofrenda y sacrificio a Dios en olor fragante.\")," + //Efesios 5:2 RVR60
            "(371, 1, 49, 5, 25, \"Maridos, amad a vuestras mujeres, así como Cristo amó a la iglesia, y se entregó a sí mismo por ella.\")," + //Efesios 5:25 RVR60
            "(372, 1, 45, 5, 5, \"Y la esperanza no avergüenza; porque el amor de Dios ha sido derramado en nuestros corazones por el Espíritu Santo que nos fue dado.\")," + //Romanos 5:5 RVR60
            "(373, 1, 45, 8, 28, \"Y sabemos que a los que aman a Dios, todas las cosas les ayudan a bien, esto es, a los que conforme a su propósito son llamados.\")," + //Romanos 8:28 RVR60
            "(374, 1, 45, 8, 35, \"¿Quién nos separará del amor de Cristo? ¿Tribulación, o angustia, o persecución, o hambre, o desnudez, o peligro, o espada?\")," + //Romanos 8:35 RVR60
            "(375, 1, 45, 8, 38, \"Por lo cual estoy seguro de que ni la muerte, ni la vida, ni ángeles, ni principados, ni potestades, ni lo presente, ni lo por venir, ni lo alto, ni lo profundo, ni ninguna otra cosa creada nos podrá separar del amor de Dios, que es en Cristo Jesús Señor nuestro.\")," + //Romanos 8:38-39 RVR60
            "(376, 1, 45, 12, 9, \"El amor sea sin fingimiento. Aborreced lo malo, seguid lo bueno.\")," + //Romanos 12:9 RVR60
            "(377, 1, 45, 12, 10, \"Amaos los unos a los otros con amor fraternal; en cuanto a honra, prefiriéndoos los unos a los otros.\")," + //Romanos 12:10 RVR60
            "(378, 1, 45, 13, 8, \"No debáis a nadie nada, sino el amaros unos a otros; porque el que ama al prójimo, ha cumplido la ley.\")," + //Romanos 13:8 RVR60
            "(379, 1, 45, 13, 9, \"Porque: No adulterarás, no matarás, no hurtarás, no dirás falso testimonio, no codiciarás, y cualquier otro mandamiento, en esta sentencia se resume: Amarás a tu prójimo como a ti mismo.\")," + //Romanos 13:9 RVR60
            "(380, 1, 45, 13, 10, \"El amor no hace mal al prójimo; así que el cumplimiento de la ley es el amor.\")," + //Romanos 13:10 RVR60
            "(381, 1, 43, 13, 34, \"Un mandamiento nuevo os doy: Que os améis unos a otros; como yo os he amado, que también os améis unos a otros.\")," + //Juan 13:34 RVR60
            "(382, 1, 43, 13, 35, \"En esto conocerán todos que sois mis discípulos, si tuviereis amor los unos con los otros.\")," + //Juan 13:35 RVR60
            "(383, 1, 43, 14, 15, \"Si me amáis, guardad mis mandamientos.\")," + //Juan 14:15 RVR60
            "(384, 1, 43, 14, 21, \"El que tiene mis mandamientos, y los guarda, ése es el que me ama; y el que me ama, será amado por mi Padre, y yo le amaré, y me manifestaré a él.\")," + //Juan 14:21 RVR60
            "(385, 1, 43, 14, 23, \"Respondió Jesús y le dijo: El que me ama, mi palabra guardará; y mi Padre le amará, y vendremos a él, y haremos morada con él.\")," + //Juan 14:23 RVR60
            "(386, 1, 43, 15, 10, \"Si guardareis mis mandamientos, permaneceréis en mi amor; así como yo he guardado los mandamientos de mi Padre, y permanezco en su amor.\")," + //Juan 15:10 RVR60
            "(387, 1, 43, 15, 12, \"Éste es mi mandamiento: Que os améis unos a otros, como yo os he amado.\")," + //Juan 15:12 RVR60
            "(388, 1, 43, 15, 13, \"Nadie tiene mayor amor que éste, que uno ponga su vida por sus amigos.\")," + //Juan 15:13 RVR60
            "(389, 1, 43, 17, 26, \"Y les he dado a conocer tu nombre, y lo daré a conocer aún, para que el amor con que me has amado, esté en ellos, y yo en ellos.\")," + //Juan 17:26 RVR60
            "(390, 1, 23, 43, 4, \"Porque a mis ojos fuiste de gran estima, fuiste honorable, y yo te amé; daré, pues, hombres por ti, y naciones por tu vida.\")," + //Isaias 43:4 RVR60
            "(391, 1, 52, 3, 12, \"Y el Señor os haga crecer y abundar en amor unos para con otros y para con todos, como también lo hacemos nosotros para con vosotros.\")," + //1 Tesalonicenses 3:12 RVR60
            "(392, 1, 53, 3, 5, \"Y el Señor encamine vuestros corazones al amor de Dios, y a la paciencia de Cristo.\")," + //2 Tesalonicenses 3:5 RVR60
            "(393, 1, 48, 5, 6, \"Porque en Cristo Jesús ni la circuncisión vale algo, ni la incircuncisión, sino la fe que obra por el amor.\")," + //Galatas 5:6 RVR60
            "(394, 1, 48, 5, 13, \"Porque vosotros, hermanos, a libertad fuisteis llamados; solamente que no uséis la libertad como ocasión para la carne, sino servíos por amor los unos a los otros.\")," + //Galatas 5:13 RVR60
            "(395, 1, 48, 5, 14, \"Porque toda la ley en esta sola palabra se cumple: Amarás a tu prójimo como a ti mismo.\")," + //Galatas 5:14 RVR60
            "(396, 1, 48, 5, 22, \"Mas el fruto del Espíritu es amor, gozo, paz, paciencia, benignidad, bondad, fe, mansedumbre, templanza; contra tales cosas no hay ley.\")," + //Galatas 5:22-23 RVR60
            "(397, 1, 51, 3, 14, \"Y sobre todas estas cosas vestíos de amor, que es el vínculo perfecto.\")," + //Colosenses 3:14 RVR60
            "(398, 1, 60, 4, 8, \"Y ante todo, tened entre vosotros ferviente amor; porque el amor cubrirá multitud de pecados.\")," + //1 Pedro 4:8 RVR60
            "(399, 1, 41, 12, 30, \"Y amarás al Señor tu Dios con todo tu corazón, y con toda tu alma, y con toda tu mente y con todas tus fuerzas. Éste es el principal mandamiento.\")," + //Marcos 12:30 RVR60
            "(400, 1, 41, 12, 31, \"Y el segundo es semejante: Amarás a tu prójimo como a ti mismo. No hay otro mandamiento mayor que éstos.\")," + //Marcos 12:31 RVR60
            "(401, 1, 54, 4, 12, \"Ninguno tenga en poco tu juventud, sino sé ejemplo de los creyentes en palabra, conducta, amor, espíritu, fe y pureza.\")," + //1 Timoteo 4:12 RVR60
            "(402, 1, 55, 1, 7, \"Porque no nos ha dado Dios espíritu de cobardía, sino de poder, de amor y de dominio propio.\")," + //2 Timoteo 1:7 RVR60
            "(403, 1, 40, 5, 44, \"Pero yo os digo: Amad a vuestros enemigos, bendecid a los que os maldicen, haced bien a los que os aborrecen, y orad por los que os ultrajan y os persiguen.\")," + //Mateo 5:44 RVR60
            "(404, 1, 42, 10, 27, \"Aquél, respondiendo, dijo: Amarás al Señor tu Dios con todo tu corazón, y con toda tu alma, y con todas tus fuerzas, y con toda tu mente; y a tu prójimo como a ti mismo.\")," + //Lucas 10:27 RVR60
            "(405, 1, 65, 1, 2, \"Misericordia y paz y amor os sean multiplicados.\")," + //Judas 1:2 RVR60
            "(406, 1, 58, 13, 1, \"Permanezca el amor fraternal.\")," + //Hebreos 13:1 RVR60
            "(407, 1, 66, 3, 19, \"Yo reprendo y castigo a todos los que amo; sé, pues, celoso, y arrepiéntete.\")," + //Apocalipsis 3:19 RVR60
            "(408, 1, 5, 6, 5, \"Y amarás a Jehová tu Dios de todo tu corazón, y de toda tu alma, y con todas tus fuerzas.\")," + //Deuteronomio 6:5 RVR60
            "(409, 1, 22, 8, 6, \"Ponme como un sello sobre tu corazón, como una marca sobre tu brazo; Porque fuerte es como la muerte el amor; Duros como el Seol los celos; Sus brasas, brasas de fuego, fuerte llama.\")"; //Cantares 8:6 RVR60

    public static final String INSERT_VERSICULO_TEMA_AMOR_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(410, 2, 62, 2, 15, \"No amen al mundo ni nada de lo que hay en él. Si alguien ama al mundo, no tiene el amor del Padre.\")," + //1 Juan 2:15 NVI
            "(411, 2, 62, 3, 1, \"¡Fíjense qué gran amor nos ha dado el Padre, que se nos llame hijos de Dios! ¡Y lo somos! El mundo no nos conoce, precisamente porque no lo conoció a él.\")," + //1 Juan 3:1 NVI
            "(412, 2, 62, 3, 11, \"Este es el mensaje que han oído desde el principio: que nos amemos los unos a los otros.\")," + //1 Juan 3:11 NVI
            "(413, 2, 62, 3, 16, \"En esto conocemos lo que es el amor: en que Jesucristo entregó su vida por nosotros. Así también nosotros debemos entregar la vida por nuestros hermanos.\")," + //1 Juan 3:16 NVI
            "(414, 2, 62, 4, 7, \"Queridos hermanos, amémonos los unos a los otros, porque el amor viene de Dios, y todo el que ama ha nacido de él y lo conoce.\")," + //1 Juan 4:7 NVI
            "(415, 2, 62, 4, 8, \"El que no ama no conoce a Dios, porque Dios es amor.\")," + //1 Juan 4:8 NVI
            "(416, 2, 62, 4, 9, \"Así manifestó Dios su amor entre nosotros: en que envió a su Hijo unigénito al mundo para que vivamos por medio de él.\")," + //1 Juan 4:9 NVI
            "(417, 2, 62, 4, 10, \"En esto consiste el amor: no en que nosotros hayamos amado a Dios, sino en que él nos amó y envió a su Hijo para que fuera ofrecido como sacrificio por el perdón de nuestros pecados.\")," + //1 Juan 4:10 NVI
            "(418, 2, 62, 4, 11, \"Queridos hermanos, ya que Dios nos ha amado así, también nosotros debemos amarnos los unos a los otros.\")," + //1 Juan 4:11 NVI
            "(419, 2, 62, 4, 12, \"Nadie ha visto jamás a Dios, pero, si nos amamos los unos a los otros, Dios permanece entre nosotros, y entre nosotros su amor se ha manifestado plenamente.\")," + //1 Juan 4:12 NVI
            "(420, 2, 62, 4, 16, \"Y nosotros hemos llegado a saber y creer que Dios nos ama. Dios es amor. El que permanece en amor, permanece en Dios, y Dios en él.\")," + //1 Juan 4:16 NVI
            "(421, 2, 62, 4, 18, \"En el amor no hay temor, sino que el amor perfecto echa fuera el temor. El que teme espera el castigo, así que no ha sido perfeccionado en el amor.\")," + //1 Juan 4:18 NVI
            "(422, 2, 62, 4, 19, \"Nosotros amamos porque él nos amó primero.\")," + //1 Juan 4:19 NVI
            "(423, 2, 62, 4, 20, \"Si alguien afirma: «Yo amo a Dios», pero odia a su hermano, es un mentiroso; pues el que no ama a su hermano, a quien ha visto, no puede amar a Dios, a quien no ha visto.\")," + //1 Juan 4:20 NVI
            "(424, 2, 62, 4, 21, \"Y él nos ha dado este mandamiento: el que ama a Dios, ame también a su hermano.\")," + //1 Juan 4:21 NVI
            "(425, 2, 19, 33, 5, \"El Señor ama la justicia y el derecho; llena está la tierra de su amor.\")," + //Salmos 33:5 NVI
            "(426, 2, 19, 116, 1, \"Yo amo al Señor porque él escucha mi voz suplicante.\")," + //Salmos 116:1 NVI
            "(427, 2, 20, 3, 12, \"Porque el Señor disciplina a los que ama, como corrige un padre a su hijo querido.\")," + //Proverbios 3:12 NVI
            "(428, 2, 20, 10, 12, \"El odio es motivo de disensiones, pero el amor cubre todas las faltas.\")," + //Proverbios 10:12 NVI
            "(429, 2, 46, 2, 9, \"Sin embargo, como está escrito: «Ningún ojo ha visto, ningún oído ha escuchado, ninguna mente humana ha concebido lo que Dios ha preparado para quienes lo aman».\")," + //1 Corintios 2:9 NVI
            "(430, 2, 46, 13, 1, \"Si hablo en lenguas humanas y angelicales, pero no tengo amor, no soy más que un metal que resuena o un platillo que hace ruido.\")," + //1 Corintios 13:1 NVI
            "(431, 2, 46, 13, 2, \"Si tengo el don de profecía y entiendo todos los misterios y poseo todo conocimiento, y si tengo una fe que logra trasladar montañas, pero me falta el amor, no soy nada.\")," + //1 Corintios 13:2 NVI
            "(432, 2, 46, 13, 3, \"Si reparto entre los pobres todo lo que poseo, y si entrego mi cuerpo para que lo consuman las llamas, pero no tengo amor, nada gano con eso.\")," + //1 Corintios 13:3 NVI
            "(433, 2, 46, 13, 4, \"El amor es paciente, es bondadoso. El amor no es envidioso ni jactancioso ni orgulloso. No se comporta con rudeza, no es egoísta, no se enoja fácilmente, no guarda rencor. El amor no se deleita en la maldad, sino que se regocija con la verdad. Todo lo disculpa, todo lo cree, todo lo espera, todo lo soporta.\")," + //1 Corintios 13:4-7 NVI
            "(434, 2, 46, 13, 13, \"Ahora, pues, permanecen estas tres virtudes: la fe, la esperanza y el amor. Pero la más excelente de ellas es el amor.\")," + //1 Corintios 13:13 NVI
            "(435, 2, 46, 16, 14, \"Hagan todo con amor.\")," + //1 Corintios 16:14 NVI
            "(436, 2, 47, 5, 14, \"El amor de Cristo nos obliga, porque estamos convencidos de que uno murió por todos, y por consiguiente todos murieron. Y él murió por todos, para que los que viven ya no vivan para sí, sino para el que murió por ellos y fue resucitado.\")," + //2 Corintios 5:14-15 NVI
            "(437, 2, 49, 2, 4, \"Pero Dios, que es rico en misericordia, por su gran amor por nosotros, nos dio vida con Cristo, aun cuando estábamos muertos en pecados. ¡Por gracia ustedes han sido salvados!\")," + //Efesios 2:4-5 NVI
            "(438, 2, 49, 4, 2, \"Siempre humildes y amables, pacientes, tolerantes unos con otros en amor.\")," + //Efesios 4:2 NVI
            "(439, 2, 49, 4, 15, \"Más bien, al vivir la verdad con amor, creceremos hasta ser en todo como aquel que es la cabeza, es decir, Cristo.\")," + //Efesios 4:15 NVI
            "(440, 2, 49, 5, 2, \"Y lleven una vida de amor, así como Cristo nos amó y se entregó por nosotros como ofrenda y sacrificio fragante para Dios.\")," + //Efesios 5:2 NVI
            "(441, 2, 49, 5, 25, \"Esposos, amen a sus esposas, así como Cristo amó a la iglesia y se entregó por ella.\")," + //Efesios 5:25 NVI
            "(442, 2, 45, 5, 5, \"Y esta esperanza no nos defrauda, porque Dios ha derramado su amor en nuestro corazón por el Espíritu Santo que nos ha dado.\")," + //Romanos 5:5 NVI
            "(443, 2, 45, 8, 28, \"Ahora bien, sabemos que Dios dispone todas las cosas para el bien de quienes lo aman, los que han sido llamados de acuerdo con su propósito.\")," + //Romanos 8:28 NVI
            "(444, 2, 45, 8, 35, \"¿Quién nos apartará del amor de Cristo? ¿La tribulación, o la angustia, la persecución, el hambre, la indigencia, el peligro, o la violencia?\")," + //Romanos 8:35 NVI
            "(445, 2, 45, 8, 38, \"Pues estoy convencido de que ni la muerte ni la vida, ni los ángeles ni los demonios, ni lo presente ni lo por venir, ni los poderes, ni lo alto ni lo profundo, ni cosa alguna en toda la creación podrá apartarnos del amor que Dios nos ha manifestado en Cristo Jesús nuestro Señor.\")," + //Romanos 8:38-39 NVI
            "(446, 2, 45, 12, 9, \"El amor debe ser sincero. Aborrezcan el mal; aférrense al bien.\")," + //Romanos 12:9 NVI
            "(447, 2, 45, 12, 10, \"Ámense los unos a los otros con amor fraternal, respetándose y honrándose mutuamente.\")," + //Romanos 12:10 NVI
            "(448, 2, 45, 13, 8, \"No tengan deudas pendientes con nadie, a no ser la de amarse unos a otros. De hecho, quien ama al prójimo ha cumplido la ley.\")," + //Romanos 13:8 NVI
            "(449, 2, 45, 13, 9, \"Porque los mandamientos que dicen: «No cometas adulterio», «No mates», «No robes», «No codicies», y todos los demás mandamientos, se resumen en este precepto: «Ama a tu prójimo como a ti mismo».\")," + //Romanos 13:9 NVI
            "(450, 2, 45, 13, 10, \"El amor no perjudica al prójimo. Así que el amor es el cumplimiento de la ley.\")," + //Romanos 13:10 NVI
            "(451, 2, 43, 13, 34, \"Este mandamiento nuevo les doy: que se amen los unos a los otros. Así como yo los he amado, también ustedes deben amarse los unos a los otros.\")," + //Juan 13:34 NVI
            "(452, 2, 43, 13, 35, \"De este modo todos sabrán que son mis discípulos, si se aman los unos a los otros.\")," + //Juan 13:35 NVI
            "(453, 2, 43, 14, 15, \"Si ustedes me aman, obedecerán mis mandamientos.\")," + //Juan 14:15 NVI
            "(454, 2, 43, 14, 21, \"¿Quién es el que me ama? El que hace suyos mis mandamientos y los obedece. Y al que me ama, mi Padre lo amará, y yo también lo amaré y me manifestaré a él.\")," + //Juan 14:21 NVI
            "(455, 2, 43, 14, 23, \"Le contestó Jesús:―El que me ama, obedecerá mi palabra, y mi Padre lo amará, y haremos nuestra vivienda en él.\")," + //Juan 14:23 NVI
            "(456, 2, 43, 15, 10, \"Si obedecen mis mandamientos, permanecerán en mi amor, así como yo he obedecido los mandamientos de mi Padre y permanezco en su amor.\")," + //Juan 15:10 NVI
            "(457, 2, 43, 15, 12, \"Y este es mi mandamiento: que se amen los unos a los otros, como yo los he amado.\")," + //Juan 15:12 NVI
            "(458, 2, 43, 15, 13, \"Nadie tiene amor más grande que el dar la vida por sus amigos.\")," + //Juan 15:13 NVI
            "(459, 2, 43, 17, 26, \"Yo les he dado a conocer quién eres, y seguiré haciéndolo, para que el amor con que me has amado esté en ellos, y yo mismo esté en ellos.\")," + //Juan 17:26 NVI
            "(460, 2, 23, 43, 4, \"A cambio de ti entregaré hombres; ¡a cambio de tu vida entregaré pueblos! Porque te amo y eres ante mis ojos precioso y digno de honra.\")," + //Isaias 43:4 NVI
            "(461, 2, 52, 3, 12, \"Que el Señor los haga crecer para que se amen más y más unos a otros, y a todos, tal como nosotros los amamos a ustedes.\")," + //1 Tesalonicenses 3:12 NVI
            "(462, 2, 53, 3, 5, \"Que el Señor los lleve a amar como Dios ama, y a perseverar como Cristo perseveró.\")," + //2 Tesalonicenses 3:5 NVI
            "(463, 2, 48, 5, 6, \"En Cristo Jesús de nada vale estar o no estar circuncidados; lo que vale es la fe que actúa mediante el amor.\")," + //Galatas 5:6 NVI
            "(464, 2, 48, 5, 13, \"Les hablo así, hermanos, porque ustedes han sido llamados a ser libres; pero no se valgan de esa libertad para dar rienda suelta a sus pasiones. Más bien sírvanse unos a otros con amor.\")," + //Galatas 5:13 NVI
            "(465, 2, 48, 5, 14, \"En efecto, toda la ley se resume en un solo mandamiento: «Ama a tu prójimo como a ti mismo».\")," + //Galatas 5:14 NVI
            "(466, 2, 48, 5, 22, \"En cambio, el fruto del Espíritu es amor, alegría, paz, paciencia, amabilidad, bondad, fidelidad, humildad y dominio propio. No hay ley que condene estas cosas.\")," + //Galatas 5:22-23 NVI
            "(467, 2, 51, 3, 14, \"Por encima de todo, vístanse de amor, que es el vínculo perfecto.\")," + //Colosenses 3:14 NVI
            "(468, 2, 60, 4, 8, \"Sobre todo, ámense los unos a los otros profundamente, porque el amor cubre multitud de pecados.\")," + //1 Pedro 4:8 NVI
            "(469, 2, 41, 12, 30, \"Ama al Señor tu Dios con todo tu corazón, con toda tu alma, con toda tu mente y con todas tus fuerzas.\")," + //Marcos 12:30 NVI
            "(470, 2, 41, 12, 31, \"El segundo es: “Ama a tu prójimo como a ti mismo”. No hay otro mandamiento más importante que estos.\")," + //Marcos 12:31 NVI
            "(471, 2, 54, 4, 12, \"Que nadie te menosprecie por ser joven. Al contrario, que los creyentes vean en ti un ejemplo a seguir en la manera de hablar, en la conducta, y en amor, fe y pureza.\")," + //1 Timoteo 4:12 NVI
            "(472, 2, 55, 1, 7, \"Pues Dios no nos ha dado un espíritu de timidez, sino de poder, de amor y de dominio propio.\")," + //2 Timoteo 1:7 NVI
            "(473, 2, 40, 5, 44, \"Pero yo les digo: Amen a sus enemigos y oren por quienes los persiguen.\")," + //Mateo 5:44 NVI
            "(474, 2, 42, 10, 27, \"Como respuesta el hombre citó:―“Ama al Señor tu Dios con todo tu corazón, con todo tu ser, con todas tus fuerzas y con toda tu mente”, y: “Ama a tu prójimo como a ti mismo”.\")," + //Lucas 10:27 NVI
            "(475, 2, 65, 1, 2, \"Que reciban misericordia, paz y amor en abundancia.\")," + //Judas 1:2 NVI
            "(476, 2, 58, 13, 1, \"Sigan amándose unos a otros fraternalmente.\")," + //Hebreos 13:1 NVI
            "(477, 2, 66, 3, 19, \"Yo reprendo y disciplino a todos los que amo. Por lo tanto, sé fervoroso y arrepiéntete.\")," + //Apocalipsis 3:19 NVI
            "(478, 2, 5, 6, 5, \"Ama al Señor tu Dios con todo tu corazón y con toda tu alma y con todas tus fuerzas.\")," + //Deuteronomio 6:5 NVI
            "(479, 2, 22, 8, 6, \"Grábame como un sello sobre tu corazón; llévame como una marca sobre tu brazo. Fuerte es el amor, como la muerte, y tenaz la pasión, como el sepulcro. Como llama divina es el fuego ardiente del amor.\")"; //Cantares 8:6 NVI

    public static final String INSERT_VERSICULO_TEMA_AMOR_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(480, 3, 62, 2, 15, \"No quieran ustedes ser como los pecadores del mundo, ni tampoco hacer lo que ellos hacen. Quienes lo hacen, no aman a Dios el Padre.\")," + //1 Juan 2:15 TLA
            "(481, 3, 62, 3, 1, \"¡Miren! Dios el Padre nos ama tanto que la gente nos llama hijos de Dios, y la verdad es que lo somos. Por eso los pecadores de este mundo no nos conocen, porque tampoco han conocido a Dios.\")," + //1 Juan 3:1 TLA
            "(482, 3, 62, 3, 11, \"Desde el principio se les ha enseñado a ustedes que nosotros debemos amarnos unos a otros.\")," + //1 Juan 3:11 TLA
            "(483, 3, 62, 3, 16, \"Pero nosotros sabemos lo que es el amor, porque Jesucristo dio su vida por nosotros. Así también nosotros, debemos dar nuestra vida por nuestros hermanos en Cristo.\")," + //1 Juan 3:16 TLA
            "(484, 3, 62, 4, 7, \"Amados hijos míos, debemos amarnos unos a otros, porque el amor viene de Dios. Todo el que ama es hijo de Dios, y conoce a Dios.\")," + //1 Juan 4:7 TLA
            "(485, 3, 62, 4, 8, \"El que no ama no conoce a Dios, porque Dios es amor.\")," + //1 Juan 4:8 TLA
            "(486, 3, 62, 4, 9, \"Dios nos dio muestras de su amor al enviar al mundo a Jesús, su único Hijo, para que por medio de él todos nosotros tengamos vida eterna.\")," + //1 Juan 4:9 TLA
            "(487, 3, 62, 4, 10, \"El verdadero amor no consiste en que nosotros hayamos amado a Dios, sino en que él nos amó y envió a su Hijo, para que nosotros fuéramos perdonados por medio de su sacrificio.\")," + //1 Juan 4:10 TLA
            "(488, 3, 62, 4, 11, \"Hijos míos, si Dios nos ha amado así, nosotros también debemos amarnos los unos a los otros.\")," + //1 Juan 4:11 TLA
            "(489, 3, 62, 4, 12, \"Nadie ha visto nunca a Dios; pero, si nos amamos unos a otros, Dios vive en nosotros y también su amor estará en nosotros.\")," + //1 Juan 4:12 TLA
            "(490, 3, 62, 4, 16, \"Sabemos y creemos que Dios nos ama, porque Dios es amor. Cualquiera que ama a sus hermanos está íntimamente unido a Dios.\")," + //1 Juan 4:16 TLA
            "(491, 3, 62, 4, 18, \"La persona que ama no tiene miedo. Donde hay amor no hay temor. Al contrario, el verdadero amor quita el miedo. Si alguien tiene miedo de que Dios lo castigue, es porque no ha aprendido a amar.\")," + //1 Juan 4:18 TLA
            "(492, 3, 62, 4, 19, \"Nosotros amamos a nuestros hermanos porque Dios nos amó primero.\")," + //1 Juan 4:19 TLA
            "(493, 3, 62, 4, 20, \"Si decimos que amamos a Dios, y al mismo tiempo nos odiamos unos a otros, somos unos mentirosos. Porque si no amamos al hermano, a quien podemos ver, mucho menos podemos amar a Dios, a quien no podemos ver.\")," + //1 Juan 4:20 TLA
            "(494, 3, 62, 4, 21, \"Y Jesucristo nos dio este mandamiento: «¡Amen a Dios, y ámense unos a otros!»\")," + //1 Juan 4:21 TLA
            "(495, 3, 19, 33, 5, \"Dios es digno de confianza; Dios ama lo que es justo y recto. Por todas partes se pueden ver sus grandes actos de bondad.\")," + //Salmos 33:5 TLA
            "(496, 3, 19, 116, 1, \"Yo amo a mi Dios porque él escucha mis ruegos.\")," + //Salmos 116:1 TLA
            "(497, 3, 20, 3, 12, \"Porque Dios corrige a quienes ama, como corrige un padre a sus hijos.\")," + //Proverbios 3:12 TLA
            "(498, 3, 20, 10, 12, \"El odio produce más odio; el amor todo lo perdona.\")," + //Proverbios 10:12 TLA
            "(499, 3, 46, 2, 9, \"Como dice la Biblia: «Para aquellos que lo aman, Dios ha preparado cosas que nadie jamás pudo ver, ni escuchar ni imaginar.»\")," + //1 Corintios 2:9 TLA
            "(500, 3, 46, 13, 1, \"Si no tengo amor, de nada me sirve hablar todos los idiomas del mundo, y hasta el idioma de los ángeles. Si no tengo amor, soy como un pedazo de metal ruidoso; ¡soy como una campana desafinada!\")," + //1 Corintios 13:1 TLA
            "(501, 3, 46, 13, 2, \"Si no tengo amor, de nada me sirve hablar de parte de Dios y conocer sus planes secretos. De nada me sirve que mi confianza en Dios me haga mover montañas.\")," + //1 Corintios 13:2 TLA
            "(502, 3, 46, 13, 3, \"Si no tengo amor, de nada me sirve darles a los pobres todo lo que tengo. De nada me sirve dedicarme en cuerpo y alma a ayudar a los demás.\")," + //1 Corintios 13:3 TLA
            "(503, 3, 46, 13, 4, \"El que ama tiene paciencia en todo, y siempre es amable. El que ama no es envidioso, ni se cree más que nadie. No es orgulloso. No es grosero ni egoísta. No se enoja por cualquier cosa. No se pasa la vida recordando lo malo que otros le han hecho. No aplaude a los malvados, sino a los que hablan con la verdad. El que ama es capaz de aguantarlo todo, de creerlo todo, de esperarlo todo, de soportarlo todo.\")," + //1 Corintios 13:4-7 TLA
            "(504, 3, 46, 13, 13, \"Hay tres cosas que son permanentes: la confianza en Dios, la seguridad de que él cumplirá sus promesas, y el amor. De estas tres cosas, la más importante es el amor.\")," + //1 Corintios 13:13 TLA
            "(505, 3, 46, 16, 14, \"Y todo lo que hagan, háganlo con amor.\")," + //1 Corintios 16:14 TLA
            "(506, 3, 47, 5, 14, \"El amor de Cristo domina nuestras vidas. Sabemos que él murió por todos y que, por lo tanto, todos hemos muerto. Así que, si Cristo murió por nosotros, ya no debemos vivir más para nosotros mismos, sino para Cristo, que murió y resucitó para darnos vida.\")," + //2 Corintios 5:14-15 TLA
            "(507, 3, 49, 2, 4, \"Pero Dios es muy compasivo, y su amor por nosotros es inmenso. Por eso, aunque estábamos muertos por culpa de nuestros pecados, él nos dio vida al resucitar a Cristo. Nos hemos salvado gracias al amor de Dios.\")," + //Efesios 2:4-5 TLA
            "(508, 3, 49, 4, 2, \"Sean humildes, amables y pacientes, y bríndense apoyo, por amor, los unos a los otros.\")," + //Efesios 4:2 TLA
            "(509, 3, 49, 4, 15, \"Al contrario, el amor debe hacernos decir siempre la verdad, para que en todo lo que hagamos nos parezcamos cada vez más a Cristo, que es quien gobierna la iglesia.\")," + //Efesios 4:15 TLA
            "(510, 3, 49, 5, 2, \"Deben amar a los demás, así como Cristo nos amó y murió por nosotros. Para Dios, la muerte de Cristo es como el delicado aroma de una ofrenda.\")," + //Efesios 5:2 TLA
            "(511, 3, 49, 5, 25, \"Los esposos deben amar a sus esposas, así como Cristo amó a la iglesia y dio su vida por ella.\")," + //Efesios 5:25 TLA
            "(512, 3, 45, 5, 5, \"Y si aprendemos a soportarlo, seremos aprobados por Dios. Y si él nos aprueba, podremos estar seguros de nuestra salvación. De eso estamos seguros: Dios cumplirá su promesa, porque él nos ha llenado el corazón con su amor, por medio del Espíritu Santo que nos ha dado.\")," + //Romanos 5:5 TLA
            "(513, 3, 45, 8, 28, \"Sabemos que Dios va preparando todo para el bien de los que lo aman, es decir, de los que él ha llamado de acuerdo con su plan.\")," + //Romanos 8:28 TLA
            "(514, 3, 45, 8, 35, \"¿Quién podrá separarnos del amor de Jesucristo? Nada ni nadie. Ni los problemas, ni los sufrimientos, ni las dificultades. Tampoco podrán hacerlo el hambre ni el frío, ni los peligros ni la muerte.\")," + //Romanos 8:35 TLA
            "(515, 3, 45, 8, 38, \"Yo estoy seguro de que nada podrá separarnos del amor de Dios: ni la vida ni la muerte, ni los ángeles ni los espíritus, ni lo presente ni lo futuro, ni los poderes del cielo ni los del infierno, ni nada de lo creado por Dios. ¡Nada, absolutamente nada, podrá separarnos del amor que Dios nos ha mostrado por medio de nuestro Señor Jesucristo!\")," + //Romanos 8:38-39 TLA
            "(516, 3, 45, 12, 9, \"Amen a los demás con sinceridad. Rechacen todo lo que sea malo, y no se aparten de lo que sea bueno.\")," + //Romanos 12:9 TLA
            "(517, 3, 45, 12, 10, \"Ámense unos a otros como hermanos, y respétense siempre.\")," + //Romanos 12:10 TLA
            "(518, 3, 45, 13, 8, \"No le deban nada a nadie. La única deuda que deben tener es la de amarse unos a otros. El que ama a los demás ya ha cumplido con todo lo que la ley exige.\")," + //Romanos 13:8 TLA
            "(519, 3, 45, 13, 9, \"En la ley hay mandatos como éstos: «No sean infieles en su matrimonio. No maten. No roben. No se dejen dominar por el deseo de tener lo que otros tienen.» Estos mandamientos, y todos los demás, pueden resumirse en uno solo: «Cada uno debe amar a su prójimo, como se ama a sí mismo.»\")," + //Romanos 13:9 TLA
            "(520, 3, 45, 13, 10, \"El amor no causa daño a nadie. Cuando amamos a los demás, estamos cumpliendo toda la ley.\")," + //Romanos 13:10 TLA
            "(521, 3, 43, 13, 34, \"Les doy un mandamiento nuevo: Ámense unos a otros.Ustedes deben amarse de la misma manera que yo los amo.\")," + //Juan 13:34 TLA
            "(522, 3, 43, 13, 35, \"Si se aman de verdad, entonces todos sabrán que ustedes son mis seguidores.\")," + //Juan 13:35 TLA
            "(523, 3, 43, 14, 15, \"Ustedes demostrarán que me aman, si cumplen mis mandamientos.\")," + //Juan 14:15 TLA
            "(524, 3, 43, 14, 21, \"El que me obedece y hace lo que yo mando, demuestra que me ama de verdad. Al que me ame así, mi Padre lo amará, y yo también lo amaré y le mostraré cómo soy en realidad.\")," + //Juan 14:21 TLA
            "(525, 3, 43, 14, 23, \"Jesús le contestó:—Si alguien me ama, también me obedece. Dios mi Padre lo amará, y vendremos a vivir con él.\")," + //Juan 14:23 TLA
            "(526, 3, 43, 15, 10, \"Si obedecen todo lo que yo les he mandado, los amaré siempre, así como mi Padre me ama, porque yo lo obedezco en todo.\")," + //Juan 15:10 TLA
            "(527, 3, 43, 15, 12, \"Y esto es lo que les mando: que se amen unos a otros, así como yo los amo a ustedes.\")," + //Juan 15:12 TLA
            "(528, 3, 43, 15, 13, \"Nadie muestra más amor que quien da la vida por sus amigos.\")," + //Juan 15:13 TLA
            "(529, 3, 43, 17, 26, \"Les he dicho quién eres, y no dejaré de hacerlo, para que se mantengan unidos a mí, y para que amen a los demás como tú y yo nos amamos.\")," + //Juan 17:26 TLA
            "(530, 3, 23, 43, 4, \"Porque yo soy tu Dios y te pondré a salvo. Yo soy el Dios santo de Israel. Israel, yo te amo; tú vales mucho para mí.\")," + //Isaias 43:4 TLA
            "(531, 3, 52, 3, 12, \"Le pedimos al Señor que los haga amarse más los unos a los otros, y amar también a todos por igual. Porque así los amamos nosotros a ustedes.\")," + //1 Tesalonicenses 3:12 TLA
            "(532, 3, 53, 3, 5, \"Deseamos que el Señor Jesús los ayude a amar a los demás, así como Dios ama a todos, y que les dé su fortaleza para resistir en medio del sufrimiento.\")," + //2 Tesalonicenses 3:5 TLA
            "(533, 3, 48, 5, 6, \"Gracias a lo que Cristo hizo, ya no importa si estamos circuncidados o no. Lo que sí importa es que confiamos en Cristo, y que esa confianza nos hace amar a los demás.\")," + //Galatas 5:6 TLA
            "(534, 3, 48, 5, 13, \"Hermanos, Dios los llamó a ustedes a ser libres, pero no usen esa libertad como pretexto para hacer lo malo. Al contrario, ayúdense por amor los unos a los otros.\")," + //Galatas 5:13 TLA
            "(535, 3, 48, 5, 14, \"Porque toda la ley de Dios se resume en un solo mandamiento: «Cada uno debe amar a su prójimo, como se ama a sí mismo.»\")," + //Galatas 5:14 TLA
            "(536, 3, 48, 5, 22, \"En cambio, el Espíritu de Dios nos hace amar a los demás, estar siempre alegres y vivir en paz con todos. Nos hace ser pacientes y amables, y tratar bien a los demás, tener confianza en Dios, ser humildes, y saber controlar nuestros malos deseos. No hay ley que esté en contra de todo esto.\")," + //Galatas 5:22-23 TLA
            "(537, 3, 51, 3, 14, \"Y sobre todo, ámense unos a otros, porque el amor es el mejor lazo de unión.\")," + //Colosenses 3:14 TLA
            "(538, 3, 60, 4, 8, \"Sobre todo, ámense mucho unos a otros, porque el amor borra los pecados.\")," + //1 Pedro 4:8 TLA
            "(539, 3, 41, 12, 30, \"Ama a tu Dios con todo lo que piensas, con todo lo que eres y con todo lo que vales.\")," + //Marcos 12:30 TLA
            "(540, 3, 41, 12, 31, \"Y el segundo mandamiento en importancia es: “Cada uno debe amar a su prójimo, como se ama a sí mismo.” Ningún otro mandamiento es más importante que estos dos.\")," + //Marcos 12:31 TLA
            "(541, 3, 54, 4, 12, \"No permitas que nadie te desprecie por ser joven. Al contrario, trata de ser un ejemplo para los demás cristianos. Que cuando todos oigan tu modo de hablar, y vean cómo vives, traten de ser puros como tú. Que todos imiten tu carácter amoroso y tu confianza en Dios.\")," + //1 Timoteo 4:12 TLA
            "(542, 3, 55, 1, 7, \"Porque el Espíritu de Dios no nos hace cobardes. Al contrario, nos da poder para amar a los demás, y nos fortalece para que podamos vivir una buena vida cristiana.\")," + //2 Timoteo 1:7 TLA
            "(543, 3, 40, 5, 44, \"Pero ahora yo les digo: Amen a sus enemigos y oren por quienes los maltratan.\")," + //Mateo 5:44 TLA
            "(544, 3, 42, 10, 27, \"El maestro de la Ley respondió: —“Ama a tu Dios con todo lo que piensas, con todo lo que vales y con todo lo que eres, y cada uno debe amar a su prójimo como se ama a sí mismo.”\")," + //Lucas 10:27 TLA
            "(545, 3, 65, 1, 2, \"Deseo que Dios los trate con mucha compasión y con abundante paz y amor.\")," + //Judas 1:2 TLA
            "(546, 3, 58, 13, 1, \"Ámense siempre los unos a los otros, como hermanos en Cristo.\")," + //Hebreos 13:1 TLA
            "(547, 3, 66, 3, 19, \"Yo reprendo y corrijo a los que amo. Por eso, vuélvete a Dios y obedécelo completamente.\")," + //Apocalipsis 3:19 TLA
            "(548, 3, 5, 6, 5, \"Ama a tu Dios con todo lo que piensas, con todo lo que eres y con todo lo que vales.\")," + //Deuteronomio 6:5 TLA
            "(549, 3, 22, 8, 6, \"¡Graba mi nombre en tu corazón! ¡Graba mi imagen en tu brazo! ¡Tan fuerte es el amor como la muerte! ¡Tan cierta es la pasión como la tumba! ¡El fuego del amor es una llama que Dios mismo ha encendido!\")"; //Cantares 8:6 TLA

    public static final String INSERT_VERSICULO_TEMA_AMOR_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(550, 4, 62, 2, 15, \"No amen a este mundo ni las cosas que les ofrece, porque cuando aman al mundo no tienen el amor del Padre en ustedes.\")," + //1 Juan 2:15 NTV
            "(551, 4, 62, 3, 1, \"Miren con cuánto amor nos ama nuestro Padre que nos llama sus hijos, ¡y eso es lo que somos! Pero la gente de este mundo no reconoce que somos hijos de Dios, porque no lo conocen a él.\")," + //1 Juan 3:1 NTV
            "(552, 4, 62, 3, 11, \"Este es el mensaje que ustedes han oído desde el principio: que nos amemos unos a otros.\")," + //1 Juan 3:11 NTV
            "(553, 4, 62, 3, 16, \"Conocemos lo que es el amor verdadero, porque Jesús entregó su vida por nosotros. De manera que nosotros también tenemos que dar la vida por nuestros hermanos.\")," + //1 Juan 3:16 NTV
            "(554, 4, 62, 4, 7, \"Queridos amigos, sigamos amándonos unos a otros, porque el amor viene de Dios. Todo el que ama es un hijo de Dios y conoce a Dios.\")," + //1 Juan 4:7 NTV
            "(555, 4, 62, 4, 8, \"Pero el que no ama no conoce a Dios, porque Dios es amor.\")," + //1 Juan 4:8 NTV
            "(556, 4, 62, 4, 9, \"Dios mostró cuánto nos ama al enviar a su único Hijo al mundo, para que tengamos vida eterna por medio de él.\")," + //1 Juan 4:9 NTV
            "(557, 4, 62, 4, 10, \"En esto consiste el amor verdadero: no en que nosotros hayamos amado a Dios, sino en que él nos amó a nosotros y envió a su Hijo como sacrificio para quitar nuestros pecados.\")," + //1 Juan 4:10 NTV
            "(558, 4, 62, 4, 11, \"Queridos amigos, ya que Dios nos amó tanto, sin duda nosotros también debemos amarnos unos a otros.\")," + //1 Juan 4:11 NTV
            "(559, 4, 62, 4, 12, \"Nadie jamás ha visto a Dios; pero si nos amamos unos a otros, Dios vive en nosotros y su amor llega a la máxima expresión en nosotros.\")," + //1 Juan 4:12 NTV
            "(560, 4, 62, 4, 16, \"Nosotros sabemos cuánto nos ama Dios y hemos puesto nuestra confianza en su amor. Dios es amor, y todos los que viven en amor viven en Dios y Dios vive en ellos\")," + //1 Juan 4:16 NTV
            "(561, 4, 62, 4, 18, \"En esa clase de amor no hay temor, porque el amor perfecto expulsa todo temor. Si tenemos miedo es por temor al castigo, y esto muestra que no hemos experimentado plenamente el perfecto amor de Dios.\")," + //1 Juan 4:18 NTV
            "(562, 4, 62, 4, 19, \"Nos amamos unos a otros, porque él nos amó primero.\")," + //1 Juan 4:19 NTV
            "(563, 4, 62, 4, 20, \"Si alguien dice: «Amo a Dios» pero odia a un hermano en Cristo, esa persona es mentirosa pues, si no amamos a quienes podemos ver, ¿cómo vamos a amar a Dios, a quien no podemos ver?\")," + //1 Juan 4:20 NTV
            "(564, 4, 62, 4, 21, \"Y él nos ha dado el siguiente mandato: los que aman a Dios amen también a sus hermanos en Cristo.\")," + //1 Juan 4:21 NTV
            "(565, 4, 19, 33, 5, \"Él ama lo que es justo y bueno; el amor inagotable del Señor llena la tierra.\")," + //Salmos 33:5 NTV
            "(566, 4, 19, 116, 1, \"Amo al Señor porque escucha mi voz y mi oración que pide misericordia.\")," + //Salmos 116:1 NTV
            "(567, 4, 20, 3, 12, \"Pues el Señor corrige a los que ama, tal como un padre corrige al hijo que es su deleite.\")," + //Proverbios 3:12 NTV
            "(568, 4, 20, 10, 12, \"El odio provoca peleas, pero el amor cubre todas las ofensas.\")," + //Proverbios 10:12 NTV
            "(569, 4, 46, 2, 9, \"A eso se refieren las Escrituras cuando dicen: «Ningún ojo ha visto, ningún oído ha escuchado, ninguna mente ha imaginado lo que Dios tiene preparado para quienes lo aman»\")," + //1 Corintios 2:9 NTV
            "(570, 4, 46, 13, 1, \"Si pudiera hablar todos los idiomas del mundo y de los ángeles pero no amara a los demás, yo solo sería un metal ruidoso o un címbalo que resuena.\")," + //1 Corintios 13:1 NTV
            "(571, 4, 46, 13, 2, \"Si tuviera el don de profecía y entendiera todos los planes secretos de Dios y contara con todo el conocimiento, y si tuviera una fe que me hiciera capaz de mover montañas, pero no amara a otros, yo no sería nada.\")," + //1 Corintios 13:2 NTV
            "(572, 4, 46, 13, 3, \"Si diera todo lo que tengo a los pobres y hasta sacrificara mi cuerpo, podría jactarme de eso; pero si no amara a los demás, no habría logrado nada.\")," + //1 Corintios 13:3 NTV
            "(573, 4, 46, 13, 4, \"El amor es paciente y bondadoso. El amor no es celoso ni fanfarrón ni orgulloso ni ofensivo. No exige que las cosas se hagan a su manera. No se irrita ni lleva un registro de las ofensas recibidas. No se alegra de la injusticia sino que se alegra cuando la verdad triunfa. El amor nunca se da por vencido, jamás pierde la fe, siempre tiene esperanzas y se mantiene firme en toda circunstancia.\")," + //1 Corintios 13:4-7 NTV
            "(574, 4, 46, 13, 13, \"Tres cosas durarán para siempre: la fe, la esperanza y el amor; y la mayor de las tres es el amor.\")," + //1 Corintios 13:13 NTV
            "(575, 4, 46, 16, 14, \"Y hagan todo con amor.\")," + //1 Corintios 16:14 NTV
            "(576, 4, 47, 5, 14, \"Sea de una forma u otra, el amor de Cristo nos controla. Ya que creemos que Cristo murió por todos, también creemos que todos hemos muerto a nuestra vida antigua. Él murió por todos para que los que reciben la nueva vida de Cristo ya no vivan más para sí mismos. Más bien, vivirán para Cristo, quien murió y resucitó por ellos.\")," + //2 Corintios 5:14-15 NTV
            "(577, 4, 49, 2, 4, \"Pero Dios es tan rico en misericordia y nos amó tanto que, a pesar de que estábamos muertos por causa de nuestros pecados, nos dio vida cuando levantó a Cristo de los muertos. (¡Es solo por la gracia de Dios que ustedes han sido salvados!)\")," + //Efesios 2:4-5 NTV
            "(578, 4, 49, 4, 2, \"Sean siempre humildes y amables. Sean pacientes unos con otros y tolérense las faltas por amor.\")," + //Efesios 4:2 NTV
            "(579, 4, 49, 4, 15, \"En cambio, hablaremos la verdad con amor y así creceremos en todo sentido hasta parecernos más y más a Cristo, quien es la cabeza de su cuerpo, que es la iglesia.\")," + //Efesios 4:15 NTV
            "(580, 4, 49, 5, 2, \"Vivan una vida llena de amor, siguiendo el ejemplo de Cristo. Él nos amó y se ofreció a sí mismo como sacrificio por nosotros, como aroma agradable a Dios.\")," + //Efesios 5:2 NTV
            "(581, 4, 49, 5, 25, \"Para los maridos, eso significa: ame cada uno a su esposa tal como Cristo amó a la iglesia. Él entregó su vida por ella.\")," + //Efesios 5:25 NTV
            "(582, 4, 45, 5, 5, \"Y esa esperanza no acabará en desilusión. Pues sabemos con cuánta ternura nos ama Dios, porque nos ha dado el Espíritu Santo para llenar nuestro corazón con su amor.\")," + //Romanos 5:5 NTV
            "(583, 4, 45, 8, 28, \"Y sabemos que Dios hace que todas las cosas cooperen para el bien de quienes lo aman y son llamados según el propósito que él tiene para ellos.\")," + //Romanos 8:28 NTV
            "(584, 4, 45, 8, 35, \"¿Acaso hay algo que pueda separarnos del amor de Cristo? ¿Será que él ya no nos ama si tenemos problemas o aflicciones, si somos perseguidos o pasamos hambre o estamos en la miseria o en peligro o bajo amenaza de muerte?\")," + //Romanos 8:35 NTV
            "(585, 4, 45, 8, 38, \"Y estoy convencido de que nada podrá jamás separarnos del amor de Dios. Ni la muerte ni la vida, ni ángeles ni demonios, ni nuestros temores de hoy ni nuestras preocupaciones de mañana. Ni siquiera los poderes del infierno pueden separarnos del amor de Dios. Ningún poder en las alturas ni en las profundidades, de hecho, nada en toda la creación podrá jamás separarnos del amor de Dios, que está revelado en Cristo Jesús nuestro Señor.\")," + //Romanos 8:38-39 NTV
            "(586, 4, 45, 12, 9, \"No finjan amar a los demás; ámenlos de verdad. Aborrezcan lo malo. Aférrense a lo bueno.\")," + //Romanos 12:9 NTV
            "(587, 4, 45, 12, 10, \"Ámense unos a otros con un afecto genuino y deléitense al honrarse mutuamente.\")," + //Romanos 12:10 NTV
            "(588, 4, 45, 13, 8, \"No deban nada a nadie, excepto el deber de amarse unos a otros. Si aman a su prójimo, cumplen con las exigencias de la ley de Dios.\")," + //Romanos 13:8 NTV
            "(589, 4, 45, 13, 9, \"Pues los mandamientos dicen: «No cometas adulterio. No mates. No robes. No codicies». Estos y otros mandamientos semejantes se resumen en uno solo: «Ama a tu prójimo como a ti mismo»\")," + //Romanos 13:9 NTV
            "(590, 4, 45, 13, 10, \"El amor no hace mal a otros, por eso el amor cumple con las exigencias de la ley de Dios.\")," + //Romanos 13:10 NTV
            "(591, 4, 43, 13, 34, \"Así que ahora les doy un nuevo mandamiento: ámense unos a otros. Tal como yo los he amado, ustedes deben amarse unos a otros.\")," + //Juan 13:34 NTV
            "(592, 4, 43, 13, 35, \"El amor que tengan unos por otros será la prueba ante el mundo de que son mis discípulos.\")," + //Juan 13:35 NTV
            "(593, 4, 43, 14, 15, \"Si me aman, obedezcan mis mandamientos.\")," + //Juan 14:15 NTV
            "(594, 4, 43, 14, 21, \"Los que aceptan mis mandamientos y los obedecen son los que me aman. Y, porque me aman a mí, mi Padre los amará a ellos. Y yo los amaré y me daré a conocer a cada uno de ellos.\")," + //Juan 14:21 NTV
            "(595, 4, 43, 14, 23, \"Jesús contestó:—Todos los que me aman harán lo que yo diga. Mi Padre los amará, y vendremos para vivir con cada uno de ellos.\")," + //Juan 14:23 NTV
            "(596, 4, 43, 15, 10, \"Cuando obedecen mis mandamientos, permanecen en mi amor, así como yo obedezco los mandamientos de mi Padre y permanezco en su amor.\")," + //Juan 15:10 NTV
            "(597, 4, 43, 15, 12, \"Este es mi mandamiento: ámense unos a otros de la misma manera en que yo los he amado.\")," + //Juan 15:12 NTV
            "(598, 4, 43, 15, 13, \"No hay un amor más grande que el dar la vida por los amigos.\")," + //Juan 15:13 NTV
            "(599, 4, 43, 17, 26, \"Yo te he dado a conocer a ellos y seguiré haciéndolo. Entonces tu amor por mí estará en ellos, y yo también estaré en ellos.\")," + //Juan 17:26 NTV
            "(600, 4, 23, 43, 4, \"Entregué a otros a cambio de ti. Cambié la vida de ellos por la tuya, porque eres muy precioso para mí. Recibes honra, y yo te amo.\")," + //Isaias 43:4 NTV
            "(601, 4, 52, 3, 12, \"Y que el Señor haga crecer y sobreabundar el amor que tienen unos por otros y por toda la gente, tanto como sobreabunda nuestro amor por ustedes.\")," + //1 Tesalonicenses 3:12 NTV
            "(602, 4, 53, 3, 5, \"Que el Señor les guíe el corazón a un entendimiento total y a una expresión plena del amor de Dios, y a la perseverancia con paciencia que proviene de Cristo.\")," + //2 Tesalonicenses 3:5 NTV
            "(603, 4, 48, 5, 6, \"Pues, una vez que depositamos nuestra fe en Cristo Jesús, de nada sirve estar o no circuncidado. Lo importante es la fe que se expresa por medio del amor.\")," + //Galatas 5:6 NTV
            "(604, 4, 48, 5, 13, \"Pues ustedes, mis hermanos, han sido llamados a vivir en libertad; pero no usen esa libertad para satisfacer los deseos de la naturaleza pecaminosa. Al contrario, usen la libertad para servirse unos a otros por amor.\")," + //Galatas 5:13 NTV
            "(605, 4, 48, 5, 14, \"Pues toda la ley puede resumirse en un solo mandato: «Ama a tu prójimo como a ti mismo»\")," + //Galatas 5:14 NTV
            "(606, 4, 48, 5, 22, \"En cambio, la clase de fruto que el Espíritu Santo produce en nuestra vida es: amor, alegría, paz, paciencia, gentileza, bondad, fidelidad, humildad y control propio. ¡No existen leyes contra esas cosas!\")," + //Galatas 5:22-23 NTV
            "(607, 4, 51, 3, 14, \"Sobre todo, vístanse de amor, lo cual nos une a todos en perfecta armonía.\")," + //Colosenses 3:14 NTV
            "(608, 4, 60, 4, 8, \"Lo más importante de todo es que sigan demostrando profundo amor unos a otros, porque el amor cubre gran cantidad de pecados.\")," + //1 Pedro 4:8 NTV
            "(609, 4, 41, 12, 30, \"Amarás al Señor tu Dios con todo tu corazón, con toda tu alma, con toda tu mente y con todas tus fuerzas.\")," + //Marcos 12:30 NTV
            "(610, 4, 41, 12, 31, \"El segundo es igualmente importante: “Amarás a tu prójimo como a ti mismo”. Ningún otro mandamiento es más importante que estos.\")," + //Marcos 12:31 NTV
            "(611, 4, 54, 4, 12, \"No permitas que nadie te subestime por ser joven. Sé un ejemplo para todos los creyentes en lo que dices, en la forma en que vives, en tu amor, tu fe y tu pureza.\")," + //1 Timoteo 4:12 NTV
            "(612, 4, 55, 1, 7, \"Pues Dios no nos ha dado un espíritu de temor y timidez sino de poder, amor y autodisciplina.\")," + //2 Timoteo 1:7 NTV
            "(613, 4, 40, 5, 44, \"Pero yo digo: ¡ama a tus enemigos! ¡Ora por los que te persiguen!\")," + //Mateo 5:44 NTV
            "(614, 4, 42, 10, 27, \"El hombre contestó: —“Amarás al Señor tu Dios con todo tu corazón, con toda tu alma, con toda tu fuerza y con toda tu mente” y “Amarás a tu prójimo como a ti mismo”.\")," + //Lucas 10:27 NTV
            "(615, 4, 65, 1, 2, \"Que Dios les dé cada vez más misericordia, paz y amor.\")," + //Judas 1:2 NTV
            "(616, 4, 58, 13, 1, \"Sigan amándose unos a otros como hermanos.\")," + //Hebreos 13:1 NTV
            "(617, 4, 66, 3, 19, \"Yo corrijo y disciplino a todos los que amo. Por lo tanto, sé diligente y arrepiéntete de tu indiferencia.\")," + //Apocalipsis 3:19 NTV
            "(618, 4, 5, 6, 5, \"Ama al Señor tu Dios con todo tu corazón, con toda tu alma y con todas tus fuerzas.\")," + //Deuteronomio 6:5 NTV
            "(619, 4, 22, 8, 6, \"Ponme como un sello sobre tu corazón, como un sello sobre tu brazo. Pues el amor es tan fuerte como la muerte, y sus celos, tan duraderos como la tumba. El amor destella como el fuego con la llama más intensa.\")"; //Cantares 8:6 NTV

    public static final String INSERT_VERSICULO_TEMA_AMOR_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(620, 5, 62, 2, 15, \"Love not the world, neither the things that are in the world. If any man love the world, the love of the Father is not in him.\")," + //1 John 2:15 KJV
            "(621, 5, 62, 3, 1, \"Behold, what manner of love the Father hath bestowed upon us, that we should be called the sons of God: therefore the world knoweth us not, because it knew him not.\")," + //1 John 3:1 KJV
            "(622, 5, 62, 3, 11, \"For this is the message that ye heard from the beginning, that we should love one another.\")," + //1 John 3:11 KJV
            "(623, 5, 62, 3, 16, \"Hereby perceive we the love of God, because he laid down his life for us: and we ought to lay down our lives for the brethren.\")," + //1 John 3:16 KJV
            "(624, 5, 62, 4, 7, \"Beloved, let us love one another: for love is of God; and every one that loveth is born of God, and knoweth God.\")," + //1 John 4:7 KJV
            "(625, 5, 62, 4, 8, \"He that loveth not knoweth not God; for God is love.\")," + //1 John 4:8 KJV
            "(626, 5, 62, 4, 9, \"In this was manifested the love of God toward us, because that God sent his only begotten Son into the world, that we might live through him.\")," + //1 John 4:9 KJV
            "(627, 5, 62, 4, 10, \"Herein is love, not that we loved God, but that he loved us, and sent his Son to be the propitiation for our sins.\")," + //1 John 4:10 KJV
            "(628, 5, 62, 4, 11, \"Beloved, if God so loved us, we ought also to love one another.\")," + //1 John 4:11 KJV
            "(629, 5, 62, 4, 12, \"No man hath seen God at any time. If we love one another, God dwelleth in us, and his love is perfected in us.\")," + //1 John 4:12 KJV
            "(630, 5, 62, 4, 16, \"And we have known and believed the love that God hath to us. God is love; and he that dwelleth in love dwelleth in God, and God in him.\")," + //1 John 4:16 KJV
            "(631, 5, 62, 4, 18, \"There is no fear in love; but perfect love casteth out fear: because fear hath torment. He that feareth is not made perfect in love.\")," + //1 John 4:18 KJV
            "(632, 5, 62, 4, 19, \"We love him, because he first loved us.\")," + //1 John 4:19 KJV
            "(633, 5, 62, 4, 20, \"If a man say, I love God, and hateth his brother, he is a liar: for he that loveth not his brother whom he hath seen, how can he love God whom he hath not seen?\")," + //1 John 4:20 KJV
            "(634, 5, 62, 4, 21, \"And this commandment have we from him, That he who loveth God love his brother also.\")," + //1 John 4:21 KJV
            "(635, 5, 19, 33, 5, \"He loveth righteousness and judgment: the earth is full of the goodness of the Lord.\")," + //Psalms 33:5 KJV
            "(636, 5, 19, 116, 1, \"I love the Lord, because he hath heard my voice and my supplications.\")," + //Psalms 116:1 KJV
            "(637, 5, 20, 3, 12, \"For whom the Lord loveth he correcteth; even as a father the son in whom he delighteth.\")," + //Proverbs 3:12 KJV
            "(638, 5, 20, 10, 12, \"Hatred stirreth up strifes: but love covereth all sins.\")," + //Proverbs 10:12 KJV
            "(639, 5, 46, 2, 9, \"But as it is written, Eye hath not seen, nor ear heard, neither have entered into the heart of man, the things which God hath prepared for them that love him.\")," + //1 Corinthians 2:9 KJV
            "(640, 5, 46, 13, 1, \"Though I speak with the tongues of men and of angels, and have not charity, I am become as sounding brass, or a tinkling cymbal.\")," + //1 Corinthians 13:1 KJV
            "(641, 5, 46, 13, 2, \"And though I have the gift of prophecy, and understand all mysteries, and all knowledge; and though I have all faith, so that I could remove mountains, and have not charity, I am nothing.\")," + //1 Corinthians 13:2 KJV
            "(642, 5, 46, 13, 3, \"And though I bestow all my goods to feed the poor, and though I give my body to be burned, and have not charity, it profiteth me nothing.\")," + //1 Corinthians 13:3 KJV
            "(643, 5, 46, 13, 4, \"Charity suffereth long, and is kind; charity envieth not; charity vaunteth not itself, is not puffed up, Doth not behave itself unseemly, seeketh not her own, is not easily provoked, thinketh no evil; Rejoiceth not in iniquity, but rejoiceth in the truth; Beareth all things, believeth all things, hopeth all things, endureth all things.\")," + //1 Corinthians 13:4-7 KJV
            "(644, 5, 46, 13, 13, \"And now abideth faith, hope, charity, these three; but the greatest of these is charity.\")," + //1 Corinthians 13:13 KJV
            "(645, 5, 46, 16, 14, \"Let all your things be done with charity.\")," + //1 Corinthians 16:14 KJV
            "(646, 5, 47, 5, 14, \"For the love of Christ constraineth us; because we thus judge, that if one died for all, then were all dead: And that he died for all, that they which live should not henceforth live unto themselves, but unto him which died for them, and rose again.\")," + //2 Corinthians 5:14-15 KJV            "(647, 5, 49, 2, 4, \"But God, who is rich in mercy, for his great love wherewith he loved us, Even when we were dead in sins, hath quickened us together with Christ, (by grace ye are saved)\")," + //Ephesians 2:4-5 NTV
            "(648, 5, 49, 4, 2, \"With all lowliness and meekness, with longsuffering, forbearing one another in love.\")," + //Ephesians 4:2 KJV
            "(649, 5, 49, 4, 15, \"But speaking the truth in love, may grow up into him in all things, which is the head, even Christ.\")," + //Ephesians 4:15 KJV
            "(650, 5, 49, 5, 2, \"And walk in love, as Christ also hath loved us, and hath given himself for us an offering and a sacrifice to God for a sweetsmelling savour.\")," + //Ephesians 5:2 KJV
            "(651, 5, 49, 5, 25, \"Husbands, love your wives, even as Christ also loved the church, and gave himself for it.\")," + //Ephesians 5:25 KJV
            "(652, 5, 45, 5, 5, \"And hope maketh not ashamed; because the love of God is shed abroad in our hearts by the Holy Ghost which is given unto us.\")," + //Romans 5:5 KJV
            "(653, 5, 45, 8, 28, \"And we know that all things work together for good to them that love God, to them who are the called according to his purpose.\")," + //Romans 8:28 KJV
            "(654, 5, 45, 8, 35, \"Who shall separate us from the love of Christ? shall tribulation, or distress, or persecution, or famine, or nakedness, or peril, or sword?\")," + //Romans 8:35 KJV
            "(655, 5, 45, 8, 38, \"For I am persuaded, that neither death, nor life, nor angels, nor principalities, nor powers, nor things present, nor things to come, Nor height, nor depth, nor any other creature, shall be able to separate us from the love of God, which is in Christ Jesus our Lord.\")," + //Romans 8:38-39 KJV
            "(656, 5, 45, 12, 9, \"Let love be without dissimulation. Abhor that which is evil; cleave to that which is good.\")," + //Romans 12:9 KJV
            "(657, 5, 45, 12, 10, \"Be kindly affectioned one to another with brotherly love; in honour preferring one another.\")," + //Romans 12:10 KJV
            "(658, 5, 45, 13, 8, \"Owe no man any thing, but to love one another: for he that loveth another hath fulfilled the law.\")," + //Romans 13:8 KJV
            "(659, 5, 45, 13, 9, \"For this, Thou shalt not commit adultery, Thou shalt not kill, Thou shalt not steal, Thou shalt not bear false witness, Thou shalt not covet; and if there be any other commandment, it is briefly comprehended in this saying, namely, Thou shalt love thy neighbour as thyself.\")," + //Romans 13:9 KJV
            "(660, 5, 45, 13, 10, \"Love worketh no ill to his neighbour: therefore love is the fulfilling of the law.\")," + //Romans 13:10 KJV
            "(661, 5, 43, 13, 34, \"A new commandment I give unto you, That ye love one another; as I have loved you, that ye also love one another.\")," + //John 13:34 KJV
            "(662, 5, 43, 13, 35, \"By this shall all men know that ye are my disciples, if ye have love one to another.\")," + //John 13:35 KJV
            "(663, 5, 43, 14, 15, \"If ye love me, keep my commandments.\")," + //John 14:15 KJV
            "(664, 5, 43, 14, 21, \"He that hath my commandments, and keepeth them, he it is that loveth me: and he that loveth me shall be loved of my Father, and I will love him, and will manifest myself to him.\")," + //John 14:21 KJV
            "(665, 5, 43, 14, 23, \"Jesus answered and said unto him, If a man love me, he will keep my words: and my Father will love him, and we will come unto him, and make our abode with him.\")," + //John 14:23 KJV
            "(666, 5, 43, 15, 10, \"If ye keep my commandments, ye shall abide in my love; even as I have kept my Father's commandments, and abide in his love.\")," + //John 15:10 KJV
            "(667, 5, 43, 15, 12, \"This is my commandment, That ye love one another, as I have loved you.\")," + //John 15:12 KJV
            "(668, 5, 43, 15, 13, \"Greater love hath no man than this, that a man lay down his life for his friends.\")," + //John 15:13 KJV
            "(669, 5, 43, 17, 26, \"And I have declared unto them thy name, and will declare it: that the love wherewith thou hast loved me may be in them, and I in them.\")," + //John 17:26 KJV
            "(670, 5, 23, 43, 4, \"Since thou wast precious in my sight, thou hast been honourable, and I have loved thee: therefore will I give men for thee, and people for thy life.\")," + //Isaiah 43:4 KJV
            "(671, 5, 52, 3, 12, \"And the Lord make you to increase and abound in love one toward another, and toward all men, even as we do toward you.\")," + //1 Thessalonians 3:12 KJV
            "(672, 5, 53, 3, 5, \"And the Lord direct your hearts into the love of God, and into the patient waiting for Christ.\")," + //2 Thessalonians 3:5 KJV
            "(673, 5, 48, 5, 6, \"For in Jesus Christ neither circumcision availeth any thing, nor uncircumcision; but faith which worketh by love.\")," + //Galatians 5:6 KJV
            "(674, 5, 48, 5, 13, \"For, brethren, ye have been called unto liberty; only use not liberty for an occasion to the flesh, but by love serve one another.\")," + //Galatians 5:13 KJV
            "(675, 5, 48, 5, 14, \"For all the law is fulfilled in one word, even in this; Thou shalt love thy neighbour as thyself.\")," + //Galatians 5:14 KJV
            "(676, 5, 48, 5, 22, \"But the fruit of the Spirit is love, joy, peace, longsuffering, gentleness, goodness, faith, meekness, temperance: against such there is no law.\")," + //Galatians 5:22-23 KJV
            "(677, 5, 51, 3, 14, \"And above all these things put on charity, which is the bond of perfectness.\")," + //Colossians 3:14 KJV
            "(678, 5, 60, 4, 8, \"And above all things have fervent charity among yourselves: for charity shall cover the multitude of sins.\")," + //1 Peter 4:8 KJV
            "(679, 5, 41, 12, 30, \"And thou shalt love the Lord thy God with all thy heart, and with all thy soul, and with all thy mind, and with all thy strength: this is the first commandment.\")," + //Mark 12:30 KJV
            "(680, 5, 41, 12, 31, \"And the second is like, namely this, Thou shalt love thy neighbour as thyself. There is none other commandment greater than these.\")," + //Mark 12:31 KJV
            "(681, 5, 54, 4, 12, \"Let no man despise thy youth; but be thou an example of the believers, in word, in conversation, in charity, in spirit, in faith, in purity.\")," + //1 Timothy 4:12 KJV
            "(682, 5, 55, 1, 7, \"For God hath not given us the spirit of fear; but of power, and of love, and of a sound mind.\")," + //2 Timothy 1:7 KJV
            "(683, 5, 40, 5, 44, \"But I say unto you, Love your enemies, bless them that curse you, do good to them that hate you, and pray for them which despitefully use you, and persecute you.\")," + //Matthew 5:44 KJV
            "(684, 5, 42, 10, 27, \"And he answering said, Thou shalt love the Lord thy God with all thy heart, and with all thy soul, and with all thy strength, and with all thy mind; and thy neighbour as thyself.\")," + //Luke 10:27 KJV
            "(685, 5, 65, 1, 2, \"Mercy unto you, and peace, and love, be multiplied.\")," + //Jude 1:2 KJV
            "(686, 5, 58, 13, 1, \"Let brotherly love continue.\")," + //Hebrews 13:1 KJV
            "(687, 5, 66, 3, 19, \"As many as I love, I rebuke and chasten: be zealous therefore, and repent.\")," + //Revelation 3:19 KJV
            "(688, 5, 5, 6, 5, \"And thou shalt love the Lord thy God with all thine heart, and with all thy soul, and with all thy might.\")," + //Deuteronomy 6:5 KJV
            "(689, 5, 22, 8, 6, \"Set me as a seal upon thine heart, as a seal upon thine arm: for love is strong as death; jealousy is cruel as the grave: the coals thereof are coals of fire, which hath a most vehement flame.\")"; //Song of Solomon 8:6 KJV

    public static final String INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(690, 1, 14, 7, 14, \"Si se humillare mi pueblo, sobre el cual mi nombre es invocado, y oraren, y buscaren mi rostro, y se convirtieren de sus malos caminos; entonces yo oiré desde los cielos, y perdonaré sus pecados, y sanaré su tierra.\")," + //2 Crónicas 7:14 RVR60
            "(691, 1, 62, 1, 9, \"Si confesamos nuestros pecados, él es fiel y justo para perdonar nuestros pecados, y limpiarnos de toda maldad.\")," + //1 Juan 1:9 RVR60
            "(692, 1, 40, 4, 17, \"Desde entonces comenzó Jesús a predicar, y a decir: Arrepentíos, porque el reino de los cielos se ha acercado.\")," + //Mateo 4:17 RVR60
            "(693, 1, 40, 9, 13, \"Id, pues, y aprended lo que significa: Misericordia quiero, y no sacrificio. Porque no he venido a llamar a justos, sino a pecadores, al arrepentimiento.\")," + //Mateo 9:13 RVR60
            "(694, 1, 61, 3, 9, \"El Señor no retarda su promesa, según algunos la tienen por tardanza, sino que es paciente para con nosotros, no queriendo que ninguno perezca, sino que todos procedan al arrepentimiento.\")," + //2 Pedro 3:9 RVR60
            "(695, 1, 44, 2, 38, \"Pedro les dijo: Arrepentíos, y bautícese cada uno de vosotros en el nombre de Jesucristo para perdón de los pecados; y recibiréis el don del Espíritu Santo.\")," + //Hechos 2:38 RVR60
            "(696, 1, 44, 3, 19, \"Así que, arrepentíos y convertíos, para que sean borrados vuestros pecados; para que vengan de la presencia del Señor tiempos de refrigerio.\")," + //Hechos 3:19 RVR60
            "(697, 1, 59, 4, 8, \"Acercaos a Dios, y él se acercará a vosotros. Pecadores, limpiad las manos; y vosotros los de doble ánimo, purificad vuestros corazones.\")," + //Santiago 4:8 RVR60
            "(698, 1, 29, 2, 13, \"Rasgad vuestro corazón, y no vuestros vestidos, y convertíos a Jehová vuestro Dios; porque misericordioso es y clemente, tardo para la ira y grande en misericordia, y que se duele del castigo.\")," + //Joel 2:13 RVR60
            "(699, 1, 26, 18, 32, \"Porque no quiero la muerte del que muere, dice Jehová el Señor; convertíos, pues, y viviréis.\")," + //Ezequiel 18:32 RVR60
            "(700, 1, 40, 3, 8, \"Haced, pues, frutos dignos de arrepentimiento.\")," + //Mateo 3:8 RVR60
            "(701, 1, 44, 17, 30, \"Pero Dios, habiendo pasado por alto los tiempos de esta ignorancia, ahora manda a todos los hombres en todo lugar, que se arrepientan.\")," + //Hechos 17:30 RVR60
            "(702, 1, 14, 30, 9, \"Porque si os volviereis a Jehová, vuestros hermanos y vuestros hijos hallarán misericordia delante de los que los tienen cautivos, y volverán a esta tierra; porque Jehová vuestro Dios es clemente y misericordioso, y no apartará de vosotros su rostro, si vosotros os volviereis a él.\")," + //2 Crónicas 30:9 RVR60
            "(703, 1, 42, 15, 10, \"Así os digo que hay gozo delante de los ángeles de Dios por un pecador que se arrepiente.\")," + //Lucas 15:10 RVR60
            "(704, 1, 41, 1, 15, \"Diciendo: El tiempo se ha cumplido, y el reino de Dios se ha acercado; arrepentíos, y creed en el evangelio.\")," + //Marcos 1:15 RVR60
            "(705, 1, 20, 28, 13, \"El que encubre sus pecados no prosperará; Mas el que los confiesa y se aparta alcanzará misericordia.\")"; //Proverbios 28:13 RVR60

    public static final String INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(706, 2, 14, 7, 14, \"Si mi pueblo, que lleva mi nombre, se humilla y ora, y me busca y abandona su mala conducta, yo lo escucharé desde el cielo, perdonaré su pecado y restauraré su tierra.\")," + //2 Crónicas 7:14 NVI
            "(707, 2, 62, 1, 9, \"Si confesamos nuestros pecados, Dios, que es fiel y justo, nos los perdonará y nos limpiará de toda maldad.\")," + //1 Juan 1:9 NVI
            "(708, 2, 40, 4, 17, \"Desde entonces comenzó Jesús a predicar: «Arrepiéntanse, porque el reino de los cielos está cerca».\")," + //Mateo 4:17 NVI
            "(709, 2, 40, 9, 13, \"Pero vayan y aprendan qué significa esto: “Lo que pido de ustedes es misericordia y no sacrificios”. Porque no he venido a llamar a justos, sino a pecadores.\")," + //Mateo 9:13 NVI
            "(710, 2, 61, 3, 9, \"El Señor no tarda en cumplir su promesa, según entienden algunos la tardanza. Más bien, él tiene paciencia con ustedes, porque no quiere que nadie perezca, sino que todos se arrepientan.\")," + //2 Pedro 3:9 NVI
            "(711, 2, 44, 2, 38, \"―Arrepiéntase y bautícese cada uno de ustedes en el nombre de Jesucristo para perdón de sus pecados —les contestó Pedro—, y recibirán el don del Espíritu Santo.\")," + //Hechos 2:38 NVI
            "(712, 2, 44, 3, 19, \"Por tanto, para que sean borrados sus pecados, arrepiéntanse y vuélvanse a Dios, a fin de que vengan tiempos de descanso de parte del Señor.\")," + //Hechos 3:19 NVI
            "(713, 2, 59, 4, 8, \"Acérquense a Dios, y él se acercará a ustedes. ¡Pecadores, límpiense las manos! ¡Ustedes los inconstantes, purifiquen su corazón!\")," + //Santiago 4:8 NVI
            "(714, 2, 29, 2, 13, \"Rásguense el corazón y no las vestiduras. Vuélvanse al Señor su Dios, porque él es bondadoso y compasivo, lento para la ira y lleno de amor, cambia de parecer y no castiga.\")," + //Joel 2:13 NVI
            "(715, 2, 26, 18, 32, \"Yo no quiero la muerte de nadie. ¡Conviértanse, y vivirán! Lo afirma el Señor omnipotente.\")," + //Ezequiel 18:32 NVI
            "(716, 2, 40, 3, 8, \"Produzcan frutos que demuestren arrepentimiento.\")," + //Mateo 3:8 NVI
            "(717, 2, 44, 17, 30, \"Pues bien, Dios pasó por alto aquellos tiempos de tal ignorancia, pero ahora manda a todos, en todas partes, que se arrepientan.\")," + //Hechos 17:30 NVI
            "(718, 2, 14, 30, 9, \"Si se vuelven al Señor, sus hermanos y sus hijos serán tratados con benevolencia por aquellos que los tienen cautivos, y podrán regresar a esta tierra. El Señor su Dios es compasivo y misericordioso. Si ustedes se vuelven a él, jamás los abandonará.\")," + //2 Crónicas 30:9 NVI
            "(719, 2, 42, 15, 10, \"Les digo que así mismo se alegra Dios con sus ángeles por un pecador que se arrepiente.\")," + //Lucas 15:10 NVI
            "(720, 2, 41, 1, 15, \"«Se ha cumplido el tiempo —decía—. El reino de Dios está cerca. ¡Arrepiéntanse y crean las buenas nuevas!»\")," + //Marcos 1:15 NVI
            "(721, 2, 20, 28, 13, \"Quien encubre su pecado jamás prospera; quien lo confiesa y lo deja halla perdón.\")"; //Proverbios 28:13 NVI

    public static final String INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(722, 3, 14, 7, 14, \"Pero si mi pueblo se humilla, y ora y me busca, y si al mismo tiempo abandona su mala conducta, yo escucharé en el cielo su oración, perdonaré sus pecados y los haré prosperar de nuevo.\")," + //2 Crónicas 7:14 TLA
            "(723, 3, 62, 1, 9, \"Pero si reconocemos ante Dios que hemos pecado, podemos estar seguros de que él, que es justo, nos perdonará y nos limpiará de toda maldad.\")," + //1 Juan 1:9 TLA
            "(724, 3, 40, 4, 17, \"Desde entonces, Jesús comenzó a decirles a todos: «Vuélvanse a Dios, porque su reino se va a establecer aquí».\")," + //Mateo 4:17 TLA
            "(725, 3, 40, 9, 13, \"Mejor vayan y traten de averiguar lo que Dios quiso decir con estas palabras: “Prefiero que sean compasivos con la gente, y no que me traigan ofrendas”. Yo vine a invitar a los pecadores para que sean mis discípulos, no a los que se creen buenos.\")," + //Mateo 9:13 TLA
            "(726, 3, 61, 3, 9, \"No es que Dios sea lento para cumplir su promesa, como algunos piensan. Lo que pasa es que Dios tiene paciencia con ustedes, porque él no quiere que nadie muera, sino que todos vuelvan a obedecerle.\")," + //2 Pedro 3:9 TLA
            "(727, 3, 44, 2, 38, \"Pedro les contestó: —Pídanle perdón a Dios, vuelvan a obedecerlo, y dejen que nosotros los bauticemos en el nombre de Jesucristo. Así Dios los perdonará y les dará el Espíritu Santo.\")," + //Hechos 2:38 TLA
            "(728, 3, 44, 3, 19, \"Por eso, dejen de pecar y vuelvan a obedecer a Dios. Así él olvidará todo lo malo que ustedes han hecho, les dará nuevas fuerzas.\")," + //Hechos 3:19 TLA
            "(729, 3, 59, 4, 8, \"Háganse amigos de Dios, y él se hará amigo de ustedes. ¡Pecadores, dejen de hacer el mal! Los que quieren amar a Dios, pero también quieren pecar, deben tomar una decisión: o Dios, o el mundo de pecado.\")," + //Santiago 4:8 TLA
            "(730, 3, 29, 2, 13, \"¡Arrepiéntanse y vuelvan a mí, pero háganlo de todo corazón, y no sólo de palabra! Yo soy tierno y bondadoso, y no me enojo fácilmente; yo los amo mucho y estoy dispuesto a perdonarlos”.\")," + //Joel 2:13 TLA
            "(731, 3, 26, 18, 32, \"¡Yo no quiero que mueran! ¡Apártense de la maldad, y vivirán! Yo soy el Dios de Israel, y cumpliré mi palabra.\")," + //Ezequiel 18:32 TLA
            "(732, 3, 40, 3, 8, \"Demuestren con su conducta que han dejado de pecar.\")," + //Mateo 3:8 TLA
            "(733, 3, 44, 17, 30, \"Durante mucho tiempo Dios perdonó a los que hacían todo eso, porque no sabían lo que hacían; pero ahora Dios ordena que todos los que habitan este mundo se arrepientan, y que lo obedezcan sólo a él.\")," + //Hechos 17:30 TLA
            "(734, 3, 14, 30, 9, \"Si ustedes vuelven a obedecer a Dios, él hará que sus enemigos dejen en libertad a los israelitas que fueron llevados prisioneros. Nuestro Dios es bueno y muy amoroso; si lo buscan, no los rechazará.\")," + //2 Crónicas 30:9 TLA
            "(735, 3, 42, 15, 10, \"De la misma manera, los ángeles de Dios hacen fiesta cuando alguien se vuelve a Dios.\")," + //Lucas 15:10 TLA
            "(736, 3, 41, 1, 15, \"«¡Ya está cerca el día en que Dios comenzará a reinar! Vuélvanse a Dios y crean en la buena noticia.»\")," + //Marcos 1:15 TLA
            "(737, 3, 20, 28, 13, \"Quien esconde su pecado jamás puede prosperar; quien lo confiesa y lo deja, recibe el perdón.\")"; //Proverbios 28:13 TLA

    public static final String INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(738, 4, 14, 7, 14, \"Pero si mi pueblo, que lleva mi nombre, se humilla y ora, busca mi rostro y se aparta de su conducta perversa, yo oiré desde el cielo, perdonaré sus pecados y restauraré su tierra.\")," + //2 Crónicas 7:14 NTV
            "(739, 4, 62, 1, 9, \"Pero si confesamos nuestros pecados a Dios, él es fiel y justo para perdonarnos nuestros pecados y limpiarnos de toda maldad.\")," + //1 Juan 1:9 NTV
            "(740, 4, 40, 4, 17, \"A partir de entonces, Jesús comenzó a predicar: «Arrepiéntanse de sus pecados y vuelvan a Dios, porque el reino del cielo está cerca».\")," + //Mateo 4:17 NTV
            "(741, 4, 40, 9, 13, \"Luego añadió: «Ahora vayan y aprendan el significado de la siguiente Escritura: “Quiero que tengan compasión, no que ofrezcan sacrificios”. Pues no he venido a llamar a los que se creen justos, sino a los que saben que son pecadores».\")," + //Mateo 9:13 NTV
            "(742, 4, 61, 3, 9, \"En realidad, no es que el Señor sea lento para cumplir su promesa, como algunos piensan. Al contrario, es paciente por amor a ustedes. No quiere que nadie sea destruido, quiere que todos se arrepientan.\")," + //2 Pedro 3:9 NTV
            "(743, 4, 44, 2, 38, \"Pedro contestó: —Cada uno de ustedes debe arrepentirse de sus pecados y volver a Dios, y ser bautizado en el nombre de Jesucristo para el perdón de sus pecados. Entonces recibirán el regalo del Espíritu Santo.\")," + //Hechos 2:38 NTV
            "(744, 4, 44, 3, 19, \"Ahora pues, arrepiéntanse de sus pecados y vuelvan a Dios para que sus pecados sean borrados.\")," + //Hechos 3:19 NTV
            "(745, 4, 59, 4, 8, \"Acérquense a Dios, y Dios se acercará a ustedes. Lávense las manos, pecadores; purifiquen su corazón, porque su lealtad está dividida entre Dios y el mundo.\")," + //Santiago 4:8 NTV
            "(746, 4, 29, 2, 13, \"No se desgarren la ropa en su dolor sino desgarren sus corazones. Regresen al SEÑOR su Dios, porque él es misericordioso y compasivo, lento para enojarse y lleno de amor inagotable. Está deseoso de desistir y no de castigar.\")," + //Joel 2:13 NTV
            "(747, 4, 26, 18, 32, \"No quiero que mueras, dice el SEÑOR Soberano. ¡Cambia de rumbo y vive!\")," + //Ezequiel 18:32 NTV
            "(748, 4, 40, 3, 8, \"Demuestren con su forma de vivir que se han arrepentido de sus pecados y han vuelto a Dios.\")," + //Mateo 3:8 NTV
            "(749, 4, 44, 17, 30, \"En la antigüedad Dios pasó por alto la ignorancia de la gente acerca de estas cosas, pero ahora él manda que todo el mundo en todas partes se arrepienta de sus pecados y vuelva a él.\")," + //Hechos 17:30 NTV
            "(750, 4, 14, 30, 9, \"»Pues si ustedes se vuelven al SEÑOR, sus parientes y sus hijos serán tratados con compasión por sus captores, y podrán regresar a esta tierra. El SEÑOR su Dios es bondadoso y misericordioso. Si ustedes se vuelven a él, él no seguirá apartando su rostro de ustedes».\")," + //2 Crónicas 30:9 NTV
            "(751, 4, 42, 15, 10, \"De la misma manera, hay alegría en presencia de los ángeles de Dios cuando un solo pecador se arrepiente.\")," + //Lucas 15:10 NTV
            "(752, 4, 41, 1, 15, \"«¡Por fin ha llegado el tiempo prometido por Dios! —anunciaba—. ¡El reino de Dios está cerca! ¡Arrepiéntanse de sus pecados y crean la Buena Noticia!».\")," + //Marcos 1:15 NTV
            "(753, 4, 20, 28, 13, \"Los que encubren sus pecados no prosperarán, pero si los confiesan y los abandonan, recibirán misericordia.\")"; //Proverbios 28:13 NTV

    public static final String INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(754, 5, 14, 7, 14, \"If my people, which are called by my name, shall humble themselves, and pray, and seek my face, and turn from their wicked ways; then will I hear from heaven, and will forgive their sin, and will heal their land.\")," + //2 Chronicles 7:14 KJV
            "(755, 5, 62, 1, 9, \"If we confess our sins, he is faithful and just to forgive us our sins, and to cleanse us from all unrighteousness.\")," + //1 John 1:9 KJV
            "(756, 5, 40, 4, 17, \"From that time Jesus began to preach, and to say, Repent: for the kingdom of heaven is at hand.\")," + //Matthew 4:17 KJV
            "(757, 5, 40, 9, 13, \"But go ye and learn what that meaneth, I will have mercy, and not sacrifice: for I am not come to call the righteous, but sinners to repentance.\")," + //Matthew 9:13 KJV
            "(758, 5, 61, 3, 9, \"The Lord is not slack concerning his promise, as some men count slackness; but is longsuffering to us-ward, not willing that any should perish, but that all should come to repentance.\")," + //2 Peter 3:9 KJV
            "(759, 5, 44, 2, 38, \"Then Peter said unto them, Repent, and be baptized every one of you in the name of Jesus Christ for the remission of sins, and ye shall receive the gift of the Holy Ghost.\")," + //Acts 2:38 KJV
            "(760, 5, 44, 3, 19, \"Repent ye therefore, and be converted, that your sins may be blotted out, when the times of refreshing shall come from the presence of the Lord.\")," + //Acts 3:19 KJV
            "(761, 5, 59, 4, 8, \"Draw nigh to God, and he will draw nigh to you. Cleanse your hands, ye sinners; and purify your hearts, ye double minded.\")," + //James 4:8 KJV
            "(762, 5, 29, 2, 13, \"And rend your heart, and not your garments, and turn unto the Lord your God: for he is gracious and merciful, slow to anger, and of great kindness, and repenteth him of the evil.\")," + //Joel 2:13 KJV
            "(763, 5, 26, 18, 32, \"For I have no pleasure in the death of him that dieth, saith the Lord God: wherefore turn yourselves, and live ye.\")," + //Ezekiel 18:32 KJV
            "(764, 5, 40, 3, 8, \"Bring forth therefore fruits meet for repentance.\")," + //Matthew 3:8 KJV
            "(765, 5, 44, 17, 30, \"And the times of this ignorance God winked at; but now commandeth all men every where to repent.\")," + //Acts 17:30 KJV
            "(766, 5, 14, 30, 9, \"For if ye turn again unto the Lord, your brethren and your children shall find compassion before them that lead them captive, so that they shall come again into this land: for the Lord your God is gracious and merciful, and will not turn away his face from you, if ye return unto him.\")," + //2 Chronicles 30:9 KJV
            "(767, 4, 42, 15, 10, \"Likewise, I say unto you, there is joy in the presence of the angels of God over one sinner that repenteth.\")," + //Luke 15:10 KJV
            "(768, 5, 41, 1, 15, \"And saying, The time is fulfilled, and the kingdom of God is at hand: repent ye, and believe the gospel.\")," + //Mark 1:15 KJV
            "(769, 5, 20, 28, 13, \"He that covereth his sins shall not prosper: but whoso confesseth and forsaketh them shall have mercy.\")"; //Proverbs 28:13 KJV

    public static final String INSERT_VERSICULO_TEMA_PACIENCIA_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(770, 1, 19, 37, 7, \"Guarda silencio ante Jehová, y espera en él. No te alteres con motivo del que prospera en su camino, Por el hombre que hace maldades.\")," + //Salmos 37:7 RVR60
            "(771, 1, 20, 14, 29, \"El que tarda en airarse es grande de entendimiento; Mas el que es impaciente de espíritu enaltece la necedad.\")," + //Proverbios 14:29 RVR60
            "(772, 1, 20, 16, 32, \"Mejor es el que tarda en airarse que el fuerte; Y el que se enseñorea de su espíritu, que el que toma una ciudad.\")," + //Proverbios 16:32 RVR60
            "(773, 1, 45, 8, 25, \"Pero si esperamos lo que no vemos, con paciencia lo aguardamos.\")," + //Romanos 8:25 RVR60
            "(774, 1, 45, 12, 12, \"Gozosos en la esperanza; sufridos en la tribulación; constantes en la oración.\")," + //Romanos 12:12 RVR60
            "(775, 1, 51, 3, 12, \"Vestíos, pues, como escogidos de Dios, santos y amados, de entrañable misericordia, de benignidad, de humildad, de mansedumbre, de paciencia.\")"; //Colosenses 3:12 RVR60

    public static final String INSERT_VERSICULO_TEMA_PACIENCIA_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(776, 2, 19, 37, 7, \"Guarda silencio ante el Señor, y espera en él con paciencia; no te irrites ante el éxito de otros, de los que maquinan planes malvados.\")," + //Salmos 37:7 NVI
            "(777, 2, 20, 14, 29, \"El que es paciente muestra gran discernimiento; el que es agresivo muestra mucha insensatez.\")," + //Proverbios 14:29 NVI
            "(778, 2, 20, 16, 32, \"Más vale ser paciente que valiente; más vale el dominio propio que conquistar ciudades.\")," + //Proverbios 16:32 NVI
            "(779, 2, 45, 8, 25, \"Pero, si esperamos lo que todavía no tenemos, en la espera mostramos nuestra constancia.\")," + //Romanos 8:25 NVI
            "(780, 2, 45, 12, 12, \"Alégrense en la esperanza, muestren paciencia en el sufrimiento, perseveren en la oración.\")," + //Romanos 12:12 NVI
            "(781, 2, 51, 3, 12, \"Por lo tanto, como escogidos de Dios, santos y amados, revístanse de afecto entrañable y de bondad, humildad, amabilidad y paciencia.\")"; //Colosenses 3:12 NVI

    public static final String INSERT_VERSICULO_TEMA_PACIENCIA_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(782, 3, 19, 37, 7, \"Calla en presencia de Dios, y espera paciente a que actúe; no te enojes por causa de los que prosperan ni por los que hacen planes malvados.\")," + //Salmos 37:7 TLA
            "(783, 3, 20, 14, 29, \"El sabio domina su enojo; el tonto no controla su violencia.\")," + //Proverbios 14:29 TLA
            "(784, 3, 20, 16, 32, \"Vale más ser paciente que valiente; vale más dominarse uno mismo que dominar a los demás.\")," + //Proverbios 16:32 TLA
            "(785, 3, 45, 8, 25, \"Sin embargo, si esperamos recibir algo que todavía no vemos, tenemos que esperarlo con paciencia.\")," + //Romanos 8:25 TLA
            "(786, 3, 45, 12, 12, \"Mientras esperan al Señor, muéstrense alegres; cuando sufran por el Señor, muéstrense pacientes; cuando oren al Señor, muéstrense constantes.\")," + //Romanos 12:12 TLA
            "(787, 3, 51, 3, 12, \"Dios los ama mucho a ustedes, y los ha elegido para que formen parte de su pueblo. Por eso, vivan como se espera de ustedes: amen a los demás, sean buenos, humildes, amables y pacientes.\")"; //Colosenses 3:12 TLA

    public static final String INSERT_VERSICULO_TEMA_PACIENCIA_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(788, 4, 19, 37, 7, \"Quédate quieto en la presencia del SEÑOR, y espera con paciencia a que él actúe. No te inquietes por la gente mala que prospera, ni te preocupes por sus perversas maquinaciones.\")," + //Salmos 37:7 NTV
            "(789, 4, 20, 14, 29, \"Los que tienen entendimiento no pierden los estribos; los que se enojan fácilmente demuestran gran necedad.\")," + //Proverbios 14:29 NTV
            "(790, 4, 20, 16, 32, \"Mejor es ser paciente que poderoso; más vale tener control propio que conquistar una ciudad.\")," + //Proverbios 16:32 NTV
            "(791, 4, 45, 8, 25, \"Pero si deseamos algo que todavía no tenemos, debemos esperar con paciencia y confianza.\")," + //Romanos 8:25 NTV
            "(792, 4, 45, 12, 12, \"Alégrense por la esperanza segura que tenemos. Tengan paciencia en las dificultades y sigan orando.\")," + //Romanos 12:12 NTV
            "(793, 4, 51, 3, 12, \"Dado que Dios los eligió para que sean su pueblo santo y amado por él, ustedes tienen que vestirse de tierna compasión, bondad, humildad, gentileza y paciencia.\")"; //Colosenses 3:12 NTV

    public static final String INSERT_VERSICULO_TEMA_PACIENCIA_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(794, 5, 19, 37, 7, \"Rest in the Lord, and wait patiently for him: fret not thyself because of him who prospereth in his way, because of the man who bringeth wicked devices to pass.\")," + //Psalms 37:7 KJV
            "(795, 5, 20, 14, 29, \"He that is slow to wrath is of great understanding: but he that is hasty of spirit exalteth folly.\")," + //Proverbs 14:29 KJV
            "(796, 5, 20, 16, 32, \"He that is slow to anger is better than the mighty; and he that ruleth his spirit than he that taketh a city.\")," + //Proverbs 16:32 KJV
            "(797, 5, 45, 8, 25, \"But if we hope for that we see not, then do we with patience wait for it.\")," + //Romans 8:25 KJV
            "(798, 5, 45, 12, 12, \"Rejoicing in hope; patient in tribulation; continuing instant in prayer.\")," + //Romans 12:12 KJV
            "(799, 5, 51, 3, 12, \"Put on therefore, as the elect of God, holy and beloved, bowels of mercies, kindness, humbleness of mind, meekness, longsuffering.\")"; //Colossians 3:12 KJV

    public static final String INSERT_VERSICULO_TEMA_PERDON_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(800, 1, 33, 7, 18, \"¿Qué Dios como tú, que perdona la maldad, y olvida el pecado del remanente de su heredad? No retuvo para siempre su enojo, porque se deleita en misericordia.\")," + //Miqueas 7:18 RVR60
            "(801, 1, 19, 32, 5, \"Mi pecado te declaré, y no encubrí mi iniquidad. Dije: Confesaré mis transgresiones a Jehová; Y tú perdonaste la maldad de mi pecado.\")," + //Salmos 32:5 RVR60
            "(802, 1, 19, 86, 5, \"Porque tú, Señor, eres bueno y perdonador, Y grande en misericordia para con todos los que te invocan.\")," + //Salmos 86:5 RVR60
            "(803, 1, 20, 17, 9, \"El que cubre la falta busca amistad; Mas el que la divulga, aparta al amigo.\")," + //Proverbios 17:9 RVR60
            "(804, 1, 20, 28, 13, \"El que encubre sus pecados no prosperará; Mas el que los confiesa y se aparta alcanzará misericordia.\")," + //Proverbios 28:13 RVR60
            "(805, 1, 40, 6, 12, \"Y perdónanos nuestras deudas, como también nosotros perdonamos a nuestros deudores.\")," + //Mateo 6:12 RVR60
            "(806, 1, 40, 6, 14, \"Porque si perdonáis a los hombres sus ofensas, os perdonará también a vosotros vuestro Padre celestial.\")," + //Mateo 6:14 RVR60
            "(807, 1, 42, 6, 37, \"No juzguéis, y no seréis juzgados; no condenéis, y no seréis condenados; perdonad, y seréis perdonados.\")," + //Lucas 6:37 RVR60
            "(808, 1, 44, 13, 38, \"Sabed, pues, esto, varones hermanos: que por medio de él se os anuncia perdón de pecados.\")," + //Hechos 13:38 RVR60
            "(809, 1, 49, 1, 7, \"En quien tenemos redención por su sangre, el perdón de pecados según las riquezas de su gracia.\")," + //Efesios 1:7 RVR60
            "(810, 1, 49, 4, 32, \"Antes sed benignos unos con otros, misericordiosos, perdonándoos unos a otros, como Dios también os perdonó a vosotros en Cristo.\")," + //Efesios 4:32 RVR60
            "(811, 1, 51, 3, 13, \"Soportándoos unos a otros, y perdonándoos unos a otros si alguno tuviere queja contra otro. De la manera que Cristo os perdonó, así también hacedlo vosotros.\")," + //Colosenses 3:13 RVR60
            "(812, 1, 62, 2, 2, \"Y él es la propiciación por nuestros pecados; y no solamente por los nuestros, sino también por los de todo el mundo.\")"; //1 Juan 2:2 RVR60

    public static final String INSERT_VERSICULO_TEMA_PERDON_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(813, 2, 33, 7, 18, \"¿Qué Dios hay como tú, que perdone la maldad y pase por alto el delito del remanente de su pueblo? No siempre estarás airado, porque tu mayor placer es amar.\")," + //Miqueas 7:18 NVI
            "(814, 2, 19, 32, 5, \"Pero te confesé mi pecado, y no te oculté mi maldad. Me dije: «Voy a confesar mis transgresiones al Señor», y tú perdonaste mi maldad y mi pecado.\")," + //Salmos 32:5 NVI
            "(815, 2, 19, 86, 5, \"Tú, Señor, eres bueno y perdonador; grande es tu amor por todos los que te invocan.\")," + //Salmos 86:5 NVI
            "(816, 2, 20, 17, 9, \"El que perdona la ofensa cultiva el amor; el que insiste en la ofensa divide a los amigos.\")," + //Proverbios 17:9 NVI
            "(817, 2, 20, 28, 13, \"Quien encubre su pecado jamás prospera; quien lo confiesa y lo deja halla perdón.\")," + //Proverbios 28:13 NVI
            "(818, 2, 40, 6, 12, \"Perdónanos nuestras deudas, como también nosotros hemos perdonado a nuestros deudores.\")," + //Mateo 6:12 NVI
            "(819, 2, 40, 6, 14, \"Porque, si perdonan a otros sus ofensas, también los perdonará a ustedes su Padre celestial.\")," + //Mateo 6:14 NVI
            "(820, 2, 42, 6, 37, \"No juzguen, y no se les juzgará. No condenen, y no se les condenará. Perdonen, y se les perdonará.\")," + //Lucas 6:37 NVI
            "(821, 2, 44, 13, 38, \"Por tanto, hermanos, sepan que por medio de Jesús se les anuncia a ustedes el perdón de los pecados.\")," + //Hechos 13:38 NVI
            "(822, 2, 49, 1, 7, \"En él tenemos la redención mediante su sangre, el perdón de nuestros pecados, conforme a las riquezas de la gracia.\")," + //Efesios 1:7 NVI
            "(823, 2, 49, 4, 32, \"Más bien, sean bondadosos y compasivos unos con otros, y perdónense mutuamente, así como Dios los perdonó a ustedes en Cristo.\")," + //Efesios 4:32 NVI
            "(824, 2, 51, 3, 13, \"De modo que se toleren unos a otros y se perdonen si alguno tiene queja contra otro. Así como el Señor los perdonó, perdonen también ustedes.\")," + //Colosenses 3:13 NVI
            "(825, 2, 62, 2, 2, \"Él es el sacrificio por el perdón de nuestros pecados, y no solo por los nuestros, sino por los de todo el mundo.\")"; //1 Juan 2:2 NVI

    public static final String INSERT_VERSICULO_TEMA_PERDON_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(826, 3, 33, 7, 18, \"No hay otro Dios como tú. Somos pocos los que quedamos con vida. Tú perdonas nuestra maldad y olvidas nuestro pecado. Tan grande es tu amor por nosotros que tu enojo no dura para siempre.\")," + //Miqueas 7:18 TLA
            "(827, 3, 19, 32, 5, \"Pero te confesé mi pecado, y no oculté mi maldad. Me decidí a reconocer que había sido rebelde contigo, y tú, mi Dios, me perdonaste.\")," + //Salmos 32:5 TLA
            "(828, 3, 19, 86, 5, \"Dios mío, tú eres bueno y sabes perdonar; ¡qué grande es tu amor por los que te buscan!\")," + //Salmos 86:5 TLA
            "(829, 3, 20, 17, 9, \"Quien perdona gana un amigo; quien no perdona gana un enemigo.\")," + //Proverbios 17:9 TLA
            "(830, 3, 20, 28, 13, \"Quien esconde su pecado jamás puede prosperar; quien lo confiesa y lo deja, recibe el perdón.\")," + //Proverbios 28:13 TLA
            "(831, 3, 40, 6, 12, \"Perdona el mal que hacemos, así como nosotros perdonamos a los que nos hacen mal.\")," + //Mateo 6:12 TLA
            "(832, 3, 40, 6, 14, \"Si ustedes perdonan a otros el mal que les han hecho, Dios, su Padre que está en el cielo, los perdonará a ustedes.\")," + //Mateo 6:14 TLA
            "(833, 3, 42, 6, 37, \"Jesús también les dijo: «No se conviertan en jueces de los demás, y Dios no los juzgará a ustedes. No sean duros con los demás, y Dios no será duro con ustedes. Perdonen a los demás y Dios los perdonará a ustedes.\")," + //Lucas 6:37 TLA
            "(834, 3, 44, 13, 38, \"Amigos israelitas, éste es el mensaje que anunciamos: ¡Jesús puede perdonarles sus pecados! La ley de Moisés no puede librarlos de todos sus pecados.\")," + //Hechos 13:38 TLA
            "(835, 3, 49, 1, 7, \"Por la muerte de Cristo en la cruz, Dios perdonó nuestros pecados y nos liberó de toda culpa. Esto lo hizo por su inmenso amor. Por su gran sabiduría y conocimiento.\")," + //Efesios 1:7 TLA
            "(836, 3, 49, 4, 32, \"Por el contrario, sean buenos y compasivos los unos con los otros, y perdónense, así como Dios los perdonó a ustedes por medio de Cristo.\")," + //Efesios 4:32 TLA
            "(837, 3, 51, 3, 13, \"Sean tolerantes los unos con los otros, y si alguien tiene alguna queja contra otro, perdónense, así como el Señor los ha perdonado a ustedes.\")," + //Colosenses 3:13 TLA
            "(838, 3, 62, 2, 2, \"Dios perdona nuestros pecados, y los de todo el mundo, porque Cristo se ofreció voluntariamente para morir por nosotros.\")"; //1 Juan 2:2 TLA

    public static final String INSERT_VERSICULO_TEMA_PERDON_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(839, 4, 33, 7, 18, \"¿Dónde hay otro Dios como tú, que perdona la culpa del remanente y pasa por alto los pecados de su preciado pueblo? No seguirás enojado con tu pueblo para siempre, porque tú te deleitas en mostrar tu amor inagotable.\")," + //Miqueas 7:18 NTV
            "(840, 4, 19, 32, 5, \"Finalmente te confesé todos mis pecados y ya no intenté ocultar mi culpa. Me dije: «Le confesaré mis rebeliones al SEÑOR», ¡y tú me perdonaste! Toda mi culpa desapareció.\")," + //Salmos 32:5 NTV
            "(841, 4, 19, 86, 5, \"¡Oh Señor, eres tan bueno, estás tan dispuesto a perdonar, tan lleno de amor inagotable para los que piden tu ayuda!\")," + //Salmos 86:5 NTV
            "(842, 4, 20, 17, 9, \"Cuando se perdona una falta, el amor florece, pero mantenerla presente separa a los amigos íntimos.\")," + //Proverbios 17:9 NTV
            "(843, 4, 20, 28, 13, \"Los que encubren sus pecados no prosperarán, pero si los confiesan y los abandonan, recibirán misericordia.\")," + //Proverbios 28:13 NTV
            "(844, 4, 40, 6, 12, \"Y perdónanos nuestros pecados, así como hemos perdonado a los que pecan contra nosotros.\")," + //Mateo 6:12 NTV
            "(845, 4, 40, 6, 14, \"Si perdonas a los que pecan contra ti, tu Padre celestial te perdonará a ti.\")," + //Mateo 6:14 NTV
            "(846, 4, 42, 6, 37, \"No juzguen a los demás, y no serán juzgados. No condenen a otros, para que no se vuelva en su contra. Perdonen a otros, y ustedes serán perdonados.\")," + //Lucas 6:37 NTV
            "(847, 4, 44, 13, 38, \"Hermanos, ¡escuchen! Estamos aquí para proclamar que, por medio de este hombre Jesús, ustedes tienen el perdón de sus pecados.\")," + //Hechos 13:38 NTV
            "(848, 4, 49, 1, 7, \"Dios es tan rico en gracia y bondad que compró nuestra libertad con la sangre de su Hijo y perdonó nuestros pecados.\")," + //Efesios 1:7 NTV
            "(849, 4, 49, 4, 32, \"Por el contrario, sean amables unos con otros, sean de buen corazón, y perdónense unos a otros, tal como Dios los ha perdonado a ustedes por medio de Cristo.\")," + //Efesios 4:32 NTV
            "(850, 4, 51, 3, 13, \"Sean comprensivos con las faltas de los demás y perdonen a todo el que los ofenda. Recuerden que el Señor los perdonó a ustedes, así que ustedes deben perdonar a otros.\")," + //Colosenses 3:13 NTV
            "(851, 4, 62, 2, 2, \"Él mismo es el sacrificio que pagó por nuestros pecados, y no solo los nuestros sino también los de todo el mundo.\")"; //1 Juan 2:2 NTV

    public static final String INSERT_VERSICULO_TEMA_PERDON_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(852, 5, 33, 7, 18, \"Who is a God like unto thee, that pardoneth iniquity, and passeth by the transgression of the remnant of his heritage? he retaineth not his anger for ever, because he delighteth in mercy.\")," + //Micah 7:18 KJV
            "(853, 5, 19, 32, 5, \"I acknowledged my sin unto thee, and mine iniquity have I not hid. I said, I will confess my transgressions unto the Lord; and thou forgavest the iniquity of my sin.\")," + //Psalms 32:5 KJV
            "(854, 5, 19, 86, 5, \"For thou, Lord, art good, and ready to forgive; and plenteous in mercy unto all them that call upon thee.\")," + //Psalms 86:5 KJV
            "(855, 5, 20, 17, 9, \"He that covereth a transgression seeketh love; but he that repeateth a matter separateth very friends.\")," + //Proverbs 17:9 KJV
            "(856, 5, 20, 28, 13, \"He that covereth his sins shall not prosper: but whoso confesseth and forsaketh them shall have mercy.\")," + //Proverbs 28:13 KJV
            "(857, 5, 40, 6, 12, \"And forgive us our debts, as we forgive our debtors.\")," + //Matthew 6:12 KJV
            "(858, 5, 40, 6, 14, \"For if ye forgive men their trespasses, your heavenly Father will also forgive you.\")," + //Matthew 6:14 KJV
            "(859, 5, 42, 6, 37, \"Judge not, and ye shall not be judged: condemn not, and ye shall not be condemned: forgive, and ye shall be forgiven.\")," + //Luke 6:37 KJV
            "(860, 5, 44, 13, 38, \"Be it known unto you therefore, men and brethren, that through this man is preached unto you the forgiveness of sins.\")," + //Acts 13:38 KJV
            "(861, 5, 49, 1, 7, \"In whom we have redemption through his blood, the forgiveness of sins, according to the riches of his grace.\")," + //Ephesians 1:7 KJV
            "(862, 5, 49, 4, 32, \"And be ye kind one to another, tenderhearted, forgiving one another, even as God for Christ's sake hath forgiven you.\")," + //Ephesians 4:32 KJV
            "(863, 5, 51, 3, 13, \"Forbearing one another, and forgiving one another, if any man have a quarrel against any: even as Christ forgave you, so also do ye.\")," + //Colossians 3:13 KJV
            "(864, 5, 62, 2, 2, \"And he is the propitiation for our sins: and not for ours only, but also for the sins of the whole world.\")"; //1 John 2:2 KJV

    public static final String INSERT_VERSICULO_TEMA_HUMILDAD_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(865, 1, 19, 25, 8, \"Bueno y recto es Jehová; Por tanto, él enseñará a los pecadores el camino. Encaminará a los humildes por el juicio, Y enseñará a los mansos su carrera.\")," + //Salmos 25:8-9 RVR60
            "(866, 1, 19, 115, 1, \"No a nosotros, oh Jehová, no a nosotros, Sino a tu nombre da gloria, Por tu misericordia, por tu verdad.\")," + //Salmos 115:1 RVR60
            "(867, 1, 19, 149, 4, \"Porque Jehová tiene contentamiento en su pueblo; Hermoseará a los humildes con la salvación.\")," + //Salmos 149:4 RVR60
            "(868, 1, 20, 11, 2, \"Cuando viene la soberbia, viene también la deshonra; Mas con los humildes está la sabiduría.\")," + //Proverbios 11:2 RVR60
            "(869, 1, 20, 15, 33, \"El temor de Jehová es enseñanza de sabiduría; Y a la honra precede la humildad.\")," + //Proverbios 15:33 RVR60
            "(870, 1, 20, 18, 12, \"Antes del quebrantamiento se eleva el corazón del hombre, Y antes de la honra es el abatimiento.\")," + //Proverbios 18:12 RVR60
            "(871, 1, 20, 22, 4, \"Riquezas, honra y vida son la remuneración de la humildad y del temor de Jehová.\")," + //Proverbios 22:4 RVR60
            "(872, 1, 20, 29, 23, \"La soberbia del hombre le abate; Pero al humilde de espíritu sustenta la honra.\")," + //Proverbios 29:23 RVR60
            "(873, 1, 33, 6, 8, \"Oh hombre, él te ha declarado lo que es bueno, y qué pide Jehová de ti: solamente hacer justicia, y amar misericordia, y humillarte ante tu Dios.\")," + //Miqueas 6:8 RVR60
            "(874, 1, 40, 6, 2, \"Cuando, pues, des limosna, no hagas tocar trompeta delante de ti, como hacen los hipócritas en las sinagogas y en las calles, para ser alabados por los hombres; de cierto os digo que ya tienen su recompensa.\")," + //Mateo 6:2 RVR60
            "(875, 1, 40, 11, 29, \"Llevad mi yugo sobre vosotros, y aprended de mí, que soy manso y humilde de corazón; y hallaréis descanso para vuestras almas; porque mi yugo es fácil, y ligera mi carga.\")," + //Mateo 11:29-30 RVR60
            "(876, 1, 41, 9, 35, \"Entonces él se sentó y llamó a los doce, y les dijo: Si alguno quiere ser el primero, será el postrero de todos, y el servidor de todos.\")," + //Marcos 9:35 RVR60
            "(877, 1, 41, 10, 45, \"Porque el Hijo del Hombre no vino para ser servido, sino para servir, y para dar su vida en rescate por muchos.\")," + //Marcos 10:45 RVR60
            "(878, 1, 42, 9, 48, \"Y les dijo: Cualquiera que reciba a este niño en mi nombre, a mí me recibe; y cualquiera que me recibe a mí, recibe al que me envió; porque el que es más pequeño entre todos vosotros, ése es el más grande.\")," + //Lucas 9:48 RVR60
            "(879, 1, 43, 13, 14, \"Pues si yo, el Señor y el Maestro, he lavado vuestros pies, vosotros también debéis lavaros los pies los unos a los otros.\")," + //Juan 13:14 RVR60
            "(880, 1, 45, 12, 16, \"Unánimes entre vosotros; no altivos, sino asociándoos con los humildes. No seáis sabios en vuestra propia opinión.\")," + //Romanos 12:16 RVR60
            "(881, 1, 48, 5, 13, \"Porque vosotros, hermanos, a libertad fuisteis llamados; solamente que no uséis la libertad como ocasión para la carne, sino servíos por amor los unos a los otros.\")," + //Galatas 5:13 RVR60
            "(882, 1, 50, 2, 3, \"Nada hagáis por contienda o por vanagloria; antes bien con humildad, estimando cada uno a los demás como superiores a él mismo.\")," + //Filipenses 2:3 RVR60
            "(883, 1, 46, 1, 28, \"Y lo vil del mundo y lo menospreciado escogió Dios, y lo que no es, para deshacer lo que es, a fin de que nadie se jacte en su presencia.\")," + //1 Corintios 1:28-29 RVR60
            "(884, 1, 59, 3, 13, \"¿Quién es sabio y entendido entre vosotros? Muestre por la buena conducta sus obras en sabia mansedumbre.\")," + //Santiago 3:13 RVR60
            "(885, 1, 59, 4, 10, \"Humillaos delante del Señor, y él os exaltará.\")," + //Santiago 4:10 RVR60
            "(886, 1, 60, 3, 3, \"Vuestro atavío no sea el externo de peinados ostentosos, de adornos de oro o de vestidos lujosos, sino el interno, el del corazón, en el incorruptible ornato de un espíritu afable y apacible, que es de grande estima delante de Dios.\")," + //1 Pedro 3:3-4 RVR60
            "(887, 1, 60, 3, 8, \"Finalmente, sed todos de un mismo sentir, compasivos, amándoos fraternalmente, misericordiosos, amigables.\")," + //1 Pedro 3:8 RVR60
            "(888, 1, 60, 5, 6, \"Humillaos, pues, bajo la poderosa mano de Dios, para que él os exalte cuando fuere tiempo.\")"; //1 Pedro 5:6 RVR60

    public static final String INSERT_VERSICULO_TEMA_HUMILDAD_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(889, 2, 19, 25, 8, \"Bueno y justo es el Señor; por eso les muestra a los pecadores el camino. Él dirige en la justicia a los humildes, y les enseña su camino.\")," + //Salmos 25:8-9 NVI
            "(890, 2, 19, 115, 1, \"La gloria, Señor, no es para nosotros; no es para nosotros, sino para tu nombre, por causa de tu amor y tu verdad.\")," + //Salmos 115:1 NVI
            "(891, 2, 19, 149, 4, \"Porque el Señor se complace en su pueblo; a los humildes concede el honor de la victoria.\")," + //Salmos 149:4 NVI
            "(892, 2, 20, 11, 2, \"Con el orgullo viene el oprobio; con la humildad, la sabiduría.\")," + //Proverbios 11:2 NVI
            "(893, 2, 20, 15, 33, \"El temor del Señor imparte sabiduría; la humildad precede a la honra.\")," + //Proverbios 15:33 NVI
            "(894, 2, 20, 18, 12, \"Al fracaso lo precede la soberbia humana; a los honores los precede la humildad.\")," + //Proverbios 18:12 NVI
            "(895, 2, 20, 22, 4, \"Recompensa de la humildad y del temor del Señor son las riquezas, la honra y la vida.\")," + //Proverbios 22:4 NVI
            "(896, 2, 20, 29, 23, \"El altivo será humillado, pero el humilde será enaltecido.\")," + //Proverbios 29:23 NVI
            "(897, 2, 33, 6, 8, \"¡Ya se te ha declarado lo que es bueno! Ya se te ha dicho lo que de ti espera el Señor: Practicar la justicia, amar la misericordia, y humillarte ante tu Dios.\")," + //Miqueas 6:8 NVI
            "(898, 2, 40, 6, 2, \"Por eso, cuando des a los necesitados, no lo anuncies al son de trompeta, como lo hacen los hipócritas en las sinagogas y en las calles para que la gente les rinda homenaje. Les aseguro que ellos ya han recibido toda su recompensa.\")," + //Mateo 6:2 NVI
            "(899, 2, 40, 11, 29, \"Carguen con mi yugo y aprendan de mí, pues yo soy apacible y humilde de corazón, y encontrarán descanso para su alma. Porque mi yugo es suave y mi carga es liviana.\")," + //Mateo 11:29-30 NVI
            "(900, 2, 41, 9, 35, \"Entonces Jesús se sentó, llamó a los doce y les dijo: ―Si alguno quiere ser el primero, que sea el último de todos y el servidor de todos.\")," + //Marcos 9:35 NVI
            "(901, 2, 41, 10, 45, \"Porque ni aun el Hijo del hombre vino para que le sirvan, sino para servir y para dar su vida en rescate por muchos.\")," + //Marcos 10:45 NVI
            "(902, 2, 42, 9, 48, \"―El que recibe en mi nombre a este niño —les dijo—, me recibe a mí; y el que me recibe a mí, recibe al que me envió. El que es más insignificante entre todos ustedes, ese es el más importante.\")," + //Lucas 9:48 NVI
            "(903, 2, 43, 13, 14, \"Pues, si yo, el Señor y el Maestro, les he lavado los pies, también ustedes deben lavarse los pies los unos a los otros.\")," + //Juan 13:14 NVI
            "(904, 2, 45, 12, 16, \"Vivan en armonía los unos con los otros. No sean arrogantes, sino háganse solidarios con los humildes. No se crean los únicos que saben.\")," + //Romanos 12:16 NVI
            "(905, 2, 48, 5, 13, \"Les hablo así, hermanos, porque ustedes han sido llamados a ser libres; pero no se valgan de esa libertad para dar rienda suelta a sus pasiones. Más bien sírvanse unos a otros con amor.\")," + //Galatas 5:13 NVI
            "(906, 2, 50, 2, 3, \"No hagan nada por egoísmo o vanidad; más bien, con humildad consideren a los demás como superiores a ustedes mismos.\")," + //Filipenses 2:3 NVI
            "(907, 2, 46, 1, 28, \"También escogió Dios lo más bajo y despreciado, y lo que no es nada, para anular lo que es, a fin de que en su presencia nadie pueda jactarse.\")," + //1 Corintios 1:28-29 NVI
            "(908, 2, 59, 3, 13, \"¿Quién es sabio y entendido entre ustedes? Que lo demuestre con su buena conducta, mediante obras hechas con la humildad que le da su sabiduría.\")," + //Santiago 3:13 NVI
            "(909, 2, 59, 4, 10, \"Humíllense delante del Señor, y él los exaltará.\")," + //Santiago 4:10 NVI
            "(910, 2, 60, 3, 3, \"Que la belleza de ustedes no sea la externa, que consiste en adornos tales como peinados ostentosos, joyas de oro y vestidos lujosos. Que su belleza sea más bien la incorruptible, la que procede de lo íntimo del corazón y consiste en un espíritu suave y apacible. Esta sí que tiene mucho valor delante de Dios.\")," + //1 Pedro 3:3-4 NVI
            "(911, 2, 60, 3, 8, \"En fin, vivan en armonía los unos con los otros; compartan penas y alegrías, practiquen el amor fraternal, sean compasivos y humildes.\")," + //1 Pedro 3:8 NVI
            "(912, 2, 60, 5, 6, \"Humíllense, pues, bajo la poderosa mano de Dios, para que él los exalte a su debido tiempo.\")"; //1 Pedro 5:6 NVI

    public static final String INSERT_VERSICULO_TEMA_HUMILDAD_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(913, 3, 19, 25, 8, \"Dios mío, tú eres bueno y siempre actúas con justicia. Enseñas a los pecadores a hacer lo bueno; enseñas a los humildes a hacer lo bueno y lo justo.\")," + //Salmos 25:8-9 TLA
            "(914, 3, 19, 115, 1, \"Tú mereces alabanzas, Dios nuestro, y no nosotros; tú mereces alabanzas por tu amor y tu fidelidad.\")," + //Salmos 115:1 TLA
            "(915, 3, 19, 149, 4, \"Pues él se agrada de su pueblo y da la victoria a los humildes. ¡Alabémoslo con danzas! ¡Cantémosle himnos con música de arpas y panderos!\")," + //Salmos 149:4 TLA
            "(916, 3, 20, 11, 2, \"El orgulloso termina en la vergüenza, y el humilde llega a ser sabio.\")," + //Proverbios 11:2 TLA
            "(917, 3, 20, 15, 33, \"Quien obedece a Dios gana en sabiduría y disciplina; quien quiera recibir honores debe empezar por ser humilde.\")," + //Proverbios 15:33 TLA
            "(918, 3, 20, 18, 12, \"El orgullo acaba en fracaso; la honra comienza con la humildad.\")," + //Proverbios 18:12 TLA
            "(919, 3, 20, 22, 4, \"Humíllate y obedece a Dios, y recibirás riquezas, honra y vida.\")," + //Proverbios 22:4 TLA
            "(920, 3, 20, 29, 23, \"El orgulloso será humillado, y el humilde será alabado.\")," + //Proverbios 29:23 TLA
            "(921, 3, 33, 6, 8, \"Pero ya Dios les ha dicho qué es lo mejor que pueden hacer y lo que espera de ustedes. Es muy sencillo: Dios quiere que ustedes sean justos los unos con los otros, que sean bondadosos con los más débiles, y que lo adoren como su único Dios.\")," + //Miqueas 6:8 TLA
            "(922, 3, 40, 6, 2, \"Si alguno de ustedes ayuda a los pobres, no se ponga a publicarlo en las sinagogas ni en los lugares por donde pasa la gente; eso lo hacen los hipócritas, que quieren que la gente los alabe. Les aseguro que ése es el único premio que ustedes recibirán.\")," + //Mateo 6:2 TLA
            "(923, 3, 40, 11, 29, \"Obedezcan mis mandamientos y aprendan de mí, pues yo soy paciente y humilde de verdad. Conmigo podrán descansar. Lo que yo les impongo no es difícil de cumplir, ni es pesada la carga que les hago llevar.\")," + //Mateo 11:29-30 TLA
            "(924, 3, 41, 9, 35, \"Entonces Jesús se sentó, llamó a los doce discípulos y les dijo: «Si alguno de ustedes quiere ser el más importante, deberá ocupar el último lugar y ser el servidor de todos los demás.»\")," + //Marcos 9:35 TLA
            "(925, 3, 41, 10, 45, \"Yo, el Hijo del hombre, soy así. No vine a este mundo para que me sirvan, sino para servir a los demás. Vine para liberar a la gente que es esclava del pecado, y para lograrlo pagaré con mi vida.\")," + //Marcos 10:45 TLA
            "(926, 3, 42, 9, 48, \"Y les dijo: «Si alguno acepta a un niño como éste, me acepta a mí. Y si alguno me acepta a mí, acepta a Dios, que fue quien me envió. El más humilde de todos ustedes es la persona más importante.»\")," + //Lucas 9:48 TLA
            "(927, 3, 43, 13, 14, \"Pues si yo, su Señor y Maestro, les he lavado los pies, también ustedes deben lavarse los pies unos a otros.\")," + //Juan 13:14 TLA
            "(928, 3, 45, 12, 16, \"Vivan siempre en armonía. Y no sean orgullosos, sino traten como iguales a la gente humilde. No se crean más inteligentes que los demás.\")," + //Romanos 12:16 TLA
            "(929, 3, 48, 5, 13, \"Hermanos, Dios los llamó a ustedes a ser libres, pero no usen esa libertad como pretexto para hacer lo malo. Al contrario, ayúdense por amor los unos a los otros.\")," + //Galatas 5:13 TLA
            "(930, 3, 50, 2, 3, \"No hagan nada por orgullo o sólo por pelear. Al contrario, hagan todo con humildad, y vean a los demás como mejores a ustedes mismos.\")," + //Filipenses 2:3 TLA
            "(931, 3, 46, 1, 28, \"Dios eligió a los que, desde el punto de vista humano, son débiles, despreciables y de poca importancia, para que los que se creen muy importantes se den cuenta de que en realidad no lo son.\")," + //1 Corintios 1:28-29 TLA
            "(932, 3, 59, 3, 13, \"Si alguno de ustedes es sabio y entendido, demuéstrelo haciendo el bien y portándose con humildad.\")," + //Santiago 3:13 TLA
            "(933, 3, 59, 4, 10, \"Sean humildes delante del Señor, y él los premiará.\")," + //Santiago 4:10 TLA
            "(934, 3, 60, 3, 3, \"Que el adorno de ustedes no sea de cosas externas, como peinados exagerados, o con joyas de oro y vestidos lujosos. La belleza no depende de las apariencias, sino de lo que hay en el corazón. Así que, sean ustedes personas tranquilas y amables. Esta belleza nunca desaparece, y es muy valiosa delante de Dios.\")," + //1 Pedro 3:3-4 TLA
            "(935, 3, 60, 3, 8, \"En fin, todos ustedes deben vivir en armonía y amarse unos a otros. Pónganse de acuerdo en todo, para que permanezcan unidos. Sean buenos y humildes.\")," + //1 Pedro 3:8 TLA
            "(936, 3, 60, 5, 6, \"Por eso, sean humildes y acepten la autoridad de Dios, pues él es poderoso. Cuando llegue el momento oportuno, Dios los tratará como a gente importante.\")"; //1 Pedro 5:6 TLA

    public static final String INSERT_VERSICULO_TEMA_HUMILDAD_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(937, 4, 19, 25, 8, \"El SEÑOR es bueno y hace lo correcto; les muestra el buen camino a los que andan descarriados. Guía a los humildes para que hagan lo correcto; les enseña su camino.\")," + //Salmos 25:8-9 NTV
            "(938, 4, 19, 115, 1, \"No a nosotros, oh SEÑOR, no a nosotros sino a tu nombre le corresponde toda la gloria, por tu amor inagotable y tu fidelidad.\")," + //Salmos 115:1 NTV
            "(939, 4, 19, 149, 4, \"Porque el SEÑOR se deleita en su pueblo; él corona al humilde con victoria.\")," + //Salmos 149:4 NTV
            "(940, 4, 20, 11, 2, \"El orgullo lleva a la deshonra, pero con la humildad viene la sabiduría.\")," + //Proverbios 11:2 NTV
            "(941, 4, 20, 15, 33, \"El temor del SEÑOR enseña sabiduría; la humildad precede a la honra.\")," + //Proverbios 15:33 NTV
            "(942, 4, 20, 18, 12, \"La arrogancia va delante de la destrucción; la humildad precede al honor.\")," + //Proverbios 18:12 NTV
            "(943, 4, 20, 22, 4, \"La verdadera humildad y el temor del SEÑOR conducen a riquezas, a honor y a una larga vida.\")," + //Proverbios 22:4 NTV
            "(944, 4, 20, 29, 23, \"El orgullo termina en humillación, mientras que la humildad trae honra.\")," + //Proverbios 29:23 NTV
            "(945, 4, 33, 6, 8, \"¡No! Oh pueblo, el SEÑOR te ha dicho lo que es bueno, y lo que él exige de ti: que hagas lo que es correcto, que ames la compasión y que camines humildemente con tu Dios.\")," + //Miqueas 6:8 NTV
            "(946, 4, 40, 6, 2, \"Cuando le des a alguien que pasa necesidad, no hagas lo que hacen los hipócritas que tocan la trompeta en las sinagogas y en las calles para llamar la atención a sus actos de caridad. Les digo la verdad, no recibirán otra recompensa más que esa.\")," + //Mateo 6:2 NTV
            "(947, 4, 40, 11, 29, \"Pónganse mi yugo. Déjenme enseñarles, porque yo soy humilde y tierno de corazón, y encontrarán descanso para el alma. Pues mi yugo es fácil de llevar y la carga que les doy es liviana.\")," + //Mateo 11:29-30 NTV
            "(948, 4, 41, 9, 35, \"Jesús se sentó y llamó a los doce discípulos y dijo: «Quien quiera ser el primero, debe tomar el último lugar y ser el sirviente de todos los demás».\")," + //Marcos 9:35 NTV
            "(949, 4, 41, 10, 45, \"Pues ni aun el Hijo del Hombre vino para que le sirvan, sino para servir a otros y para dar su vida en rescate por muchos.\")," + //Marcos 10:45 NTV
            "(950, 4, 42, 9, 48, \"Luego les dijo: «Todo el que recibe de mi parte a un niño pequeño como este, me recibe a mí; y todo el que me recibe a mí, también recibe al Padre, quien me envió. El más insignificante entre ustedes es el más importante».\")," + //Lucas 9:48 NTV
            "(951, 4, 43, 13, 14, \"Y, dado que yo, su Señor y Maestro, les he lavado los pies, ustedes deben lavarse los pies unos a otros.\")," + //Juan 13:14 NTV
            "(952, 4, 45, 12, 16, \"Vivan en armonía unos con otros. No sean tan orgullosos como para no disfrutar de la compañía de la gente común. ¡Y no piensen que lo saben todo!\")," + //Romanos 12:16 NTV
            "(953, 4, 48, 5, 13, \"Pues ustedes, mis hermanos, han sido llamados a vivir en libertad; pero no usen esa libertad para satisfacer los deseos de la naturaleza pecaminosa. Al contrario, usen la libertad para servirse unos a otros por amor.\")," + //Galatas 5:13 NTV
            "(954, 4, 50, 2, 3, \"No sean egoístas; no traten de impresionar a nadie. Sean humildes, es decir, considerando a los demás como mejores que ustedes.\")," + //Filipenses 2:3 NTV
            "(955, 4, 46, 1, 28, \"Dios escogió lo despreciado por el mundo —lo que se considera como nada— y lo usó para convertir en nada lo que el mundo considera importante. Como resultado, nadie puede jamás jactarse en presencia de Dios.\")," + //1 Corintios 1:28-29 NTV
            "(956, 4, 59, 3, 13, \"Si ustedes son sabios y entienden los caminos de Dios, demuéstrenlo viviendo una vida honesta y haciendo buenas acciones con la humildad que proviene de la sabiduría.\")," + //Santiago 3:13 NTV
            "(957, 4, 59, 4, 10, \"Humíllense delante del Señor, y él los levantará con honor.\")," + //Santiago 4:10 NTV
            "(958, 4, 60, 3, 3, \"No se interesen tanto por la belleza externa: los peinados extravagantes, las joyas costosas o la ropa elegante. En cambio, vístanse con la belleza interior, la que no se desvanece, la belleza de un espíritu tierno y sereno, que es tan precioso a los ojos de Dios.\")," + //1 Pedro 3:3-4 NTV
            "(959, 4, 60, 3, 8, \"Por último, todos deben ser de un mismo parecer. Tengan compasión unos de otros. Ámense como hermanos y hermanas. Sean de buen corazón y mantengan una actitud humilde.\")," + //1 Pedro 3:8 NTV
            "(960, 4, 60, 5, 6, \"Así que humíllense ante el gran poder de Dios y, a su debido tiempo, él los levantará con honor.\")"; //1 Pedro 5:6 NTV

    public static final String INSERT_VERSICULO_TEMA_HUMILDAD_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(961, 5, 19, 25, 8, \"Good and upright is the Lord: therefore will he teach sinners in the way. The meek will he guide in judgment: and the meek will he teach his way.\")," + //Psalms 25:8-9 KJV
            "(962, 5, 19, 115, 1, \"Not unto us, O Lord, not unto us, but unto thy name give glory, for thy mercy, and for thy truth's sake.\")," + //Psalms 115:1 KJV
            "(963, 5, 19, 149, 4, \"For the Lord taketh pleasure in his people: he will beautify the meek with salvation.\n\")," + //Psalms 149:4 KJV
            "(964, 5, 20, 11, 2, \"When pride cometh, then cometh shame: but with the lowly is wisdom.\")," + //Proverbs 11:2 KJV
            "(965, 5, 20, 15, 33, \"The fear of the Lord is the instruction of wisdom; and before honour is humility.\")," + //Proverbs 15:33 KJV
            "(966, 5, 20, 18, 12, \"Before destruction the heart of man is haughty, and before honour is humility.\")," + //Proverbs 18:12 KJV
            "(967, 5, 20, 22, 4, \"By humility and the fear of the Lord are riches, and honour, and life.\")," + //Proverbs 22:4 KJV
            "(968, 5, 20, 29, 23, \"A man's pride shall bring him low: but honour shall uphold the humble in spirit.\")," + //Proverbs 29:23 KJV
            "(969, 5, 33, 6, 8, \"He hath shewed thee, O man, what is good; and what doth the Lord require of thee, but to do justly, and to love mercy, and to walk humbly with thy God?\")," + //Micah 6:8 KJV
            "(970, 5, 40, 6, 2, \"Therefore when thou doest thine alms, do not sound a trumpet before thee, as the hypocrites do in the synagogues and in the streets, that they may have glory of men. Verily I say unto you, They have their reward.\")," + //Matthew 6:2 KJV
            "(971, 5, 40, 11, 29, \"Take my yoke upon you, and learn of me; for I am meek and lowly in heart: and ye shall find rest unto your souls. For my yoke is easy, and my burden is light.\")," + //Matthew 11:29-30 KJV
            "(972, 5, 41, 9, 35, \"And he sat down, and called the twelve, and saith unto them, If any man desire to be first, the same shall be last of all, and servant of all.\")," + //Mark 9:35 KJV
            "(973, 5, 41, 10, 45, \"For even the Son of man came not to be ministered unto, but to minister, and to give his life a ransom for many.\")," + //Mark 10:45 KJV
            "(974, 5, 42, 9, 48, \"And said unto them, Whosoever shall receive this child in my name receiveth me: and whosoever shall receive me receiveth him that sent me: for he that is least among you all, the same shall be great.\")," + //Luke 9:48 KJV
            "(975, 5, 43, 13, 14, \"If I then, your Lord and Master, have washed your feet; ye also ought to wash one another's feet.\")," + //John 13:14 KJV
            "(976, 5, 45, 12, 16, \"Be of the same mind one toward another. Mind not high things, but condescend to men of low estate. Be not wise in your own conceits.\")," + //Romans 12:16 KJV
            "(977, 5, 48, 5, 13, \"For, brethren, ye have been called unto liberty; only use not liberty for an occasion to the flesh, but by love serve one another.\")," + //Galatians 5:13 KJV
            "(978, 5, 50, 2, 3, \"Let nothing be done through strife or vainglory; but in lowliness of mind let each esteem other better than themselves.\")," + //Philippians 2:3 KJV
            "(979, 5, 46, 1, 28, \"And base things of the world, and things which are despised, hath God chosen, yea, and things which are not, to bring to nought things that are: That no flesh should glory in his presence.\")," + //1 Corinthians 1:28-29 KJV
            "(980, 5, 59, 3, 13, \"Who is a wise man and endued with knowledge among you? let him shew out of a good conversation his works with meekness of wisdom.\")," + //James 3:13 KJV
            "(981, 5, 59, 4, 10, \"Humble yourselves in the sight of the Lord, and he shall lift you up.\")," + //James 4:10 KJV
            "(982, 5, 60, 3, 3, \"Whose adorning let it not be that outward adorning of plaiting the hair, and of wearing of gold, or of putting on of apparel; But let it be the hidden man of the heart, in that which is not corruptible, even the ornament of a meek and quiet spirit, which is in the sight of God of great price.\")," + //1 Peter 3:3-4 KJV
            "(983, 5, 60, 3, 8, \"Finally, be ye all of one mind, having compassion one of another, love as brethren, be pitiful, be courteous.\")," + //1 Peter 3:8 KJV
            "(984, 5, 60, 5, 6, \"Humble yourselves therefore under the mighty hand of God, that he may exalt you in due time.\")"; //1 Peter 5:6 KJV

    public static final String INSERT_VERSICULO_TEMA_SABIDURIA_RVR60_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(985, 1, 23, 28, 29, \"También esto salió de Jehová de los ejércitos, para hacer maravilloso el consejo y engrandecer la sabiduría.\")," + //Isaías 28:29 RVR60
            "(986, 1, 27, 2, 23, \"A ti, oh Dios de mis padres, te doy gracias y te alabo, porque me has dado sabiduría y fuerza, y ahora me has revelado lo que te pedimos; pues nos has dado a conocer el asunto del rey.\")," + //Daniel 2:23 RVR60
            "(987, 1, 21, 7, 10, \"Nunca digas: ¿Cuál es la causa de que los tiempos pasados fueron mejores que éstos? Porque nunca de esto preguntarás con sabiduría.\")," + //Eclesiastés 7:10 RVR60
            "(988, 1, 21, 10, 12, \"Las palabras de la boca del sabio son llenas de gracia, mas los labios del necio causan su propia ruina.\")," + //Eclesiastés 10:12 RVR60
            "(989, 1, 19, 90, 12, \"Enséñanos de tal modo a contar nuestros días, que traigamos al corazón sabiduría.\")," + //Salmos 90:12 RVR60
            "(990, 1, 20, 1, 7, \"El principio de la sabiduría es el temor de Jehová; los insensatos desprecian la sabiduría y la enseñanza.\")," + //Proverbios 1:7 RVR60
            "(991, 1, 20, 2, 6, \"Porque Jehová da la sabiduría, y de su boca viene el conocimiento y la inteligencia.\")," + //Proverbios 2:6 RVR60
            "(992, 1, 20, 4, 7, \"Sabiduría ante todo; adquiere sabiduría; y sobre todas tus posesiones adquiere inteligencia.\")," + //Proverbios 4:7 RVR60
            "(993, 1, 20, 9, 10, \"El temor de Jehová es el principio de la sabiduría, y el conocimiento del Santísimo es la inteligencia.\")," + //Proverbios 9:10 RVR60
            "(994, 1, 20, 10, 8, \"El sabio de corazón recibirá los mandamientos; mas el necio de labios caerá.\")," + //Proverbios 10:8 RVR60
            "(995, 1, 20, 11, 9, \"El hipócrita con la boca daña a su prójimo; mas los justos son librados con la sabiduría.\")," + //Proverbios 11:9 RVR60
            "(996, 1, 20, 13, 10, \"Ciertamente la soberbia concebirá contienda; mas con los avisados está la sabiduría.\")," + //Proverbios 13:10 RVR60
            "(997, 1, 20, 15, 5, \"El necio menosprecia el consejo de su padre; mas el que guarda la corrección vendrá a ser prudente.\")," + //Proverbios 15:5 RVR60
            "(998, 1, 20, 16, 16, \"Mejor es adquirir sabiduría que oro preciado; y adquirir inteligencia vale más que la plata.\")," + //Proverbios 16:16 RVR60
            "(999, 1, 20, 17, 28, \"Aun el necio, cuando calla, es contado por sabio; el que cierra sus labios es entendido.\")," + //Proverbios 17:28 RVR60
            "(1000, 1, 20, 18, 6, \"Los labios del necio traen contienda; y su boca los azotes llama.\")," + //Proverbios 18:6 RVR60
            "(1001, 1, 20, 19, 8, \"El que posee entendimiento ama su alma; el que guarda la inteligencia hallará el bien.\")," + //Proverbios 19:8 RVR60
            "(1002, 1, 20, 23, 24, \"Mucho se alegrará el padre del justo, y el que engendra sabio se gozará con él.\")," + //Proverbios 23:24 RVR60
            "(1003, 1, 51, 4, 5, \"Andad sabiamente para con los de afuera, redimiendo el tiempo. Sea vuestra palabra siempre con gracia, sazonada con sal, para que sepáis cómo debéis responder a cada uno.\")," + //Colosenses 4:5-6 RVR60
            "(1004, 1, 49, 1, 17, \"Para que el Dios de nuestro Señor Jesucristo, el Padre de gloria, os dé espíritu de sabiduría y de revelación en el conocimiento de él.\")," + //Efesios 1:17 RVR60
            "(1005, 1, 49, 5, 15, \"Mirad, pues, con diligencia cómo andéis, no como necios sino como sabios, aprovechando bien el tiempo, porque los días son malos.\")," + //Efesios 5:15-16 RVR60
            "(1006, 1, 45, 11, 33, \"¡Oh profundidad de las riquezas de la sabiduría y de la ciencia de Dios! ¡Cuán insondables son sus juicios, e inescrutables sus caminos!\")," + //Romanos 11:33 RVR60
            "(1007, 1, 45, 14, 5, \"Uno hace diferencia entre día y día; otro juzga iguales todos los días. Cada uno esté plenamente convencido en su propia mente.\")," + //Romanos 14:5 RVR60
            "(1008, 1, 59, 1, 5, \"Y si alguno de vosotros tiene falta de sabiduría, pídala a Dios, el cual da a todos abundantemente y sin reproche, y le será dada.\")," + //Santiago 1:5 RVR60
            "(1009, 1, 59, 3, 17, \"Pero la sabiduría que es de lo alto es primeramente pura, después pacífica, amable, benigna, llena de misericordia y de buenos frutos, sin incertidumbre ni hipocresía.\")," + //Santiago 3:17 RVR60
            "(1010, 1, 46, 3, 18, \"Nadie se engañe a sí mismo; si alguno entre vosotros se cree sabio en este siglo, hágase ignorante, para que llegue a ser sabio.\")"; //1 Corintios 3:18 RVR60

    public static final String INSERT_VERSICULO_TEMA_SABIDURIA_NVI_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(1011, 2, 23, 28, 29, \"También esto viene del Señor Todopoderoso, admirable por su consejo y magnífico por su sabiduría.\")," + //Isaías 28:29 NVI
            "(1012, 2, 27, 2, 23, \"A ti, Dios de mis padres, te alabo y te doy gracias. Me has dado sabiduría y poder, me has dado a conocer lo que te pedimos, ¡me has dado a conocer el sueño del rey!\")," + //Daniel 2:23 NVI
            "(1013, 2, 21, 7, 10, \"Nunca preguntes por qué todo tiempo pasado fue mejor. No es de sabios hacer tales preguntas.\")," + //Eclesiastés 7:10 NVI
            "(1014, 2, 21, 10, 12, \"Las palabras del sabio son placenteras, pero los labios del necio son su ruina.\")," + //Eclesiastés 10:12 NVI
            "(1015, 2, 19, 90, 12, \"Enséñanos a contar bien nuestros días, para que nuestro corazón adquiera sabiduría.\")," + //Salmos 90:12 NVI
            "(1016, 2, 20, 1, 7, \"El temor del Señor es el principio del conocimiento; los necios desprecian la sabiduría y la disciplina.\")," + //Proverbios 1:7 NVI
            "(1017, 2, 20, 2, 6, \"Porque el Señor da la sabiduría; conocimiento y ciencia brotan de sus labios.\")," + //Proverbios 2:6 NVI
            "(1018, 2, 20, 4, 7, \"La sabiduría es lo primero. ¡Adquiere sabiduría! Por sobre todas las cosas, adquiere discernimiento.\")," + //Proverbios 4:7 NVI
            "(1019, 2, 20, 9, 10, \"El comienzo de la sabiduría es el temor del Señor; conocer al Santo es tener discernimiento.\")," + //Proverbios 9:10 NVI
            "(1020, 2, 20, 10, 8, \"El de sabio corazón acata las órdenes, pero el necio y rezongón va camino al desastre.\")," + //Proverbios 10:8 NVI
            "(1021, 2, 20, 11, 9, \"Con la boca el impío destruye a su prójimo, pero los justos se libran por el conocimiento.\")," + //Proverbios 11:9 NVI
            "(1022, 2, 20, 13, 10, \"El orgullo solo genera contiendas, pero la sabiduría está con quienes oyen consejos.\")," + //Proverbios 13:10 NVI
            "(1023, 2, 20, 15, 5, \"El necio desdeña la corrección de su padre; el que la acepta demuestra prudencia.\")," + //Proverbios 15:5 NVI
            "(1024, 2, 20, 16, 16, \"Más vale adquirir sabiduría que oro; más vale adquirir inteligencia que plata.\")," + //Proverbios 16:16 NVI
            "(1025, 2, 20, 17, 28, \"Hasta un necio pasa por sabio si guarda silencio; se le considera prudente si cierra la boca.\")," + //Proverbios 17:28 NVI
            "(1026, 2, 20, 18, 6, \"Los labios del necio son causa de contienda; su boca incita a la riña.\")," + //Proverbios 18:6 NVI
            "(1027, 2, 20, 19, 8, \"El que adquiere cordura a sí mismo se ama, y el que retiene el discernimiento prospera.\")," + //Proverbios 19:8 NVI
            "(1028, 2, 20, 23, 24, \"El padre del justo experimenta gran regocijo; quien tiene un hijo sabio se solaza en él.\")," + //Proverbios 23:24 NVI
            "(1029, 2, 51, 4, 5, \"Compórtense sabiamente con los que no creen en Cristo, aprovechando al máximo cada momento oportuno. Que su conversación sea siempre amena y de buen gusto. Así sabrán cómo responder a cada uno.\")," + //Colosenses 4:5-6 NVI
            "(1030, 2, 49, 1, 17, \"Pido que el Dios de nuestro Señor Jesucristo, el Padre glorioso, les dé el Espíritu de sabiduría y de revelación, para que lo conozcan mejor.\")," + //Efesios 1:17 NVI
            "(1031, 2, 49, 5, 15, \"Así que tengan cuidado de su manera de vivir. No vivan como necios, sino como sabios, aprovechando al máximo cada momento oportuno, porque los días son malos.\")," + //Efesios 5:15-16 NVI
            "(1032, 2, 45, 11, 33, \"¡Qué profundas son las riquezas de la sabiduría y del conocimiento de Dios! ¡Qué indescifrables sus juicios e impenetrables sus caminos!\")," + //Romanos 11:33 NVI
            "(1033, 2, 45, 14, 5, \"Hay quien considera que un día tiene más importancia que otro, pero hay quien considera iguales todos los días. Cada uno debe estar firme en sus propias opiniones.\")," + //Romanos 14:5 NVI
            "(1034, 2, 59, 1, 5, \"Si a alguno de ustedes le falta sabiduría, pídasela a Dios, y él se la dará, pues Dios da a todos generosamente sin menospreciar a nadie.\")," + //Santiago 1:5 NVI
            "(1035, 2, 59, 3, 17, \"En cambio, la sabiduría que desciende del cielo es ante todo pura, y además pacífica, bondadosa, dócil, llena de compasión y de buenos frutos, imparcial y sincera.\")," + //Santiago 3:17 NVI
            "(1036, 2, 46, 3, 18, \"Que nadie se engañe. Si alguno de ustedes se cree sabio según las normas de esta época, hágase ignorante para así llegar a ser sabio.\")"; //1 Corintios 3:18 NVI

    public static final String INSERT_VERSICULO_TEMA_SABIDURIA_TLA_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(1037, 3, 23, 28, 29, \"Todo este conocimiento proviene del Dios todopoderoso. Dios hace planes admirables y los realiza con sabiduría.\")," + //Isaías 28:29 TLA
            "(1038, 3, 27, 2, 23, \"A ti, Dios de mis padres, te doy gracias y te alabo, porque me has hecho entender qué fue lo que el rey soñó.\")," + //Daniel 2:23 TLA
            "(1039, 3, 21, 7, 10, \"Hay quienes se quejan de que «todo tiempo pasado fue mejor». Pero esas quejas no demuestran mucha sabiduría.\")," + //Eclesiastés 7:10 TLA
            "(1040, 3, 21, 10, 12, \"Cuando el sabio habla, a todos les cae bien; cuando el tonto abre la boca, provoca su propia ruina.\")," + //Eclesiastés 10:12 TLA
            "(1041, 3, 19, 90, 12, \"Enséñanos a pensar cómo vivir para que nuestra mente se llene de sabiduría.\")," + //Salmos 90:12 TLA
            "(1042, 3, 20, 1, 7, \"Todo el que quiera ser sabio debe empezar por obedecer a Dios. Pero la gente ignorante no quiere ser corregida ni llegar a ser sabia.\")," + //Proverbios 1:7 TLA
            "(1043, 3, 20, 2, 6, \"Sólo Dios puede hacerte sabio; sólo Dios puede darte conocimiento.\")," + //Proverbios 2:6 TLA
            "(1044, 3, 20, 4, 7, \"Lo que realmente importa es que cada día seas más sabio y que aumentes tus conocimientos, aunque tengas que vender todo lo que poseas.\")," + //Proverbios 4:7 TLA
            "(1045, 3, 20, 9, 10, \"Todo el que quiera ser sabio que comience por obedecer a Dios; conocer al Dios santo es dar muestras de inteligencia.\")," + //Proverbios 9:10 TLA
            "(1046, 3, 20, 10, 8, \"El hombre sabio cumple una orden; el imprudente acaba en la ruina.\")," + //Proverbios 10:8 TLA
            "(1047, 3, 20, 11, 9, \"Los chismes de los malvados destruyen a sus semejantes, pero a la gente honrada la salva la sabiduría.\")," + //Proverbios 11:9 TLA
            "(1048, 3, 20, 13, 10, \"La gente orgullosa provoca peleas; la gente humilde escucha consejos.\")," + //Proverbios 13:10 TLA
            "(1049, 3, 20, 15, 5, \"El que es tonto no acepta que su padre lo corrija, pero el que es sabio acepta la corrección.\")," + //Proverbios 15:5 TLA
            "(1050, 3, 20, 16, 16, \"La sabiduría y el entendimiento valen más que el oro y la plata.\")," + //Proverbios 16:16 TLA
            "(1051, 3, 20, 17, 28, \"Hasta el tonto pasa por sabio si se calla y mantiene la calma.\")," + //Proverbios 17:28 TLA
            "(1052, 3, 20, 18, 6, \"Cuando el tonto abre la boca, causa discusiones y pleitos.\")," + //Proverbios 18:6 TLA
            "(1053, 3, 20, 19, 8, \"Si en verdad te aprecias, estudia. Bien harás en practicar lo aprendido.\")," + //Proverbios 19:8 TLA
            "(1054, 3, 20, 23, 24, \"El hijo bueno y sabio es motivo de gran alegría para su padre y su madre que le dieron la vida.\")," + //Proverbios 23:24 TLA
            "(1055, 3, 51, 4, 5, \"Usen su inteligencia para tratar como se debe a los que no confían en Cristo. Aprovechen bien cada oportunidad que tengan de conversar con ellos. Hablen siempre de cosas buenas, díganlas de manera agradable, y piensen bien cómo se debe contestar a cada uno.\")," + //Colosenses 4:5-6 TLA
            "(1056, 3, 49, 1, 17, \"Le pido al Dios de nuestro Señor Jesucristo, es decir, al Padre maravilloso, que les dé su Espíritu, para que sean sabios y puedan entender cómo es Dios.\")," + //Efesios 1:17 TLA
            "(1057, 3, 49, 5, 15, \"Tengan cuidado de cómo se comportan. Vivan como gente que piensa lo que hace, y no como tontos. Aprovechen cada oportunidad que tengan de hacer el bien, porque estamos viviendo tiempos muy malos.\")," + //Efesios 5:15-16 TLA
            "(1058, 3, 45, 11, 33, \"¡Dios es inmensamente rico! ¡Su inteligencia y su conocimiento son tan grandes que no se pueden medir! Nadie es capaz de entender sus decisiones, ni de explicar sus hechos.\")," + //Romanos 11:33 TLA
            "(1059, 3, 45, 14, 5, \"Permítanme darles otro ejemplo. Hay algunos que piensan que ciertos días son especiales, mientras que para otras personas todos los días son iguales. Cada uno debe estar seguro de que piensa lo correcto.\")," + //Romanos 14:5 TLA
            "(1060, 3, 59, 1, 5, \"Si alguno de ustedes no tiene sabiduría, pídasela a Dios. Él se la da a todos en abundancia, sin echarles nada en cara.\")," + //Santiago 1:5 TLA
            "(1061, 3, 59, 3, 17, \"En cambio, los que tienen la sabiduría que viene de Dios, no hacen lo malo; al contrario, buscan la paz, son obedientes y amables con los demás, se compadecen de los que sufren, y siempre hacen lo bueno; tratan a todos de la misma manera, y son verdaderos cristianos.\")," + //Santiago 3:17 TLA
            "(1062, 3, 46, 3, 18, \"¡No se engañen a ustedes mismos! Si alguno cree que es muy sabio, y que sabe mucho de las cosas de este mundo, para ser sabio de verdad debe comportarse como un ignorante.\")"; //1 Corintios 3:18 TLA

    public static final String INSERT_VERSICULO_TEMA_SABIDURIA_NTV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(1063, 4, 23, 28, 29, \"El SEÑOR de los Ejércitos Celestiales es un maestro maravilloso, y le da gran sabiduría al agricultor.\")," + //Isaías 28:29 NTV
            "(1064, 4, 27, 2, 23, \"Te agradezco y te alabo, Dios de mis antepasados, porque me has dado sabiduría y fortaleza. Me revelaste lo que te pedimos y nos diste a conocer lo que el rey exigía.\")," + //Daniel 2:23 NTV
            "(1065, 4, 21, 7, 10, \"No añores «viejos tiempos»; no es nada sabio.\")," + //Eclesiastés 7:10 NTV
            "(1066, 4, 21, 10, 12, \"Las palabras sabias traen aprobación, pero a los necios, sus propias palabras los destruyen.\")," + //Eclesiastés 10:12 NTV
            "(1067, 4, 19, 90, 12, \"Enséñanos a entender la brevedad de la vida, para que crezcamos en sabiduría.\")," + //Salmos 90:12 NTV
            "(1068, 4, 20, 1, 7, \"El temor del SEÑOR es la base del verdadero conocimiento, pero los necios desprecian la sabiduría y la disciplina.\")," + //Proverbios 1:7 NTV
            "(1069, 4, 20, 2, 6, \"¡Pues el SEÑOR concede sabiduría! De su boca provienen el saber y el entendimiento.\")," + //Proverbios 2:6 NTV
            "(1070, 4, 20, 4, 7, \"¡Adquirir sabiduría es lo más sabio que puedes hacer! Y en todo lo demás que hagas, desarrolla buen juicio.\")," + //Proverbios 4:7 NTV
            "(1071, 4, 20, 9, 10, \"El temor del SEÑOR es la base de la sabiduría. Conocer al Santo da por resultado el buen juicio.\")," + //Proverbios 9:10 NTV
            "(1072, 4, 20, 10, 8, \"El sabio con gusto recibe instrucción, pero el necio que habla hasta por los codos caerá de narices.\")," + //Proverbios 10:8 NTV
            "(1073, 4, 20, 11, 9, \"Los que no tienen a Dios destruyen a sus amigos con sus palabras, pero el conocimiento rescatará a los justos.\")," + //Proverbios 11:9 NTV
            "(1074, 4, 20, 13, 10, \"El orgullo lleva a conflictos; los que siguen el consejo son sabios.\")," + //Proverbios 13:10 NTV
            "(1075, 4, 20, 15, 5, \"Solo un necio desprecia la disciplina de sus padres; el que aprende de la corrección es sabio.\")," + //Proverbios 15:5 NTV
            "(1076, 4, 20, 16, 16, \"¡Cuánto mejor es adquirir sabiduría que oro, y el buen juicio que la plata!\")," + //Proverbios 16:16 NTV
            "(1077, 4, 20, 17, 28, \"Hasta los necios pasan por sabios si permanecen callados; parecen inteligentes cuando mantienen la boca cerrada.\")," + //Proverbios 17:28 NTV
            "(1078, 4, 20, 18, 6, \"Con sus palabras, los necios se meten continuamente en pleitos; van en busca de una paliza.\")," + //Proverbios 18:6 NTV
            "(1079, 4, 20, 19, 8, \"Adquirir sabiduría es amarse a uno mismo; los que atesoran el entendimiento prosperarán.\")," + //Proverbios 19:8 NTV
            "(1080, 4, 20, 23, 24, \"El padre de hijos justos tiene motivos para alegrarse. ¡Qué satisfacción es tener hijos sabios!\")," + //Proverbios 23:24 NTV
            "(1081, 4, 51, 4, 5, \"Vivan sabiamente entre los que no creen en Cristo y aprovechen al máximo cada oportunidad. Que sus conversaciones sean cordiales y agradables, a fin de que ustedes tengan la respuesta adecuada para cada persona.\")," + //Colosenses 4:5-6 NTV
            "(1082, 4, 49, 1, 17, \"Y le pido a Dios, el glorioso Padre de nuestro Señor Jesucristo, que les dé sabiduría espiritual y percepción, para que crezcan en el conocimiento de Dios.\")," + //Efesios 1:17 NTV
            "(1083, 4, 49, 5, 15, \"Así que tengan cuidado de cómo viven. No vivan como necios sino como sabios. Saquen el mayor provecho de cada oportunidad en estos días malos.\")," + //Efesios 5:15-16 NTV
            "(1084, 4, 45, 11, 33, \"¡Qué grande es la riqueza, la sabiduría y el conocimiento de Dios! ¡Es realmente imposible para nosotros entender sus decisiones y sus caminos!\")," + //Romanos 11:33 NTV
            "(1085, 4, 45, 14, 5, \"Del mismo modo, algunos piensan que un día es más sagrado que otro, mientras que otros creen que todos los días son iguales. Cada uno debería estar plenamente convencido de que el día que elija es aceptable.\")," + //Romanos 14:5 NTV
            "(1086, 4, 59, 1, 5, \"Si necesitan sabiduría, pídansela a nuestro generoso Dios, y él se la dará; no los reprenderá por pedirla.\")," + //Santiago 1:5 NTV
            "(1087, 4, 59, 3, 17, \"Sin embargo, la sabiduría que proviene del cielo es, ante todo, pura y también ama la paz; siempre es amable y dispuesta a ceder ante los demás. Está llena de compasión y de buenas acciones. No muestra favoritismo y siempre es sincera.\")," + //Santiago 3:17 NTV
            "(1088, 4, 46, 3, 18, \"Dejen de engañarse a sí mismos. Si piensan que son sabios de acuerdo con los criterios de este mundo, necesitan volverse necios para ser verdaderamente sabios.\")"; //1 Corintios 3:18 NTV

    public static final String INSERT_VERSICULO_TEMA_SABIDURIA_KJV_SCRIPT =
        "insert into " + VERSICULO_TABLE_NAME + " values" +
            "(1089, 5, 23, 28, 29, \"This also cometh forth from the Lord of hosts, which is wonderful in counsel, and excellent in working.\")," + //Isaiah 28:29 KJV
            "(1090, 5, 27, 2, 23, \"I thank thee, and praise thee, O thou God of my fathers, who hast given me wisdom and might, and hast made known unto me now what we desired of thee: for thou hast now made known unto us the king's matter.\")," + //Daniel 2:23 KJV
            "(1091, 5, 21, 7, 10, \"Say not thou, What is the cause that the former days were better than these? for thou dost not enquire wisely concerning this.\")," + //Ecclesiastes 7:10 KJV
            "(1092, 5, 21, 10, 12, \"The words of a wise man's mouth are gracious; but the lips of a fool will swallow up himself.\")," + //Ecclesiastes 10:12 KJV
            "(1093, 5, 19, 90, 12, \"So teach us to number our days, that we may apply our hearts unto wisdom.\")," + //Psalms 90:12 KJV
            "(1094, 5, 20, 1, 7, \"The fear of the Lord is the beginning of knowledge: but fools despise wisdom and instruction.\")," + //Proverbs 1:7 KJV
            "(1095, 5, 20, 2, 6, \"For the Lord giveth wisdom: out of his mouth cometh knowledge and understanding.\")," + //Proverbs 2:6 KJV
            "(1096, 5, 20, 4, 7, \"Wisdom is the principal thing; therefore get wisdom: and with all thy getting get understanding.\")," + //Proverbs 4:7 KJV
            "(1097, 5, 20, 9, 10, \"The fear of the Lord is the beginning of wisdom: and the knowledge of the holy is understanding.\")," + //Proverbs 9:10 KJV
            "(1098, 5, 20, 10, 8, \"The wise in heart will receive commandments: but a prating fool shall fall.\")," + //Proverbs 10:8 KJV
            "(1099, 5, 20, 11, 9, \"An hypocrite with his mouth destroyeth his neighbour: but through knowledge shall the just be delivered.\")," + //Proverbs 11:9 KJV
            "(1100, 5, 20, 13, 10, \"Only by pride cometh contention: but with the well advised is wisdom.\")," + //Proverbs 13:10 KJV
            "(1101, 5, 20, 15, 5, \"A fool despiseth his father's instruction: but he that regardeth reproof is prudent.\")," + //Proverbs 15:5 KJV
            "(1102, 5, 20, 16, 16, \"How much better is it to get wisdom than gold! and to get understanding rather to be chosen than silver!\")," + //Proverbs 16:16 KJV
            "(1103, 5, 20, 17, 28, \"Even a fool, when he holdeth his peace, is counted wise: and he that shutteth his lips is esteemed a man of understanding.\")," + //Proverbs 17:28 KJV
            "(1104, 5, 20, 18, 6, \"A fool's lips enter into contention, and his mouth calleth for strokes.\")," + //Proverbs 18:6 KJV
            "(1105, 5, 20, 19, 8, \"He that getteth wisdom loveth his own soul: he that keepeth understanding shall find good.\")," + //Proverbs 19:8 KJV
            "(1106, 5, 20, 23, 24, \"The father of the righteous shall greatly rejoice: and he that begetteth a wise child shall have joy of him.\")," + //Proverbs 23:24 KJV
            "(1107, 5, 51, 4, 5, \"Walk in wisdom toward them that are without, redeeming the time. Let your speech be always with grace, seasoned with salt, that ye may know how ye ought to answer every man.\")," + //Colossians 4:5-6 KJV
            "(1108, 5, 49, 1, 17, \"That the God of our Lord Jesus Christ, the Father of glory, may give unto you the spirit of wisdom and revelation in the knowledge of him.\")," + //Ephesians 1:17 KJV
            "(1109, 5, 49, 5, 15, \"See then that ye walk circumspectly, not as fools, but as wise, redeeming the time, because the days are evil.\")," + //Ephesians 5:15-16 KJV
            "(1110, 5, 45, 11, 33, \"O the depth of the riches both of the wisdom and knowledge of God! how unsearchable are his judgments, and his ways past finding out!\")," + //Romans 11:33 KJV
            "(1111, 5, 45, 14, 5, \"One man esteemeth one day above another: another esteemeth every day alike. Let every man be fully persuaded in his own mind.\")," + //Romans 14:5 KJV
            "(1112, 5, 59, 1, 5, \"If any of you lack wisdom, let him ask of God, that giveth to all men liberally, and upbraideth not; and it shall be given him.\")," + //James 1:5 KJV
            "(1113, 5, 59, 3, 17, \"But the wisdom that is from above is first pure, then peaceable, gentle, and easy to be entreated, full of mercy and good fruits, without partiality, and without hypocrisy.\")," + //James 3:17 KJV
            "(1114, 5, 46, 3, 18, \"Let no man deceive himself. If any man among you seemeth to be wise in this world, let him become a fool, that he may be wise.\")"; //1 Corinthians 3:18 KJV


    public static final String INSERT_PROMESA_TEMA_AMOR_RVR60_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(1, 1, 340)," + //1 Juan 2:15 RVR60
            "(2, 1, 341)," + //1 Juan 3:1 RVR60
            "(3, 1, 342)," + //1 Juan 3:11 RVR60
            "(4, 1, 343)," + //1 Juan 3:16 RVR60
            "(5, 1, 344)," + //1 Juan 4:7 RVR60
            "(6, 1, 345)," + //1 Juan 4:8 RVR60
            "(7, 1, 346)," + //1 Juan 4:9 RVR60
            "(8, 1, 347)," + //1 Juan 4:10 RVR60
            "(9, 1, 348)," + //1 Juan 4:11 RVR60
            "(10, 1, 349)," + //1 Juan 4:12 RVR60
            "(11, 1, 350)," + //1 Juan 4:16 RVR60
            "(12, 1, 351)," + //1 Juan 4:18 RVR60
            "(13, 1, 352)," + //1 Juan 4:19 RVR60
            "(14, 1, 353)," + //1 Juan 4:20 RVR60
            "(15, 1, 354)," + //1 Juan 4:21 RVR60
            "(16, 1, 355)," + //Salmos 33:5 RVR60
            "(17, 1, 356)," + //Salmos 116:1 RVR60
            "(18, 1, 357)," + //Proverbios 3:12 RVR60
            "(19, 1, 358)," + //Proverbios 10:12 RVR60
            "(20, 1, 359)," + //1 Corintios 2:9 RVR60
            "(21, 1, 360)," + //1 Corintios 13:1 RVR60
            "(22, 1, 361)," + //1 Corintios 13:2 RVR60
            "(23, 1, 362)," + //1 Corintios 13:3 RVR60
            "(24, 1, 363)," + //1 Corintios 13:4-7 RVR60
            "(25, 1, 364)," + //1 Corintios 13:13 RVR60
            "(26, 1, 365)," + //1 Corintios 16:14 RVR60
            "(27, 1, 366)," + //2 Corintios 5:14-15 RVR60
            "(28, 1, 367)," + //Efesios 2:4-5 RVR60
            "(29, 1, 368)," + //Efesios 4:2 RVR60
            "(30, 1, 369)," + //Efesios 4:15 RVR60
            "(31, 1, 370)," + //Efesios 5:2 RVR60
            "(32, 1, 371)," + //Efesios 5:25 RVR60
            "(33, 1, 372)," + //Romanos 5:5 RVR60
            "(34, 1, 373)," + //Romanos 8:28 RVR60
            "(35, 1, 374)," + //Romanos 8:35 RVR60
            "(36, 1, 375)," + //Romanos 8:38-39 RVR60
            "(37, 1, 376)," + //Romanos 12:9 RVR60
            "(38, 1, 377)," + //Romanos 12:10 RVR60
            "(39, 1, 378)," + //Romanos 13:8 RVR60
            "(40, 1, 379)," + //Romanos 13:9 RVR60
            "(41, 1, 380)," + //Romanos 13:10 RVR60
            "(42, 1, 381)," + //Juan 13:34 RVR60
            "(43, 1, 382)," + //Juan 13:35 RVR60
            "(44, 1, 383)," + //Juan 14:15 RVR60
            "(45, 1, 384)," + //Juan 14:21 RVR60
            "(46, 1, 385)," + //Juan 14:23 RVR60
            "(47, 1, 386)," + //Juan 15:10 RVR60
            "(48, 1, 387)," + //Juan 15:12 RVR60
            "(49, 1, 388)," + //Juan 15:13 RVR60
            "(50, 1, 389)," + //Juan 17:26 RVR60
            "(51, 1, 390)," + //Isaias 43:4 RVR60
            "(52, 1, 391)," + //1 Tesalonicenses 3:12 RVR60
            "(53, 1, 392)," + //2 Tesalonicenses 3:5 RVR60
            "(54, 1, 393)," + //Galatas 5:6 RVR60
            "(55, 1, 394)," + //Galatas 5:13 RVR60
            "(56, 1, 395)," + //Galatas 5:14 RVR60
            "(57, 1, 396)," + //Galatas 5:22-23 RVR60
            "(58, 1, 397)," + //Colosenses 3:14 RVR60
            "(59, 1, 398)," + //1 Pedro 4:8 RVR60
            "(60, 1, 399)," + //Marcos 12:30 RVR60
            "(61, 1, 400)," + //Marcos 12:31 RVR60
            "(62, 1, 401)," + //1 Timoteo 4:12 RVR60
            "(63, 1, 402)," + //2 Timoteo 1:7 RVR60
            "(64, 1, 403)," + //Mateo 5:44 RVR60
            "(65, 1, 404)," + //Lucas 10:27 RVR60
            "(66, 1, 405)," + //Judas 1:2 RVR60
            "(67, 1, 406)," + //Hebreos 13:1 RVR60
            "(68, 1, 407)," + //Apocalipsis 3:19 RVR60
            "(69, 1, 408)," + //Deuteronomio 6:5 RVR60
            "(70, 1, 409)" ; //Cantares 8:6 RVR60

    public static final String INSERT_PROMESA_TEMA_AMOR_NVI_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(71, 1, 410)," + //1 Juan 2:15 NVI
            "(72, 1, 411)," + //1 Juan 3:1 NVI
            "(73, 1, 412)," + //1 Juan 3:11 NVI
            "(74, 1, 413)," + //1 Juan 3:16 NVI
            "(75, 1, 414)," + //1 Juan 4:7 NVI
            "(76, 1, 415)," + //1 Juan 4:8 NVI
            "(77, 1, 416)," + //1 Juan 4:9 NVI
            "(78, 1, 417)," + //1 Juan 4:10 NVI
            "(79, 1, 418)," + //1 Juan 4:11 NVI
            "(80, 1, 419)," + //1 Juan 4:12 NVI
            "(81, 1, 420)," + //1 Juan 4:16 NVI
            "(82, 1, 421)," + //1 Juan 4:18 NVI
            "(83, 1, 422)," + //1 Juan 4:19 NVI
            "(84, 1, 423)," + //1 Juan 4:20 NVI
            "(85, 1, 424)," + //1 Juan 4:21 NVI
            "(86, 1, 425)," + //Salmos 33:5 NVI
            "(87, 1, 426)," + //Salmos 116:1 NVI
            "(88, 1, 427)," + //Proverbios 3:12 NVI
            "(89, 1, 428)," + //Proverbios 10:12 NVI
            "(90, 1, 429)," + //1 Corintios 2:9 NVI
            "(91, 1, 430)," + //1 Corintios 13:1 NVI
            "(92, 1, 431)," + //1 Corintios 13:2 NVI
            "(93, 1, 432)," + //1 Corintios 13:3 NVI
            "(94, 1, 433)," + //1 Corintios 13:4-7 NVI
            "(95, 1, 434)," + //1 Corintios 13:13 NVI
            "(96, 1, 435)," + //1 Corintios 16:14 NVI
            "(97, 1, 436)," + //2 Corintios 5:14-15 NVI
            "(98, 1, 437)," + //Efesios 2:4-5 NVI
            "(99, 1, 438)," + //Efesios 4:2 NVI
            "(100, 1, 439)," + //Efesios 4:15 NVI
            "(101, 1, 440)," + //Efesios 5:2 NVI
            "(102, 1, 441)," + //Efesios 5:25 NVI
            "(103, 1, 442)," + //Romanos 5:5 NVI
            "(104, 1, 443)," + //Romanos 8:28 NVI
            "(105, 1, 444)," + //Romanos 8:35 NVI
            "(106, 1, 445)," + //Romanos 8:38-39 NVI
            "(107, 1, 446)," + //Romanos 12:9 NVI
            "(108, 1, 447)," + //Romanos 12:10 NVI
            "(109, 1, 448)," + //Romanos 13:8 NVI
            "(110, 1, 449)," + //Romanos 13:9 NVI
            "(111, 1, 450)," + //Romanos 13:10 NVI
            "(112, 1, 451)," + //Juan 13:34 NVI
            "(113, 1, 452)," + //Juan 13:35 NVI
            "(114, 1, 453)," + //Juan 14:15 NVI
            "(115, 1, 454)," + //Juan 14:21 NVI
            "(116, 1, 455)," + //Juan 14:23 NVI
            "(117, 1, 456)," + //Juan 15:10 NVI
            "(118, 1, 457)," + //Juan 15:12 NVI
            "(119, 1, 458)," + //Juan 15:13 NVI
            "(120, 1, 459)," + //Juan 17:26 NVI
            "(121, 1, 460)," + //Isaias 43:4 NVI
            "(122, 1, 461)," + //1 Tesalonicenses 3:12 NVI
            "(123, 1, 462)," + //2 Tesalonicenses 3:5 NVI
            "(124, 1, 463)," + //Galatas 5:6 NVI
            "(125, 1, 464)," + //Galatas 5:13 NVI
            "(126, 1, 465)," + //Galatas 5:14 NVI
            "(127, 1, 466)," + //Galatas 5:22-23 NVI
            "(128, 1, 467)," + //Colosenses 3:14 NVI
            "(129, 1, 468)," + //1 Pedro 4:8 NVI
            "(130, 1, 469)," + //Marcos 12:30 NVI
            "(131, 1, 470)," + //Marcos 12:31 NVI
            "(132, 1, 471)," + //1 Timoteo 4:12 NVI
            "(133, 1, 472)," + //2 Timoteo 1:7 NVI
            "(134, 1, 473)," + //Mateo 5:44 NVI
            "(135, 1, 474)," + //Lucas 10:27 NVI
            "(136, 1, 475)," + //Judas 1:2 NVI
            "(137, 1, 476)," + //Hebreos 13:1 NVI
            "(138, 1, 477)," + //Apocalipsis 3:19 NVI
            "(139, 1, 478)," + //Deuteronomio 6:5 NVI
            "(140, 1, 479)" ; //Cantares 8:6 NVI

    public static final String INSERT_PROMESA_TEMA_AMOR_TLA_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(141, 1, 480)," + //1 Juan 2:15 TLA
            "(142, 1, 481)," + //1 Juan 3:1 TLA
            "(143, 1, 482)," + //1 Juan 3:11 TLA
            "(144, 1, 483)," + //1 Juan 3:16 TLA
            "(145, 1, 484)," + //1 Juan 4:7 TLA
            "(146, 1, 485)," + //1 Juan 4:8 TLA
            "(147, 1, 486)," + //1 Juan 4:9 TLA
            "(148, 1, 487)," + //1 Juan 4:10 TLA
            "(149, 1, 488)," + //1 Juan 4:11 TLA
            "(150, 1, 489)," + //1 Juan 4:12 TLA
            "(151, 1, 490)," + //1 Juan 4:16 TLA
            "(152, 1, 491)," + //1 Juan 4:18 TLA
            "(153, 1, 492)," + //1 Juan 4:19 TLA
            "(154, 1, 493)," + //1 Juan 4:20 TLA
            "(155, 1, 494)," + //1 Juan 4:21 TLA
            "(156, 1, 495)," + //Salmos 33:5 TLA
            "(157, 1, 496)," + //Salmos 116:1 TLA
            "(158, 1, 497)," + //Proverbios 3:12 TLA
            "(159, 1, 498)," + //Proverbios 10:12 TLA
            "(160, 1, 499)," + //1 Corintios 2:9 TLA
            "(161, 1, 500)," + //1 Corintios 13:1 TLA
            "(162, 1, 501)," + //1 Corintios 13:2 TLA
            "(163, 1, 502)," + //1 Corintios 13:3 TLA
            "(164, 1, 503)," + //1 Corintios 13:4-7 TLA
            "(165, 1, 504)," + //1 Corintios 13:13 TLA
            "(166, 1, 505)," + //1 Corintios 16:14 TLA
            "(167, 1, 506)," + //2 Corintios 5:14-15 TLA
            "(168, 1, 507)," + //Efesios 2:4-5 TLA
            "(169, 1, 508)," + //Efesios 4:2 TLA
            "(170, 1, 509)," + //Efesios 4:15 TLA
            "(171, 1, 510)," + //Efesios 5:2 TLA
            "(172, 1, 511)," + //Efesios 5:25 TLA
            "(173, 1, 512)," + //Romanos 5:5 TLA
            "(174, 1, 513)," + //Romanos 8:28 TLA
            "(175, 1, 514)," + //Romanos 8:35 TLA
            "(176, 1, 515)," + //Romanos 8:38-39 TLA
            "(177, 1, 516)," + //Romanos 12:9 TLA
            "(178, 1, 517)," + //Romanos 12:10 TLA
            "(179, 1, 518)," + //Romanos 13:8 TLA
            "(180, 1, 519)," + //Romanos 13:9 TLA
            "(181, 1, 520)," + //Romanos 13:10 TLA
            "(182, 1, 521)," + //Juan 13:34 TLA
            "(183, 1, 522)," + //Juan 13:35 TLA
            "(184, 1, 523)," + //Juan 14:15 TLA
            "(185, 1, 524)," + //Juan 14:21 TLA
            "(186, 1, 525)," + //Juan 14:23 TLA
            "(187, 1, 526)," + //Juan 15:10 TLA
            "(188, 1, 527)," + //Juan 15:12 TLA
            "(189, 1, 528)," + //Juan 15:13 TLA
            "(190, 1, 529)," + //Juan 17:26 TLA
            "(191, 1, 530)," + //Isaias 43:4 TLA
            "(192, 1, 531)," + //1 Tesalonicenses 3:12 TLA
            "(193, 1, 532)," + //2 Tesalonicenses 3:5 TLA
            "(194, 1, 533)," + //Galatas 5:6 TLA
            "(195, 1, 534)," + //Galatas 5:13 TLA
            "(196, 1, 535)," + //Galatas 5:14 TLA
            "(197, 1, 536)," + //Galatas 5:22-23 TLA
            "(198, 1, 537)," + //Colosenses 3:14 TLA
            "(199, 1, 538)," + //1 Pedro 4:8 TLA
            "(200, 1, 539)," + //Marcos 12:30 TLA
            "(201, 1, 540)," + //Marcos 12:31 TLA
            "(202, 1, 541)," + //1 Timoteo 4:12 TLA
            "(203, 1, 542)," + //2 Timoteo 1:7 TLA
            "(204, 1, 543)," + //Mateo 5:44 TLA
            "(205, 1, 544)," + //Lucas 10:27 TLA
            "(206, 1, 545)," + //Judas 1:2 TLA
            "(207, 1, 546)," + //Hebreos 13:1 TLA
            "(208, 1, 547)," + //Apocalipsis 3:19 TLA
            "(209, 1, 548)," + //Deuteronomio 6:5 TLA
            "(210, 1, 549)" ; //Cantares 8:6 TLA

    public static final String INSERT_PROMESA_TEMA_AMOR_NTV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(211, 1, 550)," + //1 Juan 2:15 NTV
            "(212, 1, 551)," + //1 Juan 3:1 NTV
            "(213, 1, 552)," + //1 Juan 3:11 NTV
            "(214, 1, 553)," + //1 Juan 3:16 NTV
            "(215, 1, 554)," + //1 Juan 4:7 NTV
            "(216, 1, 555)," + //1 Juan 4:8 NTV
            "(217, 1, 556)," + //1 Juan 4:9 NTV
            "(218, 1, 557)," + //1 Juan 4:10 NTV
            "(219, 1, 558)," + //1 Juan 4:11 NTV
            "(220, 1, 559)," + //1 Juan 4:12 NTV
            "(221, 1, 560)," + //1 Juan 4:16 NTV
            "(222, 1, 561)," + //1 Juan 4:18 NTV
            "(223, 1, 562)," + //1 Juan 4:19 NTV
            "(224, 1, 563)," + //1 Juan 4:20 NTV
            "(225, 1, 564)," + //1 Juan 4:21 NTV
            "(226, 1, 565)," + //Salmos 33:5 NTV
            "(227, 1, 566)," + //Salmos 116:1 NTV
            "(228, 1, 567)," + //Proverbios 3:12 NTV
            "(229, 1, 568)," + //Proverbios 10:12 NTV
            "(230, 1, 569)," + //1 Corintios 2:9 NTV
            "(231, 1, 570)," + //1 Corintios 13:1 NTV
            "(232, 1, 571)," + //1 Corintios 13:2 NTV
            "(233, 1, 572)," + //1 Corintios 13:3 NTV
            "(234, 1, 573)," + //1 Corintios 13:4-7 NTV
            "(235, 1, 574)," + //1 Corintios 13:13 NTV
            "(236, 1, 575)," + //1 Corintios 16:14 NTV
            "(237, 1, 576)," + //2 Corintios 5:14-15 NTV
            "(238, 1, 577)," + //Efesios 2:4-5 NTV
            "(239, 1, 578)," + //Efesios 4:2 NTV
            "(240, 1, 579)," + //Efesios 4:15 NTV
            "(241, 1, 580)," + //Efesios 5:2 NTV
            "(242, 1, 581)," + //Efesios 5:25 NTV
            "(243, 1, 582)," + //Romanos 5:5 NTV
            "(244, 1, 583)," + //Romanos 8:28 NTV
            "(245, 1, 584)," + //Romanos 8:35 NTV
            "(246, 1, 585)," + //Romanos 8:38-39 NTV
            "(247, 1, 586)," + //Romanos 12:9 NTV
            "(248, 1, 587)," + //Romanos 12:10 NTV
            "(249, 1, 588)," + //Romanos 13:8 NTV
            "(250, 1, 589)," + //Romanos 13:9 NTV
            "(251, 1, 590)," + //Romanos 13:10 NTV
            "(252, 1, 591)," + //Juan 13:34 NTV
            "(253, 1, 592)," + //Juan 13:35 NTV
            "(254, 1, 593)," + //Juan 14:15 NTV
            "(255, 1, 594)," + //Juan 14:21 NTV
            "(256, 1, 595)," + //Juan 14:23 NTV
            "(257, 1, 596)," + //Juan 15:10 NTV
            "(258, 1, 597)," + //Juan 15:12 NTV
            "(259, 1, 598)," + //Juan 15:13 NTV
            "(260, 1, 599)," + //Juan 17:26 NTV
            "(261, 1, 600)," + //Isaias 43:4 NTV
            "(262, 1, 601)," + //1 Tesalonicenses 3:12 NTV
            "(263, 1, 602)," + //2 Tesalonicenses 3:5 NTV
            "(264, 1, 603)," + //Galatas 5:6 NTV
            "(265, 1, 604)," + //Galatas 5:13 NTV
            "(266, 1, 605)," + //Galatas 5:14 NTV
            "(267, 1, 606)," + //Galatas 5:22-23 NTV
            "(268, 1, 607)," + //Colosenses 3:14 NTV
            "(269, 1, 608)," + //1 Pedro 4:8 NTV
            "(270, 1, 609)," + //Marcos 12:30 NTV
            "(271, 1, 610)," + //Marcos 12:31 NTV
            "(272, 1, 611)," + //1 Timoteo 4:12 NTV
            "(273, 1, 612)," + //2 Timoteo 1:7 NTV
            "(274, 1, 613)," + //Mateo 5:44 NTV
            "(275, 1, 614)," + //Lucas 10:27 NTV
            "(276, 1, 615)," + //Judas 1:2 NTV
            "(277, 1, 616)," + //Hebreos 13:1 NTV
            "(278, 1, 617)," + //Apocalipsis 3:19 NTV
            "(279, 1, 618)," + //Deuteronomio 6:5 NTV
            "(280, 1, 619)" ; //Cantares 8:6 NTV

    public static final String INSERT_PROMESA_TEMA_AMOR_KJV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(281, 1, 620)," + //1 John 2:15 KJV
            "(282, 1, 621)," + //1 John 3:1 KJV
            "(283, 1, 622)," + //1 John 3:11 KJV
            "(284, 1, 623)," + //1 John 3:16 KJV
            "(285, 1, 624)," + //1 John 4:7 KJV
            "(286, 1, 625)," + //1 John 4:8 KJV
            "(287, 1, 626)," + //1 John 4:9 KJV
            "(288, 1, 627)," + //1 John 4:10 KJV
            "(289, 1, 628)," + //1 John 4:11 KJV
            "(290, 1, 629)," + //1 John 4:12 KJV
            "(291, 1, 630)," + //1 John 4:16 KJV
            "(292, 1, 631)," + //1 John 4:18 KJV
            "(293, 1, 632)," + //1 John 4:19 KJV
            "(294, 1, 633)," + //1 John 4:20 KJV
            "(295, 1, 634)," + //1 John 4:21 KJV
            "(296, 1, 635)," + //Psalms 33:5 KJV
            "(297, 1, 636)," + //Psalms 116:1 KJV
            "(298, 1, 637)," + //Proverbs 3:12 KJV
            "(299, 1, 638)," + //Proverbs 10:12 KJV
            "(300, 1, 639)," + //1 Corinthians 2:9 KJV
            "(301, 1, 640)," + //1 Corinthians 13:1 KJV
            "(302, 1, 641)," + //1 Corinthians 13:2 KJV
            "(303, 1, 642)," + //1 Corinthians 13:3 KJV
            "(304, 1, 643)," + //1 Corinthians 13:4-7 KJV
            "(305, 1, 644)," + //1 Corinthians 13:13 KJV
            "(306, 1, 645)," + //1 Corinthians 16:14 KJV
            "(307, 1, 646)," + //2 Corinthians 5:14-15 KJV
            "(308, 1, 647)," + //Ephesians 2:4-5 KJV
            "(309, 1, 648)," + //Ephesians 4:2 KJV
            "(310, 1, 649)," + //Ephesians 4:15 KJV
            "(311, 1, 650)," + //Ephesians 5:2 KJV
            "(312, 1, 651)," + //Ephesians 5:25 KJV
            "(313, 1, 652)," + //Romans 5:5 KJV
            "(314, 1, 653)," + //Romans 8:28 KJV
            "(315, 1, 654)," + //Romans 8:35 KJV
            "(316, 1, 655)," + //Romans 8:38-39 KJV
            "(317, 1, 656)," + //Romans 12:9 KJV
            "(318, 1, 657)," + //Romans 12:10 KJV
            "(319, 1, 658)," + //Romans 13:8 KJV
            "(320, 1, 659)," + //Romans 13:9 KJV
            "(321, 1, 660)," + //Romans 13:10 KJV
            "(322, 1, 661)," + //John 13:34 KJV
            "(323, 1, 662)," + //John 13:35 KJV
            "(324, 1, 663)," + //John 14:15 KJV
            "(325, 1, 664)," + //John 14:21 KJV
            "(326, 1, 665)," + //John 14:23 KJV
            "(327, 1, 666)," + //John 15:10 KJV
            "(328, 1, 667)," + //John 15:12 KJV
            "(329, 1, 668)," + //John 15:13 KJV
            "(330, 1, 669)," + //John 17:26 KJV
            "(331, 1, 670)," + //Isaiah 43:4 KJV
            "(332, 1, 671)," + //1 Thessalonians 3:12 KJV
            "(333, 1, 672)," + //2 Thessalonians 3:5 KJV
            "(334, 1, 673)," + //Galatians 5:6 KJV
            "(335, 1, 674)," + //Galatians 5:13 KJV
            "(336, 1, 675)," + //Galatians 5:14 KJV
            "(337, 1, 676)," + //Galatians 5:22-23 KJV
            "(338, 1, 677)," + //Colossians 3:14 KJV
            "(339, 1, 678)," + //1 Peter 4:8 KJV
            "(340, 1, 679)," + //Mark 12:30 KJV
            "(341, 1, 680)," + //Mark 12:31 KJV
            "(342, 1, 681)," + //1 Timothy 4:12 KJV
            "(343, 1, 682)," + //2 Timothy 1:7 KJV
            "(344, 1, 683)," + //Matthew 5:44 KJV
            "(345, 1, 684)," + //Luke 10:27 KJV
            "(346, 1, 685)," + //Jude 1:2 KJV
            "(347, 1, 686)," + //Hebrews 13:1 KJV
            "(348, 1, 687)," + //Revelation 3:19 KJV
            "(349, 1, 688)," + //Deuteronomy 6:5 KJV
            "(350, 1, 689)" ; //Song of Solomon 8:6 KJV

    public static final String INSERT_PROMESA_TEMA_ARREPENTIMIENTO_RVR60_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(351, 2, 690)," + //2 Crónicas 7:14 RVR60
            "(352, 2, 691)," + //1 Juan 1:9 RVR60
            "(353, 2, 692)," + //Mateo 4:17 RVR60
            "(354, 2, 693)," + //Mateo 9:13 RVR60
            "(355, 2, 694)," + //2 Pedro 3:9 RVR60
            "(356, 2, 695)," + //Hechos 2:38 RVR60
            "(357, 2, 696)," + //Hechos 3:19 RVR60
            "(358, 2, 697)," + //Santiago 4:8 RVR60
            "(359, 2, 698)," + //Joel 2:13 RVR60
            "(360, 2, 699)," + //Ezequiel 18:32 RVR60
            "(362, 2, 700)," + //Mateo 3:8 RVR60
            "(363, 2, 701)," + //Hechos 17:30 RVR60
            "(364, 2, 702)," + //2 Crónicas 30:9 RVR60
            "(365, 2, 703)," + //Lucas 15:10 RVR60
            "(366, 2, 704)," + //Marcos 1:15 RVR60
            "(367, 2, 705)," + //Proverbios 28:13 RVR60
            "(368, 2, 407)" ; //Apocalipsis 3:19 RVR60

    public static final String INSERT_PROMESA_TEMA_ARREPENTIMIENTO_NVI_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(369, 2, 706)," + //2 Crónicas 7:14 NVI
            "(370, 2, 707)," + //1 Juan 1:9 NVI
            "(371, 2, 708)," + //Mateo 4:17 NVI
            "(372, 2, 709)," + //Mateo 9:13 NVI
            "(373, 2, 710)," + //2 Pedro 3:9 NVI
            "(374, 2, 711)," + //Hechos 2:38 NVI
            "(375, 2, 712)," + //Hechos 3:19 NVI
            "(376, 2, 713)," + //Santiago 4:8 NVI
            "(377, 2, 714)," + //Joel 2:13 NVI
            "(378, 2, 715)," + //Ezequiel 18:32 NVI
            "(379, 2, 716)," + //Mateo 3:8 NVI
            "(380, 2, 717)," + //Hechos 17:30 NVI
            "(381, 2, 718)," + //2 Crónicas 30:9 NVI
            "(382, 2, 719)," + //Lucas 15:10 NVI
            "(383, 2, 720)," + //Marcos 1:15 NVI
            "(384, 2, 721)," + //Proverbios 28:13 NVI
            "(385, 2, 477)" ; //Apocalipsis 3:19 NVI

    public static final String INSERT_PROMESA_TEMA_ARREPENTIMIENTO_TLA_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(386, 2, 722)," + //2 Crónicas 7:14 TLA
            "(387, 2, 723)," + //1 Juan 1:9 TLA
            "(388, 2, 724)," + //Mateo 4:17 TLA
            "(389, 2, 725)," + //Mateo 9:13 TLA
            "(390, 2, 726)," + //2 Pedro 3:9 TLA
            "(391, 2, 727)," + //Hechos 2:38 TLA
            "(392, 2, 728)," + //Hechos 3:19 TLA
            "(393, 2, 729)," + //Santiago 4:8 TLA
            "(394, 2, 730)," + //Joel 2:13 TLA
            "(395, 2, 731)," + //Ezequiel 18:32 TLA
            "(396, 2, 732)," + //Mateo 3:8 TLA
            "(397, 2, 733)," + //Hechos 17:30 TLA
            "(398, 2, 734)," + //2 Crónicas 30:9 TLA
            "(399, 2, 735)," + //Lucas 15:10 TLA
            "(400, 2, 736)," + //Marcos 1:15 TLA
            "(401, 2, 737)," + //Proverbios 28:13 TLA
            "(402, 2, 547)" ; //Apocalipsis 3:19 TLA

    public static final String INSERT_PROMESA_TEMA_ARREPENTIMIENTO_NTV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(403, 2, 738)," + //2 Crónicas 7:14 NTV
            "(404, 2, 739)," + //1 Juan 1:9 NTV
            "(405, 2, 740)," + //Mateo 4:17 NTV
            "(406, 2, 741)," + //Mateo 9:13 NTV
            "(407, 2, 742)," + //2 Pedro 3:9 NTV
            "(408, 2, 743)," + //Hechos 2:38 NTV
            "(409, 2, 744)," + //Hechos 3:19 NTV
            "(410, 2, 745)," + //Santiago 4:8 NTV
            "(411, 2, 746)," + //Joel 2:13 NTV
            "(412, 2, 747)," + //Ezequiel 18:32 NTV
            "(413, 2, 748)," + //Mateo 3:8 NTV
            "(414, 2, 749)," + //Hechos 17:30 NTV
            "(415, 2, 750)," + //2 Crónicas 30:9 NTV
            "(416, 2, 751)," + //Lucas 15:10 NTV
            "(417, 2, 752)," + //Marcos 1:15 NTV
            "(418, 2, 753)," + //Proverbios 28:13 NTV
            "(419, 2, 617)" ; //Apocalipsis 3:19 NTV

    public static final String INSERT_PROMESA_TEMA_ARREPENTIMIENTO_KJV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(420, 2, 754)," + //2 Chronicles 7:14 KJV
            "(421, 2, 755)," + //1 John 1:9 KJV
            "(422, 2, 756)," + //Matthew 4:17 KJV
            "(423, 2, 757)," + //Matthew 9:13 KJV
            "(424, 2, 758)," + //2 Peter 3:9 KJV
            "(425, 2, 759)," + //Acts 2:38 KJV
            "(426, 2, 760)," + //Acts 3:19 KJV
            "(427, 2, 761)," + //James 4:8 KJV
            "(428, 2, 762)," + //Joel 2:13 KJV
            "(429, 2, 763)," + //Ezekiel 18:32 KJV
            "(430, 2, 764)," + //Matthew 3:8 KJV
            "(431, 2, 765)," + //Acts 17:30 KJV
            "(432, 2, 766)," + //2 Chronicles 30:9 KJV
            "(433, 2, 767)," + //Luke 15:10 KJV
            "(434, 2, 768)," + //Mark 1:15 KJV
            "(435, 2, 769)," + //Proverbs 28:13 KJV
            "(436, 2, 687)" ; //Revelation 3:19 KJV

    public static final String INSERT_PROMESA_TEMA_PACIENCIA_RVR60_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(437, 3, 770)," + //Salmos 37:7 RVR60
            "(438, 3, 771)," + //Proverbios 14:29 RVR60
            "(439, 3, 772)," + //Proverbios 16:32 RVR60
            "(440, 3, 773)," + //Romanos 8:25 RVR60
            "(441, 3, 774)," + //Romanos 12:12 RVR60
            "(442, 3, 775)," + //Colosenses 3:12 RVR60
            "(443, 3, 368)," + //Efesios 4:2 RVR60
            "(444, 3, 4)," + //Salmos 40:1 RVR60
            "(445, 3, 694)" ; //2 Pedro 3:9 RVR60

    public static final String INSERT_PROMESA_TEMA_PACIENCIA_NVI_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(446, 3, 776)," + //Salmos 37:7 NVI
            "(447, 3, 777)," + //Proverbios 14:29 NVI
            "(448, 3, 778)," + //Proverbios 16:32 NVI
            "(449, 3, 779)," + //Romanos 8:25 NVI
            "(450, 3, 780)," + //Romanos 12:12 NVI
            "(451, 3, 781)," + //Colosenses 3:12 NVI
            "(452, 3, 438)," + //Efesios 4:2 NVI
            "(453, 3, 5)," + //Salmos 40:1 NVI
            "(454, 3, 710)" ; //2 Pedro 3:9 NVI

    public static final String INSERT_PROMESA_TEMA_PACIENCIA_TLA_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(455, 3, 782)," + //Salmos 37:7 TLA
            "(456, 3, 783)," + //Proverbios 14:29 TLA
            "(457, 3, 784)," + //Proverbios 16:32 TLA
            "(458, 3, 785)," + //Romanos 8:25 TLA
            "(459, 3, 786)," + //Romanos 12:12 TLA
            "(460, 3, 787)," + //Colosenses 3:12 TLA
            "(461, 3, 508)," + //Efesios 4:2 TLA
            "(462, 3, 6)," + //Salmos 40:1 TLA
            "(463, 3, 726)" ; //2 Pedro 3:9 TLA

    public static final String INSERT_PROMESA_TEMA_PACIENCIA_NTV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(464, 3, 788)," + //Salmos 37:7 NTV
            "(465, 3, 789)," + //Proverbios 14:29 NTV
            "(466, 3, 790)," + //Proverbios 16:32 NTV
            "(467, 3, 791)," + //Romanos 8:25 NTV
            "(468, 3, 792)," + //Romanos 12:12 NTV
            "(469, 3, 793)," + //Colosenses 3:12 NTV
            "(470, 3, 578)," + //Efesios 4:2 NTV
            "(471, 3, 209)," + //Salmos 40:1 NTV
            "(472, 3, 742)" ; //2 Pedro 3:9 NTV

    public static final String INSERT_PROMESA_TEMA_PACIENCIA_KJV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(473, 3, 794)," + //Psalms 37:7 KJV
            "(474, 3, 795)," + //Proverbs 14:29 KJV
            "(475, 3, 796)," + //Proverbs 16:32 KJV
            "(476, 3, 797)," + //Romans 8:25 KJV
            "(477, 3, 798)," + //Romans 12:12 KJV
            "(478, 3, 799)," + //Colossians 3:12 KJV
            "(479, 3, 648)," + //Ephesians 4:2 KJV
            "(480, 3, 276)," + //Psalms 40:1 KJV
            "(481, 3, 758)" ; //2 Peter 3:9 KJV

    public static final String INSERT_PROMESA_TEMA_PERDON_RVR60_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(482, 4, 800)," + //Miqueas 7:18 RVR60
            "(483, 4, 801)," + //Salmos 32:5 RVR60
            "(484, 4, 802)," + //Salmos 86:5 RVR60
            "(485, 4, 803)," + //Proverbios 17:9 RVR60
            "(486, 4, 804)," + //Proverbios 28:13 RVR60
            "(487, 4, 805)," + //Mateo 6:12 RVR60
            "(488, 4, 806)," + //Mateo 6:14 RVR60
            "(489, 4, 807)," + //Lucas 6:37 RVR60
            "(490, 4, 808)," + //Hechos 13:38 RVR60
            "(491, 4, 809)," + //Efesios 1:7 RVR60
            "(492, 4, 810)," + //Efesios 4:32 RVR60
            "(493, 4, 811)," + //Colosenses 3:13 RVR60
            "(494, 4, 812)," + //1 Juan 2:2 RVR60
            "(495, 4, 695)" ; //Hechos 2:38 RVR60

    public static final String INSERT_PROMESA_TEMA_PERDON_NVI_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(496, 4, 813)," + //Miqueas 7:18 NVI
            "(497, 4, 814)," + //Salmos 32:5 NVI
            "(498, 4, 815)," + //Salmos 86:5 NVI
            "(499, 4, 816)," + //Proverbios 17:9 NVI
            "(500, 4, 817)," + //Proverbios 28:13 NVI
            "(501, 4, 818)," + //Mateo 6:12 NVI
            "(502, 4, 819)," + //Mateo 6:14 NVI
            "(503, 4, 820)," + //Lucas 6:37 NVI
            "(504, 4, 821)," + //Hechos 13:38 NVI
            "(505, 4, 822)," + //Efesios 1:7 NVI
            "(506, 4, 823)," + //Efesios 4:32 NVI
            "(507, 4, 824)," + //Colosenses 3:13 NVI
            "(508, 4, 825)," + //1 Juan 2:2 NVI
            "(509, 4, 711)" ; //Hechos 2:38 NVI

    public static final String INSERT_PROMESA_TEMA_PERDON_TLA_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(510, 4, 826)," + //Miqueas 7:18 TLA
            "(511, 4, 827)," + //Salmos 32:5 TLA
            "(512, 4, 828)," + //Salmos 86:5 TLA
            "(513, 4, 829)," + //Proverbios 17:9 TLA
            "(514, 4, 830)," + //Proverbios 28:13 TLA
            "(515, 4, 831)," + //Mateo 6:12 TLA
            "(516, 4, 832)," + //Mateo 6:14 TLA
            "(517, 4, 833)," + //Lucas 6:37 TLA
            "(518, 4, 834)," + //Hechos 13:38 TLA
            "(519, 4, 835)," + //Efesios 1:7 TLA
            "(520, 4, 836)," + //Efesios 4:32 TLA
            "(521, 4, 837)," + //Colosenses 3:13 TLA
            "(522, 4, 838)," + //1 Juan 2:2 TLA
            "(523, 4, 727)" ; //Hechos 2:38 TLA

    public static final String INSERT_PROMESA_TEMA_PERDON_NTV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(524, 4, 839)," + //Miqueas 7:18 NTV
            "(525, 4, 840)," + //Salmos 32:5 NTV
            "(526, 4, 841)," + //Salmos 86:5 NTV
            "(527, 4, 842)," + //Proverbios 17:9 NTV
            "(528, 4, 843)," + //Proverbios 28:13 NTV
            "(529, 4, 844)," + //Mateo 6:12 NTV
            "(530, 4, 845)," + //Mateo 6:14 NTV
            "(531, 4, 846)," + //Lucas 6:37 NTV
            "(532, 4, 847)," + //Hechos 13:38 NTV
            "(533, 4, 848)," + //Efesios 1:7 NTV
            "(534, 4, 849)," + //Efesios 4:32 NTV
            "(535, 4, 850)," + //Colosenses 3:13 NTV
            "(536, 4, 851)," + //1 Juan 2:2 NTV
            "(537, 4, 743)" ; //Hechos 2:38 NTV

    public static final String INSERT_PROMESA_TEMA_PERDON_KJV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(538, 4, 852)," + //Micah 7:18 KJV
            "(539, 4, 853)," + //Psalms 32:5 KJV
            "(540, 4, 854)," + //Psalms 86:5 KJV
            "(541, 4, 855)," + //Proverbs 17:9 KJV
            "(542, 4, 856)," + //Proverbs 28:13 KJV
            "(543, 4, 857)," + //Matthew 6:12 KJV
            "(544, 4, 858)," + //Matthew 6:14 KJV
            "(545, 4, 859)," + //Luke 6:37 KJV
            "(546, 4, 860)," + //Acts 13:38 KJV
            "(547, 4, 861)," + //Ephesians 1:7 KJV
            "(548, 4, 862)," + //Ephesians 4:32 KJV
            "(549, 4, 863)," + //Colossians 3:13 KJV
            "(550, 4, 864)," + //1 John 2:2 KJV
            "(551, 4, 759)" ; //Acts 2:38 KJV

    public static final String INSERT_PROMESA_TEMA_HUMILDAD_RVR60_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(552, 5, 865)," + //Salmos 25:8-9 RVR60
            "(553, 5, 866)," + //Salmos 115:1 RVR60
            "(554, 5, 867)," + //Salmos 149:4 RVR60
            "(555, 5, 868)," + //Proverbios 11:2 RVR60
            "(556, 5, 869)," + //Proverbios 15:33 RVR60
            "(557, 5, 870)," + //Proverbios 18:12 RVR60
            "(558, 5, 871)," + //Proverbios 22:4 RVR60
            "(559, 5, 872)," + //Proverbios 29:23 RVR60
            "(560, 5, 873)," + //Miqueas 6:8 RVR60
            "(561, 5, 874)," + //Mateo 6:2 RVR60
            "(562, 5, 875)," + //Mateo 11:29-30 RVR60
            "(563, 5, 876)," + //Marcos 9:35 RVR60
            "(564, 5, 877)," + //Marcos 10:45 RVR60
            "(565, 5, 878)," + //Lucas 9:48 RVR60
            "(566, 5, 879)," + //Juan 13:14 RVR60
            "(567, 5, 880)," + //Romanos 12:16 RVR60
            "(568, 5, 881)," + //Galatas 5:13 RVR60
            "(569, 5, 882)," + //Filipenses 2:3 RVR60
            "(570, 5, 883)," + //1 Corintios 1:28-29 RVR60
            "(571, 5, 884)," + //Santiago 3:13 RVR60
            "(572, 5, 885)," + //Santiago 4:10 RVR60
            "(573, 5, 886)," + //1 Pedro 3:3-4 RVR60
            "(574, 5, 887)," + //1 Pedro 3:8 RVR60
            "(575, 5, 888)," + //1 Pedro 5:6 RVR60
            "(576, 5, 690)," + //2 Crónicas 7:14 RVR60
            "(577, 5, 775)," + //Colosenses 3:12 RVR60
            "(578, 5, 368)" ; //Efesios 4:2 RVR60

    public static final String INSERT_PROMESA_TEMA_HUMILDAD_NVI_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(579, 5, 889)," + //Salmos 25:8-9 NVI
            "(580, 5, 890)," + //Salmos 115:1 NVI
            "(581, 5, 891)," + //Salmos 149:4 NVI
            "(582, 5, 892)," + //Proverbios 11:2 NVI
            "(583, 5, 893)," + //Proverbios 15:33 NVI
            "(584, 5, 894)," + //Proverbios 18:12 NVI
            "(585, 5, 895)," + //Proverbios 22:4 NVI
            "(586, 5, 896)," + //Proverbios 29:23 NVI
            "(587, 5, 897)," + //Miqueas 6:8 NVI
            "(588, 5, 898)," + //Mateo 6:2 NVI
            "(589, 5, 899)," + //Mateo 11:29-30 NVI
            "(590, 5, 900)," + //Marcos 9:35 NVI
            "(591, 5, 901)," + //Marcos 10:45 NVI
            "(592, 5, 902)," + //Lucas 9:48 NVI
            "(593, 5, 903)," + //Juan 13:14 NVI
            "(594, 5, 904)," + //Romanos 12:16 NVI
            "(595, 5, 905)," + //Galatas 5:13 NVI
            "(596, 5, 906)," + //Filipenses 2:3 NVI
            "(597, 5, 907)," + //1 Corintios 1:28-29 NVI
            "(598, 5, 908)," + //Santiago 3:13 NVI
            "(599, 5, 909)," + //Santiago 4:10 NVI
            "(600, 5, 910)," + //1 Pedro 3:3-4 NVI
            "(601, 5, 911)," + //1 Pedro 3:8 NVI
            "(602, 5, 912)," + //1 Pedro 5:6 NVI
            "(603, 5, 706)," + //2 Crónicas 7:14 NVI
            "(604, 5, 781)," + //Colosenses 3:12 NVI
            "(605, 5, 438)" ; //Efesios 4:2 NVI

    public static final String INSERT_PROMESA_TEMA_HUMILDAD_TLA_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(606, 5, 913)," + //Salmos 25:8-9 TLA
            "(607, 5, 914)," + //Salmos 115:1 TLA
            "(608, 5, 915)," + //Salmos 149:4 TLA
            "(609, 5, 916)," + //Proverbios 11:2 TLA
            "(610, 5, 917)," + //Proverbios 15:33 TLA
            "(611, 5, 918)," + //Proverbios 18:12 TLA
            "(612, 5, 919)," + //Proverbios 22:4 TLA
            "(613, 5, 920)," + //Proverbios 29:23 TLA
            "(614, 5, 921)," + //Miqueas 6:8 TLA
            "(615, 5, 922)," + //Mateo 6:2 TLA
            "(616, 5, 923)," + //Mateo 11:29-30 TLA
            "(617, 5, 924)," + //Marcos 9:35 TLA
            "(618, 5, 925)," + //Marcos 10:45 TLA
            "(619, 5, 926)," + //Lucas 9:48 TLA
            "(620, 5, 927)," + //Juan 13:14 TLA
            "(621, 5, 928)," + //Romanos 12:16 TLA
            "(622, 5, 929)," + //Galatas 5:13 TLA
            "(623, 5, 930)," + //Filipenses 2:3 TLA
            "(624, 5, 931)," + //1 Corintios 1:28-29 TLA
            "(625, 5, 932)," + //Santiago 3:13 TLA
            "(626, 5, 933)," + //Santiago 4:10 TLA
            "(627, 5, 934)," + //1 Pedro 3:3-4 TLA
            "(628, 5, 935)," + //1 Pedro 3:8 TLA
            "(629, 5, 936)," + //1 Pedro 5:6 TLA
            "(630, 5, 722)," + //2 Crónicas 7:14 TLA
            "(631, 5, 787)," + //Colosenses 3:12 TLA
            "(632, 5, 508)" ; //Efesios 4:2 TLA

    public static final String INSERT_PROMESA_TEMA_HUMILDAD_NTV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(633, 5, 937)," + //Salmos 25:8-9 NTV
            "(634, 5, 938)," + //Salmos 115:1 NTV
            "(635, 5, 939)," + //Salmos 149:4 NTV
            "(636, 5, 940)," + //Proverbios 11:2 NTV
            "(637, 5, 941)," + //Proverbios 15:33 NTV
            "(638, 5, 942)," + //Proverbios 18:12 NTV
            "(639, 5, 943)," + //Proverbios 22:4 NTV
            "(640, 5, 944)," + //Proverbios 29:23 NTV
            "(641, 5, 945)," + //Miqueas 6:8 NTV
            "(642, 5, 946)," + //Mateo 6:2 NTV
            "(643, 5, 947)," + //Mateo 11:29-30 NTV
            "(644, 5, 948)," + //Marcos 9:35 NTV
            "(645, 5, 949)," + //Marcos 10:45 NTV
            "(646, 5, 950)," + //Lucas 9:48 NTV
            "(647, 5, 951)," + //Juan 13:14 NTV
            "(648, 5, 952)," + //Romanos 12:16 NTV
            "(649, 5, 953)," + //Galatas 5:13 NTV
            "(650, 5, 954)," + //Filipenses 2:3 NTV
            "(651, 5, 955)," + //1 Corintios 1:28-29 NTV
            "(652, 5, 956)," + //Santiago 3:13 NTV
            "(653, 5, 957)," + //Santiago 4:10 NTV
            "(654, 5, 958)," + //1 Pedro 3:3-4 NTV
            "(655, 5, 959)," + //1 Pedro 3:8 NTV
            "(656, 5, 960)," + //1 Pedro 5:6 NTV
            "(657, 5, 738)," + //2 Crónicas 7:14 NTV
            "(658, 5, 793)," + //Colosenses 3:12 NTV
            "(659, 5, 578)" ; //Efesios 4:2 NTV

    public static final String INSERT_PROMESA_TEMA_HUMILDAD_KJV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(660, 5, 961)," + //Psalms 25:8-9 KJV
            "(661, 5, 962)," + //Psalms 115:1 KJV
            "(662, 5, 963)," + //Psalms 149:4 KJV
            "(663, 5, 964)," + //Proverbs 11:2 KJV
            "(664, 5, 965)," + //Proverbs 15:33 KJV
            "(665, 5, 966)," + //Proverbs 18:12 KJV
            "(666, 5, 967)," + //Proverbs 22:4 KJV
            "(667, 5, 968)," + //Proverbs 29:23 KJV
            "(668, 5, 969)," + //Micah 6:8 KJV
            "(669, 5, 970)," + //Matthew 6:2 KJV
            "(670, 5, 971)," + //Matthew 11:29-30 KJV
            "(671, 5, 972)," + //Mark 9:35 KJV
            "(672, 5, 973)," + //Mark 10:45 KJV
            "(673, 5, 974)," + //Luke 9:48 KJV
            "(674, 5, 975)," + //John 13:14 KJV
            "(675, 5, 976)," + //Romans 12:16 KJV
            "(676, 5, 977)," + //Galatians 5:13 KJV
            "(677, 5, 978)," + //Philippians 2:3 KJV
            "(678, 5, 979)," + //1 Corinthians 1:28-29 KJV
            "(679, 5, 980)," + //James 3:13 KJV
            "(680, 5, 981)," + //James 4:10 KJV
            "(681, 5, 982)," + //1 Peter 3:3-4 KJV
            "(682, 5, 983)," + //1 Peter 3:8 KJV
            "(683, 5, 984)," + //1 Peter 5:6 KJV
            "(684, 5, 754)," + //2 Chronicles 7:14 KJV
            "(685, 5, 799)," + //Colossians 3:12 KJV
            "(686, 5, 648)" ; //Ephesians 4:2 KJV

    public static final String INSERT_PROMESA_TEMA_SABIDURIA_RVR60_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(687, 6, 985)," + //Isaías 28:29 RVR60
            "(688, 6, 986)," + //Daniel 2:23 RVR60
            "(689, 6, 987)," + //Eclesiastés 7:10 RVR60
            "(690, 6, 988)," + //Eclesiastés 10:12 RVR60
            "(691, 6, 989)," + //Salmos 90:12 RVR60
            "(692, 6, 990)," + //Proverbios 1:7 RVR60
            "(693, 6, 991)," + //Proverbios 2:6 RVR60
            "(694, 6, 992)," + //Proverbios 4:7 RVR60
            "(695, 6, 993)," + //Proverbios 9:10 RVR60
            "(696, 6, 994)," + //Proverbios 10:8 RVR60
            "(697, 6, 995)," + //Proverbios 11:9 RVR60
            "(698, 6, 996)," + //Proverbios 13:10 RVR60
            "(699, 6, 997)," + //Proverbios 15:5 RVR60
            "(700, 6, 998)," + //Proverbios 16:16 RVR60
            "(701, 6, 999)," + //Proverbios 17:28 RVR60
            "(702, 6, 1000)," + //Proverbios 18:6 RVR60
            "(703, 6, 1001)," + //Proverbios 19:8 RVR60
            "(704, 6, 1002)," + //Proverbios 23:24 RVR60
            "(705, 6, 1003)," + //Colosenses 4:5-6 RVR60
            "(706, 6, 1004)," + //Efesios 1:17 RVR60
            "(707, 6, 1005)," + //Efesios 5:15-16 RVR60
            "(708, 6, 1006)," + //Romanos 11:33 RVR60
            "(709, 6, 1007)," + //Romanos 14:5 RVR60
            "(710, 6, 1008)," + //Santiago 1:5 RVR60
            "(711, 6, 1009)," + //Santiago 3:17 RVR60
            "(712, 6, 1010)," + //1 Corintios 3:18 RVR60
            "(713, 6, 884)," + //Santiago 3:13 RVR60
            "(714, 6, 868)," + //Proverbios 11:2 RVR60
            "(715, 6, 869)" ; //Proverbios 15:33 RVR60

    public static final String INSERT_PROMESA_TEMA_SABIDURIA_NVI_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(716, 6, 1011)," + //Isaías 28:29 NVI
            "(717, 6, 1012)," + //Daniel 2:23 NVI
            "(718, 6, 1013)," + //Eclesiastés 7:10 NVI
            "(719, 6, 1014)," + //Eclesiastés 10:12 NVI
            "(720, 6, 1015)," + //Salmos 90:12 NVI
            "(721, 6, 1016)," + //Proverbios 1:7 NVI
            "(722, 6, 1017)," + //Proverbios 2:6 NVI
            "(723, 6, 1018)," + //Proverbios 4:7 NVI
            "(724, 6, 1019)," + //Proverbios 9:10 NVI
            "(725, 6, 1020)," + //Proverbios 10:8 NVI
            "(726, 6, 1021)," + //Proverbios 11:9 NVI
            "(727, 6, 1022)," + //Proverbios 13:10 NVI
            "(728, 6, 1023)," + //Proverbios 15:5 NVI
            "(729, 6, 1024)," + //Proverbios 16:16 NVI
            "(730, 6, 1025)," + //Proverbios 17:28 NVI
            "(731, 6, 1026)," + //Proverbios 18:6 NVI
            "(732, 6, 1027)," + //Proverbios 19:8 NVI
            "(733, 6, 1028)," + //Proverbios 23:24 NVI
            "(734, 6, 1029)," + //Colosenses 4:5-6 NVI
            "(735, 6, 1030)," + //Efesios 1:17 NVI
            "(736, 6, 1031)," + //Efesios 5:15-16 NVI
            "(737, 6, 1032)," + //Romanos 11:33 NVI
            "(738, 6, 1033)," + //Romanos 14:5 NVI
            "(739, 6, 1034)," + //Santiago 1:5 NVI
            "(740, 6, 1035)," + //Santiago 3:17 NVI
            "(741, 6, 1036)," + //1 Corintios 3:18 NVI
            "(742, 6, 908)," + //Santiago 3:13 NVI
            "(743, 6, 892)," + //Proverbios 11:2 NVI
            "(744, 6, 893)" ; //Proverbios 15:33 NVI

    public static final String INSERT_PROMESA_TEMA_SABIDURIA_TLA_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(745, 6, 1037)," + //Isaías 28:29 TLA
            "(746, 6, 1038)," + //Daniel 2:23 TLA
            "(747, 6, 1039)," + //Eclesiastés 7:10 TLA
            "(748, 6, 1040)," + //Eclesiastés 10:12 TLA
            "(749, 6, 1041)," + //Salmos 90:12 TLA
            "(750, 6, 1042)," + //Proverbios 1:7 TLA
            "(751, 6, 1043)," + //Proverbios 2:6 TLA
            "(752, 6, 1044)," + //Proverbios 4:7 TLA
            "(753, 6, 1045)," + //Proverbios 9:10 TLA
            "(754, 6, 1046)," + //Proverbios 10:8 TLA
            "(755, 6, 1047)," + //Proverbios 11:9 TLA
            "(756, 6, 1048)," + //Proverbios 13:10 TLA
            "(757, 6, 1049)," + //Proverbios 15:5 TLA
            "(758, 6, 1050)," + //Proverbios 16:16 TLA
            "(759, 6, 1051)," + //Proverbios 17:28 TLA
            "(760, 6, 1052)," + //Proverbios 18:6 TLA
            "(761, 6, 1053)," + //Proverbios 19:8 TLA
            "(762, 6, 1054)," + //Proverbios 23:24 TLA
            "(763, 6, 1055)," + //Colosenses 4:5-6 TLA
            "(764, 6, 1056)," + //Efesios 1:17 TLA
            "(765, 6, 1057)," + //Efesios 5:15-16 TLA
            "(766, 6, 1058)," + //Romanos 11:33 TLA
            "(767, 6, 1059)," + //Romanos 14:5 TLA
            "(768, 6, 1060)," + //Santiago 1:5 TLA
            "(769, 6, 1061)," + //Santiago 3:17 TLA
            "(770, 6, 1062)," + //1 Corintios 3:18 TLA
            "(771, 6, 932)," + //Santiago 3:13 TLA
            "(772, 6, 916)," + //Proverbios 11:2 TLA
            "(773, 6, 917)" ; //Proverbios 15:33 TLA

    public static final String INSERT_PROMESA_TEMA_SABIDURIA_NTV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(774, 6, 1063)," + //Isaías 28:29 NTV
            "(775, 6, 1064)," + //Daniel 2:23 NTV
            "(776, 6, 1065)," + //Eclesiastés 7:10 NTV
            "(777, 6, 1066)," + //Eclesiastés 10:12 NTV
            "(778, 6, 1067)," + //Salmos 90:12 NTV
            "(779, 6, 1068)," + //Proverbios 1:7 NTV
            "(780, 6, 1069)," + //Proverbios 2:6 NTV
            "(781, 6, 1070)," + //Proverbios 4:7 NTV
            "(782, 6, 1071)," + //Proverbios 9:10 NTV
            "(783, 6, 1072)," + //Proverbios 10:8 NTV
            "(784, 6, 1073)," + //Proverbios 11:9 NTV
            "(785, 6, 1074)," + //Proverbios 13:10 NTV
            "(786, 6, 1075)," + //Proverbios 15:5 NTV
            "(787, 6, 1076)," + //Proverbios 16:16 NTV
            "(788, 6, 1077)," + //Proverbios 17:28 NTV
            "(789, 6, 1078)," + //Proverbios 18:6 NTV
            "(790, 6, 1079)," + //Proverbios 19:8 NTV
            "(791, 6, 1080)," + //Proverbios 23:24 NTV
            "(792, 6, 1081)," + //Colosenses 4:5-6 NTV
            "(793, 6, 1082)," + //Efesios 1:17 NTV
            "(794, 6, 1083)," + //Efesios 5:15-16 NTV
            "(795, 6, 1084)," + //Romanos 11:33 NTV
            "(796, 6, 1085)," + //Romanos 14:5 NTV
            "(797, 6, 1086)," + //Santiago 1:5 NTV
            "(798, 6, 1087)," + //Santiago 3:17 NTV
            "(799, 6, 1088)," + //1 Corintios 3:18 NTV
            "(800, 6, 956)," + //Santiago 3:13 NTV
            "(801, 6, 940)," + //Proverbios 11:2 NTV
            "(802, 6, 941)" ; //Proverbios 15:33 NTV

    public static final String INSERT_PROMESA_TEMA_SABIDURIA_KJV_SCRIPT =
        "insert into " + PROMESA_TEMA_TABLE_NAME + " values" +
            "(803, 6, 1089)," + //Isaiah 28:29 KJV
            "(804, 6, 1090)," + //Daniel 2:23 KJV
            "(805, 6, 1091)," + //Ecclesiastes 7:10 KJV
            "(806, 6, 1092)," + //Ecclesiastes 10:12 KJV
            "(807, 6, 1093)," + //Psalms 90:12 KJV
            "(808, 6, 1094)," + //Proverbs 1:7 KJV
            "(809, 6, 1095)," + //Proverbs 2:6 KJV
            "(810, 6, 1096)," + //Proverbs 4:7 KJV
            "(811, 6, 1097)," + //Proverbs 9:10 KJV
            "(812, 6, 1098)," + //Proverbs 10:8 KJV
            "(813, 6, 1099)," + //Proverbs 11:9 KJV
            "(814, 6, 1100)," + //Proverbs 13:10 KJV
            "(815, 6, 1101)," + //Proverbs 15:5 KJV
            "(816, 6, 1102)," + //Proverbs 16:16 KJV
            "(817, 6, 1103)," + //Proverbs 17:28 KJV
            "(818, 6, 1104)," + //Proverbs 18:6 KJV
            "(819, 6, 1105)," + //Proverbs 19:8 KJV
            "(820, 6, 1106)," + //Proverbs 23:24 KJV
            "(821, 6, 1107)," + //Colossians 4:5-6 KJV
            "(822, 6, 1108)," + //Ephesians 1:17 KJV
            "(823, 6, 1109)," + //Ephesians 5:15-16 KJV
            "(824, 6, 1110)," + //Romans 11:33 KJV
            "(825, 6, 1111)," + //Romans 14:5 KJV
            "(826, 6, 1112)," + //James 1:5 KJV
            "(827, 6, 1113)," + //James 3:17 KJV
            "(828, 6, 1114)," + //1 Corinthians 3:18 KJV
            "(829, 6, 980)," + //James 3:13 KJV
            "(830, 6, 964)," + //Proverbs 11:2 KJV
            "(831, 6, 965)" ; //Proverbs 15:33 KJV

    //Scripts de Drops de las tablas
    public static final String DROP_TABLE_VERSION_SCRIPT = "drop table if exists " + VERSION_TABLE_NAME;

    public static final String DROP_TABLE_LIBRO_SCRIPT = "drop table if exists " + LIBRO_TABLE_NAME;

    public static final String DROP_TABLE_VERSICULO_SCRIPT = "drop table if exists " + VERSICULO_TABLE_NAME;

    public static final String DROP_TABLE_PROMESA_SCRIPT = "drop table if exists " + PROMESA_TABLE_NAME;

    public static final String DROP_TABLE_TEMA_SCRIPT = "drop table if exists " + TEMA_TABLE_NAME;

    public static final String DROP_TABLE_PROMESA_TEMA_SCRIPT = "drop table if exists " + PROMESA_TEMA_TABLE_NAME;

    public DataSource(Context context) {
        DbHelper openHelper = new DbHelper(context);
        //Creando una instancia hacia la base de datos
        SQLiteDatabase database = openHelper.getWritableDatabase();
    }


}
