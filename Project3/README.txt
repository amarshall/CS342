CS342 Design Patterns, Spring 2012
Project 3
Author: J. Andrew Marshall <jmarsha6@binghamton.edu>,
        Kenneth Louie <klouie1@bighamton.edu>

PURPOSE: Apply the design principles and patterns you have learned so far to develop and test code for the given problem.
PERCENT COMPLETE: Completed 100% of this project.
PARTS THAT ARE NOT COMPLETE: None
BUGS: None
FILES:
    ./src/customerService/driver/Driver.java - Takes in user input. Starts gathering product information, and initiates the searches.
    ./src/customerService/product/BookProduct.java - Abstract class that defines the necessary methods for every BookProduct.
    ./src/customerService/product/BookProduct1.java - Concrete class which extends BookProduct. 
    ./src/customerService/product/BookProduct2.java - Concrete class which extends BookProduct.
    ./src/customerService/product/BookProduct3.java - Concrete class which extends BookProduct.
    ./src/customerService/product/FAQFiles.java - Enum that holds a representation of every product. Stores the file names associated to each product. Able to parse and gather information from these files.
    ./src/customerService/product/HDDProduct.java - Abstract class that defines the necessary methods for every HDDProduct.
    ./src/customerService/product/HDDProduct1.java - Concrete class which extends HDDProduct.
    ./src/customerService/product/HDDProduct2.java - Concrete class which extends HDDProduct.
    ./src/customerService/product/HDDProduct3.java - Concrete class which extends HDDProduct.
    ./src/customerService/product/OpticalDriveProduct.java - Abstract class that defines the necessary methods for every OpticalDriveProduct.
    ./src/customerService/product/OpticalDriveProduct1.java - Concrete class which extends OpticalDriveProduct.
    ./src/customerService/product/OpticalDriveProduct2.java - Concrete class which extends OpticalDriveProduct.
    ./src/customerService/product/OpticalDriveProduct3.java - Concrete class which extends OpticalDriveProduct.
    ./src/customerService/product/ProductFAQVisitor.java - Concrete visitor class which implements ProductVisitor. Implements an overloaded visit method for each distinct product.
    ./src/customerService/product/ProductVisitor.java - Interface to define necessary visit methods for visiting products
    ./src/customerService/product/SSDProduct.java - Abstract class that defines the necessary methods for every SSDProduct.
    ./src/customerService/product/SSDProduct1.java - Concrete class which extends SSDProduct.
    ./src/customerService/product/SSDProduct2.java - Concrete class which extends SSDProduct.
    ./src/customerService/product/SSDProduct3.java - Concrete class which extends SSDProduct.
    ./src/customerService/search/ExactMatchSearch.java - Concrete search class which implements SearchStrategy. Implements the search method to use the exact match algorithm.
    ./src/customerService/search/ProductSearch.java - Gives the ability to search using a specific search strategy. Uses both product info, as well as a search strategy.
    ./src/customerService/search/SearchStrategy.java - Interface to define a search method.
    ./src/customerService/search/SemanticMatchSearch.java - Concrete search class which implements SearchStrategy. Implements the search method to use the semantic algorithm.
    ./src/customerService/search/StemmerMatchSearch.java -  Concrete search class which implements SearchStrategy. Implements the search method to use the stemming algorithm.
    ./src/customerService/util/Debug.java - Contains a user defined debug level. Controls what gets printed depending on the debug level.
    ./data/book1faqs.txt - Contains faq information for BookProduct1.
    ./data/book2faqs.txt - Contains faq information for BookProduct2.
    ./data/book3faqs.txt - Contains faq information for BookProduct3.
    ./data/hdd1faqs.txt - Contains faq information for HDDProduct1.
    ./data/hdd2faqs.txt - Contains faq information for HDDProduct2.
    ./data/hdd3faqs.txt - Contains faq information for HDDProduct3.
    ./data/optical1faqs.txt - Contains faq information for OpticalDriveProduct1.
    ./data/optical2faqs.txt - Contains faq information for OpticalDriveProduct2.
    ./data/optical3faqs.txt - Contains faq information for OpticalDriveProduct3.
    ./data/ssd1faqs.txt - Contains faq information for SSDProduct1.
    ./data/ssd2faqs.txt - Contains faq information for SSDProduct2.
    ./data/ssd3faqs.txt - Contains faq information for SSDProduct3.
    ./data/synonyms.txt - Contains the synonyms used by semantic search.
    ./data/userInputs.txt - Contains the user's searches.
    ./README.txt - The text file you are presently reading
    ./build.xml - Responsible for compiling, running, and setting command line arguments for the project using ant.	
SAMPLE OUTPUT:
    prepare:
        [mkdir] Created dir: /Users/klouie/Code/CS342/Project3/build
        [mkdir] Created dir: /Users/klouie/Code/CS342/Project3/build/classes

    customerService:
        [javac] Compiling 26 source files to /Users/klouie/Code/CS342/Project3/build/classes

    compile:

    jar:
        [mkdir] Created dir: /Users/klouie/Code/CS342/Project3/build/jar
          [jar] Building jar: /Users/klouie/Code/CS342/Project3/build/jar/customerService.jar

    run:
         [java] Search results for 'problems reading a disk':
         [java]   Exact results:
         [java]     If the OpticalDriveProduct2 is having problems reading a disk, make sure the disk is not upside down
         [java]   Stemmer results:
         [java]     If the OpticalDriveProduct2 is having problems reading a disk, make sure the disk is not upside down
         [java]   Semantic results:
TO COMPILE: ant compile
TO RUN: ant run
EXTRA CREDIT: n/a
DEBUG SCHEME: Hardcoded
	0: No output should be printed (Only error messages should be printed).
	1: Only the search results should be printed.
	2: Only the search results should be printed.
	3: Only the search results should be printed.
	4: Only the search results should be printed.
BIBLIOGRAPHY: J. Andrew Marshall & Kenneth Louie
ACKNOWLEDGEMENT: n/a
