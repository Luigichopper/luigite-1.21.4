package com.luigite.modid.villager;

import com.luigite.modid.LuigiteMod;
import com.luigite.modid.item.ModItems;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradedItem;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModTrades {

    public static void registerCustomTrades() {
        LuigiteMod.LOGGER.info("Registering custom villager trades for " + LuigiteMod.MOD_ID);

        // Get the Cleric profession directly from the registry
        VillagerProfession CLERIC = Registries.VILLAGER_PROFESSION.get(Identifier.of("minecraft", "cleric"));

        // Add a trade to Cleric villagers at level 2 (Apprentice) - was 3 (Journeyman)
        TradeOfferHelper.registerVillagerOffers(CLERIC, 2, factories -> {
            // Create a new trade factory for Luigite Gem - reduced price from 8 to 3 emeralds
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),         // 3 emeralds as payment (was 8)
                    new ItemStack(ModItems.LUIGITE_GEM, 1),   // 1 Luigite Gem in return
                    8,      // Maximum uses before restocking
                    5,      // Villager experience gained per trade
                    0.05f   // Price multiplier (affects price increases)
            ));
        });

        // Add another trade for Luigite Apple at level 3 (Journeyman) - was 4 (Expert)
        TradeOfferHelper.registerVillagerOffers(CLERIC, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 9),        // 9 emeralds as payment (was 16)
                    new ItemStack(ModItems.LUIGITE_APPLE, 1), // 1 Luigite Apple in return
                    4,      // Maximum uses before restocking (rarer)
                    12,     // More villager experience gained
                    0.05f   // Price multiplier
            ));
        });

        LuigiteMod.LOGGER.info("Custom villager trades registered successfully");
    }
}