# CostumerParser
Done for COMP 4040 under Prof Fateh Sen, U of Memphis Comp Science Professor
Task of this project is to write a parser for a customer form. which develop a Java application using Parboiled library. 
The program include a grammar for the parser and display the parse tree.
The customer form include the following structure:
First name, middle name (optional), last name
Street address, city, state (or province), country
Phone number
Rules

• First name, middle name and last name should start with an uppercase letter followed by lower case letters. Middle name is an optional input meaning such an input may or may not exist.
• The street address can include any type of letters or numbers. There is no lowercase/uppercase restriction either.
• The city name should start with an uppercase letter followed by lowercase/uppercase letters.
• The state or province should start with an uppercase letter followed by lowercase/uppercase letters.
• The country name should start with an uppercase letter followed by lowercase/uppercase letters.
• The phone number should begin with area code in parenthesis, followed by a space, three digits, a hyphen, and four digits.

Examples
Here are some input examples for your program:
John Doe
3609 Mynders Ave, Memphis, TN, United States of America
(901) 345-9834
Joshua R. Clemens
982 Pryor St, Little Rock, AR, USA
(501) 876-1234
Mary Smith
82 Main St., Toronto, Ontario, Canada
(416) 509-6995

