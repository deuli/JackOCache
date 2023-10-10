package deuli.jackocache.blocks;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.Blocks;

public class EquipableWitherPumpkinBlock extends WitherPumpkinBlock implements Equipable, PumpkinBlur {
    public EquipableWitherPumpkinBlock() {
        super(Properties.copy(Blocks.CARVED_PUMPKIN));
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public String getBlur() {
        return "wither";
    }
}
