package algorithm.sorting;
//퀵정렬 구현
//이 알고리즘에는 재귀함수 요소가 들어가기 때문에 이해가 확실히 필요하다고 생각됨.

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,3,4,1,5,2};

        quick_sort(arr,0,arr.length-1);
        //정렬 후
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" "); //1 2 3 4 5 6
        }
    }

    public static void quick_sort(int A[], int start, int end) { // A[start..end]을 오름차순 정렬한다.
        //start=end가 되면 종료 - 부분배열의 크기가 1이 될 때
        if (start >= end) return;

        //분할 후 정렬
        //부분배열 정렬 종료시 start가 part가 됨
        int part = partition(A,start,end);
        quick_sort(A, start, part-1); //왼쪽 영역
        quick_sort(A, part, end); //오른쪽 영역
    }

    //분할한 영역 정렬
    public static int partition(int A[],int start,int end) {
        int pivot = A[(start+end)/2]; //가운데를 피벗으로

        while(start<=end) { //start==end면 부분배열 정렬 종료
            while(A[start]<pivot) start++;
            while(pivot<A[end]) end--;

            //자리 교환
            if(start<=end) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }
        }

        return start;

    }
    //참고자료
    //https://chobo24.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%80%B5-%EC%A0%95%EB%A0%ACQuick-Sort-JAVA%EC%9E%90%EB%B0%94
}
