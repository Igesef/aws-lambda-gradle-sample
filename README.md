# Sample AWS lambda with Java and gradle

The goal of this project is to provide a sample aws lambda using gradle.
It will do following:

* for JSON list will return random element as a single element list. Like this:
for 
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
* be buildable into zip deployment unit using gradle

## How to build
Simply run `gradle build`
A .zip Deployment Package will be available in `project-dir/build/distributions` directory