package com.dottyvinnie.portmod.blocks;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Dotty on 20-Mar-17.
 */
public class BlockBone extends BlockRotatedPillar implements IConfig
{

    public BlockBone()
    {
        super(Material.rock);
        this.setHardness(2.0F);
        this.setStepSound(soundTypePiston);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName(Utility.getBlockTexture("bone_block"));
        this.setBlockName(Utility.getUnlocalisedName("bone_block"));
        this.setCreativeTab(ConfigurationHandler.enableBone ? PortMod.creativeTabPM : null);
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int side)
    {
        return blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        super.registerBlockIcons(reg);
        field_150164_N = reg.registerIcon(getTextureName() + "_top");
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enableBone;
    }
}
