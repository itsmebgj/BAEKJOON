package src.chatgpt.boj1306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SegmentTree {
    private int[] tree;

    public SegmentTree(int size) {
        this.tree = new int[size * 4];
    }

    public void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, node * 2, start, mid);
            build(arr, node * 2 + 1, mid + 1, end);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    public int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            return 0; // 세그먼트 트리의 초기값
        }
        if (L <= start && end <= R) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftMax = query(node * 2, start, mid, L, R);
        int rightMax = query(node * 2 + 1, mid + 1, end, L, R);
        return Math.max(leftMax, rightMax);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] firstLine = br.readLine().trim().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 코스의 길이
        int M = Integer.parseInt(firstLine[1]); // 시야 범위

        int[] lights = new int[N];
        String[] lightValues = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            lights[i] = Integer.parseInt(lightValues[i]);
        }

        // 세그먼트 트리 초기화 및 구축
        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.build(lights, 1, 0, N - 1);

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (int i = M - 1; i <= N - M; i++) {
            int left = i - (M - 1);
            int right = i + (M - 1);
            int maxLight = segmentTree.query(1, 0, N - 1, left, right);
            result.append(maxLight).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
/*
홍준이는 러너이다. 그런데 어쩌다 보니 아무리 뛰어도 뛰어도 속도가 변하지 않는다. 1초에 딱 1칸을 움직인다.
그런데 홍준이가 뛰는 코스는 광고판으로 가득하다. 광고판은 빛의 세기가 다른데, 홍준이는 자신이 볼 수 있는 광고판들 중에서 가장 강렬한 빛의 광고판만이 눈에 들어온다.
홍준이는 눈이 안좋기 때문에 빛의 세기가 강한 지점에서는 안경을 쓰고 뛰려한다. 그래서 알아야 할 것이, 뛰어가면서 보이는 광고판의 빛의 세기를 알고 싶다.
홍준이가 뛰어갈 때, 1초마다 보이는 광고판의 빛의 세기를 출력하여라.

세그먼트 트리 문제
 */