package xmlmodel;

import cablelabs.md.xsd.content._3.BoxCoverType;
import cablelabs.md.xsd.offer._3.OfferType;
import cablelabs.md.xsd.title._3.TitleType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"tt","ot","bct"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceObject {
    @XmlElement(name = "tt")
    TitleType tt;
    @XmlElement(name = "ot")
    OfferType ot;
    @XmlElement(name = "bct")
    BoxCoverType bct;

    public TitleType getTt() {
        return tt;
    }

    public void setTt(TitleType tt) {
        this.tt = tt;
    }

    public OfferType getOt() {
        return ot;
    }

    public void setOt(OfferType ot) {
        this.ot = ot;
    }

    public BoxCoverType getBct() {
        return bct;
    }

    public void setBct(BoxCoverType bct) {
        this.bct = bct;
    }
}
