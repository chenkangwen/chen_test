package com.example.demo.commom.designMode.factoryModel.methodFactoryModel;

import com.example.demo.commom.designMode.factoryModel.methodFactoryModel.Game;
import com.example.demo.commom.designMode.factoryModel.methodFactoryModel.GameFactory;
import com.example.demo.commom.designMode.factoryModel.methodFactoryModel.LOL;

public class LOLGameFactory implements GameFactory {


    @Override
    public Game getGame() {
        return new LOL();
    }
}
