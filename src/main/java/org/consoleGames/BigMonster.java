package org.consoleGames;

public class BigMonster extends Monster {
    private final String icon = "Бм";

    public BigMonster(int x, int y, int difficultLevel) {
        super(x, y, difficultLevel);
    }

    @Override
    public boolean task(int difficult) {
        return super.task(difficult);
    }
}
