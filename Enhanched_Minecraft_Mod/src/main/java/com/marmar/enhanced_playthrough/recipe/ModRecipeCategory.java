package com.marmar.enhanced_playthrough.recipe;

import net.minecraft.util.StringRepresentable;

public enum ModRecipeCategory implements StringRepresentable{
    ALLOY("ore_alloy"),
    SUPER_ALLOY("super_ore_alloy"),
    GEM_POLISH("gem_polish"),
    GRIND("grind"),
    BASIC_SMELT("basic_smelt"),
    SOUL_BASIC_SMELT("soul_basic_smelt")
    ;

    public static final StringRepresentable.EnumCodec<ModRecipeCategory> CODEC = StringRepresentable.fromEnum(ModRecipeCategory::values);
    private final String recipeName;

    private ModRecipeCategory(String pRecipeName){
        this.recipeName = pRecipeName;
    }

    @Override
    public String getSerializedName() {
        return this.recipeName;
    }
}
