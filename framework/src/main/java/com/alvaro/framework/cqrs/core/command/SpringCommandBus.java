package com.alvaro.framework.cqrs.core.command;

import com.alvaro.framework.cqrs.core.ProviderLocator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring backed Command Bus.
 */
@Component
@RequiredArgsConstructor
public class SpringCommandBus implements CommandBus {

  private final ProviderLocator providerLocator;

  @Override
  @SuppressWarnings("unchecked")
  public <K extends Command> void execute(K command) {
    CommandHandler<K> commandHandler = (CommandHandler<K>) providerLocator.getCommandHandler(command.getClass());
    commandHandler.execute(command);
  }
}