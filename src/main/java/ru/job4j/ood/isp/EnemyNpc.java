package ru.job4j.ood.isp;

public interface EnemyNpc {
    void walk();

    double meleeAttack();

    double rangeAttack();

    void stayInSiege();

    void crouch();

    void fly();
}
