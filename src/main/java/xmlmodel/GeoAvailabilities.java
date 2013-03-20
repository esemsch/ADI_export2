package xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "GeoAvailabilities")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoAvailabilities {

    @XmlElement(name = "geo")
    List<String> geos = new ArrayList<String>();

    public List<String> getGeos() {
        return geos;
    }
}
