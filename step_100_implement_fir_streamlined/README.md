## Construction of a simple FIR based echo generator using DelayLine

This exercise adds a factory method named `buildFIR` for an FIR filter. This
makes it easier to build such a filter based on an object that contains a
specification of each filter stage, namely a `delay` and a `scaleFactor`.

If you want, you can try to build this yourself based on the state of the
previous exercise. Otherwise, you can pull in the changed version by
selectively pulling the changed files by pulling the full "solution" by
running the `nextExercise` and `pullSolution` commands from the sbt 
prompt.

If you want to hang on to the code you implemented in the previous
exercises, save it by running `saveState` before pulling the solution.
This will allow you to restore the saved state using the `restoreState`
command later! (you need to pass a reference to the saved state to
`restoreState`. To display all saved states, run the `savedStates` command)

Verify that the tests still pass and also run the code via the `run`
command.

NOTE: Before moving to the next exercise, you may want to save the current
      state of your exercise by running the `saveState` command from the
      sbt prompt.

      You can restore this saved state later by looking up its reference
      using the `savedStates` command and then pass the desired state to
      the `restoreState` command.