#pragma once
// 指定上层包名
[["java:package:com.txmd.generate.model"]]
// module和Java的Package对应
module orderModule {

    enum UserRole {ADMIN,VIP,VISITOR};

    struct User {
        long        userId;
        string      userName;
        int         userAge;
        bool        userSex;
        UserRole    userRole;
    };

    struct Order {
        long        orderId;
        bool        isPay;
        long        createTime;
        long        payTime;
        long        endTime;
        User        user;
    };

    interface OrderService{
        ["ami"] bool addOrder(Order order);
        bool payOrder(long orderId);
        Order getOrder(long orderId);
        bool endOrder(long orderId);
        void shutdown();
    };
};