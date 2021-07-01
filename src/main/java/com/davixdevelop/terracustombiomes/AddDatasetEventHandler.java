package com.davixdevelop.terraimprovedbiomes;

import net.buildtheearth.terraplusplus.event.InitDatasetsEvent;
import net.buildtheearth.terraplusplus.event.InitEarthRegistryEvent;
import net.buildtheearth.terraplusplus.generator.biome.IEarthBiomeFilter;
import net.buildtheearth.terraplusplus.generator.data.IEarthDataBaker;
import net.buildtheearth.terraplusplus.generator.populate.IEarthPopulator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AddDatasetEventHandler {
    public static final String KEY_KOPPEN = "KEY_DAVIXDEVELOP_KOPPEN_DATASET";

    @SubscribeEvent
    public void datasets(InitDatasetsEvent event) {
      boolean addKoppen = true;
      try{
        if(event.get(KEY_KOPPEN) != null)
          addKoppen = false;
      }catch (Exception ex){ }
      if(addKoppen)
        event.register(KEY_KOPPEN, new KoppenClimate());
    }

    @SubscribeEvent
    public void biomes(InitEarthRegistryEvent<IEarthBiomeFilter> event){
        event.registry().addBefore("biome_overrides", "davixdevelop_custombiomes", new CustomBiomeFilter());
    }
}
