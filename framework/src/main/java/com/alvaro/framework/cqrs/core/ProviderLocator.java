package com.alvaro.framework.cqrs.core;

import com.alvaro.framework.cqrs.core.command.Command;
import com.alvaro.framework.cqrs.core.command.CommandHandler;
import com.alvaro.framework.cqrs.core.command.CommandProvider;
import com.alvaro.framework.cqrs.core.query.Query;
import com.alvaro.framework.cqrs.core.query.QueryHandler;
import com.alvaro.framework.cqrs.core.query.QueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ProviderLocator is a class that is responsible for mapping commands and queries with its handlers.
 * Spring framework should always inject ProviderLocator.
 */
@Component
public class ProviderLocator {

  private final Map<Class<? extends Command>, CommandProvider> commandProviders = new HashMap<>();

  private final Map<Class<? extends Query<?>>, QueryProvider> queryProviders = new HashMap<>();

  @Autowired
  public ProviderLocator(ApplicationContext applicationContext) {
    processCommands(applicationContext);

    processQueries(applicationContext);
  }

  private void processCommands(ApplicationContext applicationContext) {
    String[] names = applicationContext.getBeanNamesForType(CommandHandler.class);
    for (String name : names) {
      registerCommands(applicationContext, name);
    }
  }

  private void processQueries(ApplicationContext applicationContext) {
    String[] names = applicationContext.getBeanNamesForType(QueryHandler.class);
    for (String name : names) {
      registerQueries(applicationContext, name);
    }
  }

  @SuppressWarnings("unchecked")
  private void registerCommands(ApplicationContext applicationContext, String name ){
    Class<CommandHandler<?>> handlerClass = (Class<CommandHandler<?>>) applicationContext.getType(name);
    Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, CommandHandler.class);
    Class<? extends Command> commandType = (Class<? extends Command>) Objects.requireNonNull(generics)[0];
    commandProviders.put(commandType, new CommandProvider<>(applicationContext, handlerClass));
  }

  @SuppressWarnings("unchecked")
  private void registerQueries(ApplicationContext applicationContext, String name ){
    Class<QueryHandler<?, ?>> handlerClass = (Class<QueryHandler<?, ?>>) applicationContext.getType(name);
    Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, QueryHandler.class);
    Class<? extends Query<?>> queryType = (Class<? extends Query<?>>) Objects.requireNonNull(generics)[0];
    queryProviders.put(queryType, new QueryProvider<>(applicationContext, handlerClass));
  }

  @SuppressWarnings("unchecked")
  public <C extends Command> CommandHandler<C> getCommandHandler(Class<C> commandClass) {
    return commandProviders.get(commandClass).get();
  }

  @SuppressWarnings("unchecked")
  public <R extends Query<R>> QueryHandler<Query<R>, R> getQueryHandler(Class<R> queryClass) {
    return queryProviders.get(queryClass).get();
  }

}