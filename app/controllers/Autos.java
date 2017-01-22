package controllers;

import models.Auto;
import models.Booking;
import models.Persona;

import java.util.List;

/**
 * Created by Вашурин Александр on 21.01.2017.
 */
public class Autos extends Persons{


    public static void index() {
            List<Booking> bookings = Booking.find("byUser", connected()).fetch();
            render(bookings);
        }

    public static void list(String search, Integer size, Integer page) {
        List<Auto> autos = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
            flash.error("Введите строку для поиска");
        } else {
            search = search.toLowerCase();
            autos = Auto.find("lower(modelname) like ?1 OR lower(color) like ?2", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        render(autos, search, size, page);
    }

    public static void show(Long id) {
        Auto auto = Auto.findById(id);
        render(auto);
    }

    public static void book(Long id) {
       Auto auto = Auto.findById(id);
        render(auto);
    }
}
