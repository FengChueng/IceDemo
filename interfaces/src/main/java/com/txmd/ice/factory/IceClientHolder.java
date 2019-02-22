package com.txmd.ice.factory;

import Ice.ObjectPrx;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class IceClientHolder<T extends ObjectPrx> {

    @Autowired
    private IceClientFactory iceClientFactory;

    public void setIceClientFactory(IceClientFactory iceClientFactory) {
        this.iceClientFactory = iceClientFactory;
    }

    public IceClientFactory getIceClientFactory() {
        return iceClientFactory;
    }

    /**
     * 获取 ObjectPrx 代理对象
     *
     * @param objPrxKey
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getObjPrx(String objPrxKey) {
        return (T) iceClientFactory.getPrxByKey(objPrxKey);
    }

    /**
     * 获取代理对象
     *
     * @return
     */
    protected abstract T getProviderPrx();
}