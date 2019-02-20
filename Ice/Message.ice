#pragma once
// 指定上层包名
[["java:package:com.txmd.generate"]]
// module和Java的Package对应
module book {
    struct Message {
    string name;
    int type;
    bool valid;
    double price;
    string content;
    };
    interface OnlineBook{
        Message bookTicket(Message msg);
    };
};