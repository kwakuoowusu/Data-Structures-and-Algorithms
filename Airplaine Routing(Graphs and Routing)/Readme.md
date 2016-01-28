#Airplane Router

This program allows for users to see the shortest path between two given airlines, with the use of serialization and
googles geocoder api

##General Use

Users can store aiport locations, add and remove connections between airports and shortest path between connections


##How to Use

*one file named cities.txt must be listed outside the src directory
*this will contain a list of cities to be plugged into the program

>New York

>Paris

>Beijing

>Buenos Aires

*another file, named connections .txt will be placed in the same location
*this will hold our connections between airports 

>New York,Beijing

>New York,Paris

>Beijing,Paris

From this, the program will create an object file that will be used to run a shortest path algorithm to find out the fastst way to get to a city
##Sample Output

(A) Add City
(B) Add Connection
(C) Load all Cities
(D) Load all Connections
(E) Print all Cities
(F) Print all Connections
(G) Remove Connection
(H) Find Shortest Path
(Q) Quit
Enter a selection: C

Enter the file name: cities.txt

New York has been added: (40.7127837, -74.0059413)
Paris has been added: (48.856614, 2.3522219)
Beijing has been added: (39.904211, 116.407395)
Buenos Aires has been added: (-34.6037232. -58.3815931)


Enter a selection: H

Enter source city: New York
Enter destination city: Tokyo

Shortest path from New York to Tokyo:
New York --> Beijing --> Tokyo : 1.3081489337585555E7


