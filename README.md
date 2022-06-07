# Akka Streams with Scala - Advanced

## Description

This repository contains the so-called _Course Management Tools master_ for
the Advanced Akka Streams training course.

In order to step through the course as a student, a student ready artefact needs
to be generated from this master repository using the `cmta` command.

Follow the following steps to do this

- If not already installed, install the Course Management Tools (CMT) from
[here](https://github.com/eloots/course-management-tools). Note that there
is a [CMT documentation site](https://eloots.github.io/course-management-tools/) too.

- Clone this course repo on your system and change your current directory into 
  [any folder in] the cloned repo.

- Generate the studentified artefact by running `cmta studentify -f . <some folder>`.
  After the command completes, `<some folder>` will have a new folder nameds
  `lunatech-akka-streams-with-scala`.

- cd into  `<some folder>/lunatech-akka-streams-with-scala/code`, launch sbt and enjoy!

In general, you will use run through consecutive exercises, by moving to the next
exercise and pull the solution for that exercise. You can to do by issuing the following
commands from the command line:

`cmtc next-exercise <some folder>/lunatech-akka-streams-with-scala`
`cmtc pull-solution <some folder>/lunatech-akka-streams-with-scala`

Note that the last argument passed to these `cmtc` commands are the root folder of
the studentified artifact.

The list of all the available exercises can be obtained by issuing the following command:

`cmtc list-exercises <some folder>/lunatech-akka-streams-with-scala`

For this repository, this gives the following result:

```bash
$ cmtc list-exercises ..
  1.      step_000_using_sourceWithContext
  2.      step_001_flow_from_source_and_sink
  3.      step_002_using_stateful_streams
  4.      step_003_using_substreams
  5.      step_004_using_scan
  6.      step_005_implement_a_delay_element
  7.      step_006_implement_fir_manually
  8.      step_007_implement_fir_streamlined
  9.      step_008_implement_iir_set_stage
 10.      step_009_implement_iir
 11.      step_010_chain_fir_and_fir
 12.  *   step_011_chain_iir_and_fir_cancel_echo
 13.      step_012_check_diff
 14.      step_013_vco
 15.      step_014_matching_streams_speeds
```
It is also possible to jump to an arbitrary exercise by using the `cmtc goto-exercise`
command. For example, to jump to exercise 11 and pull the solution for that exercise,
execute the following commands:

`cmtc goto-exercise step_011_chain_iir_and_fir_cancel_echo <some folder>/lunatech-akka-streams-with-scala`
`cmtc pull-solution <some folder>/lunatech-akka-streams-with-scala`

## System prerequisites

Your system should have `sbt` installed and a JDK, preferably Java 11 or higher.
