package server.service;

import java.util.Collection;

public interface Service<K, V> {

    void create(V v);
    V read(K k);
    void update(K k);
    void delete(K k);
    Collection<V> getCollection();

}
