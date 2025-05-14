package com.luigite.modid;

import com.luigite.modid.block.ModBlocks;
import com.luigite.modid.item.ModItemGroup;
import com.luigite.modid.item.ModItems;
import com.luigite.modid.villager.ModTrades;
import com.luigite.modid.world.LuigiteWorldGen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuigiteMod implements ModInitializer {
    public static final String MOD_ID = "luigite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModTrades.registerCustomTrades();
        LuigiteWorldGen.registerWorldGen();


        LOGGER.info("Luigite Mod has been initialized!");
    }
}