/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa1;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;
    @ManyToOne
    private CustomerOrder order;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ItemType type;

    public OrderLine()
    {
    }
    
    public OrderLine(int quantity, CustomerOrder order, ItemType type)
    {
        this.quantity = quantity;
        this.order = order;
        this.type = type;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderLine))
        {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.jpa1.OrderLine[ id=" + id + " ]";
    }
    
}
