# Using SourceWithContext

## Introduction

This sample application shows how to the Akka Streams SourceWithContext
feature.

SourceWithContext allows one to split contextual information from Stream
elements and focus on the data contained in those elements. During the
business processing steps, the context is passed along in the stream in
a transparent way.

After the processing of the data is complete, it can be reunited with
its context information.

This feature comes in handy when processing data from a Kafka topic
[partition].