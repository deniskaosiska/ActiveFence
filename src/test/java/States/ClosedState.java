package States;

public class ClosedState implements VaultState{
    //Defined Closed state
    @Override
    public String state() {
        String State = "Close";
        System.out.println(State);
        return State;
    }
}
