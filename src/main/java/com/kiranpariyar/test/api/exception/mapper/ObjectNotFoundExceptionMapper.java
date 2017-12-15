package com.kiranpariyar.test.api.exception.mapper;

import com.kiranpariyar.test.api.exception.ObjectNotFoundException;
import com.kiranpariyar.test.api.pojo.ErrorMessageWrapper;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ObjectNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {

    @Override
    public Response toResponse(ObjectNotFoundException exception) {
        ErrorMessageWrapper errorMessageWrapper = new ErrorMessageWrapper();
        errorMessageWrapper.setStatus(Response.Status.NOT_FOUND.getStatusCode());
        errorMessageWrapper.setMessage(exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessageWrapper).type(MediaType.APPLICATION_JSON).build();
    }
}
