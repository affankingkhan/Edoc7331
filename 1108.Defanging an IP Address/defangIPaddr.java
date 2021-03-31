class Solution {
    public String defangIPaddr(String address) {
        String ret = "";
        for(int i=0; i<address.length();i++){
            if(address.charAt(i) == '.'){
                ret += "[.]";
            }else{
                ret += address.charAt(i);
            }
        }
        return ret;
    }
}