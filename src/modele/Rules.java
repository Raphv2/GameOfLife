package modele;

public abstract class Rules { 
    public abstract boolean applyRule(boolean state, int alive, Case cell);
    public abstract boolean applyRuleVanilla(boolean state, int alive);
}

class StandardRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive < 2) {
                cell.loseLife(2);
            } else if (alive > 3) {
                cell.loseLife(1);
            }
            return cell.getLife() > 0;
        } else {
            return alive == 3;
        }
    }

    @Override
    public boolean applyRuleVanilla(boolean state, int alive) {
        if (state) {
            return alive == 2 || alive == 3;
        } else {
            return alive == 3;
        }
    }
}

class HighLifeRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive == 2 || alive == 3) {
                return true;
            } else {
                cell.loseLife(1);
                return cell.isAlive();
            }
        } else {
            if (alive == 3 || alive == 6) {
                cell.gainLife(1);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean applyRuleVanilla(boolean state, int alive) {
        if (state) {
            return alive == 2 || alive == 3;
        } else {
            return alive == 3 || alive == 6;
        }
    }
}

class DayAndNightRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive == 3 || alive == 4 || alive == 6 || alive == 7 || alive == 8) {
                return true;
            } else {
                cell.loseLife(1);
                return cell.isAlive();
            }
        } else {
            if (alive == 3 || alive == 6 || alive == 7 || alive == 8) {
                cell.gainLife(1);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean applyRuleVanilla(boolean state, int alive) {
        if (state) {
            return alive == 3 || alive == 4 || alive == 6 || alive == 7 || alive == 8;
        } else {
            return alive == 3 || alive == 6 || alive == 7 || alive == 8;
        }
    }
}

class SeedsRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            cell.loseLife(1);
            return cell.isAlive();
        } else {
            if (alive == 2) {
                cell.gainLife(1);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean applyRuleVanilla(boolean state, int alive) {
        if (state) {
            return false;
        } else {
            return alive == 2;
        }
    }
}

class MazeRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive >= 1 && alive <= 5) {
                return true;
            } else {
                cell.loseLife(1);
                return cell.isAlive();
            }
        } else {
            if (alive == 3) {
                cell.gainLife(1);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean applyRuleVanilla(boolean state, int alive) {
        if (state) {
            return alive >= 1 && alive <= 5;
        } else {
            return alive == 3;
        }
    }
}

class TwoByTwoRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive == 1 || alive == 2 || alive == 5) {
                return true;
            } else {
                cell.loseLife(1);
                return cell.isAlive();
            }
        } else {
            if (alive == 3 || alive == 6) {
                cell.gainLife(1);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean applyRuleVanilla(boolean state, int alive) {
        if (state) {
            return alive == 1 || alive == 2 || alive == 5;
        } else {
            return alive == 3 || alive == 6;
        }
    }
}
