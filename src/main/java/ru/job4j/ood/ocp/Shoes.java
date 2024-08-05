package ru.job4j.ood.ocp;

import java.util.Objects;

public class Shoes {
    private int size;
    private String type;
    private String sex;

    public Shoes(int size, String type, String sex) {
        this.size = size;
        this.type = type;
        this.sex = sex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shoes shoes = (Shoes) o;
        return size == shoes.size && Objects.equals(type, shoes.type) && Objects.equals(sex, shoes.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, type, sex);
    }

    @Override
    public String toString() {
        return "Shoes{"
                + "size=" + size
                + ", type='" + type + '\''
                + ", sex='" + sex + '\''
                + '}';
    }
}
