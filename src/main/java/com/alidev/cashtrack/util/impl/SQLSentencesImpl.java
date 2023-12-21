package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.util.SQLSentences;

public class SQLSentencesImpl implements SQLSentences {
    private static final String FIND_ALL_FROM_BY = "SELECT * FROM %s WHERE %s = ?";
    private static final String CREATE_ACCOUNT = "INSERT INTO accounts (accountName, adminId, description, password, balance) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_MONEY = "INSERT INTO %s (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_USER = "INSERT INTO users (username, email, pin, account) VALUES (?, ?, ?, ?)";
    private static final String DELETE_ENTITY = "DELETE FROM %s WHERE %s = ?";
    private static final String DELETE_ACCOUNT_REVENUES = "DELETE FROM revenues WHERE userId IN (SELECT userId FROM users WHERE account = ?);";
    private static final String DELETE_ACCOUNT_EXPENSES = "DELETE FROM expenses WHERE userId IN (SELECT userId FROM users WHERE account = ?);";
    private static final String DELETE_ACCOUNT_ID_FROM_USERS = "UPDATE users SET account = NULL WHERE account = ?;";
    private static final String UPDATE_VALUE = "UPDATE %s SET %s = ? WHERE %s = ?;";
    private static final String UPDATE_BALANCE_REMOVE = "UPDATE accounts SET balance = balance - (SELECT amount FROM %s WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM %s WHERE id = ?));";
    private static final String UPDATE_BALANCE_ADD = "UPDATE accounts SET balance = balance + (SELECT amount FROM %s WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM %s WHERE id = ?));";
    private static final String GET_ALL_FROM_BY = "SELECT * FROM %s WHERE %s = ?;";
    private static final String GET_ACCOUNT_BALANCE = "SELECT * FROM accounts WHERE id = (SELECT account FROM users WHERE id = ?);";

    @Override
    public String get_find_all_from_by_sentence() {
        return FIND_ALL_FROM_BY;
    }

    @Override
    public String get_create_account_sentence() {
        return CREATE_ACCOUNT;
    }

    @Override
    public String get_create_money_sentence() {
        return CREATE_MONEY;
    }

    @Override
    public String get_create_user_sentence() {
        return CREATE_USER;
    }

    @Override
    public String get_delete_entity_sentence() {
        return DELETE_ENTITY;
    }

    @Override
    public String get_delete_account_revenues_sentence() {
        return DELETE_ACCOUNT_REVENUES;
    }

    @Override
    public String get_delete_account_expenses_sentence() {
        return DELETE_ACCOUNT_EXPENSES;
    }

    @Override
    public String get_delete_account_id_from_users_sentence() {
        return DELETE_ACCOUNT_ID_FROM_USERS;
    }

    @Override
    public String get_update_value_sentence() {
        return UPDATE_VALUE;
    }

    @Override
    public String get_update_balance_remove_sentence() {
        return UPDATE_BALANCE_REMOVE;
    }

    @Override
    public String get_update_balance_add_sentence() {
        return UPDATE_BALANCE_ADD;
    }

    @Override
    public String get_all_from_by_sentence() {
        return GET_ALL_FROM_BY;
    }

    @Override
    public String get_account_balance_sentence() {
        return GET_ACCOUNT_BALANCE;
    }
}
