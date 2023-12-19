package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.util.SQLSentences;

public class SQLSentencesImpl implements SQLSentences {
    private static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id = ?";
    private static final String FIND_ACCOUNT_BY_ADMIN_ID = "SELECT * FROM accounts WHERE adminId = ?";
    private static final String FIND_EXPENSE_BY_ID = "SELECT * FROM expenses WHERE id = ?";
    private static final String FIND_REVENUE_BY_ID = "SELECT * FROM revenues WHERE id = ?";
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String CREATE_ACCOUNT = "INSERT INTO accounts (accountName, adminId, description, password, balance) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_EXPENSE = "INSERT INTO expenses (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_REVENUE = "INSERT INTO revenues (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_USER = "INSERT INTO users (username, email, pin, account) VALUES (?, ?, ?, ?)";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = ?";
    private static final String DELETE_ACCOUNT_REVENUES = "DELETE FROM revenues WHERE userId IN (SELECT userId FROM users WHERE account = ?);";
    private static final String DELETE_ACCOUNT_EXPENSES = "DELETE FROM expenses WHERE userId IN (SELECT userId FROM users WHERE account = ?);";
    private static final String DELETE_ACCOUNT_ID_FROM_USERS = "UPDATE users SET account = NULL WHERE account = ?;";
    private static final String DELETE_EXPENSE = "DELETE FROM expenses WHERE id = ?";
    private static final String DELETE_REVENUE = "DELETE FROM revenues WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    private static final String DELETE_REVENUES = "DELETE FROM revenues WHERE userId = ?;";
    private static final String DELETE_EXPENSES = "DELETE FROM expenses WHERE userId = ?;";private static final String UPDATE_ACCOUNT_NAME = "UPDATE accounts SET accountName = ? WHERE id = ?;";
    private static final String UPDATE_ADMIN_ID = "UPDATE accounts SET adminId = ? WHERE id = ?;";
    private static final String UPDATE_DESCRIPTION = "UPDATE accounts SET description = ? WHERE id = ?;";
    private static final String UPDATE_PASSWORD = "UPDATE accounts SET password = ? WHERE id = ?;";
    private static final String UPDATE_BALANCE_REMOVE = "UPDATE accounts SET balance = balance - (SELECT amount FROM expenses WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM expenses WHERE id = ?));";
    private static final String UPDATE_BALANCE_ADD = "UPDATE accounts SET balance = balance + (SELECT amount FROM expenses WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM expenses WHERE id = ?));";
    private static final String UPDATE_DESCRIPTION = "UPDATE expenses SET description = ? WHERE id = ?;";
    private static final String UPDATE_TYPE = "UPDATE expenses SET type = ? WHERE id = ?;";
    private static final String UPDATE_BALANCE_ADD = "UPDATE accounts SET balance = balance + (SELECT amount FROM revenues WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM revenues WHERE id = ?));";
    private static final String UPDATE_BALANCE_REMOVE = "UPDATE accounts SET balance = balance - (SELECT amount FROM revenues WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM revenues WHERE id = ?));";
    private static final String UPDATE_AMOUNT = "UPDATE revenues SET amount = ? WHERE id = ?;";
    private static final String UPDATE_DESCRIPTION = "UPDATE revenues SET description = ? WHERE id = ?;";
    private static final String UPDATE_TYPE = "UPDATE revenues SET type = ? WHERE id = ?;";
    private static final String UPDATE_USER_NAME = "UPDATE users SET username = ? WHERE id = ?;";
    private static final String UPDATE_EMAIL = "UPDATE users SET email = ? WHERE id = ?;";
    private static final String UPDATE_PIN = "UPDATE users SET pin = ? WHERE id = ?;";
    private static final String UPDATE_ACCOUNT_ID = "UPDATE users SET account = ? WHERE id = ?;";
    private static final String GET_USERS_BY_ACCOUNT_ID = "SELECT * FROM users WHERE account = ?;";
    private static final String GET_EXPENSES_BY_USER_ID = "SELECT * FROM expenses WHERE userId = ?;";
    private static final String GET_ACCOUNT_BALANCE = "SELECT * FROM accounts WHERE id = (SELECT account FROM users WHERE id = ?);";
    private static final String GET_REVENUES_BY_USER_ID = "SELECT * FROM revenues WHERE userId = ?;";

}
