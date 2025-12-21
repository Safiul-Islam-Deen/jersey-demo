package com.example.jersey.demo.model;

/**
 * Model class representing user profile settings
 */
public class UserProfile {
    private String userId;
    private String username;
    private String email;
    private String displayName;
    private boolean notificationsEnabled;
    private String theme;

    // Constructors
    public UserProfile() {
    }

    public UserProfile(String userId, String username, String email, String displayName, 
                      boolean notificationsEnabled, String theme) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.notificationsEnabled = notificationsEnabled;
        this.theme = theme;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", notificationsEnabled=" + notificationsEnabled +
                ", theme='" + theme + '\'' +
                '}';
    }
}
