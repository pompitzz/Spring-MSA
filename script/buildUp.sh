#!/bin/sh
cd ..

echo "======================== Down ======================="
docker-compose -f ./docker/docker-compose.yml down

echo "======================= Build ========================"
./gradlew docker

echo "======================= Up =========================="
docker-compose -f ./docker/docker-compose.yml up
