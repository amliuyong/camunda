#!/usr/bin/env bash


curl -H "Content-Type: application/json" -X POST \
-d '{"variables": {"amount": {"value":555,"type":"long"}, "item": {"value":"item-xyz"} } }' \
 http://localhost:8080/engine-rest/process-definition/key/Process_1if9eba/start



 http://localhost:8080/engine-rest/deployment/create


curl -H "Content-Type: application/json" -X POST  \
-d ' {"messageName" : "UsidorandChuntArriveMessage","businessKey" : "13"}' \
http://localhost:8088/rest/message



curl -X GET http://localhost:8088/rest/task
你

curl  -H "Content-Type: application/json" -X POST http://localhost:8088/rest/decision-definition/key/decideOnBeveage/evaluate \
-d '{
  "variables": {
      "name": { "value": "Dale Cooper", "type": "String" },
      "timeOfDay": { "value": "Morning", "type": "String" }
  }
}'  | python -m json.tool



curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "QuestionCreated",  "businessKey" : "1", "processVariables":  { "question": { "value":  "How do you start a process with a message?", "type": "String" } } }' \


curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "NiallKonws",  "businessKey" : "1", "processVariables":  { "confidence": { "value":  "10, I am confidence!", "type": "String" } } }' \


curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "QuestionEdited",  "businessKey" : "1", "processVariables":  { "question": { "value":  "How far away is the Sun?", "type": "String" } } }' \




curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "QuestionCreated",  "businessKey" : "1", "processVariables":  { "question": { "value":  "Question 1 ?", "type": "String" } } }' \

curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "QuestionCreated",  "businessKey" : "2", "processVariables":  { "question": { "value":  "Question 2 ?", "type": "String" } } }' \


curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "QuestionCreated",  "businessKey" : "3", "processVariables":  { "question": { "value":  "Question 3 ?", "type": "String" } } }' \



curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/message \
-d ' {"messageName" : "NiallHasNoIdea",  "businessKey" : "2" }'



curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/signal \
-d ' {"name" : "importantWork",   "variables":  { "var1": { "value":  "value for var1", "type": "String" } }  }'


curl -H "Content-Type: application/json" -X POST  http://localhost:8088/rest/process-definition/key/BER/start \
-d '{
    "variables": {
        "airportCode": {
            "value": "BER",
            "type": "String"
        },
        "buget": {
            "value": 100000000,
            "type": "Long"
        },
        "OpeningDate": {
            "value": "2020-09-28T00:00:00",
            "type": "String"
        }
    },
    "businessKey": "13"
}'  | python -m json.tool
