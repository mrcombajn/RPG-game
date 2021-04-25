package main.java.character;

import main.java.character.skills.Skill;

public class Profession {
    private Profession_Name name;
    private Skill[] skills;

    public Profession(Profession_Name name, Skill[] skills) {
        this.name = name;
        this.skills = skills;
    }
}
