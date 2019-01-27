package exceptions;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-Validation-Error", e.getMessage())
                .entity(e.getMessage()).build();
    }
}
