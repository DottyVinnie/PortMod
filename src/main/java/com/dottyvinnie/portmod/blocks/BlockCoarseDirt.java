package com.dottyvinnie.portmod.blocks;

import com.dottyvinnie.portmod.util.Utility;
import cpw.mods.fml.common.eventhandler.Event.Result;
import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.UseHoeEvent;


public class BlockCoarseDirt extends Block implements IConfig
{

    public BlockCoarseDirt()
    {
        super(Material.ground);
        this.setHardness(0.5F);
        this.setHarvestLevel("shovel", 0);
        this.setStepSound(soundTypeGravel);
        this.setBlockTextureName(Utility.getBlockTexture("coarse_dirt"));
        this.setBlockName(Utility.getUnlocalisedName("coarse_dirt"));
        this.setCreativeTab(ConfigurationHandler.enableNewStone ? PortMod.creativeTabPM : null);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
        return Blocks.dirt.canSustainPlant(world, x, y, z, direction, plant);
    }

    @Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.enableCoarseDirt;
    }

    public static void onHoeEvent(UseHoeEvent event)
    {
        if (ConfigurationHandler.enableCoarseDirt)
        {
            World world = event.world;
            if (world.getBlock(event.x, event.y, event.z) == ModBlocks.coarse_dirt)
            {
                world.setBlock(event.x, event.y, event.z, Blocks.dirt);
                world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, Block.soundTypeGravel.getStepResourcePath(), 1.0F, 0.8F);
                event.setResult(Result.ALLOW);
            }
        }
    }
}
