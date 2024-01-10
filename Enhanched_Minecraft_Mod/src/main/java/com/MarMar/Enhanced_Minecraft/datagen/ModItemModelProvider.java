package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Enhanced_Minecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        simpleItem(ModItems.Banana);
                simpleItem(ModItems.Green_apple);
                simpleItem(ModItems.Lemon);
                simpleItem(ModItems.Orange);
                simpleItem(ModItems.Sulfur);
                simpleItem(ModItems.Raw_tin);
                simpleItem(ModItems.Tin_ingot);
                simpleItem(ModItems.Bronze_ingot);
                simpleItem(ModItems.Raw_steel);
                simpleItem(ModItems.Steel_ingot);

                HandheldItem(ModItems.Bronze_sword);
                HandheldItem(ModItems.Bronze_pickaxe);
                HandheldItem(ModItems.Bronze_axe);
                HandheldItem(ModItems.Bronze_shovel);
                HandheldItem(ModItems.Bronze_hoe);

                HandheldItem(ModItems.Steel_sword);
                HandheldItem(ModItems.Steel_pickaxe);
                HandheldItem(ModItems.Steel_axe);
                HandheldItem(ModItems.Steel_shovel);
                HandheldItem(ModItems.Steel_hoe);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture ("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID,
                        "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder HandheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "item/" + item.getId().getPath()));
    }
}
