package States;

public class OpenState implements VaultState{
    //Defined Open state
    @Override
    public String state() {
        String State = "Open";
        System.out.println(State);
        return State;
    }
}
