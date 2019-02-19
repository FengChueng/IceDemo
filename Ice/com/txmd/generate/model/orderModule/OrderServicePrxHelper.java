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

/**
 * Provides type-specific helper functions.
 **/
public final class OrderServicePrxHelper extends Ice.ObjectPrxHelperBase implements OrderServicePrx
{
    private static final String __addOrder_name = "addOrder";

    public boolean addOrder(Order order)
    {
        return addOrder(order, null, false);
    }

    public boolean addOrder(Order order, java.util.Map<String, String> __ctx)
    {
        return addOrder(order, __ctx, true);
    }

    private boolean addOrder(Order order, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__addOrder_name);
        return end_addOrder(begin_addOrder(order, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_addOrder(Order order)
    {
        return begin_addOrder(order, null, false, false, null);
    }

    public Ice.AsyncResult begin_addOrder(Order order, java.util.Map<String, String> __ctx)
    {
        return begin_addOrder(order, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_addOrder(Order order, Ice.Callback __cb)
    {
        return begin_addOrder(order, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_addOrder(Order order, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_addOrder(order, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_addOrder(Order order, Callback_OrderService_addOrder __cb)
    {
        return begin_addOrder(order, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_addOrder(Order order, java.util.Map<String, String> __ctx, Callback_OrderService_addOrder __cb)
    {
        return begin_addOrder(order, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_addOrder(Order order, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_addOrder(order, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_addOrder(Order order, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_addOrder(order, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_addOrder(Order order, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_addOrder(order, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_addOrder(Order order, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_addOrder(order, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_addOrder(Order order, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_BoolCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_addOrder(order, __ctx, __explicitCtx, __synchronous, 
                              new IceInternal.Functional_TwowayCallbackBool(__responseCb, __exceptionCb, __sentCb)
                                  {
                                      public final void __completed(Ice.AsyncResult __result)
                                      {
                                          OrderServicePrxHelper.__addOrder_completed(this, __result);
                                      }
                                  });
    }

    private Ice.AsyncResult begin_addOrder(Order order, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__addOrder_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__addOrder_name, __cb);
        try
        {
            __result.prepare(__addOrder_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            Order.__write(__os, order);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public boolean end_addOrder(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __addOrder_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            boolean __ret;
            __ret = __is.readBool();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __addOrder_completed(Ice.TwowayCallbackBool __cb, Ice.AsyncResult __result)
    {
        com.txmd.generate.model.orderModule.OrderServicePrx __proxy = (com.txmd.generate.model.orderModule.OrderServicePrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_addOrder(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __endOrder_name = "endOrder";

    public boolean endOrder(long orderId)
    {
        return endOrder(orderId, null, false);
    }

    public boolean endOrder(long orderId, java.util.Map<String, String> __ctx)
    {
        return endOrder(orderId, __ctx, true);
    }

    private boolean endOrder(long orderId, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__endOrder_name);
        return end_endOrder(begin_endOrder(orderId, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_endOrder(long orderId)
    {
        return begin_endOrder(orderId, null, false, false, null);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, java.util.Map<String, String> __ctx)
    {
        return begin_endOrder(orderId, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, Ice.Callback __cb)
    {
        return begin_endOrder(orderId, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_endOrder(orderId, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, Callback_OrderService_endOrder __cb)
    {
        return begin_endOrder(orderId, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, java.util.Map<String, String> __ctx, Callback_OrderService_endOrder __cb)
    {
        return begin_endOrder(orderId, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_endOrder(orderId, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_endOrder(orderId, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_endOrder(orderId, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_endOrder(long orderId, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_endOrder(orderId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_endOrder(long orderId, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_BoolCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_endOrder(orderId, __ctx, __explicitCtx, __synchronous, 
                              new IceInternal.Functional_TwowayCallbackBool(__responseCb, __exceptionCb, __sentCb)
                                  {
                                      public final void __completed(Ice.AsyncResult __result)
                                      {
                                          OrderServicePrxHelper.__endOrder_completed(this, __result);
                                      }
                                  });
    }

    private Ice.AsyncResult begin_endOrder(long orderId, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__endOrder_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__endOrder_name, __cb);
        try
        {
            __result.prepare(__endOrder_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeLong(orderId);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public boolean end_endOrder(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __endOrder_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            boolean __ret;
            __ret = __is.readBool();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __endOrder_completed(Ice.TwowayCallbackBool __cb, Ice.AsyncResult __result)
    {
        com.txmd.generate.model.orderModule.OrderServicePrx __proxy = (com.txmd.generate.model.orderModule.OrderServicePrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_endOrder(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __getOrder_name = "getOrder";

    public Order getOrder(long orderId)
    {
        return getOrder(orderId, null, false);
    }

    public Order getOrder(long orderId, java.util.Map<String, String> __ctx)
    {
        return getOrder(orderId, __ctx, true);
    }

    private Order getOrder(long orderId, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__getOrder_name);
        return end_getOrder(begin_getOrder(orderId, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_getOrder(long orderId)
    {
        return begin_getOrder(orderId, null, false, false, null);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, java.util.Map<String, String> __ctx)
    {
        return begin_getOrder(orderId, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, Ice.Callback __cb)
    {
        return begin_getOrder(orderId, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getOrder(orderId, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, Callback_OrderService_getOrder __cb)
    {
        return begin_getOrder(orderId, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, java.util.Map<String, String> __ctx, Callback_OrderService_getOrder __cb)
    {
        return begin_getOrder(orderId, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, 
                                          IceInternal.Functional_GenericCallback1<Order> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_getOrder(orderId, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, 
                                          IceInternal.Functional_GenericCallback1<Order> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_getOrder(orderId, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<Order> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_getOrder(orderId, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_getOrder(long orderId, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<Order> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_getOrder(orderId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_getOrder(long orderId, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_GenericCallback1<Order> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_getOrder(orderId, __ctx, __explicitCtx, __synchronous, 
                              new IceInternal.Functional_TwowayCallbackArg1<com.txmd.generate.model.orderModule.Order>(__responseCb, __exceptionCb, __sentCb)
                                  {
                                      public final void __completed(Ice.AsyncResult __result)
                                      {
                                          OrderServicePrxHelper.__getOrder_completed(this, __result);
                                      }
                                  });
    }

    private Ice.AsyncResult begin_getOrder(long orderId, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getOrder_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__getOrder_name, __cb);
        try
        {
            __result.prepare(__getOrder_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeLong(orderId);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public Order end_getOrder(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __getOrder_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            Order __ret = null;
            __ret = Order.__read(__is, __ret);
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __getOrder_completed(Ice.TwowayCallbackArg1<Order> __cb, Ice.AsyncResult __result)
    {
        com.txmd.generate.model.orderModule.OrderServicePrx __proxy = (com.txmd.generate.model.orderModule.OrderServicePrx)__result.getProxy();
        Order __ret = null;
        try
        {
            __ret = __proxy.end_getOrder(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __payOrder_name = "payOrder";

    public boolean payOrder(long orderId)
    {
        return payOrder(orderId, null, false);
    }

    public boolean payOrder(long orderId, java.util.Map<String, String> __ctx)
    {
        return payOrder(orderId, __ctx, true);
    }

    private boolean payOrder(long orderId, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__payOrder_name);
        return end_payOrder(begin_payOrder(orderId, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_payOrder(long orderId)
    {
        return begin_payOrder(orderId, null, false, false, null);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, java.util.Map<String, String> __ctx)
    {
        return begin_payOrder(orderId, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, Ice.Callback __cb)
    {
        return begin_payOrder(orderId, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_payOrder(orderId, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, Callback_OrderService_payOrder __cb)
    {
        return begin_payOrder(orderId, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, java.util.Map<String, String> __ctx, Callback_OrderService_payOrder __cb)
    {
        return begin_payOrder(orderId, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_payOrder(orderId, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_payOrder(orderId, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_payOrder(orderId, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_payOrder(long orderId, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_BoolCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_payOrder(orderId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_payOrder(long orderId, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_BoolCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_payOrder(orderId, __ctx, __explicitCtx, __synchronous, 
                              new IceInternal.Functional_TwowayCallbackBool(__responseCb, __exceptionCb, __sentCb)
                                  {
                                      public final void __completed(Ice.AsyncResult __result)
                                      {
                                          OrderServicePrxHelper.__payOrder_completed(this, __result);
                                      }
                                  });
    }

    private Ice.AsyncResult begin_payOrder(long orderId, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__payOrder_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__payOrder_name, __cb);
        try
        {
            __result.prepare(__payOrder_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeLong(orderId);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public boolean end_payOrder(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __payOrder_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            boolean __ret;
            __ret = __is.readBool();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __payOrder_completed(Ice.TwowayCallbackBool __cb, Ice.AsyncResult __result)
    {
        com.txmd.generate.model.orderModule.OrderServicePrx __proxy = (com.txmd.generate.model.orderModule.OrderServicePrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_payOrder(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __shutdown_name = "shutdown";

    public void shutdown()
    {
        shutdown(null, false);
    }

    public void shutdown(java.util.Map<String, String> __ctx)
    {
        shutdown(__ctx, true);
    }

    private void shutdown(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_shutdown(begin_shutdown(__ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_shutdown()
    {
        return begin_shutdown(null, false, false, null);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx)
    {
        return begin_shutdown(__ctx, true, false, null);
    }

    public Ice.AsyncResult begin_shutdown(Ice.Callback __cb)
    {
        return begin_shutdown(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_shutdown(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(Callback_OrderService_shutdown __cb)
    {
        return begin_shutdown(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, Callback_OrderService_shutdown __cb)
    {
        return begin_shutdown(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_shutdown(null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_shutdown(IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_shutdown(null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_shutdown(__ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_shutdown(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_shutdown(__ctx, 
                              __explicitCtx, 
                              __synchronous, 
                              new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__shutdown_name, __cb);
        try
        {
            __result.prepare(__shutdown_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            __result.writeEmptyParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_shutdown(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __shutdown_name);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OrderServicePrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), OrderServicePrx.class, OrderServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OrderServicePrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), OrderServicePrx.class, OrderServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OrderServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), OrderServicePrx.class, OrderServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OrderServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), OrderServicePrx.class, OrderServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static OrderServicePrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, OrderServicePrx.class, OrderServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static OrderServicePrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, OrderServicePrx.class, OrderServicePrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::orderModule::OrderService"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, OrderServicePrx v)
    {
        __os.writeProxy(v);
    }

    public static OrderServicePrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            OrderServicePrxHelper result = new OrderServicePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
