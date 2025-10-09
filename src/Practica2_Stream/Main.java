package Practica2_Stream;

import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {

        String ruta1 = "C:\\Users\\Andrea\\Desktop\\texto1.txt";
        String ruta2 = "C:\\Users\\Andrea\\Desktop\\texto2.txt";

        String nombres = "Tanjiro\n" +
                "Nezuko\n" +
                "Muzan";

        CrearArchivo(ruta1,nombres);
        AñadirContenido(ruta1,ruta2);

    }
    public static void CrearArchivo (String ruta, String contenido) {

        try (FileWriter wp = new FileWriter(ruta)) {
            wp.write(contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void AñadirContenido (String ruta, String ruta2) throws IOException {

        FileInputStream in = new FileInputStream(ruta);
        FileOutputStream out = new FileOutputStream(ruta2,true);

        int caracter;
        try {
            while ((caracter = in.read())!= -1) {
                out.write(caracter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        in.close();
        out.close();
    }

}