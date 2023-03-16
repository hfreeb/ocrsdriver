package org.dave.ocrsdriver;

import li.cil.oc.api.driver.Converter;

import java.util.Map;

public class ConverterStorageNode implements Converter {
    @Override
    public void convert(Object value, final Map<Object, Object> output) {
        if (!(value instanceof StorageNode)) {
            return;
        }

        StorageNode storage = (StorageNode) value;

        output.put("stored", storage.getStored());
        output.put("capacity", storage.getCapacity());
        output.put("type", storage.getType());
        output.put("external", storage.isExternal());
    }
}
