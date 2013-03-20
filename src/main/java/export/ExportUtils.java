package export;

import model.Movy;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.util.GregorianCalendar;

/**
 * Utils for the project.
 */
@Component
public class ExportUtils {

    @Autowired
    Marshaller marshaller;

    @Value("${destination.folder}")
    String destinationFolder;

    public void marshal(Object o, String prefix, String name) throws JAXBException {
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(o, new File(destinationFolder+File.separator+prefix+"_"+name+".xml"));
    }

    public static XMLGregorianCalendar xmlCal(DateTime d) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(d.toDate());
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public static String getUriId(String prefix, Movy m) {
        return prefix+"_"+m.getTmsId();
    }

}
