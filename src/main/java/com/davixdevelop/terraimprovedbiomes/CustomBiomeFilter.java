package com.davixdevelop.terraimprovedbiomes;

import net.buildtheearth.terraplusplus.dataset.IScalarDataset;
import net.buildtheearth.terraplusplus.generator.ChunkBiomesBuilder;
import net.buildtheearth.terraplusplus.generator.GeneratorDatasets;
import net.buildtheearth.terraplusplus.generator.biome.IEarthBiomeFilter;
import net.buildtheearth.terraplusplus.generator.biome.Terra121BiomeFilter;
import net.buildtheearth.terraplusplus.projection.OutOfProjectionBoundsException;
import net.buildtheearth.terraplusplus.util.CornerBoundingBox2d;
import net.buildtheearth.terraplusplus.util.bvh.Bounds2d;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class CustomBiomeFilter implements IEarthBiomeFilter<double[]> {

    @Override
    public CompletableFuture<double[]> requestData(ChunkPos pos, GeneratorDatasets datasets, Bounds2d bounds, CornerBoundingBox2d boundsGeo) throws OutOfProjectionBoundsException {
        return datasets.<IScalarDataset>getCustom(AddBiomeFilterEventHandler.KEY_KOPPEN).getAsync(boundsGeo, 16, 16);
    }

    @Override
    public void bake(ChunkPos pos, ChunkBiomesBuilder builder, double[] data) {
        Biome[] biomes = builder.state();

        if(data == null){
            Arrays.fill(biomes, Biomes.OCEAN);
            return;
        }

        for(int c = 0; c < 16 * 16; c++){
            biomes[c] = koppenToBiome(data[c]);
        }
    }

    private Biome koppenToBiome(double koppen){
        switch ((int)koppen){
            case 0:
                return Biomes.OCEAN;
            case 1: //Af - jungle
                return Biomes.JUNGLE;
            case 2: //Am - bamboo_jungle (1.13) #ToDo Change to bamboo_jungle in future update to MC 1.17
                return Biomes.JUNGLE;
            case 3: //Aw - jungle_edge
                return Biomes.JUNGLE_EDGE;
            case 4: //BWh - desert
                return Biomes.DESERT;
            case 5: //BWk - desert_hills
                return Biomes.DESERT_HILLS;
            case 6: //BSh - savanna
                return Biomes.SAVANNA;
            case 7: //BSk - desert_lakes #ToDo Change to desert_lakes in future update to MC 1.17
                return Biomes.DESERT;
            case 8: //Csa - plains
                return Biomes.PLAINS;
            case 9: //Csb - sunflower_plains
                return Biomes.MUTATED_PLAINS;
            case 10: //Csc
                return Biomes.BEACH;
            case 11: //Cwa -  modified_jungle_edge
                return Biomes.MUTATED_JUNGLE_EDGE;
            case 12: //Cwb - jungle_hills
                return Biomes.JUNGLE_HILLS;
            case 13: //Cwc - gravelly_mountains
                return Biomes.MUTATED_EXTREME_HILLS;
            case 14: //Cfa - flower_forest
                return Biomes.MUTATED_FOREST;
            case 15: //Cfb - flower_forest
                return Biomes.MUTATED_FOREST;
            case 16: //Cfc - mountains
                return Biomes.EXTREME_HILLS;
            case 17: //Dsa - savanna_plateau
                return Biomes.SAVANNA_PLATEAU;
            case 18: //Dsb - wooded_badlands_plateau
                return Biomes.MESA_ROCK;
            case 19: //Dsc - snowy_taiga
                return Biomes.COLD_TAIGA;
            case 20: //Dsd - giant_spruce_taiga_hills
                return Biomes.MUTATED_REDWOOD_TAIGA_HILLS;
            case 21: //Dwa - swamp
                return Biomes.SWAMPLAND;
            case 22: //Dwb - swampland_hills
                return Biomes.MUTATED_SWAMPLAND;
            case 23: //Dwc - giant_tree_taiga
                return Biomes.REDWOOD_TAIGA;
            case 24: //Dwd - giant_spruce_taiga
                return Biomes.MUTATED_REDWOOD_TAIGA;
            case 25: //Dfa - forest
                return Biomes.FOREST;
            case 26: //Dfb - dark_forest
                return Biomes.ROOFED_FOREST;
            case 27: //Dfc - taiga
                return Biomes.TAIGA;
            case 28: //Dfd - snowy_mountains
                return Biomes.ICE_MOUNTAINS;
            case 29: //ET - snowy_tundra
                return Biomes.ICE_PLAINS;
            case 30: //EF - ice_spikes
                return Biomes.MUTATED_ICE_FLATS;
        }

        return Biomes.PLAINS;
    }
}
