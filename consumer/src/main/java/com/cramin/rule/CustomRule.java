package com.cramin.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author ChengRuimin
 * @date: 2019/10/29 17:06
 * @description:
 */
public class CustomRule extends AbstractLoadBalancerRule {

    private int total = 0;
    private int index = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }

    public Server choose(ILoadBalancer lb, Object o) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            if (allList.size() == 0) {
               return null;
            }
            total ++;
            if (total >= 5) {
                total = 0;
                index = (index + 1) % upList.size();
            }
            server = upList.get(index);

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return server;
            }
        }
        return server;
    }
}
