#pragma once
// 指定上层包名
[["java:package:com.txmd.generate"]]
// module和Java的Package对应
module helloworld {
    interface Hello{
        idempotent void sayHello(int delay);
        idempotent string helloWorld(string name);
        void shutdown();
    };
};