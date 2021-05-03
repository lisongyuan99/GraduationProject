package cn.lsy99.api.activity.order;

import cn.lsy99.api.activity.order.dto.ActivityInfo;
import cn.lsy99.api.activity.exception.exception.NoShopException;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.Comment;
import cn.lsy99.api.activity.generator.table.OrderInfo;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.order.dto.OrderForShow;
import cn.lsy99.api.activity.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderForShow getByOrderId(int id) {
        OrderForShow orderForShow = OrderForShow.builder().build();
        Optional<OrderInfo> order = orderRepository.getById(id);
        if (order.isEmpty()) {
            return null;
        }
        orderForShow.setOrder(order.get());
        Optional<Activity> activity = orderRepository.getActivity(order.get().getActivityId());
        if(activity.isPresent()){
            orderForShow.setActivity(getInfo(activity.get()));
            Optional<Comment> comment = orderRepository.getComment(order.get().getId());
            comment.ifPresent(orderForShow::setComment);
        }
        return orderForShow;
    }

    public List<OrderForShow> getByActivity(int activityId) {
        List<OrderInfo> orders = orderRepository.getByActivityId(activityId);
        List<OrderForShow> orderForShowList = new ArrayList<>();
        for (OrderInfo e : orders) {
            OrderForShow orderForShow = OrderForShow.builder().order(e).build();
            Optional<Activity> activity = orderRepository.getActivity(e.getActivityId());
            activity.ifPresent(value -> orderForShow.setActivity(getInfo(value)));
            orderForShowList.add(orderForShow);
        }
        return orderForShowList;
    }

    public List<OrderForShow> getByBossId(int bossId) {
        Optional<Seller> boss = orderRepository.getBoss(bossId);
        if (boss.isEmpty()) {
            throw new NoShopException();
        }
        List<OrderInfo> orders = orderRepository.getByShopId(boss.get().getShopId());
        List<OrderForShow> orderForShowList = new ArrayList<>();
        for (OrderInfo e : orders) {
            OrderForShow orderForShow = OrderForShow.builder().order(e).build();
            Optional<Activity> activity = orderRepository.getActivity(e.getActivityId());
            activity.ifPresent(value -> orderForShow.setActivity(getInfo(value)));
            orderForShowList.add(orderForShow);
        }
        return orderForShowList;
    }

    private ActivityInfo getInfo(Activity activity){
        String[] pictures = ArrayUtil.StringToStringArray(activity.getPics());
        ActivityInfo result =  ActivityInfo.builder()
                .name(activity.getTitle())
                .regionCode(activity.getPositionCode())
                .address(activity.getPositionDetail())
                .time(activity.getBeginTime())
                .build();
        if (pictures.length >= 1) {
            result.setPicture(pictures[0]);
        }
        return result;
    }
}
