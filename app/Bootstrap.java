import models.Persona;
import play.db.DB;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

import java.sql.Connection;
import java.sql.SQLException;

@OnApplicationStart
public class Bootstrap extends Job {


    public void doJob() throws SQLException {
        // Запускается проверка заполнены ли необходимые таблицы,
        //ежели нет - они заполняются
        if(Persona.count() == 0) {

            Fixtures.load("data.yml");
            Connection conn = DB.getConnection();
            conn.createStatement().execute("update persona set auto_id=13 where id=5;\n" +
                    "update persona set auto_id=14 where id=6;\n" +
                    "update persona set auto_id=15 where id=3;\n" +
                    "update persona set auto_id=16 where id=10;\n" +
                    "update persona set auto_id=17 where id=11;\n" +
                    "update persona set auto_id=18 where id=12;\n" +
                    "update persona set auto_id=19 where id=7;\n" +
                    "update persona set auto_id=19 where id=4;\n" +
                    "update persona set auto_id=19 where id=8;\n" +
                    "update persona set auto_id=19 where id=9;\n" +
                    "update persona set auto_id=19 where id=13;");

        }
    }
    
}
