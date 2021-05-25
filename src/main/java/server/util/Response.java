package server.util;

public class Response<T> {

    private T t;
    private int status;

    public Response() {
        this.t = null;
        this.status = 0;
    }

    public Response(int status) {
        this.t = null;
        this.status = status;
    }

    public Response(T t, int status) {
        this.t = t;
        this.status = status;
    }

    public T getBody() {
        return t;
    }

    public void setBody(T t) { this.t = t; }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("%d\n%s", status, t);
    }

}
