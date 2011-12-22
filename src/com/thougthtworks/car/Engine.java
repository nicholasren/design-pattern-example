package com.thougthtworks.car;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 12/14/11
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Engine {
    private State state = State.STOPPED;

    public State state() {
        return this.state;
    }

    public Engine operate(Action action){
        this.state = this.state.transfer(action);
        return this;
    }

    public Engine state(State state) {
        this.state = state;
        return this;
    }
}
