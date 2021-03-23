# Akka Streams with Scala - Advanced

## Description

This repository contains the so-called _Course Management Tools master_ for
the Advanced Akka Streams training course.

In order to step through the course as a student, a student ready artefact needs
to be generated from this master repository using the `cmt-studentify` command.

Follow the following steps to do this

- If not already installed, install the Course Management Tools (CMT) from [here](https://github.com/eloots/course-management-tools). Note that there is a [CMT documentation site](https://eloots.github.io/course-management-tools/) too.

- Clone this course repo on your system and change your current directory into 
  [any folder in] the cloned repo.

- Generate the studentified artefact by running `cmt-studentify -dot . <some folder>`.
  After the command completes, `<some folder>` will have a new folder named `lunatech-akka-streams-with-scala`.

- cd into that folder, launch sbt and enjoy!

## System prerequisites

Your system should have `sbt` installed and a JDK, preferably Java 11 or higher
Even though the studentified artefact can be used on different sysems (Mac, *nix, Windows 10), the
studentification process is not supported on Windows (unless you run the process under WSL 2).