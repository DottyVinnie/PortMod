package com.dottyvinnie.portmod.blocks;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.block.material.Material;

/**
 * Created by Dotty on 17-Mar-17.
 */
public class BlockPrismarine extends PMBlock implements IConfig
{
    public BlockPrismarine()
    {
        super(Material.rock, "rough", "bricks", "dark");
        this.setResistance(10.0F);
        this.setHardness(1.5F);
        this.setHarvestLevel("pickaxe", 1);
        this.setBlockTextureName(Utility.getBlockTexture("prismarine"));
        this.setBlockName(Utility.getUnlocalisedName("prismarine"));
        this.setCreativeTab(ConfigurationHandler.enablePrismarine ? PortMod.creativeTabPM : null);
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enablePrismarine;
    }
}
