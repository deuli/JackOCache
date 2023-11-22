package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EntityNearbyCondition extends TransformCondition {
    private final EntityType<?> entity;
    private final double radius;

    public EntityNearbyCondition(EntityType<?> entity, int radius) {
        this.entity = entity;
        this.radius = radius;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        List<Entity> entities = level.getEntities(null, new AABB(blockPos).inflate(radius));
        for (Entity entity : entities)
            if (entity.getType() == this.entity)
                return checkNext(level, blockPos);

        return false;
    }
}
