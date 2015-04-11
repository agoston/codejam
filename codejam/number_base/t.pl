#!/usr/bin/perl

use strict;
use warnings;

my $total = <>;
my $actline = 1;

while (<>) {

  my @a = split;
  my @num = split(//, $a[0]);
  my $srcstr = $a[1];
  my $dststr = $a[2];

  my @src = split(//, $srcstr);
  my @dst = split(//, $dststr);
  
  my $srcbase = scalar @src;
  my $dstbase = scalar @dst;

  my $act = 0;
  foreach my $digit (@num) {
    $act *= $srcbase;
    $act += index($srcstr, $digit);
  }

  my $res = "";
  
  while ($act > 0) {
    my $lastdigit = $act % $dstbase;
    $res = $dst[$lastdigit] . $res;
    $act -= $lastdigit;
    $act /= $dstbase;
  }

  print "Case #$actline: $res\n";
  $actline++;

}