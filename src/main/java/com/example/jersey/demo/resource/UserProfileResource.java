package com.example.jersey.demo.resource;

import com.example.jersey.demo.model.UserProfile;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * REST resource for managing user profile settings
 */
@Path("/users")
public class UserProfileResource {

    // In-memory storage for demo purposes
    private static Map<String, UserProfile> userProfiles = new HashMap<>();

    static {
        // Initialize with some sample data
        userProfiles.put("1", new UserProfile("1", "johndoe", "john@example.com", 
            "John Doe", true, "light"));
        userProfiles.put("2", new UserProfile("2", "janedoe", "jane@example.com", 
            "Jane Doe", false, "dark"));
    }

    /**
     * Get user profile by ID
     */
    @GET
    @Path("/{userId}/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserProfile(@PathParam("userId") String userId) {
        UserProfile profile = userProfiles.get(userId);
        if (profile != null) {
            return Response.ok(profile).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"error\": \"User not found\"}")
                .build();
    }

    /**
     * Get all user profiles
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProfiles() {
        return Response.ok(userProfiles.values()).build();
    }

    /**
     * Create or update user profile settings
     */
    @POST
    @Path("/{userId}/profile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserProfile(@PathParam("userId") String userId, UserProfile profile) {
        profile.setUserId(userId);
        userProfiles.put(userId, profile);
        return Response.ok(profile).build();
    }

    /**
     * Update specific settings
     * Note: Boolean fields (notificationsEnabled) will be updated to the provided value.
     * To preserve existing boolean values, use GET to retrieve current state first.
     */
    @PUT
    @Path("/{userId}/profile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserSettings(@PathParam("userId") String userId, UserProfile updates) {
        UserProfile existing = userProfiles.get(userId);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"User not found\"}")
                    .build();
        }

        // Update only non-null fields (String fields)
        if (updates.getUsername() != null) {
            existing.setUsername(updates.getUsername());
        }
        if (updates.getEmail() != null) {
            existing.setEmail(updates.getEmail());
        }
        if (updates.getDisplayName() != null) {
            existing.setDisplayName(updates.getDisplayName());
        }
        if (updates.getTheme() != null) {
            existing.setTheme(updates.getTheme());
        }
        // Boolean fields are always updated as they cannot be null (primitive type)
        existing.setNotificationsEnabled(updates.isNotificationsEnabled());

        return Response.ok(existing).build();
    }

    /**
     * Delete user profile
     */
    @DELETE
    @Path("/{userId}/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserProfile(@PathParam("userId") String userId) {
        UserProfile removed = userProfiles.remove(userId);
        if (removed != null) {
            return Response.ok("{\"message\": \"User profile deleted\"}").build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"error\": \"User not found\"}")
                .build();
    }

    /**
     * Simple health check endpoint
     */
    @GET
    @Path("/health")
    @Produces(MediaType.TEXT_PLAIN)
    public Response health() {
        return Response.ok("OK").build();
    }
}
