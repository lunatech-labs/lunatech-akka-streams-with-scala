# Using substreams

There may exist more than one car. We should update our detection logic to
account for this possibility.

- Update `DrivingDetector.flow` such that a separate state is kept for every
  vehicle.

  Hint: each vehicle has its own unique Vehicle Identification Number

- Run the tests to validate your implementation.
