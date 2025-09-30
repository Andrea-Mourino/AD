import java.io.*;
import java.util.Arrays;

public class Main  {
    public static void main(String[] args) throws IOException {

        String ruta1 = "Input-Output_Stream/texto1.txt";
        String ruta2 = "Input-Output_Stream/texto2.txt";

        AñadirContenido(ruta1,ruta2);

    }
    public static void CrearArchivo(String ruta, String contenido) {
        try (FileWriter fw = new FileWriter(ruta)) {
            fw.write(contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CopiarArchivo(String ruta, String ruta2) throws IOException {

        FileInputStream in = new FileInputStream(ruta);
        FileOutputStream out = new FileOutputStream(ruta2);

        int caracter= 0;
        byte[] pb = new byte[in.available()];
        System.out.println("mensaje de depuracion (bytes leidos) " + Arrays.toString(pb));

        try {
            while (true){
                int bytesLeidos = in.read();
                if (bytesLeidos == -1) {
                    break;

                } else {
                    byte bp = (byte) bytesLeidos;
                    pb[caracter] = bp;
                    caracter++;
                }
            }
            System.out.println("mensaje de depuracion (ver si se copian) " + Arrays.toString(pb));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        out.write(pb);
        System.out.println("datos escritos en el archivo de destino.");

        in.close();
        out.close();

    }

    public static void AñadirContenido (String ruta, String ruta2) throws IOException {
        FileInputStream in = new FileInputStream(ruta);
        FileOutputStream out = new FileOutputStream(ruta2,true);
        int caracter;
        try {
            while ((caracter = in.read())!= -1) {
                out.write(caracter);
            }
            System.out.println("mensaje de depuracion (comprobar si llega a leer todos los bytes) -> " + caracter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        in.close();
        out.close();
    }

} //pueba