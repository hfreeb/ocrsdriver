package org.dave.ocrsdriver;

public class StorageNode {
    private final String type;
    private final boolean external;
    private final int stored;
    private final int capacity;

    public StorageNode(String type, boolean external, int stored, int capacity) {
        this.type = type;
        this.external = external;
        this.stored = stored;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public boolean isExternal() {
        return external;
    }

    public int getStored() {
        return stored;
    }

    public int getCapacity() {
        return capacity;
    }
}
