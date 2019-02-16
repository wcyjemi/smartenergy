package xin.cymall.common.utils;

import net.sf.ehcache.CacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

public class EhcacheUtil {

    public static EhCacheCacheManager ehCacheManager = SpringContextUtils.getBean("ehCacheCacheManager",EhCacheCacheManager.class);
    public static String get(String key,String cacheKey) throws CacheException {
        String result;
        Cache cache = ehCacheManager.getCache(cacheKey);
        Cache.ValueWrapper value = cache.get(key);
        if (value == null) {
            result = "";
        } else {
            result = value.get().toString();
        }
        return result;
    }

    public static String put(String key, String value, String cacheKey) throws CacheException {
        Cache cache = ehCacheManager.getCache(cacheKey);
        cache.put(key, value);
        return value;
    }

    public static String remove(String key, String cacheKey) throws CacheException {
        Cache cache = ehCacheManager.getCache(cacheKey);
        String previous = get(key,cacheKey);
        cache.evict(key);
        return previous;
    }

    public static void clear(String cacheKey) throws CacheException {
        Cache cache = ehCacheManager.getCache(cacheKey);
        cache.clear();
    }
}
