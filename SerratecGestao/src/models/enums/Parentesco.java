package models.enums;

public enum Parentesco {
    FILHO, SOBRINHO, OUTROS;

    public static Parentesco fromString(String s) {
        if (s == null) return OUTROS;
        s = s.trim().toUpperCase();
        switch (s) {
            case "FILHO": return FILHO;
            case "SOBRINHO": return SOBRINHO;
            default: return OUTROS;
        }
    }
}