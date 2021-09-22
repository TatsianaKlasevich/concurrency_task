# concurrency

You have the four functions:

- `printLand` that prints the word `"Land"` to the console,
- `printRover` that prints the word `"Rover"` to the console,
- `printLandRover` that prints the word `"LandRover"` to the console, and
- `printNumber` that prints a given integer to the console.

You are given an instance of the class `LandRover` that has four functions: `land`, `rover`, `landrover` and number. The same instance of `LandRover` will be passed to four different threads:

- **Thread A**: calls `land()` that should output the word `"Land"`.
- **Thread B**: calls `rover()` that should output the word `"Rover"`.
- **Thread C**: calls `landrover()` that should output the word `"LandRover"`.
- **Thread D**: calls `number()` that should only output the integers.

Modify the given class to output the series `[1, 2, "Land", 4, "Rover", ...]` where the i-th token (**1-indexed**) of the series is:

- `"LandRover"` if i is divisible by `3` and `5`,
- `"Land"` if i is divisible by `3` and not `5`,
- `"Rover"` if i is divisible by `5` and not `3`, or
- `i` if i is not divisible by `3` or `5`.

Implement the `LandRover` class:

- `LandRover(int n)` Initializes the object with the number `n` that represents the length of the sequence that should be printed.
- `void land(printLand)` Calls `printLand` to output `"Land"`.
- `void rover(printRover)` Calls `printRover` to output `"Rover"`.
- `void landrover(printLandRover)` Calls `printLandRover` to output `"LandRover"`.
- `void number(printNumber)` Calls `printnumber` to output the numbers.

Example 1:

>Input: n = 15
>
>Output: [1,2,"land",4,"rover","land",7,8,"land","rover",11,"land",13,14,"landrover"]

Example 2:

>Input: n = 5
> 
>Output: [1,2,"land",4,"rover"]

Constraints:

>1 <= n <= 50
