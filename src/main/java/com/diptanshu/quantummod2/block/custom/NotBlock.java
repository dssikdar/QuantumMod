package com.diptanshu.quantummod2.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static com.diptanshu.quantummod2.block.custom.QubitBlock.*;

public class NotBlock extends GateBlock {
    public NotBlock(Boolean pressed, Properties properties) {
        super(pressed, properties);
    }

    final double[][] xMatrix = {{0.0, 1.0}, {1.0, 0.0}};

    @Override
    public void press(BlockState blockState, Level level, BlockPos position) {
        Block blockBelow = level.getBlockState(position.below(1)).getBlock();
        if (level.isClientSide()) {
            if (blockBelow instanceof QubitBlock) {
                QubitBlock qubitBlock = (QubitBlock) blockBelow;
                qubitBlock.stateVector = matrixMult(qubitBlock.stateVector, xMatrix);
            }
        }

        Block blockFacingNorth = level.getBlockState(position.north(1)).getBlock();
        if (level.isClientSide()) {
            if (blockFacingNorth instanceof QubitBlock) {
                QubitBlock qubitBlock = (QubitBlock) blockFacingNorth;
                qubitBlock.stateVector = matrixMult(qubitBlock.stateVector, xMatrix);
            }
        }

        Block blockFacingSouth = level.getBlockState(position.south(1)).getBlock();
        if (level.isClientSide()) {
            if (blockFacingSouth instanceof QubitBlock) {
                QubitBlock qubitBlock = (QubitBlock) blockFacingSouth;
                qubitBlock.stateVector = matrixMult(qubitBlock.stateVector, xMatrix);
            }
        }

        Block blockFacingEast = level.getBlockState(position.east(1)).getBlock();
        if (level.isClientSide()) {
            if (blockFacingEast instanceof QubitBlock) {
                QubitBlock qubitBlock = (QubitBlock) blockFacingEast;
                qubitBlock.stateVector = matrixMult(qubitBlock.stateVector, xMatrix);
            }
        }

        Block blockFacingWest = level.getBlockState(position.west(1)).getBlock();
        if (level.isClientSide()) {
            if (blockFacingWest instanceof QubitBlock) {
                QubitBlock qubitBlock = (QubitBlock) blockFacingWest;
                qubitBlock.stateVector = matrixMult(qubitBlock.stateVector, xMatrix);
            }
        }

        super.press(blockState, level, position);
    }
}
