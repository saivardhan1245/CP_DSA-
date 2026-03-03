package StackQueues;

class Stack{
    final int maxsize = 8;
    private int tos;
    private int[] data ;
    public Stack(){
        data = new int[maxsize];
        tos = -1;
    }
    public void resize(){
        int[] newdata = new int[maxsize*2];
        for(int i = 0 ; i < data.length ; i++){
            newdata[i] = data[i];
        }
        data = newdata;
    }
    public void push(int val){
        if(tos==maxsize-1){
            System.out.println("resizing");
            resize();
        }else{
            data[++tos] = val;
        }

    }
    public int pop(){
        if(tos==-1){
             System.out.println("empty stack");
            return -1;
        }else{
            int val = data[tos];
            tos--;
            return val;
        }

    }
    public int size(){
        return tos+1;
    }
    public int peek(){
        if(tos==-1){
            System.out.println("empty stack");
            return -1;
        }else{
            return data[tos];
        }
    }
    @Override
    public String toString(){
        String str  ="";
        str+="[";
        for(int i= 0 ; i<=tos ; i++){
            str+= data[i] +",";
        }
        str+="]";
        return str;
    }
}
public class DynamicStack {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(45);
        st.push(50);
        st.push(60);
        st.push(40);
    }
}
