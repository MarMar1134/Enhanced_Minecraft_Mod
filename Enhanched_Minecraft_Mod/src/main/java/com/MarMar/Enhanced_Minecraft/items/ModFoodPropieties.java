package com.MarMar.Enhanced_Minecraft.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodPropieties {
    //Regular food
    public static final FoodProperties Mate = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.6f)
            .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200,1), 0.5f)
            .alwaysEat().build();
    public static final FoodProperties Cooked_zapallo = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties Cooked_eggplant = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties Cooked_corn = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties Rice_bowl = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.5f).build();
    //Fruit
    public static final FoodProperties Orange= new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties Lemon = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties Green_apple = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.4f).build();
    public static final FoodProperties Tomato = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties Corn = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1f).build();
    //Vegetables
    public static final FoodProperties Rice = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.1f).effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.2f)
            .build();
    public static final FoodProperties Zapallo = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties Eggplant = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();

}
