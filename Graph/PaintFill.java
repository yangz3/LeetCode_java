public static boolean PaintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
    if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
        return false;
    }
    if (screen[y][x] == ocolor) {
        screen[y][x] = ncolor;
        PaintFill(screen, x - 1, y, ocolor, ncolor); // left
        PaintFill(screen, x + 1, y, ocolor, ncolor); // right
        PaintFill(screen, x, y - 1, ocolor, ncolor); // top
        PaintFill(screen, x, y + 1, ocolor, ncolor); // bottom
    }
    return true;
    }

public static boolean PaintFill(Color[][] screen, int x, int y, Color ncolor) {
    if (screen[y][x] == ncolor) return false;
    return PaintFill(screen, x, y, screen[y][x], ncolor);
}