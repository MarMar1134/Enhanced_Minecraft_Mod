package com.MarMar.Enhanced_Minecraft.event;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Enhanced_Minecraft.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void trades(VillagerTradesEvent event){
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
                    new ItemStack(ModItems.Bronze_helmet.get(), 1),
                    8, 1, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ModItems.Bronze_chestplate.get(), 1),
                    8, 1, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.Bronze_leggings.get(), 1),
                    8, 1, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.Bronze_boots.get(), 1),
                    8, 1, 0.2f));


            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.Saphire.get(), 1),
                    12, 10, 0.02f));
                //Iron
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.Saphire.get(), 2),
                    new ItemStack(Items.IRON_HELMET, 1),
                    6, 12, 0.4f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ModItems.Saphire.get(), 5),
                    new ItemStack(Items.IRON_CHESTPLATE, 1),
                    6, 12, 0.4f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.Saphire.get(), 3),
                    new ItemStack(Items.IRON_LEGGINGS, 1),
                    6, 12, 0.4f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.Saphire.get(), 2),
                    new ItemStack(Items.IRON_BOOTS, 1),
                    6, 12, 0.4f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 6),
                    new ItemStack(ModItems.Rubi.get(), 1),
                    12, 20, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 5),
                    new ItemStack(ModItems.Steel_helmet.get(), 1),
                    4, 8, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 9),
                    new ItemStack(ModItems.Steel_chestplate.get(), 1),
                    4, 8, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 7),
                    new ItemStack(ModItems.Steel_leggings.get(), 1),
                    4, 8, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 4),
                    new ItemStack(ModItems.Steel_boots.get(), 1),
                    4, 8, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 14),
                    new ItemStack(Items.DIAMOND_LEGGINGS, 1),
                    2, 16, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 12),
                    new ItemStack(Items.DIAMOND_BOOTS, 1),
                    2, 16, 0.2f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 16),
                    new ItemStack(Items.DIAMOND_HELMET, 1),
                    2, 34, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 18),
                    new ItemStack(Items.DIAMOND_CHESTPLATE, 1),
                    2, 34, 0.2f));
        }
        if(event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(3).removeAll(trades.get(3));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.Saphire.get(), 1),
                    12, 15, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Bronze_ingot.get(), 7),
                    new ItemStack(Items.EMERALD, 1),
                    12, 8, 0.02f));
                //Bronze
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ModItems.Bronze_axe.get(), 1),
                    3, 10, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 11),
                    new ItemStack(ModItems.Bronze_pickaxe.get(), 1),
                    3, 10, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.Bronze_shovel.get(), 1),
                    3, 10, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.Bronze_hoe.get(), 1),
                    3, 10, 0.2f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.FLINT, 30),
                    new ItemStack(Items.EMERALD, 1),
                    12, 20, 0.02f));
                //Iron
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.Saphire.get(), 3),
                    new ItemStack(Items.IRON_AXE, 1),
                    4, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.Saphire.get(), 4),
                    new ItemStack(Items.IRON_PICKAXE, 1),
                    4, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(Items.IRON_SHOVEL, 5),
                    new ItemStack(ModItems.Saphire.get(), 2),
                    4, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.Saphire.get(), 2),
                    new ItemStack(Items.IRON_HOE, 1),
                    4, 10, 0.2f));
                //Steel
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 6),
                    new ItemStack(ModItems.Steel_axe.get(), 1),
                    5, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 8),
                    new ItemStack(ModItems.Steel_pickaxe.get(), 1),
                    5, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 7),
                    new ItemStack(ModItems.Steel_shovel.get(), 1),
                    5, 10, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 4),
                    new ItemStack(ModItems.Steel_hoe.get(), 1),
                    5, 10, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Steel_ingot.get(), 6),
                    new ItemStack(ModItems.Saphire.get(), 1),
                    12, 8, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 7),
                    new ItemStack(ModItems.Rubi.get(), 1),
                    12, 30, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 9),
                    new ItemStack(Items.DIAMOND_AXE, 1),
                    2, 15, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 7),
                    new ItemStack(Items.DIAMOND_SHOVEL, 1),
                    2, 15, 0.2f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 16),
                    new ItemStack(Items.DIAMOND, 1),
                    12, 45, 0.02f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 12),
                    new ItemStack(Items.DIAMOND_PICKAXE, 1),
                    2, 15, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 6),
                    new ItemStack(Items.DIAMOND_HOE, 1),
                    2, 15, 0.2f));
        }
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
                    new ItemStack(ModItems.Bronze_axe.get(), 1),
                    6, 2, 0.2f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.Bronze_sword.get(), 1),
                    6, 2, 0.2f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 2),
                    new ItemStack(Items.COAL, 32),
                    12, 8, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Bronze_ingot.get(), 5),
                    new ItemStack(Items.EMERALD, 1),
                    12, 8, 0.02f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.Saphire.get(), 3),
                    new ItemStack(Items.IRON_AXE, 1),
                    4, 6, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.Saphire.get(), 4),
                    new ItemStack(Items.IRON_SWORD, 1),
                    4, 6, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 8),
                    new ItemStack(ModItems.Rubi.get(), 1),
                    12, 8, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 22),
                    new ItemStack(ModItems.Rubi.get(), 1),
                    12, 8, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 5),
                    new ItemStack(ModItems.Steel_axe.get(), 1),
                    4, 9, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Saphire.get(), 8),
                    new ItemStack( ModItems.Steel_sword.get(), 1),
                    4, 9, 0.2f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 5),
                    new ItemStack(Items.DIAMOND_AXE, 1),
                    2, 9, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Rubi.get(), 8),
                    new ItemStack(Items.DIAMOND_SWORD, 1),
                    2, 9, 0.2f));
        }
    }
}