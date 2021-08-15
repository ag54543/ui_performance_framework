call gradlew clean assemble 

call gradlew -Dcucumber.options="--tags @Perf" -Dproperties="serenity.properties" test aggregate