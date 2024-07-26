package com.MarMar.Enhanced_Minecraft.loot;

import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.block.crops.CornCropBlock;
import com.MarMar.Enhanced_Minecraft.block.crops.TomatoCropBlock;
import com.MarMar.Enhanced_Minecraft.block.crops.YerbaMateCropBlock;
import com.MarMar.Enhanced_Minecraft.block.crops.ZapalloCropBlock;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        //ores
        this.add(ModBlocks.Tin_ore.get(),
                block -> createTinOreDrops(ModBlocks.Tin_ore.get()));
        this.add(ModBlocks.Deepslate_tin_ore.get(),
                block -> createTinOreDrops(ModBlocks.Deepslate_tin_ore.get()));

        this.add(ModBlocks.Sulfur_ore.get(),
                block -> createSulfurOreDrops(ModBlocks.Sulfur_ore.get()));
        this.add(ModBlocks.Deepslate_sulfur_ore.get(),
                block -> createSulfurOreDrops(ModBlocks.Deepslate_sulfur_ore.get()));
        this.add(ModBlocks.Nether_sulfur_ore.get(),
                block -> createSulfurOreDrops(ModBlocks.Nether_sulfur_ore.get()));

        this.add(ModBlocks.Silver_ore.get(),
                block -> createSilverOreDrops(ModBlocks.Silver_ore.get()));
        this.add(ModBlocks.Deepslate_silver_ore.get(),
                block -> createSilverOreDrops(ModBlocks.Deepslate_silver_ore.get()));

        this.add(ModBlocks.Deepslate_cobalt_ore.get(),
                block -> createCobaltOreDrops(ModBlocks.Deepslate_cobalt_ore.get()));

        this.add(ModBlocks.Rubi_ore.get(), block -> createRubiOreDrops(ModBlocks.Rubi_ore.get()));
        this.add(ModBlocks.Deepslate_rubi_ore.get(), block -> createRubiOreDrops(ModBlocks.Deepslate_rubi_ore.get()));

        this.add(ModBlocks.Saphire_ore.get(), block -> createSaphireOreDrops(ModBlocks.Saphire_ore.get()));
        this.add(ModBlocks.Deepslate_saphire_ore.get(), block -> createSaphireOreDrops(ModBlocks.Deepslate_saphire_ore.get()));

        //Crops
            //Yerba mate
        LootItemCondition.Builder yerbaMateBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.Yerba_mate_crop.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YerbaMateCropBlock.AGE, 4));

        this.add(ModBlocks.Yerba_mate_crop.get(), createCropDrops(ModBlocks.Yerba_mate_crop.get(), ModItems.Yerba_mate.get(),
                ModItems.Yerba_mate_seeds.get(), yerbaMateBuilder));

            //Zapallo
        LootItemCondition.Builder zapalloBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.Zapallo_crop.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 3));

        this.add(ModBlocks.Zapallo_crop.get(), createCropDrops(ModBlocks.Zapallo_crop.get(), ModItems.Zapallo.get(),
                ModItems.Zapallo_seeds.get(), zapalloBuilder));

            //Eggplant
        LootItemCondition.Builder eggplantBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.Eggplant_crop.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 5));

        this.add(ModBlocks.Eggplant_crop.get(), createCropDrops(ModBlocks.Eggplant_crop.get(), ModItems.Eggplant.get(),
                ModItems.Eggplant_seeds.get(), eggplantBuilder));

            //Tomato
        LootItemCondition.Builder tomatoBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.Tomato_crop.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));

        this.add(ModBlocks.Tomato_crop.get(), createCropDrops(ModBlocks.Tomato_crop.get(), ModItems.Tomato.get(),
                ModItems.Tomato_seeds.get(), tomatoBuilder));

            //Corn
         LootItemCondition.Builder cornBuilder = LootItemBlockStatePropertyCondition
                 .hasBlockStateProperties(ModBlocks.Corn_crop.get())
                 .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7));

         this.add(ModBlocks.Corn_crop.get(), createCropDrops(ModBlocks.Corn_crop.get(), ModItems.Corn.get(),
                 ModItems.Corn_seeds.get(), cornBuilder));

         //Entity blocks
        this.dropSelf(ModBlocks.Adobe_alloying_furnace.get());
        this.dropSelf(ModBlocks.Super_alloying_furnace.get());
        this.dropSelf(ModBlocks.Gem_polisher_block.get());
    }

    //Loot table creators
    protected LootTable.Builder createTinOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_tin.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));

    }
    protected LootTable.Builder createSulfurOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Sulfur.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 8.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected LootTable.Builder createSilverOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_silver.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,1))))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }

    protected LootTable.Builder createCobaltOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Cobalt.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }
    protected LootTable.Builder createRubiOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_rubi.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }
    protected LootTable.Builder createSaphireOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_saphire.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,4))))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.Blocks.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
