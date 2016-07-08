#!/usr/bin/env bash
gibo -u
gibo osx windows jetbrains gradle > .gitignore
gibo gradle java > rxproperty/.gitignore
gibo gradle java > rxproperty-kotlin/.gitignore
git rm -rf --cached .
git add .
