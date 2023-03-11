package com.abusmac.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
            System.out.println("Within invocation handler from lambda");

            proxyExamples.runFromWithinInvocationHandler();

            return null;
        };

        Runnable newProxyInstance = (Runnable) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Runnable.class}, invocationHandler);
        newProxyInstance.run();

        Runnable newProxyInstance2 = (Runnable) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Runnable.class}, new TraceInvocationHandler(this));
        newProxyInstance2.run();

        System.out.println("End of ProxyExamples");
    }

    public class TraceInvocationHandler implements InvocationHandler {
        final ProxyExamples proxyExamples;

        public TraceInvocationHandler(ProxyExamples proxyExamples) {
            this.proxyExamples = proxyExamples;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Within invocation handler from implementing InvocationHandler class");

            proxyExamples.runFromWithinInvocationHandler();

            return null;
        }
    }
}
