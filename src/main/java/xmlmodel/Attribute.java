package xmlmodel;

import javax.xml.bind.annotation.*;

@XmlType(name = "attribute")
@XmlAccessorType(XmlAccessType.FIELD)
public class Attribute {
    @XmlValue
    private String attribute;

    @XmlAttribute(name = "name")
    private String name;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}