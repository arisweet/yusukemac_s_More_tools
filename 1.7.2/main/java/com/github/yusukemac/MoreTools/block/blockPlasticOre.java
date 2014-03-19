package com.github.yusukemac.MoreTools.block;

import com.github.yusukemac.MoreTools.Core;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by yusuke on 2014/03/19.
 */
public class blockPlasticOre extends Block {

    public blockPlasticOre(Material material)
    {

        super(material);
        setCreativeTab(Core.tabYMTools);
        setBlockName("orePlastic");
        setBlockTextureName("plastic_ore");
        setHardness(4.0F);
        setStepSound(Block.soundTypeStone);
    }
}
