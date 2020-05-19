package collections.my;

import java.util.*;


public class MyMap<K, V> extends AbstractMap<K, V>{
    private ArrayList<Node> arrayList;

    private static class Node<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }
    }

    public MyMap() {
        arrayList = new ArrayList<>();
    }

    public MyMap(MyMap<? extends K, ? extends V> map){
        for(int i = 0; i < map.size(); i++) {
            this.arrayList.add(map.arrayList.get(i));
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = null;
        for (Node el : arrayList) {
            set.add(el);
        }
        return set;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node val : arrayList) {
            if (val.getValue().equals(value)) return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Node val : arrayList) {
            if (val.getKey() == key) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if(arrayList.size() == 0) return null;
        for (Node val : arrayList) {
            if (val.getKey() == key) return (V) val.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V val = get(key);
        arrayList.add(new Node(key, value));
        return val;
    }

    @Override
    public V remove(Object key) {
        V val = get(key);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getKey() == key) {
                arrayList.remove(i);
            }
        }
        return val;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Map<K, V> map = null;
        for(Node el: arrayList) {
            map.put((K)el.getKey(), (V)el.getValue());
        }
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Node el : arrayList) {
            set.add((K) el.getKey());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> coll = new ArrayList<>();
        for (Node el : arrayList) {
            coll.add((V) el.getValue());
        }
        return coll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyMap<?, ?> myMap = (MyMap<?, ?>) o;
        return Objects.equals(arrayList, myMap.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), arrayList);
    }

    @Override
    public String toString() {
        String str = "[";
        for(int i = 0; i < size() - 1; i++) {
            str = str + arrayList.get(i).getKey() + "=" + arrayList.get(i).getValue() + ", ";
        }
        str = str + arrayList.get(size()-1).getKey() + "=" + arrayList.get(size()-1).getValue() + "]";
        return str;
    }

    public static void main(String[] args) {
        MyMap<Integer, Float> map = new MyMap<>();
        map.put(1, 0.1f);
        map.put(2, 0.2f);
        map.put(3, 0.3f);
        map.put(4, 0.4f);
        map.put(5, 0.5f);
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.values());
        System.out.println(map.keySet());
        System.out.println(map.size());
        System.out.println(map.containsKey(4));
        System.out.println(map.containsKey(6));
        System.out.println(map.containsValue(0.1f));
        map.remove(3);
        System.out.println(map);
    }
}
