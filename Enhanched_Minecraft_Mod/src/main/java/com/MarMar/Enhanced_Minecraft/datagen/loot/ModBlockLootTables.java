package com.MarMar.Enhanced_Minecraft.datagen.loot;

import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
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
        this.add(ModBlocks.Tin_ore.get(),
                block -> createTinOreDrops(ModBlocks.Tin_ore.get()));
        this.add(ModBlocks.Deepslate_tin_ore.get(),
                block -> createTinOreDrops(ModBlocks.Deepslate_tin_ore.get()));

        this.add(ModBlocks.Sulfur_ore.get(),
                block -> createRedstoneOreDrops(ModBlocks.Sulfur_ore.get()));
        this.add(ModBlocks.Deepslate_sulfur_ore.get(),
                block -> createRedstoneOreDrops(ModBlocks.Deepslate_sulfur_ore.get()));
        this.add(ModBlocks.Nether_sulfur_ore.get(),
                block -> createRedstoneOreDrops(ModBlocks.Nether_sulfur_ore.get()));
    }
    protected LootTable.Builder createTinOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.Raw_tin.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));



    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.Blocks.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
