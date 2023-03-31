package edu.iu.c322.trackingservice.repository;

import edu.iu.c322.trackingservice.model.Item;
import edu.iu.c322.trackingservice.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TrackingRepository {
    private List<Order> orders = new ArrayList<>();
    public int create(Order order) {
        orders.add(order);
        return order.getOrderId();
    }
    public Item getItem(int orderId, int itemId) {


        for(int i =0; i < orders.size(); i++) {

            if(orders.get(i).getOrderId() == orderId) {
                List<Item> itemList = orders.get(i).getItems();
                for(int j =0; j < itemList.size(); j++) {
                    if(itemList.get(j).getItemId() == itemId) {
                        return itemList.get(j);
                    }
                }

            }
            else {

            }


        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "order with this itemId does not exist in the system."
        );
    }
    public void update(Item item, int orderId ) {
        for(int i =0; i < orders.size(); i++) {
            if(orders.get(i).getOrderId() == orderId) {
                List<Item> itemList = orders.get(i).getItems();
                for(int j =0; j < itemList.size(); j++) {
                    if(itemList.get(j).getItemId() == item.getItemId()) {
                        orders.get(i).getItems().set(j, item);
                    }
                }

            }

        }

    }
}
