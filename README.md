# Transactions APP

Saving personal transaction to earnings, payments, budgets, etc..

# Dependencies
postgresql-42.6.0.jar

Created a main table on PostgreSQL for Movements (id, credit, debit, entitie, account, date, category, description, type)
Secondary tables for Registers, Entities, Accounts, Categories.

Using a 3 label business model, I have made a Controller package to communicate with the user

DAO package to create CRUD methods and others for all the tables. This DAO package also has the PostgresConfigs.

Service package which will callout the DAO methods and communicate with the Controller.

*****Still updating the program******
