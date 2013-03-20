package xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "DeviceAvailabilities")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceAvailabilities {

    @XmlElement(name = "device")
    List<String> devices = new ArrayList<String>();

    public List<String> getDevices() {
        return devices;
    }
}
