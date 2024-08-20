package ru.job4j.ood.isp;

public class FlyingEnemy implements EnemyNpc {
    @Override
    public void walk() {
        System.out.println("особый моб может ходить");
    }

    @Override
    public double meleeAttack() {
        System.out.println("особый моб может атаковать вблизи");
        return 0;
    }

    @Override
    public double rangeAttack() {
        System.out.println("особый моб может бросать снаряды");
        return 0;
    }

    @Override
    public void stayInSiege() {

    }

    @Override
    public void crouch() {

    }

    @Override
    public void fly() {
        System.out.println("особый моб может летать");
    }
}
