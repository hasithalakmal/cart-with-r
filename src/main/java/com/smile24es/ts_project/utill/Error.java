package com.smile24es.ts_project.utill;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>Java class for Error complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Error">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="additionalInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author rohanakumara
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Error", propOrder = {

})
@XmlRootElement
public class Error implements Serializable {

    /**
     * <p>Constructor for Error.</p>
     */
    public Error() {
    }

    /**
     * <p>Constructor for Error.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @param description a {@link java.lang.String} object.
     */
    public Error(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @XmlElement(required = true)
    private String code;
    @XmlElement(required = true)
    private String description;
    private String additionalInfo;

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     *         {@link java.lang.String}
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link java.lang.String}
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link java.lang.String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link java.lang.String}
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     *
     * @return possible object is
     *         {@link java.lang.String}
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     *
     * @param value allowed object is
     *              {@link java.lang.String}
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Error{")
                .append("code='").append(code).append('\'')
                .append(", description='").append(description).append('\'')
                .append(", additionalInfo='").append(additionalInfo).append('\'')
                .append('}').toString();
    }
}