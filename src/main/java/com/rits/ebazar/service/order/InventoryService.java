package com.rits.ebazar.service.order;

import com.rits.ebazar.bean.Item;
import com.rits.ebazar.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@Service
public interface InventoryService {

//    Item saveItem(Item item);
//    List<Item> getAllItem();

    Order processOrder(Order order);
}
