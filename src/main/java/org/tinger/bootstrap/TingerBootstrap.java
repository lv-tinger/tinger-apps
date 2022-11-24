package org.tinger.bootstrap;

import org.tinger.core.apps.Application;

/**
 * Created by tinger on 2022-10-03
 */
public class TingerBootstrap {
    public static void run(String name, String... args) {
        Application application = new TingerApplication(name, args);
        application.init();
        application.start();
        Thread shutdown = new Thread("TINGER-SHUTDOWN") {
            @Override
            public void run() {
                application.close();
            }
        };
        Runtime.getRuntime().addShutdownHook(shutdown);

        try {
            Thread.currentThread().join();
        } catch (InterruptedException ignore) {
        }
    }
}
