FROM openjdk:11 as builder
WORKDIR /app
COPY . .
RUN ls
RUN sh ./gradlew build


FROM openjdk:11  
WORKDIR /root/
COPY --from=builder /app/application/build/libs/application.jar ./
CMD ["java","-jar","application.jar"] 
