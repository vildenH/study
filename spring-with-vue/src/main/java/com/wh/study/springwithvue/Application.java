package com.wh.study.springwithvue;

import com.wh.study.springwithvue.statemachine.Events;
import com.wh.study.springwithvue.statemachine.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.statemachine.StateMachine;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Autowired
  private StateMachine<States, Events> stateMachine;

  @Override
  public void run(String... args) throws Exception {
    stateMachine.start();
    stateMachine.sendEvent(Events.PAY);
    stateMachine.sendEvent(Events.RECEIVE);
  }
}
