## Implement an Infinite Impulse Response Filter

In this exercise, you will implement the core `IIR` filter code
using the Akka Streams Flow Graph DSL

What is special about this particular case is that we will use
feedback in this use case.

## Exercise instructions

- Have a look at the `FIRElements` object and figure out why the
  `FirInitialZero` flow element is introduced.
  
- Take a look at `IIR` to see how specific IIR filter is created
  using the `buildIIR` factory method.
  
- You also may want to have a look at the `IIRSpec` test file.

Next, you should implement the core IIR implementation using the
Akka Streams Graph DSL.

- Open the `IIRFlow` object in your IDE. The code to be implemented
  has been substituted with `???`.
  
- The outline of the Graph DSL implementation is already present.

- Note that the internal FIR filter is passed in as a parameter.

- You will need to add a number of elements such as:

  - a `Zip` component which zips two input elements together and
    outputs them as a tuple
    
  - a `Concat` component, which has 2 input and one output

  - a `Broadcast` component with 2 outputs. A `Broadcast` has
    one input and it will broadcast every element it received
    two its two outputs
    
  - finally, you will need a component which will emit just a 
    single element: a `Double` value equal to 0.0
    
  - You can wire everything together using the DSL operators
    `~>` (for _forward_ operations) and `<~` for _backward_
    operations
    
Finally, you will have to wire-up the component's [single] input
and [single] output.

- Run the tests to check that your solution is correct.

- Run the `IIR` program to _"hear"_ it in action.