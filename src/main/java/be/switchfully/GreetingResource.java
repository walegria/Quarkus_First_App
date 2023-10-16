package be.switchfully;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.*;

@Path("/hello")
public class GreetingResource {

    GreetingService greetingService;

    @Inject
    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GET
    @Path("/member")
    @ResponseStatus(OK)
    public String error() {
        try {
            return greetingService.greetingError();
        } catch (GreetingException exception) {
            throw new WebApplicationException(NOT_FOUND);
        }
    }

    @ServerExceptionMapper(GreetingException.class)
    public Response greetingResponse(GreetingException exception){
        return Response.status(BAD_REQUEST).entity(exception.getMessage()).build();
    }

    @GET
    @Path("/{Id}/{test}")
    @Produces(MediaType.TEXT_PLAIN)
    @ResponseStatus(OK)
    public String hello(@QueryParam("ID") String string, @RestPath("test") String test) {
        return greetingService.greeting(string, test);
    }


}
