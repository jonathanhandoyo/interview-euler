# Euler Triangle
```
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
```

### Problem:
Given a triangle similar to the above; starting from the top of the triangle, there would be 2 options (adjacent left and adjacent right). When accumulated continuously downwards, find the biggest possible number.

### Approach & Solution:
The approach is actually to start from the bottom and fold the numbers to the top. The following would be the progression with a simple triangle like the above

##### Step 1
```
line 1 =>     1
line 2 =>    1 2
line 3 =>   1 2 3
line 4 =>  1 2 3 4
line 5 => 1 2 3 4 5
```

##### Step 2
```
line 1 =>     1
line 2 =>    1 2
line 3 =>   1 2 3
line 4 =>  3 5 7 9
```
Seeing the bottom 2 lines:
```text
line 4 =>  1 2 3 4
line 5 => 1 2 3 4 5
```
- Between `1` & `2` => `2` is larger, so fold `2` into the number `1` from line 4 => result: `3`
- Between `2` & `3` => `3` is larger, so fold `3` into the number `2` from line 4 => result: `5`
- Between `3` & `4` => `4` is larger, so fold `4` into the number `3` from line 4 => result: `7`
- Between `4` & `5` => `5` is larger, so fold `5` into the number `4` from line 4 => result: `9`

##### Step 3
```
line 1 =>       01
line 2 =>     01  02
line 3 =>   06  09  12
```
Seeing the bottom 2 lines:
```text
line 3 =>   1 2 3
line 4 =>  3 5 7 9
```
- Between `3` & `5` => `5` is larger, so fold `5` into the number `1` from line 3 => result: `6`
- Between `5` & `7` => `7` is larger, so fold `7` into the number `2` from line 3 => result: `9`
- Between `7` & `9` => `9` is larger, so fold `9` into the number `3` from line 3 => result: `12`

##### Step 4
```
line 1 =>       01
line 2 =>     10  14
```
Seeing the bottom 2 lines:
```text
line 2 =>     01  02
line 3 =>   06  09  12
```
- Between `06` & `09` => `09` is larger, so fold `09` into the number `1` from line 2 => result: `10`
- Between `09` & `12` => `12` is larger, so fold `12` into the number `2` from line 2 => result: `14`

##### Step 5
```
line 1 =>       15
```
Seeing the bottom 2 lines:
```text
line 1 =>       01
line 2 =>     10  14
```
- Between `10` & `14` => `14` is larger, so fold `14` into the number `1` from line 1 => result: `15`

### Execution:
- Go to project root 
- Run maven: `mvn test`

The test provides 3 sample inputs of varying size with a predetermined maximum sum.