# RandomPhraseGraph

## About the Project
This project was created for the CS2420 final project, it was written by Ian Argyle and Donald Kubiak. Grading was based almost entirely on run time, so this implimentation aims to generate phrases as fast as possible using a graph. Time complexity is O( log(n) ) where n is the number of non-terminals in the grammar file (see below). This was the 6th fastest implimentation in a class of ~150.

In a video game, the characters often must say phrases throughout the play of the game. The phrases must be of a certain form (e.g., a noun followed by a verb followed by an object). However, the phrases must also be randomized, so that the character does not repeat exactly the same phrase again and again. This project impliments a graph object to generate random phrases from an input (.g) grammar file. Rules for the grammar file are as follows:
* The file contains the definitions of one or more non-terminals.
* Non-terminals are always denoted with angle brackets, and the name of a non-terminal may not contain any whitespace. For example, <noun> and <long-int> are correct non-terminals. <awesome word> and <noun > are not correct non-terminals.
* Terminals are denoted by the absence of angle brackets.
* Each non-terminal definition begins with an opening curly brace (on its own line with no extraneous spaces). The non-terminal being defined appears alone on the next line. The choice of one or more productions to which the non-terminal can be expanded appear next (one per line). A single production consists of one or more terminals and/or non-terminals. A single blank space may appear between each terminal and non-terminal; however, no extraneous spaces appear before the first (non-)terminal or after the last (non-)terminal. Finally, the non-terminal definition ends with a closing curly brace (on its own line with no extraneous spaces).
* Every non-terminal used in a production is defined somewhere in the file, but not necessarily before (or after) the production in which it is used.
* The starting non-terminal is always identified as <start>.
* Comments may appear in between non-terminal definitions. Therefore, any lines outside of the curly braces should be ignored.
  
Here is an example of a very simple grammar file. A possible random phrase of this form is "The mouse stood on the dog." Another is "The cat sat on the mouse."
```
{
<start>
The <object> <verb> on the <object>.
}

{
<object>
cat
dog
mouse
}

Outside of the braces, there can be any kind of text; for comments, diagrams, etc.  You should skip over all this text and read the next nonterminal definition.

{
<verb>
sat
stood
}
```
