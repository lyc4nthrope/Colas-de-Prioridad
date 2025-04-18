package com.store.storeu.model;

public class Order implements Comparable<Order> {
    private String name;
    private String role;
    private int priority;  // 1=Professor,2=Disability,3=Student
    private int ticket;    // sequential ticket

    public Order() {

    }

    public Order(String name, String role, int priority, int ticket) {
        this.name = name;
        this.role = role;
        this.priority = priority;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getTicket() {
        return ticket;
    }
    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public int compareTo(Order o) {
        if (this.priority != o.priority) {
            return Integer.compare(this.priority, o.priority);
        }
        return Integer.compare(this.ticket, o.ticket);
    }
}