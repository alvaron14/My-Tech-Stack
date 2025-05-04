package com.alvaro.framework.cqrs.core.command;

import org.springframework.stereotype.Service;

@Service
public interface CommandHandler<K extends Command> {

  default void execute(final K command) {
    doHandle(command);
  }

  void doHandle(K command);

}
