#!/bin/bash

go run main.go | sort > actual-output.txt

diff -w actual-output.txt expected-output.txt