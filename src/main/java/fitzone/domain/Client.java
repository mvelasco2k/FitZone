/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitzone.domain;

import java.util.Objects;

/**
 *
 * @author Mateo Velasco
 */
public class Client {
    private int id;
    private String Name;
    private String Surname;
    private String Membresy;
    
    public Client(){
    }
    
    public Client(int id){
        this.id = id;
    }
    
    public Client(String name, String surname, String membresy){
        this.Name = name;
        this.Surname = surname;
        this.Membresy = membresy;
    }
    
    public Client(int id, String name, String surname, String membresy){
        this(name, surname, membresy);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getMembresy() {
        return Membresy;
    }

    public void setMembresy(String Membresy) {
        this.Membresy = Membresy;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", Name=" + Name + ", Surname=" + Surname + ", Membresy=" + Membresy + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.Name);
        hash = 31 * hash + Objects.hashCode(this.Surname);
        hash = 31 * hash + Objects.hashCode(this.Membresy);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Surname, other.Surname)) {
            return false;
        }
        return Objects.equals(this.Membresy, other.Membresy);
    }
    
    
}
