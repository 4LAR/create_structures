package net.mcreator.createstructures.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class Additional_genProcedure {
	public static boolean execute(LevelAccessor world, double xx, double yy, double zz, StructureTemplate template) {

		int struct_x = template.getSize().getX();
		int struct_y = template.getSize().getY();
		int struct_z = template.getSize().getZ();

		int max_size = struct_x;
		if (struct_z > struct_x) {
			max_size = struct_z;
		}

		
		for (int height = 0; height < max_size / 3; height++) {
			double pow_height = Math.pow(height, 2);
			for (int circle_x = 0; circle_x < struct_x - pow_height; circle_x++) {
				for (int circle_z = 0; circle_z < struct_z - pow_height; circle_z++) {
					world.setBlock(new BlockPos(xx + circle_x + height, yy - height, zz + circle_z + height), Blocks.DIRT.defaultBlockState(), 3);
				}
			}
		}

// генерация по нужному месту
//		int size_pos[][] = {
//			{0, 0},
//			{max_size, 0},
//			{max_size, max_size},
//			{0, max_size}	
//		};

//		int i;
//		for (i = 0; i < 4; i++) {
//			if ((world.isEmptyBlock(new BlockPos(x + size_pos[i][0], y - 1, z + size_pos[i][1]))) | ((world.getFluidState(new BlockPos(x + size_pos[i][0], y - 1, z + size_pos[i][1])).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
//				return false;
//			}
//		}

//		for (i = 0; i < 4; i++) {
//			world.setBlock(new BlockPos(x + size_pos[i][0], y - 1, z + size_pos[i][1]), Blocks.RED_WOOL.defaultBlockState(), 3);
//		}

		return true;
	}
}
