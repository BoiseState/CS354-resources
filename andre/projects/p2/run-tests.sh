#!/bin/bash

# intended to be run within a repository that has a test-cases directory
# test-cases should contain a set of json files and a set of .json.out files
# for comparison with the javascript program driver.js.

for i in ./test-cases/*.json
do
	echo "======================================================================="
	echo "Running Test $i"
	node driver.js $i user | sort -t ':' -k2,2nr -k1,1f > ${i}_test.out
	echo "created ${i}_test.out"
	diff -B -w ${i}_test.out $i.out
	result=$?
	if test "$result" = 0
	then
		echo " ---- Test $i output matches! ---- "
	else
		echo " ---- Test $i FAILED!! ---- "
	fi
done

echo "======================================================================="
