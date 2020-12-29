package abigailfails.tradeandinvade.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import abigailfails.tradeandinvade.TradeAndInvade;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

public class VillagerSleepyEyeRenderLayer<T extends LivingEntity> extends LayerRenderer<T, VillagerModel<T>> {
    private static final ResourceLocation VILLAGER_EYES = new ResourceLocation(TradeAndInvade.MODID, "textures/entity/villager_eyes.png");
    private final VillagerModel<T> layerModel = new VillagerModel<>(0.0F);

    public VillagerSleepyEyeRenderLayer(IEntityRenderer<T, VillagerModel<T>> rendererIn) {
        super(rendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entitylivingbaseIn.isSleeping())
            renderCopyCutoutModel(this.getEntityModel(), this.layerModel, VILLAGER_EYES, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, 1.0F, 1.0F, 1.0F);
    }
}
