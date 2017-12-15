package com.kiranpariyar.test.api.exception.mapper;

import com.kiranpariyar.test.api.exception.DataAccessException;
import com.kiranpariyar.test.api.pojo.ErrorMessageWrapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataAccessExceptionMapper implements ExceptionMapper<DataAccessException> {

    @Override
    public Response toResponse(DataAccessException exception) {
        ErrorMessageWrapper errorMessageWrapper = new ErrorMessageWrapper();
        errorMessageWrapper.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
        errorMessageWrapper.setMessage(exception.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessageWrapper).type(MediaType.APPLICATION_JSON).build();
    }

}
