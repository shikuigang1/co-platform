package com.co.back.config;

import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * @auther skg
 * @Date: 2019/11/29
 */
@Configuration
public class RepxCache {

        private static final Map<String,Pattern> repxCache = new ConcurrentHashMap<>();

        public static void add(String key,Pattern pattern){
            repxCache.put(key,pattern);
        }

        public static void update(String key,Pattern pattern){

            if(repxCache.containsKey(key)){
                repxCache.replace(key,pattern);
            }else{
                repxCache.put(key, pattern);
            }
        }
        public static void remove(String key){
            repxCache.remove(key);
        }

        public static Pattern get(String key){
            return repxCache.get(key);
        }

        public static void init(){
            add("1",Pattern.compile(""));
            add("2",Pattern.compile(""));
            add("3",Pattern.compile(""));
            add("4",Pattern.compile(""));
            add("5",Pattern.compile(""));
        }
}
