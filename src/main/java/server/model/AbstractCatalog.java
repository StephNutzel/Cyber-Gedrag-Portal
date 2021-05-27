package server.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCatalog<T extends AbstractModel> {

    private HashMap<Long, T> hashMap;
    private float avgGrade;

    public AbstractCatalog() {
        this.hashMap = new HashMap<>();
        this.avgGrade = 0;
    }

    public T get(long id) {
        return hashMap.get(id);
    }

    public List<T> findAll() {
        return (List<T>)hashMap.values();
    }

    public void add(T t) {
        hashMap.put(t.getId(), t);
    }

    public void addList(List<T> list) {
        for(T t: list) {
            hashMap.put(t.getId(), t);
        }
    }

    public void remove(T t) {
        hashMap.remove(t.getId());
    }

    public void remove(long id) {
        hashMap.remove(id);
    }

    public void clear() {
        hashMap.clear();
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float grade) {
        this.avgGrade = grade;
    }

    @Override
    public String toString() {
        String res = "";
        for(Map.Entry<Long, T> map: hashMap.entrySet()) {
            res += (map.getValue() + "\n");
        }
        return res;
    }

}
