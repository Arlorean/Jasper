# Jasper
Java ZX Spectrum Emulator

## Updated (23rd March 2019)

Without Changing the original source code in any way I added some classes from [Java Expert Solutions](http://www.webbasedprogramming.com/Java-Expert-Solutions/) [Chapter 13 - Running Applets as Applications](http://www.webbasedprogramming.com/Java-Expert-Solutions/ch13.htm) by Mark Wutka. These replace the [appletviewer](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html#JDK-8200146) which was removed in Java 11.

**NOTE:** This may change the license from MIT if you include those source files. I'm unsure of the license at this point.

## How to build

1. Install the [Java SE Development Kit 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html).
1. Add JDK bin directory to your PATH environment variable (e.g. *C:\Program Files\Java\jdk-11.0.2\bin*).
1. Open a shell/command prompt and navigate to the directory where the source code is extracted from github.
1. Compile all the source files using this command: 

```java *.java```

## How to run

**.sna** or **.z80** snapshot files can be loaded from the command line from the directory where the **.class** files. 
e.g. To load the **ManicMiner.z80** snapshot, use this command:

```java Main ManicMiner.z80```

![Jasper Manic Miner Screenshot](https://github.com/Arlorean/Jasper/raw/master/ManicMiner.png "Jasper Manic Miner Screenshot")

## Background

A friend of mine original wrote this emulator in 68000 assembler in order to play [Steve Davies Snooker](http://www.worldofspectrum.org/infoseekid.cgi?id=0004896) on his Atari ST back in 1988.
He then ported it to 'C'. At this point I was keen to play [Match Day](http://torinak.com/qaop#!matchday) with two players, each on their own Sun Sparcstation 1 that we used at University at the time in 1991. This was done using X-Windows windows on different displays while running the emulator as a server process updating the independent X-Displays.

Time then passed until Sun released their first version of Java in 1996 and I was hooked. I instantly started porting the 'C' code to Java and created an applet that could eventually run in a browser, if they were ever supported.
Competition is a great thing. In 1997 Netscape and Internet Explorer both released browsers with Java applet support baked in. I took a week vacation and got the emulator up and running and it was slow as anything, unplayable on by 133Mhz Pentium that I had at the time.
Shortly afterwards though the JIT compilers arrived and suddenly the applet ran in real-time (most of the time) and we decided to release it and put up a webpage.
I tried contacting the orignal firms that wrote some of the games to ask if they were OK with us putting up a snapshot of their game on our site for people to play. Contacting companies that wrote software in the 1982-1986 timeframe was VERY hard. We got some OKs but many just ignored us. In the end we put up a selection of games and waited to see what would happen.

Surprisingly we were contacted by Sun Microsystem's lawyers with a cease and desist letter because we called in "Java ZX Spectrum Emulator"! Of all the companies I thought would complain, I didn't expect Sun to be one of them as they were trying to promote Java heavily at the time. We had to change the name to Jasper (JAva SPectrum EmulatoR).

The original browser applet APIs didn't really have support for sound in the way we needed it to emulate the ZX Specturm audio correctly so we never managed to get sound support in there. 

Some other kind users have also [uploaded the source code](https://github.com/begoon/jasper) we wrote. Many thanks to them for doing that and keeping our names on the repositories.
