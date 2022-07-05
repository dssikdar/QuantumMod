package com.diptanshu.quantummod2.item;

import com.diptanshu.quantummod2.QuantumMod2;
import com.diptanshu.quantummod2.item.custom.MeasurementItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // List of items created under "newtrymod" as known by Forge
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, QuantumMod2.MOD_ID);

    /**
    public static final RegistryObject<MeasurementItem> MEASUREMENT = ITEMS.register("measurement",
            () -> new MeasurementItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
     */

    // create a register
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}