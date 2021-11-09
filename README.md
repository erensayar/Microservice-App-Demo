## Development Continues... 
It is not the final state.

---


# Architecture

![Architecture](/dev-doc-file/arch-ss.png)


# Working Principle
![WorkingPrinciple](/dev-doc-file/problem-solution-pseudo.png)


---

# Requirements

Backend Requirements

* JDK 11 https://jdk.java.net/archive/ (OpenJDK)
* Maven https://maven.apache.org/download.cgi

---

Requirements Setup For GNU/Linux:
--

1.You can use package manager:

Java:

    $ sudo apt-get update \
    && sudo apt-get install openjdk-8-jdk \
    && java -version

Maven:

    $ sudo apt install maven \
    && mvn -version

2.Manuel Setup:

* Get JDK And Maven compressed files.

* Then extract.

* Give name without space to files. (Java File: OpenJDK-1.8 | Maven: Maven)

* Then move files to any where permanently.

* Last thing you should set PATH and ENVIRONMENT VARIABLE:

    * Open terminal and open .bashrc file with any editor for edit this file. (I choose gedit for this example)

            $ gedit .bashrc

    * And then add this lines.        
  
    Maven:

        export M2_HOME=/${PATH}/${MAVEN-MAIN-DIRECTORY}
        export PATH=$M2_HOME/bin:$PATH

    Java:        

        export JAVA_HOME=/${PATH}/${JAVA-MAIN-DIRECTORY}
        export PATH=$JAVA_HOME/bin:$PATH

---
