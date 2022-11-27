package com.example.demo.commom.designMode.factoryModel.abstractFactoryModel;

//小米工厂实现类
public class XiaomiFactory implements IProductFactory {

    @Override
    public IPhoneProduct phoneProduct() {
    	return new XiaomiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
	return new XiaomiRouter();
    }
}
