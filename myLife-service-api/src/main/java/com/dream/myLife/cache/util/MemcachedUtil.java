package com.dream.myLife.cache.util;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.stereotype.Service;

/**
 * Created by zhang on 2018/1/18.
 */
public class MemcachedUtil {
    private static MemcachedClient memcachedClient;

    public static MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }

    public static void setMemcachedClient(MemcachedClient memcachedClient) {
        MemcachedUtil.memcachedClient = memcachedClient;
    }
}
