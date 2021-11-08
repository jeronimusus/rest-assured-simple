package models.requestModels;

public class AuthRequestBody {
    public String password;
    public String username;

    /**
     * No args constructor for use in serialization
     *
     */
    public AuthRequestBody() {
    }

    /**
     *
     * @param password
     * @param username
     */
    public AuthRequestBody(String password, String username) {
        super();
        this.password = password;
        this.username = username;
    }
}
