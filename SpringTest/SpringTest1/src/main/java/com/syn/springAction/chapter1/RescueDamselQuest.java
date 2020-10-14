package com.syn.springAction.chapter1;

import com.syn.springAction.chapter1.Quest;

public class RescueDamselQuest implements Quest {
    @Override
    public void embark() {
        System.out.println("Embarking on a quest to rescue the damsel.");
    }
}
