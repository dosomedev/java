@echo off

mvn archetype:generate^
    -DgroupId=com.dosomedev^
    -DartifactId=concurrenthashmap-app^
    -DarchetypeArtifactId=maven-archetype-quickstart^
    -DarchetypeVersion=1.4^
    -DinteractiveMode=false
