package com.google.zachdeibert.alchemymod.items;

import com.google.zachdeibert.alchemymod.init.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public class ItemAlchemicCatalyst extends Item {
    
    public ItemAlchemicCatalyst() {
        super("alchemicCatalyst");
        setTextureName("catalyst");
    }
    
    private void addDecreasingRecipe(Object out, Object in) {
        ItemStack stack;
        if ( out instanceof net.minecraft.item.Item ) {
            stack = new ItemStack((net.minecraft.item.Item) out);
        } else {
            stack = new ItemStack(Item.getItemFromBlock((net.minecraft.block.Block) out));
        }
        GameRegistry.addRecipe(stack, in, in, in, in, in, in, in, in, Items.alchemicCatalyst);
    }
    
    private void addIncreasingRecipe(Object out, Object in) {
        ItemStack stack;
        if ( out instanceof net.minecraft.item.Item ) {
            stack = new ItemStack((net.minecraft.item.Item) out);
        } else {
            stack = new ItemStack(Item.getItemFromBlock((net.minecraft.block.Block) out));
        }
        stack.stackSize = 8;
        GameRegistry.addRecipe(stack, in, Items.alchemicCatalyst);
    }
    
    protected boolean load(Configuration config) {
        boolean metalAlchemy = config.getBoolean("allowMetalAlchemy", "metalAlchemy", true, "Allow Metal Alchemy");
        boolean craftIron = config.getBoolean("allowCraftingIron", "metalAlchemy", true, "Allow crafting iron from gold");
        boolean craftGold = config.getBoolean("allowCraftingGold", "metalAlchemy", true, "Allow crafting gold from iron");
        boolean craftBlocks = config.getBoolean("allowCraftingBlocks", "metalAlchemy", true, "Can blocks be used instead of only ingots?");
        if ( metalAlchemy ) {
            ItemStack alchemicCatalyst = new ItemStack(Items.alchemicCatalyst);
            GameRegistry.addRecipe(alchemicCatalyst,
                            "aba", "bcb", "aba",
                            'a', Items.redstone,
                            'b', Blocks.lapis_ore,
                            'c', Items.diamond);
            if ( craftIron ) {
                addDecreasingRecipe(Items.iron_ingot, Items.gold_ingot);
                if ( craftBlocks ) {
                    addDecreasingRecipe(Blocks.iron_block, Blocks.gold_block);
                }
            }
            if ( craftGold ) {
                addIncreasingRecipe(Items.gold_ingot, Items.iron_ingot);
                if ( craftBlocks ) {
                    addIncreasingRecipe(Blocks.gold_block, Blocks.iron_block);
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
