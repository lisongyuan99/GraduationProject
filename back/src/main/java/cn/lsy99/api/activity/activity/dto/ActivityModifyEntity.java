package cn.lsy99.api.activity.activity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ActivityModifyEntity {
    private int activityId;
    private String name;
    private String introduction;
    private String[] pictures;
    private int category;
    private Date date;
    private int regionCode;
    private String address;
    private String detail;
}
