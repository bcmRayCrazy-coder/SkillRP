package cn.jerrymc.skilrp.skills;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Skill {
    // Name
    private String name;
    // Custom Model Data that display texture in client
    private int modelData;
    // Cooldown level (0 when it isn't cooldown, minus 1 per tick while cooldown)
    private float cooldown;
    // Skill level
    private int level;

    // cooldown task id
    private int cooldownTaskId;

    private JavaPlugin owner;

    public Skill(JavaPlugin owner, String name, int modelData, float cooldownTicks, int level) {
        this.owner = owner;
        this.name = name;
        this.modelData = modelData;
        this.cooldown = cooldownTicks;
        this.level = level;
    }

    // When skill used
    public void use(Player player, World world) {
    }

    public void startCooldown() {
        BukkitScheduler scheduler = owner.getServer().getScheduler();
        setCooldownTaskId(scheduler.scheduleSyncRepeatingTask(owner, new Runnable() {
            @Override
            public void run() {
                if (!isCooldown()) {
                    stopCooldown();
                    return;
                }
                setCooldown(getCooldown() - 1.0f);
            }
        }, 0, 1L));
    }

    public void stopCooldown() {
        BukkitScheduler scheduler = owner.getServer().getScheduler();
        scheduler.cancelTask(cooldownTaskId);
    }


    public String getName() {
        return name;
    }

    public float getCooldown() {
        return cooldown;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getModelData() {
        return modelData;
    }

    public void setCooldownTaskId(int cooldownTaskId) {
        this.cooldownTaskId = cooldownTaskId;
    }

    public boolean isCooldown() {
        return cooldown > 0.0f;
    }

    public void setCooldown(float cooldown) {
        this.cooldown = cooldown;
    }
}
