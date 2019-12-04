package com.company.model.AbstractDataTypes;

import com.company.model.Values.Value;

import java.util.Map;
import java.util.Set;

public interface MyIHeap<K,V> {
    boolean isDefined(K id);
    void update(Integer id, Value value);
    void update(V value);
    void remove(Value value);
    K getCurrentFree();
    Set<Map.Entry<K,V>> getEntrySet();
    V getValue(K key);
    void setContent(Map<Integer, Value> newContent);
}
