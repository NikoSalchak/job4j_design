package ru.job4j.ood.isp;

public class ActionGame {

    EnemyNpc enemy;

    public ActionGame(EnemyNpc enemy) {
        this.enemy = enemy;
    }

    public void action() {
        enemy.fly();
    }

    public static void main(String[] args) {
        ActionGame game = new ActionGame(new Enemy1stLvl());
    }
}
