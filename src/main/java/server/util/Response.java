package server.util;

public class Response<T> {

    private T t;
    private int status;

    public Response(T t, int status) {
        this.t = t;
        this.status = status;
    }

    public T getResponse() {
        return t;
    }

    public int getStatus() {
        return status;
    }

}
