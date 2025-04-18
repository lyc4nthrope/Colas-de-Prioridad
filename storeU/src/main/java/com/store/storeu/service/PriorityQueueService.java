package com.store.storeu.service;

import com.store.storeu.ds.PriorityQueue;
import com.store.storeu.model.Order;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PriorityQueueService {
    private final PriorityQueue<Order> queue = new PriorityQueue<>();
    private final AtomicInteger ticketCounter = new AtomicInteger(0);

    public Order addOrder(String name, String role) {
        int priority;
        switch (role.toLowerCase()) {
            case "disability": priority = 1; break;
            case "professor": priority = 2; break;
            case "administrator": priority = 3; break;
            default: priority = 4;
        }
        int ticket = ticketCounter.incrementAndGet();
        Order o = new Order(name, role, priority, ticket);
        queue.offer(o);
        return o;
    }

    public Order attendOrder() {
        return queue.poll();
    }

    public Order[] listOrders() {
        return queue.toArray(Order.class);
    }
}