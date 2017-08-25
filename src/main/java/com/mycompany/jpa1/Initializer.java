package com.mycompany.jpa1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Persistence;

public class Initializer
{
    public static void main(String[] args)
    {
        /////// Setup //////////////////
        HashMap puproperties = new HashMap();

        puproperties.put("javax.persistence.sql-load-script-source", "scripts/drop_all.sql");
        Persistence.generateSchema("jpaPU", puproperties);
        ////////////////////////////////

        Facade facade = new Facade(Persistence.createEntityManagerFactory("jpaPU"));
        Customer customer = new Customer("Josef", "Blabla@blamail.bla");
        facade.createCustomer(customer);
        
        System.out.println(facade.findCustomer("Blabla@blamail.bla").getEmail());
        
        CustomerOrder order = new CustomerOrder();
        List<OrderLine> orderlines = new ArrayList();
        orderlines.add(new OrderLine(5, order, new ItemType("Clothes", "It is clothes and stuff", 2.5)));
        order.setOrderlines(orderlines);
        facade.createOrder(order, customer);
        
        facade.closeEntityManager();
    }
}
