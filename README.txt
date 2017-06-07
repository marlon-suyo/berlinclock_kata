Berlin Clock Kata (by Marlon Suyo)

This Berlin Kata exercise converts time represented in a digital format to an output that simulates the Berlin Clock. 
In addition, test cases using JUnit have been provided to ensure the conversion functionality of the program is correct.



The following overview is derived from Agile Katas (http://agilekatas.co.uk/katas/BerlinClock-Kata)

The Berlin Clock (Mengenlehreclock or Berlin Uhr) is a clock that tells the time using a series of illuminated coloured blocks.
	The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.
	The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps. 
	The lower row represents 1 hour blocks and is also made up of 4 red lamps.
	The final two rows represent the minutes. 
		The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow. 
		The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.


Converting Digital Time to Berlin Time
	So what we want first is a way to get a textual representation of a Berlin Clock time based on a digital time. 
	This is so we can use this converter everywhere, all we have to do is hook up a frontend. 
