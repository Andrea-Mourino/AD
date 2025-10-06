import java.io.File;
    class App {
        public static final String directorio = "C:\\Users\\Andrea\\Desktop\\DAM2\\AD\\arquivosdir\\Products1.txt";
        public static String arquivosdir = "C:\\Users\\Andrea\\Desktop\\DAM2\\AD\\arquivosdir";
        public static String subdir = "C:\\Users\\Andrea\\Desktop\\DAM2\\AD\\arquivosdir\\subdir";
        public static String products2_txt = "C:\\Users\\Andrea\\Desktop\\DAM2\\AD\\arquivosdir\\subdir\\Products2.txt";


        public static void ejercicio1() {
            Fichero1.crearDirectorio(arquivosdir);
            System.out.println(Fichero1.eDirectorio(arquivosdir));
        }

        public static void ejercicio2() {
            Fichero1.crearFicheiro(arquivosdir, "Products1.txt");
            System.out.printf(Fichero1.eFicheiro(products2_txt));
        }

        public static void ejercicio3() {
            System.out.println(Fichero1.crearDirectorio(subdir));
            System.out.println(Fichero1.crearFicheiro(subdir, "product2_txt"));
        }

        public static void ejercicio4() {
            Fichero1.mContido(arquivosdir);
        }

        public static void main(String[] args) {
            ejercicio1();

        }


        public static void ejercicio5() {
            Fichero1.modoAcceso(arquivosdir, "Products1.txt");
            Fichero1.calculaLonxitude(arquivosdir, "Products1.txt");
        }

        public static void ejercicio6() {
            Fichero1.mLectura(arquivosdir, "Products1.txt");
        }

        public static void ejercicio7() {
            System.out.println(Fichero1.mEscritura(arquivosdir, "Products1.txt"));
        }

        public static void ejercicio8() {
            Fichero1.borrarFicheiro(arquivosdir, "Products1.txt");
        }

        public static void ejercicio9() {
            Fichero1.borrarFicheiro(subdir, "product2_txt");
            Fichero1.borrarDirectorio(subdir);
            Fichero1.borrarDirectorio(arquivosdir);
        }


        public static void ejercicio10() {
            File file = new File(arquivosdir);
            Fichero1.recur(file);
        }

    }

    public class Fichero1 {

        public static String eDirectorio(String ruta) {
            File archivo = new File(ruta);
            if (archivo.isDirectory()) {
                return "é directorio";
            } else {
                return "non é directorio";
            }
        }

        public static String eFicheiro(String ruta) {
            File archivo = new File(ruta);
            if (archivo.isFile()) {
                return "é ficheiro";
            } else {
                return "non é ficheiro";
            }
        }

        public static boolean crearDirectorio(String ruta) {
            File file = new File(ruta);
            if(!file.exists()){
                return file.mkdirs();
            }
            return false;
        }

        public static boolean crearFicheiro(String ruta, String nomFichero) {
            File file = new File(ruta, nomFichero);
            if (!file.exists()) {
                try {
                    return file.createNewFile();
                } catch (Exception e) {
                    System.out.println("Error al crear el fichero: " + e.getMessage());
                    return false;
                }
            }
            return false;
        }

        public static boolean modoAcceso(String dirName, String fileName) {
            File file = new File(dirName, fileName);
            if (file.exists()) {
                if (file.canRead())
                    System.out.println("lectura si");
                else
                    System.out.println("lectura non");
                if (file.canWrite())
                    System.out.println("escritura si");
                else
                    System.out.println("escritura non");
                return true;
            }
            return false;
        }

        public static boolean calculaLonxitude(String dirName, String fileName) {
            File file = new File(dirName, fileName);
            if(file.exists()){
                System.out.println(file.length());
                return true;
            }
            return false;
        }


        public static void mLectura(String dirName, String fileName) {
            File file = new File(dirName, fileName);
            if (file.exists()) {
                file.setReadOnly();
            }
        }

        public static boolean mEscritura(String dirName, String fileName) {
            File file = new File(dirName, fileName);
            if(file.exists() && !file.canWrite()){
                return file.setWritable(true);
            }
            return false;
        }

        public static void borrarFicheiro(String dirName, String fileName) {
            File file = new File(dirName, fileName);
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Ficheiro eliminado correctamente");
                } else {
                    System.out.println("Non se puido eliminar o ficheiro");
                }
            } else {
                System.out.println("Ficheiro inexistente");
            }
        }

        public static void borrarDirectorio(String dirName){
            File dir = new File(dirName);
            if (dir.exists()) {
                if (dir.isDirectory() && dir.list().length == 0) {
                    dir.delete();
                    System.out.println("Directorio eliminado correctamente");
                } else {
                    System.out.println("ruta inexistente ou con descendencia");
                }
            } else {
                System.out.println("Ruta inexistente");
            }
        }

        public static void mContido (String dirName) {
            File dir = new File(dirName);
            if (dir.exists()) {
                String[] ficheros = dir.list();
                for (String fichero : ficheros) {
                    System.out.println(fichero);
                }
            } else {
                System.out.println("El directorio no existe");
            }
        }

        public static void recur(File file) {
            if (file.isDirectory()) {
                System.out.println("Directorio: " + file.getAbsolutePath());
                File[] ficheros = file.listFiles();
                if (ficheros != null) {
                    for (File f : ficheros) {
                        System.out.print("   " + f.getName());
                        recur(f);
                    }
                    System.out.print("\n");
                }
            }
        }

    }

