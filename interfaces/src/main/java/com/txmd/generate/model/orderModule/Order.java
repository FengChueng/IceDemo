// **********************************************************************
//
// Copyright (c) 2003-2017 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.4
//
// <auto-generated>
//
// Generated from file `Order.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.txmd.generate.model.orderModule;

public class Order implements Cloneable, java.io.Serializable
{
    public long orderId;

    public boolean isPay;

    public long createTime;

    public long payTime;

    public long endTime;

    public User user;

    public Order()
    {
        user = new User();
    }

    public Order(long orderId, boolean isPay, long createTime, long payTime, long endTime, User user)
    {
        this.orderId = orderId;
        this.isPay = isPay;
        this.createTime = createTime;
        this.payTime = payTime;
        this.endTime = endTime;
        this.user = user;
    }

    public boolean
    equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Order _r = null;
        if(rhs instanceof Order)
        {
            _r = (Order)rhs;
        }

        if(_r != null)
        {
            if(orderId != _r.orderId)
            {
                return false;
            }
            if(isPay != _r.isPay)
            {
                return false;
            }
            if(createTime != _r.createTime)
            {
                return false;
            }
            if(payTime != _r.payTime)
            {
                return false;
            }
            if(endTime != _r.endTime)
            {
                return false;
            }
            if(user != _r.user)
            {
                if(user == null || _r.user == null || !user.equals(_r.user))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::orderModule::Order");
        __h = IceInternal.HashUtil.hashAdd(__h, orderId);
        __h = IceInternal.HashUtil.hashAdd(__h, isPay);
        __h = IceInternal.HashUtil.hashAdd(__h, createTime);
        __h = IceInternal.HashUtil.hashAdd(__h, payTime);
        __h = IceInternal.HashUtil.hashAdd(__h, endTime);
        __h = IceInternal.HashUtil.hashAdd(__h, user);
        return __h;
    }

    public Order
    clone()
    {
        Order c = null;
        try
        {
            c = (Order)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeLong(orderId);
        __os.writeBool(isPay);
        __os.writeLong(createTime);
        __os.writeLong(payTime);
        __os.writeLong(endTime);
        User.__write(__os, user);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        orderId = __is.readLong();
        isPay = __is.readBool();
        createTime = __is.readLong();
        payTime = __is.readLong();
        endTime = __is.readLong();
        user = User.__read(__is, user);
    }

    static public void
    __write(IceInternal.BasicStream __os, Order __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public Order
    __read(IceInternal.BasicStream __is, Order __v)
    {
        if(__v == null)
        {
             __v = new Order();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final Order __nullMarshalValue = new Order();

    public static final long serialVersionUID = 1387198183L;
}