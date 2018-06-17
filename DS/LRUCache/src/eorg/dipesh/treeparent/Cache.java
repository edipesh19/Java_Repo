package eorg.dipesh.treeparent;

import java.util.Map;
import java.util.Set;

public interface Cache<K, V> {
    V retrive(K key);

    V insert(K key, V value);

    Set<Map.Entry<K,V>> getAll();
}
