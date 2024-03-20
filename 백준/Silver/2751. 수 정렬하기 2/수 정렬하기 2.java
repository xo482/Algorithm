import java.io.*;

public class Main {

    static int[] list;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        list = new int[size];
        temp = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0,size-1);

        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void mergeSort(int start, int end) {
        int mid = 0;
        if (end - start > 0) {
            mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            int point = start;
            int left = start;
            int right = mid+1;

            while (left <= mid && right <= end) {
                if (list[left] < list[right]) temp[point++] = list[left++];
                else temp[point++] = list[right++];
            }

            if (left <= mid)
                while(left <= mid)
                    temp[point++] = list[left++];
            if (right <= end)
                while(right <= end)
                    temp[point++] = list[right++];

            for (int i=start;i<=end;i++) {
                list[i]=temp[i];
            }
        }
    }
}