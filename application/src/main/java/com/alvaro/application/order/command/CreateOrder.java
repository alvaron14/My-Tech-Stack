package com.alvaro.application.order.command;

import com.alvaro.framework.cqrs.core.command.CommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Slf4j
@Component
public class CreateOrder implements CommandHandler<CreateOrderCommand> {

  @Override
  public void doHandle(CreateOrderCommand command) {
    log.info("Time: "  + ZonedDateTime.now() + " | " + command.toString());
  }
}
