package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CanCreateExceptionMapper implements ExceptionMapper<CarCreationException> {
    @Override
    public Response toResponse(CarCreationException e) {
        return Response.serverError().header("X-Car-Error", e.getMessage())
                .entity(e.getMessage()).build();
    }
}
