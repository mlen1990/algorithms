<?php

/*

Calculate the angle between hour hand and minute hand

Input:  h = 12:00, m = 30.00
Output: 165 degree

Input:  h = 3.00, m = 30.00
Output: 75 degree

Let 12:00 be the reference point. 

Steps:
1) Calculate the angle made by hour hand with respect to 12:00 in h hours and m minutes.
2) Calculate the angle made by minute hand with respect to 12:00 in h hours and m minutes.
3) The difference between two angles is the angle between two hands.

How to calculate the two angles with respect to 12:00? 
The minute hand moves 360 degree in 60 minute (or 6 degree in one minute) and hour hand moves 360 degree in 12 hours (or 0.5 degree in 1 minute).
In h hours and m minutes, the minute hand would move 6*m and hour hand would move (60*h + m)*0.5.

 */
function clockAngle($hours, $minutes) {
	if ($hours < 0 || $minutes < 0 || $hours > 12 || $minutes > 60) {
		print_r('Wrong Input');
	}
	if ($hours == 12) {
		$hours = 0;
	}
	if ($minutes == 60) {
		$minutes = 0;
	}
	$hoursAngle = 30 * $hours + 0.5 * $minutes;
	$minutesAngle = 6 * $minutes;

	$angle = abs($hoursAngle - $minutesAngle);

	// Return the smaller of the two angels
	// Comment this line of code out if you just want the larger of the two
	$angle = min(360 - $angle, $angle);
	return $angle;
}


print(clockAngle(12, 30)."\n");
print(clockAngle(12, 45)."\n");
print(clockAngle(3, 30)."\n");
print(clockAngle(9, 60)."\n");
?>
