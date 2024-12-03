package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> Tabs=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Enhanced_Playthrough.MOD_ID);

    //Tabs
    public static final RegistryObject<CreativeModeTab> Saplings= Tabs.register(
            "saplings", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.WALNUT_SAPLING.get()))
                    .title(Component.translatable("creativetab.saplings"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.WALNUT_SAPLING.get());
                        output.accept(ModBlocks.WALNUT_LEAVES.get());
                        output.accept(ModBlocks.APPLE_SAPLING.get());
                        output.accept(ModBlocks.APPLE_LEAVES.get());
                        output.accept(ModBlocks.GREEN_APPLE_SAPLING.get());
                        output.accept(ModBlocks.GREEN_APPLE_LEAVES.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> Wood= Tabs.register(
            "woodtypes", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.WALNUT_PLANKS.get()))
                    .title(Component.translatable("creativetab.woodtypes"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.WALNUT_LOG.get());
                        output.accept(ModBlocks.STRIPPED_WALNUT_LOG.get());
                        output.accept(ModBlocks.WALNUT_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_WALNUT_WOOD.get());
                        output.accept(ModBlocks.WALNUT_PLANKS.get());
                        output.accept(ModBlocks.WALNUT_DOOR.get());
                        output.accept(ModBlocks.WALNUT_TRAPDOOR.get());
                        output.accept(ModBlocks.WALNUT_BUTTON.get());
                        output.accept(ModBlocks.WALNUT_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.WALNUT_SLAB.get());
                        output.accept(ModBlocks.WALNUT_STAIRS.get());
                        output.accept(ModBlocks.WALNUT_FENCE.get());
                        output.accept(ModBlocks.WALNUT_FENCEGATE.get());

                        output.accept(ModBlocks.APPLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_APPLE_LOG.get());
                        output.accept(ModBlocks.APPLE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_APPLE_WOOD.get());
                        output.accept(ModBlocks.APPLE_PLANKS.get());
                        output.accept(ModBlocks.APPLE_DOOR.get());
                        output.accept(ModBlocks.APPLE_TRAPDOOR.get());
                        output.accept(ModBlocks.APPLE_BUTTON.get());
                        output.accept(ModBlocks.APPLE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.APPLE_SLAB.get());
                        output.accept(ModBlocks.APPLE_STAIRS.get());
                        output.accept(ModBlocks.APPLE_FENCE.get());
                        output.accept(ModBlocks.APPLE_FENCEGATE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> Blocks = Tabs.register(
            "blocks", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.POLISHED_LIMESTONE.get()))
                    .title(Component.translatable("creativetab.blocks"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.POLISHED_STONE.get());
                        output.accept(ModBlocks.POLISHED_STONE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_STONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_STONE_WALL.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE_SLAB.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE_STAIRS.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE_WALL.get());
                        output.accept(ModBlocks.LIMESTONE.get());
                        output.accept(ModBlocks.LIMESTONE_SLAB.get());
                        output.accept(ModBlocks.LIMESTONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE_WALL.get());
                        output.accept(ModBlocks.LIMESTONE_BRICKS.get());
                        output.accept(ModBlocks.LIMESTONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.LIMESTONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.LIMESTONE_BRICK_WALL.get());
                        output.accept(ModBlocks.SOUL_MUD.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICKS.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICK_SLAB.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICK_STAIRS.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICK_WALL.get());
                        output.accept(ModBlocks.SILVER_BLOCK.get());
                        output.accept(ModBlocks.TIN_BLOCK.get());
                        output.accept(ModBlocks.ZINC_BLOCK.get());
                        output.accept(ModBlocks.BRASS_BLOCK.get());
                        output.accept(ModBlocks.BRONZE_BLOCK.get());
                        output.accept(ModBlocks.ROSE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.STEEL_BLOCK.get());
                        output.accept(ModBlocks.GREEN_GOLD_BLOCK.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> Minerals = Tabs.register(
            "minerals", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_ORE.get()))
                    .title(Component.translatable("creativetab.minerals"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SULFUR_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
                        output.accept(ModBlocks.NETHER_SULFUR_ORE.get());

                        output.accept(ModBlocks.TIN_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE.get());

                        output.accept(ModBlocks.ZINC_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ZINC_ORE.get());
                        output.accept(ModBlocks.NETHER_ZINC_ORE.get());

                        output.accept(ModBlocks.SILVER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());

                        output.accept(ModBlocks.DEEPSLATE_COBALT_ORE.get());

                        output.accept(ModBlocks.RUBI_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBI_ORE.get());

                        output.accept(ModBlocks.SAPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPHIRE_ORE.get());

                        output.accept(ModItems.SULFUR.get());

                        output.accept((ModItems.RAW_TIN.get()));

                        output.accept(ModItems.RAW_ZINC.get());

                        output.accept(ModItems.RAW_SILVER.get());

                        output.accept(ModItems.COBALT.get());
                        output.accept(ModItems.COBALT_DUST.get());

                        output.accept(ModItems.RAW_RUBI.get());

                        output.accept(ModItems.RAW_SAPPHIRE.get());

                        output.accept(ModItems.RAW_EMERALD.get());

                        output.accept(ModItems.RAW_DIAMOND.get());

                        output.accept(ModItems.RUBI.get());

                        output.accept(ModItems.SAPPHIRE.get());

                        output.accept(Items.EMERALD);

                        output.accept(Items.DIAMOND);
                    }).build());
    public static final RegistryObject<CreativeModeTab> utility = Tabs.register(
            "utility", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab.utility"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ADOBE_FURNACE.get());
                        output.accept(ModBlocks.ADOBE_ALLOYING_FURNACE.get());
                        output.accept(ModBlocks.SUPER_ALLOYING_FURNACE.get());
                        output.accept(ModBlocks.SOUL_ALLOY_FURNACE.get());
                        output.accept(ModBlocks.GEM_POLISHER.get());
                        output.accept(ModBlocks.GRINDER.get());

                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModItems.SILVER_NUGGET.get());

                        output.accept((ModItems.COPPER_NUGGET.get()));

                        output.accept((ModItems.TIN_INGOT.get()));
                        output.accept((ModItems.TIN_NUGGET.get()));

                        output.accept(ModItems.ZINC_INGOT.get());
                        output.accept(ModItems.ZINC_NUGGET.get());

                        output.accept(ModItems.BRASS_INGOT.get());
                        output.accept(ModItems.BRASS_NUGGET.get());

                        output.accept(ModItems.BRONZE_INGOT.get());
                        output.accept(ModItems.BRONZE_NUGGET.get());

                        output.accept(ModItems.ROSE_GOLD_INGOT.get());
                        output.accept(ModItems.ROSE_GOLD_NUGGET.get());

                        output.accept(ModItems.STEEL_INGOT.get());

                        output.accept(ModItems.GREEN_GOLD_INGOT.get());
                        output.accept(ModItems.GREEN_GOLD_NUGGET.get());

                        output.accept(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> Tools = Tabs.register(
            "tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_PICKAXE.get()))
                    .title((Component.translatable("creativetab.tools")))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Silver
                        output.accept(ModItems.SILVER_PICKAXE.get());
                        output.accept(ModItems.SILVER_AXE.get());
                        output.accept(ModItems.SILVER_SHOVEL.get());
                        output.accept(ModItems.SILVER_HOE.get());
                        output.accept(ModItems.SILVER_POLISHER.get());
                        output.accept(ModItems.SILVER_POLISHER.get());

                        //Bronze
                        output.accept(ModItems.BRONZE_PICKAXE.get());
                        output.accept(ModItems.BRONZE_AXE.get());
                        output.accept(ModItems.BRONZE_SHOVEL.get());
                        output.accept(ModItems.BRONZE_HOE.get());
                        output.accept(ModItems.BRONZE_POLISHER.get());

                        //Brass
                        output.accept(ModItems.BRASS_PICKAXE.get());
                        output.accept(ModItems.BRASS_AXE.get());
                        output.accept(ModItems.BRASS_SHOVEL.get());
                        output.accept(ModItems.BRASS_HOE.get());
                        output.accept(ModItems.BRASS_POLISHER.get());

                        //Rose Gold
                        output.accept(ModItems.ROSE_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.ROSE_GOLDEN_AXE.get());
                        output.accept(ModItems.ROSE_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.ROSE_GOLDEN_HOE.get());
                        output.accept(ModItems.ROSE_GOLDEN_POLISHER.get());

                        //Steel
                        output.accept(ModItems.STEEL_PICKAXE.get());
                        output.accept(ModItems.STEEL_AXE.get());
                        output.accept(ModItems.STEEL_SHOVEL.get());
                        output.accept(ModItems.STEEL_HOE.get());
                        output.accept(ModItems.STEEL_POLISHER.get());
                        output.accept(ModItems.STEEL_POLISHER.get());

                        //Green Gold
                        output.accept(ModItems.GREEN_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.GREEN_GOLDEN_AXE.get());
                        output.accept(ModItems.GREEN_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.GREEN_GOLDEN_HOE.get());
                        output.accept(ModItems.GREEN_GOLDEN_POLISHER.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> weapons = Tabs.register(
            "weapons",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_SWORD.get()))
                    .title(Component.translatable("creativetab.weapons"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Silver
                        output.accept(ModItems.SILVER_SWORD.get());
                        output.accept(ModItems.SILVER_HELMET.get());
                        output.accept(ModItems.SILVER_CHESTPLATE.get());
                        output.accept(ModItems.SILVER_LEGGINGS.get());
                        output.accept(ModItems.SILVER_BOOTS.get());

                        //Bronze
                        output.accept(ModItems.BRONZE_SWORD.get());
                        output.accept(ModItems.BRONZE_HELMET.get());
                        output.accept(ModItems.BRONZE_CHESTPLATE.get());
                        output.accept(ModItems.BRONZE_LEGGINGS.get());
                        output.accept(ModItems.BRONZE_BOOTS.get());

                        //Brass
                        output.accept(ModItems.BRASS_SWORD.get());
                        output.accept(ModItems.BRASS_HELMET.get());
                        output.accept(ModItems.BRASS_CHESTPLATE.get());
                        output.accept(ModItems.BRASS_LEGGINGS.get());
                        output.accept(ModItems.BRASS_BOOTS.get());

                        //Rose gold
                        output.accept(ModItems.ROSE_GOLDEN_SWORD.get());
                        output.accept(ModItems.ROSE_GOLDEN_HELMET.get());
                        output.accept(ModItems.ROSE_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.ROSE_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.ROSE_GOLDEN_BOOTS.get());

                        //Steel
                        output.accept(ModItems.STEEL_SWORD.get());
                        output.accept(ModItems.STEEL_HELMET.get());
                        output.accept(ModItems.STEEL_CHESTPLATE.get());
                        output.accept(ModItems.STEEL_LEGGINGS.get());
                        output.accept(ModItems.STEEL_BOOTS.get());

                        //Green gold
                        output.accept(ModItems.GREEN_GOLDEN_SWORD.get());
                        output.accept(ModItems.GREEN_GOLDEN_HELMET.get());
                        output.accept(ModItems.GREEN_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.GREEN_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.GREEN_GOLDEN_BOOTS.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> jewelery = Tabs.register(
            "jewelery", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBI.get()))
                    .title(Component.translatable("creativetab.jewelery"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.GEM_POLISHER.get());
                        output.accept(ModItems.GOLD_POLISHER.get());
                        output.accept(ModItems.SILVER_POLISHER.get());
                        output.accept((ModItems.STONE_POLISHER.get()));
                        output.accept((ModItems.BRONZE_POLISHER.get()));
                        output.accept(ModItems.BRASS_POLISHER.get());
                        output.accept(ModItems.ROSE_GOLDEN_POLISHER.get());
                        output.accept(ModItems.IRON_POLISHER.get());
                        output.accept(ModItems.STEEL_POLISHER.get());
                        output.accept(ModItems.GREEN_GOLDEN_POLISHER.get());
                        output.accept(ModItems.DIAMOND_POLISHER.get());
                        output.accept(ModItems.NETHERITE_POLISHER.get());
                        output.accept(ModItems.RAW_RUBI.get());
                        output.accept(ModItems.RAW_SAPPHIRE.get());
                        output.accept(ModItems.RAW_EMERALD.get());
                        output.accept(ModItems.RAW_DIAMOND.get());
                        output.accept(ModItems.RUBI.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(Items.EMERALD);
                        output.accept(Items.DIAMOND);
                        output.accept(ModBlocks.RUBI_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBI_ORE.get());
                        output.accept(ModBlocks.SAPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPHIRE_ORE.get());
                        output.accept(net.minecraft.world.level.block.Blocks.EMERALD_ORE);
                        output.accept(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE);
                        output.accept(net.minecraft.world.level.block.Blocks.DIAMOND_ORE);
                        output.accept(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE);
                    }).build());
    public static final RegistryObject<CreativeModeTab> Food= Tabs.register(
            "fruits", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GREEN_APPLE.get()))
                    .title(Component.translatable("creativetab.fruits"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WALNUT.get());
                        output.accept(ModItems.PEELED_WALNUT.get());

                        output.accept(ModItems.GREEN_APPLE.get());

                        output.accept(ModItems.LEMON.get());

                        output.accept(ModItems.ORANGE.get());

                        output.accept(ModItems.YERBA_MATE.get());
                        output.accept(ModItems.GROUNDED_YERBA_MATE.get());
                        output.accept(ModItems.YERBA_MATE_SEEDS.get());

                        output.accept(ModItems.ZAPALLO.get());
                        output.accept(ModItems.COOKED_ZAPALLO.get());
                        output.accept(ModItems.ZAPALLO_SEEDS.get());

                        output.accept(ModItems.EGGPLANT.get());
                        output.accept(ModItems.COOKED_EGGPLANT.get());
                        output.accept(ModItems.EGGPLANT_SEEDS.get());

                        output.accept(ModItems.TOMATO.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());

                        output.accept(ModItems.CORN.get());
                        output.accept(ModItems.COOKED_CORN.get());
                        output.accept(ModItems.CORN_SEEDS.get());

                        output.accept(ModItems.WHEAT_FLOUR.get());

                        output.accept(ModItems.PUMPKIN_FLOUR.get());

                        output.accept(ModItems.YEAST.get());

                        output.accept(ModItems.EMPTY_MATE.get());
                        output.accept(ModItems.MATE.get());
                    }).build());
    public static void Register(IEventBus eventBus){
        Tabs.register(eventBus);
    }
}
