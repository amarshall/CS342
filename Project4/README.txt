CS342 Design Patterns, Spring 2012
Project 4
Author: J. Andrew Marshall <jmarsha6@binghamton.edu>,
        Kenneth Louie <klouie1@bighamton.edu>

PURPOSE: Apply the design principles and patterns you have learned so far to develop and test code for the given problem.
PERCENT COMPLETE: 100%
PARTS THAT ARE NOT COMPLETE: None
BUGS: None
FILES:
  ./src/taskManager/data/Process.java - Stores the information of a Process.
  ./src/taskManager/data/Performance.java - Stores the information of a Performance readout.
  ./src/taskManager/data/User.java - Stores the information of a User.
  ./src/taskManager/tabs/UsersTab.java - Implements Tab. Stores a list of Users. Is a listener to the TaskManager, but a subject to the Display.
  ./src/taskManager/tabs/ProcessesTab.java - Implements Tab. Stores a list of Processes. Is a listener to the TaskManager, but a subject to the Display.
  ./src/taskManager/tabs/Tab.java - Tab interface definning all the methods required for a Tab.
  ./src/taskManager/tabs/PerformanceTab.java - Implements Tab. Stores a list of Performances. Is a listener to TaskManager, but a subject to Displays.
  ./src/taskManager/driver/Driver.java - Initiates the program.
  ./src/taskManager/display/StdoutDisplay.java - Implements Display. Is a listener to each Tab. Prints the information when updated.
  ./src/taskManager/display/Display.java - Display interface definning all the methods required for a Display.
  ./src/taskManager/TaskManager.java - Reads input and sorts it based on Process,Peformance,User. Then updates each Tab accordingly.
  ./data/input.txt - Stores all the computer information
  ./README.txt - The file you are reading now.
  ./build.xml - Compile and runs the program using Ant.
INPUT FORMAT:
  process:name,owner,cpu,mem,description
  system:mem,cpu,totalMem,totalCached
  user:name,status
SAMPLE OUTPUT:
  [java] Process 'dSeagateSupport' | Owner: 'Kenny' | CpuUsage: '10.0' | MemoryUsage: '100.0' | Description: 'description'
  [java] Process 'dTunes' | Owner: 'Andrew' | CpuUsage: '14.0' | MemoryUsage: '130.0' | Description: 'description'
  [java] Process 'mapreduce' | Owner: 'Madhu' | CpuUsage: '100.0' | MemoryUsage: '110.0' | Description: 'description'
  [java] Process 'name' | Owner: 'owner' | CpuUsage: '14.0' | MemoryUsage: '140.0' | Description: 'description'
  [java] Process 'name' | Owner: 'owner' | CpuUsage: '12.0' | MemoryUsage: '160.0' | Description: 'description'
  [java] MemoryUsage: '100.0' | CpuUsage: '42.0' | Total Memory '10000.0' | Total Cached: '402.0'
  [java] MemoryUsage: '120.0' | CpuUsage: '12.0' | Total Memory '10000.0' | Total Cached: '402.0'
  [java] MemoryUsage: '1000.0' | CpuUsage: '81.0' | Total Memory '10000.0' | Total Cached: '631.0'
  [java] MemoryUsage: '87.0' | CpuUsage: '12.0' | Total Memory '10000.0' | Total Cached: '888.0'
  [java] User Name: 'Kenny' | Status: 'admin'
  [java] User Name: 'Andrew' | Status: 'admin'
  [java] User Name: 'Bob' | Status: 'cool'
  [java] User Name: 'Evan' | Status: 'visitor'
TO COMPILE: ant compile
TO RUN: ant run
DEBUG SCHEME: Hardcoded
	0: No output should be printed (Only error messages should be printed).
	1: Only the results should be printed.
	2: Only the results should be printed.
	3: Only the results should be printed.
	4: Only the results should be printed.
EXTRA CREDIT: n/a
BIBLIOGRAPHY: J. Andrew Marshall & Kenneth Louie
ACKNOWLEDGEMENT: n/a
