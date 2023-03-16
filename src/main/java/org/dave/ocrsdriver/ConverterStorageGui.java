package org.dave.ocrsdriver;

import com.raoulvdberge.refinedstorage.tile.IStorageGui;
import com.raoulvdberge.refinedstorage.tile.config.IType;
import com.raoulvdberge.refinedstorage.tile.externalstorage.TileExternalStorage;
import li.cil.oc.api.driver.Converter;

import java.util.Map;

public class ConverterStorageGui implements Converter  {
    @Override
    public void convert(Object value, final Map<Object, Object> output) {
        if(!(value instanceof IStorageGui)) {
            return;
        }

        IStorageGui storage = (IStorageGui) value;

        String type;
        if (storage.getTypeParameter().getValue() == IType.ITEMS) {
            type = "items";
        } else {
            type = "fluids";
        }

        boolean external = value instanceof TileExternalStorage;

        output.put("stored", storage.getStored());
        output.put("capacity", storage.getCapacity());
        output.put("type", type);
        output.put("external", external);
    }
}
