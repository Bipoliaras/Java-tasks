# Java task

# Application overview

The application can be used to get specific conversion rates from a service.

The API becomes available on `http://localhost:8080/camel/api/rates`

# Homework tasks

* Add additional Integration tests for currencies `AUD` and `BAM`

* Integration tests should also verify the conversion rate

* Use the @MockBean annotation to mock external dependencies

* Use the @SQL annotation to clean up the database after each test

* Update the integration tests to check that the database state is correct after each test

# Example CURL requests

`
curl --location --request POST 'http://localhost:8080/camel/api/rates' \
--header 'Content-Type: application/json' \
--data-raw '{
"rateName":"USD"
}'
`
