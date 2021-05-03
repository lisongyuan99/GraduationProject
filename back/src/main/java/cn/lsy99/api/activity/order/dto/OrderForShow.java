package cn.lsy99.api.activity.order.dto;

import cn.lsy99.api.activity.generator.table.Comment;
import cn.lsy99.api.activity.generator.table.OrderInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderForShow {
    private OrderInfo order;
    private ActivityInfo activity;
    private Comment comment;
}
