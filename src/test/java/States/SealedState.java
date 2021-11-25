package States;

public class SealedState implements VaultState{
    //Defined Sealed state
    @Override
    public String state() {
        String State = "Sealed";
        System.out.println(State);
        return State;
    }
}
