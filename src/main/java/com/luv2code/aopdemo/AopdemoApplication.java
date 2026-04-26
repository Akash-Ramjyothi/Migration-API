package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> runAopDemo(accountDAO, membershipDAO);
    }

    /**
     * Main demo orchestrator for AOP Before Advice
     */
    private void runAopDemo(AccountDAO accountDAO, MembershipDAO membershipDAO) {

        System.out.println("\n=== Running AOP @Before Advice Demo ===\n");

        processAccountOperations(accountDAO);
        processMembershipOperations(membershipDAO);

        System.out.println("\n=== Demo Completed ===\n");
    }

    /**
     * Demonstrates AccountDAO operations
     */
    private void processAccountOperations(AccountDAO accountDAO) {

        System.out.println("\n--- AccountDAO Operations ---");

        Account account = createSampleAccount("Madhu", "Platinum");

        // Business method calls
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        // Getter/Setter method calls (to test AOP exclusions if configured)
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();

        System.out.println("Retrieved AccountDAO name: " + name);
        System.out.println("Retrieved Service Code: " + serviceCode);
    }

    /**
     * Demonstrates MembershipDAO operations
     */
    private void processMembershipOperations(MembershipDAO membershipDAO) {

        System.out.println("\n--- MembershipDAO Operations ---");

        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }

    /**
     * Factory method for Account object creation
     */
    private Account createSampleAccount(String name, String level) {

        Account account = new Account();
        account.setName(name);
        account.setLevel(level);

        return account;
    }
}
