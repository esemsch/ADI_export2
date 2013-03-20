package xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class YearOfProductionEnd {
    @XmlValue
    private String yearOfProductionEnd;

    public YearOfProductionEnd() {
    }

    public YearOfProductionEnd(String yearOfProductionEnd) {
        this.yearOfProductionEnd = yearOfProductionEnd;
    }

    public String getYearOfProductionEnd() {
        return yearOfProductionEnd;
    }

    public void setYearOfProductionEnd(String yearOfProductionEnd) {
        this.yearOfProductionEnd = yearOfProductionEnd;
    }
}
