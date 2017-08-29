Instructions to run:

java -jar -Dserver.port=8090 worker-job-matching-API-0.1.0.jar
http://localhost:8090//matches/{workerId}

{workerId} is the guid of the worker.

Example URLs:
1)  URL will return top 3 job matches for worker id
    http://localhost:8090/matches/562f66479f8711e1c6ce94cb
    
2) URL will return 5 job matches for worker id
   http://localhost:8090/matches/562f66479f8711e1c6ce94cb?maxResult=5