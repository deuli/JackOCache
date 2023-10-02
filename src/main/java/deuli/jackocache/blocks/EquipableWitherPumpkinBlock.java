package deuli.jackocache.blocks;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EquipableWitherPumpkinBlock extends WitherPumpkinBlock implements Equipable {
    public EquipableWitherPumpkinBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN));
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
