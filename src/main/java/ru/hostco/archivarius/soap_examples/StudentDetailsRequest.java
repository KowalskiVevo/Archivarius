//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:20:38 PM IST 
//


package ru.hostco.archivarius.soap_examples;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "Lastname",
    "SNILS"
})
@XmlRootElement(name = "StudentDetailsRequest")
public class StudentDetailsRequest {

    @XmlElement(required = true)
    protected String SNILS;
    protected String Lastname;

    public String getName() {
        return SNILS;
    }

    public void setName(String value) {
        this.SNILS = value;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String value) {
        this.Lastname = value;
    }

}