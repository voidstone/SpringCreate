package org.example;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;


    private ObjectFactory() {
        config = new JavaConfig("org.example",new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
    }

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type)  {
        Class<? extends T> implClass = type;
        if(type.isInterface()) {
            implClass = config.getImpClass(type);
        }

        T t =  implClass.getDeclaredConstructor().newInstance();


        return t;
    }
}
