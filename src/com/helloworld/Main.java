import java.util.Scanner;

class Quiz {
    private String soal;
    private String jawab;
    public Quiz(String soal, String jawab) {
        this.soal = soal;
        this.jawab = jawab;
    }
    public boolean cocokanJawaban(String jawab) {
        return this.jawab.equalsIgnoreCase(jawab);
    }
    public String getJawab() {
        return jawab;
    }
    public String getSoal() {
        return soal;
    }
}

class Soal {
    int kesempatan;
    String jawab;
    int score;
    int soalKe;
    int bykSoal;
    String j;
    Soal() { start(); }
    public void setJawab(String jawab) { this.jawab = jawab; }
    private Quiz quiz[] = {
            new Quiz("Berapakah 1 + 1: ", "2"),
            new Quiz("Berapakah 5 x 20: ", "100"),
            new Quiz("Berapakah 9 x 12: ", "108"),
            new Quiz("Berapakah 7 x 7 x 7: ", "343"),
            new Quiz("Berapakah 3 x 5 x 9: ", "135")
    };
    public void start() {
        kesempatan = 2;
        score = 0;
        soalKe = 0;
        bykSoal = quiz.length;
    }
    public int getBykSoal() { return bykSoal; }
    public int getKesempatan() { return kesempatan; }
    public String getSoal() {
        return quiz[soalKe].getSoal();
    }
    public int getScore() { return score; }
    public int getSoalKe() { return soalKe; }
    public String cekJawaban() {
        j = "";
        if (quiz[soalKe].cocokanJawaban(jawab)) {   // if true (boolean)
            score++;
            soalBerikut();
            j = "benar";
            return "Benar..!";
        } else {
            if (kesempatan == 0) {
                j = "over";
                return "===Game over===";
            } else {
                kesempatan--;
                j = "salah";
                return "Salah..! Silahkan menjawab lagi..";
            }
        }
    }
    private void soalBerikut() { soalKe++; }
    public String getJ() { return j; }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Soal soal = new Soal();
        int banyakSoal = soal.getBykSoal();

        System.out.println("Silahkan jawab beberapa Quiz dibawah ini!");
        System.out.println("Anda hanya punya 2x kesempatan!");
        do {
            System.out.println("\nKesempatan (" + soal.getKesempatan() + ")");
            System.out.println("SOAL KE - " + (soal.getSoalKe() + 1));
            System.out.println("Score: " + soal.getScore());
            System.out.println(soal.getSoal());
            soal.setJawab(input.nextLine().toString());
            System.out.println(soal.cekJawaban());
            System.out.println("");
            if (soal.getJ().equalsIgnoreCase("benar")) { banyakSoal--; }
            if (soal.getJ().equalsIgnoreCase("over")) { break; }
        } while (banyakSoal != 0);

        System.out.println("Score akhir: " + soal.getScore());
        if (soal.getKesempatan() == 2) {
            System.out.println("Perfect!");
        } else if ((soal.getKesempatan() == 0) && (soal.getScore() == 5)) {
            System.out.println("Berakhir dengan keberuntungan, he3..");
        } else if (soal.getJ().equalsIgnoreCase("over")) {
            System.out.println("Anda harus berlatih berhitung..");
        }
    }
}