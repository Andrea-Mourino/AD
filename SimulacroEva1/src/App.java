import java.sql.Connection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Connection conx = Conexion.conexionMetodo();
        Vehiculo v1 = new Vehiculo("Mustang","Ford",2021,"Deportimos americanos iconicos");
        Vehiculo v2 = new Vehiculo("Model S","Tesla",2023,"Sedán eléctrico de luxo con gran autonomía");
        Vehiculo v3 = new Vehiculo("Civic Type R", "Honda", 2022, "Compacto deportivo con alto rendimiento y diseño agresivo.");
        Vehiculo v4 = new Vehiculo("911 Carrera", "Porsche", 2021, "Clásico deportivo alemán con ingeniería de precisión.");
        Vehiculo v5 = new Vehiculo("A4", "Audi", 2020, "Berlina elegante con excelente equilibrio entre confort y potencia.");
        Vehiculo v6 = new Vehiculo("CX-5", "Mazda", 2022, "SUV versátil con gran eficiencia y diseño atractivo.");
        Vehiculo v7 = new Vehiculo("F-150 Raptor", "Ford", 2023, "Pickup todoterreno potente y resistente para cualquier terreno.");
        Vehiculo v8 = new Vehiculo("Camry", "Toyota", 2021, "Sedán confiable con tecnología avanzada y excelente economía de combustible.");
        Vehiculo v9 = new Vehiculo("Challenger Hellcat", "Dodge", 2022, "Muscle car con motor V8 sobrealimentado y estilo retro.");
        Vehiculo v10 = new Vehiculo("Defender", "Land Rover", 2023, "SUV todoterreno premium con capacidades extremas y diseño moderno.");
        Vehiculo v11 = new Vehiculo("Aventador", "Lamborghini", 2021, "Superdeportivo italiano con motor V12 y diseño radical.");
        Vehiculo v12 = new Vehiculo("i4", "BMW", 2023, "Coupé eléctrico con alto rendimiento y tecnología de última generación.");

//        CRUD.insertarVehiculo(v3);
//        CRUD.insertarVehiculo(v4);
//        CRUD.insertarVehiculo(v5);
//        CRUD.insertarVehiculo(v6);
//        CRUD.insertarVehiculo(v7);
//        CRUD.insertarVehiculo(v8);
//        CRUD.insertarVehiculo(v9);
//        CRUD.insertarVehiculo(v10);
//        CRUD.insertarVehiculo(v11);
//        CRUD.insertarVehiculo(v12);

//        CRUD.insertarVehiculo(v1);
//        CRUD.insertarVehiculo(v2);
//        CRUD.eliminarVehiculo(3);
        ArrayList<Vehiculo> miLista= CRUD.leerVehiculos();
        for(Vehiculo v: miLista){
            System.out.println(v);
        }

//        Vehiculo n = new Vehiculo("Mustang","Ford",2023,"Deportimos americanos iconicos");
//        CRUD.actualizarVehiculo(n,1);

        System.out.println("------------------------------");
        Serializacion.escribirListaVehiculos(miLista);

        //si queremos usar este metodo cambiar Serializacion.leerListaVehiculo por .leerListaVehiculoUnoaUno
        ArrayList<Vehiculo> miListaS = Serializacion.leerListaVehiculo();
        for(Vehiculo v: miListaS){
            System.out.println(v);
        }

        GeneradorDeVehiculosXML.escribirListaVehiculosXML(miListaS);

    }



}
