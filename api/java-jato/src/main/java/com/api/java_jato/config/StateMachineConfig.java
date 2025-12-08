package com.api.java_jato.config;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import com.api.java_jato.states.Events;
import com.api.java_jato.states.States;

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

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
                .action(externalWashing())
                .and()
                .withExternal().source(States.EXTERNAL_WASH).target(States.INTERNAL_CLEANING)
                .event(Events.FINISH_INTERNAL_CLEANING)
                .action(internalCleaning())
                .and()
                .withExternal().source(States.INTERNAL_CLEANING).target(States.DETAILING)
                .event(Events.FINISH_INTERNAL_CLEANING)
                .action(detailingAction())
                .and()
                .withExternal().source(States.DETAILING).target(States.WAITING_PAYMENT).event(Events.PAYMENT_RECEIVED)
                .action(waitingPayment())
                .and()
                .withExternal().source(States.WAITING_PAYMENT).target(States.FINISHED).event(Events.FINISHED)
                .action(finished())
                .and()
                .withExternal().source(States.WAITING).target(States.CANCELED).event(Events.REQUEST_CANCELLATION);

    }

    @Bean
    StateMachineListener<States, Events> stateMachineListener() {
        return new StateMachineListenerAdapter<>() {
            @Override
            public void transition(Transition<States, Events> transition) {
                if (transition.getTarget().getId() != null) {
                    System.out.println("Transition from"
                            + (transition.getSource() != null ? transition.getSource().getId() : "none") + " to "
                            + transition.getTarget().getId());
                }
            }
        };
    }

    @Bean
    Action<States, Events> finished() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finished'");
    }

    @Bean
    Action<States, Events> waitingPayment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'waitingPayment'");
    }

    @Bean
    Action<States, Events> externalWashing() {
        return context -> {
            System.out.println("Carro lavando externamente");
        };
    }

    @Bean
    Action<States, Events> internalCleaning() {
        return context -> {
            System.out.println("Carro lavando internamente");
        };
    }

    @Bean
    public Action<States, Events> detailingAction() {
        return context -> {
            String result = "dsasdas";
        };
    }
}
