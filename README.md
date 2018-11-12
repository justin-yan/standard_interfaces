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
