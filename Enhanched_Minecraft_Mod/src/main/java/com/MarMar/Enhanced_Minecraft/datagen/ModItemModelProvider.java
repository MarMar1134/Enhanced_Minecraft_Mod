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
        simpleItem(ModItems.Banana);
                simpleItem(ModItems.Green_apple);
                simpleItem(ModItems.Lemon);
                simpleItem(ModItems.Orange);
                simpleItem(ModItems.Sulfur);
                simpleItem(ModItems.Raw_tin);
                simpleItem(ModItems.Tin_ingot);
                simpleItem(ModItems.Bronze_ingot);
                simpleItem(ModItems.Raw_steel);
                simpleItem(ModItems.Steel_ingot);

                SwordItem(ModItems.Bronze_sword);
        PicaxeItem(ModItems.Bronze_picaxe);
        AxeItem(ModItems.Bronze_axe);
        ShovelItem(ModItems.Bronze_shovel);
        HoeItem(ModItems.Bronze_hoe);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture ("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID,
                        "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder SwordItem(RegistryObject<SwordItem> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder PicaxeItem(RegistryObject<PickaxeItem> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder AxeItem(RegistryObject<AxeItem> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder ShovelItem(RegistryObject<ShovelItem> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder HoeItem(RegistryObject<HoeItem> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "item/" + item.getId().getPath()));
    }
}
