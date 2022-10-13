package org.example;

import lombok.SneakyThrows;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("org.example");


    private ObjectFactory() {
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

        return implClass.getDeclaredConstructor().newInstance();
    }
}
