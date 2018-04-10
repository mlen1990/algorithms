<?php

/*

Design an algorithm to print all permutations of a string. For simplicity, assume all characters are unique.

Example input: 'abcdefg'

Case 'a' => {'a'}
Case 'ab' => {'ab', 'ba'}
Case 'abc' => {'cab', 'acb', abc', 'cba', 'bca', 'bac'}


*/


function permutation($string) {
	getPermutations('', $string);
}

function getPermutations($prefix, $string) {
	$len = strlen($string);
	// if the string's length is less then 0 print the current string
	if ($len == 0) {
		print($prefix."\n");
	} else {
		$charArray = str_split($string);
		// For each character in the input string
		foreach ($charArray as $i => $character) {
			// Input 1: Append a new character
	        // Input 2: String without the iTH character
			getPermutations($prefix.$character, substr($string, 0, $i).substr($string, $i+1, $len));
		}
	}
}

permutation('abcdefg');