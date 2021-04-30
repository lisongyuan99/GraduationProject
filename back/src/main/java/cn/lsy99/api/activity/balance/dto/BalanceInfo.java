package cn.lsy99.api.activity.balance.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BalanceInfo {
    private double balance;
    private double withdraw;
    private double today;
    private double sum;
    private List<Bill> bills;
}
