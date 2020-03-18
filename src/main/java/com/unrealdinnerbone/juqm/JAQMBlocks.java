package com.unrealdinnerbone.juqm;

import com.unrealdinnerbone.juqm.blocks.QuarryBlock;
import com.unrealdinnerbone.juqm.util.IItemProperitesProvider;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;

import java.util.function.Supplier;

public enum JAQMBlocks
{
    QUARRY(QuarryBlock::new);

    private final Block block;
    private BlockItem blockItem;
    private final ResourceLocation resourceLocation;

    public static final JAQMBlocks[] ALL = values();

    JAQMBlocks(Supplier<Block> blockConsumer) {
        this.resourceLocation = new ResourceLocation(JAQM.MOD_ID, name().toLowerCase());
        this.block = blockConsumer.get().setRegistryName(resourceLocation);
        if(block instanceof IItemProperitesProvider) {
            this.blockItem = new BlockItem(block, ((IItemProperitesProvider) block).getItemProperties());
            this.blockItem.setRegistryName(resourceLocation);
        }

    }

    public Block getBlock() {
        return block;
    }

    public BlockItem getBlockItem() {
        return blockItem;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

}
