# GoldPassword engine

[![](https://jitpack.io/v/PWManager/GoldPassword.svg)](https://jitpack.io/#PWManager/GoldPassword)

# A tool for creating a password managers

## Connecting

- Connect jitpack
- Connect GoldPassword Engine

### For gradle (Groovy DSL)
```groovy
	repositories {
	    mavenCentral()
	    maven { url 'https://jitpack.io' }
	}
```

And connect

```groovy
	dependencies {
	        implementation 'com.github.PWManager:GoldPassword:bb2850f'
	}
```

### For gradle (Kotlin DSL)

```kotlin
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
```

And connect

```kotlin
	dependencies {
	        implementation("com.github.PWManager:GoldPassword:bb2850f")
	}
```

### For maven

```maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

And connect

```maven
	<dependency>
	    <groupId>com.github.PWManager</groupId>
	    <artifactId>GoldPassword</artifactId>
	    <version>bb2850f</version>
	</dependency>
```

## Using

```java

import org.pwmanager.goldpass.GoldPassword;

public class Main {
    static GoldPassword manager = new GoldPassword();

    public static void main(String[] args) throws Exception {
        manager.initialize();
        manager.savePassword("example.com", "password123");
        System.out.println(manager.viewPasswords());
    }
}

```
