
package net.mcreator.createstructures.world.features;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import net.mcreator.createstructures.procedures.Additional_genProcedure;

import java.util.Set;
import java.util.List;

public class VillagehauseFeature extends Feature<NoneFeatureConfiguration> {
	public static VillagehauseFeature FEATURE = null;
	public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new VillagehauseFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("create_structures:villagehause", FEATURE, FeatureConfiguration.NONE);
		PLACED_FEATURE = PlacementUtils.register("create_structures:villagehause", CONFIGURED_FEATURE, List.of());
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;//Set.of(new ResourceLocation("forest"), new ResourceLocation("taiga"),
//			new ResourceLocation("plains"));
	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);
	private final List<Block> base_blocks;
	private StructureTemplate template = null;
	private String[] Resource_list = new String[] {
//		"car",
//		"field_tent",
//		"field_theatre",
//		"grave",
//		"grave2",
//		"grave3",
//		"grave4",
//		"vallage_hause",
//		"vallage_hause2",
//		"vallage_hause3",
//		/////////////////
//		"field_hospital",
//		"artillery_position",
//		"barbed_wire",
//		"long_term_firing_point",
//		"destroyed_long_term_firing_point",
//		"long_term_firing_point_in_the_ground",
//		"destroyed_townhouses",
//		"lil_destroyed_townhouses"
		"artillery_position",
		"barbed_wire",
		"bunker",
		"camp_grass",
		"car",
		"crater_grass",
		"destroyed_long_term_firing_point",
		"destroyed_townhouses",
		"field_hospital",
		"field_tent",
		"field_theatre",
		"grave",
		"grave2",
		"grave3",
		"grave4",
		"lil_destroyed_townhouses",
		"long_term_firing_point",
		"long_term_firing_point_in_the_ground",
		"tower_grass",
		"trench_grass",
		//"vallage_big_hause",
		"vallage_hause",
		"vallage_hause2",
		"vallage_hause3"
	};

	private String template_name = "";
	
	private boolean spawned = true;
	
	public VillagehauseFeature() {
		super(NoneFeatureConfiguration.CODEC);
		base_blocks = List.of(Blocks.GRASS_BLOCK);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (!generate_dimensions.contains(context.level().getLevel().dimension()))
			return false;
		
		if (spawned) {
			template_name = Resource_list[context.random().nextInt(Resource_list.length)];
			template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("create_structures", template_name));
		}
		
		if (template == null)
			return false;

//		System.out.println(template.getSize());
		
		boolean anyPlaced = false;
		if ((context.random().nextInt(1000000) + 1) <= 100000) {
			int count = context.random().nextInt(1) + 1;
			for (int a = 0; a < count; a++) {
				int i = context.origin().getX() + context.random().nextInt(16);
				int k = context.origin().getZ() + context.random().nextInt(16);
				int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k) - 1;
				if (!base_blocks.contains(context.level().getBlockState(new BlockPos(i, j, k)).getBlock())) {
					spawned = false;
					//continue;
					break;
				}
				int bottom_offs = 0;
				if (template_name == "bunker") {
					bottom_offs = 15;
				}
				BlockPos spawnTo = new BlockPos(i + 0, j - bottom_offs, k + 0);
				WorldGenLevel world = context.level();
				int x = spawnTo.getX();
				int y = spawnTo.getY();
				int z = spawnTo.getZ();

				////////////////////////////////////

				int struct_x = template.getSize().getX();
				int struct_y = template.getSize().getY();
				int struct_z = template.getSize().getZ();
				
				int rotate_angle = 0;
				
				int xOffset = 0;
        		int zOffset = 0;
				
				if (rotate_angle == 1) {
					xOffset -= struct_x;
				} else if (rotate_angle == 2) {
					zOffset -= struct_z;
					xOffset -= struct_x;
				} else if (rotate_angle == 3) {
					zOffset += struct_z;
					xOffset += struct_x;
				}
				////////////////////////////////////
				
				if (!Additional_genProcedure.execute(world, x + xOffset, y, z + zOffset, template) & (template_name != "bunker")) {
					spawned = false;
					//continue;
					break;
				}
				if (template.placeInWorld(context.level(), spawnTo, spawnTo,
						new StructurePlaceSettings().setMirror(Mirror.values()[0])
								.setRotation(Rotation.values()[rotate_angle]).setRandom(context.random())
								.addProcessor(BlockIgnoreProcessor.AIR).setIgnoreEntities(false),
						context.random(), 2)) {
					anyPlaced = true;
				}
			}
		}
//		System.out.print("Spawn ");
//		System.out.println(template_name);
		spawned = true;
		return anyPlaced;
	}
}
