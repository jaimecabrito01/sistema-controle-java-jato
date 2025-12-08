package com.api.java_jato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

import com.api.java_jato.states.Events;
import com.api.java_jato.states.States;

import reactor.core.publisher.Mono;

@Service
public class StateMachineService {
    @Autowired
    private StateMachineFactory<States, Events> stateMachineFactory;
    private StateMachine<States, Events> stateMachine;

    public void newQueue() {
        initQueueSaga();
        waitingQueue();

    }

    private void waitingQueue() {
        // TODO Auto-generated method stub
        System.out.println("Car waiting for wash");
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(Events.START_SERVICE).build()))
                .subscribe(result -> System.out.println(result.getResultType()));
        System.out.println("Final state:" + stateMachine.getState().getId());

    }

    private void initQueueSaga() {
        // TODO Auto-generated method stub
        System.out.println("Initizalizing queue");
        stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.startReactively().subscribe();
        System.out.println("Final state: " + stateMachine.getState().getId());

    }

    private void finishExternal() {
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(Events.FINISH_EXTERNAL_WASH).build()))
                .subscribe(result -> result.getResultType());

    }

    private void finishInternalWash() {
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(
                        Events.FINISH_INTERNAL_CLEANING)
                        .build()))
                .subscribe(result -> result.getResultType());
    }
    private void  finishDetailing(){
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(
                        Events.FINISH_DETAILING)
                        .build()))
                .subscribe(result -> result.getResultType());
    }
    private void paymentReceived(){
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(
                        Events.PAYMENT_RECEIVED)
                        .build()))
                .subscribe(result -> result.getResultType());
    }
    private void finishedService(){
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(
                        Events.FINISHED)
                        .build()))
                .subscribe(result -> result.getResultType());
                stopService();
    }

    private void stopService() {
      stateMachine.stopReactively().subscribe();
    }


}
