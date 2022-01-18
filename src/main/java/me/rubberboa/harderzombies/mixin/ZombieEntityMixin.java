package me.rubberboa.harderzombies.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin {

	@ModifyVariable(method = "setCanBreakDoors(Z)V", at = @At(value = "HEAD"))
	private boolean mixin(boolean canBreakDoors) {
		return true;
	}
}
