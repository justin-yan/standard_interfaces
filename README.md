symbolic-math
=============

Numeric formats, even "arbitrary precision" ones, suffer, fundamentally, from the loss of precision over the course of many operations.  For most practical purposes, the precision being lost is not of consequence, but where the uncertainty can be challenging is when many operations are performed, leading to compounding precision loss of an uncertain degree.

|  Operation / Format  | BigNumber/Decimal | SymbolicMath | Generalized CAS |
|----------------------|-------------------|--------------|-----------------|
| Addition/Subtraction | No Loss           | No Loss      | No Loss         |
| Multiplication       | No Loss           | No Loss      | No Loss         |
| Division             | Lossy (1/3)       | No Loss      | No Loss         |
| Exponentiation/Roots | No Support        | No Support   | No Loss         |
| Equation Solvers     | No Support        | No Support   | No Loss         |

The goal, then, should be to perform operations that retain *perfect* precision, and to only lose precision when a number needs to be rendered for some purpose, such as displaying a precise amount for a financial transaction.

This collection of libraries provides the following:

    - A `Rational`s class that provides lossless precision operations for the class of Rational numbers.
    - Conversion utilities to/from all major numeric types, along with precision specification mechanisms for the precise handling of precision loss.
    - A string serialization format and SerDe utilities to allow for cross-language transport.


## Design

The general principle is to use arbitrary-precision *integer* formats in order to retain the numerator/denominator values and preserving those through all calculations, where the canonical representation is always the *fully reduced* fraction.  Only when an actual decimal needs to be *rendered* do we perform the division and rounding as needed.

The serialization format simply uses String in order to avoid precision loss:

    - `<version#>:<payload>`
    - Version 1:
        - `1:<numerator>/<denominator>`
        - E.g., `.5` would be `1:1/2`
