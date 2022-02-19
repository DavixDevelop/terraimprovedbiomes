package com.davixdevelop.terraimprovedbiomes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TerraBiomeMod.MODID,
  dependencies = "required-after:terracommondatasets@[0.2,);required-after:terraplusplus@[0.1.627,)",
  acceptableRemoteVersions = "*",
  useMetadata = true)
public class TerraBiomeMod
{
    public static final String MODID = "terraimprovedbiomes";

    public static Logger LOGGER;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
    	MinecraftForge.TERRAIN_GEN_BUS.register(new AddBiomeFilterEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
