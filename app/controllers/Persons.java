package controllers;

import play.mvc.*;

import java.util.*;

import models.*;

public class Persons extends Application {
    
    @Before
    static void checkUser() {
        if(connected() == null) {
            flash.error("Пожалуйста залогиньтесь");
            Application.index();
        }
    }

    public static void index() {
        List<Booking> bookings = Booking.find("byUser", connected()).fetch();
        render(bookings);
    }

    


    public static void list(String search, Integer size, Integer page) {
        List<Persona> personas = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
           flash.error("Введите строку для поиска");
        } else {
            search = search.toLowerCase();
            personas = Persona.find("lower(firstname) like ?1 OR lower(lastname) like ?2", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        render(personas, search, size, page);
    }

    
    public static void show(Long id) {
        Persona persona = Persona.findById(id);
        render(persona);
    }

    public static void book(Long id) {
        Persona persona = Persona.findById(id);
        Auto auto = Auto.findById(id);
        render(persona);
        render(auto);
    }



    public static void settings() {
        render();
    }
    
    public static void saveSettings(String password, String verifyPassword) {
        User connected = connected();
        connected.password = password;
        validation.valid(connected);
        validation.required(verifyPassword);
        validation.equals(verifyPassword, password).message("Пароли не совпадают, так-то");
        if(validation.hasErrors()) {
            render("@settings", connected, verifyPassword);
        }
        connected.save();
        flash.success("Пароль обновлен");
        index();
    }
    
}

