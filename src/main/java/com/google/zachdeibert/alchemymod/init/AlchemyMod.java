package com.google.zachdeibert.alchemymod.init;

import com.google.zachdeibert.alchemymod.items.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=AlchemyMod.MODID,version=AlchemyMod.VERSION)
public class AlchemyMod {
    public static final String MODID = "AlchemyMod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent ev) {
        Configuration config = new Configuration(ev.getSuggestedConfigurationFile());
        config.load();
        Item.registerItems(config);
        config.save();
    }
}
