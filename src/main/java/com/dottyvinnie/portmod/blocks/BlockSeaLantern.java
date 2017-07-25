package com.dottyvinnie.portmod.blocks;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Dotty on 17-Mar-17.
 */
public class BlockSeaLantern extends Block implements IConfig
{
    public BlockSeaLantern()
    {
        super(Material.glass);
        this.setBlockName(Utility.getUnlocalisedName("sea_lantern"));
        this.setBlockTextureName(Utility.getBlockTexture("sea_lantern"));
        this.setHardness(0.5F);
        this.setStepSound(soundTypeGlass);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("shovel", 0);
        this.setCreativeTab(ConfigurationHandler.enablePrismarine ? PortMod.creativeTabPM : null);
    }

    @Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.enablePrismarine;
    }
}
