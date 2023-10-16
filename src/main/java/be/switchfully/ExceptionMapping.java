package be.switchfully;

import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import static org.jboss.resteasy.reactive.RestResponse.StatusCode.BAD_REQUEST;

public class ExceptionMapping {

    @ServerExceptionMapper
    public Response exceptionMapper(GreetingException exception){
        return Response.status(BAD_REQUEST).entity(exception.getMessage()).build();

    }
}
