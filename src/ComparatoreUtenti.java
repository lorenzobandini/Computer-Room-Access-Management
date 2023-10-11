import java.util.Comparator;

class ComparatoreUtenti implements Comparator<Utente> {
    @Override
    public int compare(Utente p1, Utente p2) {
        // Controlla se p1 è un Professore
        if (p1 instanceof Professore) {
            // Se p2 è anche un Professore, non cambia l'ordine
            if (p2 instanceof Professore) {
                return 0;
            } else if (p2 instanceof Tesista) {
                // Se p2 è un Tesista, p1 ha la priorità
                return -1;
            } else {
                // Altrimenti, p2 è uno Studente, quindi p1 ha la massima priorità
                return -1;
            }
        } else if (p1 instanceof Tesista) {
            // Se p1 è un Tesista, ma p2 è un Professore, p2 ha la priorità
            if (p2 instanceof Professore) {
                return 1;
            } else if (p2 instanceof Tesista) {
                // Se p2 è anche un Tesista, non cambia l'ordine
                return 0;
            } else {
                // Altrimenti, p2 è uno Studente, quindi p1 ha la priorità
                return -1;
            }
        } else {
            // Se p1 è uno Studente, p2 ha la massima priorità indipendentemente dal tipo
            return 1;
        }
    }
}
