package be.switchfully;


import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class GreetingService {

    public String greeting(String string, String test) {
        return "Ola " + string + " from "+ test +"RESTEasy Reactive";
    }

    public String greetingError() {
        Log.info("Greeting was not found???");
        throw new GreetingException("Greeting not found");

    }
}
