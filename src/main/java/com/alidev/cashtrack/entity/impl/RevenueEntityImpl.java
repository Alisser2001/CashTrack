package com.alidev.cashtrack.entity.impl;

import com.alidev.cashtrack.entity.RevenueEntity;

public class RevenueEntityImpl extends MoneyEntityImpl implements RevenueEntity {
    private int revenue_id;
    public RevenueEntityImpl() { }
    public int getRevenueId(){
        return revenue_id;
    }
    public void setRevenueId(int id){
        this.revenue_id = id;
    }

}
