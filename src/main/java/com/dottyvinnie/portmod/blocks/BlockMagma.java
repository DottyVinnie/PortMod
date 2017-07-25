package com.dottyvinnie.portmod.blocks;


import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMagma extends Block implements IConfig
{
	public BlockMagma()
		{
			super(Material.rock);
			this.setBlockName(Utility.getUnlocalisedName("magma"));
			this.setBlockTextureName(Utility.getBlockTexture("magma"));
			this.setHardness(0.5F);
			this.setStepSound(soundTypeStone);
			this.setLightLevel(0.2F);
			this.setHarvestLevel("shovel", 0);
			this.setCreativeTab(ConfigurationHandler.enableMagmaBlock ? PortMod.creativeTabPM : null);
		}

		@Override
	public boolean isEnabled()
		{
			return ConfigurationHandler.enableMagmaBlock;
		}
}
