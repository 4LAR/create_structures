package net.mcreator.createstructures.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TestProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() instanceof LiquidBlock) {
			return true;
		}
		return true;
	}
}
