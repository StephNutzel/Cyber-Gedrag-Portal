package server.util;

public class JsonResponse<E, K> {

    private E body;
    private K response;

    public JsonResponse(E body, K response) {
        this.body = body;
        this.response = response;
    }

    public E getBody() {
        return body;
    }

    public void setBody(E body) {
        this.body = body;
    }

    public K getResponse() {
        return response;
    }

    public void setResponse(K response) {
        this.response = response;
    }
}
