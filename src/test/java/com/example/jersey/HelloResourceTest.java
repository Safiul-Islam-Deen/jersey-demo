package com.example.jersey;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for HelloResource
 */
public class HelloResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(HelloResource.class);
    }

    /**
     * Test to see that the basic hello message is sent.
     */
    @Test
    public void testGetHello() {
        final String responseMsg = target().path("hello").request().get(String.class);
        assertEquals("Hello, Jersey!", responseMsg);
    }

    /**
     * Test to see that the hello message with name is sent.
     */
    @Test
    public void testGetHelloWithName() {
        final String responseMsg = target().path("hello/John").request().get(String.class);
        assertEquals("Hello, John!", responseMsg);
    }

    /**
     * Test to see that the greet endpoint returns JSON.
     */
    @Test
    public void testGreet() {
        final Response response = target().path("hello/greet")
                .queryParam("name", "Jersey")
                .request()
                .get();
        
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaderString("Content-Type"));
    }

    /**
     * Test greet endpoint without query parameter.
     */
    @Test
    public void testGreetWithoutName() {
        final Response response = target().path("hello/greet").request().get();
        assertEquals(200, response.getStatus());
    }
}
