package utils;

import model.Pokedex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PokedexXML {

    private static XMLStreamWriter iniciador() {
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            return escritor.createXMLStreamWriter(new FileOutputStream("pokedex.xml"));
        } catch (XMLStreamException e) {
            System.out.println("Error de XML Stream Exception: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado");
        }
        return null;
    }

    private static XMLStreamWriter w = iniciador();

    public static void escribirCabecera() throws XMLStreamException {
        assert w != null;
        w.writeStartDocument("1.0");
        w.writeStartElement("pokedex");
    }

    public static void escribirPokedex(List<Pokedex> lista) throws XMLStreamException {
        assert w != null;
        for (Pokedex p : lista) {
            w.writeStartElement("pokemon");

            w.writeAttribute("id", String.valueOf(p.getId()));

            w.writeStartElement("nome");
            w.writeCharacters(p.getNome());
            w.writeEndElement();

            w.writeStartElement("peso");
            w.writeCharacters(String.valueOf(p.getPeso()));
            w.writeEndElement();

            w.writeStartElement("misc");
            w.writeCharacters(p.getMisc() != null ? p.getMisc() : "");
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
