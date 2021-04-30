package cn.lsy99.api.activity.balance.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Bill {
    private Date time;
    private String info;
    private double price;
    private Integer orderId;
}
