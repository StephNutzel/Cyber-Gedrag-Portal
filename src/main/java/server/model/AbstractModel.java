package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractModel {

    @JsonProperty("id")
    public int id;

    public AbstractModel(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
