package com.sketchproject.strategy;

import com.sketchproject.strategy.behaviors.flies.FlyRocketPowered;
import com.sketchproject.strategy.ducks.DecoyDuck;
import com.sketchproject.strategy.ducks.MallardDuck;
import com.sketchproject.strategy.ducks.ModelDuck;
import com.sketchproject.strategy.ducks.RubberDuck;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        MallardDuck mallard = new MallardDuck();
        RubberDuck rubberDuckie = new RubberDuck();
        DecoyDuck decoy = new DecoyDuck();

        ModelDuck model = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
