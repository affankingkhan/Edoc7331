class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        String[] left = num1.split("\\+",2);
        String[] right = num2.split("\\+",2);
        
        String leftReal = left[0];
        String leftImaginary = left[1];
        String rightReal = right[0];
        String rightImaginary = right[1];
        
        
        int lReal = Integer.parseInt(leftReal);
        int rReal = Integer.parseInt(rightReal);
        
        int lImagin = Integer.parseInt(leftImaginary.substring(0,leftImaginary.length() - 1));
        int rImagin = Integer.parseInt(rightImaginary.substring(0,rightImaginary.length() - 1));
        
        
        int p1 = lReal * rReal;
        int p2 = lReal * rImagin;
        int p3 = lImagin * rReal;
        int p4 = lImagin * rImagin;
        
        int imagineNum = p2 + p3;
        int realNum = p1 + (-1) * p4;
        
        return "" + Integer.toString(realNum) + "+" + Integer.toString(imagineNum) + "i";
        
        
        
        
    }
}