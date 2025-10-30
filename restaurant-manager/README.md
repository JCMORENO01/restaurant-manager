# Restaurant Manager

Proyecto Maven generado con maven-archetype-quickstart versión 1.4.

## Estructura del proyecto

```
restaurant-manager/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── restaurant/
│   │               └── manager/
│   │                   └── App.java
│   └── test/
│       └── java/
│           └── com/
│               └── restaurant/
│                   └── manager/
│                       └── AppTest.java
└── README.md
```

## Compilar y ejecutar

Si tienes Maven instalado:

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.restaurant.manager.App"
```

Sin Maven, puedes compilar manualmente con `javac` si tienes Java instalado.

## Información del proyecto

- **groupId**: com.restaurant.manager
- **artifactId**: restaurant-manager
- **version**: 1.0-SNAPSHOT
- **Java version**: 1.7 (configurable en pom.xml)
