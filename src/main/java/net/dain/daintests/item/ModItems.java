package net.dain.daintests.item;

import net.dain.daintests.DainTestsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, DainTestsMod.MOD_ID
    );

    public static final RegistryObject<Item> RAW_WOLFRAMITE = ITEMS.register(
            "raw_wolframite",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> WOLFRAMITE_DUST = ITEMS.register(
            "wolframite_dust",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> WOLFRAMIUM_INGOT = ITEMS.register(
            "wolframium_ingot",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register(
            "bismuth_ingot",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> CRYSTALLIZED_ENDER_ESSSENCE_SHARD = ITEMS.register(
            "crystallized_ender_essence_shard",
            () -> new Item(new Item.Properties())
    );




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
