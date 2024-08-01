package System.model;

public class Login {
    private String username;
    private String password;
    private String role;

    // Constructor
    public Login() {
    }

    public Login(String username, String password, String role) {
        this.username = username;
        this.password = password;
        setRole(role); // Use the setter to ensure role validation
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for role with validation
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        // Ensure role is one of the valid values
        if ("Associate".equalsIgnoreCase(role) || "Employee".equalsIgnoreCase(role) || "Admin".equalsIgnoreCase(role)) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}