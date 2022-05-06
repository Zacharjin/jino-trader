package org.jinoware.trader.loader.data.model;

@FunctionalInterface
public interface UpdatePrice<T> {

    void changePrice(T price);

}
