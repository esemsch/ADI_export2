package export.creators;

import cablelabs.md.xsd.core._3.AssetRefType;
import cablelabs.md.xsd.core._3.ExtType;
import cablelabs.md.xsd.offer._3.OfferType;
import export.ExportUtils;
import model.Movy;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import xmlmodel.*;

import static export.ExportUtils.*;

import java.math.BigInteger;

@Component
public class OfferCreator {

    public OfferType createOffer(Movy m, String prefix) {
        OfferType offer = new OfferType();

        /*
        <Asset xsi:type="offer:OfferType" uriId="indemand.com/Offer/UNVA2001081701004000" providerVersionNum="1"
           internalVersionNum="0" creationDateTime="2002-01-11T00:00:00Z" startDateTime="2002-02-01T00:00:00Z"
           endDateTime="2002-03-31T11:59:59Z">
        */

        offer.setUriId(ExportUtils.getUriId(prefix, m));
        offer.setProviderVersionNum(BigInteger.ONE);  // TODO: ??
        offer.setInternalVersionNum(BigInteger.ZERO); // TODO: ??
        offer.setCreationDateTime(xmlCal(new DateTime(2013,3,18,13,55))); // TODO: ??
        offer.setStartDateTime(xmlCal(new DateTime(2013,3,18,15,55)));  // TODO: ??
        offer.setEndDateTime(xmlCal(new DateTime(2014,3,18,13,55))); // TODO: ??

        /*
        <core:Ext>
            <GeoAvalabilities>
                <geo>CZ</geo>
                <geo>GB</geo>
            </GeoAvalabilities>
            <DeviceAvailabilities>
                <device>iPad</device>
                <device>iPhone</device>
                <device>Mac</device>
            </DeviceAvailabilities>
            <Attributes>
                <Attribute name="Subscription Tier">CSVOD</Attribute>
                <Attribute name="IsFree">true</Attribute>
            </Attributes>
        </core:Ext>
        */

        ExtType ext = new ExtType();

        GeoAvailabilities geoAvailabilities = new GeoAvailabilities();  // TODO: ??
        geoAvailabilities.getGeos().add("CZ");
        geoAvailabilities.getGeos().add("GB");

        DeviceAvailabilities deviceAvailabilities = new DeviceAvailabilities();  // TODO: ??
        deviceAvailabilities.getDevices().add("iPad");
        deviceAvailabilities.getDevices().add("iPhone");
        deviceAvailabilities.getDevices().add("Mac");

        Attributes attributes = new Attributes();  // TODO: ??
        Attribute attribute = new Attribute();
        attribute.setAttribute("CSVOD");
        attribute.setName("Subscription Tier");

        Attribute attribute2 = new Attribute();
        attribute2.setAttribute("true");
        attribute2.setName("IsFree");

        attributes.getAttributes().add(attribute);
        attributes.getAttributes().add(attribute2);

        ext.getAny().add(geoAvailabilities);
        ext.getAny().add(deviceAvailabilities);
        ext.getAny().add(attributes);

        offer.setExt(ext);

        /*
       <offer:PromotionalContentGroupRef uriId="indemand.com/ContentGroup/UNVA2001081701004001"/>
       <offer:BillingId>56789</offer:BillingId>
       <offer:TermsRef uriId="indemand.com/Terms/UNVA2001081701004001"/>
       <offer:ContentGroupRef uriId="indemand.com/ContentGroup/UNVA2001081701004001"/>
       </Asset>
        */

        AssetRefType value = new AssetRefType();  // TODO: ??
        value.setUriId("???????");
        offer.setPromotionalContentGroupRef(value);

        offer.setBillingId("???????"); // TODO: ??

        AssetRefType value1 = new AssetRefType(); // TODO: ??
        value.setUriId("???????");
        offer.setTermsRef(value1);

        offer.getContentGroupRef().add(null); // TODO: ??

        return offer;
    }

}
