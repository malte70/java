all: sources packages

sources: helloworld scannerdemo forloop matchstick

packages: sources package_helloworld package_scannerdemo package_forloop package_matchstick

forloop: de/malte_bublitz/itc/forloop/ForLoop.java
	javac de/malte_bublitz/itc/forloop/ForLoop.java

helloworld: de/malte_bublitz/itc/helloworld/HelloWorld.java
	javac de/malte_bublitz/itc/helloworld/HelloWorld.java

scannerdemo: de/malte_bublitz/itc/scannerdemo/ScannerDemo.java
	javac de/malte_bublitz/itc/scannerdemo/ScannerDemo.java

matchstick: de/malte_bublitz/itc/matchstick/Matchstick.java
	javac de/malte_bublitz/itc/matchstick/Matchstick.java

package_helloworld: helloworld manifest_helloworld
	mv META-INF_helloworld META-INF
	jar cvfm ../bin/HelloWorld.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/helloworld/*.class
	mv META-INF META-INF_helloworld
	
package_forloop: forloop manifest_forloop
	mv META-INF_forloop META-INF
	jar cvfm ../bin/ForLoop.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/forloop/*.class
	mv META-INF META-INF_forloop
	
package_scannerdemo: scannerdemo manifest_scannerdemo
	mv META-INF_scannerdemo META-INF
	jar cvfm ../bin/ScannerDemo.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/scannerdemo/*.class
	mv META-INF META-INF_scannerdemo
	
package_matchstick: matchstick manifest_matchstick
	mv META-INF_matchstick META-INF
	jar cvfm ../bin/MatchStick.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/matchstick/*.class
	mv META-INF META-INF_matchstick
	
manifest_helloworld:
	mkdir META-INF_helloworld
	echo "Main-Class: de.malte_bublitz.itc.helloworld.HelloWorld" > META-INF_helloworld/MANIFEST.mf
	
manifest_forloop:
	mkdir META-INF_forloop
	echo "Main-Class: de.malte_bublitz.itc.forloop.ForLoop" > META-INF_forloop/MANIFEST.mf
	
manifest_scannerdemo:
	mkdir META-INF_scannerdemo
	echo "Main-Class: de.malte_bublitz.itc.scannerdemo.ScannerDemo" > META-INF_scannerdemo/MANIFEST.mf
	
manifest_matchstick:
	mkdir META-INF_matchstick
	echo "Main-Class: de.malte_bublitz.itc.matchstick.MatchStick" > META-INF_matchstick/MANIFEST.mf
	
run_helloworld: helloworld package_helloworld
	java -jar ../bin/HelloWorld.jar
	
run_forloop: forloop package_forloop
	java -jar ../bin/ForLoop.jar
	
run_scannerdemo: scannerdemo package_scannerdemo
	java -jar ../bin/ScannerDemo.jar
	
run_matchstick: matchstick package_matchstick
	java -jar ../bin/MatchStick.jar
	
clean:
	rm -rf *.class
	rm -rf META-INF*
	
clean-all: clean
	rm -f ../bin/*.jar
	
