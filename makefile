JC = javac
JFLAGS = -g
PACKAGE = histogram/
.SUFFIXES: .class .java
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
  $(PACKAGE)Histogram.java \
	$(PACKAGE)Runner.java

default: classes run

run: 
	java $(PACKAGE)Runner

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(PACKAGE)*.class
	$(RM) output.txt

