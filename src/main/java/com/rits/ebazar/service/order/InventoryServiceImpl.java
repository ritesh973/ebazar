package com.rits.ebazar.service.order;

import com.rits.ebazar.bean.Coupon;
import com.rits.ebazar.model.Order;
import com.rits.ebazar.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private RuleService ruleService;

//    @Autowired
//    private ItemRepo itemRepo;
//    @Override
//    public Item saveItem(Item item) {
//        Item itemWithCategory = ruleService.applyCategory(item);
//        ItemData itemData = new ItemData(itemWithCategory);
//        itemRepo.save(itemData);
//        return item;
//    }

//    @Override
//    public List<Item> getAllItem() {
//        List<ItemData> all = itemRepo.findAll();
//        List<Item> collect = all.stream().map(Item::new).collect(Collectors.toList());
//        return collect;
//    }

    @Override
    public Order processOrder(Order order) {
        order.getOrderLines().stream().forEach(data->{
            ruleService.applyCategory(data.getItem());
        });
        Order orderWithClassifiedCustomer = ruleService.classifyCustomer(order);
        Collection<Coupon> coupons = ruleService.applyCoupons(order);
        coupons.forEach(data-> System.out.println("Coupon Applied for Order ::: "+data.getOrder().getOrderId()));
        Order discountAppliedOrder = ruleService.applyDiscount(orderWithClassifiedCustomer);
        return discountAppliedOrder;
    }
}
