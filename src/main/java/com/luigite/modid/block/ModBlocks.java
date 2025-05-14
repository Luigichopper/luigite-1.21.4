package com.luigite.modid.block;

import com.luigite.modid.LuigiteMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    // Use registry keys for blocks
    public static final RegistryKey<Block> LUIGITE_ORE_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(LuigiteMod.MOD_ID, "luigite_ore")
    );

    public static final RegistryKey<Block> DEEPSLATE_LUIGITE_ORE_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(LuigiteMod.MOD_ID, "deepslate_luigite_ore")
    );

    public static final RegistryKey<Block> LUIGITE_BLOCK_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(LuigiteMod.MOD_ID, "luigite_block")
    );

    // Initialize blocks
    public static final Block LUIGITE_ORE = Registry.register(
            Registries.BLOCK,
            LUIGITE_ORE_KEY.getValue(),
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.STONE_GRAY)
                            .strength(3.0f, 3.0f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
                            .registryKey(LUIGITE_ORE_KEY)
            )
    );

    public static final Block DEEPSLATE_LUIGITE_ORE = Registry.register(
            Registries.BLOCK,
            DEEPSLATE_LUIGITE_ORE_KEY.getValue(),
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DEEPSLATE_GRAY)
                            .strength(4.5f, 4.0f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)
                            .registryKey(DEEPSLATE_LUIGITE_ORE_KEY)
            )
    );

    public static final Block LUIGITE_BLOCK = Registry.register(
            Registries.BLOCK,
            LUIGITE_BLOCK_KEY.getValue(),
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.EMERALD_GREEN) // You can change this color
                            .strength(5.0f, 6.0f) // Similar to iron block
                            .requiresTool()
                            .sounds(BlockSoundGroup.METAL) // Metal sound for a refined block
                            .registryKey(LUIGITE_BLOCK_KEY)
            )
    );

    // Initialize block items
    public static final Item LUIGITE_ORE_ITEM = Registry.register(
            Registries.ITEM,
            LUIGITE_ORE_KEY.getValue(),
            new BlockItem(LUIGITE_ORE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, LUIGITE_ORE_KEY.getValue())))
    );

    public static final Item DEEPSLATE_LUIGITE_ORE_ITEM = Registry.register(
            Registries.ITEM,
            DEEPSLATE_LUIGITE_ORE_KEY.getValue(),
            new BlockItem(DEEPSLATE_LUIGITE_ORE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, DEEPSLATE_LUIGITE_ORE_KEY.getValue())))
    );

    public static final Item LUIGITE_BLOCK_ITEM = Registry.register(
            Registries.ITEM,
            LUIGITE_BLOCK_KEY.getValue(),
            new BlockItem(LUIGITE_BLOCK, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, LUIGITE_BLOCK_KEY.getValue())))
    );

    public static void registerModBlocks() {
        LuigiteMod.LOGGER.info("Registered mod blocks for " + LuigiteMod.MOD_ID);
        LuigiteMod.LOGGER.info("LUIGITE_ORE registry key: " + Registries.BLOCK.getId(LUIGITE_ORE));
        LuigiteMod.LOGGER.info("DEEPSLATE_LUIGITE_ORE registry key: " + Registries.BLOCK.getId(DEEPSLATE_LUIGITE_ORE));
        LuigiteMod.LOGGER.info("LUIGITE_BLOCK registry key: " + Registries.BLOCK.getId(LUIGITE_BLOCK));
    }
}