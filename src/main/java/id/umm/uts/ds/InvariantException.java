package id.umm.uts.ds;

/**
 * Dilempar oleh validateInvariant() jika keadaan internal struktur data
 * tidak konsisten (mis. size negatif, elemen null di tengah, tail salah).
 */
public class InvariantException extends RuntimeException {
    public InvariantException(String message) {
        super(message);
    }
}