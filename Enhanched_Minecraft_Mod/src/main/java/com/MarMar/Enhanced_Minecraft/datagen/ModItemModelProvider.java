package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Enhanced_Minecraft.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Enhanced_Minecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Food
//        simpleItem(ModItems.Banana);
        simpleItem(ModItems.Green_apple);
        simpleItem(ModItems.Lemon);
        simpleItem(ModItems.Orange);
        simpleItem(ModItems.Rice);
        simpleItem(ModItems.Rice_bowl);
        simpleItem(ModItems.Yerba_mate);
        simpleItem(ModItems.Grounded_yerba_mate);
        simpleItem(ModItems.Mate);
        simpleItem(ModItems.Empty_mate);
        simpleItem(ModItems.Zapallo);
        simpleItem(ModItems.Cooked_zapallo);
        simpleItem(ModItems.Eggplant);
        simpleItem(ModItems.Cooked_eggplant);
        simpleItem(ModItems.Tomato);
        simpleItem(ModItems.Corn);
        simpleItem(ModItems.Cooked_corn);

        //Seeds
        simpleItem(ModItems.Yerba_mate_seeds);
        simpleItem(ModItems.Zapallo_seeds);
        simpleItem(ModItems.Eggplant_seeds);
        simpleItem(ModItems.Tomato_seeds);
        simpleItem(ModItems.Corn_seeds);

        //Ores
        simpleItem(ModItems.Sulfur);

        simpleItem(ModItems.Raw_tin);
        simpleItem(ModItems.Tin_ingot);

        simpleItem(ModItems.Raw_bronze);
        simpleItem(ModItems.Bronze_ingot);
        simpleItem(ModItems.Bronze_nugget);

        simpleItem(ModItems.Raw_steel);
        simpleItem(ModItems.Steel_ingot);

        simpleItem(ModItems.Raw_silver);
        simpleItem(ModItems.Silver_ingot);
        simpleItem(ModItems.Silver_nugget);

        simpleItem(ModItems.Rose_gold_ingot);
        simpleItem(ModItems.Rose_gold_nugget);

        simpleItem(ModItems.Cobalt);

        simpleItem(ModItems.Raw_rubi);
        simpleItem(ModItems.Raw_saphire);
        simpleItem(ModItems.Raw_emerald);
        simpleItem(ModItems.Raw_diamond);

        simpleItem(ModItems.Rubi);
        simpleItem(ModItems.Saphire);

        simpleItem(ModItems.Reinforced_diamond);

        //Smithing templates
        simpleItem(ModItems.reinforcing_upgrade_smithing_template);

        //Armors and tools
            //Gold
            HandheldItem(ModItems.Gold_polisher);

            //Silver
            HandheldItem(ModItems.Silver_sword);
            HandheldItem(ModItems.Silver_pickaxe);
            HandheldItem(ModItems.Silver_axe);
            HandheldItem(ModItems.Silver_shovel);
            HandheldItem(ModItems.Silver_hoe);
            HandheldItem(ModItems.Silver_polisher);

            simpleItem(ModItems.Silver_helmet);
            simpleItem(ModItems.Silver_chestplate);
            simpleItem(ModItems.Silver_leggings);
            simpleItem(ModItems.Silver_boots);

            //Stone
            HandheldItem(ModItems.Stone_polisher);

            //Bronze
            HandheldItem(ModItems.Bronze_sword);
            HandheldItem(ModItems.Bronze_pickaxe);
            HandheldItem(ModItems.Bronze_axe);
            HandheldItem(ModItems.Bronze_shovel);
            HandheldItem(ModItems.Bronze_hoe);
            HandheldItem(ModItems.Bronze_polisher);

            simpleItem(ModItems.Bronze_helmet);
            simpleItem(ModItems.Bronze_chestplate);
            simpleItem(ModItems.Bronze_leggings);
            simpleItem(ModItems.Bronze_boots);

            //Iron
            HandheldItem(ModItems.Iron_polisher);

            //Rose Gold
            HandheldItem(ModItems.Rose_golden_sword);
            HandheldItem(ModItems.Rose_golden_pickaxe);
            HandheldItem(ModItems.Rose_golden_axe);
            HandheldItem(ModItems.Rose_golden_shovel);
            HandheldItem(ModItems.Rose_golden_hoe);
            HandheldItem(ModItems.Rose_golden_polisher);

            simpleItem(ModItems.Rose_golden_helmet);
            simpleItem(ModItems.Rose_golden_chestplate);
            simpleItem(ModItems.Rose_golden_leggings);
            simpleItem(ModItems.Rose_golden_boots);

            //Steel
            HandheldItem(ModItems.Steel_sword);
            HandheldItem(ModItems.Steel_pickaxe);
            HandheldItem(ModItems.Steel_axe);
            HandheldItem(ModItems.Steel_shovel);
            HandheldItem(ModItems.Steel_hoe);
            HandheldItem(ModItems.Steel_polisher);

            simpleItem(ModItems.Steel_helmet);
            simpleItem(ModItems.Steel_chestplate);
            simpleItem(ModItems.Steel_leggings);
            simpleItem(ModItems.Steel_boots);

            //Diamond
            HandheldItem(ModItems.Diamond_polisher);

            //Reinforced Diamond
            HandheldItem(ModItems.Reinforced_diamond_sword);
            HandheldItem(ModItems.Reinforced_diamond_pickaxe);
            HandheldItem(ModItems.Reinforced_diamond_axe);
            HandheldItem(ModItems.Reinforced_diamond_shovel);
            HandheldItem(ModItems.Reinforced_diamond_hoe);

            simpleItem(ModItems.Reinforced_diamond_helmet);
            simpleItem(ModItems.Reinforced_diamond_chestplate);
            simpleItem(ModItems.Reinforced_diamond_leggings);
            simpleItem(ModItems.Reinforced_diamond_boots);

            //Netherite
            HandheldItem(ModItems.Netherite_polisher);
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
