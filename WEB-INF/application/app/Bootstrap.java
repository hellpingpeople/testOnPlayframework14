import play.test.*;
import play.jobs.*;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() throws SQLException {
        // Load default data if the database is empty
        if(Persona.count() == 0) {
            Fixtures.load("data.yml");
        }
    }
    
}