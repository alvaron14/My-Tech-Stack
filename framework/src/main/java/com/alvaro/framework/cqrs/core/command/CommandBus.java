package com.alvaro.framework.cqrs.core.command;

public interface CommandBus {

  <K extends Command> void execute(final K command);

}
