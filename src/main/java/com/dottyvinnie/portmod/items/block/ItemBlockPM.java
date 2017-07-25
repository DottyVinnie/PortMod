package com.dottyvinnie.portmod.items.block;

import com.dottyvinnie.portmod.blocks.PMBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Dotty on 17-Mar-17.
 */
public class ItemBlockPM extends ItemBlock
{

    public ItemBlockPM(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (field_150939_a instanceof PMBlock) {
            String name = ((PMBlock) field_150939_a).getNameFor(stack.getItemDamage());
            if ("".equals(name))
                return getUnlocalizedName();
            else
                return getUnlocalizedName() + "_" + name;
        }

        return getUnlocalizedName() + "_" + stack.getItemDamage();
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
