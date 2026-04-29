package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    // Simulated in-memory DB
    private final List<Account> accountList = new ArrayList<>();

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": ADDING ACCOUNT -> " + theAccount + ", VIP: " + vipFlag);
        accountList.add(theAccount);
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println(getClass() + ": FETCHING ALL ACCOUNTS");
        return new ArrayList<>(accountList);
    }

    @Override
    public List<Account> findAccounts(boolean includeVip) {
        System.out.println(getClass() + ": FETCHING ACCOUNTS | includeVip=" + includeVip);

        if (includeVip) {
            return findAccounts();
        }

        // Example filter: exclude accounts with level "VIP"
        return accountList.stream()
                .filter(acc -> acc.getLevel() == null || !acc.getLevel().equalsIgnoreCase("VIP"))
                .collect(Collectors.toList());
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println(getClass() + ": UPDATING ACCOUNT -> " + account);

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getName().equals(account.getName())) {
                accountList.set(i, account);
                return;
            }
        }

        System.out.println("Account not found for update: " + account.getName());
    }

    @Override
    public void deleteAccount(String accountName) {
        System.out.println(getClass() + ": DELETING ACCOUNT -> " + accountName);

        accountList.removeIf(acc -> acc.getName().equals(accountName));
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": PERFORMING WORK");
        // Simulate some processing logic
        return !accountList.isEmpty();
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": GET NAME");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + ": SET NAME -> " + name);
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + ": GET SERVICE CODE");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": SET SERVICE CODE -> " + serviceCode);
        this.serviceCode = serviceCode;
    }
}
