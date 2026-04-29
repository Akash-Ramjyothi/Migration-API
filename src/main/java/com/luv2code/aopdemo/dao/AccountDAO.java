package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

/**
 * DAO interface for Account operations.
 * Defines CRUD operations and additional utility behaviors.
 */
public interface AccountDAO {

    /**
     * Adds a new account.
     *
     * @param theAccount account object to be added
     * @param vipFlag indicates if the account is VIP
     */
    void addAccount(Account theAccount, boolean vipFlag);

    /**
     * Retrieves all accounts.
     *
     * @return list of accounts
     */
    List<Account> findAccounts();

    /**
     * Retrieves all accounts with optional filtering.
     *
     * @param includeVip whether to include VIP accounts
     * @return filtered list of accounts
     */
    List<Account> findAccounts(boolean includeVip);

    /**
     * Updates an existing account.
     *
     * @param account account object with updated details
     */
    void updateAccount(Account account);

    /**
     * Deletes an account by name.
     *
     * @param accountName name of the account to delete
     */
    void deleteAccount(String accountName);

    /**
     * Simulates work or processing logic.
     *
     * @return true if successful, false otherwise
     */
    boolean doWork();

    /**
     * Gets DAO name.
     *
     * @return DAO name
     */
    String getName();

    /**
     * Sets DAO name.
     *
     * @param name DAO name
     */
    void setName(String name);

    /**
     * Gets service code.
     *
     * @return service code
     */
    String getServiceCode();

    /**
     * Sets service code.
     *
     * @param serviceCode service identifier
     */
    void setServiceCode(String serviceCode);
}
