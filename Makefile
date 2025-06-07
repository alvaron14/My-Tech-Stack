help:
	@echo "create-migration: Create a migration script"
	@echo "update-db: Launch themis migrations on local database"
	@echo "drop-db: Drop the local database"

create-migration:
	@echo "Creating migration script"
	mvn -B -f infrastructure/pom.xml clean compile liquibase:diff

update-db:
	@echo "Updating database with migration scripts"
	mvn -B -f infrastructure/pom.xml clean compile liquibase:update

drop-db:
	@echo "Nuke the database"
	mvn -B liquibase:dropAll