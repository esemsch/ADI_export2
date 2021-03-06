//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.15 at 04:29:34 PM CET 
//


package cablelabs.md.xsd.core._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Defines one particular trick mode exclusion composed of a type and, for type="trick", a speed scaling factor
 * 		    or range of factors. The scale factor is the ratio of the play speed to normal play speed; forward speeds are
 * 		    positive, and backward speeds are negative.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Normal is forward at an implied scale of 1.0, and that combination is always explicit (i.e., normal play is
 * 		    never an implied part of a trick range).&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Trick is a multiple of normal play speed, signed for forward or reverse. Trick 0.0 describes no play (i.e., pause).&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Jump is a navigational notation used for transitions such as "digital rewind" or "go to chapter". It does not have a speed.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;All is all trick modes, but excludes normal play.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;If present, lowertest and uppertest are applied when evaluating the scale value. The default tests are "ge" for lowertest and "le" for uppertest.&lt;/p&gt;
 * </pre>
 * 
 * 			
 * 
 * <p>Java class for TrickModeExclusionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrickModeExclusionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="type" use="required" type="{urn:cablelabs:md:xsd:core:3.0}TrickModeType" />
 *       &lt;attribute name="scale" type="{urn:cablelabs:md:xsd:core:3.0}SpeedScaleType" />
 *       &lt;attribute name="lowertest" type="{urn:cablelabs:md:xsd:core:3.0}LowerTestType" />
 *       &lt;attribute name="uppertest" type="{urn:cablelabs:md:xsd:core:3.0}UpperTestType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrickModeExclusionType")
public class TrickModeExclusionType {

    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "scale")
    protected String scale;
    @XmlAttribute(name = "lowertest")
    protected String lowertest;
    @XmlAttribute(name = "uppertest")
    protected String uppertest;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScale(String value) {
        this.scale = value;
    }

    /**
     * Gets the value of the lowertest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowertest() {
        return lowertest;
    }

    /**
     * Sets the value of the lowertest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowertest(String value) {
        this.lowertest = value;
    }

    /**
     * Gets the value of the uppertest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUppertest() {
        return uppertest;
    }

    /**
     * Sets the value of the uppertest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUppertest(String value) {
        this.uppertest = value;
    }

}
