package com.MarMar.Enhanced_Minecraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodPropieties {
    //Regular food
    public static final FoodProperties MATE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.6f)
            .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200,1), 0.5f)
            .alwaysEat().build();
    public static final FoodProperties COOKED_ZAPALLO = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_EGGPLANT = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties COOKED_CORN = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties RICE_BOWL = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.5f).build();
    //Fruit
    public static final FoodProperties ORANGE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties LEMON = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties GREEN_APPLE = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.4f).build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1f).build();
    public static final FoodProperties PEELED_WALNUT = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.4f).build();
    //Vegetables
    public static final FoodProperties RICE = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.1f).effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.2f)
            .build();
    public static final FoodProperties ZAPALLO = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties EGGPLANT = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();

}
