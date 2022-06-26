#!/usr/bin/env python3

import sys

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    words = line.split(',')

    doc = words[6]
    accession = words[5]
    date = words[1]
    ip = words[0]
    file = doc
    if doc[0]=='.':
        file = accession + doc
    key = ip + " " + file
    value = date
            
    # write the results to STDOUT (standard output);
    # what we output here will be the input for the
    # Reduce step, i.e. the input for reducer.py
    # tab-delimited
    print('%s\t%s' % (key, value))
