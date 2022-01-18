package me.rubberboa.harderzombies.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.DoorInteractGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BreakDoorGoal.class)
public abstract class BreakDoorGoalMixin extends DoorInteractGoal {
	public BreakDoorGoalMixin(MobEntity mob) {
		super(mob);
	}

	@ModifyArg(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;syncWorldEvent(ILnet/minecraft/util/math/BlockPos;I)V"), index = 0)
	private int mixin(int eventId) {
		BlockState state = this.mob.world.getBlockState(doorPos);
		return state.getMaterial() == Material.METAL ? WorldEvents.ZOMBIE_ATTACKS_IRON_DOOR : WorldEvents.ZOMBIE_ATTACKS_WOODEN_DOOR;
	}
}
