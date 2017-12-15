package com.kiranpariyar.test.api.rs;

import com.kiranpariyar.test.api.annotation.Logged;
import com.kiranpariyar.test.api.entity.User;
import com.kiranpariyar.test.api.util.GuidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */

@Logged
@Path("tests")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/tests", description = "Say Hello!")
public class TestRs {

    @GET
    @Path("/")
    @ApiOperation(value = "Say Hello World",
            notes = "Anything Else?")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
    public Response list() {
        User user1 =new User();
        user1.setId(GuidUtil.generate());
        user1.setName("name1");
        user1.setAddress("address2");

        User user2 = new User();
        user2.setId(GuidUtil.generate());
        user2.setName("name2");
        user2.setAddress("address2");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        return Response.status(Response.Status.OK).entity(userList).build();
    }
}
