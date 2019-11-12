package Bit;

public class ReverseBits {
    public int reverseBits(int n) {
        int retVal=0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                retVal++;
            }
            retVal = retVal<<1;
        }
        return retVal;
    }
}
