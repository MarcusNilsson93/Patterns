package shop.undo;

import java.util.Stack;

public class HistoryStack {
    static Stack<State> redoStack = new Stack<>();
    static Stack<State> undoStack = new Stack<>();

    public void undo(){
        if(undoStack.size() > 0){
            redoStack.push(undoStack.peek());
            undoStack.pop().undo.execute();
        }
    }

    public void redo(){
        if(redoStack.size() > 0) {
            undoStack.push(redoStack.peek());
            redoStack.pop().redo.execute();
        }
    }

    public static void addState(State state){
        undoStack.push(state);
        redoStack.clear();
    }

}
