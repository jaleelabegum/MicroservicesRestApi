package com.example.MicroserviceSecondService.utilities;

public class JsonResponseBody {

    private int server;
    private Object response;

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public JsonResponseBody(int server, Object response) {
        this.server = server;
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
