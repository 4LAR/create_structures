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
		
		// позиции для проверки
		int size_pos[][] = {
			{0, 0},
			{struct_x, 0},
			{struct_x, struct_z},
			{0, struct_z}	
		};

		int depth_check = 10;

		// проверка на пустоту и воду
		for (int i = 0; i < 4; i++) {
			if ((world.isEmptyBlock(new BlockPos(xx + size_pos[i][0], yy - 1, zz + size_pos[i][1]))) | ((world.getFluidState(new BlockPos(xx + size_pos[i][0], yy - depth_check, zz + size_pos[i][1])).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
				return false;
			}
		}

		// делаем островок
		for (int height = 0; height < depth_check; height++) {
			for (int circle_x = 0; circle_x < struct_x; circle_x++) {
				for (int circle_z = 0; circle_z < struct_z; circle_z++) {
					if (world.isEmptyBlock(new BlockPos(xx + circle_x, height - 1, zz + circle_z)) | ((world.getFluidState(new BlockPos(xx + circle_x, height - 1, zz + circle_z)).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
						world.setBlock(new BlockPos(xx + circle_x, yy - height, zz + circle_z), Blocks.DIRT.defaultBlockState(), 3);
					}
				}
			}
		}
//		for (int height = 0; height < max_size / 3; height++) {
//			double pow_height = Math.pow(height, 2);
//			for (int circle_x = 0; circle_x < struct_x - pow_height; circle_x++) {
//				for (int circle_z = 0; circle_z < struct_z - pow_height; circle_z++) {
//					world.setBlock(new BlockPos(xx + circle_x + height, yy - height, zz + circle_z + height), Blocks.DIRT.defaultBlockState(), 3);
//				}
//			}
//		}

		return true;
	}
}
