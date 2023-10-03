package deuli.jackocache.blocks;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.Blocks;

public class EquipableSheepPumpkinBlock extends SheepPumpkinBlock implements Equipable {
    public EquipableSheepPumpkinBlock() {
        super(Properties.copy(Blocks.CARVED_PUMPKIN));
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
