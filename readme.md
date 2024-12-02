### docker commands <br>

1. docker --version <br>
2. docker image ls <br>
3. docker container ls <br>
4. docker ps <br>
5. docker ps -a <br>
6. docker build -t darryl1975/vttp5b-ssf-day18l:0.0.1 . <br>
7. docker run -d -p 8085:4000 darryl1975/vttp5b-ssf-day18l:0.0.1 <br>
8. docker stop <first 4 characters of the container id to stop> <br>
9. docker rm <first 4 characters of the container id to stop> <br>
10. docker rmi <image id> <br>
11. docker system prune


### railway

1. railway login --browserless (in project root, login to railway)
2. railway link (in project root, link to railway enivronment to deploy your app)
3. railway up (deploying your app to railway)
