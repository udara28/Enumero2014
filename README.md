Enumero2014
===========

Hacker game for IEEE Enumero2014
Crack the Code
Decrypt the secret message without knowing the encryption key

###What has happened:
With our secret contacts to the one of the safe designers “jack”, who has designed the “PanoraBox” we were able to obtain the method which we could use to break the safe without the key. But since he did not want to get caught he has encrypted the email and send it to our team member “Jill”. Unfortunately jack got busted before he was able to send the key and is now in a high secured prison and nobody is able to make any contact with him. Now we need your help to decrypt the message without the secret key. Don’t worry with lot of hard work we have learned the encryption scheme and it is described below.
###How it has encrypted:
It is not that difficult because it only contains a simple XOR gate. We have a 3 letter English word which is used as secret key. This secret key is repeated (message.length/3) times so the repeated key string has the same length of the message. Then each character in the message is XOR with appropriate key Character as follows (here secret key is “abc”),

| h |	e	| l |	l	| o	|   |	w |	o |	r |	l |	d	| (EOF) |
|---|---|---|---|---|---|---|---|---|---|---|-------|
| ^ |	^ |	^ |	^ |	^	| ^	| ^	| ^	| ^	| ^ |	^	|   ^   |
| a	| b |	c	| a	| b	| c	| a	| b	| c	| a	| b	|   c   |
|---|---|---|---|---|---|---|---|---|---|---|-------|											
| 9 |	7	| 15 | 13 |	13	| 67|	22|	13|	17|	13|	6|	105|

What we have in the email is this line of numbers separated be commas,
9,7,15,13,13,67,22,13,17,13,6,105,
###How to decrypt:
If we know the secret key decrypting is the same procedure we used to encrypt the message, Only this time we are using our encrypted message as our message

| 9 |	7	| 15 | 13 |	13	| 67|	22|	13|	17|	13|	6|	105|
|---|---|---|---|---|---|---|---|---|---|---|-------|
| ^ |	^ |	^ |	^ |	^	| ^	| ^	| ^	| ^	| ^ |	^	|   ^   |
| a	| b |	c	| a	| b	| c	| a	| b	| c	| a	| b	|   c   |
|---|---|---|---|---|---|---|---|---|---|---|-------|											
| h |	e	| l |	l	| o	|   |	w |	o |	r |	l |	d	| (EOF) |


###Try our code sample:
Hope all of you know little bit of java. We have coded the encryption and decryption algorithm in JAVA which can be found in the CrackMe folder. Try the code
######To Encrypt a message:
**JAVA**	: *Java Crack encrypt \<filename.txt\> \<secret_key\>*

**C++**	: *Crack encrypt \<filename.txt\> \<secret_key\>*

	-if a key is not given “yup” will be used as the default key
######To Decrypt a message:
**JAVA**	: *Java Crack decrypt \<filename.txt\> \<secret_key\>*

**C++**	: *Crack decrypt \<filename.txt\> \<secret_key\>*

	-WARNING: if you are unsure of the secret key don’t call this message because this will overwrite the original file instead use –guess flag
######To Guess a secret key:
**JAVA**	: *Java Crack decrypt \<filename.txt\> -guess \<secret_key\>*

**C++**	: *Crack decrypt \<filename.txt\> -guess \<secret_key\>*

	-This method will only give a console print with the decrypted string.
####YOUR TURN!
Now it is your turn to come up with a Good enough Algorithm to decrypt the given secret message. To make the task easy we have used a meaningful English word with three simple letters with no repetition. You can use any programming language you like but if you use Java/C++ you can use the methods already coded by us. But since they are very simple using any other language wouldn’t be greatly affected.

###Few thoughts for the solution:
We’ll give you hints throughout the attempt. Please remember that there are many solutions for this problem. You can take any approach. As long as it crack the code we are happy with it. Discuss with us the methods you think might work so we could give some support to your ideas. Don’t worry we’ll help you to get there. Only thing you required is the willingness to try. 
KEEP IT SIMPLE AND STUPID
