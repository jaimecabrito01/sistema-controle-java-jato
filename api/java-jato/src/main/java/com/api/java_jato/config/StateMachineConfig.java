package com.api.java_jato.config;

import java.lang.Thread.State;
import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.api.java_jato.states.Events;
import com.api.java_jato.states.States;

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States,Events>{

        
     @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
       
                states.withStates()
                .initial(States.WAITING)
                .states(EnumSet.allOf(States.class))
                .end(States.FINISHED)
                .end(States.CANCELED);

    }
    @Override
     public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions.withExternal().source(States.WAITING).target(States.EXTERNAL_WASH).event(Events.START_SERVICE)
        .and()
        .withExternal().source(States.EXTERNAL_WASH).target(States.INTERNAL_CLEANING).event(Events.FINISH_INTERNAL_CLEANING)
        .and()
        .withExternal().source(States.INTERNAL_CLEANING).target(States.DETAILING).event(Events.FINISH_INTERNAL_CLEANING)
        .and()
        .withExternal().source(States.DETAILING).target(States.WAITING_PAYMENT).event(Events.PAYMENT_RECEIVED)
        .and()
        .withExternal().source(States.WAITING_PAYMENT).target(States.FINISHED).event(Events.FINISHED)
        .and()
        .withExternal().source(States.WAITING).target(States.CANCELED).event(Events.REQUEST_CANCELLATION);
      
    

}
