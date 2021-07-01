package com.davixdevelop.terraimprovedbiomes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TerraBiomeMod.MODID, name = TerraBiomeMod.NAME, version = TerraBiomeMod.VERSION, dependencies = "required-after:terraplusplus@[0.1.519,)")
public class TerraBiomeMod
{
    public static final String MODID = "terraimprovedbiomes";
    public static final String NAME = "Terra++: Improved Biomes addon";
    public static final String VERSION = "0.1";

    public static Logger LOGGER;



    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
    	MinecraftForge.TERRAIN_GEN_BUS.register(new AddDatasetEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
