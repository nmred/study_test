#!/usr/bin/env python

import os

for tmpdir in ('/tmp',):
	if os.path.isdir(tmpdir):
		break
	else:
		print 'no temp directory available'
		tmpdir = ''
	
print tmpdir
if tmpdir:
	os.chdir(tmpdir)
	cwd = os.getcwd()
	print '*** current temporary directory'
	print cwd

print '*** creating example directory ...'
os.mkdir('example')
os.chdir('example')
cwd = os.getcwd()
