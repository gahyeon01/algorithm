package algorithm.sorting;
//삽입정렬 구현

import java.util.Arrays;

public class InsertionSort {
    static int[] nums;
    public static void main(String[] args) {
        nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        System.out.println("<정렬 전>");
        System.out.println(Arrays.toString(nums));

        for(int i = 1; i < nums.length; i++) {
            // 현재 선택된 원소의 값을 임시 변수에 저장해준다.
            int temp = nums[i];
            // 현재 원소를 기준으로 이전 원소를 탐색하기 위한 index 변수.
            int prev = i - 1;
            // 현재 선택된 원소가 이전 원소보다 작은 경우까지만 반복. 단, 0번째 원소까지만 비교한다.
            while(prev >= 0 && nums[prev] > temp) {
                // 현재 선택된 원소가 현재 탐색중인 원소보다 작다면, 해당 원소는 다음 인덱스로 미뤄버린다.
                nums[prev + 1] = nums[prev];
                // 다음 대상 원소를 탐색한다.
                prev--;
            }
            // 탐색이 종료된 지점에 현재 선택되었던 변수의 값을 삽입해준다.
            nums[prev + 1] = temp;
        }

        System.out.println("<정렬 후>");
        System.out.println(Arrays.toString(nums));
    }
    /*참고자료
    * https://sskl660.tistory.com/81*/
}
