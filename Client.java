import java.io.*;
import java.util.*;
import java.text.*;

public class Client implements Serializable {

    private Integer id, statusVal;
    private String name, surname, phone, email, status, note;
    private Date date;
    private Boolean newClient, oferta= false, umowa= false, realizacja = false;
    File file = new File("./data/clients.dat");


    public Client() {
        this.id = 1;
        this.statusVal = 0;
        this.name = "";
        this.date = new Date();
        this.newClient = true;
    }

    public void update() {
        this.newClient = false;
    }


    public Boolean isNew() {
        return this.newClient;
    }

    public Boolean getOferta() {
        return this.oferta;
    }

    public void setOferta(Boolean oferta ) {
        this.oferta = oferta ;
    }
    public Boolean getUmowa() {
        return this.umowa;
    }

    public void setUmowa(Boolean umowa) {
        this.umowa = umowa;
    }

    public Boolean getRealizacja() {
        return this.realizacja;
    }

    public void setRealizacja(Boolean realizacja ) {
        this.realizacja = realizacja ;
    }




    public int getStatusVal() {
        return this.statusVal;
    }

    public void setStatusVal(int statusVal) {
        this.statusVal = statusVal;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Boolean isValid() {
        if (
            this.name.length() == 0 ||
            this.surname.length() == 0 ||
            this.email.length() == 0 ||
            this.phone.length() == 0
        ) {
            return false;
        }
        return true;
    }


    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Integer getId() {
        return this.id;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.name);

        return buffer.toString();
    }

}