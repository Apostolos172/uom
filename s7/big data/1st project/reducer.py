#!/usr/bin/env python3

import sys

current_date = None
current_key = None
current_count = 0
ip_with_file = None
date = None

# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    ip_with_file, date = line.split('\t')

    # this IF-switch only works because Hadoop sorts map output
    # by key (here: ip filename) before it is passed to the reducer
    if current_key == ip_with_file and current_date == date:
        continue
    elif current_key == ip_with_file and current_date != date:
        current_count += 1
        current_date = date
    elif current_key != ip_with_file:
        if current_key:
            if current_count>1:
                keySplit = current_key.split()
                ip = keySplit[0]
                filename = keySplit[1]
                # write result to STDOUT
                print('%s\t%s' % (ip, filename))
        current_count = 1
        current_key = ip_with_file
        current_date = date

# do not forget to output the last pair if needed!
if current_key == ip_with_file and current_count>1:
    keySplit = current_key.split()
    ip = keySplit[0]
    filename = keySplit[1]
    # write result to STDOUT
    print('%s\t%s' % (ip, filename))
