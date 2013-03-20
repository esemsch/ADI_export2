package xmlmodel;

import cablelabs.md.xsd.content._3.BoxCoverType;
import cablelabs.md.xsd.offer._3.OfferType;
import cablelabs.md.xsd.title._3.TitleType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "ADI3")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"offer","title","image"})
public class ADIAssetInformation {
    @XmlElement(name = "Asset")
    private Object offer;
    @XmlElement(name = "Asset")
    private Object title;
    @XmlElement(name = "Asset")
    private List image;

    public ADIAssetInformation() {
    }

    public ADIAssetInformation(OfferType offer, TitleType title, List image) {
        this.offer = offer;
        this.title = title;
        this.image = (List) Collections.unmodifiableList(image);
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getOffer() {
        return offer;
    }

    public void setOffer(Object offer) {
        this.offer = offer;
    }

    public Object getImage() {
        if(image==null) {
            image = new ArrayList();
        }
        return image;
    }
}
