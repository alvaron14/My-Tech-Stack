package com.alvaro.infrastructure.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class JpaNamingStrategyConfig extends CamelCaseToUnderscoresNamingStrategy {

  private static final String TABLE_SUFFIX = "JpaEntity";

  @Override
  public Identifier toPhysicalTableName(final Identifier logicalName, final JdbcEnvironment jdbcEnvironment) {
    return super.toPhysicalTableName(this.updateTableIdentifier(logicalName), jdbcEnvironment);
  }

  private Identifier updateTableIdentifier(final Identifier identifier) {
    final var text = identifier.getText();
    if (text.endsWith(TABLE_SUFFIX)) {
      final String tableName = "\""
          + text.replace(TABLE_SUFFIX, "")
          + "\"";
      return Identifier.toIdentifier(tableName, true);
    }
    return identifier;
  }

}
