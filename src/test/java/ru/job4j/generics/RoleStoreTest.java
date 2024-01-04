package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Programmer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.add(new Role("1", "notAProgrammer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Programmer");
    }

    @Test
    void whenReplaceThenRoleNameIsNotAProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.replace("1", new Role("1", "notAProgrammer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("notAProgrammer");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.replace("10", new Role("10", "notAProgrammer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Programmer");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Programmer");
    }

    @Test
    void whenReplaceRoleThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        boolean result = store.replace("1", new Role("1", "notAProgrammer"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        boolean result = store.replace("10", new Role("10", "notAProgrammer"));
        assertThat(result).isFalse();
    }
}