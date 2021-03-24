# Using stateful streams

For this exercise we'll write a `Flow` that will read car telemetry signals and
detect whether the car is parked or driving as the signal data is coming in.

- Read the class definitions of `Signal` and `DrivingState`.

- Create an object `DrivingDetector` with a `val flow` of type:
  ```scala
  Flow[Signal, DrivingState, NotUsed]
  ```

- Provide an implemention with the following behavior:

  - Initially, the car is assumed to be parked
  - When velocity is non-zero, transition to driving state
  - When ignition is zero, transition to parked state

  For this exercise:
  
  - You can assume we are only detecting the state of one car 
  - You should use `statefulMapConcat` to keep state between signals.

- Run the tests to validate your implementation.
