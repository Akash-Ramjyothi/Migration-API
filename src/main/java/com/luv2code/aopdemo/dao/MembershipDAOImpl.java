package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMember() {
        log("START addSillyMember");

        // Simulate DB operation
        boolean isAdded = true;

        log("END addSillyMember - status: " + isAdded);
        return isAdded;
    }

    @Override
    public void goToSleep() {
        log("START goToSleep");

        try {
            Thread.sleep(1000); // simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log("Sleep interrupted: " + e.getMessage());
        }

        log("END goToSleep");
    }

    // --- Helper Methods ---

    private void log(String message) {
        System.out.println(getClass().getSimpleName() + " :: " + message);
    }
}
