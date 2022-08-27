package cn.jerrymc.skilrp.skills.storage;

import cn.jerrymc.skilrp.skills.Skill;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fire extends Skill {

    public Fire(JavaPlugin owner, String name, int modelData, float cooldownTicks, int level) {
        super(owner, name, modelData, cooldownTicks, level);
    }

    @Override
    public void use(Player player, World world) {
        if (isCooldown()) return;
        Location loc = player.getLocation();
        Block block = loc.getBlock();
        block.setType(Material.FIRE);
        startCooldown();
    }
}
