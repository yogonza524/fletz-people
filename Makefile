clean:
	./gradlew clean

build: assemble
	./gradlew pmdMain pmdTest build
	
pmd:
	./gradlew pmdMain pmdTest

assemble:
	./gradlew clean assemble $(ARG)

run: build
	java -jar $(JVM_ARG) build/libs/*.jar

dependencies:
	./gradlew --refresh-dependencies build
