# wordsuggest
App to pick words from a file and use ArrayAdapter to display the suggestions based on the input from the user.

WordSuggest:
This class queries the file and omits words that have non-alpha and numberic characters 
and delivers the words in an array format to the arrayadapter.
The file is under 'raw/words'.

Test:
Unit tests:
Unit tests have been added to test that appropriate words are picked

Espresso tests:
Recorded expresso tests have been added.
Lot of tests can be included to display appropriate word suggestions based on the input.

Making it better:
The file is queried at the start and this might make the app slower when the file grows in size.
CustomArrayAdapters with alphabetical sorting and picking up words based on input can improve performace.
