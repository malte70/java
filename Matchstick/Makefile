all: manifest matchstick build_jar

matchstick: de/malte70/itc/matchstick/Matchstick.java
	javac de/malte70/itc/matchstick/Matchstick.java

build_jar: matchstick
	jar cvfm bin/Matchstick.jar META-INF/MANIFEST.mf de/malte70/itc/matchstick/*.class

manifest:
	mkdir META-INF
	echo "Main-Class: de.malte70.itc.matchstick.Matchstick" > META-INF/MANIFEST.mf

run:
	java -jar bin/Matchstick.jar

clean:
	rm -f de/malte70/itc/matchstick/*.class

clean-all: clean
	rm -f bin/*.jar
	rm -rf META-INF
