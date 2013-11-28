java
====

Various Java programs, written for OOP at university

Compiling
---------

    make -C src all

Utility Classes
---------------

 * de.malte\_bublitz.util.ANSIConsole: Utility class for ANSI console handling

Programs
--------

 * HelloWorld: The mandatory "Hello World"
 * HelloWorld\_ANSIConsole: A Hello World using ANSIConsole
 * ForLoop: Playing around with arrays and for loops
 * ScannerDemo: Basic command line input
 * MatchStick: A simple match stick game

ANSIConsole Overview
--------------------

ANSIConsole is a small class which helps you accessing a ANSI console, supporting
basic ANSI escape codes like foreground color and underline/bold text.

    ANSIConsole
     +clear()
      Clears the screen
     +setForegroundColor(String c)
      Sets the console font color. See below for color names.
     +setAttribute(String a)
      Sets font attribute. See below for attribute names.
     +print(String text)
      Prints out some text.
     +println(String line)
      Same as print(), but appends a newline.
     +readLine(): String
      Reads a single line from the console.
     +printLine(String element, int count)
      Prints a line (e.g. for a ASCII TUI)
     +printTux()
      Prints out a sweet Tux. :3

### Color codes

    BLACK
    RED
    GREEN
    YELLOW
    BLUE
    DARK_MAGENTA
    DARK_CYAN
    GREY
    DARK_GREY
    LIGHT_RED
    LIGHT_GREEN
    LIGHT_YELLOW
    LIGHT_BLUE
    MAGENTA
    CYAN
    WHITE

### Font attributes

    BOLD
    UNDERLINE
    RESET

