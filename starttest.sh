#!/bin/bash

# Change to the repository root directory
cd "$(dirname "$0")"

# Run Maven test
mvn test -Pweb-execution -Dbrowser=chrome -Dheadless=false
