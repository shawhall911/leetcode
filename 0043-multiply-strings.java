class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
            
        int n1 = num1.length();
        int n2 = num2.length();
        int k = n1 + n2 - 2;
        int[] prod = new int[n1 + n2];    
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                 prod[k - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            
        k++;
        int carry = 0;
        String res = "";
        for (int i = 0; i <= k; i++) {
            prod[i] += carry;
            carry = prod[i] / 10;
            prod[i] %= 10;
            if (i < k || prod[i] != 0) res = String.valueOf(prod[i]) + res;
        }
        
        return res;
    }
}
