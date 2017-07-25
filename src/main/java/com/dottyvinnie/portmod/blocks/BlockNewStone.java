package com.dottyvinnie.portmod.blocks;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * Created by Dotty on 17-Mar-17.
 */
public class BlockNewStone extends PMBlock implements IConfig
{
    public static final int ANDESITE = 0;
    public static final int DIORITE = 1;
    public static final int GRANITE = 2;
    public static final int POLISHED_ANDESITE = 3;
    public static final int POLISHED_DIORITE = 4;
    public static final int POLISHED_GRANITE = 5;

    public BlockNewStone()
    {
        super(Material.rock,  "andesite", "diorite", "granite","andesite_smooth", "diorite_smooth", "granite_smooth");
        this.startMeta = 0;
        this.setResistance(10.0F);
        this.setHardness(1.5F);
        this.setBlockTextureName(Utility.getBlockTexture("stone"));
        this.setHarvestLevel("pickaxe", 0);
        this.setStepSound(soundTypePiston);
        this.setBlockName(Utility.getUnlocalisedName("stone"));
        this.setCreativeTab(ConfigurationHandler.enableNewStone ? PortMod.creativeTabPM : null);
    }

    @Override
    public boolean isReplaceableOreGen(World world, int x, int y, int z, Block target)
    {
        return this == target || target == Blocks.stone;
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enableNewStone;
    }
}
