# JRasterCreator, a tool to easily create raster file for mass spectrometry

## Introduction

On some mass spectrometry (MS) instruments, you can specify the location where the laser will hit your sample. On the Bruker Daltonics MS ultraflex II, there is no accompanying software to specify these locations. But you can manually edit your .raster files. On one side, it's very easy: it's only a text/xml file (see example in sampledata/) and you can get help with a grid (see example in screenshots/). On the other hand, it can become a tedious, error-prone task if you have to specify 100 locations by hand.

The goal of JRasterCreator is to allow you to easily & visually build a raster file by clicking on various spots/locations.

Please note that I am not working with MS (mass spectrometry) at all. I did this software to help some colleagues/friends in my university MS lab. I am dependent on their comments in order to improve the software and/or correct bugs. Of course, if you use this software in another lab, I'll be glad to hear from you and to receive your suggestions/bugs/... Feel free to contact me.

## Features:

* Works with an ultraflex II (not tested with other MS devices)
* Displays a grid of specified locations, from (-1.0, 1.0) on the upper left corner to (1.0, -1.0) on the lower right corner; see the grid (in screenshots/) for more details
* Allows you to click on locations where you want the MS laser to hit your sample: a red spot means a location where the laser will hit (click once more to de-select a location)
* Shows green circle where locations coordinates are in [-0.5 0.5] in X and Y
* Allows you to save your "artwork" (via the menu or Ctrl + S)
* You can run this software under MS-Windows, MacOS and GNU/Linux, provided you have the Java Runtime Engine, version 6 and above.

These keyboard shortcuts allows you to become more productive:

* Ctrl + S = save your current artwork
* Ctrl + Q = quit JRasterCreator
* Ctrl + A = show the About box (not really for productivity)

# Screenshot

In the screenshots/ directory

## Software

Download the latest version of JRasterCreator in the bin/ or src/ directories.

The JAR file is the software you'll use. You can run this software under MS-Windows, MacOS and GNU/Linux, provided you have the Java Runtime Engine, version 6 and above. You can download it for free and install it.

This software is released under the GNU General Public Licence (GPL): Java source code is in src/.

Copyright (C) belongs to Jean-Etienne Poirrier, 2006-2016. You can contact me at jepoirrier at gmail.com. Please report if you have any problem, comment or if you would like new features in this software.

## Usage

The software is so simple that there should be no problem to use it ... You can launch JRasterCreator by double-clicking on the rasterCreator.jar file (you can also enter this command in a shell: "java -jar rasterCreator.jar"). Then, simply click on white circles to define locations where the laser will hit your sample; the circle is then filled with red. Click again to de-select specific spots.

Once your are proud of your "artwork", click on the File menu and choose the Save option (or hit Ctrl + S on your keyboard), select a location and a filename (ending with .raster). That's it!

On the screenshot above, I just selected a cross in the middle of the zone. It will give this kind of .raster file (example.raster, 1ko):

```
<measuringraster name="example" date="2006-12-30T01:30:44" creator="jrc" version="1.0">
	<pos x="-0.400000" y="0.400000"/>
	<pos x="0.500000" y="0.400000"/>
	<pos x="-0.300000" y="0.300000"/>
	<pos x="0.400000" y="0.300000"/>
	<pos x="-0.200000" y="0.200000"/>
	<pos x="0.300000" y="0.200000"/>
	<pos x="-0.100000" y="0.100000"/>
	<pos x="0.200000" y="0.100000"/>
	<pos x="-0.000000" y="0.000000"/>
	<pos x="0.100000" y="0.000000"/>
	<pos x="-0.000000" y="-0.100000"/>
	<pos x="0.100000" y="-0.100000"/>
	<pos x="-0.100000" y="-0.200000"/>
	<pos x="0.200000" y="-0.200000"/>
	<pos x="-0.200000" y="-0.300000"/>
	<pos x="0.300000" y="-0.300000"/>
	<pos x="-0.300000" y="-0.400000"/>
	<pos x="0.400000" y="-0.400000"/>
	<pos x="-0.400000" y="-0.500000"/>
	<pos x="0.500000" y="-0.500000"/>
</measuringraster>
```

## Improvements

There are some improvements that could be implemented:

* the grid can show a circle instead of a square in the middle of the field (since the physical field is round
* when you save the file, you need to change the filter to "all the files" before being able to change directory (don't forget to put back the filter to "raster file" after)
* I could write a procedure to load an existing raster file

If you really want these improvements, please let me know.
