#!/bin/bash

cd `dirname $0`/src
(
	if [[ ! -e de/malte_bublitz/util ]]
	then
		cd de/malte_bublitz
		ln -sf ../../../../java-util/src/de/malte_bublitz/util .
	fi
)

for package in `find . -mindepth 4 -maxdepth 4 -type d`
do
	#echo "Found package `echo $package | cut -c 3- | tr / .`."
	for java_file in `find $package -iname "*.java"`
	do
		class_file="${java_file%.*}.class"
		class="`echo $java_file | cut -c 3- | tr / . | sed 's/.java//'`"
		echo "[JAVAC]  $class"
		if [[ ! -f $class_file || $java_file -nt $class_file ]]
		then
			javac $java_file #&>/dev/null
			if [[ $? -ne 0 ]]
			then
				exit $?
			fi
		fi
	done
done

TMPDIR="/tmp/$USER,`git config --get remote.origin.url | cut -d: -f2 | cut -d. -f1 | tr / -`,build"
REPODIR=$(dirname $PWD)
for class in `find $REPODIR/src/ -iname "*.java" -exec grep -l 'public static void main' '{}' \;`
do
	rm -rf $TMPDIR
	mkdir -p $TMPDIR
	
	jar_file="$(basename $(dirname $class))_$(basename ${class%.*}).jar"
	echo "[JAR]    $jar_file"
	jar_file="$REPODIR/bin/$jar_file"
	
	# Check if build is required...
	declare -a all_class_files
	if grep -r 'de.malte_bublitz.util.ANSIConsole' `dirname $class` &>/dev/null
	then
		all_class_files[$((${#all_class_files[@]} + 1))]=$REPODIR/src/de/malte_bublitz/util/ANSIConsole.class
	fi
	for class_file in `find $(dirname $class) -iname "*.class"`
	do
		all_class_files[$((${#all_class_files[@]} + 1))]=$class_file
	done
	DO_BUILD="no"
	for class_file_name in ${all_class_files[@]}
	do
		if [[ $class_file_name -nt $jar_file ]]
		then
			DO_BUILD="yes"
		fi
	done
	
	if [[ $DO_BUILD == "yes" ]]
	then
		# Check if the class uses ANSIConsole
		grep -r 'de.malte_bublitz.util.ANSIConsole' `dirname $class` &>/dev/null && {
			mkdir -p $TMPDIR/de/malte_bublitz/util/
			cp -r $REPODIR/src/de/malte_bublitz/util/*.class $TMPDIR/de/malte_bublitz/util/
		}
		# Copy all files from the package
		for class_file in `find $(dirname $class) -iname "*.class"`
		do
			class_file_path=$(echo $class_file | sed "s@$REPODIR/src/@@g")
			mkdir -p $TMPDIR/`dirname $class_file_path`
			cp $class_file $TMPDIR/`dirname $class_file_path`
		done
		
		class_java=$(echo $class | sed "s@$REPODIR/src/@@g" | cut -d. -f1 | tr / .)
		# Create META-INF
		mkdir $TMPDIR/META-INF
		cat <<EOF >$TMPDIR/META-INF/MANIFEST.MF
Main-Class: $class_java
EOF
		cd $TMPDIR
		jar -cfm $jar_file META-INF/MANIFEST.MF de/
	fi
done
rm -rf $TMPDIR
