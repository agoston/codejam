#!/usr/bin/perl -w

use strict;
use warnings;

use Data::Dumper;

my $pos;
my $numeng;

sub indexof {     # pass in value, array reference
   my ( $value, $arrayref, $from ) = ( shift, shift, shift );
   foreach my $i ( $from .. @$arrayref-1 )  {
      return $i if $$arrayref[$i] == $value;
   }
   return undef;
}

sub lookmaxpos {
  my $l = shift;
  my $maxpos = $pos;
  my $retpos = 0;
  
  for my $acteng (0..$numeng-1) {
    my $actpos = indexof($acteng, $l, $pos);
    
    if (!defined $actpos) {
      return undef;
    }
    
    # most a masodik fele is elorenezunk
    for my $seceng (0..$numeng-1) {
      my $secpos = indexof($seceng, $l, $actpos);
  
      if ($secpos > $maxpos) {
        $maxpos = $secpos;
        $retpos = $actpos;
#        print "$acteng, $actpos, $seceng, $secpos\n";
      }
    }
  }	
  return $retpos;
}


my $N = <>;

for my $i (0..$N-1) {

  my %engine;
  my @l;
  my $j;

	my $S = <>;
	for $j (0..$S-1) {
		chomp(my $line = <>);
		$engine{$line} = $j;
	}

	my $Q = <>;
	for $j (0..$Q-1) {
		chomp(my $line = <>);
		push @l, $engine{$line};
	}
	
  my $ch = 0;
	if (scalar @l > 0) {

  	# beolvasas megvan
  	$numeng = scalar keys %engine;
    $pos = 0;

    while (defined $pos) {
      $pos = lookmaxpos(\@l);
      #    print " > $pos\n";
      $ch++;
    }
    $ch--;
  }
  
  print "Case #".($i+1).": $ch\n";
}
