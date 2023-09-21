#!/bin/bash

recurse() {
    sleep 1
    local a="a long string of characters" 
    recurse
}

recurse