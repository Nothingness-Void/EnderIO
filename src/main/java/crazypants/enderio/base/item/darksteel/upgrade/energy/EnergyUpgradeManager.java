package crazypants.enderio.base.item.darksteel.upgrade.energy;

import java.util.Random;

import javax.annotation.Nonnull;

import crazypants.enderio.base.handler.darksteel.AbstractUpgrade;
import crazypants.enderio.base.item.darksteel.upgrade.energy.EnergyUpgrade.EnergyUpgradeHolder;
import crazypants.enderio.base.lang.LangPower;
import net.minecraft.item.ItemStack;

public abstract class EnergyUpgradeManager {

  protected static final @Nonnull String UPGRADE_NAME = "energyUpgrade";
  protected static final @Nonnull String KEY_ENERGY = "energy";
  protected static final @Nonnull Random RANDOM = new Random();

  public static EnergyUpgrade.EnergyUpgradeHolder loadFromItem(@Nonnull ItemStack stack) {
    EnergyUpgrade energyUpgrade = EnergyUpgrade.loadAnyFromItem(stack);
    return energyUpgrade != null ? energyUpgrade.getEnergyUpgradeHolder(stack) : null;
  }

  public static boolean itemHasAnyPowerUpgrade(@Nonnull ItemStack itemstack) {
    return EnergyUpgrade.loadAnyFromItem(itemstack) != null;
  }

  public static AbstractUpgrade next(AbstractUpgrade upgrade) {
    if (upgrade == null) {
      return EnergyUpgrade.EMPOWERED;
    } else if (upgrade == EnergyUpgrade.EMPOWERED) {
      return EnergyUpgrade.EMPOWERED_TWO;
    } else if (upgrade == EnergyUpgrade.EMPOWERED_TWO) {
      return EnergyUpgrade.EMPOWERED_THREE;
    } else if (upgrade == EnergyUpgrade.EMPOWERED_THREE) {
      return EnergyUpgrade.EMPOWERED_FOUR;
    }
    return null;
  }

  public static int extractEnergy(@Nonnull ItemStack container, int maxExtract, boolean simulate) {
    EnergyUpgradeHolder eu = loadFromItem(container);
    if (eu == null) {
      return 0;
    }
    int res = eu.extractEnergy(maxExtract, simulate);
    if (!simulate && res > 0) {
      eu.writeToItem(container);
    }
    return res;
  }

  public static int receiveEnergy(@Nonnull ItemStack container, int maxReceive, boolean simulate) {
    EnergyUpgradeHolder eu = loadFromItem(container);
    if (eu == null) {
      return 0;
    }
    int res = eu.receiveEnergy(maxReceive, simulate);
    if (!simulate && res > 0) {
      eu.writeToItem(container);
    }
    return res;
  }

  public static void setPowerLevel(@Nonnull ItemStack item, int amount) {
    if (!itemHasAnyPowerUpgrade(item)) {
      return;
    }
    amount = Math.min(amount, getMaxEnergyStored(item));
    EnergyUpgradeHolder eu = loadFromItem(item);
    eu.setEnergy(amount);
    eu.writeToItem(item);
  }

  public static void setPowerFull(@Nonnull ItemStack item) {
    if (!itemHasAnyPowerUpgrade(item)) {
      return;
    }
    EnergyUpgradeHolder eu = loadFromItem(item);
    eu.setEnergy(eu.getCapacity());
    eu.writeToItem(item);
  }

  public static String getStoredEnergyString(@Nonnull ItemStack itemstack) {
    EnergyUpgradeHolder up = loadFromItem(itemstack);
    if (up == null) {
      return null;
    }
    return LangPower.RF(up.getEnergy(), up.getCapacity());
  }

  public static int getEnergyStored(@Nonnull ItemStack container) {
    EnergyUpgradeHolder eu = loadFromItem(container);
    if (eu == null) {
      return 0;
    }
    return eu.getEnergy();
  }

  public static int getMaxEnergyStored(@Nonnull ItemStack container) {
    EnergyUpgradeHolder eu = loadFromItem(container);
    if (eu == null) {
      return 0;
    }
    return eu.getCapacity();
  }

}