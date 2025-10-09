package Serializacion_e_XML;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;


public class CrearXMLAutores{
    public static void main(String[] args) {

        String ruta = "autores.xml";

        // Parte 1

        Producto p1 = new Producto("Laranxa", 10, 2.5);

        try (
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("serial.txt"))) {
            os.writeObject(p1);

            System.out.println("\nObxecto gardado correctamente: \n" + p1);

        } catch (
                IOException e) {
            e.printStackTrace();
        }


        Producto p2 = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("serial.txt"));
            p2 = (Producto) is.readObject();
            is.close();

            System.out.println("Obxecto serializado: \n" + p2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Parte 2


        ProductoTransient pt1 = new ProductoTransient("Mazá", 99, 5.75);
        try (
                ObjectOutputStream ostr = new ObjectOutputStream(new FileOutputStream("serialTransient.txt"))) {
            ostr.writeObject(pt1);

            System.out.println("\nObxecto gardado correctamente: \n" + pt1);

        } catch (
                IOException e) {
            e.printStackTrace();
        }


        ProductoTransient pt2 = null;
        try {
            ObjectInputStream istr = new ObjectInputStream(new FileInputStream("serialTransient.txt"));
            pt2 = (ProductoTransient) istr.readObject();
            istr.close();

            System.out.println("Obxecto serializado: \n" + pt2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }


        // Parte 3

        XMLOutputFactory r1 = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter esc =  r1.createXMLStreamWriter(new FileWriter(ruta));
            esc.writeStartDocument("1.0");

            esc.writeStartElement("autores");

            esc.writeStartElement("autor");
            esc.writeAttribute("codigo", "a1");


            esc.writeStartElement("nombre");
            esc.writeCharacters("Alexandre Dumas");
            esc.writeEndElement();

            esc.writeStartElement("titulo");
            esc.writeCharacters("El conde de montecristo");
            esc.writeEndElement();

            esc.writeStartElement("titulo");
            esc.writeCharacters("Los miserables");
            esc.writeEndElement();


            esc.writeEndElement(); // autor

            esc.writeStartElement("autor");
            esc.writeAttribute("codigo", "a2");

            esc.writeStartElement("nombre");
            esc.writeCharacters("Fiodor Dostoyevski");
            esc.writeEndElement();

            esc.writeStartElement("titulo");
            esc.writeCharacters("El idiota");
            esc.writeEndElement();
            esc.writeStartElement("titulo");
            esc.writeCharacters("Noches blancas");
            esc.writeEndElement();


            esc.writeEndElement(); // autor
            esc.writeEndElement(); // autores


            esc.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nXML creado en: " + ruta + "\n");

    }


}