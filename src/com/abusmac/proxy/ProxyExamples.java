package com.abusmac.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyExamples implements Runnable {

    private void runFromWithinInvocationHandler() {
        System.out.println("Within runFromWithinInvocationHandler");
    }

    @Override
    public void run() {
        final ProxyExamples proxyExamples = this;

        // Invocation handler to trace the call to the ProxyExamples runFromWithinInvocationHandler method call.
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println("Within invocation handler");

            proxyExamples.runFromWithinInvocationHandler();

            return null;
        };

        Runnable newProxyInstance = (Runnable) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Runnable.class}, invocationHandler);
        newProxyInstance.run();

        System.out.println("End of ProxyExamples");
    }
}
