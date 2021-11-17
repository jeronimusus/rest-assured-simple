package functionality.interfaces;

import io.restassured.response.Response;

// Generic Interface for all possible endpoint responses
public interface IRestResponse<T> {
    public T getBodyAsPojo();
    public String getBodyAsString();
    public int getStatusCode();
    public boolean isSuccessful();
    public String getStatusDescription();
    public Response getResponse();
    public Exception getException();
}
