package com.google.zachdeibert.alchemymod.items;

import java.lang.reflect.Field;
import net.minecraftforge.common.config.Configuration;
import com.google.zachdeibert.alchemymod.creativetab.CreativeTabs;
import com.google.zachdeibert.alchemymod.init.AlchemyMod;
import com.google.zachdeibert.alchemymod.init.Items;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class Item extends net.minecraft.item.Item {
    protected abstract boolean load(Configuration config);
    
    public Item(String name) {
        super();
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.tabAlchemy);
    }
    
    public static void registerItems(Configuration config) {
        for ( Field field : Items.class.getDeclaredFields() ) {
            try {
                Item item = (Item) field.get(null);
                if ( item.load(config) ) {
                    GameRegistry.registerItem(item, item.getUnlocalizedName(), AlchemyMod.MODID);
                }
            } catch ( Exception ex ) {
                
            }
        }
    }
}
