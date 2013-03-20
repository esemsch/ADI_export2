package xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class YearOfProductionStart {
    @XmlValue
    private String yearOfProductionStart;

    public YearOfProductionStart() {
    }

    public YearOfProductionStart(String yearOfProductionStart) {
        this.yearOfProductionStart = yearOfProductionStart;
    }

    public String getYearOfProductionStart() {
        return yearOfProductionStart;
    }

    public void setYearOfProductionStart(String yearOfProductionStart) {
        this.yearOfProductionStart = yearOfProductionStart;
    }
}
