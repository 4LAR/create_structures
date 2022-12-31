package net.mcreator.createstructures.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelgas_mask_war_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("create_structures", "modelgas_mask_war_converted"), "main");
	public final ModelPart bone;

	public Modelgas_mask_war_Converted(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 8).addBox(-12.0F, -15.0F, 4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.mirror().addBox(-4.0F, -15.0F, 4.0F, -8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 8)
						.addBox(-3.75F, -15.25F, 3.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(40, 8)
						.addBox(-12.25F, -15.25F, 3.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 8)
						.addBox(-12.25F, -15.25F, 12.25F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(26, 12)
						.addBox(-10.0F, -10.0F, 3.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 5)
						.addBox(-10.0F, -5.0F, 4.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
