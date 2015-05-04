#!/bin/bash
python3 amino_acids.py < "AUG UUU" > output.txt
python3 amino_acids.py < "UUU AUG" > output.txt
python3 amino_acids.py < "AUG UUU UAA AUG UUU UUU" > output.txt
chmod +x testAA

