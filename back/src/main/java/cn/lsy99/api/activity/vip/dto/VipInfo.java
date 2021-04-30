package cn.lsy99.api.activity.vip.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class VipInfo {
    private int activeDay;
    private Date expireDate;
    private Date lastRenewDate;
    private List<Bill> bills;
}
