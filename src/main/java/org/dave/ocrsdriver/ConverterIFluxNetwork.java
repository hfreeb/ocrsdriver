package org.dave.ocrsdriver;

import li.cil.oc.api.driver.Converter;
import sonar.flux.api.network.EnergyStats;
import sonar.flux.api.network.IFluxNetwork;
import sonar.flux.api.network.INetworkStatistics;
import sonar.flux.api.tiles.IFlux;

import java.util.Map;

public class ConverterIFluxNetwork implements Converter  {
    @Override
    public void convert(Object value, final Map<Object, Object> output) {
        if(!(value instanceof IFluxNetwork)) {
            return;
        }

        IFluxNetwork network = (IFluxNetwork) value;
        INetworkStatistics statistics = network.getStatistics();
        EnergyStats stats = statistics.getLatestStats();

        output.put("maxEnergy", network.getMaxEnergyStored());
        output.put("availableEnergy", network.getEnergyAvailable());

        output.put("numControllers", statistics.getConnectionCount(IFlux.ConnectionType.CONTROLLER));
        output.put("numPlug", statistics.getConnectionCount(IFlux.ConnectionType.PLUG));
        output.put("numPoints", statistics.getConnectionCount(IFlux.ConnectionType.POINT));
        output.put("numStorage", statistics.getConnectionCount(IFlux.ConnectionType.STORAGE));

        output.put("tickMaxSent", stats.maxSent);
        output.put("tickMaxReceived", stats.maxReceived);
        output.put("tickTransferred", stats.transfer);


    }
}
