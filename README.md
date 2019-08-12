# Amazon Keyword Score     
Project created for Sellics tech challenge, to calculate score for keywords amazon.

# StartUP Application: 
1. Into Root Folder：
   ```sh
    $ mvn clean install
    ```
2. Run Application
   ```sh
   $ java -jar target/tech-challenger-${version}.jar
   ```
   
   
## API: 

### Endpoints: 


```sh
http://localhost:8080/estimate?keyword=${keyword}
```

#### Return

```sh
{
    "Keyword":"iphone charger",
    "score":88
}
```
[![| width=20](https://swagger.io/swagger/media/assets/images/swagger_logo.svg)](doc-swager-api.yaml)


