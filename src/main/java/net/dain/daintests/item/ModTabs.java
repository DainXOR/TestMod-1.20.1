package net.dain.daintests.item;

import net.dain.daintests.DainTestsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            DainTestsMod.MOD_ID
    );

    public static final RegistryObject<CreativeModeTab> TESTS_TAB = CREATIVE_MODE_TABS.register(
            "tests_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> ModItems.WOLFRAMITE_DUST.get().getDefaultInstance())
                    .title(Component.translatable("creative_tab.daintests.tests"))
                    .displayItems(((pParameters, pOutput) -> ModItems.ITEMS
                            .getEntries()
                            .stream()
                            .map(RegistryObject::get)
                            .forEach(pOutput::accept)))
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> ARTIFACTS_TAB = CREATIVE_MODE_TABS.register(
            "artifacts_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> ModItems.CRYSTALLIZED_ENDER_ESSSENCE_SHARD.get().getDefaultInstance())
                    .title(Component.translatable("creative_tab.daintests.artifacts"))
                    .displayItems((pParameters, pOutput) -> pOutput.accept(Items.ENDER_PEARL))
                    /*
                    .displayItems(((pParameters, pOutput) -> ModItems.ITEMS
                            .getEntries()
                            .stream()
                            .map(RegistryObject::get)
                            .filter(item -> item.getRarity(item.getDefaultInstance()).ordinal() >= Rarity.RARE.ordinal())
                            .forEach(pOutput::accept)))
                     */
                    /*
                    .displayItems(((pParameters, pOutput) -> BuiltInRegistries.ITEM
                            .stream()
                            .filter(item -> item.getRarity(item.getDefaultInstance()).ordinal() < Rarity.RARE.ordinal())
                            .forEach(pOutput::accept)))
                     */
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> RELICS_TAB = CREATIVE_MODE_TABS.register(
            "relics_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> Items.ENDER_PEARL.getDefaultInstance())
                    .title(Component.translatable("creative_tab.daintests.relics"))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
