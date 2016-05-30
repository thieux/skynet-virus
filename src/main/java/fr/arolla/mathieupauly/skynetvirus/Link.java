package fr.arolla.mathieupauly.skynetvirus;

class Link {
    static final Link NONE = new Link(-1, -1);

    final int n1;
    final int n2;

    Link(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
