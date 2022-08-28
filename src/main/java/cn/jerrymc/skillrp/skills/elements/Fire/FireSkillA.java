package cn.jerrymc.skillrp.skills.elements.Fire;

import cn.jerrymc.skillrp.skills.Skill;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FireSkillA extends Skill {

    public FireSkillA(JavaPlugin owner) {
        super(owner, "fire_skill_a", "火技能1", 11401, 20, 1);
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
