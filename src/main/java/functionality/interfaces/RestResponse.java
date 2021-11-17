package functionality.interfaces;

import functionality.interfaces.IRestResponse;
import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {
    private T data;
    private Response response;
    private Exception e;

    public RestResponse(Class<T> t, Response response) {
        this.response = response;
        try {
            this.data = t.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("There should be a default constructor in the Response POJO");
        }
    }
    public T getBodyAsPojo() {
        try {
            data = (T) response.getBody().as(data.getClass());
        } catch (Exception e) {
            this.e = e;
        }
        return data;
    }
    public String getBodyAsString() {
        return response.getBody().asString();
    }
    public int getStatusCode() {
        return response.getStatusCode();
    }
    public boolean isSuccessful() {
        int code = response.statusCode();
        if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
        return false;
    }
    public String getStatusDescription() {
        return response.getStatusLine();
    }
    public Response getResponse() {
        return response;
    }
    public Exception getException() {
        return e;
    }
}
