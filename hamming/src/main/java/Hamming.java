public class Hamming {

    public static Integer compute(String strand1, String strand2) {
        Integer hamming = 0;
        Integer counter = 0;
        char[] dna1 = strand1.toCharArray();
        char[] dna2 = strand2.toCharArray();

        if (strand1.length() != strand2.length()) {
            throw new IllegalArgumentException();
        }
        for (char nucleotide : dna1) {
            if (nucleotide != dna2[counter]) {
                hamming += 1;
            }
            counter += 1;
        }
        return hamming;
    }
}

