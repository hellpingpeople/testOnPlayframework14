package models;

/**
 * Created by Александр Вашурин on 1/17/17.
 */

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class Auto extends Model {

    @CollectionTable
    public String modelname ; //"Марка, модель"

    @MaxSize(100)
    public String color; //"Цвет"

    @Required
    @MaxSize(40)
    public Date registerdate; //"Дата регистрации"

    @Required
    @MaxSize(15)
    @MinSize(2)
    public String body; //"Кузов (кабина, прицеп) №"

    @Required
    @MaxSize(6)
    @MinSize(5)
    public String registernumber; //"Номер регистрации"

    @Required
    @MaxSize(40)
    @MinSize(2)
    public String passengercapacity; //"Пассажировместимость"

    @Column(precision=6, scale=2)
    public BigDecimal power; //"Мощность"

    @Required
    @MaxSize(40)
    @MinSize(1)
    public Integer cel; //"Количество в гараже"




    public String toString() {
        return "Автомобиль(" + modelname + "," + color + "," + registerdate + "," + body + "," +
                registernumber +"," + passengercapacity + "," + power  + cel+")";
    }

}
