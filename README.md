# Project Title
Transactions APP

Saving personal transaction to track my earnings, payments, budgets, etc..

# Dependencies
postgresql-42.6.0.jar

I have created a main table on DBeaver for Movements (id, credit, debit, entitie, account, date, category, description, type)
Secondary tables for Entities, Accounts, Categories.

Using a 3 label business model, I have made a Controller package to communicate with the user

DAO package to create CRUD methods for all the tables. This DAO package also has the PostgresConfigs in order to connect to my Database

Service package which will callout the DAO methods and communicate with the Controller.

**Still updating the programm**
