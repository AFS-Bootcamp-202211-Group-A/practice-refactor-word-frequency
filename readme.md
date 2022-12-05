## Refactoring steps

### Refactor Cycle 
1. Run test cases
2. Find code smell
3. Refactor and run test cases again
4. Commit in baby steps

### Commit(refactored) steps recorded in this repos 
###### [---- Follow above cycle ----]
1. Refactor Magic names
2. Rename mysterious name and method
3. Transform inline verbose code -> private standalone function under same class
4. Transform loop function -> Java streamapi
5. Remove useless code
- Removed comments
- Make constants become final static
