package com.alvaro.framework.cqrs.core.command;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;

@RequiredArgsConstructor
public class CommandProvider<H extends CommandHandler<?>> {

  private final ApplicationContext applicationContext;

  private final Class<H> commandHandler;

  public H get() {
    return applicationContext.getBean(commandHandler);
  }
}