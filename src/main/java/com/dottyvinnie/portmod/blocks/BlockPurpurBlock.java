package com.dottyvinnie.portmod.blocks;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Dotty on 11-Mar-17.
 */
public class BlockPurpurBlock extends Block implements IConfig
{
    public BlockPurpurBlock()
    {
        super(Material.rock);
        this.setBlockName(Utility.getUnlocalisedName("purpur_block"));
        this.setBlockTextureName(Utility.getBlockTexture("purpur_block"));
        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setCreativeTab(ConfigurationHandler.enableMagmaBlock ? PortMod.creativeTabPM : null);
    }

    @Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.enablePurpurBlock;
    }
}
