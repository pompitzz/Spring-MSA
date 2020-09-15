#!/bin/sh
cd ..

echo "======================== Down ======================="
docker-compose -f ./docker/docker-compose.yml down
