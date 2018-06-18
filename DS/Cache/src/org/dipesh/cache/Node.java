package org.dipesh.cache;

public class Node {
    private int frequency;
    private String key;
    private String value;

    public Node(int frequency, String key, String value) {
        super();
        this.frequency = frequency;
        this.key = key;
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
