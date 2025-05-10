package com.luigite.modid.item;

import com.luigite.modid.LuigiteMod;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Luigite Gem with speed effect
    private static final ConsumableComponent LUIGITE_GEM_CONSUMABLE = ConsumableComponents.food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            new StatusEffectInstance(StatusEffects.SPEED, 200, 1),
                            1.0f
                    )
            )
            .build();

    private static final FoodComponent LUIGITE_GEM_FOOD = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(1.2f)
            .build();

    public static final Item LUIGITE_GEM = Registry.register(
            Registries.ITEM,
            Identifier.of(LuigiteMod.MOD_ID, "luigite_gem"),
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(LuigiteMod.MOD_ID, "luigite_gem")))
                    .food(LUIGITE_GEM_FOOD, LUIGITE_GEM_CONSUMABLE)
            )
    );

    public static void registerModItems() {
        LuigiteMod.LOGGER.info("Registering Mod Items for " + LuigiteMod.MOD_ID);
    }
}