# code-quality-challeng-01

Configuration class is simply an ID and a bunch of URLs. One Configuration can be always valid but validation requires for a list of configurations. That is what is happening inside ConfigurationValidator class.

One validation rule is that not have duplicate IDs. This rule has been implemented and the test case is succeeding. The second rule is not to have duplicate URLs among the list of the 
configurations. There is a test case for this but the validation has not been implemented.

1. Implement the second rule 
2. Refactor/enhance anything in the existing rule, or tests.