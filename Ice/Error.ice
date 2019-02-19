#pragma once

[["java:package:com.txmd.generate.error"]]

module ErrorModule {
    exception Error {string reason};

    exception RuntimeError extends Error {
        int errorSize;
        int maxSize;
        int minSize;
    }

}