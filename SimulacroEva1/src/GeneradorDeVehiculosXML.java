import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class GeneradorDeVehiculosXML {
    private static XMLStreamWriter w = iniciador();
    private static XMLStreamWriter iniciador() {
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = escritor.createXMLStreamWriter(new FileOutputStream("vehiculos.xml"));
            return writer;
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escribirListaVehiculosXML(ArrayList<Vehiculo> listaVehiculos) {
        try {
            w.writeStartDocument("1.0");
            w.writeStartElement("Vehiculos");
            for(Vehiculo v : listaVehiculos) {
                escribirVehiculoXML(v);
            }
            w.writeEndElement();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirVehiculoXML (Vehiculo vehiculo) {
        try {
            w.writeStartElement("vehiculo");
            w.writeStartElement("modelo");
            w.writeCharacters(vehiculo.getModelo());
            w.writeEndElement();
            w.writeStartElement("marca");
            w.writeCharacters(vehiculo.getMarca());
            w.writeEndElement();
            w.writeStartElement("ano");
            w.writeCharacters(String.valueOf(vehiculo.getAno()));
            w.writeEndElement();
            w.writeStartElement("descripcion");
            w.writeCharacters(vehiculo.getDescripcion());
            w.writeEndElement();
            w.writeEndElement();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }


}
