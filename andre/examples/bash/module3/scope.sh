#!/bin/bash

declare a

modify() {
  a=2
}

init() {
  local a
  modify
}

a=1
init
echo $a