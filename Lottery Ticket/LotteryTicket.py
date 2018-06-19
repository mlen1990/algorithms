"""

Winning Ticket!

Your favorite uncle, Morty, is crazy about the lottery and even crazier about how he picks his "lucky" numbers.
And even though his "never fail" strategy has yet to succeed, Uncle Morty doesn't let that get him down.

Every week he searches through the Sunday newspaper to find a string of digits that might be potential lottery picks. 
But this week the newspaper has moved to a new electronic format, and instead of a comfortable pile of papers, Uncle Morty receives a text file with the stories.

Help your Uncle find his lotto picks. Given a large series of number strings, return each that might be suitable for a lottery ticket pick.
Note that a valid lottery ticket must have 7 unique numbers between 1 and 59, digits must be used in order, and every digit must be used exactly once.

For example, given the following strings:

[ "569815571556", "4938532894754", "1234567", "472844278465445"]

Your function should return:

4938532894754 -> 49 38 53 28 9 47 54
1234567 -> 1 2 3 4 5 6 7

"""

"""
SOLUTION SUMMARY
Step 1: Inputs must have 7 to 14 digits inclusive. Do not try to find a valid lottery ticket for invalid inputs i.e. do not call generate_lists() on invalid inputs
Step 2: Any one digit or two digit number must be between 1 and 59 inclusive. See valid_number()
Step 3: Create a function generate_lists() that takes in a string of numbers and return a list of lists, where each list contains 1 to 2 digit numbers with length 7
	Process:
		Step 1: Create a list of dictionaries. Each dictionary has two fields.
			"numbers": a list of 1 to 2 digit numbers, initially an empty array
			"remaining": the remaining digits in the string of numbers, initially the whole input string
		Step 2: While list of dictionaries is not empty:
			1. pop the last item in the list of dictionaries
			2. Check if the next digit may be added to the current "numbers" list in "item." If yes, then create a new item dictionary and append to list of dictionaries. The "remaining" string will have 1 less digit
			3. Check if the next two digits may be added to the current "numbers" list in "item." If yes, then create a new item dictionary and append to list of dictionaries. The "remaining" string will have 2 less digits
			4. Repeat
		Points where the list of dictionaries gets smaller in size:
			1. The remaining digits in item["remaining"] is 0. Note: If the length of the "numbers" list is 7, then add it to the list of finished_lists
			2. The next digit or next two digits is in the item["numbers"] list already
			3. The value of next one to two digits is out of range of [1, 59]
			4. The numbers array is length 7 and there are still remaining digits
		Finally return a list containing lists of lottery tickets

EFFICIENCY:
Running time: O(n), where n is the size of the inputs list. I reasoned that the generate_lists() function takes constant time. The max depth of the tree is 7.
The while loop will execute at most (2^7 - 1) or 127 times. With pruning due to various criteria, this number is much lower than 127 which reduces to constant time or O(1).
Therefore, the running time really depends on how big the inputs list is.

Space Efficiency:
The max number of items in finish_lists is 2^(7-1) or 64, which reduces to constant space O(1). The space efficiency really depends on how big the input list is.

"""
inputs = ["569815571556", "4938532894754", "1234567", "472844278465445"]

min_ticket_number = 1
max_ticket_number = 59

# String of numbers must have a length between 7 and 14 inclusive
def validate_input(input):
	if 7 <= len(input) and len(input) <= 14:
		return True
	return False

# Each one to two digit number must be between 1 and 59 inclusive
def valid_number(number):
	if min_ticket_number <= number and number <= max_ticket_number:
		return True
	return False;

# Given a string, generate a list of lottery tickets (returns a list of lists as there could be more than 1 solution)
def generate_lists(input):
	lists = [{"numbers": [], "remaining": input}]
	finished_lists = []
	while (len(lists) > 0):
		item = lists.pop()

		# done: can't take another digit
		if len(item["remaining"]) == 0:
			# append the list of numbers to the finished_lists array if it has size 7
			if len(item["numbers"]) == 7:
				finished_lists.append(item["numbers"])
			continue

		# prune: we have 7 numbers but there is still some numbers remaining
		# do not add to finished lists because each digit must be used once and there are some remaining
		if len(item["numbers"]) == 7 and len(item["remaining"]) != 0:
			continue
		
		# Case 1: Remove 1 digit at a time
		number = int(item["remaining"][0])
		if valid_number(number) and number not in item["numbers"]:
			numbers = list(item["numbers"])
			numbers.append(number)
			new_item = {"numbers": numbers, "remaining": item["remaining"][1:]}
			lists.append(new_item)

		# Case 2: Remove 2 digits at a time
		if len(item["remaining"]) > 1:
			number = int(item["remaining"][0:2])
			if valid_number(number) and number not in item["numbers"]:
				numbers = list(item["numbers"])
				numbers.append(number)
				new_item = {"numbers": numbers, "remaining": item["remaining"][2:]}
				lists.append(new_item)
		# print item
	# print lists
	return finished_lists

for input in inputs:
	if validate_input(input):
		potential_lists = generate_lists(input)
		for potential_list in potential_lists:
			print input, "->", " ".join(map(str, potential_list))
	
