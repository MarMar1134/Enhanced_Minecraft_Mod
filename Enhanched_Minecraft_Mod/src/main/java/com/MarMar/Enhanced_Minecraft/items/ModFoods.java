package com.MarMar.Enhanced_Minecraft.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoods {
    //Fruit
    public static final FoodProperties Orange= new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties Lemon = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties Green_apple = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.4f).build();
    //Vegetables
    public static final FoodProperties Rice = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.1f).effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.2f)
            .build();
    public static final FoodProperties Rice_bawl = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.5f).build();
}
