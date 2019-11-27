## API TEST Framework
Combine with rest assured and testNG for simple api tests.

### Feature
1. Data provider
2. Support multi environments
3. Report
4. Suite

### Build
`./gradlew build`

### Test
* default env - prod: 
`./gradlew clean test`
* local env: 
`./gradlew clean test -Denv=local`
