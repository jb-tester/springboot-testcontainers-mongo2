MongoDB: Debug datasource is not created
https://youtrack.jetbrains.com/issue/IDEA-365778/Spring-Debugger-the-debug-datasource-is-not-created-for-MongoDB


Expected:
SpringbootTestcontainersMongoApplication:
connection properties from application.properties

MongoTest:
with `@DynamicPropertySource` that specifies the non-default database name
the testcontainer is created with a random port, database name == `testdb`

AppTest:
random port, default database `test`


