package com.marmar.enhanced_playthrough.event;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.item.ModItems;
import com.marmar.enhanced_playthrough.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void trades(VillagerTradesEvent event){
        //Farmer
        if (event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.ZAPALLO_SEEDS.get(), 6),
                    16, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.CORN_SEEDS.get(), 3),
                    16, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.EGGPLANT_SEEDS.get(), 6),
                    16, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.TOMATO_SEEDS.get(), 4),
                    16, 2, 0.02f));
            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.ZAPALLO.get(), 20),
                    new ItemStack(Items.EMERALD, 1),
                    16, 4, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EGGPLANT.get(), 15),
                    new ItemStack(Items.EMERALD, 1),
                    16, 4, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.TOMATO.get(), 22),
                    new ItemStack(Items.EMERALD, 1),
                    16, 4, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.CORN.get(), 14),
                    new ItemStack(Items.EMERALD, 1),
                    16, 4, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.YERBA_MATE.get(), 24),
                    new ItemStack(Items.EMERALD, 1),
                    16, 4, 0.02f));

        }

        //Armorer
        if (event.getType() == VillagerProfession.ARMORER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(1).removeAll(trades.get(1));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));


            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.COAL, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.02f));
                //Bronze
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.BRONZE_HELMET.get(), 1),
                    8, 1, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ModItems.BRONZE_CHESTPLATE.get(), 1),
                    8, 1, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.BRONZE_LEGGINGS.get(), 1),
                    8, 1, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.BRONZE_BOOTS.get(), 1),
                    8, 1, 0.2f));


            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.SAPPHIRE.get(), 1),
                    12, 10, 0.02f));
                //Iron
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    new ItemStack(Items.IRON_HELMET, 1),
                    6, 12, 0.4f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ModItems.SAPPHIRE.get(), 5),
                    new ItemStack(Items.IRON_CHESTPLATE, 1),
                    6, 12, 0.4f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.SAPPHIRE.get(), 3),
                    new ItemStack(Items.IRON_LEGGINGS, 1),
                    6, 12, 0.4f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    new ItemStack(Items.IRON_BOOTS, 1),
                    6, 12, 0.4f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 6),
                    new ItemStack(ModItems.RUBI.get(), 1),
                    12, 20, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 5),
                    new ItemStack(ModItems.STEEL_HELMET.get(), 1),
                    4, 8, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 9),
                    new ItemStack(ModItems.STEEL_CHESTPLATE.get(), 1),
                    4, 8, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 7),
                    new ItemStack(ModItems.STEEL_LEGGINGS.get(), 1),
                    4, 8, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 4),
                    new ItemStack(ModItems.STEEL_BOOTS.get(), 1),
                    4, 8, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 14),
                    new ItemStack(Items.DIAMOND_LEGGINGS, 1),
                    2, 16, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 12),
                    new ItemStack(Items.DIAMOND_BOOTS, 1),
                    2, 16, 0.2f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 16),
                    new ItemStack(Items.DIAMOND_HELMET, 1),
                    2, 34, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 18),
                    new ItemStack(Items.DIAMOND_CHESTPLATE, 1),
                    2, 34, 0.2f));
        }

        //Toolsmith
        if(event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(3).removeAll(trades.get(3));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.SAPPHIRE.get(), 1),
                    12, 15, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BRONZE_INGOT.get(), 7),
                    new ItemStack(Items.EMERALD, 1),
                    12, 8, 0.02f));
                //Bronze
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ModItems.BRONZE_AXE.get(), 1),
                    3, 10, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 11),
                    new ItemStack(ModItems.BRONZE_PICKAXE.get(), 1),
                    3, 10, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.BRONZE_SHOVEL.get(), 1),
                    3, 10, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.BRONZE_HOE.get(), 1),
                    3, 10, 0.2f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.FLINT, 30),
                    new ItemStack(Items.EMERALD, 1),
                    12, 20, 0.02f));
                //Iron
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.SAPPHIRE.get(), 3),
                    new ItemStack(Items.IRON_AXE, 1),
                    4, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.SAPPHIRE.get(), 4),
                    new ItemStack(Items.IRON_PICKAXE, 1),
                    4, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.SAPPHIRE.get(), 5),
                    new ItemStack(Items.IRON_SHOVEL, 1),
                    4, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    new ItemStack(Items.IRON_HOE, 1),
                    4, 10, 0.2f));
                //Steel
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 6),
                    new ItemStack(ModItems.STEEL_AXE.get(), 1),
                    5, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 8),
                    new ItemStack(ModItems.STEEL_PICKAXE.get(), 1),
                    5, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 7),
                    new ItemStack(ModItems.STEEL_SHOVEL.get(), 1),
                    5, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 4),
                    new ItemStack(ModItems.STEEL_HOE.get(), 1),
                    5, 10, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.STEEL_INGOT.get(), 6),
                    new ItemStack(ModItems.SAPPHIRE.get(), 1),
                    12, 8, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 7),
                    new ItemStack(ModItems.RUBI.get(), 1),
                    12, 30, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 9),
                    new ItemStack(Items.DIAMOND_AXE, 1),
                    2, 15, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 7),
                    new ItemStack(Items.DIAMOND_SHOVEL, 1),
                    2, 15, 0.2f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 16),
                    new ItemStack(Items.DIAMOND, 1),
                    12, 45, 0.02f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 12),
                    new ItemStack(Items.DIAMOND_PICKAXE, 1),
                    2, 15, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 6),
                    new ItemStack(Items.DIAMOND_HOE, 1),
                    2, 15, 0.2f));
        }

        //Weaponsmith
        if (event.getType() == VillagerProfession.WEAPONSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(1).removeAll(trades.get(1));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.COAL, 15),
                    new ItemStack(Items.EMERALD, 1),
                    16, 1, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.BRONZE_AXE.get(), 1),
                    6, 2, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.BRONZE_SWORD.get(), 1),
                    6, 2, 0.2f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    new ItemStack(Items.COAL, 32),
                    12, 8, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BRONZE_INGOT.get(), 5),
                    new ItemStack(Items.EMERALD, 1),
                    12, 8, 0.02f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.SAPPHIRE.get(), 3),
                    new ItemStack(Items.IRON_AXE, 1),
                    4, 6, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.SAPPHIRE.get(), 4),
                    new ItemStack(Items.IRON_SWORD, 1),
                    4, 6, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 5),
                    new ItemStack(ModItems.STEEL_AXE.get(), 1),
                    4, 9, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 8),
                    new ItemStack( ModItems.STEEL_SWORD.get(), 1),
                    4, 9, 0.2f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GARNET.get(), 3),
                    new ItemStack(ModItems.BRONZIUM_SWORD.get(), 1),
                    10, 10, 0.2f
            ));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 5),
                    new ItemStack(Items.DIAMOND_AXE, 1),
                    2, 9, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 8),
                    new ItemStack(Items.DIAMOND_SWORD, 1),
                    2, 9, 0.2f));
        }

        //Cleric
        if (event.getType() == VillagerProfession.CLERIC){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GARNET.get(), 6),
                    new ItemStack(Items.BLAZE_ROD, 2),
                    6, 15, 0.1f));
        }

        //Jeweler
        if (event.getType() == ModVillagers.JEWELER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                 new ItemStack(Items.EMERALD, 7),
                 new ItemStack(ModItems.STONE_POLISHER.get(), 1),
                 12, 2, 0.05f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
               new ItemStack(ModItems.RAW_EMERALD.get(), 3),
               new ItemStack(Items.COBBLESTONE, 2),
               new ItemStack(Items.EMERALD, 6),
               12, 3, 0.03f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.STONE_POLISHER.get(), 1),
                    new ItemStack(Items.EMERALD, 5),
                    6, 3, 0.08f
            ));


            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.BRONZE_POLISHER.get(), 1),
                    6, 4, 0.05f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BRONZE_POLISHER.get(), 1),
                    new ItemStack(Items.EMERALD, 8),
                    10, 5, 0.04f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RAW_SAPPHIRE.get(), 3),
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.SAPPHIRE.get(), 6),
                    12, 5, 0.05f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.SAPPHIRE.get(), 1),
                    12, 4, 0.04f
            ));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.RUBI.get(), 1),
                    12, 8, 0.05f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 4),
                    new ItemStack(ModItems.RUBI.get(), 1),
                    12, 8, 0.06f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RAW_RUBI.get(), 3),
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    new ItemStack(ModItems.RUBI.get(), 6),
                    12, 10, 0.05f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 5),
                    new ItemStack(ModItems.IRON_POLISHER.get(), 1),
                    6, 10, 0.06f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_POLISHER.get(), 1),
                    new ItemStack(ModItems.SAPPHIRE.get(), 3),
                    12, 10, 0.04f
            ));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RAW_GARNET.get(), 4),
                    new ItemStack(ModItems.RUBI.get(), 2),
                    new ItemStack(ModItems.GARNET.get(), 8),
                    12, 12, 0.04f
            ));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 4),
                    new ItemStack(ModItems.STEEL_POLISHER.get(), 1),
                    6, 12, 0.06f
            ));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.STEEL_POLISHER.get(), 1),
                    new ItemStack(ModItems.RUBI.get(), 3),
                    12, 15, 0.06f
            ));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RAW_DIAMOND.get(), 2),
                    new ItemStack(ModItems.RUBI.get(), 2),
                    new ItemStack(Items.DIAMOND, 4),
            6, 12, 0.06f
            ));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 4),
                    new ItemStack(Items.DIAMOND, 1),
                    6, 15, 0.05f
            ));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBI.get(), 4),
                    new ItemStack(ModItems.DIAMOND_POLISHER.get(), 1),
                    6, 12, 0.04f
            ));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.DIAMOND_POLISHER.get(), 1),
                    new ItemStack(ModItems.RUBI.get(), 2),
                    6, 12, 0.05f
            ));
        }
    }

    @SubscribeEvent
    public static void wandererTrades (WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 16),
                new ItemStack(ModBlocks.GREEN_APPLE_SAPLING.get(), 1),
                3, 2, 0.2f));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 7),
                new ItemStack(ModBlocks.APPLE_SAPLING.get(), 1),
                3, 2, 0.2f));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(ModBlocks.WALNUT_SAPLING.get(), 1),
                3, 2, 0.2f));
    }
}