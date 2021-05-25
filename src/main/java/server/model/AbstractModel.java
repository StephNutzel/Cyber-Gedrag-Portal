package server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractModel {

    public Integer id;

    public AbstractModel(Integer id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
