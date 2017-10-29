# CARDIAC-Compiler
Simple assembler for the CARDIAC computer


Example assembly program
~~~~
//**AVERAGING PROGRAM**
//Reads a data set until it reaches a negative number
//Then it outputs the # of items, the sum of the items and their average.
//setup bootstrapper
INP 02
JMP 00
//bootstrap program
INP 20
INP 60
INP 21
CLA 60
INP 22
TAC 80
//Load the counter variable into memory, var++, store back at 04
INP 23
CLA 04
INP 24
ADD 05
INP 25
STO 04
//running sum
INP 26
CLA 06
INP 27
ADD 60
INP 28
STO 06
//jump to 20
INP 29
JMP 20
//what to do when negative num is hit
//output the input count
INP 80
OUT 04
//output the running sum
INP 81
OUT 06
//average the inputs
INP 82
CLA 06
INP 83
SUB 04
INP 84
TAC 93
INP 85
STO 06
INP 86
CLA 07
INP 87
ADD 05
INP 88
STO 07
INP 89
JMP 82
INP 93
OUT 07
INP 94
JMP 99
//data counter
INP 04
DATA 000
//how much to add by
INP 05
DATA 001
//running sum
INP 06
DATA 000
//store average
INP 07
DATA 000
//jump to program
INP 02
JMP 20
//data set
DATA 067
DATA 001
DATA 037
DATA 006
DATA 067
DATA 044
DATA 096
DATA -095
DATA 007
DATA 001
~~~~

Output:
~~~~
002
800
020
060
021
160
022
380
023
104
024
205
025
604
026
106
027
260
028
606
029
820
080
504
081
506
082
106
083
704
084
393
085
606
086
107
087
205
088
607
089
882
093
507
094
899
004
000
005
001
006
000
007
000
002
820
067
001
037
006
067
044
096
-095
007
001
~~~~
