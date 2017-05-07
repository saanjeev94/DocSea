# README  SERVER#

### How do I get set up? ###


1. Open project as Gradle Project. (auto-import enable)

2. Create database name 'docsea'
				
3. Run server

	> gradle bootRun

Folder Structure :

org.itglance.docsea
├── src                               
	├── │java                         
   			├── domain  (entity class)
			├── repository	(jpa repository)
			├──service     (service with business logic)
				├──dto		(DTO)
			├──web
				├──rest   (Controller)
	


