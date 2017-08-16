Aplying the Observer pattern:

- added the Observer interface (FrameObserver)
	- all frames inplement the interface, and override the setCount method,	
	
	
- refactored the Counter: 
	- Counter has list of FrameObserver's,
    - simplified the increment and decrement methods, 
	- added mentod notifyObservers that loops through the list of Observers and sets the updated counter.
	

