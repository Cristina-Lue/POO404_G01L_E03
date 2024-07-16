package Switch;

public class Switch1 {
    public static void main(String[] args) {
        int a = 8;
        int b = 1;
        char op = '+';// Puede cambiar el operador aritmético...
        System.out.print("El resultado es : ");
        switch ( op ) {
            case '+':
                System.out.println( a + b );
                break;
            case '-':
                System.out.println( a - b );
                break;
            case '*':
                System.out.println( a * b );
                break;
            case '/':
                System.out.println( a / b );
                break;
            default:
                System.out.println("error" );
                break;
        }
    }
}
