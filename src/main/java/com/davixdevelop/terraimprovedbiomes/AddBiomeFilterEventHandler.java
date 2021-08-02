package com.davixdevelop.terraimprovedbiomes;

import io.github.opencubicchunks.cubicchunks.api.worldgen.populator.event.DecorateCubeBiomeEvent;
import net.buildtheearth.terraplusplus.event.InitEarthRegistryEvent;
import net.buildtheearth.terraplusplus.generator.biome.IEarthBiomeFilter;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AddBiomeFilterEventHandler {
    public static final String KEY_KOPPEN = "KEY_DAVIXDEVELOP_KOPPEN_DATASET";

    @SubscribeEvent
    public void biomes(InitEarthRegistryEvent<IEarthBiomeFilter> event){
        event.registry().addBefore("biome_overrides", "davixdevelop_custombiomes", new CustomBiomeFilter());
    }

    @SubscribeEvent
    public void onDecorate(DecorateCubeBiomeEvent.Decorate event){
        DecorateBiomeEvent.Decorate.EventType type = event.getType();
        if(type == DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM || type == DecorateBiomeEvent.Decorate.EventType.SHROOM){
            event.setResult(Event.Result.DENY);
        }
    }
}
