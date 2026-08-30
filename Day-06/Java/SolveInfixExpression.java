import java.util.*;

class SolveInfixExpression{
    static int p(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    static void calc(Stack<String> st) {
        int b = Integer.parseInt(st.pop());
        char op = st.pop().charAt(0);
        int a = Integer.parseInt(st.pop());

        int r = 0;
        if (op == '+') r = a + b;
        if (op == '-') r = a - b;
        if (op == '*') r = a * b;
        if (op == '/') r = a / b;

        st.push("" + r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                st.push("" + n);
            }
            else if (c == '(') {
                st.push("(");
            }
            else if (c == ')') {
                while (!st.peek().equals("("))
                    calc(st);
                st.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!st.empty() && !st.peek().equals("(") &&
                       p(st.peek().charAt(0)) >= p(c))
                    calc(st);

                st.push("" + c);
            }
        }

        while (st.size() > 1)
            calc(st);

        System.out.println(st.pop());
    }
}
