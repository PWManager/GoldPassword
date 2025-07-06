# GoldPassword engine

[![](https://jitpack.io/v/PWManager/GoldPassword.svg)](https://jitpack.io/#PWManager/GoldPassword)

# A tool for creating a password managers

## Connecting

- Connect jitpack
- Connect GoldPassword Engine

### For gradle (Groovy DSL)
``
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
``

And connect

``
	dependencies {
	        implementation 'com.github.PWManager:GoldPassword:bb2850f'
	}
``

### For gradle (Kotlin DSL)

``
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
``

And connect

``
	dependencies {
	        implementation("com.github.PWManager:GoldPassword:bb2850f")
	}
``

### For maven

``
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
``

And connect

``
	<dependency>
	    <groupId>com.github.PWManager</groupId>
	    <artifactId>GoldPassword</artifactId>
	    <version>bb2850f</version>
	</dependency>
``
