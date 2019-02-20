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
// Generated from file `Message.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.txmd.generate.book;

public class Message implements java.lang.Cloneable, java.io.Serializable
{
    public String name;

    public int type;

    public boolean valid;

    public double price;

    public String content;

    public Message()
    {
        name = "";
        content = "";
    }

    public Message(String name, int type, boolean valid, double price, String content)
    {
        this.name = name;
        this.type = type;
        this.valid = valid;
        this.price = price;
        this.content = content;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Message _r = null;
        if(rhs instanceof Message)
        {
            _r = (Message)rhs;
        }

        if(_r != null)
        {
            if(name != _r.name)
            {
                if(name == null || _r.name == null || !name.equals(_r.name))
                {
                    return false;
                }
            }
            if(type != _r.type)
            {
                return false;
            }
            if(valid != _r.valid)
            {
                return false;
            }
            if(price != _r.price)
            {
                return false;
            }
            if(content != _r.content)
            {
                if(content == null || _r.content == null || !content.equals(_r.content))
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
        __h = IceInternal.HashUtil.hashAdd(__h, "::book::Message");
        __h = IceInternal.HashUtil.hashAdd(__h, name);
        __h = IceInternal.HashUtil.hashAdd(__h, type);
        __h = IceInternal.HashUtil.hashAdd(__h, valid);
        __h = IceInternal.HashUtil.hashAdd(__h, price);
        __h = IceInternal.HashUtil.hashAdd(__h, content);
        return __h;
    }

    public Message
    clone()
    {
        Message c = null;
        try
        {
            c = (Message)super.clone();
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
        __os.writeString(name);
        __os.writeInt(type);
        __os.writeBool(valid);
        __os.writeDouble(price);
        __os.writeString(content);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        name = __is.readString();
        type = __is.readInt();
        valid = __is.readBool();
        price = __is.readDouble();
        content = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, Message __v)
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

    static public Message
    __read(IceInternal.BasicStream __is, Message __v)
    {
        if(__v == null)
        {
             __v = new Message();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final Message __nullMarshalValue = new Message();

    public static final long serialVersionUID = -281949533L;
}
