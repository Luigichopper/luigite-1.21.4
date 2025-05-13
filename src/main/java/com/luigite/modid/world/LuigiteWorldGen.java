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

    public static void registerWorldGen() {
        LuigiteMod.LOGGER.info("Starting registration of Luigite ore generation...");

        try {
            // Standard Luigite Ore
            LuigiteMod.LOGGER.info("Registering standard luigite ore generation with key: {}",
                    LUIGITE_ORE_PLACED_KEY.getValue());

            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    LUIGITE_ORE_PLACED_KEY
            );

            LuigiteMod.LOGGER.info("Successfully registered world generation for Luigite Mod");
        } catch (Exception e) {
            LuigiteMod.LOGGER.error("Failed to register Luigite ore generation!", e);
            e.printStackTrace();
        }
    }

    // Helper method to verify if features exist in the registry
    public static void verifyFeatureRegistration() {
        // This should be called after the world is loaded
        // For example, in a ServerStartingEvent or similar
        try {
            // You can add code here to check if your features are properly registered
            LuigiteMod.LOGGER.info("Verifying Luigite ore features in registry...");
            // This logging will help identify if the features are properly registered
        } catch (Exception e) {
            LuigiteMod.LOGGER.error("Error while verifying feature registration", e);
        }
    }
}