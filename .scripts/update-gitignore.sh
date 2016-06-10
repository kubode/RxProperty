#!/usr/bin/env bash
gibo -u
gibo osx windows jetbrains java gradle > .gitignore
git rm -r --cached .
git add .
