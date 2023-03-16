package org.dave.ocrsdriver;

import li.cil.oc.api.Network;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.api.prefab.ManagedEnvironment;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sonar.flux.FluxNetworks;
import sonar.flux.api.network.IFluxNetwork;
import sonar.flux.common.tileentity.TileEntityFlux;

public class DriverFlux extends DriverSidedTileEntity {

    @Override
    public Class<?> getTileEntityClass() {
        return TileEntityFlux.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
        return new Environment((TileEntityFlux) world.getTileEntity(pos));
    }

    public static final class Environment extends ManagedEnvironment {
        private final TileEntityFlux tileEntityFlux;

        public Environment(TileEntityFlux tileEntityFlux) {
            this.tileEntityFlux = tileEntityFlux;
            this.setNode(Network.newNode(this, Visibility.Network).withComponent("fn_interface").create());

        }

        @Callback
        public Object[] getNetworkStats(final Context context, final Arguments args) {
            IFluxNetwork network = FluxNetworks.getServerCache().getNetwork(this.tileEntityFlux.networkID.getObject());
            return new Object[] { network };
        }
    }
}
