public class BHPQ<E extends Comparable<E>> {


    /*
    Priority Queue Implementation Using Resizing Array Binary Heap
    Author @LwinPhyoAung
     */

    private E[] pq;

    private int pointer;
    private int size;

    public BHPQ(){
        pq = (E[]) new Comparable[10];
        size = pq.length;
    }

    public void insert(E e){
        if (pointer+1 == size){
            resize(size * 2);
        }
        pq[++pointer] = e;
        up(pointer);
    }

    public E delMax(){

        if (pointer <= 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (pointer <= (size / 4)){
            resize(size/2);
        }
        E max = pq[1];
        swap(pq,1,pointer--);
        down(1);
        pq[pointer+1] = null;
        return max;

    }

    private void up(int C){

        while (C > 1 && less(pq[C/2], pq[C])){
            swap(pq,C/2, C);
            C /= 2;
        }

    }

    private void down(int C){

        while ((2 * C) <= pointer){
            int t = 2*C;
            if (t < pointer && less(pq[t],pq[t+1])){
                t++;
            }
            if (!less(pq[C],pq[t])){
                break;
            }
            swap(pq,C,t);
            C = t;
        }

    }

    private void resize(int capacity){

        E[] newPq = (E[]) new Comparable[capacity];
        for (int i = 0; i <= pointer; i++) {
            newPq[i] = pq[i];
        }
        pq = newPq;
        size = pq.length;

    }

    private boolean less(Comparable x,Comparable y){
        return x.compareTo(y) == -1;
    }

    private void swap(Comparable[] a,int x,int y){
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
