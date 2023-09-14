package com.rits.ebazar.controller;

import com.rits.ebazar.bean.Item;
import com.rits.ebazar.model.Order;
import com.rits.ebazar.service.order.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private InventoryService inventoryService;


//    @PostMapping("/item")
//    public ResponseEntity<Item> getRes(@RequestBody Item item){
//        Item itemRes = inventoryService.saveItem(item);
//        return new ResponseEntity<>(itemRes, HttpStatus.OK);
//    }
//    @GetMapping("/items")
//    public ResponseEntity<List<Item>> getAllItems(){
//        List<Item> itemRes = inventoryService.getAllItem();
//        return new ResponseEntity<>(itemRes, HttpStatus.OK);
//    }
    @PostMapping("/order")
    public ResponseEntity<Order> processOrder(@RequestBody Order order){
        Order processedOrder = inventoryService.processOrder(order);
        return new ResponseEntity<>(processedOrder, HttpStatus.OK);
    }
}
