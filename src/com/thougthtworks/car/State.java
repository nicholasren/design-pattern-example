package com.thougthtworks.car;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 12/14/11
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public enum State {
//TODO: google god class， OCP, emergent design
//      state pattern - problem domain - common language
    STARTED{
        @Override
        public State transfer(Action action) {
            return action == Action.GEAR ? GEARED : this;
        }
    },
    GEARED{
        @Override
        public State transfer(Action action) {
          return action == Action.RELEASE_BREAK? READY : this;
        }
    },
    READY{
        @Override
        public State transfer(Action action) {
          return action == Action.ACC? MOVE_FORWARD : this;
        }
    },
    MOVE_FORWARD{
        @Override
        public State transfer(Action action) {
           return this;
        }
    },
    STOPPED{
        @Override
        public State transfer(Action action) {
          return action == Action.START ? STARTED : this;
        }
    },
    BROKEN;

    public State transfer(Action action){
        return this;
    };

}
