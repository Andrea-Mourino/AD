package Practica2_Stream;

import java.io.*;

public class Parte2 {
    public static void main(String[] args) throws IOException {

        String ruta1 = "C:\\Users\\Andrea\\Desktop\\mydeiSilly.jpg";
        String ruta2 = "C:\\Users\\Andrea\\Desktop\\mydeiSilly2.jpg";

        fotoCopiada2(ruta1, ruta2);
        fotoCopiada(ruta1, ruta2);
    }

     public static void fotoCopiada(String ruta1, String ruta2) throws IOException {

        FileInputStream in = new FileInputStream(ruta1);
        FileOutputStream out = new FileOutputStream(ruta2, true);

        int caracter;
        try {
            while ((caracter = in.read()) != -1) {
             out.write(caracter);
            }
        } catch (IOException e) {
        }

        in.close();
        out.close();
        System.out.println("Se a escrito os datos no archivo destinado.");
     }

    public static void fotoCopiada2(String ruta1, String ruta2) throws IOException {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(ruta1));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(ruta2));

        int caracter = 0;
        byte[] p = new byte[in.available()];
        try {
            int bite;
            while ((bite = in.read()) != -1) {
                byte b = (byte) bite;
                p[caracter] = b;
                caracter++;
            }
            out.write(p);
        } catch (IOException e) {
        }

        in.close();
        out.close();
    }
}
