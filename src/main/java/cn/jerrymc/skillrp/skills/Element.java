package cn.jerrymc.skillrp.skills;

import java.util.ArrayList;

class SkillObject {
    public Skill skill;
    public SkillType skillType;

    public SkillObject(SkillType type, Skill skill) {
        this.skill = skill;
        this.skillType = type;
    }

    public Skill getSkill() {
        return skill;
    }

    public SkillType getSkillType() {
        return skillType;
    }
}

public class Element {

    private ArrayList<SkillObject> skillObjects;

    private String name;
    private String description;

    public Element(String name, String description) {

    }

    public void registerSkill(SkillType skillType, Skill skill) {
        skillObjects.add(new SkillObject(skillType, skill));
    }

    public Skill getSkill(SkillType type) {
        for (SkillObject skill : skillObjects) {
            if (skill.getSkillType() == type) {
                return skill.getSkill();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
