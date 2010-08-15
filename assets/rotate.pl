#!/usr/bin/perl -w

use strict;

my $baseImg = "arrow0.png";

print "case 0: img = R.drawable.arrow0; break;\n";
for (my $i = 1; $i <36;$i++){
	my $angle = $i * 10;
	my $rotFile = "arrow${i}.png";
#	print "rotate $angle to $rotFile\n"; 
	print `convert -alpha Background -rotate -$angle $baseImg $rotFile`;
	print "case $i: img = R.drawable.arrow${i}; break;\n";
}
print "case 36: img = R.drawable.arrow0; break;\n";