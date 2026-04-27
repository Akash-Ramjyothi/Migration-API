package com.luv2code.aopdemo;

import java.util.Objects;

public class Account {

    private String name;
    private String level;

    // No-arg constructor
    public Account() {}

    // All-arg constructor
    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null) ? name.trim() : null;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = (level != null) ? level.trim().toUpperCase() : null;
    }

    // Utility methods
    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) &&
               Objects.equals(level, account.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }
}
