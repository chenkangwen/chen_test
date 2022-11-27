package com.example.demo.commom.designMode.factoryModel.methodFactoryModel;

import com.example.demo.commom.designMode.factoryModel.methodFactoryModel.Game;

public class LOL implements Game {
    @Override
    public void getGameName() {
        System.out.println("英雄联盟");
    }
}
