package modele;

public abstract class Rules { 
    public abstract boolean applyRule(boolean state, int alive, Case cell);
}

class StandardRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            // Exemple de perte de vie indépendante
            if (alive < 2) {
                cell.loseLife(2); // Perd 2 vies
            } else if (alive > 3) {
                cell.loseLife(1); // Perd 1 vie
            }
            return cell.getLife() > 0; // Meurt si la vie atteint 0
        } else {
            if (alive == 3) {
                return true;
            } else {
                return false; // Reste morte
            }
        }
    }
}


class HighLifeRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive == 2 || alive == 3) {
                return true; // Survit
            } else {
                cell.loseLife(1); // Perd 1 vie
                return cell.isAlive(); // Meurt si la vie atteint 0
            }
        } else {
            if (alive == 3 || alive == 6) {
                cell.gainLife(1); // Devient vivante et gagne 1 vie
                return true;
            } else {
                return false; // Reste morte
            }
        }
    }
}

class DayAndNightRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive == 3 || alive == 4 || alive == 6 || alive == 7 || alive == 8) {
                return true; // Survit
            } else {
                cell.loseLife(1); // Perd 1 vie
                return cell.isAlive(); // Meurt si la vie atteint 0
            }
        } else {
            if (alive == 3 || alive == 6 || alive == 7 || alive == 8) {
                cell.gainLife(1); // Devient vivante et gagne 1 vie
                return true;
            } else {
                return false; // Reste morte
            }
        }
    }
}

class SeedsRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            cell.loseLife(1); // Perd 1 vie
            return cell.isAlive(); // Meurt si la vie atteint 0
        } else {
            if (alive == 2) {
                cell.gainLife(1); // Devient vivante et gagne 1 vie
                return true;
            } else {
                return false; // Reste morte
            }
        }
    }
}

class MazeRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive >= 1 && alive <= 5) {
                return true; // Survit
            } else {
                cell.loseLife(1); // Perd 1 vie
                return cell.isAlive(); // Meurt si la vie atteint 0
            }
        } else {
            if (alive == 3) {
                cell.gainLife(1); // Devient vivante et gagne 1 vie
                return true;
            } else {
                return false; // Reste morte
            }
        }
    }
}

class TwoByTwoRules extends Rules {
    @Override
    public boolean applyRule(boolean state, int alive, Case cell) {
        if (state) {
            if (alive == 1 || alive == 2 || alive == 5) {
                return true; // Survit
            } else {
                cell.loseLife(1); // Perd 1 vie
                return cell.isAlive();// Meurt si la vie atteint 0
            }
        } else {
            if (alive == 3 || alive == 6) {
                cell.gainLife(1); // Devient vivante et gagne 1 vie
                return true;
            } else {
                return false; // Reste morte
            }
        }
    }
}
