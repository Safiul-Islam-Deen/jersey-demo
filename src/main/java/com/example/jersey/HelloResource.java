package com.example.jersey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "hello" path)
 */
@Path("hello")
public class HelloResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "Hello, Jersey!";
    }

    /**
     * Method handling HTTP GET requests with path parameter.
     *
     * @param name the name to greet
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloWithName(@PathParam("name") String name) {
        return "Hello, " + name + "!";
    }

    /**
     * Method handling HTTP GET requests with query parameter.
     *
     * @param name the name to greet (optional)
     * @return Response with JSON content
     */
    @GET
    @Path("/greet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greet(@QueryParam("name") String name) {
        String greeting = name != null ? "Hello, " + name + "!" : "Hello, World!";
        return Response.ok()
                .entity(new GreetingMessage(greeting))
                .build();
    }

    /**
     * Simple greeting message class for JSON responses
     */
    public static class GreetingMessage {
        private String message;

        public GreetingMessage() {
        }

        public GreetingMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
