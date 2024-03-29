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
// Generated from file `SMSService.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.txmd.generate.message;

public interface SMSServicePrx extends Ice.ObjectPrx
{
    public void sendSMS(String msg);

    public void sendSMS(String msg, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendSMS(String msg);

    public Ice.AsyncResult begin_sendSMS(String msg, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendSMS(String msg, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendSMS(String msg, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendSMS(String msg, Callback_SMSService_sendSMS __cb);

    public Ice.AsyncResult begin_sendSMS(String msg, java.util.Map<String, String> __ctx, Callback_SMSService_sendSMS __cb);

    public Ice.AsyncResult begin_sendSMS(String msg, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sendSMS(String msg, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_sendSMS(String msg, 
                                         java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sendSMS(String msg, 
                                         java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb);

    public void end_sendSMS(Ice.AsyncResult __result);
}
