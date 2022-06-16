##Character Controller
1. GET findById = Retorna o character por id OK
2. GET pageAll = Retorna lista de todos os personagens paginada. OK

##CharacterBuilt Controller
2. GET findBuildDetailsById = retorna uma build por id contendo todas as informações da build. (OK)
3. GET pageAll = retorna a lista de builds por user de forma resumida. (OK)
4. PUT updateBuild = Faz alterações em uma build
5. DELETE deleteById = exclui uma build por id
6. POST createBuild = cria uma build por userId (OK)

##Character Job
1. GET listByCharacterId = Lista todos os jobs de um personagem (OK)

##Equipment
1. GET findById = Retorna um equipamento (OK)
2. GET pageAll = retorna lista paginada de todos os equipmanentos (OK)

##Esper
1. GET findById = Retorna um Esper por id. (OK)
2. GET pageAll = Retorna lista paginada de todos os espers (OK)

##Job
1. GET findById = retorna um job por id. (OK)

##Reaction
1. GET findById = Retorna uma reaction by id; (OK)
2. GET listByCharacterId = retorna as reactions de um personagem (OK)

##Support Ability
1. GET findById = Retorna uma reaction by id (OK)
2. GET listByCharacterId = retorna todas as support abilities de um personagem. (OK)

##Vision Card
1. GET findById = retorna uma visioncard por id (OK)
2. GET pageAll = retorna uma lista paginada de todos os visioncards (OK)


Rodar o Zookeeper a partir da pasta kafka

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Rodar Kafka a partir da pasta kafka

.\bin\windows\kafka-server-start.bat .\config\server.properties

Entities = classes de dominio
Use Cases = Commands que trabalham com os Processors
