package ru.job4j.ood.isp;

public class Enemy1stLvl implements EnemyNpc {
    @Override
    public void walk() {
        System.out.println("простой вражеский моб может ходить");
    }

    @Override
    public double meleeAttack() {
        System.out.println("простой вражеский моб может атаковать вблизи");
        return 0;
    }

    @Override
    public double rangeAttack() {
        return 0;
    }

    @Override
    public void stayInSiege() {
        System.out.println("простой вражеский моб может ждать в засаде");
    }

    @Override
    public void crouch() {
        System.out.println("простой вражеский моб может пригнуться чтобы прятаться");
    }

    @Override
    public void fly() {
    }
}
