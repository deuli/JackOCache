package deuli.jackocache.blocks;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.Blocks;

public class EquipableDragonPumpkinBlock extends DragonPumpkinBlock implements Equipable {
    public EquipableDragonPumpkinBlock() {
        super(Properties.copy(Blocks.CARVED_PUMPKIN));
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
