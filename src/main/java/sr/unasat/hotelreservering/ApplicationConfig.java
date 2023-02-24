package sr.unasat.hotelreservering;

//import jakarta.ws.rs.ApplicationPath;
//import jakarta.ws.rs.core.Application;

import sr.unasat.hotelreservering.config.JPAConfiguration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    @Override
    public Map<String, Object> getProperties() {
        //Map<String, Object> properties = new HashMap<String, Object>();
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "sr.unasat.hotelreservering.controller");
        JPAConfiguration.getEntityManager();
        return properties;
    }

}