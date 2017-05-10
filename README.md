# Sample AWS lambda with Java and gradle

The goal of this project is to provide a sample aws lambda using gradle.

It has two handlers doing following:

* `ListHandler` will return a single element list with a random element from passed JSON list. 
Example: for 
`
[
    'apples',
    'oranges',
    'plums',
    'strawberries'
 ]
`
will return 
`
[
   'oranges'
]
`
* `DynamoDBHandler` will try to save all passed elements to a `TEST_TABLE` DynamoDB table. 
Notice that this handler doesnt implement `com.amazonaws.services.lambda.runtime.RequestHandler`.
When deploying, be sure to provide lambda with the role allowing access to DynamoDB table
* all of this will is buildable into zip deployment unit using gradle

## How to build
Simply run `gradle build`
A .zip Deployment Package will be available in `project-dir/build/distributions` directory