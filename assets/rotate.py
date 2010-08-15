#!/usr/bin/python

import sys
sys.path.append("/usr/lib/gimp/2.0/python/")

import Image
from gimpfu import *

image = pdb.file_png_load("/home/vogtp/android/workspace/statusbarCompass/res/drawable/arrow0.png", "arrow0.png")

for n in range(1, 35):
	img = pdb.gimp_rotate(image, TRUE, n*10)
	name = "/home/vogtp/android/workspace/statusbarCompass/res/drawable/arrow"+`n`+".png"
	pdb.file_png_save(img,draw,name,name,0,0)

	

import Image

im1 = Image.open("arrow0.png")
for n in range(1, 35):
	im2 = im1.rotate(n*10)
	name = "arrow"+`n`+".png"
	im2.save(name)