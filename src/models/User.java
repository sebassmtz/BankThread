package models;

public class User {

    private String name;
    private String id;
    private RequestType requestType;

    public User(String name, String id, RequestType requestType) {
        this.name = name;
        this.id = id;
        this.requestType = requestType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }
}
