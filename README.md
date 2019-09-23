# assignment
Pre-requsite -
  1. Java version 8
  2. Download org.json library, Link - https://jar-download.com/artifacts/org.json.
      Note down the path.
        
  To run -
  
    1. Download the JsonReader.java file.
    2. Compile the code -
          
          javac -classpath ".:/<PROVIDE PATH TO THE JAR(Pre-requisite Step 2)>/json-20190722.jar:" JsonReader.java
          
          eg - javac -classpath ".:/Users/Downloads/json-20190722.jar:" JsonReader.java
          
    3. To run the java class - 
          cat /PROVIDE PATH Sample Json Object/sample.json | java -classpath ".:/PROVIDE PATH to the Jar downloaded/json-20190722.jar:" JsonReader
          
          eg - cat /Users/Documents/interviews/mongo/sample.json | java -classpath ".:/Users/Downloads/json-20190722.jar:" JsonReader

Notes - 

  1. There is a potential of Logger statements based on info/debug/error modes, but since we are running it in simple basic modes all of it is omitted.
