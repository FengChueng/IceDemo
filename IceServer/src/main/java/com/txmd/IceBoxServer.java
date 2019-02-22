package com.txmd;

import IceBox.*;

/**
 * Created by zhangyinglong on 2019/2/22.
 */
public class IceBoxServer extends Ice.Application {

    private static void usage() {
        System.err.println("Usage: IceBox.Server [options] --Ice.Config=<file>\n");
        System.err.println(
            "Options:\n" +
                "-h, --help           Show this message.\n"
        );
    }

    public static void main(String[] args) {
        String [] config = {"--Ice.Config=config.properties"};
        Ice.InitializationData initData = new Ice.InitializationData();
        initData.properties = Ice.Util.createProperties();
        initData.properties.setProperty("Ice.Admin.DelayCreation", "1");

        IceBox.Server server = new IceBox.Server();
        System.exit(server.main("IceBox.Server", config, initData));
    }

    @Override
    public int run(String[] args) {
        final String prefix = "IceBox.Service.";
        Ice.Properties properties = communicator().getProperties();
        java.util.Map<String, String> services = properties.getPropertiesForPrefix(prefix);
        java.util.List<String> argSeq = new java.util.ArrayList<String>(args.length);
        for (String s : args) {
            argSeq.add(s);
        }

        for (java.util.Map.Entry<String, String> entry : services.entrySet()) {
            String name = entry.getKey().substring(prefix.length());
            for (int i = 0; i < argSeq.size(); ++i) {
                if (argSeq.get(i).startsWith("--" + name)) {
                    argSeq.remove(i);
                    i--;
                }
            }
        }

        for (String arg : argSeq) {
            if (arg.equals("-h") || arg.equals("--help")) {
                usage();
                return 0;
            } else {
                System.err.println("Server: unknown option `" + arg + "'");
                usage();
                return 1;
            }
        }

        ServiceManagerI serviceManagerImpl = new ServiceManagerI(communicator(), args);
        return serviceManagerImpl.run();
    }
}
