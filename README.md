# example-spring-boot-application-from-swagger

Example of use [Yeoman generator-spring-boot-application-from-swagger](https://github.com/mobulum/npm-yo-generator-spring-boot-application-from-swagger)

```bash
npm install -g yo
npm install -g generator-spring-boot-application-from-swagger
```

```bash
yo spring-boot-application-from-swagger

? Enter default base package name: com.mobulum
? Enter base name of app: app
? Enter controller class suffix: Controller
? Path (or URL) to swagger document: http://petstore.swagger.io/v2/swagger.json
```

Generated file structure for given example looks like this

```
├── api
│   ├── build.gradle
│   └── src
│       ├── integrationTest
│       │   └── groovy
│       │       └── com
│       │           └── mobulum
│       │               └── api
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── mobulum
│       │   │           └── api
│       │   │               └── model
│       │   │                   ├── Category.java
│       │   │                   ├── ErrorInfoResponse.java
│       │   │                   ├── Order.java
│       │   │                   ├── OrderStatus.java
│       │   │                   ├── Pet.java
│       │   │                   ├── PetStatus.java
│       │   │                   ├── Tag.java
│       │   │                   ├── UploadResponse.java
│       │   │                   └── User.java
│       │   └── resources
│       └── test
│           └── groovy
│               └── com
│                   └── mobulum
│                       └── api
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── service
│   ├── build.gradle
│   └── src
│       ├── integrationTest
│       │   └── groovy
│       │       └── com
│       │           └── mobulum
│       │               └── service
│       │                   ├── ApplicationIntegrationSpec.groovy
│       │                   └── rest
│       │                       └── controllers
│       │                           ├── AbstractRestControllerIntegrationSpec.groovy
│       │                           ├── V2PetControllerIntegrationSpec.groovy
│       │                           ├── V2StoreControllerIntegrationSpec.groovy
│       │                           └── V2UserControllerIntegrationSpec.groovy
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── mobulum
│       │   │           └── service
│       │   │               ├── Application.java
│       │   │               └── rest
│       │   │                   └── controllers
│       │   │                       ├── V2PetController.java
│       │   │                       ├── V2StoreController.java
│       │   │                       └── V2UserController.java
│       │   └── resources
│       │       └── application.yml
│       └── test
│           └── groovy
│               └── com
│                   └── mobulum
│                       └── service
│                           └── rest
│                               └── controllers
│                                   ├── V2PetControllerSpec.groovy
│                                   ├── V2StoreControllerSpec.groovy
│                                   └── V2UserControllerSpec.groovy
└── settings.gradle

45 directories, 31 files
```

## License

MIT © [Zenedith](http://mobulum.com)