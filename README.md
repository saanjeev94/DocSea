### DocSea #### README  SERVER#

### How do I get set up? ###


1. Open project as Gradle Project. (auto-import enable)

2. Create database name 'docsea'  (edit application.properties file's password)
				
3. Run server



        > change directory to server

	> gradle bootRun

Folder Structure :


```
#!java

org.itglance.docsea
├── src                               
	├── │java                         
   			├── domain  (entity class)
			├── repository	(jpa repository)
			├──service     (service with business logic)
				├──dto		(DTO)
			├──web
				├──rest   (Controller)
```