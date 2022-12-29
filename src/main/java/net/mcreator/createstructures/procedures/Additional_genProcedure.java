package net.mcreator.createstructures.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;

public class Additional_genProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, int struct_x, int struct_y, int struct_z, int rotate_angle) {
		int size_pos[][] = {
			{1, 1},
			{-struct_x + 1, 1},
			{-struct_x + 1, struct_z},
			{1, struct_z}	
		};

//		System.out.println("----------------------");
		int i;
		for (i = 0; i < 4; i++) {
//			System.out.print(x + size_pos[i][0]);
//			System.out.print(" ");
//			System.out.println(y + size_pos[i][1]);
//			
			if ((world.isEmptyBlock(new BlockPos(x + size_pos[i][0], y - 1, z + size_pos[i][1]))) | ((world.getFluidState(new BlockPos(x + size_pos[i][0], y - 1, z + size_pos[i][1])).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
				return false;
			}
		}

		for (i = 0; i < 4; i++) {
			world.setBlock(new BlockPos(x + size_pos[i][0], y - 1, z + size_pos[i][1]), Blocks.RED_WOOL.defaultBlockState(), 3);
		}
		return true;
	}
}
