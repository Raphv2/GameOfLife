package modele;

public abstract class Rules { 
    public abstract boolean applyRule(boolean state, int alive);
}

class StandardRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive) {
        if (state) {
            return alive == 2 || alive == 3; 
        } else {
            return alive == 3; 
        }
    }
}

class HighLifeRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive) {
        if (state) {
            return alive == 2 || alive == 3; 
        } else {
            return alive == 3 || alive == 6; 
        }
    }
}

class DayAndNightRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive) {
        if (state) {
            return alive == 3 || alive == 4 || alive == 6 || alive == 7 || alive == 8; 
        } else {
            return alive == 3 || alive == 6 || alive == 7 || alive == 8; 
        }
    }
}


class SeedsRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive) {
        if (state) {
            return false; 
        } else {
            return alive == 2; 
        }
    }
}

class MazeRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive) {
        if (state) {
            return alive >= 1 && alive <= 5; 
        } else {
            return alive == 3; 
        }
    }
}

class TwoByTwoRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive) {
        if (state) {
            return alive == 1 || alive == 2 || alive == 5;
        } else {
            return alive == 3 || alive == 6; 
        }
    }
}