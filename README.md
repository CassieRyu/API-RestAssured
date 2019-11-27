## API TEST Framework
Combine with rest assured and testNG for simple api tests.

### Feature
 
1. Support multi environments
2. Report
3. Suite, Data provider

### Build
`./gradlew build`

### Test
* default env - prod: 
`./gradlew clean test`
* local env: 
`./gradlew clean test -Denv=local`
