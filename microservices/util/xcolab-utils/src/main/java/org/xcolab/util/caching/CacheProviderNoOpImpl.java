package org.xcolab.util.caching;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import java.util.concurrent.Future;

public class CacheProviderNoOpImpl implements CacheProvider {

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public Future<Boolean> add(String key, int exp, Object o) {
        return ConcurrentUtils.constantFuture(false);
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
