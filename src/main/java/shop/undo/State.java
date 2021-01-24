package shop.undo;

public class State {
    History undo;
    History redo;

    public State(History undo, History redo) {
        this.undo = undo;
        this.redo = redo;
    }
}
