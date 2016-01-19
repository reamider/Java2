#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy jeesecdemo
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/jeesecdemo.war
