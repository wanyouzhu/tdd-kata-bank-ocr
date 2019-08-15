## Bank OCR
This is a TDD exercise project for coding kata Bank OCR, you can find this kata [here](http://codingdojo.org/kata/BankOCR/).

## Tasking

### User Story 1
* Read input file into entries
  * 8 lines -> 2 entries
  * Total number of lines is not times of 4 -> MalformedInputFileException 
* Separate entry into units
  * 867965245 -> [8, 6, 7, 9, 6, 5, 2, 4, 5]
  * Not 27 characters per line -> MalformedEntryException
* Parse numbers from units
  * 0 -> 0
  * 1 -> 1
  * 2 -> 2
  * 3 -> 3
  * 4 -> 4
  * 5 -> 5
  * 6 -> 6
  * 7 -> 7
  * 8 -> 8
  * 9 -> 9
  * other -> MalformedUnitException

### User Story 2
* Check checksum of entries