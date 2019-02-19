#pragma once
// 指定上层包名
[["java:package:com.txmd.generate"]]
// module和Java的Package对应
module MessageModule {
    ["ami"] interface Sms{
        bool sendSms(string phone);
    };
};