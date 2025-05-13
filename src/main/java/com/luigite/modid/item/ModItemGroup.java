package com.luigite.modid.item;

import com.luigite.modid.LuigiteMod;
import com.luigite.modid.block.ModBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup LUIGITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LuigiteMod.MOD_ID, "luigite_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.luigite.luigite_group"))
                    .icon(() -> new ItemStack(ModItems.LUIGITE_GEM)) // Use the gem as the icon
                    .entries((displayContext, entries) -> {
                        // Add blocks to the item group
                        entries.add(ModBlocks.LUIGITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LUIGITE_ORE);
                        entries.add(ModBlocks.LUIGITE_BLOCK);

                        // Add items to the item group
                        entries.add(ModItems.LUIGITE_GEM);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        // Method is called to trigger static initialization
        LuigiteMod.LOGGER.info("Registering Item Groups for " + LuigiteMod.MOD_ID);
    }
}