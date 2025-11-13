import model.Adestrador;
import model.Pokedex;
import service.AdestradorService;
import service.PokedexService;
import utils.AdestradoresXML;
import utils.PokedexXML;

import javax.xml.stream.XMLStreamException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PokedexService.insertPokedex(new Pokedex("Pikachu", 10, "Es adorable"));
        PokedexService.insertPokedex(new Pokedex("Charizar", 10, "Es adorable"));
        PokedexService.insertPokedex(new Pokedex("Eeevee", 10, "Es una bolita de pelo"));
        PokedexService.insertPokedex(new Pokedex("Snivy", 5, "Es adorable"));
        PokedexService.insertPokedex(new Pokedex("Bulbasur", 2, "Es mid"));
        PokedexService.insertPokedex(new Pokedex("Pichu", 15.8, "Es enano"));
        PokedexService.insertPokedex(new Pokedex("Raichu", 1, "Es monisimo"));
        PokedexService.insertPokedex(new Pokedex("Mew", 6, "Es adorable"));
        PokedexService.insertPokedex(new Pokedex("Mewtwo", 80, "Es adorable"));
        PokedexService.insertPokedex(new Pokedex("Charmander", 9.7, "Es peak"));


        //Esto es para DATE (de la variable Adestrador)
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                AdestradorService.insertAdestrador(new Adestrador("Figueroa", sdf.parse("10/02/2002")));
                AdestradorService.insertAdestrador(new Adestrador("Andrea", sdf.parse("31/05/2004")));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //La funcion exige que al llamaar a la funcion sea un List
        List<Pokedex> listado = PokedexService.leerPokedex();
        listado.forEach(System.out::println); //esto se pone una vez para mostrarlo



        Pokedex P1 = listado.get(2); //esto es para coger algo de la lista
        Pokedex P2 = listado.get(9);


        //Esto es para actualizar un Pokemon(en este caso el nombre)
        PokedexService.actualizarPokedexNome(P1, "Silveon");
        PokedexService.actualizarPokedexNome(P2, "Charmileon");


        listado = PokedexService.leerPokedex(); //esto es para llamar a listado despues de actualizar la lista
        listado.forEach(System.out::println); //esto para mostrarlo de nuevo despues de actualizarlo


        PokedexService.eliminarPokedexTodos();


        //-----------------------------------------------

        //La funcion exige que al llamaar a la funcion sea un List
        List<Adestrador> listado2 = AdestradorService.leerAdestrador();
        listado.forEach(System.out::println); //esto se pone una vez para mostrarlo


        Adestrador A1 = listado2.get(0); //esto es para coger algo de la lista
        Adestrador A2 = listado2.get(1);

        //Esto es para actualizar un Adestrador(en este caso el nombre)
        AdestradorService.actualizarAdestradorNome(A1, "DIO");
        AdestradorService.actualizarAdestradorNome(A2, "Jotaro");

        listado2 = AdestradorService.leerAdestrador();
        listado2.forEach(System.out::println);  //esto para mostrarlo de nuevo despues de actualizarlo


        AdestradorService.eliminarAdestradorTodos();



        //-----------------------------------------------

        //esto es para el XML NO HACE FALTA
        try {
            PokedexXML.escribirPokedex(listado);
            AdestradoresXML.escribirAdestradores(listado2);

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }


    }
}
