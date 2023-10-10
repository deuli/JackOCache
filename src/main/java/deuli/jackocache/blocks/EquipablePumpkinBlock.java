package deuli.jackocache.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;

public class EquipablePumpkinBlock extends EquipableCarvedPumpkinBlock implements PumpkinBlur {
    private final String blur;

    public EquipablePumpkinBlock(Properties properties, String blur) {
        super(properties);
        this.blur = blur;
    }

    public EquipablePumpkinBlock(String blur) {
        this(Properties.copy(Blocks.CARVED_PUMPKIN), blur);
    }

    @Override
    public String getBlur() {
        return blur;
    }
}
