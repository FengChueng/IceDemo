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

public abstract class Callback_OrderService_addOrder
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackBool
{
    public final void __completed(Ice.AsyncResult __result)
    {
        OrderServicePrxHelper.__addOrder_completed(this, __result);
    }
}
