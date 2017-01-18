package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
import java.math.*;
import java.util.Date;

@Entity
public class Persona extends Model {
    
    @Required
    @MaxSize(50)
    public String firstname;

    @ManyToOne
    @MaxSize(10)
    public Auto auto;

    @Required
    @MaxSize(100)
    public String lastname;
    
    @Required
    @MaxSize(40)
    public String patronymic;
    
    @Required
    @MaxSize(40)
    @MinSize(2)
    public String city;
    
    @Required
    @MaxSize(6) 
    @MinSize(1)
    public String sex;

    @Required
    @MaxSize(15)
    @MinSize(5)
    public Date burnyear;
    
    @Required
    @MaxSize(40) 
    @MinSize(2)
    public String country;

    @Column(precision=6, scale=2)
    public BigDecimal price;


    public String toString() {
        return "Персона(" + firstname + ","+ lastname + ","+ patronymic+ ","+ city +","+ sex
                +","+ burnyear + "," + country + auto + ")";
    }
    
}
