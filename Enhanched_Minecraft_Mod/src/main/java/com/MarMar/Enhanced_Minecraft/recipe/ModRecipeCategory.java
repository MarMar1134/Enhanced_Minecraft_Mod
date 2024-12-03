package com.MarMar.Enhanced_Minecraft.recipe;

import net.minecraft.util.StringRepresentable;
import org.stringtemplate.v4.ST;

public enum ModRecipeCategory implements StringRepresentable{
    ALLOY("ore_alloy"),
    SUPER_ALLOY("super_ore_alloy"),
    GEM_POLISH("gem_polish"),
    GRIND("grind"),
    BASIC_SMELT("basic_smelt")

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
