package com.thoughtworks.car;

import com.thougthtworks.car.Action;
import com.thougthtworks.car.Engine;
import com.thougthtworks.car.State;
import org.junit.Before;
import org.junit.Test;

import static com.thougthtworks.car.Action.*;
import static com.thougthtworks.car.State.*;
import static com.thougthtworks.car.State.BROKEN;
import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: reaapi
 * Date: 12/14/11
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class EngineTest {

    private Engine engine;

    @Before
    public void setUp(){
        engine = new Engine();
    }

    @Test
    public void should_be_started_if_start(){
        engine.operate(START);
        assertEquals(STARTED, engine.state());
    }

    @Test
    public void should_be_stopped_if_do_nothing(){
        assertEquals(STOPPED, engine.state());
    }

    @Test
    public void should_be_stopped_if_acc(){
       engine.operate(ACC);
       assertEquals(STOPPED, engine.state());
    }

    @Test
    public void should_be_geared_if_acc_when_started(){
      engine.operate(START).operate(GEAR);
      assertEquals(GEARED, engine.state());
    }

    @Test
    public void should_be_geared_if_acc_when_geared(){
      engine.operate(START).operate(GEAR).operate(ACC);
      assertEquals(GEARED, engine.state());
    }

    @Test
    public void should_be_ready_if_release_break_when_geared(){
      engine.operate(START).operate(GEAR).operate(RELEASE_BREAK);
      assertEquals(READY, engine.state());
    }
    @Test
    public void should_be_move_forward_if_acc_when_ready(){
      engine.operate(START).operate(GEAR).operate(RELEASE_BREAK).operate(ACC);
      assertEquals(MOVE_FORWARD, engine.state());
    }

    @Test
    public void should_not_response_if_broken(){
        assertEquals(BROKEN, engine.state(BROKEN).operate(START).state());
    }
}
