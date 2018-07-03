package com.dream.myLife.cache.service;

import java.util.Date;
import java.util.Set;

/**
 * Created by zhang on 2018/1/17.
 */
public interface ICacheClient {
    boolean clear(String var1);

    boolean put(String var1, String var2, Object var3);

    boolean put(String var1, String var2, Object var3, Date var4);

    boolean put(String var1, String var2, Object var3, int var4);

    Object get(String var1, String var2);

    boolean remove(String var1, String var2);

    int size(String var1);

    Set<String> keySet(String var1);

    boolean isExist(String var1, String var2);
}