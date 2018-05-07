Author: Markus Andersson


## Welcome to my A* and Jump point search program!



With this program you can import maps and have either A* or JPS solve them and show a visual representation of their suggested path. 



### **HOW TO RUN THE PROGRAM:**

Open a terminal and navigate to the folder where the A\*JPS.jar file is located. Then type the following command:

"java -jar A*JPS.jar" (without the apostrophes of course).



### **HOW TO USE THE PROGRAM:**
When you start the program the following is shown:

```
Which map would you like to use?

Default maps:

For 'test.map' press 1
For 'test2.map' press 2
For 'test3.map' press 3
For 'test4.map' press 4
If you wish to use your own custom map, press 5
```

If you want to use one of the default maps, simply type "1", "2", "3" or "4".

If you want to use your own custom map, type "5".
<ul>
You are then asked to type in the file name for the map. If we want to use the map "example.map", we cannot simply type "example", you have to type the entire name 	with ".map". So type your file name as: "example.map".
<p></p>
You are then asked to give the x and y coordinates for the start and end nodes. If the start node we want to use has the following coordinates: x=5 and y=4, type 		"5" when asked for the x coordinate and then type "4" when asked for the y coordinate. The same goes for the end node. If something goes wrong a error message is displayed telling you what went wrong.
</ul>

You are then asked if you want to use A* or JPS. For A* simply type "1" and for JPS type "2". After hitting enter you can sit back and enjoy the visual representation! :D

When the representation is finished the entire path as nodes are shown and how many steps it took. 
The time it took for the algorithm to calculate the path is also shown.



### **USING CUSTOM MAPS:**
Move your custom map to the Maps folder and you're done!

The idea of using ".map" file format came from the excellent website: "http://www.movingai.com/benchmarks/". 

The format is explained at: "http://www.movingai.com/benchmarks/formats.html" 

Download maps from there or try creating your own!
