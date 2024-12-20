package com.MarMar.Enhanced_Minecraft.loot;

import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.CornCropBlock;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.TomatoCropBlock;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.YerbaMateCropBlock;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.ZapalloCropBlock;
import com.MarMar.Enhanced_Minecraft.enchantment.ModEnchantments;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    protected static LootItemCondition.Builder HAS_FINE_MINING;
    @Override
    protected void generate() {
        //Polished stone
        this.dropSelf(ModBlocks.POLISHED_STONE.get());
        this.add(ModBlocks.POLISHED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_STONE_SLAB.get()));
        this.dropSelf(ModBlocks.POLISHED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_STONE_WALL.get());

        //Cobbled limestone
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE.get());
        this.add(ModBlocks.COBBLED_LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE_WALL.get());

        //Limestone
        this.add(ModBlocks.LIMESTONE.get(),
                block -> createLimestoneDrops(ModBlocks.LIMESTONE.get()));
        this.add(ModBlocks.LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.LIMESTONE_STAIRS.get());

        //Polished limestone
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE.get());
        this.add(ModBlocks.POLISHED_LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE_WALL.get());

        //Limestone bricks
        this.dropSelf(ModBlocks.LIMESTONE_BRICKS.get());
        this.add(ModBlocks.LIMESTONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIMESTONE_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.LIMESTONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.LIMESTONE_BRICK_WALL.get());

        //Soul
        this.dropSelf(ModBlocks.SOUL_MUD.get());
        this.dropSelf(ModBlocks.SOUL_MUD_BRICKS.get());
        this.add(ModBlocks.SOUL_MUD_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SOUL_MUD_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.SOUL_MUD_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.SOUL_MUD_BRICK_WALL.get());

        //wood
            //walnut
            this.dropSelf(ModBlocks.WALNUT_SAPLING.get());
            this.dropSelf(ModBlocks.WALNUT_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_WALNUT_LOG.get());
            this.dropSelf(ModBlocks.WALNUT_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_WALNUT_WOOD.get());

            this.add(ModBlocks.WALNUT_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.WALNUT_SAPLING.get(), ModItems.WALNUT.get(), 4f));

            this.dropSelf(ModBlocks.WALNUT_PLANKS.get());

            this.add(ModBlocks.WALNUT_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WALNUT_DOOR.get()));

            this.dropSelf(ModBlocks.WALNUT_TRAPDOOR.get());

            this.dropSelf(ModBlocks.WALNUT_BUTTON.get());

            this.dropSelf(ModBlocks.WALNUT_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.WALNUT_STAIRS.get());
            this.add(ModBlocks.WALNUT_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.WALNUT_SLAB.get()));
            this.dropSelf(ModBlocks.WALNUT_FENCE.get());
            this.dropSelf(ModBlocks.WALNUT_FENCEGATE.get());

            //Apple
            this.dropSelf(ModBlocks.APPLE_SAPLING.get());
            this.dropSelf(ModBlocks.GREEN_APPLE_SAPLING.get());
            this.dropSelf(ModBlocks.APPLE_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_APPLE_LOG.get());
            this.dropSelf(ModBlocks.APPLE_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_APPLE_WOOD.get());

            this.add(ModBlocks.APPLE_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.APPLE_SAPLING.get(), Items.APPLE));
            this.add(ModBlocks.GREEN_APPLE_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.GREEN_APPLE_SAPLING.get(), ModItems.GREEN_APPLE.get()));

            this.dropSelf(ModBlocks.APPLE_PLANKS.get());

            this.add(ModBlocks.APPLE_DOOR.get(),
                    block -> createDoorTable(ModBlocks.APPLE_DOOR.get()));

            this.dropSelf(ModBlocks.APPLE_TRAPDOOR.get());

            this.dropSelf(ModBlocks.APPLE_BUTTON.get());

            this.dropSelf(ModBlocks.APPLE_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.APPLE_STAIRS.get());
            this.add(ModBlocks.APPLE_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.APPLE_SLAB.get()));
            this.dropSelf(ModBlocks.APPLE_FENCE.get());
            this.dropSelf(ModBlocks.APPLE_FENCEGATE.get());

        //ores
        this.add(ModBlocks.NETHER_COPPER_ORE.get(),
                block -> createCopperOreDrops(ModBlocks.NETHER_COPPER_ORE.get()));

        this.add(ModBlocks.TIN_ORE.get(),
                block -> createTinOreDrops(ModBlocks.TIN_ORE.get()));
        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                block -> createTinOreDrops(ModBlocks.DEEPSLATE_TIN_ORE.get()));

        this.add(ModBlocks.ZINC_ORE.get(),
                block -> createZincOreDrops(ModBlocks.ZINC_ORE.get()));
        this.add(ModBlocks.DEEPSLATE_ZINC_ORE.get(),
                block -> createZincOreDrops(ModBlocks.DEEPSLATE_ZINC_ORE.get()));
        this.add(ModBlocks.NETHER_ZINC_ORE.get(),
                block -> createNetherZincOreDrops(ModBlocks.NETHER_ZINC_ORE.get()));

        this.add(ModBlocks.SULFUR_ORE.get(),
                block -> createSulfurOreDrops(ModBlocks.SULFUR_ORE.get()));
        this.add(ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                block -> createSulfurOreDrops(ModBlocks.DEEPSLATE_SULFUR_ORE.get()));
        this.add(ModBlocks.NETHER_SULFUR_ORE.get(),
                block -> createNetherSulfurOreDrops(ModBlocks.NETHER_SULFUR_ORE.get()));

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createSilverOreDrops(ModBlocks.SILVER_ORE.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createSilverOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get()));

        this.add(ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                block -> createCobaltOreDrops(ModBlocks.DEEPSLATE_COBALT_ORE.get()));

        this.add(ModBlocks.RUBI_ORE.get(),
                block -> createGemsDrops(ModBlocks.RUBI_ORE.get(), ModItems.RAW_RUBI.get(), 2, ModItems.RUBI.get(), 1));
        this.add(ModBlocks.DEEPSLATE_RUBI_ORE.get(),
                block -> createGemsDrops(ModBlocks.DEEPSLATE_RUBI_ORE.get(), ModItems.RAW_RUBI.get(), 3, ModItems.RUBI.get(), 2));

        this.add(ModBlocks.SAPHIRE_ORE.get(),
                block -> createGemsDrops(ModBlocks.SAPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get(), 4, ModItems.SAPPHIRE.get(), 2));
        this.add(ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(),
                block -> createGemsDrops(ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get(), 5, ModItems.SAPPHIRE.get(), 3));

        this.add(ModBlocks.NETHER_GARNET_ORE.get(),
                block -> createGemsDrops(ModBlocks.NETHER_GARNET_ORE.get(), ModItems.RAW_GARNET.get(), 3, ModItems.GARNET.get(), 2));

        //ore blocks
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
        this.dropSelf(ModBlocks.ZINC_BLOCK.get());
        this.dropSelf(ModBlocks.BRASS_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.ROSE_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZIUM_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.GREEN_GOLD_BLOCK.get());

        //Crops
            //Yerba mate
        LootItemCondition.Builder yerbaMateBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.YERBA_MATE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YerbaMateCropBlock.AGE, 4));

        this.add(ModBlocks.YERBA_MATE_CROP.get(), createCropDrops(ModBlocks.YERBA_MATE_CROP.get(), ModItems.YERBA_MATE.get(),
                ModItems.YERBA_MATE_SEEDS.get(), yerbaMateBuilder));

            //Zapallo
        LootItemCondition.Builder zapalloBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.ZAPALLO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 3));

        this.add(ModBlocks.ZAPALLO_CROP.get(), createCropDrops(ModBlocks.ZAPALLO_CROP.get(), ModItems.ZAPALLO.get(),
                ModItems.ZAPALLO_SEEDS.get(), zapalloBuilder));

            //Eggplant
        LootItemCondition.Builder eggplantBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.EGGPLANT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 5));

        this.add(ModBlocks.EGGPLANT_CROP.get(), createCropDrops(ModBlocks.EGGPLANT_CROP.get(), ModItems.EGGPLANT.get(),
                ModItems.EGGPLANT_SEEDS.get(), eggplantBuilder));

            //Tomato
        LootItemCondition.Builder tomatoBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));

        this.add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(),
                ModItems.TOMATO_SEEDS.get(), tomatoBuilder));

            //Corn
         LootItemCondition.Builder cornBuilder = LootItemBlockStatePropertyCondition
                 .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                 .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7));

         this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
                 ModItems.CORN_SEEDS.get(), cornBuilder));

         //Entity blocks
        this.dropSelf(ModBlocks.ADOBE_FURNACE.get());
        this.dropSelf(ModBlocks.SOUL_FURNACE.get());

        this.dropSelf(ModBlocks.ADOBE_ALLOYING_FURNACE.get());
        this.dropSelf(ModBlocks.SUPER_ALLOYING_FURNACE.get());
        this.dropSelf(ModBlocks.SOUL_ALLOY_FURNACE.get());

        this.dropSelf(ModBlocks.GEM_POLISHER.get());
        this.dropSelf(ModBlocks.GRINDER.get());
    }

    //Loot table creators
    /**
     *
     * @param leavesBlock references the block that will have the specified loot table.
     * @param saplingBlock references the sapling block that will drop the leave block.
     * @param secondLoot references the second loot that will drop the leave block. by default, the max drop for this method is 2.
     *@return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createLeaveWithFruitDrop(Block leavesBlock, Block saplingBlock, Item secondLoot){
        return createLeavesDrops(leavesBlock, saplingBlock, 0.05f)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(secondLoot))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0F, 2F)))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.087F)
                )));
    }

    /**
     *
     * @param leavesBlock references the block that will have the specified loot table.
     * @param saplingBlock references the sapling block that will drop the leave block.
     * @param secondLoot references the second loot that will drop the leave block.
     *                  You have to define the max quantity of items dropped in the {@code dropsPerLeave} parameter.
     * @param dropsPerLeave defines the max quantity of items dropped by the block.
     *@return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createLeaveWithFruitDrop(Block leavesBlock, Block saplingBlock, Item secondLoot, float dropsPerLeave){
        return createLeavesDrops(leavesBlock, saplingBlock, 0.05f)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(secondLoot))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0F, dropsPerLeave)))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.087F)
                )));
    }


    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createCopperOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(Items.RAW_COPPER)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createTinOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.RAW_TIN.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createZincOreDrops(Block pBlock){
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.RAW_ZINC.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createNetherZincOreDrops(Block pBlock){
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.RAW_ZINC.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 7.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createSulfurOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.SULFUR.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createNetherSulfurOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.SULFUR.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 9.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createSilverOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.RAW_SILVER.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,1))))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createCobaltOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.COBALT.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table
     * @param rawGem references the raw gem that will be dropped if the pickaxe doesn´t have Fine Mining
     * @param maxRawGems references the max quantity of raw gems that have the chance to be dropped
     * @param gem references the gem that will be dropped if the pickaxe has Fine Mining
     * @param maxGems references the max quantity of gems that have the chance to be dropped
     * @return the loot table JSON file with the given conditions
     */
    protected LootTable.Builder createGemsDrops(Block pBlock, ItemLike rawGem, int maxRawGems, ItemLike gem, int maxGems){
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(rawGem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, maxRawGems))))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))

                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(gem))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, maxGems)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                        .when(HAS_FINE_MINING));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createLimestoneDrops(Block pBlock){
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModBlocks.COBBLED_LIMESTONE.get())
                 .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    static {
        HAS_FINE_MINING = MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(ModEnchantments.FINE_MINING.get(), MinMaxBounds.Ints.atLeast(1))));
    }
}
