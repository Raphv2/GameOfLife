package modele;

import java.util.HashMap;
import java.util.Map;


public class DirectionOffsets {
    private static final Map<Direction, int[]> directionOffsets = new HashMap<>();

    static {
        directionOffsets.put(Direction.h, new int[]{0, 1});
        directionOffsets.put(Direction.hd, new int[]{1, 1});
        directionOffsets.put(Direction.d, new int[]{1, 0});
        directionOffsets.put(Direction.db, new int[]{1, -1});
        directionOffsets.put(Direction.b, new int[]{0, -1});
        directionOffsets.put(Direction.bg, new int[]{-1, -1});
        directionOffsets.put(Direction.g, new int[]{-1, 0});
        directionOffsets.put(Direction.gh, new int[]{-1, 1});
    }

    public static int[] getOffset(Direction direction) {
        int[] offset = directionOffsets.get(direction);
        if (offset == null) {
            throw new IllegalArgumentException("Direction inconnue : " + direction);
        }
        return offset;
    }
}