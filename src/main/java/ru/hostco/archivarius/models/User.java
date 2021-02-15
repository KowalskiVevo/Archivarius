package ru.hostco.archivarius.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

//import lombok.Data;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "Firstname",
    "Lastname",
    "Middlename",
    "BirthDate",
    "Phone",
    "PolicyNumber",
    "SNILS",
    "mcode"
})

@Entity
@Table(name = "users", schema = "archivist")
public class User {

    //@Column(name = "FirstName")
    private String Firstname;
    private String Lastname;    
    private String Middlename;
    //private String MedOrg;
    private int Phone;
    private String PolicyNumber;
    @Id
    private String SNILS;
    private int mcode;
    private Date BirthDate;

    public String getFirstname() {
        return this.Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getMiddlename() {
        return this.Middlename;
    }

    public void setMiddlename(String Middlename) {
        this.Middlename = Middlename;
    }

    public int getPhone() {
        return this.Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getPolicyNumber() {
        return this.PolicyNumber;
    }

    public void setPolicyNumber(String PolicyNumber) {
        this.PolicyNumber = PolicyNumber;
    }

    public String getSNILS() {
        return this.SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public int getMcode() {
        return this.mcode;
    }

    public void setMcode(int mcode) {
        this.mcode = mcode;
    }

    public Date getBirthDate() {
        return this.BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public User(){
    }

    // public User(
    // int id,
    // String FirstName,
    // String LastName,
    // String MiddleName,
    // String MedOrg,
    // int NumberPhone,
    // String PolisOms,
    // String SNILS,
    // int NumberCard
    // ){
    //     this.id = id;
    //     this.FirstName = FirstName;
    //     this.NumberPhone = NumberPhone;
    //     this.LastName = LastName;
    //     this.MiddleName = MiddleName;
    //     this.NumberCard = NumberCard;
    //     this.SNILS = SNILS;
    //     this.PolisOms = PolisOms;
    //     this.MedOrg = MedOrg;
    // }
}
