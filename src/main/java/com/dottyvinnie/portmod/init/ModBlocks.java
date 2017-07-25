package com.dottyvinnie.portmod.init;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.blocks.*;
import com.dottyvinnie.portmod.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

import java.lang.reflect.Field;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final Block coarse_dirt = new BlockCoarseDirt();
	public static final Block magma = new BlockMagma();
	public static final Block purpur_block = new BlockPurpurBlock();
	public static final Block stone = new BlockNewStone();
	public static final Block sea_lantern = new BlockSeaLantern();
	public static final Block prismarine = new BlockPrismarine();
	public static final Block bone_block = new BlockBone();

	public static void init() {
		try {
			for (Field f : ModBlocks.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Block)
					registerBlock((Block) obj);
				else if (obj instanceof Block[])
					for (Block block : (Block[]) obj)
						if (block != null)
							registerBlock(block);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerBlock(Block block) {
		if (!(block instanceof IConfig) || ((IConfig) block).isEnabled()) {
			String name = block.getUnlocalizedName();
			String[] strings = name.split("\\.");

			if (block instanceof ISubBlocksPM)
				GameRegistry.registerBlock(block, ((ISubBlocksPM) block).getItemBlockClass(), strings[strings.length - 1]);
			else
				GameRegistry.registerBlock(block, strings[strings.length - 1]);

			if (block instanceof IBurnable)
				Blocks.fire.setFireInfo(block, 5, 20);
		}
	}

	public static interface ISubBlocksPM {

		Class<? extends ItemBlock> getItemBlockClass();
	}

	public static interface IBurnable {
	}
}
