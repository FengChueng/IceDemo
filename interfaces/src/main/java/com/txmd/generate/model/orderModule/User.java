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

public class User implements Cloneable, java.io.Serializable
{
    public long userId;

    public String userName;

    public int userAge;

    public boolean userSex;

    public UserRole userRole;

    public User()
    {
        userName = "";
        userRole = UserRole.ADMIN;
    }

    public User(long userId, String userName, int userAge, boolean userSex, UserRole userRole)
    {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userRole = userRole;
    }

    public boolean
    equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        User _r = null;
        if(rhs instanceof User)
        {
            _r = (User)rhs;
        }

        if(_r != null)
        {
            if(userId != _r.userId)
            {
                return false;
            }
            if(userName != _r.userName)
            {
                if(userName == null || _r.userName == null || !userName.equals(_r.userName))
                {
                    return false;
                }
            }
            if(userAge != _r.userAge)
            {
                return false;
            }
            if(userSex != _r.userSex)
            {
                return false;
            }
            if(userRole != _r.userRole)
            {
                if(userRole == null || _r.userRole == null || !userRole.equals(_r.userRole))
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
        __h = IceInternal.HashUtil.hashAdd(__h, "::orderModule::User");
        __h = IceInternal.HashUtil.hashAdd(__h, userId);
        __h = IceInternal.HashUtil.hashAdd(__h, userName);
        __h = IceInternal.HashUtil.hashAdd(__h, userAge);
        __h = IceInternal.HashUtil.hashAdd(__h, userSex);
        __h = IceInternal.HashUtil.hashAdd(__h, userRole);
        return __h;
    }

    public User
    clone()
    {
        User c = null;
        try
        {
            c = (User)super.clone();
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
        __os.writeLong(userId);
        __os.writeString(userName);
        __os.writeInt(userAge);
        __os.writeBool(userSex);
        UserRole.__write(__os, userRole);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        userId = __is.readLong();
        userName = __is.readString();
        userAge = __is.readInt();
        userSex = __is.readBool();
        userRole = UserRole.__read(__is);
    }

    static public void
    __write(IceInternal.BasicStream __os, User __v)
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

    static public User
    __read(IceInternal.BasicStream __is, User __v)
    {
        if(__v == null)
        {
             __v = new User();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final User __nullMarshalValue = new User();

    public static final long serialVersionUID = 1395942891L;
}