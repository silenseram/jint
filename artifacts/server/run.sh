bash /app/wait_for.sh jsqldb:3306 -t 0 -s --;

echo "database ready";

java -jar /app/server.jar --spring.config.location=/app/application.properties;