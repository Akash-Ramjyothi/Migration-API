package com.luv2code.aopdemo.dao;

public interface MembershipDAO {

    // Core operations
    boolean addMember(String memberName, String membershipType);

    boolean updateMember(String memberName, String membershipType);

    boolean deleteMember(String memberName);

    String findMember(String memberName);

    // Demo / utility methods (used for AOP examples)
    boolean addSillyMember();

    void goToSleep();
}
