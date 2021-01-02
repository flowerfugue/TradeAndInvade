package abigailfails.tradeandinvade.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.IHeadToggle;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@Mixin(VillagerModel.class)
public abstract class VillagerModelMixin<T extends Entity> extends SegmentedModel<T> implements IHasHead, IHeadToggle {

    @Shadow
    @Final
    protected ModelRenderer villagerArms;

    @Inject(at = @At(value = "TAIL"), method = "setRotationAngles(Lnet/minecraft/entity/Entity;FFFFF)V")
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo info) {
        if (this.swingProgress != 0.0F) {
            float f = 1.0F - (float) MathHelper.abs(10 - 2 * swingProgress) / 10.0F;
            this.villagerArms.rotateAngleX = MathHelper.lerp(f, -0.87266463F, -0.34906584F);
        }
    }
}
