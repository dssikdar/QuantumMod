package com.diptanshu.quantummod2.item.custom;

import com.diptanshu.quantummod2.block.custom.QubitBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static com.diptanshu.quantummod2.block.custom.QubitBlock.*;

public class ResetQubitItem extends Item
{
    public ResetQubitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        Level pLevel = pContext.getLevel();
        Block clickedBlock = pContext.getLevel().getBlockState(positionClicked).getBlock();

        if (clickedBlock instanceof QubitBlock) {
            QubitBlock qubitBlock = QubitBlock.class.cast(clickedBlock);
            double[] currentState = qubitBlock.stateVector.clone();
            //player.sendMessage(new TextComponent(("Current State: " + currentState[0]) + " |0>   AND   " + (currentState[1]) + " |1>"), player.getUUID());
            qubitBlock.stateVector[0] = 1.0;
            qubitBlock.stateVector[1] = 0.0;
            printState(pLevel, player, qubitBlock.stateVector, "Reset");
            //player.sendMessage(new TextComponent(("New State: " + qubitBlock.stateVector[0]) + " |0>   AND   " + (qubitBlock.stateVector[1]) + " |1>"), player.getUUID());
        }

        return super.useOn(pContext);
    }
}
