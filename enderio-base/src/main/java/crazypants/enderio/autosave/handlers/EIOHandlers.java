package crazypants.enderio.autosave.handlers;

import crazypants.enderio.autosave.handlers.endercore.HandleEnderInventory;
import crazypants.enderio.autosave.handlers.endercore.HandleNNList;
import crazypants.enderio.autosave.handlers.endercore.HandleSmartTank;
import crazypants.enderio.autosave.handlers.endercore.HandleThings;
import crazypants.enderio.autosave.handlers.endercore.HandleUserIdent;
import crazypants.enderio.autosave.handlers.enderio.HandleCapturedMob;
import crazypants.enderio.autosave.handlers.enderio.HandleExperienceContainer;
import crazypants.enderio.autosave.handlers.enderio.HandleIMachineRecipe;
import crazypants.enderio.autosave.handlers.enderio.HandlePoweredTask;
import info.loenwind.autosave.exceptions.NoHandlerFoundException;

import static info.loenwind.autosave.Registry.GLOBAL_REGISTRY;

public class EIOHandlers {

  public static void register() {
    try {
      // EnderCore Object Handlers
      GLOBAL_REGISTRY.register(new HandleEnderInventory());
      GLOBAL_REGISTRY.register(new HandleNNList());
      GLOBAL_REGISTRY.register(new HandleSmartTank());
      GLOBAL_REGISTRY.register(new HandleThings());
      GLOBAL_REGISTRY.register(new HandleUserIdent());

      // EnderIO Object Handlers
      GLOBAL_REGISTRY.register(new HandleCapturedMob());
      GLOBAL_REGISTRY.register(new HandleExperienceContainer());
      GLOBAL_REGISTRY.register(new HandleIMachineRecipe());
      GLOBAL_REGISTRY.register(new HandlePoweredTask());

    } catch (NoHandlerFoundException ignored) {} // impossible
  }

}
