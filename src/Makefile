all: sources packages

sources: compile_helloworld compile_scannerdemo compile_forloop compile_matchstick compile_kontoauszug compile_buecherverwaltung compile_vokabeltrainer

packages: sources package_helloworld package_scannerdemo package_forloop package_matchstick package_kontoauszug package_buecherverwaltung package_vokabeltrainer

kontoauszug: clean compile_kontoauszug package_kontoauszug run_kontoauszug

buecherverwaltung: clean compile_buecherverwaltung package_buecherverwaltung run_buecherverwaltung

vokabeltrainer: clean compile_vokabeltrainer package_vokabeltrainer run_vokabeltrainer

compile_forloop: de/malte_bublitz/itc/forloop/ForLoop.java
	@echo "[JAVAC]    de.malte_bublitz.itc.forloop.ForLoop.java"
	@javac de/malte_bublitz/itc/forloop/ForLoop.java

compile_helloworld: de/malte_bublitz/itc/helloworld/HelloWorld.java
	@echo "[JAVAC]    de.malte_bublitz.itc.helloworld.HelloWorld.java"
	@javac de/malte_bublitz/itc/helloworld/HelloWorld.java

compile_scannerdemo: de/malte_bublitz/itc/scannerdemo/ScannerDemo.java
	@echo "[JAVAC]    de.malte_bublitz.itc.scannerdemo.ScannerDemo.java"
	@javac de/malte_bublitz/itc/scannerdemo/ScannerDemo.java

compile_matchstick: de/malte_bublitz/itc/matchstick/Matchstick.java
	@echo "[JAVAC]    de.malte_bublitz.itc.matchstick.Matchstick.java"
	@javac de/malte_bublitz/itc/matchstick/Matchstick.java

compile_kontoauszug: de/malte_bublitz/itc/kontoauszug/Buchung.java de/malte_bublitz/itc/kontoauszug/Konto.java de/malte_bublitz/itc/kontoauszug/Kontoauszug.java
	@echo "[JAVAC]    de.malte_bublitz.itc.kontoauszug.Buchung"
	@javac -cp \*:.:../../java-util/bin/ANSIConsole.jar:/usr/share/java/mysql-connector-java-bin.jar de/malte_bublitz/itc/kontoauszug/Buchung.java
	@echo "[JAVAC]    de.malte_bublitz.itc.kontoauszug.Konto"
	@javac -cp \*:.:../../java-util/bin/ANSIConsole.jar:/usr/share/java/mysql-connector-java-bin.jar de/malte_bublitz/itc/kontoauszug/Konto.java
	@echo "[JAVAC]    de.malte_bublitz.itc.kontoauszug.Kontoauszug"
	@javac -cp \*:.:../../java-util/bin/ANSIConsole.jar:/usr/share/java/mysql-connector-java-bin.jar de/malte_bublitz/itc/kontoauszug/Kontoauszug.java

compile_buecherverwaltung: de/malte_bublitz/itc/buecherverwaltung/Buch.java de/malte_bublitz/itc/buecherverwaltung/Main.java
	@echo "[JAVAC]    de.malte_bublitz.itc.buecherverwaltung.Buch"
	@javac de/malte_bublitz/itc/buecherverwaltung/Buch.java
	@echo "[JAVAC]    de.malte_bublitz.itc.buecherverwaltung.Main"
	@javac de/malte_bublitz/itc/buecherverwaltung/Main.java

compile_vokabeltrainer: de/malte_bublitz/itc/vokabeltrainer/Wort.java de/malte_bublitz/itc/vokabeltrainer/Vokabeltrainer.java de/malte_bublitz/itc/vokabeltrainer/Wortbestand.java 
	@echo "[JAVAC]    de.malte_bublitz.itc.vokabeltrainer.Wort"
	@javac de/malte_bublitz/itc/vokabeltrainer/Wort.java
	@echo "[JAVAC]    de.malte_bublitz.itc.vokabeltrainer.Wortbestand"
	@javac de/malte_bublitz/itc/vokabeltrainer/Wortbestand.java
	@echo "[JAVAC]    de.malte_bublitz.itc.vokabeltrainer.Vokabeltrainer"
	@javac de/malte_bublitz/itc/vokabeltrainer/Vokabeltrainer.java

package_helloworld: compile_helloworld
	@echo "[JAR]      bin/HelloWorld.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.helloworld.HelloWorld" > META-INF/MANIFEST.mf
	@jar cvfm ../bin/HelloWorld.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/helloworld/*.class >/dev/null
	@rm -rf META-INF 
	
package_forloop: compile_forloop
	@echo "[JAR]      bin/ForLoop.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.forloop.ForLoop" > META-INF/MANIFEST.mf
	@jar cvfm ../bin/ForLoop.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/forloop/*.class >/dev/null
	@rm -rf META-INF 
	
package_scannerdemo: compile_scannerdemo
	@echo "[JAR]      bin/ScannerDemo.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.scannerdemo.ScannerDemo" > META-INF/MANIFEST.mf
	@jar cvfm ../bin/ScannerDemo.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/scannerdemo/*.class >/dev/null
	@rm -rf META-INF 
	
package_matchstick: compile_matchstick
	@echo "[JAR]      bin/MatchStick.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.matchstick.MatchStick" > META-INF/MANIFEST.mf
	@jar cvfm ../bin/MatchStick.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/matchstick/*.class >/dev/null
	@rm -rf META-INF 
	
package_kontoauszug: compile_kontoauszug
	@echo "[JAR]      bin/Kontoauszug.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.kontoauszug.Kontoauszug" > META-INF/MANIFEST.mf
	@cp ../../java-util/bin/ANSIConsole.jar ../bin
	@cp /usr/share/java/mysql-connector-java-bin.jar ../bin/
	@jar cvfm ../bin/Kontoauszug.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/kontoauszug/*.class >/dev/null
	@rm -rf META-INF 

package_buecherverwaltung: compile_buecherverwaltung
	@echo "[JAR]      bin/Buecherverwaltung.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.buecherverwaltung.Main" > META-INF/MANIFEST.mf
	@jar cvfm ../bin/Buecherverwaltung.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/buecherverwaltung/*.class >/dev/null
	@rm -rf META-INF 
	
package_vokabeltrainer: compile_vokabeltrainer
	@echo "[JAR]      bin/Vokabeltrainer.jar"
	@mkdir META-INF
	@echo "Main-Class: de.malte_bublitz.itc.vokabeltrainer.Vokabeltrainer" > META-INF/MANIFEST.mf
	@jar cvfm ../bin/Vokabeltrainer.jar META-INF/MANIFEST.mf de/malte_bublitz/itc/vokabeltrainer/*.class >/dev/null
	@rm -rf META-INF 
	
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
	
run_buecherverwaltung: package_buecherverwaltung
	@echo "[RUN]      bin/Buecherverwaltung.jar"
	@java -jar ../bin/Buecherverwaltung.jar
	
run_vokabeltrainer: package_vokabeltrainer
	@echo "[RUN]      bin/Vokabeltrainer.jar"
	@java -jar ../bin/Vokabeltrainer.jar
	
clean:
	@echo "[CLEAN]"
	@find . -iname "*.class" -exec rm -rf '{}' \;
	@rm -rf META-INF*
	@rm -f ../bin/*.jar
	
