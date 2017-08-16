package subject;

import java.util.ArrayList;
import java.util.List;

import interfaceObserver.FrameObserver;
//Subject
public class CounterSubject
{
    private List<FrameObserver> observerList;
    private int count;

    public CounterSubject (){
        observerList = new ArrayList<>();
        count = 0;
    }

    public void addObserver(FrameObserver fo) {
        observerList.add(fo);
    }
    
    public void increment(){
        count++;
        notifyObservers();
    }
    
    public void decrement(){
        if (count >0){
            count--;
        }
        notifyObservers();
    }

    private void notifyObservers() {
        for ( FrameObserver fo : observerList) {
            fo.setCount(this.count);
        }
    }
}