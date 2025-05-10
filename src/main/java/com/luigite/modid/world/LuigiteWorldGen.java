package com.luigite.modid.world;

import com.luigite.modid.LuigiteMod;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class LuigiteWorldGen {
    // Define registry keys for our placed features
    public static final RegistryKey<PlacedFeature> LUIGITE_ORE_PLACED_KEY = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier.of(LuigiteMod.MOD_ID, "ore_luigite")
    );

    public static final RegistryKey<PlacedFeature> LUIGITE_ORE_DEEPSLATE_PLACED_KEY = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier.of(LuigiteMod.MOD_ID, "ore_deepslate_luigite")
    );

    public static void registerWorldGen() {
        // Add our ores to the world generation
        // Standard Luigite Ore - pass appropriate weight parameter as required in newer versions
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                LUIGITE_ORE_PLACED_KEY
        );

        // Deepslate variant
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                LUIGITE_ORE_DEEPSLATE_PLACED_KEY
        );

        LuigiteMod.LOGGER.info("Registered world generation for Luigite Mod");
    }
}