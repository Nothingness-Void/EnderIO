package crazypants.enderio.machine.generator;

import net.minecraft.util.EnumFacing;
import crazypants.enderio.capacitor.ICapacitorKey;
import crazypants.enderio.machine.AbstractPoweredMachineEntity;
import crazypants.enderio.machine.SlotDefinition;
import crazypants.enderio.power.IInternalPowerProvider;

public abstract class AbstractGeneratorEntity extends AbstractPoweredMachineEntity implements IInternalPowerProvider {

  //RF API Power

  @Deprecated
  public AbstractGeneratorEntity(SlotDefinition slotDefinition) {
    super(slotDefinition);
  }

  protected AbstractGeneratorEntity(SlotDefinition slotDefinition, ICapacitorKey maxEnergyRecieved, ICapacitorKey maxEnergyStored, ICapacitorKey maxEnergyUsed) {
    super(slotDefinition, maxEnergyRecieved, maxEnergyStored, maxEnergyUsed);
  }

  @Override
  public int getEnergyStored(EnumFacing from) {
    return getEnergyStored();
  }

  @Override
  public int getMaxEnergyStored(EnumFacing from) {
    return getMaxEnergyStored();
  }

  @Override
  public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
    return 0;
  }

}
