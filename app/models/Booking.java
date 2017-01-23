package models;

import play.data.validation.MaxSize;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Вашурин Александр on 21.01.2017.
 */
@Entity
public class Booking extends Model {
    @ManyToOne
    @MaxSize(10)
    public Auto auto;

    @ManyToOne
    @MaxSize(10)
    public Persona persona;

    @ManyToOne
    @MaxSize(10)
    public User user;

    public Booking(Auto auto, Persona persona, User user) {
        this.auto = auto;
        this.persona = persona;
        this.user = user;
    }

}
