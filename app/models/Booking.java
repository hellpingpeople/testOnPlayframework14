package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
import java.util.*;
import java.text.*;
import java.math.*;

@Entity
public class Booking extends Model {
    
    @Required
    @ManyToOne
    public User user;
    
    @Required
    @ManyToOne
    public Persona persona;


    public Booking(Persona persona, User user) {
        this.persona = persona;
        this.user = user;
    }


    public String toString() {
        return "Связь(" + user + ","+ persona + ")";
    }

}
