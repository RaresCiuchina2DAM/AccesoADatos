package ApuntesXML;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class xml_clase3 {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader pXML = XMLReaderFactory.createXMLReader();
        MiDefaultHandler mDF = new MiDefaultHandler();
        pXML.setContentHandler(mDF);

        //Para decirle qué fichero vamos a tratar
        InputSource fichXML = new InputSource("FichEmpleados.xml");

        pXML.parse(fichXML);
        System.out.println("hola");
    }
}

class MiDefaultHandler extends DefaultHandler {
    MiDefaultHandler() {
        super();
    }

    public void startDocument() {
        //Aquí va a hacer cosas antes de empezar el documento
        //(Por ejemplo abrir fichero)
        System.out.println("Comienzo SAX");
    }

    public void endDocument() {
        //Aquí va a hacer cosas al finalizar el documento
        //(Por ejemplo cerrar el fichero)
        System.out.println("Final SAX");
    }

    //El start y end element es respecto a los elementos, a cualquier etiqueta
    //por ejemplo, empleado, id, etc
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("Comienzo elemento %s\n", nombre);

        //Para tener acceso a los atributos
        //getLength número de atributos
        for (int i=0; i<atts.getLength();i++) {
            //getLocalName el nombre de atributo y getValue te da el valor.
            System.out.println(atts.getLocalName(i)+" : "+atts.getValue(i));
        }
    }

    public void endElement(String uri, String nombre, String nombreC, Attributes atts) {
    }

    public void characters(char[] ch, int inicio, int longitud) {
        String st = new String(ch, inicio, longitud);
        System.out.println(st);
    }
}
