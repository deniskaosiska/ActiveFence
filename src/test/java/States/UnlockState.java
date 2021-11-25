package States;

public class UnlockState implements VaultState{
    //Defined Unlock in process state
    @Override
    public String state() {
        String State = "Unlock In progress";
        System.out.println(State);
        return State;

    }
}
