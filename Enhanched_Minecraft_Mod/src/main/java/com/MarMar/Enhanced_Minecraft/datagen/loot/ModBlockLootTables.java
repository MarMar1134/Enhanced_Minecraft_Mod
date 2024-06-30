package com.MarMar.Enhanced_Minecraft.datagen.loot;

import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
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
                block -> createTinOreDrops(ModBlocks.Tin_ore.get(), ModItems.Raw_tin.get()));
        this.add(ModBlocks.Deepslate_tin_ore.get(),
                block -> createTinOreDrops(ModBlocks.Deepslate_tin_ore.get(), ModItems.Raw_tin.get()));

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

        //Entity blocks
        this.dropSelf(ModBlocks.Adobe_alloying_furnace.get());
        this.dropSelf(ModBlocks.Reforging_table.get());
    }

    //Loot tables
    protected LootTable.Builder createTinOreDrops(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_tin.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
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
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Cobalt.get())
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
    protected LootTable.Builder createEmeraldOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_emerald.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.Blocks.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
