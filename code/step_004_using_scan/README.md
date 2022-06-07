# Using substreams

We should strive to avoid `var`s in our code when a there is a feasible
alternative. Luckily, we can do that in this case.

- Update `DrivingDetector.flow` so that state is kept using `scan`
  instead of `statefulMapConcat`

  Hint: the state value might not be the same as the value you want to
  emit.
