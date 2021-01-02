package abigailfails.tradeandinvade.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.world.World;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends AbstractVillagerEntity {
    public VillagerEntityMixin(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void livingTick() {
        this.updateArmSwingProgress();
        super.livingTick();
    }

}
