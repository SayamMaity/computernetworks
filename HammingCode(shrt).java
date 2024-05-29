import java.util.Scanner;

public class HammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data to be transmitted: ");
        String data = sc.next();
        int m = data.length();
        StringBuilder rd = new StringBuilder(data).reverse();
        
        int r = 0, power = 1;
        while (power < (m + r + 1)) {
            r++;
            power *= 2;
        }
        
        StringBuilder msg = new StringBuilder();
        int curr = 0;
        for (int i = 1; i <= m + r; i++) {
            msg.append((i & (i - 1)) != 0 ? rd.charAt(curr++) : 'n');
        }

        for (int i = 1; i <= m + r; i *= 2) {
            int count = 0;
            for (int j = i + 1; j <= m + r; j++) {
                if ((j & i) != 0 && msg.charAt(j - 1) == '1') count++;
            }
            msg.setCharAt(i - 1, (count & 1) != 0 ? '1' : '0');
        }
        
        System.out.println("The data to be sent: ");
        System.out.println(msg.reverse().toString().replaceAll("", " ").trim());
        msg.reverse();
        
        System.out.print("Enter the position to introduce an error: ");
        int ep = sc.nextInt();
        if (ep >= 1 && ep <= m + r) {
            msg.setCharAt(ep - 1, msg.charAt(ep - 1) == '0' ? '1' : '0');
            System.out.println("Error introduced at position " + ep);
            System.out.println(msg.reverse().toString().replaceAll("", " ").trim());
            msg.reverse();
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1, bit = 0; i <= m + r; i *= 2, bit++) {
            int count = 0;
            for (int j = i + 1; j <= m + r; j++) {
                if ((j & i) != 0 && msg.charAt(j - 1) == '1') count++;
            }
            ans.append(((count & 1) != 0) ^ (msg.charAt(i - 1) == '1') ? '1' : '0');
        }
        
        int error = Integer.parseInt(ans.reverse().toString(), 2);
        if (error != 0) {
            System.out.println("Error detected in bit: " + error);
            msg.setCharAt(error - 1, msg.charAt(error - 1) == '0' ? '1' : '0');
            System.out.println("Error is corrected");
        }
        
        System.out.println("Corrected data: ");
        System.out.println(msg.reverse().toString().replaceAll("", " ").trim());
    }
}
