import java.io.*;
import java.util.ArrayList;

public class Serializacion {
    public static void escribirListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("serial.dat"))) {
            escritor.writeObject(listaVehiculos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Vehiculo> leerListaVehiculo(){
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            ArrayList<Vehiculo> listaleida = (ArrayList<Vehiculo>) lector.readObject();
            return listaleida;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Vehiculo> leerListaVehiculoUnoaUno() {
        ArrayList<Vehiculo> listaleidaUnoaUno = new ArrayList<>();
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            while (true) {
                Vehiculo vtemp = (Vehiculo) lector.readObject();
                listaleidaUnoaUno.add(vtemp);
            }
            //En caso de que por ejemplo te pida leer 5 vehiculos de la lista quitar el while y poner este for
//            for(int i=0; i<5; i++) {
//                Vehiculo vtemp= (Vehiculo) lector.readObject();
//                listaleidaUnoaUno.add(vtemp);
//            }
        } catch (EOFException e) {
            System.out.println("Llego al final del archivo");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaleidaUnoaUno;
    }



}
