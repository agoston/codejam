#!/usr/bin/perl

use strict;
use warnings;

use POSIX;
use Data::Dumper;

my $base = 5.23606797749978969640917366873127;
my $num = 1;

sub mulmod1000 {
  my $in = shift;
  $in *= $base;
  my $intpart = (floor($in / 1000)) * 1000;
  $in -= $intpart;
  return $in;
}

for (1..$ARGV[0]) {
  $num = mulmod1000($num);
#  printf("%10.10f\n", $num);
}

printf("%03.0f\n", floor($num));
