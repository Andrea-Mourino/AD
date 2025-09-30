import java.io.*;

public class Parte3 {
    public static void main(String[] args) throws FileNotFoundException {

        String direccion = "C:\\Users\\Andrea\\Desktop\\texto3.txt";

        escribirTexto(direccion);
    }


    static void escribirTexto(String ruta) throws RuntimeException {
        String frase = "o tempo está xélido";

        try (FileOutputStream pb = new FileOutputStream(ruta);
             DataOutputStream pd = new DataOutputStream(pb)) {

            for (int i = 0; i <= 2; i++) {
                System.out.println("Escribendo: " + frase);
                pd.writeUTF(frase);
                System.out.println("tamaño do fichero: " + pd.size() + " bytes");
            }
            System.out.println("Tamaño final do fichero: " + pd.size() + " bytes");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileInputStream wp = new FileInputStream(ruta);
             DataInputStream pw = new DataInputStream(wp)) {

            for (int i = 0; i <= 2; i++) {
                System.out.println("quedan: " + wp.available() + " bytes por ler");
                System.out.println("Cadea: " + pw.readUTF());
            }
            System.out.println("Xa non queda nada por ler");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
