package com.dottyvinnie.portmod.world.gen;

import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dotty on 11-Mar-17.
 */
public class WorldGeneratorPM implements IWorldGenerator
{
    private final List<WorldGenMinable> generators = new LinkedList<WorldGenMinable>();

    public WorldGeneratorPM()
    {
        generators.add(new WorldGenMinable(ModBlocks.stone, 1, ConfigurationHandler.maxClusterSize, Blocks.stone));
        generators.add(new WorldGenMinable(ModBlocks.stone, 3, ConfigurationHandler.maxClusterSize, Blocks.stone));
        generators.add(new WorldGenMinable(ModBlocks.stone, 5, ConfigurationHandler.maxClusterSize, Blocks.stone));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        int x = chunkX * 16;
        int z = chunkZ * 16;
        switch(world.provider.dimensionId){
            case 0:
                generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;
            case -1:
                generateNether(world, x, z, random);
                break;
            case 1:
                generateEnd(world, x, z, random);
                break;
            default:
                generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateEnd(World world, int x, int z, Random random)
    {

    }

    private void generateNether(World world, int x, int z, Random random)
    {

    }


    private void generateSurface(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (ConfigurationHandler.enableCoarseDirt && world.provider.dimensionId != -1 && world.provider.dimensionId != 1)
            for (int x = chunkX * 16; x < chunkX * 16 + 16; x++)
                for (int z = chunkZ * 16; z < chunkZ * 16 + 16; z++)
                    for (int y = 0; y < world.getActualHeight(); y++)
                        if (world.getBlock(x, y, z) == Blocks.dirt && world.getBlockMetadata(x, y, z) == 1)
                            world.setBlock(x, y, z, ModBlocks.coarse_dirt, 0, 2);

        if (ConfigurationHandler.enableNewStone && ConfigurationHandler.maxClusterSize > 0 && world.provider.dimensionId != -1 && world.provider.dimensionId != 1)
            for (Iterator<WorldGenMinable> iterator = generators.iterator(); iterator.hasNext(); )
            {
                WorldGenMinable generator = iterator.next();
                for (int i = 0; i < 10; i++)
                {
                    int x = chunkX * 16 + rand.nextInt(16);
                    int y = rand.nextInt(80);
                    int z = chunkZ * 16 + rand.nextInt(16);

                    generator.generate(world, rand, x, y, z);
                }
            }
    }

}
