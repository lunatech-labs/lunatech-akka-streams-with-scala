implement_a_delay_element

## This phase implements a core streams element - the DelayLine

A `DelayLine` is a `Flow` element that has two inputs `in`0 and
`in`1 and two outputs `out`0 and `out`1. The element types are
all `Double`s.

Output `out`0 is input stream `in`0 delayed by a specified number
of samples (`delay`).
Output `out`1 is the sum of `in`1 and `out`0 multiplied by a
specified value (`scaleFactor`).

An FIR filter can be constructed trivially by chaining `DelayLine`s

In principle, we could implement the DelayLine as a so-called
Akka Streams junction, but instead we will use a linear `Flow`
component which takes a tuple of `Double`s as input and a tuple
of `Double`s as output.

Your task is to implement the `DelayLine` `Flow` component using
`Flow.statefulMapConcat`.

## Step by step implementation

- Create a new Scala object named `FilterElements` in package
  `org.applied.akkastreams.echo`

- In the `FilterElements` object, create a new Scala object named
  `DelayLineFlow` with an `apply` method that takes two parameters:

  - `delay` of type `Int`
  - `scalaFactor` of type `Double`

  The `apply` method should return a `Flow[(Double, Double), (Double, Double), NotUsed]`

- In order to implement the required delay, you will have to choose
  a data structure that can store a number of samples equal to the
  value of `delay`.

  Two possible approaches that can work:

  - Use `scala.collection.mutable.Queue`
  - Use `scala.Array` to implement a circular buffer

- Implement the flow element based on `statefulMapConcat`:

  - This method takes one argument: a function from `Unit` to
    a function that processes the input (`Tuple2[Double, Double]`)
    and that returns a `Tuple2[Double, Double]`:

  - The first element of the returned tuple should be the
    input element delayed by `delay` samples

  - The second element of the returned tuple should be the
    sum of the second element of the input tuple and the
    product of the input element delayed by `delay` samples and
    the `scaleFactor`.

Note: The state of the `statefulMapConcat` flow component is
      kept in the body of the function.

