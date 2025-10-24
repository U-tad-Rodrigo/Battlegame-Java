package battlegame.model.action;

import battlegame.model.Character;

public abstract class ActionDecorator implements Action {

    protected Action action;

    public ActionDecorator(Action action) {
        this.action = action;
    }

    @Override
    public abstract void execute(Character source, Character target);
    
    @Override
    public abstract String getName();
}