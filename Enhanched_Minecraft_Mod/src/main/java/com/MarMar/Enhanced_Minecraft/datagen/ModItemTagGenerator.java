package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.Util.ModTags;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Enhanced_Minecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.Bronze_tag).add(ModItems.Bronze_ingot.get())
                .add(ModItems.Bronze_sword.get()).add(ModItems.Bronze_pickaxe.get())
                .add(ModItems.Bronze_axe.get()).add(ModItems.Bronze_shovel.get())
                .add(ModItems.Bronze_hoe.get())
                .add(ModItems.Bronze_helmet.get()).add(ModItems.Bronze_chestplate.get())
                .add(ModItems.Bronze_leggings.get()).add(ModItems.Bronze_boots.get());

        this.tag(ModTags.Items.Steel_tag).add(ModItems.Steel_ingot.get())
                .add(ModItems.Steel_sword.get()).add(ModItems.Steel_pickaxe.get())
                .add(ModItems.Steel_axe.get()).add(ModItems.Steel_shovel.get())
                .add(ModItems.Steel_hoe.get()).add(ModItems.Steel_helmet.get()).add(ModItems.Steel_chestplate.get())
                .add(ModItems.Steel_leggings.get()).add(ModItems.Steel_boots.get());

        this.tag(ModTags.Items.Silver_tag).add(ModItems.Silver_ingot.get())
                .add(ModItems.Silver_sword.get()).add(ModItems.Silver_pickaxe.get())
                .add(ModItems.Silver_axe.get()).add(ModItems.Silver_shovel.get())
                .add(ModItems.Silver_hoe.get()).add(ModItems.Silver_helmet.get()).add(ModItems.Silver_chestplate.get())
                .add(ModItems.Silver_leggings.get()).add(ModItems.Silver_boots.get());

        this.tag(ModTags.Items.Rose_gold_tag)
                .add(ModItems.Rose_gold_ingot.get())
                .add(ModItems.Rose_golden_sword.get())
                .add(ModItems.Rose_golden_pickaxe.get())
                .add(ModItems.Rose_golden_axe.get())
                .add(ModItems.Rose_golden_shovel.get())
                .add(ModItems.Rose_golden_hoe.get())
                .add(ModItems.Rose_golden_helmet.get())
                .add(ModItems.Rose_golden_chestplate.get())
                .add(ModItems.Rose_golden_leggings.get())
                .add(ModItems.Rose_golden_boots.get());


        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.Bronze_helmet.get())
                .add(ModItems.Bronze_chestplate.get())
                .add(ModItems.Bronze_leggings.get())
                .add(ModItems.Bronze_boots.get())
                .add(ModItems.Steel_helmet.get())
                .add(ModItems.Steel_chestplate.get())
                .add(ModItems.Steel_leggings.get())
                .add(ModItems.Steel_boots.get())
                .add(ModItems.Silver_helmet.get())
                .add(ModItems.Silver_chestplate.get())
                .add(ModItems.Silver_leggings.get())
                .add(ModItems.Silver_boots.get())
                .add(ModItems.Rose_golden_helmet.get())
                .add(ModItems.Rose_golden_chestplate.get())
                .add(ModItems.Rose_golden_leggings.get())
                .add(ModItems.Rose_golden_boots.get())
                .add(ModItems.Reinforced_diamond_helmet.get())
                .add(ModItems.Reinforced_diamond_chestplate.get())
                .add(ModItems.Bronze_leggings.get())
                .add(ModItems.Reinforced_diamond_boots.get());

        this.tag(ModTags.Items.Gem_tag).add(ModItems.Raw_rubi.get())
                .add(ModItems.Raw_saphire.get())
                .add(ModItems.Raw_emerald.get())
                .add(ModItems.Raw_diamond.get())
                .add(ModItems.Rubi.get())
                .add(ModItems.Saphire.get())
                .add(Items.EMERALD)
                .add(Items.DIAMOND);

        this.tag(ModTags.Items.Polisher_tag).add(ModItems.Bronze_polisher.get())
                .add(ModItems.Gold_polisher.get())
                .add(ModItems.Steel_polisher.get())
                .add(ModItems.Iron_polisher.get())
                .add(ModItems.Diamond_polisher.get())
                .add(ModItems.Silver_polisher.get())
                .add(ModItems.Netherite_polisher.get());
    }
}
