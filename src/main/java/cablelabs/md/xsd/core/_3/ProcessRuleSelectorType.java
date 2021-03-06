//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.15 at 04:29:34 PM CET 
//


package cablelabs.md.xsd.core._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;ProcessRuleSelector defines one set of parameters for the rules engine that generate one data
 * 		    process associated with an element. The attributes are optional, primarily to permit them to be supplanted 
 * 		    by new attributes, but a minimal operational set will be defined by profile.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Arg is an argument to be supplied to the rule along with the process rule. Args have an actual name in
 * 		    the 'name' attribute and a value in the mixed content body. If the actual name can be matched to a formal name in the
 * 		    rule definition, the value of the arg MUST be substituted for that formal name in the rule invocation.
 * 		    The affiliate destination URL might be a typical argument.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;RuleId is the repository-specific ID for the rule to be invoked.  It is appended to the ruleRepository URL to form a
 * 			composite URL that is the complete and unique rule identifier. An HTTP GET at that composite URL MUST return a rule
 * 			manifest providing complete definition and usage data for the rule.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;RuleRepository is the URL of the repository that contains the rule to be invoked. Also, an HTTP GET at the
 * 		    repository URL MUST return a list of all the rules available at that repository.&lt;/p&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="urn:cablelabs:md:xsd:core:3.0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Ext is supplied to allow attributes to be added in the same form as those currently defined.&lt;/p&gt;
 * </pre>
 * 
 * 			
 * 
 * <p>Java class for ProcessRuleSelectorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessRuleSelectorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Arg" type="{urn:cablelabs:md:xsd:core:3.0}ArgRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Ext" type="{urn:cablelabs:md:xsd:core:3.0}ExtType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ruleId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ruleRepository" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessRuleSelectorType", propOrder = {
    "arg",
    "ext"
})
public class ProcessRuleSelectorType {

    @XmlElement(name = "Arg")
    protected List<ArgRefType> arg;
    @XmlElement(name = "Ext")
    protected List<ExtType> ext;
    @XmlAttribute(name = "ruleId", required = true)
    protected String ruleId;
    @XmlAttribute(name = "ruleRepository", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String ruleRepository;

    /**
     * Gets the value of the arg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArgRefType }
     * 
     * 
     */
    public List<ArgRefType> getArg() {
        if (arg == null) {
            arg = new ArrayList<ArgRefType>();
        }
        return this.arg;
    }

    /**
     * Gets the value of the ext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtType }
     * 
     * 
     */
    public List<ExtType> getExt() {
        if (ext == null) {
            ext = new ArrayList<ExtType>();
        }
        return this.ext;
    }

    /**
     * Gets the value of the ruleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * Sets the value of the ruleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleId(String value) {
        this.ruleId = value;
    }

    /**
     * Gets the value of the ruleRepository property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleRepository() {
        return ruleRepository;
    }

    /**
     * Sets the value of the ruleRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleRepository(String value) {
        this.ruleRepository = value;
    }

}
