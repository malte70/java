all: sources packages

sources: compile_helloworld compile_scannerdemo compile_forloop compile_matchstick compile_kontoauszug

packages: sources package_helloworld package_scannerdemo package_forloop package_matchstick package_kontoauszug

kontoauszug: clean compile_kontoauszug package_kontoauszug run_kontoauszug

compile_forloop: de/malte_bublitz/itc/forloop/ForLoop.java
	@echo "[JAVAC]    de/malte_bublitz/itc/forloop/ForLoop.java"
	@javac de/malte_bublitz/itc/forloop/ForLoop.java

compile_helloworld: de/malte_bublitz/itc/helloworld/HelloWorld.java
	@echo "[JAVAC]    de/malte_bublitz/itc/helloworld/HelloWorld.java"
	@javac de/malte_bublitz/itc/helloworld/HelloWorld.java

compile_scannerdemo: de/malte_bublitz/itc/scannerdemo/ScannerDemo.java
	@echo "[JAVAC]    de/malte_bublitz/itc/scannerdemo/ScannerDemo.java"
	@javac de/malte_bublitz/itc/scannerdemo/ScannerDemo.java

compile_matchstick: de/malte_bublitz/itc/matchstick/Matchstick.java
	@echo "[JAVAC]    de/malte_bublitz/itc/matchstick/Matchstick.java"
	@javac de/malte_bublitz/itc/matchstick/Matchstick.java

compile_kontoauszug: de/malte_bublitz/itc/kontoauszug/Buchung.java de/malte_bublitz/itc/kontoauszug/Konto.java de/malte_bublitz/itc/kontoauszug/Kontoauszug.java
	@echo "[JAVAC]    de.malte_bublitz.itc.kontoauszug.Buchung"
	@javac -cp \*:.:../../java-util/bin/ANSIConsole.jar:/usr/share/java/mysql-connector-java-bin.jar de/malte_bublitz/itc/kontoauszug/Buchung.java
	@echo "[JAVAC]    de.malte_bublitz.itc.kontoauszug.Konto"
	@javac -cp \*:.:../../java-util/bin/ANSIConsole.jar:/usr/share/java/mysql-connector-java-bin.jar de/malte_bublitz/itc/kontoauszug/Konto.java
	@echo "[JAVAC]    de.malte_bublitz.itc.kontoauszug.Kontoauszug"
	@javac -cp \*:.:../../java-util/bin/ANSIConsole.jar:/usr/share/java/mysql-connector-java-bin.jar de/malte_bublitz/itc/kontoauszug/Kontoauszug.java

package_helloworld: compile_helloworld manifest_helloworld
	@echo "[JAR]      ../bin/HelloWorld.jar"
	@mv META-INF_helloworld META-INF
	@jar cvfm ../bin/HelloWorld.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/helloworld/*.class >/dev/null
	@mv META-INF META-INF_helloworld
	
package_forloop: compile_forloop manifest_forloop
	@echo "[JAR]      ../bin/ForLoop.jar"
	@mv META-INF_forloop META-INF
	@jar cvfm ../bin/ForLoop.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/forloop/*.class >/dev/null
	@mv META-INF META-INF_forloop
	
package_scannerdemo: compile_scannerdemo manifest_scannerdemo
	@echo "[JAR]      ../bin/ScannerDemo.jar"
	@mv META-INF_scannerdemo META-INF
	@jar cvfm ../bin/ScannerDemo.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/scannerdemo/*.class >/dev/null
	@mv META-INF META-INF_scannerdemo
	
package_matchstick: compile_matchstick manifest_matchstick
	@echo "[JAR]      ../bin/MatchStick.jar"
	@mv META-INF_matchstick META-INF
	@jar cvfm ../bin/MatchStick.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/matchstick/*.class >/dev/null
	@mv META-INF META-INF_matchstick
	
package_kontoauszug: compile_kontoauszug
	@echo "[MANIFEST]"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.kontoauszug.Kontoauszug" > META-INF/MANIFEST.mf
	@echo "[JAR]      bin/Kontoauszug.jar"
	@cp ../../java-util/bin/ANSIConsole.jar ../bin
	@cp /usr/share/java/mysql-connector-java-bin.jar ../bin/
	@jar cvfm ../bin/Kontoauszug.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/kontoauszug/*.class >/dev/null
	@rm -rf META-INF 
#@echo 'Class-Path: lib/*.jar' >> META-INF/MANIFEST.mf
	
manifest_helloworld:
	@echo "[MANIFEST] helloworld"
	@mkdir META-INF_helloworld
	@echo "Main-Class: de.malte_bublitz.itc.helloworld.HelloWorld" > META-INF_helloworld/MANIFEST.mf
	
manifest_forloop:
	@echo "[MANIFEST] forloop"
	@mkdir META-INF_forloop
	@echo "Main-Class: de.malte_bublitz.itc.forloop.ForLoop" > META-INF_forloop/MANIFEST.mf
	
manifest_scannerdemo:
	@echo "[MANIFEST] scannerdemo"
	@mkdir META-INF_scannerdemo
	@echo "Main-Class: de.malte_bublitz.itc.scannerdemo.ScannerDemo" > META-INF_scannerdemo/MANIFEST.mf
	
manifest_matchstick:
	@echo "[MANIFEST] matchstick"
	@mkdir META-INF_matchstick
	@echo "Main-Class: de.malte_bublitz.itc.matchstick.MatchStick" > META-INF_matchstick/MANIFEST.mf
	
run_helloworld: helloworld package_helloworld
	@echo "[RUN]      HelloWorld.jar"
	@java -jar ../bin/HelloWorld.jar
	
run_forloop: forloop package_forloop
	@echo "[RUN]      ForLoop.jar"
	@java -jar ../bin/ForLoop.jar
	
run_scannerdemo: scannerdemo package_scannerdemo
	@echo "[RUN]      ScannerDemo.jar"
	@java -jar ../bin/ScannerDemo.jar
	
run_matchstick: matchstick package_matchstick
	@echo "[RUN]      MatchStick.jar"
	@java -jar ../bin/MatchStick.jar
	
run_kontoauszug: package_kontoauszug
	@echo "[RUN]      bin/Kontoauszug.jar"
	@java -jar ../bin/Kontoauszug.jar
	
clean:
	@echo "[CLEAN]"
	@rm -rf *.class
	@rm -rf META-INF*
	@rm -f ../bin/*.jar
	
