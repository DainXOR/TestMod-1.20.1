package net.dain.daintests.block;

import net.dain.daintests.DainTestsMod;
import net.dain.daintests.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final
    DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, DainTestsMod.MOD_ID
    );

    public static final RegistryObject<Block> WOLFRAMITE_ORE = registerBlock(
            "wolframite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(30f, 75f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(18, 21))
    );

    public static final RegistryObject<Block> DEEPSLATE_WOLFRAMITE_ORE = registerBlock(
            "deepslate_wolframite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(40f, 75f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(18, 21))
    );

    public static final RegistryObject<Block> WOLFRAMIUM_BLOCK = registerBlock(
            "wolframium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .sound(SoundType.METAL)
                    .strength(60f, 2200f)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> END_STONE_ENDER_ESSENCE_ORE = registerBlock(
            "end_stone_ender_essence_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(9f, 12f)
                    .requiresCorrectToolForDrops()
                    .lightLevel((state) -> 8),
                    UniformInt.of(12, 15))
    );

    public static final RegistryObject<Block> NETHERRACK_ENDER_ESSENCE_ORE = registerBlock(
            "netherrack_ender_essence_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(4f, 9f)
                    .requiresCorrectToolForDrops()
                    .lightLevel((state) -> 8),
                    UniformInt.of(12, 15))
    );


    private static <T extends Block>
    RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> registryObject = BLOCKS.register(name, block);
        registerBlockItem(name, registryObject);

        return registryObject;
    }

    private static <T extends Block>
    RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static
    void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
