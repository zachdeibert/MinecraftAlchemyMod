package com.google.zachdeibert.alchemymod.creativetab;

import com.google.zachdeibert.alchemymod.init.Items;
import net.minecraft.item.Item;

public class CreativeTabs extends net.minecraft.creativetab.CreativeTabs {
    public static final CreativeTabs tabAlchemy = new CreativeTabs();
    
    protected CreativeTabs() {
        super("Alchemy");
    }

    @Override
    public Item getTabIconItem() {
        return Items.alchemicCatalyst;
    }
}
