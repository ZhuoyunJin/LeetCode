
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int back=A.length-1;
        int res=0;
        for(int i=0;i<=back;i++){
        	if(A[i]==elem){
        		while(A[back]==elem && i<back){
        			back--;
        		}
        		if(i!=back) {
        			res++;
        			A[i]=A[back];
        			back--;
        		}else{
        			return res;
        		}
        	}else{
        		res++;
        	}
        }
        return res;
    }
    
    public void print(int[] A){
    	for(int i:A)
    		System.out.println(i);
    }
}
