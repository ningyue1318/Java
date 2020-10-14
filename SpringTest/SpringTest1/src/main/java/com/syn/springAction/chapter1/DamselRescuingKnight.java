package com.syn.springAction.chapter1;

public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight(){
        this.quest = new RescueDamselQuest();
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

    public static void main(String[] args) {
        DamselRescuingKnight d = new DamselRescuingKnight();
        d.embarkOnQuest();
    }
}
