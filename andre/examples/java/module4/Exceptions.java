public class Exceptions {

    static void uncheckedDemo() {
        throw new RuntimeException(); //No try catch!
    }

    static void checkedDemo() {
        //throw new Exception(); //illegal
        try { throw new Exception(); } catch (Exception e) {/* handle */} finally { /* cleanup */}
    }
}
