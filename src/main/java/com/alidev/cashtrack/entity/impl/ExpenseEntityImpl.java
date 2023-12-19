package com.alidev.cashtrack.entity.impl;

import com.alidev.cashtrack.entity.ExpenseEntity;

public class ExpenseEntityImpl extends MoneyEntityImpl implements ExpenseEntity {
    private int expense_id;
    public ExpenseEntityImpl() { }
    public int getExpenseId(){
        return expense_id;
    }
    public void setExpenseId(int id){
        this.expense_id = id;
    }
}
