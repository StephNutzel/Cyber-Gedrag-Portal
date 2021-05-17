package server.service;

import java.util.Collection;

public interface Service<K, V> {

    void create(V v);
    void update(K k);
    void delete(K k);
    Collection<V> getCollection();

}
