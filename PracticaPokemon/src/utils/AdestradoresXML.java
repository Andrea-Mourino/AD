package utils;

import model.Adestrador;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class AdestradoresXML {

    private static XMLStreamWriter iniciador() {
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            return escritor.createXMLStreamWriter(new FileOutputStream("adestradores.xml"));
        } catch (XMLStreamException e) {
            System.out.println("Error de XML Stream Exception: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado");
        }
        return null;
    }

    private static XMLStreamWriter w = iniciador();
    private static final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public static void escribirCabecera() throws XMLStreamException {
        assert w != null;
        w.writeStartDocument("1.0");
        w.writeStartElement("adestradores");
    }

    public static void escribirAdestradores(List<Adestrador> lista) throws XMLStreamException {
        assert w != null;
        for (Adestrador a : lista) {
            w.writeStartElement("adestrador");

            // Atributo id
            w.writeAttribute("id", String.valueOf(a.getId()));

            // Elemento nome
            w.writeStartElement("nome");
            w.writeCharacters(a.getNome());
            w.writeEndElement();

            // Elemento nacemento
            w.writeStartElement("nacemento");
            String data = (a.getNacemento() != null) ? formatoFecha.format(a.getNacemento()) : "";
            w.writeCharacters(data);
            w.writeEndElement();

            w.writeEndElement();
        }
    }

    public static void cerrarDocumento() throws XMLStreamException {
        assert w != null;
        w.writeEndElement();
        w.writeEndDocument();
        w.flush();
        w.close();
    }


}
